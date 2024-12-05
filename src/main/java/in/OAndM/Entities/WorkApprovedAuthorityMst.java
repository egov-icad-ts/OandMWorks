package in.OAndM.Entities;

import jakarta.persistence.Column;

public class WorkApprovedAuthorityMst {
@Column(name="authority_name")
 
 private String  authorityName;

@Column(name="authority_id")
 
 private Integer  authorityId;

@Column(name="delete_flag")
 
 private boolean  deleteFlag;

@Column(name="authority_name_alias")
 
 private String  authorityNameAlias;

@Column(name="authority_type")
 
 private String  authorityType;

@Column(name="adminsanc_limit_fin_year")
 
 private Double  adminsancLimitFinYear;

@Column(name="adminsanc_limit_per_work")
 
 private Double  adminsancLimitPerWork;


}
