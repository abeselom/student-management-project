package vn.csc.webapp.serviceImplTest;

import org.junit.Assert;
import org.junit.Test;

import vn.csc.webapp.serviceImpl.UserServiceImpl;

public class UserServiceImplTest {
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	@Test
	public void testGetUserList() {
		Assert.assertEquals(2, userServiceImpl.getUserList().size());
	}

	@Test
	public void testGetUserByName() {
		Assert.assertEquals("admin", userServiceImpl.getUserByName("admin").getUsername());
	}

	@Test
	public void testUserExisted() {
		Assert.assertEquals(true, userServiceImpl.userExisted("admin"));
		Assert.assertEquals(false, userServiceImpl.userExisted("abc"));
	}

	@Test
	public void testLogIn() {
		Assert.assertEquals(true, userServiceImpl.LogIn("admin", "123456"));
		Assert.assertEquals(false, userServiceImpl.LogIn("admin", "adfsadfs"));
	}
}
