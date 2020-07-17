package net.skhu.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
    String name;
    double latitude;
    double longitude;

    @OneToMany(mappedBy="store")
    List<Review> reviews;

    public Store() {

    }

    public Store(String name,double latitude,double longitude) {
    	this.name=name;
    	this.latitude=latitude;
    	this.longitude=longitude;
    }



}
