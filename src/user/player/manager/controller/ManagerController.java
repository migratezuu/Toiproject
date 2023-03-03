package user.player.manager.controller;

import java.util.List;
import java.util.Map;

import user.player.common.dto.IngreDTO;
import user.player.common.dto.RecipeDTO;
import user.player.common.dto.StoreDTO;
import user.player.manager.service.ManagerService;

public class ManagerController {

	private ManagerService managerService = new ManagerService();

	// 재료 관리
	public String createNewIngre(Map<String, String> map) {

		IngreDTO ingre = new IngreDTO();
		ingre.setName(map.get("name"));
		ingre.setPrice(Integer.parseInt(map.get("price")));
		ingre.setImg(map.get("img"));

		boolean isCreate = managerService.createNewIngre(ingre);

		String msg;
		if (isCreate) {
			msg = "재료가 등록 됐습니다.";
		} else {
			msg = "이미 있는 재료입니다.";
		}

		return msg;
	}

	public List<IngreDTO> findAllIngre(Map<String, Integer> ingrePage) {

		List<IngreDTO> ingreList = managerService.findAllIngre(ingrePage);

		return ingreList;

	}

	public String modifyIngre(Map<String, String> map) {

		boolean isModify = managerService.modifyIngre(map);

		String messge;
		if (isModify) {
			messge = "정보가 수정되었습니다.";
		} else {
			messge = "정보를 수정할 수 없습니다.";
		}

		return messge;
	}

	public String deleteIngre(Map<String, String> map) {
		boolean isDelete = managerService.deleteIngre(map);

		String messge;
		if (isDelete) {
			messge = "재료가 삭제되었습니다.";
		} else {
			messge = "재료를 삭제할 수 없습니다.";
		}

		return messge;
	}

	// 레시피 관리
	public String createNewRecipe(Map<String, String> map) {

		RecipeDTO recipe = new RecipeDTO();
		recipe.setName(map.get("name"));
		recipe.setRecipePrice(Integer.parseInt(map.get("recipePrice")));
		recipe.setFoodPrice(Integer.parseInt(map.get("foodPrice")));
		recipe.setExp(Integer.parseInt(map.get("exp")));

		boolean isCreate = managerService.createNewRecipe(recipe);

		String msg;
		if (isCreate) {
			msg = "레시피가 등록 됐습니다.";
		} else {
			msg = "이미 있는 레시피입니다.";
		}

		return msg;
	}

	public void createRecipeIngre(Map<String, String> recipeIngre) {
		managerService.createRecipeIngre(recipeIngre);

	}

	public List<RecipeDTO> findAllRecipe(Map<String, Integer> recipePage) {

		List<RecipeDTO> recipeList = managerService.findAllRecipe(recipePage);

		return recipeList;
	}

	public List<IngreDTO> findRecipeIngre(Map<String, String> recipeNo) {

		List<IngreDTO> ingreList = managerService.findRecipeIngre(recipeNo);

		return ingreList;

	}

	public String modifyRecipe(Map<String, String> map) {

		boolean isModify = managerService.modifyRecipe(map);

		String messge;
		if (isModify) {
			messge = "정보가 수정되었습니다.";
		} else {
			messge = "정보를 수정할 수 없습니다.";
		}

		return messge;
	}

	public void deleteRecipeIngre(Map<String, String> recipeIngre) {
		managerService.deleteRecipeIngre(recipeIngre);

	}

	public String deleteRecipe(Map<String, String> map) {
		boolean isDelete = managerService.deleteRecipe(map);

		String messge;
		if (isDelete) {
			messge = "레시피가 삭제되었습니다.";
		} else {
			messge = "레시피를 삭제할 수 없습니다.";
		}

		return messge;
	}

	// 가게 관리
	public String createNewStore(Map<String, String> map) {

		StoreDTO store = new StoreDTO();
		store.setLevel(Integer.parseInt(map.get("level")));
		store.setName(map.get("name"));
		store.setPrice(Integer.parseInt(map.get("price")));
		store.setMaxRecipe(Integer.parseInt(map.get("maxRecipe")));
		store.setExp(Integer.parseInt(map.get("exp")));

		boolean isCreate = managerService.createNewStore(store);

		String msg;
		if (isCreate) {
			msg = "가게 정보가 등록 됐습니다.";
		} else {
			msg = "이미 있는 가게입니다.";
		}

		return msg;
	}

	public List<StoreDTO> findAllStore(Map<String, Integer> storePage) {

		List<StoreDTO> recipeList = managerService.findAllStore(storePage);

		return recipeList;
	}

	public String modifyStore(Map<String, String> map) {

		boolean isModify = managerService.modifyStore(map);

		String messge;
		if (isModify) {
			messge = "가게 정보가 수정되었습니다.";
		} else {
			messge = "가게 정보를 수정할 수 없습니다.";
		}

		return messge;
	}

	public String deleteStore(Map<String, String> map) {
		boolean isDelete = managerService.deleteStore(map);

		String messge;
		if (isDelete) {
			messge = "가게 정보가 삭제되었습니다.";
		} else {
			messge = "가게 정보를 삭제할 수 없습니다.";
		}

		return messge;
	}

}
