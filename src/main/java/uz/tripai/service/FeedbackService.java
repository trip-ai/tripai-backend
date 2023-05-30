package uz.tripai.service;

import uz.tripai.dto.FeedbackDto;
import uz.tripai.dto.ItineraryDto;
import uz.tripai.dto.request.FeedbackRequest;
import uz.tripai.dto.request.ItineraryRequest;
import uz.tripai.entity.Feedback;
import uz.tripai.entity.Itinerary;

public interface FeedbackService extends BaseService<Feedback, FeedbackDto> {
    FeedbackDto create(FeedbackRequest obj);
    FeedbackDto updateById(long id, FeedbackRequest obj);
    Feedback findById(long id);
}
