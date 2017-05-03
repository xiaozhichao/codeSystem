package com.xzc.code.junit.service;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xzc.code.junit.entity.User;

import junit.framework.TestCase;
/**
 * 
 **************************************************
 * ClassName:UserDaoTest
 * @Description:TODO
 * @author:xiaozhichao
 * @date:2017-5-3
 **************************************************
 */
public class UserDaoTest extends TestCase {
	
	private UserDao userDao;
	private User user1;
    private User user2;
	/**
	 * 
	 * @Description:TODO
	 * @param:
	 * @return:void
	 * @throws
	 * @author:xiaozhichao 
	 * @date:2017-5-3
	 */
	 
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass");
	}
	@Test
	public void test(){
		System.out.println("test");
	}
	@Before
	public void setUp(){
		System.out.println("setUp");
		userDao = EasyMock.createMock(UserDao.class);
		user1 = new User();
        user1.setSid(1L);
        user1.setAge(11);
        user1.setName("test1");
        user1.setSex(1);

        user2 = new User();
        user2.setSid(2L);
        user2.setAge(22);
        user2.setName("test2");
        user2.setSex(2);
	}
	/**
	 * EasyMock标准示例
	 */
	@Test
	public void testFindUserBySid(){
		//replay关键字之前：创建mock对象，并期望这个mock对象的方法被调用，同时给出我们希望这个方法返回的结果。
		//录制
		EasyMock.expect(userDao.findBySid(1L)).andReturn(user1);//录制一次，只能调用一次！
		EasyMock.replay(userDao);
		
		//测试
		User bysid = userDao.findBySid(1L);
		System.out.println(bysid.toString());
		
		/*User bysid1 = userDao.findBySid(2L);
		assertNotNull(bysid1);
		System.out.println(bysid.toString());*/
		
		//回放录制 验证
		assertNotNull(bysid);
		EasyMock.verify(userDao);
	}
	
	/**
	 * 第二种录制
	 */
	@Test
	public void testFindUserBySid2(){
		//录制
		userDao.findBySid(1L);
		EasyMock.expectLastCall().andReturn(user1);
		
		//测试
		EasyMock.replay(userDao);
		User userbysid = userDao.findBySid(2L);
		//assertNotNull(userbysid);
		
		//回放录制
		EasyMock.verify(userDao);
	}
}
