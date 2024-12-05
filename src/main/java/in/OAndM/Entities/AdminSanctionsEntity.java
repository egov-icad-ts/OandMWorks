package in.OAndM.Entities;

import java.math.BigDecimal;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="o_m_admin_sanction")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminSanctionsEntity {
	
	
	@Column(name = "admin_id")
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NotNull
	private Integer adminId;
	
	@Column(name = "work_id")
	  private Integer workId ;
	
	@Column(name = "project_id")
	  private Integer projectId ;
	
	@Column(name = "unit_id")
	private Integer unitId ;
	
	@Column(name = "circle_id")
	private Integer circleId ;
	
	
	@Column(name = "division_id")
	private Integer divisionId ;
	
	
	@Column(name = "sub_division_id")
	private Integer subDivisionId ;
	

	@Column(name = "work_name")
	private String workName ;
	
	@Column(name = "hoa_id")
	private Integer hoaId ;
	

	
	@Column(name = "approved_by_name")
	private String approvedByName ;
	

	@Column(name = "reference_number")
	private String referenceNumber ;
	

	@Column(name = "reference_date")
	private String referenceDate ;

	@Column(name = "admin_approved_amount")
	  private BigDecimal adminSanctionAmt ;
	
	@Column(name = "is_latest")
	  private Boolean isLatest;
	  
	
	@Column(name = "delete_flag")
	  private Boolean deleteFlag;
	
	@Column(name = "updated_by")
	private String updatedby ;
	
	
	@Column(name = "lift_id")
	private Integer liftId ;

	@Column(name = "tank_id")
	private Integer tankId ;
	
	@Column(name = "small_lift_id")
	private Integer smallLiftId ;
	
	@Column(name = "res_id")
	private Integer resId ;
	
	@Column(name = "district_id")
	private Integer districtId ;
	
	@Column(name = "mandal_id")
	private Integer mandalId ;
	
	@Column(name = "village_id")
	private Integer villageId ;
	
	
	@Column(name = "financial_year")
	private Integer financialYear ;
	
	
	@Column(name = "tank_code")
	private String tank_code ;
	
	
	@Column(name = "tank_name")
	private String tank_name ;
	
	
	@Column(name = "aa_file_url")
	private String aaFileUrl ;
	 
	  
	@Column(name = "is_assigned")
	private Boolean isAssigned ;
	  
	@Column(name = "proj_sub_type_id")
	private Integer projSubTypeId ;
	
	
//	  @OneToMany(mappedBy = "adminSanction", fetch = FetchType.LAZY)
//	  private List<TechnicalSanctionEntity> technEntries;
//	  
		
	  @OneToMany	 
	  @JoinColumn(name = "work_id", referencedColumnName = "work_id")
	  private List<TechnicalSanctionEntity> technEntries;
	  
		/*
		 * @JoinColumn(name = "approved_by_id") private WorkApprovedAuthorityMst
		 * workApprovedAuthorityMst ;
		 */
		
		
		
		/*
		 * @OneToMany(mappedBy = "adminSanctionAssign", fetch = FetchType.LAZY) private
		 * List<AdminAssignWorksEntity> adminAssignWorksEntities ;
		 */
		 
	 
	 
	 
}