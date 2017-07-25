package com.backbase.game.kalah.rules.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.aks.game.KalahApplication;
import com.aks.game.kalah.InvalidMoveException;
import com.aks.game.kalah.KalahGame;
import com.aks.game.kalah.KalahGameBoard;
import com.aks.game.kalah.Player;
import com.aks.game.kalah.rules.ValidMoveRule;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KalahApplication.class)

public class KalahValidMoveRuleTest {

	@Test
	public void testValidMove() {
		KalahGame game = new KalahGame();
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		game.setGameBoard(board);
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		game.setCurrentPlayer(p1);
		ValidMoveRule validMoveRule = new ValidMoveRule();
		validMoveRule.execute(game, 0);
	}

	@Test(expected = InvalidMoveException.class)
	public void testInvalidValidMove() {
		KalahGame game = new KalahGame();
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		game.setGameBoard(board);
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		game.setCurrentPlayer(p2);
		ValidMoveRule validMoveRule = new ValidMoveRule();
		validMoveRule.execute(game, 4);
	}
}
