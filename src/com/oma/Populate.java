package com.oma;

import com.oma.model.*;
import com.oma.model.base.Piece;
import java.util.List;
import java.util.Map;

public class Populate {

    private final Map<String, Piece> positions;
    private final List<String> alphabets;

    public Populate(Map<String, Piece> positions, List<String> alphabets) {
        this.positions = positions;
        this.alphabets = alphabets;
    }

    private int populateRook(int index) {
        Chess<Rook> chess = new Chess<>();
        chess.addPiece(positions, new Rook(), alphabets.get(index) + 1, "White");
        chess.addPiece(positions, new Rook(), alphabets.get(index) + 8, "Black");
        return index + 1;
    }

    private int populateKnight(int index) {
        Chess<Knight> chess2 = new Chess<>();
        chess2.addPiece(positions, new Knight(), alphabets.get(index) + 1, "White");
        chess2.addPiece(positions, new Knight(), alphabets.get(index) + 8, "Black");
        return index + 1;
    }

    private int populateBishop(int index) {
        Chess<Bishop> chess3 = new Chess<>();
        chess3.addPiece(positions, new Bishop(), alphabets.get(index) + 1, "White");
        chess3.addPiece(positions, new Bishop(), alphabets.get(index) + 8, "Black");
        return index + 1;
    }

    private int populateQueen(int index) {
        Chess<Queen> chess4 = new Chess<>();
        chess4.addPiece(positions, new Queen(), alphabets.get(index) + 1, "White");
        chess4.addPiece(positions, new Queen(), alphabets.get(index) + 8, "Black");
        return index + 1;
    }

    private int populateKing(int index) {
        Chess<King> chess5 = new Chess<>();
        chess5.addPiece(positions, new King(), alphabets.get(index) + 1, "White");
        chess5.addPiece(positions, new King(), alphabets.get(index) + 8, "Black");
        return index + 1;
    }

    private void populatePawn(int index) {
        Chess<Pawn> pawnChess = new Chess<>();
        pawnChess.addPiece(positions, new Pawn(), alphabets.get(index) + 2, "White");
        pawnChess.addPiece(positions, new Pawn(), alphabets.get(index) + 7, "Black");
    }

    public Map<String, Piece> populatePositions() {
        int j = 0;
        j = populateRook(j);
        j = populateKnight(j);
        j = populateBishop(j);
        j = populateQueen(j);
        j = populateKing(j);
        j = populateBishop(j);
        j = populateKnight(j);
        populateRook(j);

        for (int k = 0; k < 8; k++) {
            populatePawn(k);
        }

        for (int i = 3; i < 7; i++) {
            for (int k = 0; k < 8; k++) {
                positions.put(alphabets.get(k) + i, null);
            }
        }

        for (Map.Entry<String, Piece> entry : positions.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return positions;
    }
}
