/**
 * 
 */
package com.backbase.game.kalah.rules.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.aks.game.KalahApplication;
import com.aks.game.kalah.KalahGame;
import com.aks.game.kalah.KalahGameBoard;
import com.aks.game.kalah.Player;
import com.aks.game.kalah.rules.SetCurrentPlayerRule;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KalahApplication.class)

public class KalahSetCurrentPlayerRuleTest {

	@Test
	public void testSetCurrentPlayer() {
		KalahGame game = new KalahGame();
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		game.setCurrentPlayer(p1);
		game.setGameBoard(board);
		game.setLastStoneDropLocation(6);

		SetCurrentPlayerRule currentPlayerRule = new SetCurrentPlayerRule();
		currentPlayerRule.execute(game, 0);
		assertEquals(game.getCurrentPlayer().getPlayerNumber(), 0);
	}

	@Test
	public void testSetOtherPlayerTurn() {
		KalahGame game = new KalahGame();
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		game.setCurrentPlayer(p1);
		game.setGameBoard(board);
		game.setLastStoneDropLocation(6);

		SetCurrentPlayerRule currentPlayerRule = new SetCurrentPlayerRule();
		currentPlayerRule.execute(game, 1);
		assertEquals(1, game.getPlayer2().getPlayerNumber());
	}

}
