/**
 * 
 */
package com.aks.game.kalah.rules;

import com.aks.game.kalah.KalahGame;

/**
 * This class follows the Chain of responsibility design pattern. It decides the
 * order in which rules needs to be executed.
 * 
 * @author Amit Soni
 *
 */
public class KalahGameRuleChain {

	/**
	 * This method executes all the rules on the current move of the player.
	 * 
	 * @param game
	 *            - Game object.
	 * @param chosenPit
	 *            - index of the current move.
	 */
	public void excecuteRules(KalahGame game, int chosenPit) {
		IRule validMoveRule = new ValidMoveRule();
		IRule moveRule = new MoveRule();
		IRule stonesCaptureRule = new StonesCaptureRule();
		IRule setCurrentPlayerRule = new SetCurrentPlayerRule();
		IRule gameEndRule = new GameEndRule();
		IRule determineWinneRule = new DetermineWinnerRule();
		validMoveRule.setNext(moveRule);
		moveRule.setNext(stonesCaptureRule);
		stonesCaptureRule.setNext(setCurrentPlayerRule);
		setCurrentPlayerRule.setNext(gameEndRule);
		gameEndRule.setNext(determineWinneRule);
		validMoveRule.execute(game, chosenPit);
	}
}
