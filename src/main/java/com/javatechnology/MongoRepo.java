package com.javatechnology;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo extends MongoRepository<Login, Long>{
	
}
