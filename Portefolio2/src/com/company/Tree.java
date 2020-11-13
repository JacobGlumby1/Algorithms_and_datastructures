package com.company;

import java.util.LinkedList;

public class Tree {

    private int depth = 1; //Setting depth to 1, as it doesent function right if 0.
    private int[][] board;
    private int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
    private Node endNode;

    private Node root;


    public Tree(int boardHeight, int boardWidth, int startX, int startY, int endX, int endY) {
        this.root = new Node(startX, startY, depth - 1);
        this.board = new int[boardHeight + 1][boardWidth + 1];
        board[startY][startX] = 1;
        buildTree(root, endX, endY);
    }

    public void buildTree(Node root, int xEnd, int yEnd) {
        int knightMoves = 7;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            if (tempNode == null) {
                depth++;
                queue.add(null);
                if (queue.peek() == null) break;
                else continue;
            }
            for (int i = 0; i < knightMoves; i++) {
                if (isValidMove(tempNode, xMove[i], yMove[i])) {
                    if (isNewMove(board, tempNode, xMove[i], yMove[i])) {
                        Node node = new Node(tempNode.getX() + xMove[i], tempNode.getY() + yMove[i], depth);
                        tempNode.getChildList().add(node);
                        queue.add(node);
                        board[tempNode.getY() + yMove[i]][tempNode.getX() + xMove[i]] = depth;
                        if (isEndPosition(node, xEnd, yEnd)) {
                            this.endNode = node;
                        }
                        //printBoard();
                    }
                }

            }
        }
    }

    private void printBoard() {
        for (int j = 0; j < board[1].length - 1; j++) {
            for (int k = 0; k < board[0].length - 1; k++) {
                System.out.print(board[k][j] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    private boolean isEndPosition(Node node, int xEnd, int yEnd) {
        return node.getX() == xEnd && node.getY() == yEnd;
    }

    private boolean isValidMove(Node node, int xMove, int yMove) {
        return node.getX() + xMove >= 0 && node.getX() + xMove < board[1].length && node.getY() + yMove >= 0 && node.getY() + yMove < board[0].length;
    }

    private boolean isNewMove(int[][] board, Node node, int xMove, int yMove) {
        return board[node.getY() + yMove][node.getX() + xMove] == 0;
    }

    public void levelOrderTraversal(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println("X: " + node.getX() + " Y: " + node.getY() + " depth: " + node.getDepth());
            if (!node.getChildList().isEmpty()) {
                for (int i = 0; i < node.getChildList().size(); i++) {
                    queue.add(node.getChildList().get(i));
                }
            }
        }
    }


    public Node getEndNode() {
        return endNode;
    }

    public static void main(String[] args) {
        Tree t = new Tree(100, 100, 1, 1, 3, 3);

        System.out.println("The position can be reached in: " + t.endNode.getDepth() + " moves ");

        t.printBoard();
    }


    public int getDepth() {
        return depth;
    }

    public int[][] getBoard() {
        return board;
    }

    public int[] getxMove() {
        return xMove;
    }

    public int[] getyMove() {
        return yMove;
    }

    public Node getRoot() {
        return root;
    }
}
