package in.OAndM.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.OAndM.DTO.AdminAssignWorksModel;
import in.OAndM.DTO.AdminSanctionsModel;
import in.OAndM.DTO.TechnicalSanctionsModel;
import in.OAndM.Entities.AdminSanctionsBackupEntity;
import in.OAndM.Entities.AdminSanctionsEntity;
import in.OAndM.Entities.AgreementsEntity;
import in.OAndM.Entities.BillsEntity;
import in.OAndM.Entities.TechnicalSanctionEntity;
import in.OAndM.config.AppConstant;
import in.OAndM.core.BaseResponse;
import in.OAndM.core.BaseServiceImpl;
import in.OAndM.mappers.AdminSanctionBackupMapper;
import in.OAndM.repositories.AdminSanctionBackupRepo;
import in.OAndM.repositories.AdminSanctionRepo;
import in.OAndM.repositories.AgreementsRepo;
import in.OAndM.repositories.AssignAdminSanctionRepo;
import in.OAndM.repositories.BillsRepo;
import in.OAndM.repositories.TechnicalSanctionRepo;
import in.OAndM.services.AdminSanctionService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;



@Service
@Transactional

public class AdminSanctionServiceImpl extends BaseServiceImpl<AdminSanctionsEntity, AdminSanctionsModel, Integer>
		implements AdminSanctionService {
	@Autowired
	AdminSanctionRepo adminSanctionRepo;
	
	@Autowired
	AdminSanctionBackupRepo asBackupRepo;
	
	@Autowired
	private AdminSanctionBackupMapper asBackupMapper;
	
	@Autowired
	BillsRepo billsRepo;
	
	@Autowired
	AgreementsRepo agmtRepo;
	
	@Autowired
	TechnicalSanctionRepo tsRepo;
	
	@Autowired
	AssignAdminSanctionRepo assignAsRepo;
	

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
	@PersistenceContext
    private EntityManager entityManager;
	public BaseResponse<HttpStatus, AdminSanctionsModel> findbyWorkId(Integer workId) {
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_STARTED));
		BaseResponse<HttpStatus, AdminSanctionsModel> responseJson = new BaseResponse<>();
		AdminSanctionsEntity entities = adminSanctionRepo
				.findByworkIdAndIsLatestAndDeleteFlag(workId, true,
						false);
		AdminSanctionsModel models =new AdminSanctionsModel();
		if(entities!=null) {
			models= mapper.mapEntityToModel(entities);
		List<TechnicalSanctionsModel> techSanctionModels = new ArrayList<>();
		for (int i=0;i<entities.getTechnEntries().size();i++) {
			TechnicalSanctionsModel techmodel = new TechnicalSanctionsModel();
			techmodel.setTsApprovedAmount(entities.getTechnEntries().get(i).getTsApprovedAmount());
			techmodel.setTsApprovedDate(entities.getTechnEntries().get(i).getTsApprovedDate());
			techmodel.setTsDate(entities.getTechnEntries().get(i).getTsApprovedDate().toString());
			techmodel.setTsNumber(entities.getTechnEntries().get(i).getTsNumber());
		techSanctionModels.add(techmodel);
		}
		models.setTechlist(techSanctionModels);
		}
		
		

		
