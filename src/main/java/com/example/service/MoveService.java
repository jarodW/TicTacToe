package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.CreateMoveDTO;
import com.example.dto.MoveDTO;
import com.example.enums.GameStatus;
import com.example.enums.GameType;
import com.example.enums.Piece;
import com.example.model.Game;
import com.example.model.Move;
import com.example.model.Player;
import com.example.model.Position;
import com.example.repository.MoveRepository;

@Service
@Transactional
public class MoveService {

    private final MoveRepository moveRepository;


    @Autowired
    public MoveService(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    public Move createMove(Game game, Player player, CreateMoveDTO createMoveDTO) {
        Move move = new Move();
        move.setBoardColumn(createMoveDTO.getBoardColumn());
        move.setBoardRow(createMoveDTO.getBoardRow());
        move.setCreated(new Date());
        move.setPlayer(player);
        move.setGame(game);

        moveRepository.save(move);

        return move;
    }

    public Move autoCreateMove(Game game) {
        Move move = new Move();
        Position pos = GameLogic.nextAutoMove(getBoard(game));
        System.out.println("pos" + pos.getCol() + "  " + pos.getRow());
        move.setBoardColumn(pos.getCol());
        move.setBoardRow(pos.getRow());
        move.setCreated(new Date());
        move.setPlayer(null);
        move.setGame(game);

        moveRepository.save(move);

        return move;
    }

    public GameStatus checkCurrentGameStatus(Game game) {
        if (GameLogic.isWinner(getBoard(game))) {
            return GameStatus.FIRST_PLAYER_WON;
        } else if (GameLogic.isWinner(getBoard(game))) {
            return GameStatus.SECOND_PLAYER_WON;
        } else if (GameLogic.isBoardIsFull(getTakenMovePositionsInGame(game))) {
            return GameStatus.TIE;
        } else if (game.getGameType() == GameType.COMPETITION && game.getSecondPlayer() == null ) {
            return GameStatus.WAITS_FOR_PLAYER;
        } else {
            return GameStatus.IN_PROGRESS;
        }

    }


    public List<MoveDTO> getMovesInGame(Game game) {

        List<Move> movesInGame = moveRepository.findByGame(game);
        List<MoveDTO> moves = new ArrayList<>();
        Piece currentPiece = game.getFirstPlayerPieceCode();

        for(Move move :  movesInGame) {
            MoveDTO moveDTO = new MoveDTO();
            moveDTO.setBoardColumn(move.getBoardColumn());
            moveDTO.setBoardRow(move.getBoardRow());
            moveDTO.setCreated(move.getCreated());
            moveDTO.setGameStatus(move.getGame().getGameStatus());
            moveDTO.setUserName(move.getPlayer() == null ? GameType.COMPUTER.toString() : move.getPlayer().getUserName() );
            moveDTO.setPlayerPiece(currentPiece);
            moves.add(moveDTO);

            currentPiece = currentPiece == Piece.X ? Piece.O : Piece.X;
        }

        return moves;
    }

    public List<Move> getTakenMovePositionsInGame(Game game) {
        return moveRepository.findByGame(game);
    }

    public int[][] getBoard(Game game) {
    	int[][] board = new int[3][3];
    	List<Move> movesInGame = moveRepository.findByGame(game);
        for(Move move :  movesInGame) {
            board[move.getBoardRow()-1][move.getBoardColumn()-1] = move.getPlayer() == game.getFirstPlayer() ? 1 :2;
        }
        return board;
    }
    
    public int getTheNumberOfPlayerMovesInGame(Game game, Player player) {
        return moveRepository.countByGameAndPlayer(game, player);
    }

    public boolean isPlayerTurn(Game game, Player firstPlayer, Player secondPlayer) {
        return GameLogic.playerTurn(getTheNumberOfPlayerMovesInGame(game, firstPlayer),
                getTheNumberOfPlayerMovesInGame(game, secondPlayer));
    }




}