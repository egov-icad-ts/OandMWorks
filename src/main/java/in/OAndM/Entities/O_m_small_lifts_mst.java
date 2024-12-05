package in.OAndM.Entities;

import jakarta.persistence.Column;

public class O_m_small_lifts_mst {
@Column(name="lis_id")
 
 private Integer  lisId;

@Column(name="lis_type")
 
 private String  lisType;

@Column(name="name_of_lis")
 
 private String  nameOfLis;

@Column(name="location_of_lis")
 
 private String  locationOfLis;

@Column(name="approach_channel_length")
 
 private Double  approachChannelLength;

@Column(name="approach_channel_req_discharge")
 
 private Double  approachChannelReqDischarge;

@Column(name="approach_channel_design_discharge")
 
 private Double  approachChannelDesignDischarge;

@Column(name="approach_channel_bedwidth")
 
 private Double  approachChannelBedwidth;

@Column(name="approach_channel_fsd")
 
 private Double  approachChannelFsd;

@Column(name="approach_channel_velocity")
 
 private Double  approachChannelVelocity;

@Column(name="approach_channel_bedfall")
 
 private String  approachChannelBedfall;

@Column(name="approach_channel_sideslope")
 
 private Double  approachChannelSideslope;

@Column(name="approach_channel_freeboard")
 
 private Double  approachChannelFreeboard;

@Column(name="approach_channel_value_of_n")
 
 private Double  approachChannelValueOfN;

@Column(name="approach_channel_fsl")
 
 private Double  approachChannelFsl;

@Column(name="approach_channel_tbl")
 
 private Double  approachChannelTbl;

@Column(name="approach_channel_twb")
 
 private Double  approachChannelTwb;

@Column(name="approach_channel_bedlevel_start")
 
 private Double  approachChannelBedlevelStart;

@Column(name="approach_channel_bedlevel_end")
 
 private Double  approachChannelBedlevelEnd;

@Column(name="gravity_canal_length")
 
 private Double  gravityCanalLength;

@Column(name="gravity_canal_req_discharge")
 
 private Double  gravityCanalReqDischarge;

@Column(name="gravity_canal_design_discharge")
 
 private Double  gravityCanalDesignDischarge;

@Column(name="gravity_canal_bedwidth")
 
 private Double  gravityCanalBedwidth;

@Column(name="gravity_canal_fsd")
 
 private Double  gravityCanalFsd;

@Column(name="gravity_canal_velocity")
 
 private Double  gravityCanalVelocity;

@Column(name="gravity_canal_bedfall")
 
 private String  gravityCanalBedfall;

@Column(name="gravity_canal_bedlevel_start")
 
 private Double  gravityCanalBedlevelStart;

@Column(name="gravity_canal_bedlevel_end")
 
 private Double  gravityCanalBedlevelEnd;

@Column(name="gravity_canal_freeboard")
 
 private Double  gravityCanalFreeboard;

@Column(name="hr_type_of_gates")
 
 private String  hrTypeOfGates;

@Column(name="hr_no_of_gates")
 
 private Integer  hrNoOfGates;

@Column(name="hr_size")
 
 private String  hrSize;

@Column(name="hr_sill_level")
 
 private Double  hrSillLevel;

@Column(name="hr_hoist_type")
 
 private String  hrHoistType;

@Column(name="hr_hoist_details")
 
 private String  hrHoistDetails;

@Column(name="hr_operating_method")
 
 private String  hrOperatingMethod;

@Column(name="trashracks_size")
 
 private Double  trashracksSize;

@Column(name="trashrack_material")
 
 private String  trashrackMaterial;

@Column(name="tunnel_diameter")
 
 private Double  tunnelDiameter;

@Column(name="tunnel_length")
 
 private Double  tunnelLength;

@Column(name="tunnel_design_discharge")
 
 private Double  tunnelDesignDischarge;

@Column(name="no_of_drafttube_tunnels")
 
 private Integer  noOfDrafttubeTunnels;

@Column(name="drafttube_tunnel_size")
 
 private String  drafttubeTunnelSize;

@Column(name="drafttube_tunnel_shape")
 
 private String  drafttubeTunnelShape;

@Column(name="drafttube_tunnel_length")
 
 private Double  drafttubeTunnelLength;

@Column(name="drafttube_tunnel_material")
 
 private String  drafttubeTunnelMaterial;

@Column(name="drafttube_tunnel_design_discharge")
 
 private Double  drafttubeTunnelDesignDischarge;

@Column(name="no_of_drafttube_tunnel_gates")
 
 private Integer  noOfDrafttubeTunnelGates;

@Column(name="drafttube_tunnel_gates_size")
 
 private String  drafttubeTunnelGatesSize;

@Column(name="drafttube_tunnel_gates_silllevel")
 
 private Double  drafttubeTunnelGatesSilllevel;

@Column(name="dt_crane_details")
 
 private String  dtCraneDetails;

@Column(name="dt_crane_capacity")
 
 private Double  dtCraneCapacity;

@Column(name="dt_crane_make")
 
 private String  dtCraneMake;

@Column(name="dt_cane_year_of_mfg")
 
 private Integer  dtCaneYearOfMfg;

@Column(name="dt_crane_model_no")
 
 private String  dtCraneModelNo;

@Column(name="pumphouse_type")
 
 private String  pumphouseType;

@Column(name="pumphouse_location")
 
 private String  pumphouseLocation;

@Column(name="pumphouse_size")
 
 private Double  pumphouseSize;

@Column(name="pumphouse_category")
 
 private String  pumphouseCategory;

@Column(name="created_by_userid")
 
 private String  createdByUserid;



@Column(name="delete_flag")
 
 private boolean  deleteFlag;

@Column(name="post_id")
 
 private String  postId;

@Column(name="project_id")
 
 private Integer  projectId;

@Column(name="file_path")
 
 private String  filePath;

@Column(name="lis_functionality")
 
 private String  lisFunctionality;

@Column(name="unit_id")
 
 private Integer  unitId;

@Column(name="circle_id")
 
 private Integer  circleId;

@Column(name="division_id")
 
 private Integer  divisionId;

@Column(name="sub_division_id")
 
 private Integer  subDivisionId;

@Column(name="civil_com_idc_id")
 
 private Integer  civilComIdcId;


}
