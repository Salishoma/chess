package com.oma;

import com.oma.model.base.Piece;

public class Chess<T extends Piece> {

    public T addPiece(T piece, String pos, String group) {
        piece.setPosition(pos);
        piece.setGroup(group);
        return piece;
    }
}
