package in.OAndM.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class WorkDetailsViewModel {

	private Integer tsId;

	private Integer workId;

	private Integer techWorkId;
	
	private String tsNumber;

	private BigDecimal tsApprovedAmount;
	
	private BigDecimal tsApprovedAmountLakhs;

	private Date tsApprovedDate;
	
	private String tsFileUrl;
	
	private String tsEstFileUrl;

	private Integer tsType;

	private Integer agrWorkId;
	
	private Integer agreementId;
	
	private Integer tenderType;
	
	private BigDecimal tenderPercentage;
	
	private String agreementNumber;
	
	private Date agreementDate;
	
	private BigDecimal agreementAmount;
	
	private BigDecimal agreementAmountLakhs;
	
	private String agencyName;
	
	private Date tenderDate;
	
	private Integer billsPaid;
	
	private Integer billsPending;

	private Integer actionToBeTakenCount;

	private BigDecimal actionToBeTakenAmt;

	private BigDecimal paidAmount;

	private BigDecimal pendingAmount;
	
	private BigDecimal tsApprovedAmountLakh;
	
	private BigDecimal agreementAmountLakh;

	private BigDecimal paidAmountLakh;
	
	private BigDecimal pendingAmountLakh;
	
	

}
