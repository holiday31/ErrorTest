package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.skhu.domain.Review;
import net.skhu.domain.ReviewDto;
import net.skhu.domain.UploadFile;
import net.skhu.exception.FileUploadException;
import net.skhu.repository.ReviewRepository;
import net.skhu.repository.StoreRepository;
import net.skhu.service.FileUploadDownloadService;

@RestController
public class ReviewController {

	@Autowired
	private FileUploadDownloadService service;
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private StoreRepository storeRepository;

	@RequestMapping("/review")
	public Review review(@RequestParam("photo") MultipartFile photo,@RequestParam("jsonFileVo") String jsonFileVo) throws FileUploadException, org.apache.tomcat.util.http.fileupload.FileUploadException {
		UploadFile uploadFile = service.storeFile(photo);
		Review review = new Review();
		ReviewDto rd = null;
        try {
        	 rd= new ObjectMapper().readValue(jsonFileVo, ReviewDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        review.setUserId(rd.getUserId());
        review.setStore(storeRepository.findById(rd.getStore().getId()).get());
        review.setText(rd.getText());
        review.setScore(rd.getScore());
		review.setPhoto(uploadFile);
		Review r=reviewRepository.save(review);
		return r;
}

//		UploadFile uploadFile = service.storeFile(photo);
//		Review review1 =null;
//		Review review2 =null;
//        try {
//        	 review1= new ObjectMapper().readValue(jsonFileVo, Review.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        review2.setUserId(review1.getUserId());
//        review2.setStore(storeRepository.findById(review1.getStore().getId()).get());
//        review2.setText(review1.getText());
//        review2.setScore(review1.getScore());
//		review2.setPhoto(uploadFile);
//		reviewRepository.save(review2);
//		return review2;

}


