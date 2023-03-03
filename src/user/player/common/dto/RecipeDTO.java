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
public class RecipeDTO {

	private int no;
	private String name;
	private int recipePrice;
	private int foodPrice;
	private int exp;
	
}
