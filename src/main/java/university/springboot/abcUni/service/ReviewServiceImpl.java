package university.springboot.abcUni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.springboot.abcUni.dao.ReviewRepository;
import university.springboot.abcUni.entity.Review;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewServiceImpl implements ReviewService {

	// need to inject Review dao
	@Autowired
	private ReviewRepository reviewRepository;

	public ReviewServiceImpl(ReviewRepository theReviewRepository){
		reviewRepository = theReviewRepository;
	}

	@Override
	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

	@Override
	public Review findById(int theId) {
		Optional<Review> result = reviewRepository.findById(theId);
		Review theReview = null;
		if(result.isPresent()){
			theReview = result.get();
		}else{
			throw new RuntimeException("did not found idddd");
		}
		return theReview;
	}

	@Override
	public void deleteById(int theId) {
		reviewRepository.deleteById(theId);
	}

	@Override
	public void save(Review theReview) {reviewRepository.save(theReview);}

}
