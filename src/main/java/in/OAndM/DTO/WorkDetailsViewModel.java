package in.OAndM.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class WorkDetailsViewModel {

	private Integer workId;	
	private String workName;
	
	private Integer unitId;	
	private String unitName;
	
	private Integer circleId;
	private String circleName;
	
	private Integer divisionId;
	private String divisionName;
	
	private Integer subDivisionId;
	private String subDivisionName;

	private BigDecimal adminAmt;

	private Long adminCount;

	private BigDecimal techAmt;

	private Long techCount;

	private BigDecimal agreementAmt;

	private Long agreementCount;

	private Long billsPaidCount;

	private BigDecimal billsPaidAmount;

	private Long billsPendingCount;

	private BigDecimal billsPendingAmount;

	private Long actionToBeTakenCount;

	private BigDecimal actionToBeTakenAmt;
	
	private Integer approvedId;

	private String approvedName;

	private Integer workTypeId;

	private String workTypeName;

	private Integer finyear;
	
	private String referenceNumber;
	
	private String headOfAccount;

	private Integer designationId;
	
	

}
