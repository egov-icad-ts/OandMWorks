package in.OAndM.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.OAndM.DTO.AdminSanctionsModel;
import in.OAndM.DTO.TechnicalSanctionsModel;
import in.OAndM.Entities.AdminSanctionsEntity;
import in.OAndM.Entities.TechnicalSanctionEntity;
import in.OAndM.config.AppConstant;
import in.OAndM.core.BaseResponse;
import in.OAndM.core.BaseServiceImpl;
import in.OAndM.repositories.AdminSanctionRepo;
import in.OAndM.services.AdminSanctionService;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class AdminSanctionServiceImpl extends BaseServiceImpl<AdminSanctionsEntity, AdminSanctionsModel, Integer>
		implements AdminSanctionService {
	@Autowired
	AdminSanctionRepo adminSanctionRepo;

	private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

	public BaseResponse<HttpStatus, List<AdminSanctionsModel>> getAdminSanctionByFinYearByUnit(Integer unit,
			Integer year) {

		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_STARTED));
		BaseResponse<HttpStatus, List<AdminSanctionsModel>> responseJson = new BaseResponse<>();
		List<AdminSanctionsEntity> entities = adminSanctionRepo
				.findByunitIdAndFinancialYearAndIsLatestAndDeleteFlag(unit, year, true, false);
		List<AdminSanctionsModel> models = mapper.mapEntityToModel(entities);
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setSuccess(true);
		responseJson.setData(models);

		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);
		return responseJson;

	}

	public BaseResponse<HttpStatus, AdminSanctionsModel> findbyWorkId(Integer workId) {
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_STARTED));
		BaseResponse<HttpStatus, AdminSanctionsModel> responseJson = new BaseResponse<>();

		AdminSanctionsEntity entities = adminSanctionRepo
				.findByworkIdAndIsLatestAndDeleteFlagAndTechnEntriesIsLatestAndTechnEntriesDeleteFlag(workId, true,
						false, true, false);
		AdminSanctionsModel model = new AdminSanctionsModel();
		model.setWorkId(entities.getWorkId());
		model.setAdminSanctionAmt(entities.getAdminSanctionAmt());
		model.setWorkName(entities.getWorkName());
		model.setAaFileUrl(entities.getAaFileUrl());
		model.setApprovedById(entities.getApprovedById());
		model.setApprovedByName(entities.getApprovedByName());
		model.setHoaId(entities.getHoaId());
		model.setWorkTypeId(entities.getWorkTypeId());
		model.setFinancialYear(entities.getFinancialYear());
		model.setReferenceNumber(entities.getReferenceNumber());
		model.setReferenceDate(entities.getReferenceDate());

		List<TechnicalSanctionsModel> techSanctionModels = new ArrayList<>();
		for (TechnicalSanctionEntity tech : entities.getTechnEntries()) {

			TechnicalSanctionsModel techmodel = new TechnicalSanctionsModel();
			techmodel.setTsApprovedAmount(tech.getTsApprovedAmount());
			techmodel.setTsApprovedDate(tech.getTsApprovedDate());
			techmodel.setTsDate(tech.getTsApprovedDate().toString());
			techmodel.setTsNumber(tech.getTsNumber());
			techSanctionModels.add(techmodel);
		}
//>>>>>>> e9422d02dd35d036da2d11eded5c7c45d019a165
		model.setTechlist(techSanctionModels);

//	AdminSanctionsModel model = mapper.mapEntityToModel(entities);
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setSuccess(true);
		responseJson.setData(model);

		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);

		return responseJson;

	}

	public BaseResponse<HttpStatus, AdminSanctionsModel> findByunitIdAndFinancialYearAndIsLatestAndDeleteFlagAndTechnEntriesIsLatestAndTechnEntriesTsId(
			Integer unit, Integer finyear, Boolean isLatest, Boolean deleteFlag, Boolean tech_is_latest, Integer tsId) {

		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_STARTED));
		BaseResponse<HttpStatus, AdminSanctionsModel> responseJson = new BaseResponse<>();
		AdminSanctionsEntity entities = adminSanctionRepo
				.findByunitIdAndFinancialYearAndIsLatestAndDeleteFlagAndTechnEntriesIsLatestAndTechnEntriesTsId(unit,
						finyear, true, false, true, tsId);
		AdminSanctionsModel model = new AdminSanctionsModel();
		model.setWorkId(entities.getWorkId());
		List<TechnicalSanctionsModel> techSanctionModels = new ArrayList<>();
		for (TechnicalSanctionEntity tech : entities.getTechnEntries()) {

			TechnicalSanctionsModel techmodel = new TechnicalSanctionsModel();
			techmodel.setTsApprovedAmount(tech.getTsApprovedAmount());
			techmodel.setTsApprovedDate(tech.getTsApprovedDate());
			techmodel.setTsNumber(tech.getTsNumber());
			techSanctionModels.add(techmodel);
		}
		model.setTechlist(techSanctionModels);

//	AdminSanctionsModel model = mapper.mapEntityToModel(entities);

		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setSuccess(true);
		responseJson.setData(model);
		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);
		System.out.println("model in service" + model);
		System.out.println("responseJson in service" + responseJson.toString());
		return responseJson;

	}

	public BaseResponse<HttpStatus, List<AdminSanctionsModel>> getAdminSanctionForDEE(Integer unit, Integer circle,
			Integer divisionId, Integer subDivisionId, Integer year) {
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_STARTED));
		BaseResponse<HttpStatus, List<AdminSanctionsModel>> responseJson = new BaseResponse<>();
		List<AdminSanctionsEntity> entities = adminSanctionRepo
				.findByunitIdAndFinancialYearAndIsLatestAndDeleteFlagAndCircleIdAndDivisionIdAndSubDivisionIdAndIsAssignedAndTechnEntriesIsLatestAndTechnEntriesDeleteFlag(
						unit, year, true, false, circle, divisionId, subDivisionId, true, true, false);
		List<AdminSanctionsModel> adminmodels = new ArrayList<>();
		for (AdminSanctionsEntity admin : entities) {
			AdminSanctionsModel model = new AdminSanctionsModel();
			model.setWorkId(admin.getWorkId());
			model.setWorkName(admin.getWorkName());

			adminmodels.add(model);
		}
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setSuccess(true);
		responseJson.setData(adminmodels);
		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);

		return responseJson;

	}

	@Override
	public BaseResponse<HttpStatus, AdminSanctionsModel> insertAdminSanctions(AdminSanctionsModel admin) {
		// TODO Auto-generated method stub
		
		BaseResponse<HttpStatus, AdminSanctionsModel> responseJson = new BaseResponse<>();
		Integer workId=adminSanctionRepo.getNextWorkId();
		
		
		if(admin!=null && workId >0) {
			admin.setWorkId(workId);
			responseJson=create(admin);
			responseJson.setMessage("Successfully Submitted");
		}else {
			logger.debug(appConstant.getValue(AppConstant.CREATE_SERVICE_FAILED));
			responseJson.setMessage("Error in submission");
			responseJson.setStatus(HttpStatus.BAD_REQUEST);
		}
		return responseJson;
	}
}
