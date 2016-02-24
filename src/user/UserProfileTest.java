package user;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class UserProfileTest {

	private UserProfile user;

	@Before
	public void setUp() throws Exception {
		user = new UserProfile("gangus", "password");
	}

	@Test
	public void testUserProfile1() {
		
		System.out.println(user.getPassword());
		assertEquals("password", user.getPassword());

	}
}
