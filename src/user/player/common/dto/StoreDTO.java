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
public class StoreDTO {

	private int level;
	private String name;
	private int price;
	private int maxRecipe;
	private int exp;

}
