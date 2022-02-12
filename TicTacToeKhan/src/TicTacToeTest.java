import org.junit.jupiter.api.*;

import java.math.BigInteger;

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



    //functions for testing createBoard() function
    /**
     * this test will create a board with the same number of rows and columns using the smallest possible valid integer.
     *
     */
    @Test
    void createBoardSameSizeMin() {
        int row = 3;
        int column =3;
        int[][] array = {{0,0,0}, {0,0,0}, {0,0,0}};
        assertArrayEquals(array, TicTacToe.createBoard(row,column));
    }

    /**
     * this test will create a board with a larger row value and smaller column value.
     *
     */
    @Test
    void createBoardBiggerRowValue() {
        int row = 5;
        int column =3;
        int[][] array = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
        assertArrayEquals(array, TicTacToe.createBoard(row,column));
    }

    /**
     * this test will create a board with a smaller row value and larger column value.
     *
     */
    @Test
    void createBoardBiggerColumnValue() {
        int row = 3;
        int column =5;
        int[][] array = {{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}};
        assertArrayEquals(array, TicTacToe.createBoard(row,column));
    }

    /**
     * this test will create a board with the same size rows and columns using the largest valid integer.
     *
     */
    @Test
    void createBoardSameSizeMax() {
        int row = 5;
        int column =5;
        int[][] array = {{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}};
        assertArrayEquals(array, TicTacToe.createBoard(row,column));
    }


    //functions for testing rowsIn() function
    /**
     * testing for when function is passed a small row integer, should return integer for the number of rows
     *
     */
    @Test
    void rowsInBoardSmallInteger() {
        int[][] array = new int[3][5];
        assertEquals(3, TicTacToe.rowsIn(array));
    }

    /**
     * testing for when function is passed a large row integer value, should return integer for the number of rows
     *
     */
    @Test
    void rowsInBoardForBiggerInteger() {
        int[][] array = new int[5][3];
        assertEquals(5, TicTacToe.rowsIn(array));
    }

    /**
     * testing for when function is passed the same numbers for both rows and columns, should return integer for the
     * number of rows
     *
     */
    @Test
    void rowsInBoardForIntegerOfSameSize() {
        int[][] array = new int[4][4];
        assertEquals(4, TicTacToe.rowsIn(array));
    }


    //functions for testing columnsIn() function
    /**
     * testing for when function is passed a small column value, should return integer for number of columns
     *
     */
    @Test
    void columnsInBoardSmallInteger() {
        int[][] array = new int[5][3];
        assertEquals(3, TicTacToe.columnsIn(array));
    }

    /**
     * testing for when function is passed a large column value, should return integer for number of columns
     *
     */
    @Test
    void columnsInBoardBigInteger() {
        int[][] array = new int[3][5];
        assertEquals(5, TicTacToe.columnsIn(array));
    }

    /**
     * testing for when function is given a column integer that is the same number as the number of columns, should
     * return integer for number of columns
     *
     */
    @Test
    void columnsInBoardSameIntegerSize() {
        int[][] array = new int[4][4];
        assertEquals(4, TicTacToe.columnsIn(array));
    }


    //functions for testing canPlay() function
    /**
     * testing if function is able to find EMPTY location within a max sized board of 5x5. Should return that select
     * location is available for play
     *
     */
    @Test
    void canPlayForBigBoard() {
        int rowEntry = 3;
        int columnEntry = 1;
        int[][] array = {{2, 0, 1, 2, 2}, {1, 1, 2, 2, 0}, {1, 2, 0, 2, 1}, {0, 0, 1, 2, 2}, {1, 0, 2, 2, 0}};
        assertTrue(TicTacToe.canPlay(array,rowEntry,columnEntry));
    }

    /**
     * testing if function is able to find EMPTY location within the smallest sized board of 3x3. Should return that
     * select location is available for play
     *
     */
    @Test
    void canPlayForSmallBoard() {
        int rowEntry = 1;
        int columnEntry = 2;
        int[][] array = {{2, 0, 1}, {2, 2, 0}, {1, 2, 1}};
        assertTrue(TicTacToe.canPlay(array,rowEntry,columnEntry));
    }

    /**
     * testing if function is able to find EMPTY location within a board with different row and column size on board.
     * Should return that select location is available for play
     *
     */
    @Test
    void canPlayMixedRowColumnValues() {
        int rowEntry = 2;
        int columnEntry = 0;
        int[][] array = {{2,0,0,1},{1,2,1,0},{0,2,2,2}};
        assertTrue(TicTacToe.canPlay(array,rowEntry,columnEntry));
    }

    /**
     * testing if function is able to return FALSE for when the select location on the board is not available for play.
     * Should return that select location is NOT available for play
     *
     */
    @Test
    void canPlayWhenLocationIsNotEmpty() {
        int rowEntry = 1;
        int columnEntry = 2;
        int[][] array = {{2, 0, 1, 2, 2}, {1, 1, 2, 2, 0}, {1, 2, 0, 2, 1}, {0, 0, 1, 2, 2}, {1, 0, 2, 2, 0}};
        assertFalse(TicTacToe.canPlay(array,rowEntry,columnEntry));
    }


    //functions for testing play() function
    /**
     * testing for when the piece given is an X(1) and the piece is placed in board. Test will compare modified array
     * with expected array outcome. The replaced integer for X will be 1.
     *
     */

    @Test
    void playWithXPiece() {
        int [][] array = {{2, 0, 1}, {2, 2, 0}, {1, 2, 1}};
        int[][] arrayAfterPlay = {{2, 1, 1}, {2, 2, 0}, {1, 2, 1}};
        int row = 0;
        int column = 1;
        int piece = 1;
        //function modifies array with piece that is played
        TicTacToe.play(array,row,column,piece);
        assertArrayEquals(arrayAfterPlay, array);
    }

    /**
     * testing for when given piece is instead an O(2). Test will compare modified array with expected array outcome.
     * The replaced integer for O will be 2.
     */
    @Test
    void playWithOPiece() {
        int [][] array = {{2, 0, 1}, {2, 2, 0}, {1, 2, 1}};
        int[][] arrayAfterPlay = {{2, 0, 1}, {2, 2, 2}, {1, 2, 1}};
        int row = 1;
        int column = 2;
        int piece = 2;
        //function modifies array with piece that is played
        TicTacToe.play(array,row,column,piece);
        assertArrayEquals(arrayAfterPlay, array);
    }


    //functions for testing full() function
    /**
     * testing for when there is no more EMPTY spots in an array of the same sized nxn board. Should return that the
     * board is full.
     *
     */
    @Test
    void fullInSameSizedBoard() {
        int [][] array = {{2, 1, 1}, {2, 2, 1}, {1, 2, 1}};
        assertTrue(TicTacToe.full(array));

    }

    /**
     * testing for when there is no more EMPTY spots in an array of different [row][column] dimensions. Should return
     * that the board is full.
     *
     */
    @Test
    void fullForDiffDimensions() {
        int [][] array = {{2, 1, 1,2}, {2, 2, 1,2}, {1, 2, 1,2}};
        assertTrue(TicTacToe.full(array));

    }

    /**
     * testing for when there is an EMPTY spot in an array of different [row][column] dimensions. Should return
     * that the board is NOT full.
     *
     */
    @Test
    void boardIsNotFull() {
        int [][] array = {{2, 1, 0,2}, {2, 2, 1,2}, {1, 2, 0,2}};
        assertFalse(TicTacToe.full(array));

    }


    //functions for testing winInRow() function
    /**
     * testing for when there is a horizontal win in a board of the same dimensions. Should return true.
     *
     */
    @Test
    void winInRowOfSameSize() {
        int row = 0;
        int piece = 1;
        int[][] array = {{1,1,1},{2,1,1},{2,2,1}};
        assertTrue(TicTacToe.winInRow(array,row,piece));

    }

    /**
     * testing for when there is a horizontal win in a board with different dimensions. Winning row also has a different
     * piece at the end in the row. Should return true.
     *
     */
    @Test
    void winInRowOfDifferentSize() {
        int row = 0;
        int piece = 1;
        int[][] array = {{1,1,1,2},{1,2,2,1},{2,1,2,1}};
        assertTrue(TicTacToe.winInRow(array,row,piece));

    }

    /**
     * testing for when there is a horizontal win in the middle of some row. Winning row has different pieces on
     * the ends of the row. Should return true.
     *
     */
    @Test
    void winInRowWinInMid() {
        int row = 1;
        int piece = 1;
        int[][] array = {{1,1,2,2,1},{2,1,1,1,2},{2,1,2,1,2}};
        assertTrue(TicTacToe.winInRow(array,row,piece));

    }

    /**
     * testing for when there is NO horizontal win anywhere in the board. Winning row has no 3 consecutive pieces in a row.
     *
     */
    @Test
    void winInRowNotPresent() {
        int row = 1;
        int piece = 2;
        int[][] array = {{1,1,2,2,1},{2,1,2,1,2},{2,1,2,1,2}};
        assertFalse(TicTacToe.winInRow(array,row,piece));

    }

    /**
     * testing for when there is a horizontal win; however, the win is not for the right piece. Should return false.
     *
     */
    @Test
    void winInRowNotForRightPiece() {
        int row = 1;
        int piece = 1;
        int[][] array = {{1,1,2,2,1},{2,2,2,1,2},{2,1,2,1}};
        assertFalse(TicTacToe.winInRow(array,row,piece));

    }


    //functions for testing winInColumn() function
    /**
     * testing for when there is a vertical win in a board of the same dimensions. Should return true.
     *
     */
    @Test
    void winInColumnOfSameSize() {
        int column = 2;
        int piece = 1;
        int[][] array = {{1,2,1},{2,1,1},{2,2,1}};
        assertTrue(TicTacToe.winInColumn(array,column,piece));

    }

    /**
     * testing for when there is a vertical win in a board with different dimensions. Winning column also has a different
     * piece at the end of the column. Should return true.
     *
     */
    @Test
    void winInColumnOfDifferentSize() {
        int column = 0;
        int piece = 1;
        int[][] array = {{1,1,2},{1,2,1},{1,2,1},{1,2,2}};
        assertTrue(TicTacToe.winInColumn(array,column,piece));

    }

    /**
     * testing for when there is a vertical win in the middle of some column. Winning column has different pieces on
     * the ends of the row. Should return true.
     *
     */
    @Test
    void winInColumnWinInMid() {
        int column = 2;
        int piece = 1;
        int[][] array = {{1,1,2},{2,1,1},{2,1,1},{2,1,1},{1,1,2} };
        assertTrue(TicTacToe.winInColumn(array,column,piece));

    }

    /**
     * testing for when there is NO vertical win anywhere in the board. Winning column has no 3 consecutive pieces in
     * a column.
     *
     */
    @Test
    void winInColumnNotPresent() {
        int column = 1;
        int piece = 2;
        int[][] array = {{1,1,2},{2,1,2},{2,2,1}};
        assertFalse(TicTacToe.winInColumn(array,column,piece));

    }

    /**
     * testing for when there is a vertical win; however, the win is not for the right piece. Should return false.
     *
     */
    @Test
    void winInColumnNotForRightPiece() {
        int column = 1;
        int piece = 1;
        int[][] array = {{1,2,2},{2,2,1},{1,2,2}};
        assertFalse(TicTacToe.winInColumn(array,column,piece));

    }


    //functions to test winInDiagonalFS() function
    /**
     * testing for when there is a forward slash win in a board with different dimensions. Should return true.
     *
     */
    @Test
    void winInDiagonalFSDiffDimensions() {
        int piece = 1;
        int [][] array = {{1,1,1},
                        {0,1,1},
                        {1,2,2},
                        {2,1,1}};
        assertTrue(TicTacToe.winInDiagonalFS(array,piece));
    }

    /**
     * testing for when there is a forward slash win in a board with same dimensions. Should return true.
     *
     */
    @Test
    void winInDiagonalFSSameDimensions() {
        int piece = 1;
        int [][] array = {{1,1,1},
                {0,1,1},
                {1,2,2}};
        assertTrue(TicTacToe.winInDiagonalFS(array,piece));
    }

    /**
     * testing for when there is a forward slash win in a board, but the win is in the middle of the board surrounded by
     * nonconsecutive pieces. Should return true.
     *
     */
    @Test
    void winInDiagonalFSMiddle() {
        int piece = 2;
        int [][] array = {{1,1,1,1},
                        {0,1,1,2},
                        {1,2,2,1},
                        {1,2,1,2},
                        {2,2,1,2}};
        assertTrue(TicTacToe.winInDiagonalFS(array,piece));
    }

    /**
     * testing for when there is no forward slash in the board. Should return false.
     *
     */
    @Test
    void winInDiagonalFSNoWin() {
        int piece = 1;
        int [][] array = {{1,2,1,1},
                          {0,1,2,2},
                          {2,1,2,1}};
        assertFalse(TicTacToe.winInDiagonalFS(array,piece));
    }


    //functions for testing winInColumnBS() function
    /**
     * testing for when there is a backward slash win in a board with different dimensions. Should return true.
     *
     */
    @Test
    void winInDiagonalBSDiffDimensions() {
        int piece = 2;
        int [][] array = {{1,1,1},
                        {2,2,1},
                        {1,2,2},
                        {2,1,2}};
        assertTrue(TicTacToe.winInDiagonalBS(array,piece));
    }

    /**
     * testing for when there is a backward slash win in a board with same dimensions. Should return true.
     *
     */
    @Test
    void winInDiagonalBSSameDimensions() {
        int piece = 1;
        int [][] array = {{1,2,1},
                          {0,1,1},
                          {2,2,1}};
        assertTrue(TicTacToe.winInDiagonalBS(array,piece));
    }

    /**
     * testing for when there is a backward slash win in a board, but the win is in the middle of the board surrounded by
     * nonconsecutive pieces. Should return true.
     *
     */
    @Test
    void winInDiagonalBSMiddle() {
        int piece = 1;
        int [][] array = {{2,2,1,1},
                         {0,2,1,2},
                         {1,2,2,1},
                         {1,2,1,2},
                         {2,2,1,2}};
        assertTrue(TicTacToe.winInDiagonalBS(array,piece));
    }

    /**
     * testing for when there is no backward slash in the board. Should return false.
     *
     */
    @Test
    void winInDiagonalBSNoWin() {
        int piece = 1;
        int [][] array = {{1,2,1,1},
                          {0,1,2,2},
                          {2,1,2,1}};
        assertFalse(TicTacToe.winInDiagonalBS(array,piece));
    }


    //functions for testing hint() function
    /**
     * testing for a hint in some row. Should return the hint location.
     *
     */
    @Test
    void hintInRow() {
        int [][] array = {{0,1,1,2,0},
                        {0,1,0,1,0},
                        {0,1,1,0,1},
                        {0,0,0,1,1}};
        int piece = 1;
        assertArrayEquals(new int[]{0,0}, TicTacToe.hint(array,piece));
    }

    /**
     * testing for a hint in some column. Should return the hint location.
     *
     */
    @Test
    void hintInColumn() {
        int [][] array = {{0,2,1,2,0},
                          {1,0,0,1,2},
                          {0,1,1,2,1},
                          {0,0,0,1,1}};
        int piece = 1;
        assertArrayEquals(new int[]{0,0}, TicTacToe.hint(array,piece));
    }

    /**
     * testing for a hint in some forward slash diagonal. Should return the hint location.
     *
     */
    @Test
    void hintInDiagonalFS() {
        int [][] array = {{2,1,1,0},
                          {2,2,0,1},
                          {0,1,1,0}};
        int piece = 1;
        assertArrayEquals(new int[]{0,3}, TicTacToe.hint(array,piece));
    }

    /**
     * testing for a hint in some backward slash diagonal. Should return the hint location.
     *
     */
    @Test
    void hintInDiagonalBS() {
        int [][] array = {{0,0,1},
                          {1,2,1},
                          {2,1,2}};
        int piece = 2;
        assertArrayEquals(new int[]{0,0}, TicTacToe.hint(array,piece));
    }

    /**
     * testing for no hint in the board. Should return no piece for hint.
     *
     */
    @Test
    void hintInNothing() {
        int [][] array = {{2,1,1,2},
                          {1,2,2,1},
                          {2,1,1,2}};
        int piece = 1;
        assertArrayEquals(new int[]{-1,-1}, TicTacToe.hint(array,piece));
    }

    //functions for testing factorial() function
    /**
     * testing for the large possible integer without an error for complexity of game
     *
     */
    @Test
    void factorialNumLarge() {
        int num = 12;
        assertEquals(BigInteger.valueOf(479001600), TicTacToe.factorial(num));
    }

    //functions for testing factorial() function
    /**
     * testing for the smallest possible integer without an error for complexity of game
     *
     */
    @Test
    void factorialNumSmall() {
        int num = 0;
        assertEquals(BigInteger.valueOf(1), TicTacToe.factorial(num));
    }
}