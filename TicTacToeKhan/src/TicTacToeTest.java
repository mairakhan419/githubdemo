import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Maira Khan
 * @course CPSC233 W22
 * @instructor Jonathan Hudson
 * @tutorial Abdel Ghani
 * @studentID 30047942
 * @date 10 February 2022
 */

class TicTacToeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    /**
     *this test will create a board with the same number of rows and columns
     *
     */
    @Test
    void createBoardSameSizeMin() {
        int row = 3;
        int column =3;
        int[][] array = {{0,0,0}, {0,0,0}, {0,0,0}};
        assertArrayEquals(array, TicTacToe.createBoard(row,column));
    }

    @Test
    void createBoardBiggerRowValue() {
        int row = 5;
        int column =3;
        int[][] array = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
        assertArrayEquals(array, TicTacToe.createBoard(row,column));
    }

    @Test
    void createBoardBiggerColumnValue() {
        int row = 3;
        int column =5;
        int[][] array = {{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}};
        assertArrayEquals(array, TicTacToe.createBoard(row,column));
    }

    @Test
    void createBoardSameSizeMax() {
        int row = 5;
        int column =5;
        int[][] array = {{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}};
        assertArrayEquals(array, TicTacToe.createBoard(row,column));
    }


    //testing rows function

    /**
     * testing for when function is passed a small row integer, should pass back that digit
     */
    @Test
    void rowsInBoardSmallInteger() {
        int[][] array = new int[3][5];
        assertEquals(3, TicTacToe.rowsIn(array));
    }

    @Test
    void rowsInBoardForBiggerInteger() {
        int[][] array = new int[5][3];
        assertEquals(5, TicTacToe.rowsIn(array));
    }

    @Test
    void rowsInBoardForIntegerOfSameSize() {
        int[][] array = new int[4][4];
        assertEquals(4, TicTacToe.rowsIn(array));
    }



    //testing column function

    /**
     * testing for when small integer is passed for columns
     */
    @Test
    void columnsInBoardSmallInteger() {
        int[][] array = new int[5][3];
        assertEquals(3, TicTacToe.columnsIn(array));
    }

    void columnsInBoardBigInteger() {
        int[][] array = new int[3][5];
        assertEquals(5, TicTacToe.columnsIn(array));
    }

    void columnsInBoardSameIntegerSize() {
        int[][] array = new int[4][4];
        assertEquals(4, TicTacToe.columnsIn(array));
    }




    //testing play function

    @Test
    void canPlay() {
    }

    @Test
    void play() {
    }

    @Test
    void full() {
    }

    @Test
    void winInRow() {
    }

    @Test
    void winInColumn() {
    }

    @Test
    void winInDiagonalBS() {
    }

    @Test
    void factorial() {
    }
}