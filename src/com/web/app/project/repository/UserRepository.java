package com.web.app.project.repository;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;


import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.web.app.project.model.User;

@Repository("userRepository")
public class UserRepository extends AbstractRepository<User> {

//private Map<String, User> users = new HashMap<String, User>();
    
	@SuppressWarnings("unchecked")
    public List<User> getAll() {
        
		List<User> userlist = entityManager.createQuery("SELECT u FROM User u ORDER BY u.email").getResultList();

//		EntityManager entityManager = entityManagerFactory.createEntityManager();
	//	entityManager.getTransaction().begin();
		/*List<User> userlist = entityManager.createQuery( "from User", User.class ).getResultList();
		for ( User event : userlist ) {
		    System.out.println( "Event (" + event.getId() + ") : " + event.getUsername() );
		}
*/		
//		entityManager.getTransaction().commit();
//		entityManager.close();		

        return userlist;
        
    }

	public boolean validateCredentials(String email, String password) {

		boolean isValidCredentials = false;
		int userId = 0;
		
		if(email.isEmpty() || password.isEmpty())
		{
			isValidCredentials = false;
		}
		else
		{
			System.out.println("Email: ["+email+"]");
			System.out.println("Password: ["+password+"]");
			Query userByEmailByPassword = entityManager.createNamedQuery("User.findByEmailByPassword");
			userByEmailByPassword.setParameter("email", email);
			userByEmailByPassword.setParameter("password", password);
			User user = (User)userByEmailByPassword.getResultList().get(0);
			
			if(user!=null)
			{
			userId = user.getId();
			}
			
			System.out.println("UserID: ["+userId+"]");
			
			if(userId>0)
			{
				isValidCredentials = true;
			}
			else
			{
				isValidCredentials = false;
			}
		}
		
		return isValidCredentials;
	}	
	
	
}

