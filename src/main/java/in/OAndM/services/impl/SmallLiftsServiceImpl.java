package in.OAndM.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.OAndM.DTO.AdminSanctionsModel;
import in.OAndM.DTO.SmallLiftsMasterModel;
import in.OAndM.DTO.TechnicalSanctionsModel;
import in.OAndM.Entities.AdminSanctionsEntity;
import in.OAndM.Entities.SmallLiftsMaster;
import in.OAndM.Entities.TechnicalSanctionEntity;
import in.OAndM.config.AppConstant;
import in.OAndM.core.BaseResponse;
import in.OAndM.core.BaseServiceImpl;
import in.OAndM.repositories.AdminSanctionRepo;
import in.OAndM.repositories.SmallLiftMasterRepo;
import in.OAndM.services.AdminSanctionService;
import in.OAndM.services.SmallLiftService;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class SmallLiftsServiceImpl extends BaseServiceImpl<SmallLiftsMaster, SmallLiftsMasterModel, Integer>
		implements SmallLiftService {
	@Autowired
	SmallLiftMasterRepo adminSanctionRepo;

	private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);


	@Override
	public BaseResponse<HttpStatus, List<SmallLiftsMasterModel>> findbyProjectId(Integer projectId) {
		// TODO Auto-generated method stub
		return null;
	}
}
