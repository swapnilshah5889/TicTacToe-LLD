package com.swapnilshah5889.tictactoe.models;

import java.util.Scanner;

public class Player {
    private char symbol;
    private String name;
    private PlayerType type;

    public Player(String name, char symbol) {
        this(name, symbol, PlayerType.HUMAN);
    }

    protected Player(String name, char symbol, PlayerType type) {
        this.name = name;
        this.symbol = symbol;
        this.type = type;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public Move decideMove(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the row: ");
        int row = sc.nextInt();
        System.out.println("Please enter the column: ");
        int col = sc.nextInt();
        return new Move(this, new Cell(row, col));
    }
}
