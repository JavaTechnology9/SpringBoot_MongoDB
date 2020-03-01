package com.javatechnology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
@Repository
public class MongoDaoImpl implements MongoDao{
	@Autowired
	private MongoRepo repo;
	@Autowired
	private MongoOperations mongoOperation;
	@Override
	public Login save(Login login) {
		login.setSeq(getSequenceNextId(login.SEQUENCE_NAME));
		return repo.save(login);
	}

	private long getSequenceNextId(String sequenceName) {
		Query query = new Query(Criteria.where("_id").is(sequenceName));
		Update update = new Update();
		  update.inc("seq", 1);
		  FindAndModifyOptions options = new FindAndModifyOptions();
		  options.returnNew(true);
		  Login login=mongoOperation.findAndModify(query, update, options, Login.class);
		  return login.getSeq();
		  
	}

	
}
