package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.repository.StoreRepository;

@Service
public class StoreService {
	@Autowired
	StoreRepository storeRepository;

}
