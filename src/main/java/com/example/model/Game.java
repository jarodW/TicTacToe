package com.example.model;

import java.util.Date;

import javax.persistence.*;

import com.example.enums.GameStatus;
import com.example.enums.GameType;
import com.example.enums.Piece;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "second_player_id", nullable = true)
    private Player secondPlayer;

    @ManyToOne
    @JoinColumn(name = "first_player_id", nullable = false)
    private Player firstPlayer;

    @Enumerated(EnumType.STRING)
    private Piece firstPlayerPieceCode;

    @Enumerated(EnumType.STRING)
    private GameType gameType;

    @Enumerated(EnumType.STRING)
    private GameStatus gameStatus;

    @Column(name = "created", nullable = false)
    private Date created;

    public Game(){
    }
	public Game(Long id, Player secondPlayer, Player firstPlayer, Piece firstPlayerPieceCode, GameType gameType,
			GameStatus gameStatus, Date created) {
		this.id = id;
		this.secondPlayer = secondPlayer;
		this.firstPlayer = firstPlayer;
		this.firstPlayerPieceCode = firstPlayerPieceCode;
		this.gameType = gameType;
		this.gameStatus = gameStatus;
		this.created = created;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Player getSecondPlayer() {
		return secondPlayer;
	}
	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}
	public Player getFirstPlayer() {
		return firstPlayer;
	}
	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}
	public Piece getFirstPlayerPieceCode() {
		return firstPlayerPieceCode;
	}
	public void setFirstPlayerPieceCode(Piece firstPlayerPieceCode) {
		this.firstPlayerPieceCode = firstPlayerPieceCode;
	}
	public GameType getGameType() {
		return gameType;
	}
	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}
	public GameStatus getGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
}