import benchmark.Benchmark;
import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.*;
import javax.management.openmbean.CompositeData;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 -agentlib:jdwp=transport=dt_socket,address=14000,server=y,suspend=n
 -Xms512m
 -Xmx512m
 -XX:MaxMetaspaceSize=256m
 -XX:+UseConcMarkSweepGC
 -XX:+CMSParallelRemarkEnabled
 -XX:+UseCMSInitiatingOccupancyOnly
 -XX:CMSInitiatingOccupancyFraction=50
 -XX:+ScavengeBeforeFullGC
 -XX:+CMSScavengeBeforeRemark
 -XX:+UseParNewGC
 -verbose:gc
 -Xloggc:./logs/gc_pid_%p.log
 -XX:+PrintGCDateStamps
 -XX:+PrintGCDetails
 -XX:+UseGCLogFileRotation
 -XX:NumberOfGCLogFiles=10
 -XX:GCLogFileSize=1M
 -Dcom.sun.management.jmxremote.port=15000
 -Dcom.sun.management.jmxremote.authenticate=false
 -Dcom.sun.management.jmxremote.ssl=false
 -XX:+HeapDumpOnOutOfMemoryError
 -XX:HeapDumpPath=./dumps/
 -XX:OnOutOfMemoryError="kill -3 %p"
 jinfo -- list VM parameters
 jhat / jvisualvm -- analyze heap dump
 */
public class Main
{
    private static Map<String, Long> youngGc = new HashMap<>();
    private static Map<String, Long> oldGc = new HashMap<>();
    private static long youngGcCollections = 0;
    private static long oldGcCollections = 0;

    public static void main(String[] args) throws NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, MalformedObjectNameException, InterruptedException
    {
        System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());

        installGCMonitoring();

        Benchmark benchmark = new Benchmark();
        //Знаю, что нехорошо отлавливать error, но ничего лучше не придумал)
        //Количество сборок молодого поколения подсчитывает точно
        //Количество сборок старого поколения отличается в логах, jconsole, и с тем что я вывожу
        //в одном из запусков вышло 75 в логах, 70 в консоле, 77 в моих подсчетах, думаю не сильно критично
        try
        {
            benchmark.run();
        } catch (Error error)
        {
            System.out.println();
            System.out.println("minutes and time(ms) in minute for young gc");
            System.out.println(youngGc.toString());
            System.out.println("minutes and time(ms) in minute for old gc");
            System.out.println(oldGc.toString());
            System.out.println("Young gc collections " + youngGcCollections);
            System.out.println("Old gc collections " + oldGcCollections);
            System.out.println();
        }

    }

    private static void installGCMonitoring()
    {
        List<GarbageCollectorMXBean> gcbeans = java.lang.management.ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcbean : gcbeans)
        {
            NotificationEmitter emitter = (NotificationEmitter) gcbean;
            System.out.println(gcbean.getName());

            NotificationListener listener = (notification, handback) ->
            {
                if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION))
                {
                    GarbageCollectionNotificationInfo info = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());

                    long duration = info.getGcInfo().getDuration();
                    String gctype = info.getGcAction();

                    LocalDateTime time = LocalDateTime.now();
                    int minutes = time.getMinute();
                    int hours = time.getHour();
                    String finalTime = hours + ":" + minutes;
                    if (info.getGcName().equals("ParNew"))
                    {
                        if (youngGc.containsKey(finalTime)) youngGc.put(finalTime, youngGc.get(finalTime) + duration);
                        else youngGc.put(finalTime, duration);
                        youngGcCollections = info.getGcInfo().getId();
                    } else
                    {
                        if (oldGc.containsKey(finalTime)) oldGc.put(finalTime, oldGc.get(finalTime) + duration);
                        else oldGc.put(finalTime, duration);
                        oldGcCollections = info.getGcInfo().getId();
                    }
                    /*
                    System.out.println(gctype + ": - "
                            + info.getGcInfo().getId() + ", "
                            + info.getGcName()
                            + " (from " + info.getGcCause() + ") " + duration + " milliseconds");
                    */
                }
            };

            emitter.addNotificationListener(listener, null, null);
        }
    }
}
