package in.OAndM.repositories;

import java.util.List;

import in.OAndM.Entities.AdminSanctionsEntity;
import in.OAndM.core.BaseRepository;


public interface AdminSanctionRepo  extends  BaseRepository<AdminSanctionsEntity, Integer>{
	
public List<AdminSanctionsEntity> findByunitIdAndFinancialYearAndIsLatestAndDeleteFlag(Integer unit,Integer finyear,Boolean isLatest,Boolean deleteFlag);


public AdminSanctionsEntity findByunitIdAndFinancialYearAndIsLatestAndDeleteFlagAndTechnEntriesIsLatestAndTechnEntriesTsId(Integer unit,Integer finyear,Boolean isLatest,Boolean deleteFlag,Boolean tech_is_latest,Integer tsId);

public AdminSanctionsEntity findByworkIdAndIsLatestAndDeleteFlagAndTechnEntriesIsLatestAndTechnEntriesDeleteFlag(Integer workId,Boolean isLatest,Boolean deleteFlag,Boolean tech_is_latest,Boolean tech_delete_flag);

public List<AdminSanctionsEntity> findByunitIdAndFinancialYearAndIsLatestAndDeleteFlagAndCircleIdAndDivisionIdAndSubDivisionIdAndIsAssignedAndTechnEntriesIsLatestAndTechnEntriesDeleteFlag
(Integer unit,Integer finyear,Boolean isLatest,Boolean deleteFlag,Integer circleId,Integer DivisionId,Integer SubDivisionId,Boolean isAssigned,Boolean tech_is_latest,Boolean deleteflag);



}
