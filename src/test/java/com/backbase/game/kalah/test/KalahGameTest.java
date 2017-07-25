/**
 * 
 */
package com.backbase.game.kalah.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.aks.game.KalahApplication;
import com.aks.game.kalah.KalahGame;
import com.aks.game.kalah.Player;

/**
 * @author Amit Soni
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KalahApplication.class)

public class KalahGameTest {

	@Test
	public void testGetOtherPlayer(){
		Player p1 = new Player("A", 0);
		Player p2 = new Player("B", 1);
		KalahGame game = new KalahGame();
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		assertEquals(game.getOtherPlayer(p1).getPlayerNumber(),1);
		assertEquals(game.getOtherPlayer(p2).getPlayerNumber(),0);
	}
}
