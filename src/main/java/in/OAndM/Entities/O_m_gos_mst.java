package in.OAndM.Entities;

import java.util.Date;

import jakarta.persistence.Column;

public class O_m_gos_mst {
@Column(name="go_id")
 
 private Integer  goId;

@Column(name="go_number")
 
 private String  goNumber;

@Column(name="go_desc")
 
 private String  goDesc;

@Column(name="go_url")
 
 private String  goUrl;



@Column(name="delete_flag")
 
 private boolean  deleteFlag;

@Column(name="go_date")
 
 private Date  goDate;

@Column(name="upload_type")
 
 private String  uploadType;

@Column(name="go_amount")
 
 private Integer  goAmount;

@Column(name="financial_year")
 
 private Integer  financialYear;



}
