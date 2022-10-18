package com.oma;

import com.oma.model.base.Piece;
import java.util.*;

public class ChessGame {

    private Map<String, Piece> positions;
    private final List<String> alphabets = new ArrayList<String>(){{
        add("A"); add("B"); add("C"); add("D"); add("E"); add("F"); add("G"); add("H");
    }};

    public void startGame() {
        positions = new LinkedHashMap<>();
        Populate populate = new Populate(positions, alphabets);
        positions = populate.populatePositions();
    }

}
