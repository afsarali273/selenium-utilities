package com.baidu.qa.morphia;

import java.net.UnknownHostException;

import com.mongodb.MongoException;

public class MorphiaDaoTest {
	public static void main(String[] args) throws UnknownHostException, MongoException {
		MorphiaDao test = new MorphiaDao();
		test.getDatastore("", 32100, "");
	}

}
