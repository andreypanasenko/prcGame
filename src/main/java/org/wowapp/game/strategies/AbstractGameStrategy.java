package org.wowapp.game.strategies;

import java.util.LinkedList;

import org.wowapp.game.GameMoveEnum;

/**
 * Abstract strategy, handle game history and calculates particular 
 * strategy prediction error.
 */
public abstract class AbstractGameStrategy implements IGameStrategy {

	private static final int ERROR_TURNS = 4; //number of last turns used to calculate error
	
	private static final int MAX_HISTORY = 10;
	
	protected LinkedList<GameTurnContainer> history;
	
	private double accumulatedError;
	protected double averageError;
	private int errorCount;
	protected GameMoveEnum predicted;
	
	protected AbstractGameStrategy() {
		accumulatedError = 0.0;
		averageError = 0.0;
		errorCount = 0;
		history = new LinkedList<>();
		predicted = null;
	}
	
	@Override
	public double getAveragError() {
		return averageError;
	}

	@Override
	abstract public GameMoveEnum getPlayerPrediction();

	@Override
	public void logPlayerTurn(GameMoveEnum playerThrow, GameMoveEnum computerThrow) {
		if (predicted == null) {
			predicted = getPlayerPrediction();
		}
		GameTurnContainer container = new GameTurnContainer(playerThrow, computerThrow, predicted);
		accumulatedError += container.getError();
		errorCount++;
		if (history.size() >= ERROR_TURNS) {
			accumulatedError -= history.get(ERROR_TURNS -1).getError();
			errorCount--;
		}
		history.addFirst(container);
		if (history.size() > MAX_HISTORY) {
			history.removeLast();
		}
		averageError = accumulatedError / errorCount;
		predicted = null;
	}

}
