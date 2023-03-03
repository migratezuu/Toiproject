package user.player.common;

import java.util.Map;

import user.player.common.dto.PlayerDTO;
import user.player.common.dto.PlayerRecipeDTO;

public interface PlayerMapper {

	int insertNewPlayer(PlayerDTO player);

	int insertPlayerRecipe(PlayerRecipeDTO pr);

	int insertPlayerStore(PlayerDTO player);

	int insertPlayerIngre(PlayerDTO player);

	PlayerDTO selectPlayer(Map<String, String> map);

	int deletePlayer(PlayerDTO player);

}
