package com.test.lld.question.tictactoegame;

import java.util.AbstractMap;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.test.lld.question.tictactoegame.player.Players;
import com.test.lld.question.tictactoegame.playingsymbol.PlayingPieceO;
import com.test.lld.question.tictactoegame.playingsymbol.PlayingPieceX;

public class TicTacToeGame {

	private Deque<Players> players;
	
	private PlayingBoard playingBoard;

	public TicTacToeGame()
	{
		initializeGame();
	}
	
	
	public void initializeGame() {
		
		//creating 2 players
		players = new LinkedList<>();

        PlayingPieceX crossPiece = new PlayingPieceX();
        Players player1 = new Players("Player1", crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Players player2 = new Players("Player2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        //initializeBoard
        playingBoard = new PlayingBoard(3);
	}
	
	
	
	public String startGame()
	{
		boolean noWinner = true;
		
		while(noWinner){

            //take out the player whose turn is and also put the player in the list back
            Players playerTurn = players.removeFirst();

            //get the free space from the board
            playingBoard.printBoard();
            List<AbstractMap.SimpleEntry<Integer, Integer>> freeSpaces =  playingBoard.getFreeCells();
            
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            //read the user input
            System.out.print("Player:" + playerTurn.getName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);


            //place the piece
            boolean pieceAddedSuccessfully = playingBoard.addPiece(inputRow,inputColumn, playerTurn.getPlayingSymbol());
            if(!pieceAddedSuccessfully) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorredt possition chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.getPlayingSymbol().pieceType);
            if(winner) {
                return playerTurn.getName();
            }
        }

        return "tie";

	}
	
	
	public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<playingBoard.getSize();i++) {

            if(playingBoard.board[row][i] == null || playingBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<playingBoard.getSize();i++) {

            if(playingBoard.board[i][column] == null || playingBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<playingBoard.getSize();i++,j++) {
            if (playingBoard.board[i][j] == null || playingBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=playingBoard.getSize()-1; i<playingBoard.getSize();i++,j--) {
            if (playingBoard.board[i][j] == null || playingBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

	
	
}
