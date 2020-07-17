package net.skhu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "storeId")
    Store store;

	String userId;
	String text;
	float score;

    @OneToOne
    @JoinColumn(name = "photo")
    UploadFile photo;
}
