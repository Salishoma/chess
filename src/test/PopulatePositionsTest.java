package test;

import com.oma.Populate;
import com.oma.model.ChessBoard;
import com.oma.model.base.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.oma.utils.ValidMove.checkValidMoves;
import static org.junit.jupiter.api.Assertions.*;

class PopulatePositionsTest {

    private Piece[][] board;
    List<String> alphabets;

    @BeforeEach
    void setUp() {
        ChessBoard chessBoard = new ChessBoard();
        alphabets = new ArrayList<String>() {{
            add("A");
            add("B");
            add("C");
            add("D");
            add("E");
            add("F");
            add("G");
            add("H");
        }};
        Populate populate = new Populate(alphabets);
        populate.populatePositions(chessBoard);
        board = chessBoard.getBoard();
    }

    @Test
    public void rankOfficerStartPositionsTest() {
        assertEquals(board[0][0].getName(), "Rook");
        assertEquals(board[0][1].getName(), "Knight");
        assertEquals(board[0][2].getName(), "Bishop");
        assertEquals(board[0][3].getName(), "Queen");
        assertEquals(board[0][4].getName(), "King");
        assertEquals(board[0][5].getName(), "Bishop");
        assertEquals(board[0][6].getName(), "Knight");
        assertEquals(board[0][7].getName(), "Rook");

        assertEquals(board[7][0].getName(), "Rook");
        assertEquals(board[7][1].getName(), "Knight");
        assertEquals(board[7][2].getName(), "Bishop");
        assertEquals(board[7][3].getName(), "Queen");
        assertEquals(board[7][4].getName(), "King");
        assertEquals(board[7][5].getName(), "Bishop");
        assertEquals(board[7][6].getName(), "Knight");
        assertEquals(board[7][7].getName(), "Rook");
    }

    @Test
    public void pawnStartPositionsTest() {
        assertEquals(board[1][0].getName(), "Pawn");
        assertEquals(board[1][1].getName(), "Pawn");
        assertEquals(board[1][2].getName(), "Pawn");
        assertEquals(board[1][3].getName(), "Pawn");
        assertEquals(board[1][4].getName(), "Pawn");
        assertEquals(board[1][5].getName(), "Pawn");
        assertEquals(board[1][6].getName(), "Pawn");
        assertEquals(board[1][7].getName(), "Pawn");

        assertEquals(board[6][0].getName(), "Pawn");
        assertEquals(board[6][1].getName(), "Pawn");
        assertEquals(board[6][2].getName(), "Pawn");
        assertEquals(board[6][3].getName(), "Pawn");
        assertEquals(board[6][4].getName(), "Pawn");
        assertEquals(board[6][5].getName(), "Pawn");
        assertEquals(board[6][6].getName(), "Pawn");
        assertEquals(board[6][7].getName(), "Pawn");
    }

    @Test
    void checkInitialValidMovesTest() {
        int row = 0; int col = 0;
        Set<String> rookMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(0, rookMoves.size());

        col = 1;
        Set<String> validKnightMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(2, validKnightMoves.size());
        assertTrue(validKnightMoves.contains("A3"));
        assertTrue(validKnightMoves.contains("C3"));

        col = 6;
        validKnightMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(2, validKnightMoves.size());
        assertTrue(validKnightMoves.contains("F3"));
        assertTrue(validKnightMoves.contains("H3"));

        col = 2;
        Set<String> validBishopMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(0, validBishopMoves.size());

        col = 3;
        Set<String> validQueenMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(0, validQueenMoves.size());

        col = 4;
        Set<String> validKingMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(0, validKingMoves.size());

        row = 1; col = 0;
        Set<String> validPawnMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(2, validPawnMoves.size());
        assertTrue(validPawnMoves.contains("A3"));
        assertTrue(validPawnMoves.contains("A4"));

        col = 1;
        validPawnMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(2, validPawnMoves.size());
        assertTrue(validPawnMoves.contains("B3"));
        assertTrue(validPawnMoves.contains("B4"));

        col = 2;
        validPawnMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(2, validPawnMoves.size());
        assertTrue(validPawnMoves.contains("C3"));
        assertTrue(validPawnMoves.contains("C4"));

        col = 3;
        validPawnMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(2, validPawnMoves.size());
        assertTrue(validPawnMoves.contains("D3"));
        assertTrue(validPawnMoves.contains("D4"));

        row = 7; col = 0;
        rookMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(0, rookMoves.size());

        col = 1;
        validKnightMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(2, validKnightMoves.size());
        assertTrue(validKnightMoves.contains("A6"));
        assertTrue(validKnightMoves.contains("C6"));

        col = 6;
        validKnightMoves = checkValidMoves(board[row][col], alphabets, board, row, col);
        assertEquals(2, validKnightMoves.size());
        assertTrue(validKnightMoves.contains("F6"));
        assertTrue(validKnightMoves.contains("H6"));
    }
}