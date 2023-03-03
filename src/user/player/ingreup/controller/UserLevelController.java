package user.player.ingreup.controller;

import user.player.common.dto.PlayerDTO;
import user.player.ingreup.service.UserLevelService;

public class UserLevelController {
	
	private UserLevelService UserLevelService = new UserLevelService();
	
	public String findUserLevel(PlayerDTO player) {

		String string = UserLevelService.findUserLevel(player);

		return string;

	}
}

