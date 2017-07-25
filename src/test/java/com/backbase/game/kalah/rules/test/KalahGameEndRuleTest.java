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

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KalahApplication.class)

public class KalahGameEndRuleTest {

	@Test
	public void testGameEndPlayer1() {
		KalahGame game = new KalahGame();
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		board.getPits()[0].setStones(0);
		board.getPits()[1].setStones(0);
		board.getPits()[2].setStones(0);
		board.getPits()[3].setStones(0);
		board.getPits()[4].setStones(0);
		board.getPits()[5].setStones(0);
		
		game.setGameBoard(board);
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		game.setCurrentPlayer(p1);
		GameEndRule gameEndRule = new GameEndRule();
		gameEndRule.execute(game, 0);
		assertEquals(game.getGameState(), GameState.FINISHED);
	}
	
	@Test
	public void testGameEndPlayer2() {
		KalahGame game = new KalahGame();
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		board.getPits()[7].setStones(0);
		board.getPits()[8].setStones(0);
		board.getPits()[9].setStones(0);
		board.getPits()[10].setStones(0);
		board.getPits()[11].setStones(0);
		board.getPits()[12].setStones(0);
		
		game.setGameBoard(board);
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		game.setCurrentPlayer(p2);
		GameEndRule gameEndRule = new GameEndRule();
		gameEndRule.execute(game, 0);
		assertEquals(game.getGameState(), GameState.FINISHED);
	}
	
	@Test
	public void testGameEndBothPlayers() {
		KalahGame game = new KalahGame();
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		board.getPits()[7].setStones(0);
		board.getPits()[8].setStones(0);
		board.getPits()[9].setStones(0);
		board.getPits()[10].setStones(0);
		board.getPits()[11].setStones(0);
		board.getPits()[12].setStones(0);
		
		board.getPits()[7].setStones(0);
		board.getPits()[8].setStones(0);
		board.getPits()[9].setStones(0);
		board.getPits()[10].setStones(0);
		board.getPits()[11].setStones(0);
		board.getPits()[12].setStones(0);
		
		game.setGameBoard(board);
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		game.setCurrentPlayer(p2);
		GameEndRule gameEndRule = new GameEndRule();
		gameEndRule.execute(game, 0);
		assertEquals(game.getGameState(), GameState.FINISHED);
	}
}
