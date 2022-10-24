package com.oma;

import com.oma.model.*;
import com.oma.model.base.Piece;
import com.oma.utils.CharacterValidation;

import java.util.*;

import static com.oma.utils.ValidMove.checkValidMoves;

public class ChessGame {

    private final Map<String, Piece> positions = new LinkedHashMap<>();
    private final List<String> alphabets = new ArrayList<String>(){{
        add("A"); add("B"); add("C"); add("D"); add("E"); add("F"); add("G"); add("H");
    }};

    private final Map<String, Integer> alphabetMap = new HashMap<>();

    private final Scanner scanner = new Scanner(System.in);

    public void startGame() {
        for (int i = 0; i < 8; i++) {
            alphabetMap.put(alphabets.get(i), i + 1);
        }

        ChessBoard chessBoard = new ChessBoard();
        Populate populate = new Populate(alphabets);
        populate.populatePositions(chessBoard);

        Piece[][] board = chessBoard.getBoard();
        System.out.println(Arrays.deepToString(board));

        boolean whiteTurn = true;

        while (true) {
            System.out.println("Move piece");
            String curPos = scanner.nextLine();
            Object[] pos = Arrays.stream(curPos.split(""))
                    .filter(x -> !" ".equals(x))
                    .toArray();

            if (pos.length != 2) {
                System.out.println("Not a valid position");
                continue;
            }
            String s = ((String) pos[0]).toUpperCase();
            String n = (String) pos[1];
            boolean isValidLetter = CharacterValidation.validateLetter(s);
            boolean isValidNumber = CharacterValidation.validateNumber(n);
            if (!isValidNumber || !isValidLetter || !alphabetMap.containsKey(s)) {
                System.out.println("Not a valid position");
                continue;
            }
            int row = Integer.parseInt(n) - 1;
            int col = alphabetMap.get(s) - 1;
            System.out.println(whiteTurn ? "White turn" : "Black turn");
            if (row < 0 || row > 7 || col < 0 || col > 7) {
                System.out.println("Not a valid position");
                continue;
            }
            Piece piece = board[row][col];
            Set<String> validMoves = checkValidMoves(piece, alphabets, board, row, col);
            if (validMoves.size() == 0) {
                System.out.println("No valid moves");
                continue;
            }

            System.out.println("Valid moves are: ");
            for (String move : validMoves) {
                System.out.println(move);
            }
        }
    }
}
