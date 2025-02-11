package in.OAndM.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import in.OAndM.DTO.WorkDetailsViewModel;
import in.OAndM.Entities.AdminSanctionViewEntity;
import in.OAndM.Entities.WorkDetailsViewEntity;
import in.OAndM.core.BaseRepository;

public interface WorkDetailsViewRepo extends BaseRepository<WorkDetailsViewEntity, Integer> {

	@Query("select  new in.OAndM.DTO.WorkDetailsViewModel(aa.approvedById as approvedId,aa.approvedByName as approvedName,"
			+ "count(distinct(aa.workId)) as adminCount, COALESCE(sum(aa.adminApprovedAmountLakh),0) as adminAmt,"
			+ "count(distinct(wd.techWorkId)) as techCount, COALESCE(sum(wd.tsApprovedAmountLakhs),0) as techAmt,"
			+ "count(distinct(wd.agrWorkId)) as agreementCount, COALESCE(sum(wd.agreementAmountLakhs),0) as agreementAmt, "
			+ "count(distinct(wd.actionToBeTakenCount)) as actionToBeTakenCount, COALESCE((sum(wd.actionToBeTakenAmt))/100000,0) as actionToBeTakenAmt,"
			+ "count(distinct(wd.billsPaid)) as billsPaid, COALESCE(sum(wd.paidAmountLakh),0) as paidAmount, "
			+ "count(distinct(wd.billsPending)) as billsPending, COALESCE(sum(wd.pendingAmountLakh),0) as pendingAmount) "
			+ " from AdminSanctionViewEntity  aa left join  WorkDetailsViewEntity wd on aa.workId =wd.techWorkId where   aa.financialYear = :finyear group by aa.approvedById,aa.approvedByName")
	public List<WorkDetailsViewModel> getAbsRepSanctionAuthorityWiseByFinyear(Integer finyear);

	@Query("select  new in.OAndM.DTO.WorkDetailsViewModel(aa.approvedById as approvedId,aa.approvedByName as approvedName,"
			+ "count(distinct(aa.workId)) as adminCount, COALESCE(sum(aa.adminApprovedAmountLakh),0) as adminAmt,"
			+ "count(distinct(wd.techWorkId)) as techCount, COALESCE(sum(wd.tsApprovedAmountLakhs),0) as techAmt,"
			+ "count(distinct(wd.agrWorkId)) as agreementCount, COALESCE(sum(wd.agreementAmountLakhs),0) as agreementAmt, "
			+ "count(distinct(wd.actionToBeTakenCount)) as actionToBeTakenCount, COALESCE((sum(wd.actionToBeTakenAmt))/100000,0) as actionToBeTakenAmt,"
			+ "count(distinct(wd.billsPaid)) as billsPaid, COALESCE(sum(wd.paidAmountLakh),0) as paidAmount, "
			+ "count(distinct(wd.billsPending)) as billsPending, COALESCE(sum(wd.pendingAmountLakh),0) as pendingAmount) "
			+ " from AdminSanctionViewEntity  aa left join  WorkDetailsViewEntity wd on aa.workId =wd.techWorkId where   aa.financialYear=:finyear and aa.unitId=:unitId "
			+ " and aa.circleId=:circleId and aa.divisionId=:divisionId and aa.subDivisionId=:SubDivisionId group by aa.approvedById,aa.approvedByName")
	public List<WorkDetailsViewModel> getAbsRepSanctionAuthorityWiseDEE(Integer finyear, Integer unitId,
			Integer circleId, Integer divisionId, Integer SubDivisionId);

