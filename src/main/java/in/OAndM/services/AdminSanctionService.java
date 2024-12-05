package in.OAndM.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.OAndM.DTO.AdminSanctionsModel;
import in.OAndM.DTO.TechnicalSanctionsModel;
import in.OAndM.Entities.AdminSanctionsEntity;
import in.OAndM.Entities.TechnicalSanctionEntity;
import in.OAndM.config.AppConstant;
import in.OAndM.core.BaseResponse;
import in.OAndM.core.BaseServiceImpl;
import in.OAndM.repositories.AdminSanctionRepo;
import in.OAndM.requests.PaginationRequest;


public interface AdminSanctionService  {
													
	public BaseResponse<HttpStatus, List<AdminSanctionsModel>>  getAdminSanctionByFinYearByUnit(Integer unit,Integer year);
	
	public BaseResponse<HttpStatus, AdminSanctionsModel> findbyWorkId(Integer workId);
	
	public BaseResponse<HttpStatus, AdminSanctionsModel> findByunitIdAndFinancialYearAndIsLatestAndDeleteFlagAndTechnEntriesIsLatestAndTechnEntriesTsId(Integer unit,Integer finyear,Boolean isLatest,Boolean deleteFlag,Boolean tech_is_latest,Integer tsId);

	public BaseResponse<HttpStatus, List<AdminSanctionsModel>>  getAdminSanctionForDEE(Integer unit,Integer divisionId,Integer subDivisionId,Integer year);
	
	
}
