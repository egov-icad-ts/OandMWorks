package in.OAndM.services;

import java.util.List;

import org.springframework.http.HttpStatus;

import in.OAndM.DTO.AdminSanctionsModel;
import in.OAndM.DTO.WorkDetailsViewModel;
import in.OAndM.core.BaseResponse;



public interface WorkDetailsViewService  {
													
	public BaseResponse<HttpStatus, List<WorkDetailsViewModel>>  getWorksByFinyear(Integer finyear);

	

	
}