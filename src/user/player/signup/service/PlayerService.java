package user.player.signup.service;

import static user.player.common.Template.getSqlSession;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import user.player.common.PlayerMapper;
import user.player.common.dto.PlayerDTO;
import user.player.common.dto.PlayerRecipeDTO;

public class PlayerService {

	private PlayerMapper mapper;

	public boolean insertNewPlayer(PlayerDTO player) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(PlayerMapper.class);

		boolean isCreate;

		int result1 = mapper.insertNewPlayer(player);
		int result2 = 0;
		int result3;
		int result4;

		PlayerRecipeDTO pr = new PlayerRecipeDTO();
		pr.setPlayerName(player.getName());

		int[] recipe = new int[] {
				1, 4, 6, 12
		};

		if (result1 > 0) {
			for (int i = 0; i < recipe.length; i++) {
				pr.setRecipeNo(recipe[i]);
				result2 += mapper.insertPlayerRecipe(pr);
			}
			if (result2 >= recipe.length) {
				result3 = mapper.insertPlayerStore(player);
				result4 = mapper.insertPlayerIngre(player);
				if (result3 > 0 && result4 > 0) {
					sqlSession.commit();
					isCreate = true;
				} else {
					sqlSession.rollback();
					isCreate = false;
				}
			} else {
				sqlSession.rollback();
				isCreate = false;
			}
		} else {
			sqlSession.rollback();
			isCreate = false;
		}
		sqlSession.close();

		return isCreate;
	}

	public PlayerDTO findPlayer(Map<String, String> map) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(PlayerMapper.class);

		PlayerDTO player = mapper.selectPlayer(map);

		sqlSession.close();

		return player;
	}

	public boolean deletePlayer(PlayerDTO player) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(PlayerMapper.class);

		int result = mapper.deletePlayer(player);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}
}
