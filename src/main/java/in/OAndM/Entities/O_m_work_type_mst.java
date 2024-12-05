package in.OAndM.Entities;

import jakarta.persistence.Column;

public class O_m_work_type_mst {
@Column(name="work_type_id")
 
 private Integer  workTypeId;

@Column(name="work_type_name")
 
 private String  workTypeName;

@Column(name="delete_flag")
 
 private boolean  deleteFlag;


 
}
