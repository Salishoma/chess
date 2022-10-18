package test;

import com.oma.Populate;
import com.oma.model.base.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ChessGameTest {

    private final Map<String, Piece> positions = new LinkedHashMap<>();

    @BeforeEach
    void setUp() {
        List<String> alphabets = new ArrayList<String>() {{
            add("A");
            add("B");
            add("C");
            add("D");
            add("E");
            add("F");
            add("G");
            add("H");
        }};
        Populate populate = new Populate(positions, alphabets);
        populate.populatePositions();
    }

    @Test
    public void rankOfficerStartPositionTest() {
        assertEquals(positions.get("A1").getName(), "Rook");
        assertEquals(positions.get("B1").getName(), "Knight");
        assertEquals(positions.get("C1").getName(), "Bishop");
        assertEquals(positions.get("D1").getName(), "Queen");
        assertEquals(positions.get("E1").getName(), "King");
        assertEquals(positions.get("F1").getName(), "Bishop");
        assertEquals(positions.get("G1").getName(), "Knight");
        assertEquals(positions.get("H1").getName(), "Rook");

        assertEquals(positions.get("A8").getName(), "Rook");
        assertEquals(positions.get("B8").getName(), "Knight");
        assertEquals(positions.get("C8").getName(), "Bishop");
        assertEquals(positions.get("D8").getName(), "Queen");
        assertEquals(positions.get("E8").getName(), "King");
        assertEquals(positions.get("F8").getName(), "Bishop");
        assertEquals(positions.get("G8").getName(), "Knight");
        assertEquals(positions.get("H8").getName(), "Rook");
    }

    @Test
    public void pawnStartPositionTest() {
        assertEquals(positions.get("B2").getName(), "Pawn");
        assertEquals(positions.get("B2").getName(), "Pawn");
        assertEquals(positions.get("C2").getName(), "Pawn");
        assertEquals(positions.get("D2").getName(), "Pawn");
        assertEquals(positions.get("E2").getName(), "Pawn");
        assertEquals(positions.get("F2").getName(), "Pawn");
        assertEquals(positions.get("G2").getName(), "Pawn");
        assertEquals(positions.get("H2").getName(), "Pawn");

        assertEquals(positions.get("A7").getName(), "Pawn");
        assertEquals(positions.get("B7").getName(), "Pawn");
        assertEquals(positions.get("C7").getName(), "Pawn");
        assertEquals(positions.get("D7").getName(), "Pawn");
        assertEquals(positions.get("E7").getName(), "Pawn");
        assertEquals(positions.get("F7").getName(), "Pawn");
        assertEquals(positions.get("G7").getName(), "Pawn");
        assertEquals(positions.get("H7").getName(), "Pawn");
    }
}