	@Query("select  new in.OAndM.DTO.WorkDetailsViewModel(aa.approvedById as approvedId,aa.approvedByName as approvedName,"
			+ "count(distinct(aa.workId)) as adminCount, COALESCE(sum(aa.adminApprovedAmountLakh),0) as adminAmt,"
			+ "count(distinct(wd.techWorkId)) as techCount, COALESCE(sum(wd.tsApprovedAmountLakhs),0) as techAmt,"
			+ "count(distinct(wd.agrWorkId)) as agreementCount, COALESCE(sum(wd.agreementAmountLakhs),0) as agreementAmt, "
			+ "count(distinct(wd.actionToBeTakenCount)) as actionToBeTakenCount, COALESCE((sum(wd.actionToBeTakenAmt))/100000,0) as actionToBeTakenAmt,"
			+ "count(distinct(wd.billsPaid)) as billsPaid, COALESCE(sum(wd.paidAmountLakh),0) as paidAmount, "
			+ "count(distinct(wd.billsPending)) as billsPending, COALESCE(sum(wd.pendingAmountLakh),0) as pendingAmount) "
			+ " from AdminSanctionViewEntity  aa left join  WorkDetailsViewEntity wd on aa.workId =wd.techWorkId where   aa.financialYear=:finyear and aa.unitId=:unitId "
			+ " and aa.circleId=:circleId and aa.divisionId=:divisionId group by aa.approvedById,aa.approvedByName")
	public List<WorkDetailsViewModel> getAbsRepSanctionAuthorityWiseEE(Integer finyear, Integer unitId,
			Integer circleId, Integer divisionId);

	@Query("select  new in.OAndM.DTO.WorkDetailsViewModel(aa.approvedById as approvedId,aa.approvedByName as approvedName,"
			+ "count(distinct(aa.workId)) as adminCount, COALESCE(sum(aa.adminApprovedAmountLakh),0) as adminAmt,"
			+ "count(distinct(wd.techWorkId)) as techCount, COALESCE(sum(wd.tsApprovedAmountLakhs),0) as techAmt,"
			+ "count(distinct(wd.agrWorkId)) as agreementCount, COALESCE(sum(wd.agreementAmountLakhs),0) as agreementAmt, "
			+ "count(distinct(wd.actionToBeTakenCount)) as actionToBeTakenCount, COALESCE((sum(wd.actionToBeTakenAmt))/100000,0) as actionToBeTakenAmt,"
			+ "count(distinct(wd.billsPaid)) as billsPaid, COALESCE(sum(wd.paidAmountLakh),0) as paidAmount, "
			+ "count(distinct(wd.billsPending)) as billsPending, COALESCE(sum(wd.pendingAmountLakh),0) as pendingAmount) "
			+ " from AdminSanctionViewEntity  aa left join  WorkDetailsViewEntity wd on aa.workId =wd.techWorkId where   aa.financialYear=:finyear and aa.unitId=:unitId "
			+ " and aa.circleId=:circleId group by aa.approvedById,aa.approvedByName")
	public List<WorkDetailsViewModel> getAbsRepSanctionAuthorityWiseSE(Integer finyear, Integer unitId,
			Integer circleId);

	@Query("select  new in.OAndM.DTO.WorkDetailsViewModel(aa.approvedById as approvedId,aa.approvedByName as approvedName,"
			+ "count(distinct(aa.workId)) as adminCount, COALESCE(sum(aa.adminApprovedAmountLakh),0) as adminAmt,"
			+ "count(distinct(wd.techWorkId)) as techCount, COALESCE(sum(wd.tsApprovedAmountLakhs),0) as techAmt,"
			+ "count(distinct(wd.agrWorkId)) as agreementCount, COALESCE(sum(wd.agreementAmountLakhs),0) as agreementAmt, "
			+ "count(distinct(wd.actionToBeTakenCount)) as actionToBeTakenCount, COALESCE((sum(wd.actionToBeTakenAmt))/100000,0) as actionToBeTakenAmt,"
			+ "count(distinct(wd.billsPaid)) as billsPaid, COALESCE(sum(wd.paidAmountLakh),0) as paidAmount, "
			+ "count(distinct(wd.billsPending)) as billsPending, COALESCE(sum(wd.pendingAmountLakh),0) as pendingAmount) "
			+ " from AdminSanctionViewEntity  aa left join  WorkDetailsViewEntity wd on aa.workId =wd.techWorkId where   aa.financialYear=:finyear and aa.unitId=:unitId "
			+ " group by aa.approvedById,aa.approvedByName")
	public List<WorkDetailsViewModel> getAbsRepSanctionAuthorityWiseCE(Integer finyear, Integer unitId);

