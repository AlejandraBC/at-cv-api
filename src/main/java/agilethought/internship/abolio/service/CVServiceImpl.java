package agilethought.internship.abolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agilethought.internship.abolio.domain.CreateCVResponse;
import agilethought.internship.abolio.exception.EntityNotFoundException;
import agilethought.internship.abolio.model.CV;
import agilethought.internship.abolio.repository.CVRepository;

@Service
public class CVServiceImpl implements CVService {
	@Autowired
	private CVRepository repo;

	@Override
	public CV getById(String id) throws Exception {
		Optional<CV> foundEntity = repo.findById(id);
		if (foundEntity.isPresent())
			return foundEntity.get();
		throw new EntityNotFoundException("CV not found for id: " + id);
	}

	@Override
	public List<CV> getAll() {
		return repo.findAll();
	}

	@Override
	public CreateCVResponse createCV(CV request) {
		return new CreateCVResponse(repo.save(request).getId());
	}

	@Override
	public void updateCV(CV request, String id) throws Exception {
		if (!repo.existsById(id))
			throw new EntityNotFoundException("CV not found for id: " + id);
		request.setId(id);
		repo.save(request);
	}

}
