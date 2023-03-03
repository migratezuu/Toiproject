package user.player.ingreup.service;

import static user.player.common.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import user.player.common.IngreMapper;
import user.player.common.dto.IngreDTO;
import user.player.common.dto.PlayerDTO;
import user.player.common.dto.RecipeDTO;
import user.player.common.dto.StorageDTO;

public class IngreService {

	private IngreMapper mapper;

	public boolean insertNewIngre(IngreDTO ingre) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(IngreMapper.class);

		int result = mapper.insertNewIngre(ingre);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;

	}

	public List<StorageDTO> findAllingre(PlayerDTO player) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(IngreMapper.class);

		List<StorageDTO> ingreList = mapper.selectAllingre(player);

		sqlSession.close();

		return ingreList;

	}

		public List<RecipeDTO> findAllrecipe(Map<String, String> map) {

			SqlSession sqlSession = getSqlSession();
			mapper = sqlSession.getMapper(IngreMapper.class);

			List<RecipeDTO> recipeList = mapper.selectAllrecipe(map);

			sqlSession.close();

			return recipeList;

		}

	}