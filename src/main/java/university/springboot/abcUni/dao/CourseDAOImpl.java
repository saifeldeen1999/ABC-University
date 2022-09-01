package university.springboot.abcUni.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import university.springboot.abcUni.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	private SessionFactory sessionFactory;


	@Override
	public List<Course> findAll() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Course> theQuery = currentSession.createQuery("from Course order by lastName",Course.class);
		
		// execute query and get result list
		List<Course> courses = theQuery.getResultList();
				
		// return the results		
		return courses;
	}

	@Override
	public Course findById(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Course theCourse = currentSession.get(Course.class, theId);
		
		return theCourse;
	}

	@Override
	public void deleteById(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Course where id=:courseId");
		theQuery.setParameter("courseId", theId);
		
		theQuery.executeUpdate();

	}

	@Override
	public void save(Course theCourse) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the course ... finally LOL
		currentSession.saveOrUpdate(theCourse);

	}

}