//		AdminSanctionsModel model = new AdminSanctionsModel();
//		model.setWorkId(entities.getWorkId());
//		model.setAdminSanctionAmt(entities.getAdminSanctionAmt());
//		model.setWorkName(entities.getWorkName());
//		model.setAaFileUrl(entities.getAaFileUrl());
//		model.setApprovedById(entities.getApprovedById());
//		model.setApprovedByName(entities.getAuthoritymst().getAuthorityName());
//		model.setHoaId(entities.getHoaId());
//		model.setWorkTypeId(entities.getWorkTypeId());
//		model.setFinancialYear(entities.getFinancialYear());
//		model.setReferenceNumber(entities.getReferenceNumber());
//		model.setReferenceDate(entities.getReferenceDate());
//		List<TechnicalSanctionsModel> techSanctionModels = new ArrayList<>();
//		for (TechnicalSanctionEntity tech : entities.getTechnEntries()) {
//			TechnicalSanctionsModel techmodel = new TechnicalSanctionsModel();
//			techmodel.setTsApprovedAmount(tech.getTsApprovedAmount());
//			techmodel.setTsApprovedDate(tech.getTsApprovedDate());
//			techmodel.setTsDate(tech.getTsApprovedDate().toString());
//			techmodel.setTsNumber(tech.getTsNumber());
//			techSanctionModels.add(techmodel);
//		}
//		model.setTechlist(techSanctionModels);
//	AdminSanctionsModel model = mapper.mapEntityToModel(entities);
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setSuccess(true);
		responseJson.setData(models);

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
				.findByunitIdAndFinancialYearAndIsLatestAndDeleteFlagAndCircleIdAndDivisionIdAndSubDivisionIdAndIsAssignedTrue(
						unit, year, true, false, circle, divisionId, subDivisionId);
	

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
		Integer workId = adminSanctionRepo.getNextWorkId();

		if (admin != null && workId > 0) {
			admin.setWorkId(workId);
			responseJson = create(admin);
			responseJson.setMessage("Successfully Submitted");
		} else {
			logger.debug(appConstant.getValue(AppConstant.CREATE_SERVICE_FAILED));
			responseJson.setMessage("Error in submission");
			responseJson.setStatus(HttpStatus.BAD_REQUEST);
		}
		return responseJson;
	}

	@Override
	public BaseResponse<HttpStatus, List<AdminSanctionsModel>> getAdminSanctionByUserByAuthorityByFinyear(Integer unit,
			Integer circle, Integer division, Integer subdivision, Integer approvedId, Integer finyear) {
		// TODO Auto-generated method stub
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_STARTED));

		BaseResponse<HttpStatus, List<AdminSanctionsModel>> responseJson = new BaseResponse<>();
		try {
			List<AdminSanctionsEntity> entities = adminSanctionRepo
					.findByUnitIdAndCircleIdAndDivisionIdAndSubDivisionIdAndApprovedByIdAndFinancialYearAndIsLatestTrueAndDeleteFlagFalseAndIsAssignedTrue(
							unit, circle, division, subdivision, approvedId, finyear);

			List<AdminSanctionsModel> models = mapper.mapEntityToModel(entities);
			responseJson.setSuccess(true);
			responseJson.setData(models);

			responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
			responseJson.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			responseJson.setSuccess(false);
			// responseJson.setData("");
			responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_FAILED));
			responseJson.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseJson;

	}

	@Override
	public BaseResponse<HttpStatus, List<AdminSanctionsModel>> getAdminSanctions(Integer unit, Integer year) {
		// TODO Auto-generated method stub
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_STARTED));
		BaseResponse<HttpStatus, List<AdminSanctionsModel>> responseJson = new BaseResponse<>();
		List<AdminSanctionsEntity> entities = adminSanctionRepo
				.findByunitIdAndFinancialYearAndIsLatestTrueAndDeleteFlagFalseAndIsAssignedTrue(
						unit, year);
	//	List<AdminSanctionsModel> adminmodels = new ArrayList<>();
		
		List<AdminSanctionsModel> models = mapper.mapEntityToModel(entities);
