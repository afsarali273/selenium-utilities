package com.baidu.qa.memcached;

public class Test {
	public static void main(String[] args) {
		MemcachedClientUtil util = new MemcachedClientUtil("172.0.0.1", 1111);
		util.get("memkey");
		util.close();
	}

}
