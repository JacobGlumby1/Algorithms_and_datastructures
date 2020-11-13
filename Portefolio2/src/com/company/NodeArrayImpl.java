package com.company;

import java.util.ArrayList;

public class NodeArrayImpl {

    public int depth;
    public int x;
    public int y;
    public ArrayList<NodeArrayImpl> childList;

    public NodeArrayImpl(int x, int y, int depth){
        this.childList = new ArrayList<>();
        this.depth = depth;
        this.x = x;
        this.y = y;
    }

}
