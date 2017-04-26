package list;

import java.util.*;

public class MyArrayList<T> implements List<T>
{
    private T[] array;
    private int size;
    private int capacity;

    public MyArrayList()
    {
        capacity = 10;
        array = (T[]) new Object[capacity];
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
         throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator()
    {
        return new MyListIterator();
    }

    @Override
    public Object[] toArray()
    {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a)
    {
        return (T1[]) Arrays.copyOf(array, size);
    }

    @Override
    public boolean add(T t)
    {
        reallocation(size, capacity);
        array[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        int oldSize = size;
        for (T element : c)
        {
            this.add(element);
        }
        return size == oldSize + c.size();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public T get(int index)
    {
        if(index > -1 && index <= size)
        return array[index];
        else throw new IndexOutOfBoundsException();
    }

    @Override
    public T set(int index, T element)
    {
        if(index > -1 && index <size)
        {
            array[index] = element;
            return array[index];
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(int index, T element)
    {
        if (index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array,index + 1,size - index);
        array[index] = element;
        size++;
    }

    @Override
    public T remove(int index)
    {
        if (index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        T element = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        return element;
    }

    @Override
    public int indexOf(Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator()
    {
        return new MyListIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException();
    }

    private void reallocation(int size, int capacity)
    {
        if (size > 0.8 * capacity)
        {
            capacity *= 2;
            this.capacity = capacity;
            array = Arrays.copyOf(array, capacity);
        }
    }

    @Override
    public String toString() {
        Iterator<T> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            T e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    private class MyListIterator implements ListIterator<T>
    {
        private int currentPos;
        private int lastReturned;

        MyListIterator()
        {
            currentPos = 0;
        }

        @Override
        public boolean hasNext()
        {
            return currentPos != size;
        }

        @Override
        public T next()
        {
            lastReturned = currentPos;
            return array[currentPos++];
        }

        @Override
        public boolean hasPrevious()
        {
            return currentPos != 0;
        }

        @Override
        public T previous()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public int nextIndex()
        {
            return currentPos;
        }

        @Override
        public int previousIndex()
        {
            return currentPos - 1;
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t)
        {
            array[lastReturned] = t;
        }

        @Override
        public void add(T t)
        {
            throw new UnsupportedOperationException();
        }
    }
}
