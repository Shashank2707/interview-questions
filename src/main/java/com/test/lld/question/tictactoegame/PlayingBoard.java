package com.test.lld.question.tictactoegame;

import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap;

import com.test.lld.question.tictactoegame.playingsymbol.PlayingSymbol;

public class PlayingBoard {

	private int size;
	
	PlayingSymbol [][] board;

	public PlayingBoard(int size) {
		this.size = size;
		this.board = new PlayingSymbol[size][size];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean addPiece(int row, int column, PlayingSymbol playingPiece) {

        if(board[row][column] != null) {
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }
	
	
	public List<AbstractMap.SimpleEntry<Integer, Integer>> getFreeCells() {
//		AbstractMap.SimpleEntry<String, Integer> pair = new AbstractMap.SimpleEntry<>("Age", 25);
        List<AbstractMap.SimpleEntry<Integer, Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    AbstractMap.SimpleEntry<Integer, Integer> rowColumn = new AbstractMap.SimpleEntry<>(i, j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                   System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }


	
}
