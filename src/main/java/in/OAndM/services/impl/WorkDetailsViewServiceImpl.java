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
import in.OAndM.DTO.BillsModel;
import in.OAndM.DTO.TechnicalSanctionsModel;
import in.OAndM.DTO.WorkDetailsViewModel;
import in.OAndM.Entities.AdminSanctionViewEntity;
import in.OAndM.Entities.AdminSanctionsEntity;
import in.OAndM.Entities.BillsEntity;
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
	public BaseResponse<HttpStatus, List<WorkDetailsViewModel>> getAbsRepSanctionAuthorityWiseByFinyear(Integer finYear,Integer unit,Integer circle,Integer division,Integer subDivision,Integer designationId) {
		// TODO Auto-generated method stub
		
		BaseResponse<HttpStatus, List<WorkDetailsViewModel>> responseJson = new BaseResponse<>();
		List<WorkDetailsViewModel> list;

		if(designationId==4 || designationId==113 ) {
			list=workdetailsrepo.getAbsRepSanctionAuthorityWiseDEE(finYear, unit, circle, division, subDivision);
			} else if (designationId==5 || designationId==114) {
				/* for EE */
				list=workdetailsrepo.getAbsRepSanctionAuthorityWiseEE(finYear, unit, circle,division);
			}
			 else if (designationId==7) {
					/* for SE */
				 list=workdetailsrepo.getAbsRepSanctionAuthorityWiseSE(finYear, unit, circle);
				}
			 else if (designationId==9 || designationId==10) {
					/* for CE */
				 list=workdetailsrepo.getAbsRepSanctionAuthorityWiseCE(finYear, unit);
				}
			 else {
				 list=workdetailsrepo.getAbsRepSanctionAuthorityWiseByFinyear(finYear);
			 }
	
		responseJson.setSuccess(true);
		responseJson.setData(list);
		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);
		
		return responseJson;
	}


	@Override
	public BaseResponse<HttpStatus, List<WorkDetailsViewModel>> getAbsRepUnitWiseFinyear(Integer finyear) {
		// TODO Auto-generated method stub
			BaseResponse<HttpStatus, List<WorkDetailsViewModel>> responseJson = new BaseResponse<>();
		
		List<WorkDetailsViewModel> list = null;
		
		if(finyear > 0) {
			 list=workdetailsrepo.getAbsRepUnitWiseFinyear(finyear);
		}
		responseJson.setSuccess(true);
		responseJson.setData(list);
		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);
		
		return responseJson;
	}


	@Override
	public BaseResponse<HttpStatus, List<WorkDetailsViewModel>> getAbsRepWorkTypeHOAWiseFinyear(Integer finyear) {
		// TODO Auto-generated method stub
		BaseResponse<HttpStatus, List<WorkDetailsViewModel>> responseJson = new BaseResponse<>();
		
		List<WorkDetailsViewModel> list = null;
		
		if(finyear > 0) {
			 list=workdetailsrepo.getAbsRepWorkTypeHOAWiseFinyear(finyear);
		}
		responseJson.setSuccess(true);
		responseJson.setData(list);
		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);
		
		return responseJson;
	}

	

	}
