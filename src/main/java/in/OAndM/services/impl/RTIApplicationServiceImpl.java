package in.OAndM.services.impl;

import in.OAndM.DTO.RtiApplicationDto;
import in.OAndM.DTO.RtiProformaGDto;
import in.OAndM.Entities.RTIApplication;
import in.OAndM.Entities.RtiProformaG;
import in.OAndM.mappers.RtiApplicationMapper; // Assuming your mapper exists here
import in.OAndM.repositories.RtiApplicationRepository;
import in.OAndM.requests.PaginationRequest;
import in.OAndM.core.BaseResponse;
import in.OAndM.services.RTIApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RTIApplicationServiceImpl implements RTIApplicationService {

    private final RtiApplicationRepository rtiApplicationRepository;
    private final RtiApplicationMapper rtiApplicationMapper;
    
    @Autowired
    public RTIApplicationServiceImpl(RtiApplicationRepository rtiApplicationRepository, RtiApplicationMapper rtiApplicationMapper) {
        this.rtiApplicationRepository = rtiApplicationRepository;
        this.rtiApplicationMapper = rtiApplicationMapper;
    }

    @Override
    public BaseResponse<HttpStatus, List<RtiApplicationDto>> get() {
        //List<RTIApplication> applications = rtiApplicationRepository.findAll();
    	List<RTIApplication> applications = rtiApplicationRepository.findAllByDeleteFlagFalse();
        List<RtiApplicationDto> dtos = rtiApplicationMapper.mapEntityToModel(applications);
        
        BaseResponse<HttpStatus, List<RtiApplicationDto>> response = new BaseResponse<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successfully retrieved all active  RTI applications.");
        response.setData(dtos);
        response.setSuccess(true);
        response.setTotal(dtos.size());
        
        return response;
    }

    @Override
    public BaseResponse<HttpStatus, RtiApplicationDto> get(Integer id) {
       // Optional<RTIApplication> application = rtiApplicationRepository.findById(id)
    	 Optional<RTIApplication> application = rtiApplicationRepository.findByIdAndDeleteFlagFalse(id); // Use inherited method
    	 System.out.println("application.size() "+application);
    	 BaseResponse<HttpStatus, RtiApplicationDto> response = new BaseResponse<>();
        
        if (application.isPresent()) {
            RtiApplicationDto dto = rtiApplicationMapper.mapEntityToModel(application.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("Application retrieved (active) successfully.");
            response.setData(dto);
            response.setSuccess(true);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Application not found.");
            response.setSuccess(false);
        }
        
        return response;
    }

    @Override
    public BaseResponse<HttpStatus, RtiApplicationDto> create(RtiApplicationDto model) {
    	
        RTIApplication entity = rtiApplicationMapper.mapModelToEntity(model);
        entity.setIsLatest(true);
        entity.setDeleteFlag(false);
       
        entity.setCreateDate(LocalDateTime.now());
        System.out.println("entity "+entity);
        RTIApplication savedApplication = rtiApplicationRepository.save(entity);
        
        BaseResponse<HttpStatus, RtiApplicationDto> response = new BaseResponse<>();
        response.setStatus(HttpStatus.CREATED);
        response.setMessage("Application created successfully.");
        response.setData(rtiApplicationMapper.mapEntityToModel(savedApplication));
        response.setSuccess(true);
        
        return response;
    }

    @Override
    public BaseResponse<HttpStatus, RtiApplicationDto> update(Integer id, RtiApplicationDto model) {
       // Optional<RTIApplication> optionalApplication = rtiApplicationRepository.findById(id);
    	System.out.println(" id "+id+ " model "+model);
    	Optional<RTIApplication> optionalApplication = rtiApplicationRepository.findByIdAndDeleteFlagFalse(id);
    	
        BaseResponse<HttpStatus, RtiApplicationDto> response = new BaseResponse<>();
        
        if (optionalApplication.isPresent()) {
            RTIApplication entity = optionalApplication.get();
            rtiApplicationMapper.mapModelToEntity(entity, model);
            RTIApplication updatedApplication = rtiApplicationRepository.save(entity);
            
            response.setStatus(HttpStatus.OK);
            response.setMessage("Application updated successfully.");
            response.setData(rtiApplicationMapper.mapEntityToModel(updatedApplication));
            response.setSuccess(true);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Application not found.");
            response.setSuccess(false);
        }
        
        return response;
    }

    
    
//    @Override
//    public BaseResponse<HttpStatus, RtiApplicationDto> delete(Integer id) {
//        Optional<RTIApplication> optionalApplication = rtiApplicationRepository.findById(id);
//        BaseResponse<HttpStatus, RtiApplicationDto> response = new BaseResponse<>();
//        
//        if (optionalApplication.isPresent()) {
//            rtiApplicationRepository.delete(optionalApplication.get());
//            response.setStatus(HttpStatus.OK);
//            response.setMessage("Application deleted successfully.");
//            response.setSuccess(true);
//        } else {
//            response.setStatus(HttpStatus.NOT_FOUND);
//            response.setMessage("Application not found.");
//            response.setSuccess(false);
//        }
//        
//        return response;
//    }
    @Override
    public BaseResponse<HttpStatus, RtiApplicationDto> delete(Integer id) {
        //Optional<RTIApplication> optionalApplication = rtiApplicationRepository.findById(id);
    	Optional<RTIApplication> optionalApplication = rtiApplicationRepository.findByIdAndDeleteFlagFalse(id);
        if (!optionalApplication.isPresent()) {
            return createNotFoundResponse("Application not found.");
        }

        RTIApplication application = optionalApplication.get();
        application.setDeleteFlag(true); // Soft delete
        application.setUpdatedDate(LocalDateTime.now());
        rtiApplicationRepository.save(application);

        BaseResponse<HttpStatus, RtiApplicationDto> response = new BaseResponse<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Application marked as deleted.");
        response.setSuccess(true);

        return response;
    }

 // Helper method for creating not found responses
    private <T> BaseResponse<HttpStatus, T> createNotFoundResponse(String message) {
        BaseResponse<HttpStatus, T> response = new BaseResponse<>();
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setMessage(message);
        response.setSuccess(false);
        return response;
    }

//	@Override
//	public BaseResponse<HttpStatus, List<RtiApplicationDto>> get(PaginationRequest pagination) {
//		// TODO Auto-generated method stub
//		return null;
//	} 
    
    //consider pagination using pageable
//    @Override
//    public BaseResponse<HttpStatus, List<RtiApplicationDto>> get(PaginationRequest pagination) {
//        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize());
//        Page<RTIApplication> applicationsPage = rtiApplicationRepository.findAll(pageable);
//        
//        List<RtiApplicationDto> dtos = rtiApplicationMapper.mapEntityToModel(applicationsPage.getContent());
//        BaseResponse<HttpStatus, List<RtiApplicationDto>> response = new BaseResponse<>();
//        response.setStatus(HttpStatus.OK);
//        response.setMessage("Paginated applications retrieved successfully.");
//        response.setData(dtos);
//        response.setSuccess(true);
//        response.setTotal((int) applicationsPage.getTotalElements());
//        
//        return response;
//    }


	@Override
	public BaseResponse<HttpStatus, List<RtiApplicationDto>> get(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse<HttpStatus, List<RtiApplicationDto>> delete(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse<HttpStatus, List<RtiApplicationDto>> saveAll(List<RtiApplicationDto> models) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse<HttpStatus, List<RtiApplicationDto>> get(PaginationRequest pagination) {
		// TODO Auto-generated method stub
		return null;
	}
}
