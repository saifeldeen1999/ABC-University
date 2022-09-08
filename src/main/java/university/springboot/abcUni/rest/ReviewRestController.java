package university.springboot.abcUni.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import university.springboot.abcUni.entity.Course;
import university.springboot.abcUni.entity.Department;
import university.springboot.abcUni.entity.Review;
import university.springboot.abcUni.service.CourseService;
import university.springboot.abcUni.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewRestController {


	private ReviewService reviewService;
	private CourseService courseService;

	@Autowired
	public ReviewRestController(ReviewService theReviewService,CourseService theCourseService) {
		reviewService = theReviewService;
		courseService = theCourseService;
	}
	
	@GetMapping("reviews")
	public List<Review> findAll(){
		return reviewService.findAll();
	}
	
	@GetMapping("reviews/{reviewId}")
	public Review findById(@PathVariable int reviewId){
		Review review = reviewService.findById(reviewId);
		if(review == null) {
			throw new RuntimeException("ID:" + reviewId + " not found");
		}
		return review;
	}
	
	@PostMapping("reviews")
	public Review addReview(@RequestBody Review review){
		review.setId(0);
		reviewService.save(review);
		 return review;
	}
	
	@PutMapping("reviews")
	public Review updateReview(@RequestBody Review review){
		reviewService.save(review);
		 return review;
	}
	
	@DeleteMapping("reviews/{reviewId}")
	public String deleteById(@PathVariable int reviewId){
		Review review = reviewService.findById(reviewId);
		if(review == null) {
			throw new RuntimeException("ID:" + reviewId + " not found");
		}
		reviewService.deleteById(reviewId);
		return "Deleted review id #" + reviewId;
	}

	@PutMapping("{courseId}/reviews/{reviewId}")
	public String addReviewToCourse(@PathVariable int reviewId, @PathVariable int courseId){
		Review review = reviewService.findById(reviewId);
		Course course = courseService.findById(courseId);

		review.setCourse(course);
		reviewService.save(review);
		return "Review successfully added to Course: "+course.getName();
	}
}
