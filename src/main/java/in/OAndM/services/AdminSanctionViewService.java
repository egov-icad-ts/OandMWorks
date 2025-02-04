package in.OAndM.services;

import java.util.List;

import org.springframework.http.HttpStatus;

import in.OAndM.DTO.AdminSanctionsModel;
import in.OAndM.core.BaseResponse;

public interface AdminSanctionViewService {

	

	public BaseResponse<HttpStatus, List<AdminSanctionsModel>>  getWorksByFinancialyearAndOffice(Integer unitId,Integer circleId,Integer divisionId,Integer subDivisionId,Integer finYear,Integer approvedId);

}
