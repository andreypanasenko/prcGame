package org.wowapp.game;

public interface IGameService {

	/**
	 * GameService turn method which log player turn and return computer turn
	 * @param playerThrow
	 * @param playerId
	 * @return computer Throw
	 */
	GameMoveEnum makeTurn(GameMoveEnum playerThrow, long playerId);
}
