package com.oma.model;

import com.oma.enums.Move;
import com.oma.model.base.Piece;

import java.util.ArrayList;
import java.util.List;

import static com.oma.enums.Move.*;

public class Pawn extends Piece {
    private final List<Move> moves = new ArrayList<Move>(){{
        add(UP);
    }};

    private int maxDistancePerMove;
    private String name;
    private boolean firstMove;
    private boolean enPassant;

    public Pawn() {
        maxDistancePerMove = 2;
        name = "Pawn";
        firstMove = false;
        enPassant = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGroup() {
        return super.getGroup();
    }

    @Override
    public void setGroup(String group) {
        super.setGroup(group);
    }

    @Override
    public String getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(String position) {
        super.setPosition(position);
    }

    @Override
    public List<Move> getMoves() {
        return moves;
    }

    @Override
    public List<String> getCapture() {
        return super.getCapture();
    }

    @Override
    public void setCapture(List<String> capture) {
        super.setCapture(capture);
    }

    @Override
    public int getMaxDistancePerMove() {
        return maxDistancePerMove;
    }

    public void setMaxDistancePerMove() {
        if (firstMove) {
            maxDistancePerMove = 1;
        }
    }

    @Override
    public boolean isCanMoveBack() {
        return super.isCanMoveBack();
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove() {
        if (!firstMove) {
            this.firstMove = true;
        }
    }

    public boolean isEnPassant() {
        return enPassant;
    }

    public void setEnPassant(boolean enPassant) {
        this.enPassant = enPassant;
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "name='" + name + '\'' +
                ", group='" + super.getGroup() + '\'' +
                ", position='" + super.getPosition() + '\'' +
                ", moves=" + moves +
                ", maxDistancePerMove=" + maxDistancePerMove +
                ", canMoveBack=" + isCanMoveBack() +
                ", firstMove=" + firstMove +
                ", enPassant=" + enPassant +
                '}';
    }
}
