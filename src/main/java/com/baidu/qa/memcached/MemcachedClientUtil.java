package com.baidu.qa.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

/**
 * MemcachedClient
 * 
 * @author liangxiaowu
 * 
 */
public class MemcachedClientUtil {
	private MemcachedClient client = null;

	/**
	 * 
	 * 
	 * @param ip
	 *            10.81.22.103
	 * @param port
	 *            11234
	 */
	public MemcachedClientUtil(String ip, int port) {
		try {
			client = new MemcachedClient(new InetSocketAddress(ip, port));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * @param key
	 *            String type
	 * @param value
	 *            must implements Serializable interface
	 */
	public void set(String key, Object value) {
		client.set(key, 3600, value);
	}

	/**
	 * ֵ
	 * 
	 * @param key
	 *            String type
	 * @return Object type
	 */
	public Object get(String key) {
		return client.get(key);
	}

	/**
	 * shutdown memcached client
	 */
	public void close() {
		client.shutdown();
	}
}
