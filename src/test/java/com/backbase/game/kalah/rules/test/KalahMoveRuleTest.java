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
import com.aks.game.kalah.rules.MoveRule;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KalahApplication.class)

public class KalahMoveRuleTest {

	@Test
	public void testMove() {
		KalahGame game = new KalahGame();
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		game.setGameBoard(board);
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		game.setCurrentPlayer(p1);
		MoveRule moveRule = new MoveRule();
		moveRule.execute(game, 0);
		assertEquals(game.getGameBoard().getPits()[0].getStones(), 0);
		assertEquals(game.getGameBoard().getPits()[1].getStones(), 7);
		assertEquals(game.getGameBoard().getPits()[5].getStones(), 7);
		assertEquals(game.getGameBoard().getPits()[6].getStones(), 1);
		assertEquals(game.getGameBoard().getPits()[7].getStones(), 6);
		assertEquals(game.getGameBoard().getPits()[13].getStones(), 0);
		assertEquals(game.getLastStoneDropLocation(), 6);
	}
}
