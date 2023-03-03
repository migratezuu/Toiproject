package user.player.common;

import java.util.List;
import java.util.Map;

import user.player.common.dto.IngreDTO;
import user.player.common.dto.RecipeDTO;
import user.player.common.dto.StoreDTO;

public interface ManagerMapper {

	// 재료 관리
	List<IngreDTO> selectIngreByName(IngreDTO ingre);

	int insertNewIngre(IngreDTO ingre);

	List<IngreDTO> selectAllIngre(Map<String, Integer> ingrePage);

	int modifyIngre(Map<String, String> map);

	int deleteIngre(Map<String, String> map);

	// 레시피 관리
	List<RecipeDTO> selectRecipeByName(RecipeDTO recipe);

	int insertNewRecipe(RecipeDTO recipe);

	int insertRecipeIngre(Map<String, String> recipeIngre);

	List<RecipeDTO> selectAllRecipe(Map<String, Integer> recipePage);

	List<IngreDTO> selectRecipeIngre(Map<String, String> recipeNo);

	int modifyRecipe(Map<String, String> map);

	int deleteRecipeIngre(Map<String, String> recipeIngre);

	int deleteRecipe(Map<String, String> map);

	// 확장권 관리
	List<StoreDTO> selectStoreByName(StoreDTO store);

	int insertNewStore(StoreDTO store);

	List<StoreDTO> selectAllStore(Map<String, Integer> storePage);

	int modifyStore(Map<String, String> map);

	int deleteStore(Map<String, String> map);

}
