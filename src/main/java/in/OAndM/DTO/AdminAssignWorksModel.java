package in.OAndM.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdminAssignWorksModel {
	
 
 private Integer  slno;
 private Integer  workId;
 private Integer  unitId;
 private Integer  circleId;
 
 private Integer  divisionId;
 private Integer  subDivisionId;
 private boolean  isLatest;
 
 private boolean  deleteFlag;

 private String  updatedBy;

}
