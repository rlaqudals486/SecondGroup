package com.second.group.dto;

import lombok.Data;

@Data
public class SecondRecipeDto {
	public int idx;
	public String title;
	public String createdDatetime;
	public String ingredient;
	public String cooking;
	public String cookTime;
	public String cookComment;
	public String cookPoint;
	public String recipeDeletedYn;
	public String recipeCoverImg;
	public String recipeFilePath;
	public String userUserIdx;
	public int classificationClassCode;
	public String recommend;
}
