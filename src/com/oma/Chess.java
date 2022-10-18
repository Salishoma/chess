package com.oma;

import com.oma.model.base.Piece;

import java.util.Map;

public class Chess<T extends Piece> {

    public T addPiece(Map<String, Piece> positions, T piece, String pos, String group) {
        piece.setPosition(pos);
        piece.setGroup(group);
        positions.put(pos, piece);
        return piece;
    }
}
