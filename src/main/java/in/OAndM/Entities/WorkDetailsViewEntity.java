package in.OAndM.Entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "o_m_work_details_view")

@Data

public class WorkDetailsViewEntity {

	@Column(name = "admin_id")
	@Id
	private Integer adminId;

	@Column(name = "admin_work_id")
	private Integer workId;

	@Column(name = "unit_id")
	private Integer unitdId;

	@Column(name = "tech_work_id")
	private Integer techWorkId;

	@Column(name = "unitName")
	private String unitName;

	@Column(name = "ts_approved_amount")
	private BigDecimal tsApprovedAmount;

	@Column(name = "financial_year")
	private Integer finyear;

	@Column(name = "work_name")
	private String workName;

	@Column(name = "project_id")
	private Integer projectId;

	@Column(name = "circle_id")
	private Integer circleId;

	@Column(name = "division_id")
	private Integer divisionId;

	@Column(name = "sub_division_id")
	private Integer subDivisionId;

	@Column(name = "hoa_id")
	private Integer hoaId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "head_of_account")
	private String headOfAccount;

	@Column(name = "approved_by_id")
	private Integer approvedById;

	@Column(name = "authority_name")
	private String approvedName;

	@Column(name = "authority_name_alias")
	private String approvedNameAlias;

	@Column(name = "reference_number")
	private String referenceNumber;

	@Column(name = "reference_date")
	private Date referenceDate;

	@Column(name = "admin_approved_amount")
	private BigDecimal adminApprovedAmount;

	@Column(name = "project_res_lift_name")
	private String projectResName;

	@Column(name = "tank_id")
	private Integer tankId;

	@Column(name = "agr_work_id")
	private Integer agrWorkId;

	@Column(name = "agreement_amount")
	private BigDecimal agreementAmount;

	@Column(name = "action_to_be_taken_cnt")
	private Integer actionToBeTakenCount;

	@Column(name = "action_to_be_taken_amt")
	private BigDecimal actionToBeTakenAmt;

	@Column(name = "bills_paid")
	private Integer billsPaid;

	@Column(name = "bills_pending")
	private Integer billsPending;

	@Column(name = "paid_amount")
	private BigDecimal paidAmount;

	@Column(name = "pendingAmount")
	private BigDecimal pendingAmount;

	@Column(name = "work_type_id")
	private Integer workTypeId;

	@Column(name = "work_type_name")
	private String workTypeName;
	
	@Column(name = "admin_approved_amount_lakhs")
	private BigDecimal adminApprovedAmountLakh;
	
	@Column(name = "ts_approved_amount_lakhs")
	private BigDecimal tsApprovedAmountLakh;
	
	@Column(name = "agreement_amount_lakhs")
	private BigDecimal agreementAmountLakh;
	


	@Column(name = "paid_amount_lakhs")
	private BigDecimal paidAmountLakh;
	
	@Column(name = "pending_amount_lakhs")
	private BigDecimal pendingAmountLakh;

}