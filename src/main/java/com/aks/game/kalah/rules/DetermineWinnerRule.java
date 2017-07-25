/**
 * 
 */
package com.aks.game.kalah.rules;

import com.aks.game.kalah.GameState;
import com.aks.game.kalah.KalahGame;
import com.aks.game.kalah.KalahGameBoard;

/**
 * This class defines the rule or logic to determine the winner of the game once
 * the game status is changed to finished.
 * 
 * @author Amit Soni
 *
 */
public class DetermineWinnerRule implements IRule {
	/**
	 * nextRule - to be exeucted after this rule.
	 */
	private IRule nextRule;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aks.game.kalah.rules.IRule#setNext(com.aks.game.kalah.rules
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
		KalahGameBoard board = game.getGameBoard();
		if (GameState.FINISHED.toString().equals(game.getGameState().toString())) {
			// Player having maximum stones in his kalah is the winner of the
			// game. if stones are equal for both players, then game is draw.
			if (board.getPits()[board.getKalah(game.getPlayer1())]
					.getStones() > board.getPits()[board.getKalah(game.getPlayer2())].getStones()) {
				game.setWinner(game.getPlayer1());
			} else if (board.getPits()[board.getKalah(game.getPlayer1())]
					.getStones() < board.getPits()[board.getKalah(game.getPlayer2())].getStones()) {
				game.setWinner(game.getPlayer2());
			} else {
				game.setGameState(GameState.DRAW);
			}
		} else if (this.nextRule != null) {
			nextRule.execute(game, chosenPit);
		}
	}

}
