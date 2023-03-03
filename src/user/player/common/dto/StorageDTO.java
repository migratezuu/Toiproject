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
public class StorageDTO {

	private int ingreNo;
	private int ingreCnt;
	private String playerName;
	private String img;
}
