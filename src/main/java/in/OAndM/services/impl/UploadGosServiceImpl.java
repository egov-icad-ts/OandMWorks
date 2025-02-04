package in.OAndM.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.OAndM.DTO.TechnicalSanctionsModel;
import in.OAndM.DTO.UploadGOsModel;
import in.OAndM.Entities.UploadGOsEntity;
import in.OAndM.core.BaseResponse;
import in.OAndM.core.BaseServiceImpl;
import in.OAndM.services.UploadGOsService;
import in.OAndM.repositories.UploadGOsRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UploadGosServiceImpl  extends BaseServiceImpl<UploadGOsEntity, UploadGOsModel, Integer> implements UploadGOsService{
	
	@Autowired
	private UploadGOsRepo gosRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

	public BaseResponse<HttpStatus, UploadGOsModel>  insertGOs(UploadGOsModel gos) {
		
		BaseResponse<HttpStatus, UploadGOsModel> responseJson = new BaseResponse<>();
		System.out.println("gos:"+ gos);
		
		if(gos!=null) {
			responseJson=create(gos);
			responseJson.setMessage("Submitted SuccessFully");
		}else {
			responseJson.setMessage("Error in submitting");
		}
		return responseJson;
	}

	
}
