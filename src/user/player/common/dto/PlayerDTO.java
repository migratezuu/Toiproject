package user.player.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PlayerDTO {

	private String name;
	private String id;
	private String pass;
	private String email;
	private int gold;
	private int exp;

}
