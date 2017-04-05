package com.example.dto;

public class CreateMoveDTO {
	private int boardRow;
	private int boardColumn;
	
	public CreateMoveDTO(){
	}
	public CreateMoveDTO(int boardRow, int boardColumn){
		this.setBoardRow(boardRow);
		this.setBoardColumn(boardColumn);
	}
	public int getBoardRow() {
		return boardRow;
	}
	public void setBoardRow(int boardRow) {
		this.boardRow = boardRow;
	}
	public int getBoardColumn() {
		return boardColumn;
	}
	public void setBoardColumn(int boardColumn) {
		this.boardColumn = boardColumn;
	}

}
