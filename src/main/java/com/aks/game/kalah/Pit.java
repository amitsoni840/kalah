/**
 * 
 */
package com.aks.game.kalah;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class refers to a one pit in the game which can contains stones. Kalah
 * is also considered as a pit.
 * 
 * @author Amit Soni
 *
 */
@ApiModel(value = "Pit", description = "Pit containing stones")
public class Pit {

	/**
	 * number of stones in a pit.
	 */
	private int stones;

	/**
	 * Default Constructor.
	 */
	public Pit() {
		// empty constructor.
	}

	/**
	 * @param stones
	 */
	public Pit(int stones) {
		this.stones = stones;
	}

	/**
	 * @return the stones
	 */
	@ApiModelProperty(name = "stones", value = "number of stones in a pit.")
	public int getStones() {
		return stones;
	}

	/**
	 * @param stones
	 *            the stones to set
	 */
	public void setStones(final int stones) {
		this.stones = stones;
	}

	/**
	 * Method to check if a Pit is empty or not.
	 * 
	 * @return - boolean - True if empty, false if not empty.
	 */
	public boolean isEmpty() {
		return stones == 0;
	}

	/**
	 * This method empty the pit and return the number of counts to be captured.
	 * 
	 * @return int - Number of captured stones.
	 */
	public int captureStones() {
		int stonesToBeCaptures = this.stones;
		this.stones = 0;
		return stonesToBeCaptures;
	}

	/**
	 * This method is used to add stones in a pit.
	 * 
	 * @param stones
	 *            - int - number of stones to be added in a pit
	 */
	public void addStones(int stones) {
		this.stones = this.stones + stones;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return stones + " ";
	}

}
