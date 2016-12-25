package com.baidu.qa.har;

import org.codehaus.jackson.annotate.JsonWriteNullProperties;

@JsonWriteNullProperties(value = false)
public class HarTimings {
	private Long blocked;
	private Long dns;
	private Long connect;
	private long send;
	private long wait;
	private long receive;

	public HarTimings() {
	}

	public HarTimings(Long blocked, Long dns, Long connect, long send, long wait, long receive) {
		this.blocked = blocked;
		this.dns = dns;
		this.connect = connect;
		this.send = send;
		this.wait = wait;
		this.receive = receive;
	}

	public Long getBlocked() {
		return blocked;
	}

	public void setBlocked(Long blocked) {
		this.blocked = blocked;
	}

	public Long getDns() {
		return dns;
	}

	public void setDns(Long dns) {
		this.dns = dns;
	}

	public Long getConnect() {
		return connect;
	}

	public void setConnect(Long connect) {
		this.connect = connect;
	}

	public long getSend() {
		return send;
	}

	public void setSend(long send) {
		this.send = send;
	}

	public long getWait() {
		return wait;
	}

	public void setWait(long wait) {
		this.wait = wait;
	}

	public long getReceive() {
		return receive;
	}

	public void setReceive(long receive) {
		this.receive = receive;
	}

	@Override
	public String toString() {
		return "HarTimings[blocked: " + blocked + " dns: " + dns + " connect: " + connect + " send: " + send + " wait: " + wait + " receive: " + receive + "]";
	}
}
