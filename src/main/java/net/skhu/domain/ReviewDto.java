package net.skhu.domain;

import lombok.Data;

@Data
public class ReviewDto {

	int id;
	Store store;
	String userId;
	String text;
	float score;
//    UploadFile photo;

//    @JsonIgnore
//    private MultipartFile file;
}
