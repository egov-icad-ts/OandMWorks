package in.OAndM.services;

import in.OAndM.DTO.RtiProformaGDto;
import in.OAndM.DTO.UnitLevelDataDto;
import in.OAndM.DTO.UnitLevelRequest;

import jakarta.validation.Valid;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import in.OAndM.core.BaseResponse;
import in.OAndM.core.BaseService;

public interface RtiProformaGService extends BaseService<RtiProformaGDto, Integer> {
    // You can define any additional methods specific to RTI proformaG here
	
	// List<RtiProformaGDto> findByAppealNo(String appealNo);
	
	
	// If you want to use a custom query to fetch RtiRejectionStatus eagerly
	// Custom method to fetch RtiProformaG with rejection status
	BaseResponse<HttpStatus, List<RtiProformaGDto>> findAllWithRejectionStatus();

	BaseResponse<HttpStatus, List<UnitLevelDataDto>> getUnitLevelData(@Valid UnitLevelRequest request);

	BaseResponse<HttpStatus, List<UnitLevelDataDto>> getCircleLevelData(UnitLevelRequest request, Integer unitId);

	BaseResponse<HttpStatus, RtiProformaGDto> delete(Integer id, String username);

}
