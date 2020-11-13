package com.company;

import java.util.LinkedList;

public class Tree {
    public int[][] board;
    public int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
    public int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

    private Node root;

    public Tree(int startX, int startY, int boardHeight, int boardWidth) {
        this.root = new Node(startX, startY);
        this.board = new int[boardHeight][boardWidth];
        board[startY][startX] = 1;
    }

    public void buildTree(Node root) {
        int knightMoves = 8;
        int childCount = 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            if (childCount == 0 && isValidMove(tempNode, xMove[0], yMove[0])) {
                if (isNewMove(board, tempNode, xMove[0], yMove[0])) {
                    queue.add(tempNode.firstChild = new Node(tempNode.x + xMove[0], tempNode.y + yMove[0]));
                    board[tempNode.y + yMove[0]][tempNode.x + xMove[0]] = 1;
                }
                childCount += 1;
            } else if (childCount > 0 && childCount < knightMoves) {
                for (int i = 1; i < knightMoves; i++) {
                    if (isValidMove(tempNode, xMove[i], yMove[i])) {
                        if(isNewMove(board, tempNode, xMove[i], yMove[i])){
                            queue.add(tempNode.nextSibling = new Node(tempNode.x + xMove[i], tempNode.y + yMove[i]));
                            childCount += 1;
                            board[tempNode.y + yMove[i]][tempNode.x + xMove[i]] = 1;
                        }
                    }
                }
                childCount = 0;
            }
        }

    }

    private boolean isValidMove(Node node, int xMove, int yMove) {
        if (node.x + xMove >= 0 && node.x + xMove < board[1].length && node.y + yMove >= 0 && node.y + yMove < board[0].length) {
            return true;
        }
        return false;
    }

    private boolean isNewMove(int[][] board, Node node, int xMove, int yMove) {
        if (board[node.y + yMove][node.x + xMove] == 0) {
            return true;
        }
        return false;
    }

    public void levelOrderTraversal(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Node> tempQueue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempnode = queue.poll();
            System.out.println("x: " + tempnode.x + " y: " + tempnode.y);
            if (tempnode.nextSibling != null) {
                queue.add(tempnode.nextSibling);
                tempQueue.add(tempnode);
            } else if (!tempQueue.isEmpty()) {
                for (Node node : tempQueue) {
                    Node tempnode2 = tempQueue.poll();
                    if (tempnode2.firstChild != null) {
                        queue.add(tempnode2.firstChild);
                    }
                }
            } else if(tempnode.firstChild != null){
                queue.add(tempnode.firstChild);
            }
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree(0, 0, 10, 10);
        t.buildTree(t.root);
        t.levelOrderTraversal(t.root);
        for(int i = 0; i < t.board[1].length - 1;i++){
            for (int j = 0; j < t.board[0].length-1; j++) {
                System.out.print(t.board[j][i]);
            }
            System.out.println("\n");
        }
    }

}
