package net.skhu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@OneToOne
	@JoinColumn(name = "userId")
	User user;

	@OneToOne
	@JoinColumn(name = "storeId")
	Store store;

	String regNum;

	@OneToOne
	@JoinColumn(name = "photoId")
	UploadFile photo;
}
