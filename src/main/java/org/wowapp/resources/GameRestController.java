package org.wowapp.resources;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wowapp.game.GameMoveEnum;
import org.wowapp.game.IGameService;

@RestController
@RequestMapping("/game")
public class GameRestController {

	private final IGameService gameService;
	
	public GameRestController(IGameService gameService) {
		this.gameService = gameService;
	}
	
	@RequestMapping(value="/{playerId}", method=RequestMethod.POST)
	public GameMoveEnum turn(@NotNull @PathVariable Long playerId,
			@NotNull @RequestBody GameMoveEnum playerThrow) {
		return gameService.makeTurn(playerThrow, playerId);
	}
	
}
