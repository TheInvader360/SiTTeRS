package com.theinvader360.sitters;

public class Model {
    private static Model instance;
    private Board board;

    private Model() {
        board = new Board();
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public Board getBoard() {
        return board;
    }

}
