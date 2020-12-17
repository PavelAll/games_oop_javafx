package ru.job4j.chess.firuges.black;

import javafx.scene.control.Alert;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPositionF8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell rsl = bishopBlack.position();
        Assert.assertThat(rsl, is(Cell.F8));
    }

    @Test
    public void whenCopyPositionA3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Figure rsl = bishopBlack.copy(Cell.A3);
        Assert.assertThat(rsl.position(), is(Cell.A3));
    }


    @Test
    public void whenStepsWayTrue() throws ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        Cell[] rsl = bishopBlack.way(Cell.G5);
        Assert.assertThat(rsl, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }


    @Test(expected = ImpossibleMoveException.class)
    public void whenStepsWayFalse() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        logic.move(Cell.C1, Cell.F5);
        bishopBlack.way(Cell.F5);
    }
}