package com.example.model;

public class Position {
    private int boardRow;
    private int boardColumn;
    public Position(){
    	
    }
    public Position(int boardRow, int boardColumn){
    	this.boardRow = boardRow;
    	this.boardColumn = boardColumn;
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