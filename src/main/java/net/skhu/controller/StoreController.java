package net.skhu.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.skhu.domain.Manager;
import net.skhu.domain.ManagerDto;
import net.skhu.domain.Store;
import net.skhu.domain.StoreDto;
import net.skhu.domain.UploadFile;
import net.skhu.repository.ManagerRepository;
import net.skhu.repository.StoreRepository;
import net.skhu.repository.UserRepository;
import net.skhu.service.FileUploadDownloadService;

@RequestMapping("store")
@RestController
public class StoreController {
	@Autowired
	StoreRepository storeRepository;
	@Autowired
	ManagerRepository managerRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	private FileUploadDownloadService service;

	@RequestMapping("list")
	public List<Store> list(@RequestBody List<StoreDto> list) {
		List<Store> result = new ArrayList<Store>();
		for (StoreDto sto : list) {
			Store s = storeRepository.findByNameAndLatitudeAndLongitude(sto.getName(), sto.getLatitude(),
					sto.getLongitude());
			if (s == null) {
				storeRepository.save(new Store(sto.getName(), sto.getLatitude(), sto.getLongitude()));
				// result.add(storeRepository.findById(id).get());
				result.add(storeRepository.findByNameAndLatitudeAndLongitude(sto.getName(), sto.getLatitude(),
						sto.getLongitude()));
			} else
				result.add(s);
		}
		return result;

	}

//	@RequestMapping("addManager")
//	public void addManager(@RequestParam("photo") MultipartFile photo, @RequestParam("jsonFileVo") String jsonFileVo)
//			throws FileUploadException {
//		UploadFile uploadFile = service.storeFile(photo);
//	}

	@RequestMapping("addManager")
	public Manager addManager(@RequestParam("photo") MultipartFile photo,@RequestParam("jsonFileVo") String jsonFileVo) throws FileUploadException{
		UploadFile uploadFile = service.storeFile(photo);
		Manager manager = new Manager();
		ManagerDto m = null;
        try {
        	 m= new ObjectMapper().readValue(jsonFileVo, ManagerDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        manager.setId(m.getId());
        manager.setStore(storeRepository.findById(m.getStoreId()).get());
        manager.setUser(userRepository.findById(m.getUserId()).get());
        manager.setRegNum(m.getRegNum());
        manager.setPhoto(uploadFile);
		managerRepository.save(manager);
		return manager;
	}
}
