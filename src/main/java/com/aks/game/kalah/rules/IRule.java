package com.aks.game.kalah.rules;

import com.aks.game.kalah.KalahGame;

/**
 * This interface defines the contract for different rules applicable on the the
 * Kalah game. An interface has been defined so that each rule has its on
 * implementation clearly separated from the other rules (Single
 * Responsiblity).If a new rules to be added in the game, then another
 * implementation of this interface is needed (Open/Closed Principle).
 * 
 * @author Amit Soni
 *
 */
public interface IRule {

	/**
	 * Next rule to be executed after the execution of current rule.
	 * 
	 * @param rule
	 *            - next rule reference.
	 */
	public void setNext(IRule rule);

	/**
	 * Logic for different types of rules for the game.
	 * 
	 * @param game
	 *            - Game object.
	 * @param chosenPit
	 *            - index of the current move.
	 */
	public void execute(KalahGame game, int chosenPit);
}
