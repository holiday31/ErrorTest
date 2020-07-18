package net.skhu.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Clean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int storeId;
	String cycle;
	String method;
	Date cleanDate;
	int useCompany;
	String companyName;
	String companyPhone;
	int photoId;
	String rule;
}
