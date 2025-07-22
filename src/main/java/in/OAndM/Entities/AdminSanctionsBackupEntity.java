package in.OAndM.Entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="o_m_admin_sanction_backup")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminSanctionsBackupEntity {
	
	@Column(name = "admin_backup_id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_sanction_backup_seq")
	@SequenceGenerator(name = "admin_sanction_backup_seq", sequenceName = "o_m_admin_sanction_backup_admin_backup_id_seq", allocationSize = 1)
	@NotNull
	private Integer adminBackupId;
	
	@Column(name = "admin_id")
	private Integer adminId;
	

    @Column(name = "work_id", unique = true)
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
	private Date referenceDate ;

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
	private String tankCode ;
	
	
	@Column(name = "tank_name")
	private String tankName ;
	
	
	@Column(name = "aa_file_url")
	private String aaFileUrl ;
	
	@Column(name = "modified_remarks")
	private String modifiedRemarks ;
	 
	  
	@Column(name = "is_assigned")
	private Boolean isAssigned ;
	  
	@Column(name = "proj_sub_type_id")
	private Integer projSubTypeId ;
	
	@Column(name = "approved_by_id")
	private Integer approvedById;
	
	@Column(name = "work_type_id")
	private Integer workTypeId;
	
	@Column(name = "updated_on")
	private LocalDateTime updatedOn;
	
	@Column(name = "backup_on", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime backupOn;

	  @PrePersist
	  public void prePersist() {
	      LocalDateTime now = LocalDateTime.now(); 
	      this.backupOn = now;     
	    
	  }

}
