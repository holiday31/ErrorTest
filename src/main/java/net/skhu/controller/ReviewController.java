package net.skhu.controller;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.skhu.domain.Review;
import net.skhu.domain.UploadFile;
import net.skhu.repository.ReviewRepository;
import net.skhu.service.FileUploadDownloadService;

@RestController
public class ReviewController {

	@Autowired
	private FileUploadDownloadService service;
	@Autowired
	private ReviewRepository reviewRepository;

	@RequestMapping("/review")
	public Review review(@RequestParam("photo") MultipartFile photo,@RequestParam("review") Review review) throws FileUploadException {
		UploadFile uploadFile = service.storeFile(photo);
		review.setPhoto(uploadFile);
		Review r=reviewRepository.save(review);
		return r;
	}
}
