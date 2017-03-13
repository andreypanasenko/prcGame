package org.wowapp.game.strategies;

/**
 * Interface used to gather all implemented strategies together
 */
public interface IGameStrategyFactory {
	IGameStrategy getStrategy();
}