	@Query("select  new in.OAndM.DTO.WorkDetailsViewModel(aa.workTypeId as approvedId,aa.workTypeName as approvedName,"
			+ "count(distinct(aa.workId)) as adminCount, COALESCE(sum(aa.adminApprovedAmountLakh),0) as adminAmt,"
			+ "count(distinct(wd.techWorkId)) as techCount, COALESCE(sum(wd.tsApprovedAmountLakhs),0) as techAmt,"
			+ "count(distinct(wd.agrWorkId)) as agreementCount, COALESCE(sum(wd.agreementAmountLakhs),0) as agreementAmt, "
			+ "count(distinct(wd.actionToBeTakenCount)) as actionToBeTakenCount, COALESCE((sum(wd.actionToBeTakenAmt))/100000,0) as actionToBeTakenAmt,"
			+ "count(distinct(wd.billsPaid)) as billsPaid, COALESCE(sum(wd.paidAmountLakh),0) as paidAmount, "
			+ "count(distinct(wd.billsPending)) as billsPending, COALESCE(sum(wd.pendingAmountLakh),0) as pendingAmount) "
			+ " from AdminSanctionViewEntity  aa left join  WorkDetailsViewEntity wd on aa.workId =wd.techWorkId where   aa.financialYear=:finyear and aa.unitId=:unitId "
			+ " group by aa.workTypeId,aa.workTypeName")
	
	public List<WorkDetailsViewModel> getWorksByWorkcategoryByFinyear(Integer finyear);

	@Query("select  new in.OAndM.DTO.WorkDetailsViewModel(aa.unitId as unitId,aa.unitName as unitName,"
			+ "count(distinct(aa.workId)) as adminCount, COALESCE(sum(aa.adminApprovedAmountLakh),0) as adminAmt,"
			+ "count(distinct(aa.govtSanction)) as govtSanction, COALESCE(SUM(aa.govtSancAmount / 100000), 0) as govtSancAmount,"
			+ " count(distinct(aa.omCommiteeSanction)) as omCommiteeSanction, COALESCE(sum(aa.committeeSancAmount/ 100000),0) as committeeSancAmount,"
			+ " count(distinct(aa.go45Sanction)) as go45Sanction, COALESCE(sum(aa.go45SancAmount/ 100000),0) as go45SancAmount,"
			+ "count(distinct(wd.techWorkId)) as techCount, COALESCE(sum(wd.tsApprovedAmountLakhs),0) as techAmt,"
			+ "count(distinct(wd.agrWorkId)) as agreementCount, COALESCE(sum(wd.agreementAmountLakhs),0) as agreementAmt, "
			+ "  count(distinct case when aa.workId>0 and wd.techWorkId is null then aa.workId else null end ) as actionToBeTakenCount,"
			+ " COALESCE(sum(case when aa.workId>0 and wd.techWorkId is null then aa.adminApprovedAmountLakh else null end),0 ) as actionToBeTakenAmt,"
			+ "count(distinct(wd.billsPaid)) as billsPaid, COALESCE(sum(wd.paidAmountLakh),0) as paidAmount, "
			+ "count(distinct(wd.billsPending)) as billsPending, COALESCE(sum(wd.pendingAmountLakh),0) as pendingAmount) "
			+ " from AdminSanctionViewEntity  aa left join  WorkDetailsViewEntity wd on aa.workId =wd.techWorkId where   aa.financialYear=:finyear "
			+ " group by aa.unitId,aa.unitName")
	public List<WorkDetailsViewModel> getAbsRepUnitWiseFinyear(Integer finyear);
	
