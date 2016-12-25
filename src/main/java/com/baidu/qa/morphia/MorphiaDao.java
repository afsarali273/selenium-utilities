package com.baidu.qa.morphia;

import java.net.UnknownHostException;
import java.util.List;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * mongoDb
 * 
 * @author liangxiaowu
 * 
 * @param <T>
 */
public class MorphiaDao<T> {
	private Mongo mongo;
	private Morphia morphia;

	public Datastore getDatastore(String host, int port, String dbName) throws UnknownHostException, MongoException {
		mongo = new Mongo(host, port);
		morphia = new Morphia();
		return morphia.createDatastore(mongo, dbName);
	}

	public Datastore getDatastore(String host, int port, String dbName, String user, char[] pw) throws UnknownHostException, MongoException {
		mongo = new Mongo(host, port);
		morphia = new Morphia();
		return morphia.createDatastore(mongo, dbName, user, pw);
	}

	public void save(Datastore ds, Iterable<T> arg) throws Exception {
		ds.save(arg);
	}

	@SuppressWarnings("rawtypes")
	public List queryList(Datastore ds, Class<T> clazz) throws Exception {
		return ds.find(clazz).asList();
	}

	@SuppressWarnings("unchecked")
	public Object getByObjectId(Datastore ds, Class clazz, String objectId) throws Exception {
		return ds.get(clazz, objectId);
	}
}
