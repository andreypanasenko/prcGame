package org.wowapp.game.strategies;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.wowapp.game.GameMoveEnum;

public class NeuralNetworkGameStrategyTest {
	
	private IGameStrategy nn;

	@Before
	public void setUp() throws Exception {
		NeuralNetworkGameStrategyFactory factory = new NeuralNetworkGameStrategyFactory();
		nn = factory.getStrategy();
		
	}

	@Test
	public void testGetPlayerPrediction() {
		nn.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.PAPER);
		nn.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.PAPER);
		nn.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.PAPER);
		
		GameMoveEnum predict = nn.getPlayerPrediction();
		assertEquals(GameMoveEnum.PAPER, predict);
		
	}

}
