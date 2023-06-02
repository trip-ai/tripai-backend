package uz.tripai.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.tripai.dto.FeedbackDto;
import uz.tripai.dto.request.FeedbackRequest;
import uz.tripai.entity.Feedback;
import uz.tripai.mapper.FeedbackMapper;
import uz.tripai.repository.FeedbackRepository;
import uz.tripai.service.FeedbackService;

@Service
public class FeedbackServiceImpl extends BaseServiceImpl<Feedback, FeedbackDto, FeedbackRepository, FeedbackMapper> implements FeedbackService {
    private final FeedbackRepository repository;
    private final FeedbackMapper mapper;
    @Autowired
    public FeedbackServiceImpl(FeedbackRepository repository, FeedbackMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FeedbackDto create(FeedbackRequest obj) {
        Feedback entity = mapper.toEntity(obj);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public FeedbackDto updateById(long id, FeedbackRequest obj) {
        Feedback existingEntity = findById(id);
        Feedback entity = mapper.toEntity(obj);
        BeanUtils.copyProperties(entity, existingEntity, "id", "createdAt", "updatedAt");
        return mapper.toDto(repository.save(existingEntity));
    }
}
