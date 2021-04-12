package com.second.group.dto;

import lombok.Data;

@Data
public class FileDto {
	private int fidx;
	private int boardIdx;
	private String fileName;
	private String storedFilePath;
	private int fileSize;
	private String createdId;
	private String createdDatetime;
	private String updatedId;
	private String deletedYn;
}
