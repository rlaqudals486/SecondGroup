package com.second.group.dto;

import lombok.Data;

@Data
public class RecipeDto {
	private int idx;
	private String title;
	private String createdDatetime;
	private String cooking;
	private String cookTime;
	private String cookComment;
	private String cookPoint;
	private char recipeDeletedYn;
	private String recipeCoverImg;
	private String recipeFilePath;
	private int userUserIdx;
}
