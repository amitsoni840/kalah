/**
 * 
 */
package com.aks.game.kalah.rules;

import com.aks.game.kalah.KalahGame;

/**
 * This class defines rule/logic to decide next turn for a player.
 * 
 * @author Amit Soni
 *
 */
public class SetCurrentPlayerRule implements IRule {
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
		if (game.getGameBoard().getKalah(game.getCurrentPlayer()) != game.getLastStoneDropLocation()) {
			game.setCurrentPlayer(game.getOtherPlayer(game.getCurrentPlayer()));
		}
		if (nextRule != null) {
			nextRule.execute(game, chosenPit);
		}
	}

}
