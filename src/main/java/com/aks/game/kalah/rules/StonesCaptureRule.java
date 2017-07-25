/**
 * 
 */
package com.aks.game.kalah.rules;

import com.aks.game.kalah.KalahGame;
import com.aks.game.kalah.KalahGameBoard;

/**
 * This class defines rule to capture the stones of other player. If last stone
 * of current player's move falls in the player's empty pit, then all stones
 * from the opposite pit of other player's are captured and moved to current
 * player's kalah.
 * 
 * @author Amit Soni
 *
 */
public class StonesCaptureRule implements IRule {

	private IRule nextRule;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aks.game.kalah.rules.IRule#setNext(com.aks.game.kalah.rules
	 * .IRule)
	 */
	@Override
	public void setNext(final IRule rule) {
		nextRule = rule;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aks.game.kalah.rules.IRule#execute(com.aks.game.kalah.
	 * KalahGame, int)
	 */
	@Override
	public void execute(final KalahGame game, final int chosenPit) {
		KalahGameBoard board = game.getGameBoard();
		if (isLastStoneDroppedInPlayerEmptyPit(game, board)
				&& board.getKalah(game.getCurrentPlayer()) != game.getLastStoneDropLocation()) {

			int currentPlayerKalah = board.getKalah(game.getCurrentPlayer());
			board.getPits()[currentPlayerKalah].addStones(
					board.getPits()[(board.getPits().length - 2) - game.getLastStoneDropLocation()].captureStones());
			board.getPits()[currentPlayerKalah]
					.addStones(board.getPits()[game.getLastStoneDropLocation()].captureStones());
		}
		if (nextRule != null) {
			nextRule.execute(game, chosenPit);
		}
	}

	/**
	 * This method return true of false based on if current player's last stone
	 * fall in player's empty pit. Player's Kalah is not cosidered.
	 * 
	 * @param game
	 *            - {@link KalahGame}
	 * @param board
	 *            - {@link KalahGameBoard}
	 * @return - True or False
	 */
	private boolean isLastStoneDroppedInPlayerEmptyPit(final KalahGame game, KalahGameBoard board) {
		return board.isMyPit(game.getCurrentPlayer(), game.getLastStoneDropLocation())
				&& board.getPits()[game.getLastStoneDropLocation()].getStones() == 1;
	}

}
