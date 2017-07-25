/**
 * 
 */
package com.aks.game.kalah.rules;

import com.aks.game.kalah.KalahGame;
import com.aks.game.kalah.KalahGameBoard;

/**
 * This class contains logic for distributing the stones in the pits and
 * kalah.Stone needs to be emptied from current chosen Pit and needs to be
 * distributed in anticlockwise direction to all pits leaving other player's
 * Kalah.
 * 
 * @author Amit Soni
 *
 */
public class MoveRule implements IRule {

	/**
	 * Next rule to be executed.
	 */
	private IRule nextRule;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aks.game.kalah.rules.IRule#execute(com.aks.game.kalah.
	 * KalahGame, int)
	 */
	@Override
	public void execute(KalahGame game, int chosenPit) {
		KalahGameBoard board = game.getGameBoard();
		int stones = board.getPits()[chosenPit].getStones();
		board.getPits()[chosenPit].setStones(0);
		int currentPitNum = chosenPit;
		while (stones != 0) {
			currentPitNum++;
			if (currentPitNum > board.getPits().length - 1) {
				currentPitNum = 0;
			}
			if (currentPitNum != board.getKalah(game.getOtherPlayer(game.getCurrentPlayer()))) {
				board.getPits()[currentPitNum].addStones(1);
				stones--;
			}
		}
		game.setLastStoneDropLocation(currentPitNum);
		if (nextRule != null) {
			nextRule.execute(game, chosenPit);
		}

	}

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

}
