package net.skhu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Store;
import net.skhu.domain.StoreDto;
import net.skhu.repository.StoreRepository;

@RequestMapping("store")
@RestController
public class StoreController {
	@Autowired
	StoreRepository storeRepository;

	@RequestMapping("list")
	public List<Store> list(@RequestBody List<StoreDto> list) {
		List<Store> result = new ArrayList<Store>();
		for (StoreDto sto : list) {
			Store s = storeRepository.findByNameAndLatitudeAndLongitude(sto.getName(), sto.getLatitude(),
					sto.getLongitude());
			if (s == null) {
				storeRepository.save(new Store(sto.getName(), sto.getLatitude(), sto.getLongitude()));
				//result.add(storeRepository.findById(id).get());
				result.add(storeRepository.findByNameAndLatitudeAndLongitude(sto.getName(), sto.getLatitude(),
						sto.getLongitude()));
			} else
				result.add(s);
		}
		return result;

	}
}
