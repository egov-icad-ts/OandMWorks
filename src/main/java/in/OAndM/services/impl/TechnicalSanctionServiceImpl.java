package in.OAndM.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.OAndM.DTO.TechnicalSanctionsModel;
import in.OAndM.Entities.TechnicalSanctionEntity;
import in.OAndM.config.AppConstant;
import in.OAndM.core.BaseResponse;
import in.OAndM.core.BaseServiceImpl;
import in.OAndM.repositories.AdminSanctionRepo;
import in.OAndM.repositories.TechnicalSanctionRepo;
import in.OAndM.services.TechnicalSanctionService;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class TechnicalSanctionServiceImpl extends BaseServiceImpl<TechnicalSanctionEntity, TechnicalSanctionsModel, Integer>  implements TechnicalSanctionService{

	@Autowired
	TechnicalSanctionRepo technicalSanctionRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	@Override
	public void insertTechnicalSanctions(List<TechnicalSanctionsModel> list) {

			if(list!=null) {
				saveAll(list);
			}else {
				
			}
	}
	
	public BaseResponse<HttpStatus, List<TechnicalSanctionsModel>>  getTechnicalSanctionByWorkId(Integer workId){
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_STARTED));
		BaseResponse<HttpStatus, List<TechnicalSanctionsModel>> responseJson = new BaseResponse<>();
		List<TechnicalSanctionEntity> entities = technicalSanctionRepo.findByworkIdAndIsLatestTrueAndDeleteFlagFalse(workId);
		List<TechnicalSanctionsModel> techmodels =new ArrayList<>();
		for(TechnicalSanctionEntity  admin: entities) {
			TechnicalSanctionsModel model=new TechnicalSanctionsModel();
			model.setTsId(admin.getTsId());
			model.setTsNumber(admin.getTsNumber());
			
			techmodels.add(model);
		}
		logger.debug(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setSuccess(true);
		responseJson.setData(techmodels);
		responseJson.setMessage(appConstant.getValue(AppConstant.GET_SERVICE_SUCCESS));
		responseJson.setStatus(HttpStatus.OK);
		return responseJson;
		
	}
}