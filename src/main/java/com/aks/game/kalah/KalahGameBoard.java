/**
 * 
 */
package com.aks.game.kalah;

import java.util.Arrays;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author Amit Soni
 *
 */
@ApiModel(value = "KalahGameBoard", description = "This contains properties of Kalah Game Board. i.e number of pits or stones in a pit.")
public class KalahGameBoard {

	@ApiModelProperty(value = "eachPlayerPits", name = "Number of Pits for each player.")
	private int eachPlayerPits;

	@ApiModelProperty(value = "noOfStonesInEachPit", name = "Number of stones in each pit.")
	private int noOfStonesInEachPit;

	@ApiModelProperty(value = "pits", name = "Array of pits including each player's kalah.")
	private Pit[] pits;

	/**
	 * Empty Constructor.
	 */
	public KalahGameBoard() {
		// default constructor.
	}

	/**
	 * Constructor to create KalahBoard from eachPlayerPits and
	 * noOfStonesInEachPit properties.
	 * 
	 * @param eachPlayerPits
	 * @param noOfStonesInEachPit
	 */
	public KalahGameBoard(int eachPlayerPits, int noOfStonesInEachPit) {
		this.eachPlayerPits = eachPlayerPits;
		this.noOfStonesInEachPit = noOfStonesInEachPit;
	}

	/**
	 * @return the eachPlayerPits
	 */
	public int getEachPlayerPits() {
		return eachPlayerPits;
	}

	/**
	 * @return the noOfStonesInEachPit
	 */
	public int getNoOfStonesInEachPit() {
		return noOfStonesInEachPit;
	}

	/**
	 * @return the pits
	 */
	public Pit[] getPits() {
		return pits;
	}

	/**
	 * Method to initialize a KalahGameBoard.
	 */
	public void initialize() {
		pits = new Pit[(eachPlayerPits * 2) + 2];
		for (int i = 0; i < pits.length; i++) {
			Pit pit = new Pit(0);
			pits[i] = pit;
			if (!isKalah(i)) {
				pits[i].setStones(noOfStonesInEachPit);
			}
		}
	}

	/**
	 * This function checks pitNumber is a player's Kalah or not.
	 * 
	 * @param pitNumber
	 *            - Integer pit number
	 * @return boolean - True or False , True if pit is a Kalah and False if
	 *         not.
	 */
	public boolean isKalah(int pitNumber) {
		if (pitNumber == eachPlayerPits || pitNumber == eachPlayerPits * 2 + 1) {
			return true;
		}
		return false;
	}

	/**
	 * This function returns array index of a player's kalah.
	 * 
	 * @param player
	 *            - {@link Player}
	 * @return int - array index of kalah in array of pits.
	 */
	public int getKalah(Player player) {
		if (player.getPlayerNumber() == 0) {
			return eachPlayerPits;
		} else {
			return eachPlayerPits * 2 + 1;
		}
	}

	/**
	 * This method checks whether the pitNumber belongs to this player or not.
	 * 
	 * @param player
	 *            - {@link Player}
	 * @param pitNumber
	 *            - int , index of pit array.
	 * @return
	 */
	public boolean isMyPit(Player player, int pitNumber) {
		if (Math.abs(pitNumber / (eachPlayerPits + 1)) == player.getPlayerNumber()) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "KalahGameBoard [eachPlayerPits=" + eachPlayerPits + ", pits=" + Arrays.toString(pits) + "]";
	}

}
