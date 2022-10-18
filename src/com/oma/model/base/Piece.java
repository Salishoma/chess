package com.oma.model.base;

import com.oma.enums.Move;

import java.util.List;

public class Piece {
    private String name;
    private String group;
    private String position;
    private List<Move> moves;
    private List<String> capture;
    private int maxDistancePerMove;
    private boolean canMoveBack;

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<String> getCapture() {
        return capture;
    }

    public void setCapture(List<String> capture) {
        this.capture = capture;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public int getMaxDistancePerMove() {
        return maxDistancePerMove;
    }

    public boolean isCanMoveBack() {
        return canMoveBack;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", position='" + position + '\'' +
                ", moves=" + moves +
                ", capture=" + capture +
                ", maxDistancePerMove=" + maxDistancePerMove +
                ", canMoveBack=" + canMoveBack +
                '}';
    }
}
