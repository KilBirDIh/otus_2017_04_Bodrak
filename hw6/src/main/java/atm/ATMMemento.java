package atm;

import java.util.ArrayList;
import java.util.List;

class ATMMemento
{
    private final List<Cell> state;

    ATMMemento(List<Cell> state)
    {
        List<Cell> tempState = new ArrayList<>();
        for(Cell cell: state)
        {
            tempState.add(new Cell(cell.getNominal()));
        }
        this.state = tempState;
    }

    List<Cell> getSavedState()
    {
        return state;
    }
}
