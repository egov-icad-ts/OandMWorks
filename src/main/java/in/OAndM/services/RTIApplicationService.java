package in.OAndM.services;

import in.OAndM.DTO.RtiApplicationDto;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.OAndM.core.BaseResponse;
import in.OAndM.core.BaseService;


public interface RTIApplicationService extends BaseService<RtiApplicationDto, Integer> {

	BaseResponse<HttpStatus, RtiApplicationDto> delete(Integer id, String username);
    // You can define any additional methods specific to RTI applications here
}
