package university.springboot.abcUni.service;

import university.springboot.abcUni.entity.Course;
import university.springboot.abcUni.entity.Review;

import java.util.List;

public interface ReviewService {

	public List<Review> findAll();
	
	public Review findById(int theId);
	
	public void deleteById(int theId);
	
	public void save(Review theReview);
	
}
