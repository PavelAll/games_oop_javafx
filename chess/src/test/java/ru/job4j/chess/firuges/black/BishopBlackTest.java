package ru.job4j.chess.firuges.black;

import javafx.scene.control.Alert;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
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

        try {
            logic.move(Cell.C1, Cell.G5);
        } catch (Exception e) {
            e.getMessage();
        }

        Cell[] rsl = bishopBlack.way(Cell.G5);
        Assert.assertThat(rsl, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }


    @Test
    public void whenStepsWayFalse() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);

        try {
            logic.move(Cell.C1, Cell.F5);
        } catch (Exception e) {
            e.getMessage();
        }
        String rsl = null;
        try {
            bishopBlack.way(Cell.F5);
        } catch (ImpossibleMoveException e) {
            rsl = e.getMessage();
        }
        Assert.assertThat(rsl, is(String.format("Could not move by diagonal from %s to %s", Cell.C1, Cell.F5)));
    }
}