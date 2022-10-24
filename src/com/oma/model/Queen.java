package com.oma.model;

import com.oma.enums.Move;
import com.oma.model.base.Piece;

import java.util.ArrayList;
import java.util.List;

import static com.oma.enums.Move.*;

public class Queen extends Piece {
    private final List<Move> moves = new ArrayList<Move>(){{
        add(UP); add(DOWN); add(LEFT);
        add(RIGHT); add(DIAGONAL_UP_LEFT); add(DIAGONAL_UP_RIGHT);
        add(DIAGONAL_DOWN_LEFT); add(DIAGONAL_DOWN_RIGHT);
    }};

    private final int maxDistancePerMove;
    private final String name;

    public Queen() {
        maxDistancePerMove  = 8;
        name = "Queen";
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

    @Override
    public boolean isCanMoveBack() {
        return true;
    }

    @Override
    public String toString() {
        return "Queen{" +
                "name='" + name + '\'' +
                ", group='" + super.getGroup() + '\'' +
                ", position='" + super.getPosition() + '\'' +
                ", moves=" + moves +
                ", maxDistancePerMove=" + maxDistancePerMove +
                ", canMoveBack=" + isCanMoveBack() +
                '}';
    }
}
