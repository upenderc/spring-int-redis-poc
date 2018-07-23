package com.uppi.poc;

public interface RedisChannelGateway {

	void enqueue(String msg);
}
