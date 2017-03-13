package org.wowapp.game.strategies;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.wowapp.game.GameMoveEnum;

public class LinearPredictionGameStrategyTest {
	
	private IGameStrategy strategy;
	
	@Before
	public void init() {
		strategy = new LinearPredictionGameStrategy();
	}
	
	@Test
	public void testOnlyPaperPrediction() {
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		GameMoveEnum predicted = strategy.getPlayerPrediction();
		assertEquals(GameMoveEnum.PAPER, predicted);
	}
	
	@Test
	public void testOnlyRockPrediction() {
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		
		GameMoveEnum predicted = strategy.getPlayerPrediction();
		assertEquals(GameMoveEnum.ROCK, predicted);
	}
	
	@Test
	public void testOnlyScissorsPrediction() {
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		
		GameMoveEnum predicted = strategy.getPlayerPrediction();
		assertEquals(GameMoveEnum.SCISSORS, predicted);
	}
	
	@Test
	public void testPaperRockPeriodicPrediction() {
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		GameMoveEnum predicted = strategy.getPlayerPrediction();
		assertEquals(GameMoveEnum.PAPER, predicted);
	}
	
	@Test
	public void testRockScissorsPeriodicPrediction() {
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		
		GameMoveEnum predicted = strategy.getPlayerPrediction();
		assertEquals(GameMoveEnum.SCISSORS, predicted);
		
	}
	
	@Test
	public void testPaperScissorsPeriodicPrediction() {
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		
		GameMoveEnum predicted = strategy.getPlayerPrediction();
		assertEquals(GameMoveEnum.SCISSORS, predicted);
	}
	
	
	@Test
	public void testPeriodicPrediction() {
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		
		GameMoveEnum predicted = strategy.getPlayerPrediction();
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		predicted = strategy.getPlayerPrediction();
		assertEquals(GameMoveEnum.SCISSORS, predicted);
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		predicted = strategy.getPlayerPrediction();
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		predicted = strategy.getPlayerPrediction();
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		predicted = strategy.getPlayerPrediction();
		assertEquals(GameMoveEnum.SCISSORS, predicted);
	}

	@Test
	public void testLogPlayerTurn() {
		strategy.logPlayerTurn(GameMoveEnum.SCISSORS, GameMoveEnum.ROCK);
		assertEquals(0.5, strategy.getAveragError(), 0.0);
		strategy.logPlayerTurn(GameMoveEnum.ROCK, GameMoveEnum.ROCK);
		assertEquals(0.75, strategy.getAveragError(), 0.0);
		strategy.logPlayerTurn(GameMoveEnum.PAPER, GameMoveEnum.ROCK);
		assertEquals(0.5, strategy.getAveragError(), 0.0);
	}

}
