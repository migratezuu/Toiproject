package user.player.common;

import java.util.List;
import java.util.Map;

import user.player.common.dto.IngreDTO;
import user.player.common.dto.PlayerDTO;
import user.player.common.dto.RecipeDTO;
import user.player.common.dto.StorageDTO;

public interface IngreMapper {

	int insertNewIngre(IngreDTO ingre);

	List<StorageDTO> selectAllingre(PlayerDTO player);
	
	public List<RecipeDTO> selectAllrecipe(Map<String, String> map);

	
}