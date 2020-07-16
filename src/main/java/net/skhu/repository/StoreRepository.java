package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {

	public Store findByNameAndLatitudeAndLongitude(String name,double Latitude,double longitude);

}
