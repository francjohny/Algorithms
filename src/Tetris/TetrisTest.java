package Tetris;


import org.junit.Before;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TetrisTest {

    Board b;

    @Before
    public void setUp() throws Exception {
        b = new Board(10, 20);
    }

    @org.junit.Test
    public void testInput() {
        assertEquals(2, TetrisEngine.getMaxGridHeight("Q0", b));
    }

    @org.junit.Test
    public void testInput2() {
        assertEquals(4, TetrisEngine.getMaxGridHeight("Q0,Q1", b));
    }
    @org.junit.Test
    public void testInput3() {
        assertEquals(2, TetrisEngine.getMaxGridHeight("Q0,Q4", b));
    }
    @org.junit.Test
    public void testInput4() {
        assertEquals(0, TetrisEngine.getMaxGridHeight("Q0,Q2,Q4,Q6,Q8", b));
    }
    @org.junit.Test
    public void testInput5() {
        assertEquals(2, TetrisEngine.getMaxGridHeight("Q0,Q2,Q4,Q6,Q8,Q1", b));
    }
    @org.junit.Test
    public void testInput6() {
        assertEquals(4, TetrisEngine.getMaxGridHeight("Q0,Q2,Q4,Q6,Q8,Q1,Q1", b));
    }
    @org.junit.Test
    public void testInput7() {
        assertEquals(1, TetrisEngine.getMaxGridHeight("I0,I4,Q8", b));
    }
    @org.junit.Test
    public void testInput8() {
        assertEquals(0, TetrisEngine.getMaxGridHeight("I0,I4,Q8,I0,I4", b));
    }
    @org.junit.Test
    public void testInput9() {
        assertEquals(2, TetrisEngine.getMaxGridHeight("L0,J2,L4,J6,Q8", b));
    }
    @org.junit.Test
    public void testInput10() {
        assertEquals(2, TetrisEngine.getMaxGridHeight("L0,Z1,Z3,Z5,Z7", b));
    }
    @org.junit.Test
    public void testInput11() {
        assertEquals(2, TetrisEngine.getMaxGridHeight("T0,T3", b));
    }
    @org.junit.Test
    public void testInput12() {
        assertEquals(1, TetrisEngine.getMaxGridHeight("T0,T3,I6,I6", b));
    }
    @org.junit.Test
    public void testInput13() {
        assertEquals(1, TetrisEngine.getMaxGridHeight("I0,I6,S4", b));
    }
    @org.junit.Test
    public void testInput14() {
        assertEquals(4, TetrisEngine.getMaxGridHeight("T1,Z3,I4", b));
    }
    @org.junit.Test
    public void testInput15() {
        assertEquals(3, TetrisEngine.getMaxGridHeight("L0,J3,L5,J8,T1", b));
    }
    @org.junit.Test
    public void testInput16() {
        assertEquals(1, TetrisEngine.getMaxGridHeight("L0,J3,L5,J8,T1,T6", b));
    }
    @org.junit.Test
    public void testInput17() {
        assertEquals(2, TetrisEngine.getMaxGridHeight("L0,J3,L5,J8,T1,T6,J2,L6,T0,T7", b));
    }
    @org.junit.Test
    public void testInput18() {
        assertEquals(1, TetrisEngine.getMaxGridHeight("L0,J3,L5,J8,T1,T6,J2,L6,T0,T7,Q4", b));
    }
    @org.junit.Test
    public void testInput19() {
        assertEquals(8, TetrisEngine.getMaxGridHeight("S0,S2,S4,S6", b));
    }
    @org.junit.Test
    public void testInput20() {
        assertEquals(8, TetrisEngine.getMaxGridHeight("S0,S2,S4,S5,Q8,Q8,Q8,Q8,T1,Q1,I0,Q4", b));
    }
    @org.junit.Test
    public void testInput21() {
        assertEquals(0, TetrisEngine.getMaxGridHeight("L0,J3,L5,J8,T1,T6,S2,Z5,T0,T7", b));
    }
    @org.junit.Test
    public void testInput22() {
        assertEquals(4, TetrisEngine.getMaxGridHeight("Q0,I2,I6,I0,I6,I6,Q2,Q4", b));
    }
}

