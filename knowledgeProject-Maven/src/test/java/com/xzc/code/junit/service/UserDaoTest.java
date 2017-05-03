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
	 * EasyMock��׼ʾ��
	 */
	@Test
	public void testFindUserBySid(){
		//replay�ؼ���֮ǰ������mock���󣬲��������mock����ķ��������ã�ͬʱ��������ϣ������������صĽ����
		//¼��
		EasyMock.expect(userDao.findBySid(1L)).andReturn(user1);//¼��һ�Σ�ֻ�ܵ���һ�Σ�
		EasyMock.replay(userDao);
		
		//����
		User bysid = userDao.findBySid(1L);
		System.out.println(bysid.toString());
		
		/*User bysid1 = userDao.findBySid(2L);
		assertNotNull(bysid1);
		System.out.println(bysid.toString());*/
		
		//�ط�¼�� ��֤
		assertNotNull(bysid);
		EasyMock.verify(userDao);
	}
	
	/**
	 * �ڶ���¼��
	 */
	@Test
	public void testFindUserBySid2(){
		//¼��
		userDao.findBySid(1L);
		EasyMock.expectLastCall().andReturn(user1);
		
		//����
		EasyMock.replay(userDao);
		User userbysid = userDao.findBySid(2L);
		//assertNotNull(userbysid);
		
		//�ط�¼��
		EasyMock.verify(userDao);
	}
}
