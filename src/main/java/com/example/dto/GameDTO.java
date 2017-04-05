package com.example.dto;

import com.example.enums.GameType;
import com.example.enums.Piece;

public class GameDTO {
	private int id;
	private GameType gameType;
	private Piece piece;
	
	public GameDTO(){
	}
	public GameDTO(int id, GameType gameType, Piece piece){
		this.setId(id);
		this.setGameType(gameType);
		this.setPiece(piece);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public GameType getGameType() {
		return gameType;
	}
	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
