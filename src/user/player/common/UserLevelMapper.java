package user.player.common;

import user.player.common.dto.PlayerDTO;

public interface UserLevelMapper {

	String selectUserLevel(PlayerDTO player);

}
