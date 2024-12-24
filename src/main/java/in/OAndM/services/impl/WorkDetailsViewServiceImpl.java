package in.OAndM.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.jdbc.AbstractWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.OAndM.DTO.AdminSanctionsModel;
import in.OAndM.DTO.TechnicalSanctionsModel;
import in.OAndM.DTO.WorkDetailsViewModel;
import in.OAndM.Entities.AdminSanctionsEntity;
import in.OAndM.Entities.TechnicalSanctionEntity;
import in.OAndM.Entities.WorkDetailsViewEntity;
import in.OAndM.config.AppConstant;
import in.OAndM.core.BaseMapper;
import in.OAndM.core.BaseResponse;
import in.OAndM.core.BaseServiceImpl;
import in.OAndM.repositories.AdminSanctionRepo;
import in.OAndM.repositories.WorkDetailsViewRepo;
import in.OAndM.services.AdminSanctionService;
import in.OAndM.services.WorkDetailsViewService;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class WorkDetailsViewServiceImpl extends BaseServiceImpl<WorkDetailsViewEntity, WorkDetailsViewModel, Integer> implements WorkDetailsViewService {
	
	@Autowired
	WorkDetailsViewRepo workdetailsrepo;
	
	private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	@Autowired
	protected BaseMapper<TechnicalSanctionEntity, TechnicalSanctionsModel>  techMapper;

	
	@Override
	public BaseResponse<HttpStatus, List<WorkDetailsViewModel>> getWorksByFinyear(Integer finYear) {
		// TODO Auto-generated method stub
		
		BaseResponse<HttpStatus, List<WorkDetailsViewModel>> responseJson = new BaseResponse<>();
		
		String condition="";
		
		//condition="w.unitdId=9812";
		
		 List<WorkDetailsViewModel> list=workdetailsrepo.getWorksByFinyear(finYear,condition);
		 
		// List<WorkDetailsViewModel> list=new ArrayList<>();
		responseJson.setSuccess(true);
		responseJson.setData(list);
		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);
		
		return responseJson;
	}




}
