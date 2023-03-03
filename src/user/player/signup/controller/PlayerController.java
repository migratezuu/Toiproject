package user.player.signup.controller;

import java.util.Map;

import javax.swing.JFrame;

import user.player.common.dto.PlayerDTO;
import user.player.info.UserDeletePage;
import user.player.signup.service.PlayerService;

public class PlayerController {
	private PlayerService signService = new PlayerService();

	public boolean insertNewPlayer(Map<String, String> map) {

		PlayerDTO player = new PlayerDTO();
		player.setName(map.get("name"));
		player.setId(map.get("id"));
		player.setPass(map.get("pwd"));
		player.setEmail(map.get("email"));

		boolean isCreate = signService.insertNewPlayer(player);

		return isCreate;

	}

	public String findPwdByIdAndEmail(Map<String, String> map) {

		PlayerDTO player = signService.findPlayer(map);

		String message;

		if (player != null) {
			String pwd = "";
			for (int i = 0; i < player.getPass().length() / 2; i++) {
				pwd += player.getPass().charAt(i);
			}
			for (int i = player.getPass().length() / 2; i < player.getPass().length(); i++) {
				pwd += '*';
			}

			message = "당신의 비밀번호는 " + pwd + "입니다.";
		} else {
			message = "일치하는 비밀번호가 없습니다.";
		}

		return message;
	}

	public boolean findPlayer(Map<String, String> map) {

		PlayerDTO player = signService.findPlayer(map);

		boolean isFind;
		if (player == null) {
			isFind = true;
		} else {
			isFind = false;
		}

		return isFind;
	}

	public PlayerDTO loginPlayer(Map<String, String> map) {
		PlayerDTO player = signService.findPlayer(map);

		return player;
	}

	public void deletePlayer(PlayerDTO player, JFrame mf) {
		boolean isDelete = signService.deletePlayer(player);

		if (isDelete) {
			mf.dispose();
			new UserDeletePage();
		}

	}

}
