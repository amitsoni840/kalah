/**
 * 
 */
package com.aks.game.kalah.rules;

import com.aks.game.kalah.InvalidMoveException;
import com.aks.game.kalah.KalahGame;

/**
 * This class defines conditions to check whether the player's has made a right
 * move, otherwise user needs to try again.
 * 
 * @author Amit Soni
 *
 */
public class ValidMoveRule implements IRule {

	private IRule nextRule;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aks.game.kalah.rules.IRule#execute(com.aks.game.kalah.
	 * KalahGameBoard, int)
	 */
	@Override
	public void execute(final KalahGame game, final int chosenPit) {

		if (game.getGameBoard().getPits()[chosenPit].getStones() != 0
				&& game.getCurrentPlayer().getPlayerNumber() == chosenPit
						/ (game.getGameBoard().getEachPlayerPits() + 1)
				&& !game.getGameBoard().isKalah(chosenPit) && chosenPit < game.getGameBoard().getPits().length) {
			if (nextRule != null) {
				nextRule.execute(game, chosenPit);
			}
		} else {
			throw new InvalidMoveException(-10, "Invalid Move");
		}
	}

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

}
