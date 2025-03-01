package in.OAndM.services;

import java.util.List;

import org.springframework.http.HttpStatus;

import in.OAndM.DTO.AdminSanctionsModel;
import in.OAndM.DTO.WorkDetailsViewModel;
import in.OAndM.core.BaseResponse;



public interface WorkDetailsViewService  {
													
	public BaseResponse<HttpStatus, List<WorkDetailsViewModel>>  getAbsRepSanctionAuthorityWiseByFinyear(Integer finyear,Integer unit,Integer circle,Integer division,Integer subdiv,Integer designationId);

	public BaseResponse<HttpStatus, List<WorkDetailsViewModel>> getAbsRepUnitWiseFinyear(Integer finyear);
	
	public BaseResponse<HttpStatus, List<WorkDetailsViewModel>> getAbsRepWorkTypeHOAWiseFinyear(Integer finyear);
	
	public BaseResponse<HttpStatus, List<WorkDetailsViewModel>> getAbsRepWorkTypeWiseFinyear(Integer finyear);
	
	public BaseResponse<HttpStatus, List<WorkDetailsViewModel>> getAbsRepSanctionAuthWorkTypeWiseFinyear(Integer finyear);
	
}
