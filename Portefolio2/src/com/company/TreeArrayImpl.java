package com.company;

import java.util.LinkedList;

public class TreeArrayImpl {

    public int depth = 1; //Setting depth to 1, as it doesent function right if 0.
    public int[][] board;
    public int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
    public int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
    public NodeArrayImpl endNode;

    private NodeArrayImpl root;

    public TreeArrayImpl(int startX, int startY, int boardHeight, int boardWidth) {
        this.root = new NodeArrayImpl(startX, startY, depth-1);
        this.board = new int[boardHeight][boardWidth];
        board[startY][startX] = 1;
    }

    public void buildTree(NodeArrayImpl root, int xEnd, int yEnd) {
        int knightMoves = 7;
        LinkedList<NodeArrayImpl> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            NodeArrayImpl tempNode = queue.poll();
            if(tempNode == null){
                depth++;
                queue.add(null);
                if(queue.peek() == null) break;
                else continue;
            }
            for (int i = 0; i < knightMoves; i++) {
                if (isValidMove(tempNode, xMove[i], yMove[i])) {
                    if (isNewMove(board, tempNode, xMove[i], yMove[i])) {
                        NodeArrayImpl node = new NodeArrayImpl(tempNode.x + xMove[i], tempNode.y + yMove[i], depth);
                        tempNode.childList.add(node);
                        queue.add(node);
                        board[tempNode.y + yMove[i]][tempNode.x + xMove[i]] = depth;
                        if(isEndPosition(node, xEnd, yEnd)){
                            this.endNode = node;
                        }
                        //printBoard();
                    }
                }

            }
        }
    }

    private void printBoard(){
        for (int j = 0; j < board[1].length - 1; j++) {
            for (int k= 0; k < board[0].length - 1; k++) {
                System.out.print(board[k][j] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    private boolean isEndPosition(NodeArrayImpl node, int xEnd, int yEnd){
        return node.x == xEnd && node.y == yEnd;
    }

    private boolean isValidMove(NodeArrayImpl node, int xMove, int yMove) {
        return node.x + xMove >= 0 && node.x + xMove < board[1].length && node.y + yMove >= 0 && node.y + yMove < board[0].length;
    }

    private boolean isNewMove(int[][] board, NodeArrayImpl node, int xMove, int yMove) {
        return board[node.y + yMove][node.x + xMove] == 0;
    }

    public void levelOrderTraversal(NodeArrayImpl root) {
        LinkedList<NodeArrayImpl> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            NodeArrayImpl node = queue.poll();
            System.out.println("X: " + node.x + " Y: " + node.y + " depth: " + node.depth);
            if(!node.childList.isEmpty()){
                for(int i = 0; i < node.childList.size();i++){
                    queue.add(node.childList.get(i));
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeArrayImpl t = new TreeArrayImpl(0, 0, 100, 100);
        t.buildTree(t.root,3,3);
        System.out.println("The position can be reached in: " + t.endNode.depth + " moves ");
        t.levelOrderTraversal(t.root);

        for (int i = 0; i < t.board[1].length - 1; i++) {
            for (int j = 0; j < t.board[0].length - 1; j++) {
                System.out.print(t.board[j][i] + "\t");
            }
            System.out.println("\n");
        }
    }


}
