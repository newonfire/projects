package decision.drools;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import decision.drools.model.User;
import decision.drools.service.UserService;

public class UserTest extends Tester {

	@Resource
	private UserService userService;

	@Test
	@Rollback(false)
	public void test() {
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("bbb");
		userService.save(user);

	}
}
