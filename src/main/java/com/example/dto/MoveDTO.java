package com.example.dto;

import java.util.Date;

import com.example.enums.GameStatus;
import com.example.enums.Piece;

public class MoveDTO {
	private int boardColumn;
	private int boardRow;
	private Date created;
	private String userName;
	private GameStatus gameStatus;
	private Piece playerPiece;
	
	public MoveDTO(){
	}
	public MoveDTO(int boardColumn, int boardRow, Date created, String userName, GameStatus gameStatus,Piece playerPiece) {
		this.setBoardColumn(boardColumn);
		this.setBoardRow(boardRow);
		this.setCreated(created);
		this.setUserName(userName);
		this.setGameStatus(gameStatus);
		this.setPlayerPiece(playerPiece);
	}
	public int getBoardColumn() {
		return boardColumn;
	}
	public void setBoardColumn(int boardColumn) {
		this.boardColumn = boardColumn;
	}
	public int getBoardRow() {
		return boardRow;
	}
	public void setBoardRow(int boardRow) {
		this.boardRow = boardRow;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public GameStatus getGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
	public Piece getPlayerPiece() {
		return playerPiece;
	}
	public void setPlayerPiece(Piece playerPiece) {
		this.playerPiece = playerPiece;
	}
	
}
