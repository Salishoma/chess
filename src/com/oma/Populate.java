package com.oma;

import com.oma.model.*;
import com.oma.model.base.Piece;
import java.util.List;

public class Populate {

    private final List<String> alphabets;

    public Populate(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    private int populateRook(int index, ChessBoard chessBoard) {
        Chess<Rook> chess = new Chess<>();
        Rook whiteRook = chess.addPiece(new Rook(), alphabets.get(index) + 1, "White");
        Rook blackRook = chess.addPiece(new Rook(), alphabets.get(index) + 8, "Black");
        Piece[][] pieces = chessBoard.getBoard();
        pieces[0][index] = whiteRook;
        pieces[7][index] = blackRook;
        chessBoard.setBoard(pieces);
        return index + 1;
    }

    private int populateKnight(int index, ChessBoard chessBoard) {
        Chess<Knight> chess2 = new Chess<>();
        Knight whiteKnight = chess2.addPiece(new Knight(), alphabets.get(index) + 1, "White");
        Knight blackKnight = chess2.addPiece(new Knight(), alphabets.get(index) + 8, "Black");
        Piece[][] pieces = chessBoard.getBoard();
        pieces[0][index] = whiteKnight;
        pieces[7][index] = blackKnight;
        chessBoard.setBoard(pieces);
        return index + 1;
    }

    private int populateBishop(int index, ChessBoard chessBoard) {
        Chess<Bishop> chess3 = new Chess<>();
        Bishop whiteBishop = chess3.addPiece(new Bishop(), alphabets.get(index) + 1, "White");
        Bishop blackBishop = chess3.addPiece(new Bishop(), alphabets.get(index) + 8, "Black");
        Piece[][] pieces = chessBoard.getBoard();
        pieces[0][index] = whiteBishop;
        pieces[7][index] = blackBishop;
        chessBoard.setBoard(pieces);
        return index + 1;
    }

    private int populateQueen(int index, ChessBoard chessBoard) {
        Chess<Queen> chess4 = new Chess<>();
        Queen whiteQueen = chess4.addPiece(new Queen(), alphabets.get(index) + 1, "White");
        Queen blackQueen = chess4.addPiece(new Queen(), alphabets.get(index) + 8, "Black");
        Piece[][] pieces = chessBoard.getBoard();
        pieces[0][index] = whiteQueen;
        pieces[7][index] = blackQueen;
        chessBoard.setBoard(pieces);
        return index + 1;
    }

    private int populateKing(int index, ChessBoard chessBoard) {
        Chess<King> chess5 = new Chess<>();
        King whiteKing = chess5.addPiece(new King(), alphabets.get(index) + 1, "White");
        King blackKing = chess5.addPiece(new King(), alphabets.get(index) + 8, "Black");
        Piece[][] pieces = chessBoard.getBoard();
        pieces[0][index] = whiteKing;
        pieces[7][index] = blackKing;
        chessBoard.setBoard(pieces);
        return index + 1;
    }

    private void populatePawn(int index, ChessBoard chessBoard) {
        Chess<Pawn> pawnChess = new Chess<>();
        Pawn whitePawn = pawnChess.addPiece(new Pawn(), alphabets.get(index) + 2, "White");
        Pawn blackPawn = pawnChess.addPiece(new Pawn(), alphabets.get(index) + 7, "Black");
        Piece[][] pieces = chessBoard.getBoard();
        pieces[1][index] = whitePawn;
        pieces[6][index] = blackPawn;
        chessBoard.setBoard(pieces);
    }

    public void populatePositions(ChessBoard chessBoard) {
        int j = 0;
        j = populateRook(j, chessBoard);
        j = populateKnight(j, chessBoard);
        j = populateBishop(j, chessBoard);
        j = populateQueen(j, chessBoard);
        j = populateKing(j, chessBoard);
        j = populateBishop(j, chessBoard);
        j = populateKnight(j, chessBoard);
        populateRook(j, chessBoard);

        for (int k = 0; k < 8; k++) {
            populatePawn(k, chessBoard);
        }
    }
}
