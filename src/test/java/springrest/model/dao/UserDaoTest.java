package springrest.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import springrest.model.User;

@Test
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    UserDao userDao;

    @Test
    public void getUser()
    {
        assert userDao.getUser( 1L ).getUsername().equalsIgnoreCase( "admin" );
    }

    @Test
    public void getUsers()
    {
        assert userDao.getUsers().size() >= 2;
    }

    @Test
    public void saveUser()
    {
        User user = new User();
        user.setUsername( "john" );
        user.setPassword( "abcd" );
        user = userDao.saveUser( user );

        assert user.getId() != null;
    }

}
