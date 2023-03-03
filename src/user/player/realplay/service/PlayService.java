package user.player.realplay.service;

import static user.player.common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import user.player.common.RealPlayMapper;
import user.player.common.dto.PlayerDTO;
import user.player.common.dto.RecipeIngreDTO;

public class PlayService {

	private RealPlayMapper mapper;
	
	public List<RecipeIngreDTO> searchRecipeByRandomRecipeCode(PlayerDTO player) {
		SqlSession sqlSession = getSqlSession();
	
		RealPlayMapper realPlayMapper = sqlSession.getMapper(RealPlayMapper.class);
		
		List<RecipeIngreDTO> playRecipeList = realPlayMapper.searchRecipeByRandomRecipeCode(player);
		sqlSession.close();
		
		return playRecipeList;
		
	}
	
}
 