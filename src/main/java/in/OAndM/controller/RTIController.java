package in.OAndM.controller;

import in.OAndM.core.BaseController;
import in.OAndM.Entities.RTIApplication;
import in.OAndM.DTO.RtiApplicationDto;
import in.OAndM.DTO.RtiProformaGDto;
import in.OAndM.DTO.UserDetailsDto;
import in.OAndM.core.BaseResponse; // Assuming you have this response in your project
import in.OAndM.services.RTIApplicationService;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rti")
@CrossOrigin(origins = "http://localhost:3000")
public class RTIController extends BaseController<RTIApplication, RtiApplicationDto, Integer> {
	
	private static final Logger logger = LoggerFactory.getLogger(RTIController.class);

    private final RTIApplicationService rtiApplicationService;

    public RTIController(RTIApplicationService rtiApplicationService) {
        this.rtiApplicationService = rtiApplicationService;
    }

    @GetMapping("/app/getAll")
    public ResponseEntity<BaseResponse<HttpStatus, List<RtiApplicationDto>>> getAllApplications() {
        return ResponseEntity.ok(rtiApplicationService.get());
    }

    @GetMapping("/app/getById/{id}")
    public ResponseEntity<BaseResponse<HttpStatus, RtiApplicationDto>> getApplicationById(@PathVariable Integer id) {
        return ResponseEntity.ok(rtiApplicationService.get(id));
    }

    @PostMapping("/app/entry")
    public ResponseEntity<BaseResponse<HttpStatus, RtiApplicationDto>> createApplication(@Valid @RequestBody RtiApplicationDto rtiApplicationDto) {
    	
    	// Extract user details
        UserDetailsDto user;
		
			user = rtiApplicationDto.getUser();
			 String username = user != null ? user.getUsername() : "Unknown";

		        //java.lang.System.out.println("Received request from user: " + user);
		        logger.info("Received request from user: {}", user);
		
       
		        BaseResponse<HttpStatus, RtiApplicationDto> response = rtiApplicationService.create(rtiApplicationDto);
		        return new ResponseEntity<>(response, HttpStatus.CREATED);
       // return ResponseEntity.status(HttpStatus.CREATED).body(rtiApplicationService.create(rtiApplicationDto));
    }

    @PutMapping("/app/updateById/{id}")
    public ResponseEntity<BaseResponse<HttpStatus, RtiApplicationDto>> updateApplication(@PathVariable Integer id, @Valid @RequestBody RtiApplicationDto rtiApplicationDto) {
        return ResponseEntity.ok(rtiApplicationService.update(id, rtiApplicationDto));
    }

//    @DeleteMapping("/app/deleteById/{id}")
//    public ResponseEntity<BaseResponse<HttpStatus, RtiApplicationDto>> deleteApplication(@PathVariable Integer id) {
//        return ResponseEntity.ok(rtiApplicationService.delete(id));
//    }
    
    @DeleteMapping("/app/deleteById/{id}")
    public ResponseEntity<BaseResponse<HttpStatus, RtiApplicationDto>> deleteApplication(@PathVariable Integer id,@RequestParam String username) {
    	
    	//java.lang.System.out.println("Received delete request from user: " + username);
        logger.info("Received delete request from user: {}", username);
        
        BaseResponse<HttpStatus, RtiApplicationDto> response = rtiApplicationService.delete(id,username);

        if (response.isSuccess()) {
            return ResponseEntity.ok(response); // Return HTTP 200 for successful deletion
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); // Return HTTP 404 if not found
        }
    }
}