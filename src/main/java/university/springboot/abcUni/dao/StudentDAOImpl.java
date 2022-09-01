package university.springboot.abcUni.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import university.springboot.abcUni.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	private EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	
	@Override
	public List<Student> findAll() {
		
		//get current status of db
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create query to get students from db
		Query<Student> theQuery = currentSession.createQuery("from Student",Student.class);
		
		//save the results in students to be returned 
		List<Student> students = theQuery.getResultList();
		return students;
	}


	@Override
	public Student findById(int theId) {
		
		//get current status of db
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get student by id 
		Student theStudent = currentSession.get(Student.class, theId);
		
		//return the student object
		return theStudent;
	}


	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from theStudent where id=:studentId");
		theQuery.setParameter("studentId", theId);
		theQuery.executeUpdate();
		
	}


	@Override
	public void save(Student theStudent) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theStudent);
	}

}
