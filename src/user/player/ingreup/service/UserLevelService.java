package user.player.ingreup.service;

import static user.player.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import user.player.common.UserLevelMapper;
import user.player.common.dto.PlayerDTO;

public class UserLevelService {

	private UserLevelMapper mapper;
	
	public String findUserLevel(PlayerDTO player) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(UserLevelMapper.class);
		
		String string = mapper.selectUserLevel(player);

		sqlSession.close();

		return string;
	}

}
