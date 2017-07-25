package com.backbase.game.kalah.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.aks.game.KalahApplication;
import com.aks.game.kalah.KalahGameBoard;
import com.aks.game.kalah.Player;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KalahApplication.class)
public class KalahGameBoardTest {

	@Test
	public void testInitialize() {
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();

		assertEquals(board.getPits().length, 14);
		assertEquals(board.getPits()[6].getStones(), 0);
		assertEquals(board.getPits()[13].getStones(), 0);
		assertEquals(board.getPits()[0].getStones(), 6);
		assertEquals(board.getPits()[7].getStones(), 6);
	}

	@Test
	public void testIsKalah() {
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		assertEquals(board.isKalah(0), false);
		assertEquals(board.isKalah(6), true);
		assertEquals(board.isKalah(13), true);
		assertEquals(board.isKalah(9), false);
	}

	@Test
	public void testGetKalahForPlayer() {
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		assertEquals(board.getKalah(p1), 6);
		assertEquals(board.getKalah(p2), 13);
	}

	@Test
	public void testIsMyPit() {
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		KalahGameBoard board = new KalahGameBoard(6, 6);
		board.initialize();
		assertEquals(board.isMyPit(p1, 0), true);
		assertEquals(board.isMyPit(p2, 8), true);
		assertEquals(board.isMyPit(p1, 13), false);
		assertEquals(board.isMyPit(p2, 1), false);
	}

}
