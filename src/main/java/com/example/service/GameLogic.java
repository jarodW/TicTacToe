package com.example.service;

import java.util.*;
import java.util.stream.Collectors;

import com.example.model.Game;
import com.example.model.Move;
import com.example.model.Position;

public class GameLogic {
	private Game game;
	
	public GameLogic(Game game){
		this.game = game;
	}
	
    static boolean isWinner(int[][] moves) {
    	
        for (int row = 0; row<3; row++)
        {
            if (moves[row][0]==moves[row][1]  &&moves[row][1]==moves[row][2] && moves[row][0] != 0)
            	return true;
        }
        
        for(int col =  0;col<3; col++){
            if (moves[0][col]==moves[1][col] &&moves[1][col]==moves[2][col]  && moves[0][col] != 0)
            	return true;
        }
        
        if (moves[0][0]==moves[1][1] && moves[1][1]==moves[2][2] && moves[1][1] != 0)
        	return true;
        if (moves[0][2]==moves[1][1] && moves[1][1]==moves[2][0] && moves[1][1] != 0)
        	return true;
        return false;
    }
        
    static boolean playerTurn(int numberOfFirstPlayerMovesInGame, int numberOfSecondPlayerMovesInGame) {
        return numberOfFirstPlayerMovesInGame == numberOfSecondPlayerMovesInGame || numberOfFirstPlayerMovesInGame == 0;
    }

    static boolean isBoardIsFull(List<Move> moves) {
        return moves.size() == 9;
    }

	static Position nextAutoMove(int[][] board) {
    	 int bestVal = -100;
    	 int row = -1;
    	 int col = -1;
    	 
    	 for (int i = 0; i<3; i++){
    	     for (int j = 0; j<3; j++){
    	         if (board[i][j]== 0){
    	           board[i][j] = 2;
    	             int moveVal = minimax(board, 0, false);    	 
    	                board[i][j] = 0;
    	                if (moveVal > bestVal){
    	                    row = i;
    	                    col = j;
    	                    bestVal = moveVal;
    	                }
    	            }
    	        }
    	    }
		return new Position(row+1,col+1);
	}

	private static int minimax(int[][] board, int depth, boolean isMaxamizer) {
		
		int score = score(board);
		if(score == 10 || score == -10)
			return score;
		if(checkAvailable(board) == false)
			return 0;
		if(isMaxamizer){
			int best = -100;
			for(int i = 0; i <3; i++){
				for(int j = 0; j < 3; j++){
					if(board[i][j]==0){
						board[i][j]  = 2;
						best = Math.max(best, minimax(board,depth+1,!isMaxamizer));
						board[i][j] = 0;
					}
				}
			}
			return best;
		}else{
			int best = 100;
			for(int i = 0;i <3; i++){
				for(int j = 0; j< 3;j++){
					  if(board[i][j]==0){
						  board[i][j] = 1;
					  best = Math.max(best, minimax(board,depth+1,!isMaxamizer));
					  board[i][j] = 0;
					  }
				}
			}
			return best;
		}
	}
	
    static int score(int[][] board) {
    	
        for (int row = 0; row<3; row++)
        {
            if (board[row][0]==board[row][1]  &&board[row][1]==board[row][2]){
            	if(board[row][0] == 1)
            		return -10;
            	else if(board[row][0] == 2)
            		return 10;
            }
        }
        
        for(int col =  0;col<3; col++){
            if (board[0][col]==board[0][col] &&board[0][col]==board[0][col]){
            	if(board[0][col] == 1)
            		return -10;
            	else if(board[0][col] == 2)
            		return 10;
            }
           
        }
        
        if (board[0][0]==board[1][1] && board[1][1]==board[2][2]){
            if (board[0][0]==1)
                return -10;
            else if (board[0][0]==2)
                return 10;
        }
        if (board[0][2]==board[1][1] && board[1][1]==board[2][0]){
            if (board[0][0]==1)
                return -10;
            else if (board[0][0]==2)
                return 10;
        }
        return 0;
    }
    
    static boolean checkAvailable(int board[][]){
    	for(int i = 0; i < 3; i ++){
    		for(int j  =0; j < 3;j++){
    			if(board[i][j] == 0)
    				return true;
    		}
    	}
    	return false;
    }

}
