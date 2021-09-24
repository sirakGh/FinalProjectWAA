package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Review;
import edu.miu.ecommerce.repository.ReviewDAO;
import edu.miu.ecommerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewDAO reviewDAO;

    @Override
    public List<Review> getAllReviews() {
        return reviewDAO.findAll();
    }

    @Override
    public Review getReviewById(long id) {
        return reviewDAO.findById(id).get();
    }

    @Override
    public Review approveReview(long id) {
        Review review = getReviewById(id);
        review.setApproved(true);
        return reviewDAO.save(review);
    }
}
