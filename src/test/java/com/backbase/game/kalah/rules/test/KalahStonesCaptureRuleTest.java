package com.backbase.game.kalah.rules.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.aks.game.KalahApplication;
import com.aks.game.kalah.GameState;
import com.aks.game.kalah.KalahGame;
import com.aks.game.kalah.KalahGameBoard;
import com.aks.game.kalah.Player;
import com.aks.game.kalah.rules.GameEndRule;
import com.aks.game.kalah.rules.MoveRule;
import com.aks.game.kalah.rules.StonesCaptureRule;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KalahApplication.class)

public class KalahStonesCaptureRuleTest {

	@Test
	public void testCaptureStones() {
		KalahGame game = new KalahGame();
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		board.getPits()[0].setStones(0);
		board.getPits()[1].setStones(1);
		board.getPits()[2].setStones(5);
		board.getPits()[3].setStones(4);
		board.getPits()[4].setStones(3);
		board.getPits()[5].setStones(2);
		board.getPits()[6].setStones(15);
		board.getPits()[7].setStones(2);
		board.getPits()[8].setStones(6);
		board.getPits()[9].setStones(1);
		board.getPits()[10].setStones(2);
		board.getPits()[11].setStones(5);
		board.getPits()[12].setStones(3);
		board.getPits()[13].setStones(18);

		game.setGameBoard(board);
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		game.setCurrentPlayer(p1);
		game.setLastStoneDropLocation(1);
		StonesCaptureRule stoneCaptureRule = new StonesCaptureRule();

		stoneCaptureRule.execute(game, 0);
		assertEquals(21, game.getGameBoard().getPits()[6].getStones());
	}
}
