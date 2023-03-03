package user.player.manager.service;

import static user.player.common.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import user.player.common.ManagerMapper;
import user.player.common.dto.IngreDTO;
import user.player.common.dto.RecipeDTO;
import user.player.common.dto.StoreDTO;

public class ManagerService {
	private ManagerMapper mapper;

	// 재료 관리
	public boolean createNewIngre(IngreDTO ingre) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		List<IngreDTO> ingreList = mapper.selectIngreByName(ingre);

		if (!ingreList.isEmpty()) {
			sqlSession.close();
			return false;
		}

		int result = mapper.insertNewIngre(ingre);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}

	public List<IngreDTO> findAllIngre(Map<String, Integer> ingrePage) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		List<IngreDTO> ingreList = mapper.selectAllIngre(ingrePage);

		sqlSession.close();

		return ingreList;
	}

	public boolean modifyIngre(Map<String, String> map) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		int result = mapper.modifyIngre(map);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}

	public boolean deleteIngre(Map<String, String> map) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		int result = mapper.deleteIngre(map);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}

	// 레시피 관리
	public boolean createNewRecipe(RecipeDTO recipe) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		List<RecipeDTO> recipeList = mapper.selectRecipeByName(recipe);

		if (!recipeList.isEmpty()) {
			sqlSession.close();
			return false;
		}

		int result = mapper.insertNewRecipe(recipe);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}

	public void createRecipeIngre(Map<String, String> recipeIngre) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		int result = mapper.insertRecipeIngre(recipeIngre);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

	}

	public List<RecipeDTO> findAllRecipe(Map<String, Integer> recipePage) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		List<RecipeDTO> recipeList = mapper.selectAllRecipe(recipePage);

		sqlSession.close();

		return recipeList;
	}

	public List<IngreDTO> findRecipeIngre(Map<String, String> recipeNo) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		List<IngreDTO> ingreList = mapper.selectRecipeIngre(recipeNo);

		sqlSession.close();

		return ingreList;
	}

	public boolean modifyRecipe(Map<String, String> map) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		int result = mapper.modifyRecipe(map);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}

	public void deleteRecipeIngre(Map<String, String> recipeIngre) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		int result = mapper.deleteRecipeIngre(recipeIngre);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

	}

	public boolean deleteRecipe(Map<String, String> map) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		int result = mapper.deleteRecipe(map);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}

	// 확장권 관리
	public boolean createNewStore(StoreDTO store) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		List<StoreDTO> recipeList = mapper.selectStoreByName(store);

		if (!recipeList.isEmpty()) {
			sqlSession.close();
			return false;
		}

		int result = mapper.insertNewStore(store);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}

	public List<StoreDTO> findAllStore(Map<String, Integer> storePage) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		List<StoreDTO> recipeList = mapper.selectAllStore(storePage);

		sqlSession.close();

		return recipeList;
	}

	public boolean modifyStore(Map<String, String> map) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		int result = mapper.modifyStore(map);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}

	public boolean deleteStore(Map<String, String> map) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ManagerMapper.class);

		int result = mapper.deleteStore(map);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}

}
