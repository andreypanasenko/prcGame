package org.wowapp.game.strategies;

import org.springframework.stereotype.Component;

@Component
public class NeuralNetworkGameStrategyFactory implements IGameStrategyFactory {

	private static final int LEARN_ITERATION = 500;
	private static final int INPUTS = 3;
	private static final int HIDDEN = 4;
	private static final int OUTPUTS = 1;
	private static final double LEARN_RATE = 0.75;
	private static final double MOMENTUM = 0.75;
	
	private static final double PAPER = 0.0;
	private static final double ROCK = 0.5;
	private static final double SCISSORS = 1.0;
	
	private final NeuralNetwork referenceNetwork;
	
	public NeuralNetworkGameStrategyFactory() {
		referenceNetwork = new NeuralNetwork(INPUTS, HIDDEN, OUTPUTS, LEARN_RATE, MOMENTUM);
		learn();
	}
	
	@Override
	public IGameStrategy getStrategy() {
		return new NeuralNetworkGameStrategy(NeuralNetwork.cloneNeuralNetwork(referenceNetwork));
	}

	private void learn() {
		for(int i=0; i < LEARN_ITERATION; i++) {
			
			//constants patterns
			referenceNetwork.computeOutputs(new double[]{PAPER, PAPER, PAPER});
		    referenceNetwork.calcError(new double[]{PAPER});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{ROCK, ROCK, ROCK});
		    referenceNetwork.calcError(new double[]{ROCK});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{SCISSORS, SCISSORS, SCISSORS});
		    referenceNetwork.calcError(new double[]{SCISSORS});
		    referenceNetwork.learn();
	    
		    // periodic patterns
		    referenceNetwork.computeOutputs(new double[]{PAPER, ROCK, SCISSORS});
		    referenceNetwork.calcError(new double[]{PAPER});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{ROCK, SCISSORS, PAPER});
		    referenceNetwork.calcError(new double[]{ROCK});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{SCISSORS, PAPER, ROCK});
		    referenceNetwork.calcError(new double[]{SCISSORS});
		    referenceNetwork.learn();
		    
		    // small cycles
		    referenceNetwork.computeOutputs(new double[]{PAPER, ROCK, PAPER});
		    referenceNetwork.calcError(new double[]{ROCK});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{ROCK, PAPER, ROCK});
		    referenceNetwork.calcError(new double[]{PAPER});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{ROCK, SCISSORS, ROCK});
		    referenceNetwork.calcError(new double[]{SCISSORS});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{SCISSORS, ROCK, SCISSORS});
		    referenceNetwork.calcError(new double[]{ROCK});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{PAPER, SCISSORS, PAPER});
		    referenceNetwork.calcError(new double[]{SCISSORS});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{SCISSORS, PAPER, SCISSORS});
		    referenceNetwork.calcError(new double[]{PAPER});
		    referenceNetwork.learn();
		    
		    //Behavioral pattern
		    referenceNetwork.computeOutputs(new double[]{SCISSORS, SCISSORS, ROCK});
		    referenceNetwork.calcError(new double[]{PAPER});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{PAPER, PAPER, SCISSORS});
		    referenceNetwork.calcError(new double[]{ROCK});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{ROCK, ROCK, PAPER});
		    referenceNetwork.calcError(new double[]{SCISSORS});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{PAPER, ROCK, ROCK});
		    referenceNetwork.calcError(new double[]{SCISSORS});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{SCISSORS, ROCK, ROCK});
		    referenceNetwork.calcError(new double[]{PAPER});
		    referenceNetwork.learn();
		    
		    
		    referenceNetwork.computeOutputs(new double[]{SCISSORS, PAPER, PAPER});
		    referenceNetwork.calcError(new double[]{ROCK});
		    referenceNetwork.learn();
		    
		    referenceNetwork.computeOutputs(new double[]{SCISSORS, SCISSORS, PAPER});
		    referenceNetwork.calcError(new double[]{ROCK});
		    referenceNetwork.learn();
		}
	}
}
