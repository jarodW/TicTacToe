package com.example.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(name = "board_row", nullable = false)
    private int boardRow;

    @Column(name = "board_column", nullable = false)
    private int boardColumn;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = true)
    private Player player;

    @Column(name = "created", nullable = false)
    private Date created;
    
    public Move(){
    }
    
	public Move(int id, Game game, int boardRow, int boardColumn, Player player, Date created) {
		this.id = id;
		this.game = game;
		this.boardRow = boardRow;
		this.boardColumn = boardColumn;
		this.player = player;
		this.created = created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}