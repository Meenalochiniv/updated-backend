package com.example.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.FeedbackRequest;
import com.example.entity.Feedback;
import com.example.service.FeedbackService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
 
    @Autowired
    private FeedbackService feedbackService;
 
  
//    @PostMapping("/add")
//    public ResponseEntity<Feedback> addFeedback(
//            @RequestParam Long customerId,
//           @RequestParam Long productId,
//        @RequestParam String feedbackContent) {
//    Feedback feedback = feedbackService.addFeedback(customerId, productId, feedbackContent);
//        return ResponseEntity.ok(feedback);
//    }
   
        @PostMapping("/add")
        public ResponseEntity<Feedback> addFeedback(@RequestBody FeedbackRequest request) {
            Feedback feedback = feedbackService.addFeedback(request);
            return ResponseEntity.ok(feedback);
        }
    

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Feedback>> getFeedbackByCustomerId(@PathVariable Long customerId) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByCustomerId(customerId);
        return ResponseEntity.ok(feedbackList);
    }
 
    
    @GetMapping("/{feedbackId}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long feedbackId) {
        Feedback feedback = feedbackService.getFeedbackById(feedbackId);
        if (feedback != null) {
            return ResponseEntity.ok(feedback);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}