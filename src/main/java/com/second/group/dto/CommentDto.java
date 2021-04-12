package com.second.group.dto;

import lombok.Data;

@Data
public class CommentDto {
	private int cmtidx;
	private String cmtReply;
	private String cmtSecret;
	private String cmtContent;
	private String cmtDatetime;
	private String cmtDeletedYn;
	private int userUserIdx;
	private int recipeIdx;
}
