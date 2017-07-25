/**
 * 
 */
package com.aks.game.kalah;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author Amit Soni
 *
 */
@Component
@ApiModel(value = "KalahGame", description = "Kalah Game details.")
public class KalahGame {

	/**
	 * Kalah Game Board containing pits and stones.
	 */
	@ApiModelProperty(name = "KalahGameBoard", value = "Kalah Game Board details.")
	private KalahGameBoard gameBoard;
	/**
	 * First Player details.
	 */
	@ApiModelProperty(name = "Player1", value = "First Player's information.")
	private Player player1;
	/**
	 * Second player details.
	 */
	@ApiModelProperty(name = "Player2", value = "Secong Player's information.")
	private Player player2;
	/**
	 * Player refering to current turn.
	 */
	@ApiModelProperty(name = "currentPlayer", value = "Current Player's reference.")
	private Player currentPlayer;
	/**
	 * Location of the last stone dropped for current player's turn.
	 */
	@ApiModelProperty(name = "lastStoneDropLocation", value = "last stone drop location to decide another turn or capture the balls from other's kalah..")
	private int lastStoneDropLocation;
	/**
	 * Game State. Possible values are FINISHED,INPROGRESS and DRAW.
	 */
	@ApiModelProperty(name = "gameState", value = "Game status whether in progress or finished.")
	private GameState gameState;

	private Player winner;

	/**
	 * @return the winner
	 */
	public Player getWinner() {
		return winner;
	}

	/**
	 * @param winner
	 *            the winner to set
	 */
	public void setWinner(Player winner) {
		this.winner = winner;
	}

	/**
	 * @return the gameState
	 */
	public GameState getGameState() {
		return gameState;
	}

	/**
	 * @param gameState
	 *            the gameState to set
	 */
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	/**
	 * @return the lastStoneDropLocation
	 */
	public int getLastStoneDropLocation() {
		return lastStoneDropLocation;
	}

	/**
	 * @param lastStoneDropLocation
	 *            the lastStoneDropLocation to set
	 */
	public void setLastStoneDropLocation(int lastStoneDropLocation) {
		this.lastStoneDropLocation = lastStoneDropLocation;
	}

	/**
	 * @return the gameBoard
	 */
	public KalahGameBoard getGameBoard() {
		return gameBoard;
	}

	/**
	 * @param gameBoard
	 *            the gameBoard to set
	 */
	public void setGameBoard(KalahGameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	/**
	 * @return the player1
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * @param player1
	 *            the player1 to set
	 */
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	/**
	 * @return the player2
	 */
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * @param player2
	 *            the player2 to set
	 */
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	/**
	 * @return the currentPlayer
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * @param currentPlayer
	 *            the currentPlayer to set
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player getOtherPlayer(Player player) {
		if (player.getPlayerNumber() == 0) {
			return player2;
		} else {
			return player1;
		}
	}

}
