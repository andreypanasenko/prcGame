package org.wowapp.game.strategies;

import org.springframework.stereotype.Component;

@Component
public class RandGameStrategyFactory implements IGameStrategyFactory {

	@Override
	public IGameStrategy getStrategy() {
		return new RandGameStrategy();
	}

}
