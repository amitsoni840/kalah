package com.backbase.game.kalah.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.aks.game.KalahApplication;
import com.aks.game.kalah.Pit;

import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KalahApplication.class)

public class PitTest {

	@Test
	public void testPitIsEmpty() {
		Pit pit = new Pit(0);
		assertEquals(pit.getStones(), 0);
		assertEquals(pit.isEmpty(), true);
		
		Pit pit1 = new Pit(6);
		assertEquals(pit1.getStones(), 6);
		assertEquals(pit1.isEmpty(), false);
	}
	
	@Test
	public void testCaptureStones(){
		Pit pit = new Pit(6);
		assertEquals(pit.captureStones(),6);
		assertEquals(pit.getStones(), 0);
	}
}
