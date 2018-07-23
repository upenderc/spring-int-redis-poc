package com.uppi.poc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RedisRepoConfiguration.class)
public class RedisCacheStoreTest {

	/*@Autowired
	RedisChannelGateway eventChannelGateway;*/
	@Autowired
	private RedisTemplate<String, Person> redisTemplate;
	@Autowired
	private PersonRepository personRepository;
	private static final String KEY = "key-channel";
	@Test
	public void test() {
		Person person = new Person();
		person.setAge(10);
		person.setId(2);
		person.setName("Bala");
		/*eventChannelGateway.enqueue("spring-data-redis");*/
		 redisTemplate.opsForList().leftPush(KEY, person);
	}
	@Test
	public void persons() {
		Person person1 = new Person();
		person1.setAge(10);
		person1.setId(2);
		person1.setName("Bala");
		//person1.setExpiration(5l);
		person1.setStatus("INPROGRESS");
		Person person2 = new Person();
		person2.setAge(11);
		person2.setId(3);
		person2.setName("Upender");
		//person2.setExpiration(5l);
		person2.setStatus("INPROGRESS");
		//personRepository.save(Arrays.asList(person1,person2));
		Person pq=new Person();
		pq.setStatus("INPROGRESS");
		Iterable<Person> ps=personRepository.findAll();
		ps.forEach(System.out::println);
		//p.setStatus("PROGRESS");
		//personRepository.save(p);
		
		//personRepository.save(ps);
		
		/*eventChannelGateway.enqueue("spring-data-redis");*/
		 //redisTemplate.opsForList().range(KEY, 0, 2).stream().forEach(System.out::println);
	}
}

