package com.company;

import java.util.ArrayList;

public class Node {

    private int depth;
    private int x;
    private int y;
    private ArrayList<Node> childList;

    public Node(int x, int y, int depth){
        this.childList = new ArrayList<>();
        this.depth = depth;
        this.x = x;
        this.y = y;
    }

    public int getDepth() {
        return depth;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Node> getChildList() {
        return childList;
    }


}
