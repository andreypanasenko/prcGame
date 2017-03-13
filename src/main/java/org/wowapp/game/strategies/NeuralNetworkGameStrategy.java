package org.wowapp.game.strategies;

import org.wowapp.game.GameMoveEnum;

/**
 * Simple neural network strategy
 * Use 3 input neurons and one output
 * input neurons is 3 last history player throws
 * Reference networks trained against simple periodic and behavior patterns
 * And cloned for every new Player.
 */
public class NeuralNetworkGameStrategy extends AbstractGameStrategy {

	private final NeuralNetwork neuralNetwork; 
	
	public NeuralNetworkGameStrategy(NeuralNetwork neuralNetwork) {
		this.neuralNetwork = neuralNetwork;
	}
	
	@Override
	public String getStrategyName() {
		return "NeuralNetwork Strategy";
	}

	@Override
	public GameMoveEnum getPlayerPrediction() {
		predicted = fromDouble(neuralNetwork.computeOutputs(makeInputs(0)));
		return predicted;
	}
	
	@Override
	public void logPlayerTurn(GameMoveEnum playerThrow, GameMoveEnum computerThrow) {
		super.logPlayerTurn(playerThrow, computerThrow);
		neuralNetwork.calcError(new double[] {fromGameMoveEnum(playerThrow)});
		neuralNetwork.learn();
	}
	
	private double[] makeInputs(int offset) {
		return new double[] {
				history.size() > offset ?
						fromGameMoveEnum(history.get(offset).getPlayer()) : 
							fromGameMoveEnum(GameMoveEnum.ROCK),
				history.size() > (offset + 1) ?
						fromGameMoveEnum(history.get(offset + 1).getPlayer()) : 
							fromGameMoveEnum(GameMoveEnum.ROCK),
				history.size() > (offset + 2) ?
						fromGameMoveEnum(history.get(offset + 2).getPlayer()) : 
							fromGameMoveEnum(GameMoveEnum.ROCK),
		};
	}
	
	private double fromGameMoveEnum(GameMoveEnum gameThrow) {
		return gameThrow.getValue() / 2.0;
	}
	
	private GameMoveEnum fromDouble(double[] output) {
		return GameMoveEnum.fromValue((int)Math.round(output[0] * 2.0));
	}

}