//		for (AdminSanctionsEntity admin : entities) {
//			AdminSanctionsModel model = new AdminSanctionsModel();
//			model.setWorkId(admin.getWorkId());
//			model.setWorkName(admin.getWorkName());
//
//			adminmodels.add(model);
//		}
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setSuccess(true);
		responseJson.setData(models);
		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);

		return responseJson;

	}

	@Override
	public BaseResponse<HttpStatus, List<AdminSanctionsModel>> getUnAssignedAdminSanctions(Integer unit, Integer circle,
			Integer division, Integer subDivision) {
		// TODO Auto-generated method stub
		
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_STARTED));
		BaseResponse<HttpStatus, List<AdminSanctionsModel>> responseJson = new BaseResponse<>();
		List<AdminSanctionsEntity> entities = adminSanctionRepo.findByUnitIdAndCircleIdAndDivisionIdAndSubDivisionIdAndIsAssignedTrueAndIsLatestTrueAndDeleteFlagFalse(unit, circle, division, subDivision);
		
		List<AdminSanctionsModel> models = mapper.mapEntityToModel(entities);
		
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setSuccess(true);
		responseJson.setData(models);
		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);
		return responseJson;
	}

	@Override
	public BaseResponse<HttpStatus, AdminSanctionsModel> updateAdminSanctions(AdminSanctionsModel admin) {
		// TODO Auto-generated method stub
	
		BaseResponse<HttpStatus, AdminSanctionsModel> responseJson = new BaseResponse<>();
			int i=0;   String remarks="yes";
			
			  AdminSanctionsEntity  existingRecord = adminSanctionRepo.findByworkIdAndIsLatestAndDeleteFlag(admin.getWorkId(), true, false);
			  
		
				  if (existingRecord != null) {
					  AdminSanctionsBackupEntity backupEntity = asBackupMapper.mapFromMainEntity(existingRecord);

					    backupEntity.setBackupOn(LocalDateTime.now()); 
					    asBackupRepo.save(backupEntity); 
					}
				 // responseJson = create(admin);
				  
				  i=adminSanctionRepo.updateAdminSanctions(admin.getWorkId(),admin.getFinancialYear(), admin.getWorkName(), admin.getHoaId(), admin.getApprovedById(),
					 admin.getAdminSanctionAmt(), admin.getReferenceNumber(), admin.getReferenceDate(), admin.getAaFileUrl(), remarks);
			
			 if(i>0) {
					logger.debug(appConstant.getValue(AppConstant.CREATE_SERVICE_SUCCESS));
			responseJson.setMessage("Successfully Submitted");
			responseJson.setStatus(HttpStatus.CREATED);
		} 
			  
	else {
			logger.debug(appConstant.getValue(AppConstant.CREATE_SERVICE_FAILED));
			responseJson.setMessage("Error in submission");
			responseJson.setStatus(HttpStatus.BAD_REQUEST);
		}
		return responseJson;
	}

	@Override
	public BaseResponse<HttpStatus, String> deleteByWorkId(Integer WorkId) {
		// TODO Auto-generated method stub
		BaseResponse<HttpStatus, String> responseJson = new BaseResponse<>();

		try {
		    long billCount = billsRepo.countByWorkIdAndIsLatestTrueAndDeleteFlagFalse(WorkId);
		    long agmtCount = agmtRepo.countByWorkIdAndIsLatestTrueAndDeleteFlagFalse(WorkId);
		    long tsCount = tsRepo.countByWorkIdAndIsLatestTrueAndDeleteFlagFalse(WorkId);
		    long asCount = adminSanctionRepo.countByWorkIdAndIsLatestTrueAndDeleteFlagFalseAndIsAssignedTrue(WorkId);

		    if (billCount > 0) {
		        billsRepo.deleteByWorkId(WorkId);
		        agmtRepo.deleteByWorkId(WorkId);
		        tsRepo.deleteByWorkId(WorkId);
		        assignAsRepo.deleteByWorkId(WorkId);
		    	adminSanctionRepo.deleteByWorkId(WorkId);
		        responseJson.setMessage("Bill, Agreement,Technical Sanction and Admin Sanction details deleted successfully.");
		    } else if (agmtCount > 0) {
		    	agmtRepo.deleteByWorkId(WorkId);
		        tsRepo.deleteByWorkId(WorkId);
		        assignAsRepo.deleteByWorkId(WorkId);
		    	adminSanctionRepo.deleteByWorkId(WorkId);
		        responseJson.setMessage("Agreement,Technical Sanction and Admin Sanction details deleted successfully.");
		    } else if (tsCount > 0) {
		        tsRepo.deleteByWorkId(WorkId);
		        assignAsRepo.deleteByWorkId(WorkId);
		    	adminSanctionRepo.deleteByWorkId(WorkId);
		        responseJson.setMessage("Technical Sanction and Admin Sanction details deleted successfully.");
		    }else if(asCount > 0) {
		    	assignAsRepo.deleteByWorkId(WorkId);
		    	adminSanctionRepo.deleteByWorkId(WorkId);
		    	responseJson.setMessage("Admin Sanction details deleted successfully.");
		    }
		    else {
		        responseJson.setMessage("No records found to delete.");
		    }
		    responseJson.setSuccess(true);
		    responseJson.setStatus(HttpStatus.OK);

		} catch (Exception e) {
		    responseJson.setSuccess(false);
		    responseJson.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		    responseJson.setMessage("Error occurred during deletion: " + e.getMessage());
		}
		return responseJson;	
	}
}
