/**
 * 
 */
package com.aks.game.kalah;

import com.aks.game.kalah.rules.KalahGameRuleChain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class refers to a player.
 * 
 * @author Amit Soni
 *
 */
@ApiModel(value = "Player", description = "Player details.")
public class Player {
	@ApiModelProperty(name = "name", value = "Player's Name.")
	private String name;

	@ApiModelProperty(name = "playerNumber", value = "Player's number. Either 0 or 1. 0 is the first player, 1 is the second player")
	private int playerNumber;

	KalahGameRuleChain rulesChain = new KalahGameRuleChain();

	/**
	 * Default Constructor.
	 */
	public Player() {
		// empty constructor.
	}

	/**
	 * @param name
	 * @param playerNumber
	 */
	public Player(String name, int playerNumber) {
		this.name = name;
		this.playerNumber = playerNumber;
	}

	public void makeMove(KalahGame game, int chosenPit) {

		rulesChain.excecuteRules(game, chosenPit);

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the playerNumber
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}

	/**
	 * @param playerNumber
	 *            the playerNumber to set
	 */
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.playerNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Player) {
			return this.getPlayerNumber() == ((Player) obj).getPlayerNumber();
		}
		return false;
	}

}
