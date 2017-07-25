/**
 * 
 */
package com.aks.game.kalah.rules;

import com.aks.game.kalah.GameState;
import com.aks.game.kalah.KalahGame;
import com.aks.game.kalah.KalahGameBoard;

/**
 * This class defines rules to decide whether the the game is ended or not.
 * 
 * @author Amit Soni
 *
 */
public class GameEndRule implements IRule {

	private IRule nextRule;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aks.game.kalah.rules.IRule#setNext(com.aks.game.kalah.rules
	 * .IRule)
	 */
	@Override
	public void setNext(IRule rule) {
		nextRule = rule;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aks.game.kalah.rules.IRule#execute(com.aks.game.kalah.
	 * KalahGame, int)
	 */
	@Override
	public void execute(KalahGame game, int chosenPit) {
		int player1Stones = 0;
		int player2Stones = 0;
		KalahGameBoard board = game.getGameBoard();
		int eachPlayerPits = board.getEachPlayerPits();

		// Count stones for both players in their pits. if any or both of the
		// player's total is 0 , that means no more moves left. In that case
		// empty the pits and moves the stones to respective player's Kalah.
		for (int i = 0; i < eachPlayerPits; i++) {
			player1Stones = player1Stones + board.getPits()[i].getStones();
			player2Stones = player2Stones + (board.getPits()[(eachPlayerPits + 1) + i].getStones());
		}
		if (player1Stones == 0 && player2Stones == 0) {
			game.setGameState(GameState.FINISHED);
		} else if (player1Stones == 0) {
			board.getPits()[board.getKalah(game.getPlayer2())].addStones(player2Stones);
			game.setGameState(GameState.FINISHED);
			for (int i = 0; i < eachPlayerPits; i++) {
				board.getPits()[(eachPlayerPits + 1) + i].captureStones();
			}
			// capture player 2 stones to his kalah
		} else if (player2Stones == 0) {
			// capture player1 stones to his kalah
			board.getPits()[board.getKalah(game.getPlayer1())].addStones(player1Stones);
			game.setGameState(GameState.FINISHED);
			for (int i = 0; i < eachPlayerPits; i++) {
				board.getPits()[i].captureStones();
			}
		}
		if (nextRule != null) {
			nextRule.execute(game, chosenPit);
		}
	}

}
