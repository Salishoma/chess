package com.oma.utils;

import com.oma.model.King;
import com.oma.model.Rook;
import com.oma.model.base.Piece;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidMove {

    public static Set<String> checkValidMoves(Piece piece, List<String>alphabets, Piece[][] board, int row, int col) {
        if (piece == null) {
            return new HashSet<>();
        }
        String name = piece.getName();
        switch (name) {
            case "Rook":
                return checkValidRookMoves(alphabets, board, row, col);
            case "Knight":
                return checkValidKnightMoves(alphabets, board, row, col);
            case "Bishop":
                return checkValidBishopMoves(alphabets, board, row, col);
            case "Queen":
                return checkValidQueenMoves(alphabets, board, row, col);
            case "King":
                return checkValidKingMoves(alphabets, board, row, col);
            case "Pawn":
                return checkValidPawnMoves(alphabets, board, row, col);
            default:
                return new HashSet<>();
        }
    }

    private static void checkValidMoves(List<String> alphabets, Piece[][] board, int row, int col, Set<String> set) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length && board[row][col] == null) {
            set.add(alphabets.get(col) + (row + 1));
        }
    }

    private static boolean isNotValidMovesXYDiagonal(List<String> alphabets, Piece[][] board, int row, int col, Set<String> set) {
        if (board[row][col] != null) {
            return true;
        }
        return !set.add(alphabets.get(col) + (row + 1));
    }

    private static Set<String> checkValidPawnMoves(List<String> alphabets, Piece[][] board, int row, int col) {
        Set<String> set = new HashSet<>();
        checkValidMoves(alphabets, board, row + 1, col, set);
        if (row == 1 & col >= 0 && col < board.length && board[row + 1][col] == null && board[row + 2][col] == null)  {
            set.add(alphabets.get(col) + (row + 3));
        }
        return set;
    }

    private static Set<String> checkValidKingMoves(List<String> alphabets, Piece[][] board, int row, int col) {
        Set<String> set = new HashSet<>();
        checkValidMoves(alphabets, board, row - 1, col - 1, set);
        checkValidMoves(alphabets, board, row, col - 1, set);
        checkValidMoves(alphabets, board, row + 1, col - 1, set);
        checkValidMoves(alphabets, board, row - 1, col, set);
        checkValidMoves(alphabets, board, row + 1, col, set);
        checkValidMoves(alphabets, board, row - 1, col + 1, set);
        checkValidMoves(alphabets, board, row , col + 1, set);
        checkValidMoves(alphabets, board, row + 1, col + 1, set);
        boolean isCastled = ((King) board[row][col]).isCastled();
        if (!isCastled) {
            addCastleMove(row, col - 1, board, alphabets, set, true);
            addCastleMove(row, col + 1, board, alphabets, set, false);
        }
        return set;
    }

    private static void addCastleMove(int row, int col, Piece[][] board, List<String> alphabets,
                              Set<String> set, boolean fromLeft) {
        boolean valid = true;
        int ind = fromLeft ? -1 : 1;
        for (int i = col; fromLeft ? i >= 0 : i < board.length; i = i + ind) {
            if (i != 0 && board[row][i] != null) {
                valid = false;
                break;
            }
        }
        if (valid) {
            boolean castled = ((Rook) board[row][fromLeft ? 0 : 7]).isCastled();
            if (!castled) {
                set.add(alphabets.get(col + 2 * ind) + (row + 1));
            }
        }
    }

    private static Set<String> checkValidQueenMoves(List<String> alphabets, Piece[][] board, int row, int col) {
        Set<String> set = moveXorY(alphabets, board, row, col, new HashSet<>());
        return moveDiagonal(alphabets, board, row, col, set);
    }

    private static Set<String> checkValidBishopMoves(List<String> alphabets, Piece[][] board, int row, int col) {
        return moveDiagonal(alphabets, board, row, col, new HashSet<>());
    }

    private static Set<String> checkValidKnightMoves(List<String> alphabets, Piece[][] board, int row, int col) {
        Set<String> set = new HashSet<>();
        checkValidMoves(alphabets, board, row - 2, col - 1, set);
        checkValidMoves(alphabets, board, row - 2, col + 1, set);
        checkValidMoves(alphabets, board, row + 2, col - 1, set);
        checkValidMoves(alphabets, board, row + 2, col + 1, set);
        checkValidMoves(alphabets, board, row - 1, col - 2, set);
        checkValidMoves(alphabets, board, row - 1, col + 2, set);
        checkValidMoves(alphabets, board, row + 1, col - 2, set);
        checkValidMoves(alphabets, board, row + 1, col + 2, set);
        return set;
    }

    private static Set<String> checkValidRookMoves(List<String> alphabets, Piece[][] board, int row, int col) {
        return moveXorY(alphabets, board, row, col, new HashSet<>());
    }

    private static Set<String> moveXorY(List<String> alphabets, Piece[][] board, int row, int col, Set<String> set) {

        for (int i = col - 1; i >= 0; i--) {
            if (isNotValidMovesXYDiagonal(alphabets, board, row, i, set)) break;
        }

        for (int i = col + 1; i < board.length; i++) {
            if (isNotValidMovesXYDiagonal(alphabets, board, row, i, set)) break;
        }

        for (int i = row; i >= 0; i--) {
            if (isNotValidMovesXYDiagonal(alphabets, board, i, col, set)) break;
        }

        for (int i = row; i < board.length; i++) {
            if (isNotValidMovesXYDiagonal(alphabets, board, i, col, set)) break;
        }
        return set;
    }

    private static Set<String> moveDiagonal(List<String> alphabets, Piece[][] board, int row, int col, Set<String> set) {
        int i = row + 1; int j = col - 1;
        while (i < board.length && j >= 0) {
            if (isNotValidMovesXYDiagonal(alphabets, board, i, j, set)) break;
            i += 1; j -= 1;
        }

        i = row + 1; j = col + 1;
        while (i < board.length && j < board.length) {
            if (isNotValidMovesXYDiagonal(alphabets, board, i, j, set)) break;
            i += 1; j += 1;
        }

        i = row - 1; j = col - 1;
        while (i >= 0 && j >= 0) {
            if (isNotValidMovesXYDiagonal(alphabets, board, i, j, set)) break;
            i -= 1; j -= 1;
        }

        i = row - 1; j = col + 1;
        while (i >= 0 && j < board.length) {
            if (isNotValidMovesXYDiagonal(alphabets, board, i, j, set)) break;
            i -= 1; j += 1;
        }
        return set;
    }
}
