package in.OAndM.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.OAndM.DTO.BillsModel;
import in.OAndM.Entities.BillsEntity;
import in.OAndM.core.BaseServiceImpl;
import in.OAndM.repositories.BillsRepo;
import in.OAndM.services.BillsService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class BillsServiceImpl extends BaseServiceImpl<BillsEntity, BillsModel, Integer> implements BillsService{

	@Autowired
	private BillsRepo billsRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

	public void insertBills(BillsModel bills) {
		
		System.out.println("bills:"+ bills);
		
		if(bills!=null) {
			create(bills);
		}else {
			
		}
	}
}
