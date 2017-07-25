/**
 * 
 */
package com.aks.game.kalah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aks.game.kalah.InvalidMoveException;
import com.aks.game.kalah.KalahGame;
import com.aks.game.kalah.service.KalahGameService;
import com.aks.game.request.StartGameRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This class contains Rest API's to play the Kalah Game
 * 
 * @author Amit Soni
 *
 */
@Api(value = "/kalah", description = "This Api allows to start and play a Kalah game.")
@RestController
@RequestMapping("/kalah")
public class KalahRestController {

	@Autowired
	KalahGameService gameService;

	/**
	 * API to start & initialize the game.
	 * 
	 * @param startGameRequest
	 *            - {@link StartGameRequest}
	 * @return {@link KalahGame} - Returns the response containing updated Game
	 *         board as per current action.
	 */
	@ApiOperation(value = "/start", notes = "This api is used to start the game.", response = KalahGame.class)
	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public ResponseEntity<KalahGame> startGame(@RequestBody StartGameRequest startGameRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(gameService.startGame(startGameRequest));
	}

	/**
	 * This API will make a move onto the the current Kalah game board as per
	 * the pit chosed by the current player.
	 * 
	 * @param kalahGame
	 *            - {@link KalahGame}
	 * @param pitIdToMove
	 *            - Int Pit ID chosen to make a move.
	 * @return {@link KalahGame} - Returns the response containing updated Game
	 *         board as per current action.
	 */
	@ApiOperation(value = "/move/{pitIdToMove}", notes = "This api is used to make a move in the game.", response = KalahGame.class)
	@RequestMapping(value = "/move/{pitIdToMove}", method = RequestMethod.POST)
	public ResponseEntity<KalahGame> makeMove(@RequestBody KalahGame kalahGame, @PathVariable int pitIdToMove) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(gameService.makeMove(kalahGame, pitIdToMove));
		} catch (InvalidMoveException ime) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(kalahGame);
		}
	}

	/**
	 * This API is used to reset a game if a user wants to leave the game and
	 * start a new.
	 * 
	 * @param kalahGame
	 *            - {@link KalahGame}
	 * @return {@link KalahGame} - Returns the current game object containing
	 *         Game board ,game status , players etc.
	 */
	@ApiOperation(value = "/reset", notes = "This api is used to reset a game.", response = KalahGame.class)
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public ResponseEntity<KalahGame> resetGame(@RequestBody KalahGame kalahGame) {
		return ResponseEntity.status(HttpStatus.OK).body(gameService.resetGame(kalahGame));
	}
}
