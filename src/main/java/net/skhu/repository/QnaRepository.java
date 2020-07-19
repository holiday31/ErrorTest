package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Qna;

public interface QnaRepository extends JpaRepository<Qna,Integer> {

	List<Qna> findByStoreId(int id);

}
