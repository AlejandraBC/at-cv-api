package agilethought.internship.abolio.service;

import java.util.List;

import agilethought.internship.abolio.domain.CreateCVResponse;
import agilethought.internship.abolio.model.CV;

public interface CVService {

	CV getById(String id) throws Exception;

	List<CV> getAll();

	CreateCVResponse createCV(CV request);

	void updateCV(CV request, String id) throws Exception;

}
