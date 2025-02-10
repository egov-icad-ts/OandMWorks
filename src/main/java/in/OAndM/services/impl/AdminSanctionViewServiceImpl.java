package in.OAndM.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import in.OAndM.DTO.AdminSanctionViewModel;
import in.OAndM.Entities.AdminSanctionViewEntity;
import in.OAndM.config.AppConstant;
import in.OAndM.core.BaseResponse;
import in.OAndM.core.BaseServiceImpl;
import in.OAndM.repositories.AdminSanctionViewRepo;
import in.OAndM.services.AdminSanctionViewService;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class AdminSanctionViewServiceImpl extends BaseServiceImpl<AdminSanctionViewEntity, AdminSanctionViewModel, Integer> implements AdminSanctionViewService {
	
	@Autowired
	AdminSanctionViewRepo adminRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	@Override
	public BaseResponse<HttpStatus, List<AdminSanctionViewModel>> getWorksByFinancialyearAndOffice(Integer unitId,Integer circleId,Integer divisionId,Integer subDivisionId,Integer finYear,Integer approvedId) {
		// TODO Auto-generated method stub
		
		BaseResponse<HttpStatus, List<AdminSanctionViewModel>> responseJson = new BaseResponse<>();
		
		List<AdminSanctionViewEntity> list = null;
		
		if(unitId > 0 && circleId == 0) {
			list = adminRepo.findByFinancialYearAndUnitIdAndApprovedById(finYear,unitId,approvedId);
		}
		else if (circleId > 0 && divisionId == 0 && subDivisionId == 0) {
			list = adminRepo.findByFinancialYearAndUnitIdAndCircleIdAndApprovedById(finYear,unitId,circleId,approvedId);
		}
		else if (divisionId > 0 && subDivisionId == 0) {
			list = adminRepo.findByFinancialYearAndUnitIdAndCircleIdAndDivisionIdAndApprovedById(finYear,unitId,circleId,divisionId,approvedId);
		}
		else if (subDivisionId > 0) {
			list = adminRepo.findByFinancialYearAndUnitIdAndCircleIdAndDivisionIdAndSubDivisionIdAndApprovedById(finYear,unitId,circleId,divisionId,subDivisionId,approvedId);
		}
		 
		List<AdminSanctionViewModel> adminViewModel=new ArrayList<>();
		if( list.size()>0) {
			for(AdminSanctionViewEntity  work: list) {
				
				AdminSanctionViewModel adminModel=new AdminSanctionViewModel();
				adminModel.setWorkId(work.getWorkId());
				adminModel.setWorkName(work.getWorkName());
				adminModel.setWorkTypeName(work.getWorkTypeName());
				adminModel.setReferenceNumber(work.getReferenceNumber());
				adminModel.setAdminSanctionAmt(work.getAdminSanctionAmt());
				adminModel.setHeadOfAccount(work.getHeadOfAccount());
				adminModel.setApprovedByName(work.getApprovedByName());
				adminModel.setFinancialYear(work.getFinancialYear());
				adminViewModel.add(adminModel);
			}
			}
			
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setSuccess(true);
		responseJson.setData(adminViewModel);

		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);
		//System.out.println("responseJson" +responseJson);
		return responseJson;
	}

	@Override
	public BaseResponse<HttpStatus, List<AdminSanctionViewModel>> getAbsRepHOAWiseByFinancialyear(Integer financialYear) {
		// TODO Auto-generated method stub
		BaseResponse<HttpStatus, List<AdminSanctionViewModel>> responseJson = new BaseResponse<>();
		
		List<AdminSanctionViewModel> list = null;
		
		if(financialYear > 0) {
			 list=adminRepo.getAbsRepHOAWiseByFinancialyear(financialYear);
		}
		responseJson.setSuccess(true);
		responseJson.setData(list);
		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);
		
		return responseJson;
	}

	@Override
	public BaseResponse<HttpStatus, List<AdminSanctionViewModel>> getAbsRepUnitHOAWiseFinyear(Integer financialYear) {
		// TODO Auto-generated method stub
		BaseResponse<HttpStatus, List<AdminSanctionViewModel>> responseJson = new BaseResponse<>();
		
		List<AdminSanctionViewModel> list = null;
		
		if(financialYear > 0) {
			 list=adminRepo.getAbsRepUnitHOAWiseFinyear(financialYear);
		}
		responseJson.setSuccess(true);
		responseJson.setData(list);
		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);
		
		return responseJson;
	}

	

}
