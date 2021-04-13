package com.second.group.dto;

import lombok.Data;

@Data
public class SecondUserDto {
	private int userIdx;
	private String userId;
	private String userPw;
	private String userAddr;
	private String userPhone;
	private String userGender;
	private char userLevel;
	private char userDeleteYn;
}
