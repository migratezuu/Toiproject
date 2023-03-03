package user.player.realplay.controller;

import java.util.List;

import user.player.common.dto.PlayerDTO;
import user.player.common.dto.RecipeIngreDTO;
import user.player.realplay.service.PlayService;

public class PlayController {
	
	private final PlayService playService;
	
	public PlayController() {
		this.playService = new PlayService();
	}

	public List<RecipeIngreDTO> searchRecipeByRandomRecipeCode(PlayerDTO player) {
		List<RecipeIngreDTO> playRecipeList = playService.searchRecipeByRandomRecipeCode(player);
		
		if(playRecipeList != null) {
			System.out.println(playRecipeList);
		}else {
			System.out.println("No");
		}
		return playRecipeList;
	}
	
//	
}
