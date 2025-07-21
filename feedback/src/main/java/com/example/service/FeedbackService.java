package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CustomerDTO;
import com.example.dto.FeedbackRepository;
import com.example.dto.FeedbackRequest;
import com.example.dto.ProductDTO;
import com.example.entity.Feedback;
import com.example.feignclient.CustomerClient;
import com.example.feignclient.ProductClient;

@Service
public class FeedbackService {
 
    @Autowired
    private FeedbackRepository feedbackRepository;
 
    @Autowired
    private CustomerClient customerClient;
 
    @Autowired
    private ProductClient productClient;
 
   
////    public Feedback addFeedback(Long customerId, Long productId, String feedbackContent) {
////       
//        CustomerDTO customer = customerClient.getCustomerById(customerId);
//        if (customer == null) {
//            throw new RuntimeException("Customer not found");
//        }
// 
//      
////        ProductDTO product = productClient.getProductById(productId);
////        if (product == null) {
////            throw new RuntimeException("Product not found");
////        }
//        public Feedback addFeedback(Long customerId, Long productId, String feedbackContent) {
//        	CustomerDTO customer = customerClient.getCustomerById(customerId);
//            if (customer == null) {
//                throw new RuntimeException("Customer not found");
//            }
//     
//            if (productId == null) {
//                throw new IllegalArgumentException("Product ID cannot be null");
//            }
//
//            ProductDTO product = productClient.getProductById(productId); // This line is failing
//            if (product == null) {
//              throw new RuntimeException("Product not found");
//        }
//
//        
//        Feedback feedback = new Feedback();
//        feedback.setCustomerId(customerId);
//        feedback.setCustomerName(customer.getFirstName() + " " + customer.getLastName());
//        feedback.setProductName(product.getProductName());
//        feedback.setFeedback(feedbackContent);
// 
//        return feedbackRepository.save(feedback);
//    }
        public Feedback addFeedback(FeedbackRequest request) {
            Feedback feedback = new Feedback();
            feedback.setFeedbackId(request.getFeedbackId());
            feedback.setCustomerId(request.getCustomerId());
            feedback.setCustomerName(request.getCustomerName());
            feedback.setProductName(request.getProductName());
            feedback.setFeedback(request.getFeedback());

            return feedbackRepository.save(feedback);
        }

    
//    public List<Feedback> getFeedbackByCustomerId(Long customerId) {
//        return feedbackRepository.findByCustomerId(customerId);
//    }
 
   public List<Feedback> getFeedbackByCustomerId(Long customerId){
	  return feedbackRepository.findByCustomerId(customerId);
   }
	  
    public Feedback getFeedbackById(Long feedbackId) {
        return feedbackRepository.findById(feedbackId).orElse(null);
    }
}
