package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Clean;

public interface CleanRepository extends JpaRepository<Clean,Integer>{

	Clean findByStoreId(int storeId);

}
