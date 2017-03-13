package org.wowapp.game.strategies;

import org.springframework.stereotype.Component;

@Component
public class LinearPredictionGameStrategyFactory implements IGameStrategyFactory {

	@Override
	public IGameStrategy getStrategy() {
		return new LinearPredictionGameStrategy();
	}

}