	@Query("select  new in.OAndM.DTO.WorkDetailsViewModel(aa.headOfAccount as headOfAccount,aa.workTypeId as workTypeId,aa.workTypeName as workTypeName,"
			+ "count(distinct(aa.workId)) as adminCount, COALESCE(sum(aa.adminApprovedAmountLakh),0) as adminAmt,"
			+ "count(distinct(wd.techWorkId)) as techCount, COALESCE(sum(wd.tsApprovedAmountLakhs),0) as techAmt,"
			+ "count(distinct(wd.agrWorkId)) as agreementCount, COALESCE(sum(wd.agreementAmountLakhs),0) as agreementAmt, "
			+ "  count(distinct case when aa.workId>0 and wd.techWorkId is null then aa.workId else null end ) as actionToBeTakenCount,"
			+ " COALESCE(sum(case when aa.workId>0 and wd.techWorkId is null then aa.adminApprovedAmountLakh else null end),0 ) as actionToBeTakenAmt,"
			+ "count(distinct(wd.billsPaid)) as billsPaid, COALESCE(sum(wd.paidAmountLakh),0) as paidAmount, "
			+ "count(distinct(wd.billsPending)) as billsPending, COALESCE(sum(wd.pendingAmountLakh),0) as pendingAmount) "
			+ " from AdminSanctionViewEntity  aa left join  WorkDetailsViewEntity wd on aa.workId =wd.techWorkId where   aa.financialYear=:finyear "
			+ " group by aa.headOfAccount,aa.workTypeId,aa.workTypeName")
	public List<WorkDetailsViewModel> getAbsRepWorkTypeHOAWiseFinyear(Integer finyear);
	
	@Query("select  new in.OAndM.DTO.WorkDetailsViewModel(aa.workTypeId as workTypeId,aa.workTypeName as workTypeName,"
			+ "count(distinct(aa.workId)) as adminCount, COALESCE(sum(aa.adminApprovedAmountLakh),0) as adminAmt,"
			+ "count(distinct(wd.techWorkId)) as techCount, COALESCE(sum(wd.tsApprovedAmountLakhs),0) as techAmt,"
			+ "count(distinct(wd.agrWorkId)) as agreementCount, COALESCE(sum(wd.agreementAmountLakhs),0) as agreementAmt, "
			+ "  count(distinct case when aa.workId>0 and wd.techWorkId is null then aa.workId else null end ) as actionToBeTakenCount,"
			+ " COALESCE(sum(case when aa.workId>0 and wd.techWorkId is null then aa.adminApprovedAmountLakh else null end),0 ) as actionToBeTakenAmt,"
			+ "count(distinct(wd.billsPaid)) as billsPaid, COALESCE(sum(wd.paidAmountLakh),0) as paidAmount, "
			+ "count(distinct(wd.billsPending)) as billsPending, COALESCE(sum(wd.pendingAmountLakh),0) as pendingAmount) "
			+ " from AdminSanctionViewEntity  aa left join  WorkDetailsViewEntity wd on aa.workId =wd.techWorkId where   aa.financialYear=:finyear "
			+ " group by aa.workTypeId,aa.workTypeName")
	public List<WorkDetailsViewModel> getAbsRepWorkTypeWiseFinyear(Integer finyear);
	
	@Query("select  new in.OAndM.DTO.WorkDetailsViewModel(aa.authorityType as authorityType, aa.workTypeId as workTypeId,aa.workTypeName as workTypeName,"
			+ "count(distinct(aa.workId)) as adminCount, COALESCE(sum(aa.adminApprovedAmountLakh),0) as adminAmt,"
			+ "count(distinct(wd.techWorkId)) as techCount, COALESCE(sum(wd.tsApprovedAmountLakhs),0) as techAmt,"
			+ "count(distinct(wd.agrWorkId)) as agreementCount, COALESCE(sum(wd.agreementAmountLakhs),0) as agreementAmt, "
			+ "  count(distinct case when aa.workId>0 and wd.techWorkId is null then aa.workId else null end ) as actionToBeTakenCount,"
			+ " COALESCE(sum(case when aa.workId>0 and wd.techWorkId is null then aa.adminApprovedAmountLakh else null end),0 ) as actionToBeTakenAmt,"
			+ "count(distinct(wd.billsPaid)) as billsPaid, COALESCE(sum(wd.paidAmountLakh),0) as paidAmount, "
			+ "count(distinct(wd.billsPending)) as billsPending, COALESCE(sum(wd.pendingAmountLakh),0) as pendingAmount) "
			+ " from AdminSanctionViewEntity  aa left join  WorkDetailsViewEntity wd on aa.workId =wd.techWorkId where   aa.financialYear=:finyear "
			+ " group by aa.authorityType,aa.workTypeId,aa.workTypeName")
	public List<WorkDetailsViewModel> getAbsRepSanctionAuthWorkTypeWiseFinyear(Integer finyear);

}
