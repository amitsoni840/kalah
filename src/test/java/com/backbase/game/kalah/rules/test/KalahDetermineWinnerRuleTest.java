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
import com.aks.game.kalah.rules.DetermineWinnerRule;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KalahApplication.class)

public class KalahDetermineWinnerRuleTest {

	@Test
	public void testDetremineWinnerPlayer1() {
		KalahGame game = new KalahGame();
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		board.getPits()[0].setStones(0);
		board.getPits()[1].setStones(0);
		board.getPits()[2].setStones(0);
		board.getPits()[3].setStones(0);
		board.getPits()[4].setStones(0);
		board.getPits()[5].setStones(0);
		board.getPits()[6].setStones(28);
		board.getPits()[7].setStones(0);
		board.getPits()[8].setStones(1);
		board.getPits()[9].setStones(0);
		board.getPits()[10].setStones(4);
		board.getPits()[11].setStones(4);
		board.getPits()[12].setStones(3);
		board.getPits()[13].setStones(25);

		game.setGameBoard(board);
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		game.setCurrentPlayer(p1);
		game.setLastStoneDropLocation(1);
		game.setGameState(GameState.FINISHED);
		DetermineWinnerRule determineWinnerRule = new DetermineWinnerRule();
		determineWinnerRule.execute(game, 0);
		assertEquals(0, game.getWinner().getPlayerNumber());
	}

	@Test
	public void testDetremineWinnerPlayer2() {
		KalahGame game = new KalahGame();
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		board.getPits()[13].setStones(28);
		board.getPits()[12].setStones(0);
		board.getPits()[11].setStones(0);
		board.getPits()[10].setStones(0);
		board.getPits()[9].setStones(0);
		board.getPits()[8].setStones(0);
		board.getPits()[7].setStones(1);
		board.getPits()[6].setStones(25);
		board.getPits()[5].setStones(1);
		board.getPits()[4].setStones(0);
		board.getPits()[3].setStones(4);
		board.getPits()[2].setStones(4);
		board.getPits()[1].setStones(3);
		board.getPits()[0].setStones(0);

		game.setGameBoard(board);
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		game.setCurrentPlayer(p2);
		game.setLastStoneDropLocation(1);
		game.setGameState(GameState.FINISHED);
		DetermineWinnerRule determineWinnerRule = new DetermineWinnerRule();
		determineWinnerRule.execute(game, 0);
		assertEquals(1, game.getWinner().getPlayerNumber());
	}

	@Test
	public void testDetremineGameDraw() {
		KalahGame game = new KalahGame();
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		board.getPits()[0].setStones(0);
		board.getPits()[1].setStones(0);
		board.getPits()[2].setStones(0);
		board.getPits()[3].setStones(0);
		board.getPits()[4].setStones(0);
		board.getPits()[5].setStones(0);
		board.getPits()[6].setStones(36);
		board.getPits()[7].setStones(0);
		board.getPits()[8].setStones(0);
		board.getPits()[9].setStones(0);
		board.getPits()[10].setStones(0);
		board.getPits()[11].setStones(0);
		board.getPits()[12].setStones(0);
		board.getPits()[13].setStones(36);

		game.setGameBoard(board);
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		game.setCurrentPlayer(p2);
		game.setLastStoneDropLocation(1);
		game.setGameState(GameState.FINISHED);
		DetermineWinnerRule determineWinnerRule = new DetermineWinnerRule();
		determineWinnerRule.execute(game, 0);
		assertEquals(GameState.DRAW, game.getGameState());
	}

}
