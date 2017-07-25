/**
 * 
 */
package com.aks.game.request;

/**
 * @author Amit Soni
 *
 */
public class StartGameRequest {

	private String player1Name;
	private String player2Name;
	private int numberOfPitsEachPlayer;
	private int numberOfStonesEachPit;
	/**
	 * @return the player1Name
	 */
	public String getPlayer1Name() {
		return player1Name;
	}
	/**
	 * @param player1Name the player1Name to set
	 */
	public void setPlayer1Name(String player1Name) {
		this.player1Name = player1Name;
	}
	/**
	 * @return the player2Name
	 */
	public String getPlayer2Name() {
		return player2Name;
	}
	/**
	 * @param player2Name the player2Name to set
	 */
	public void setPlayer2Name(String player2Name) {
		this.player2Name = player2Name;
	}
	/**
	 * @return the numberOfPitsEachPlayer
	 */
	public int getNumberOfPitsEachPlayer() {
		return numberOfPitsEachPlayer;
	}
	/**
	 * @param numberOfPitsEachPlayer the numberOfPitsEachPlayer to set
	 */
	public void setNumberOfPitsEachPlayer(int numberOfPitsEachPlayer) {
		this.numberOfPitsEachPlayer = numberOfPitsEachPlayer;
	}
	/**
	 * @return the numberOfStonesEachPit
	 */
	public int getNumberOfStonesEachPit() {
		return numberOfStonesEachPit;
	}
	/**
	 * @param numberOfStonesEachPit the numberOfStonesEachPit to set
	 */
	public void setNumberOfStonesEachPit(int numberOfStonesEachPit) {
		this.numberOfStonesEachPit = numberOfStonesEachPit;
	}
	
}
