/**
 * 
 */
package com.aks.game.kalah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aks.game.kalah.GameState;
import com.aks.game.kalah.KalahGame;
import com.aks.game.kalah.KalahGameBoard;
import com.aks.game.kalah.Player;
import com.aks.game.request.StartGameRequest;

/**
 * @author Amit Soni
 *
 */
@Service
public class KalahGameService {

	@Autowired
	private KalahGame game;

	public KalahGame startGame(StartGameRequest request) {
		KalahGameBoard board = new KalahGameBoard(request.getNumberOfPitsEachPlayer(),
				request.getNumberOfStonesEachPit());
		board.initialize();
		game.setGameBoard(board);
		Player player1 = new Player(request.getPlayer1Name(), 0);
		Player player2 = new Player(request.getPlayer2Name(), 1);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setCurrentPlayer(player1);
		game.setGameState(GameState.INPROGRESS);
		return game;
	}

	public KalahGame makeMove(KalahGame game, int chosenPit) {
		Player currentPlayer = game.getCurrentPlayer();
		currentPlayer.makeMove(game, chosenPit);
		return game;
	}

	public KalahGame resetGame(KalahGame game) {
		KalahGameBoard board = new KalahGameBoard(game.getGameBoard().getEachPlayerPits(),
				game.getGameBoard().getNoOfStonesInEachPit());
		board.initialize();
		game.setGameBoard(board);
		game.setCurrentPlayer(game.getPlayer1());
		game.setGameState(GameState.INPROGRESS);
		return game;
	}
}
