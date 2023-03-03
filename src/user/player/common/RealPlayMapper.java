package user.player.common;

import java.util.List;

import user.player.common.dto.PlayerDTO;
import user.player.common.dto.RecipeIngreDTO;


public interface RealPlayMapper {

	List<RecipeIngreDTO> searchRecipeByRandomRecipeCode(PlayerDTO player);
	
}
