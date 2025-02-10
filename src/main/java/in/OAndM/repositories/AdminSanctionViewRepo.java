package in.OAndM.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.OAndM.DTO.AdminSanctionViewModel;
import in.OAndM.Entities.AdminSanctionViewEntity;
import in.OAndM.core.BaseRepository;

public interface AdminSanctionViewRepo extends BaseRepository<AdminSanctionViewEntity, Integer> {


	public List<AdminSanctionViewEntity> findByFinancialYearAndUnitIdAndApprovedById(Integer finYear, Integer unitId,
			Integer approvedId);

	public List<AdminSanctionViewEntity> findByFinancialYearAndUnitIdAndCircleIdAndApprovedById(Integer finYear, Integer unitId,
			Integer circleId, Integer approvedId);

	public List<AdminSanctionViewEntity> findByFinancialYearAndUnitIdAndCircleIdAndDivisionIdAndApprovedById(Integer finYear,
			Integer unitId, Integer circleId, Integer divisionId, Integer approvedId);

	public List<AdminSanctionViewEntity> findByFinancialYearAndUnitIdAndCircleIdAndDivisionIdAndSubDivisionIdAndApprovedById(
			Integer finYear, Integer unitId, Integer circleId, Integer divisionId, Integer subDivisionId,
			Integer approvedId);
	
	@Query( "select  new in.OAndM.DTO.AdminSanctionViewModel (hoaId as hoaId,headOfAccount as headOfAccount, count(distinct(workId)) as longWorkId "
			+ ",count(distinct(govtSanction)) as govtSanction,COALESCE(sum(govtSancAmount/ 100000),0) as govtSancAmount,"
			+ "count(distinct(omCommiteeSanction)) as omCommiteeSanction, COALESCE(sum(committeeSancAmount/ 100000),0) as committeeSancAmount, "
			+ "count(distinct(go45SanctionCe)) as go45SanctionCe, COALESCE(sum(go45SancAmountCe/ 100000),0) as go45SancAmountCe,  "
			+ "count(distinct(go45SanctionSe)) as go45SanctionSe, COALESCE(sum(go45SancAmountSe/ 100000),0) as go45SancAmountSe,"
			+ "count(distinct(go45SanctionEe)) as go45SanctionEe, COALESCE(sum(go45SancAmountEe/ 100000),0) as go45SancAmountEe,"
			+ "count(distinct(go45SanctionDee)) as go45SanctionDee, COALESCE(sum(go45SancAmountDee/ 100000),0) as go45SancAmountDee, "
			+ " COALESCE(sum(adminSanctionAmt/ 100000),0) as adminSanctionAmt )"
			+ " from AdminSanctionViewEntity where financialYear = :financialYear group by hoaId,headOfAccount ")
	public List<AdminSanctionViewModel> getAbsRepHOAWiseByFinancialyear(Integer financialYear);
	
	@Query( "select  new in.OAndM.DTO.AdminSanctionViewModel (unitId as unitId,unitName as unitName,hoaId as hoaId,headOfAccount as headOfAccount, count(distinct(workId)) as longWorkId "
			+ ",count(distinct(govtSanction)) as govtSanction, COALESCE(SUM(govtSancAmount / 100000), 0) as govtSancAmount, "
			+ "count(distinct(omCommiteeSanction)) as omCommiteeSanction, COALESCE(sum(committeeSancAmount/ 100000),0) as committeeSancAmount, "
			+ "count(distinct(go45SanctionCe)) as go45SanctionCe, COALESCE(sum(go45SancAmountCe/ 100000),0) as go45SancAmountCe,  "
			+ "count(distinct(go45SanctionSe)) as go45SanctionSe, COALESCE(sum(go45SancAmountSe/ 100000),0) as go45SancAmountSe,"
			+ "count(distinct(go45SanctionEe)) as go45SanctionEe, COALESCE(sum(go45SancAmountEe/ 100000),0) as go45SancAmountEe,"
			+ "count(distinct(go45SanctionDee)) as go45SanctionDee, COALESCE(sum(go45SancAmountDee/ 100000),0) as go45SancAmountDee, "
			+ " COALESCE(sum(adminSanctionAmt/ 100000),0) as adminSanctionAmt )"
			+ " from AdminSanctionViewEntity where financialYear = :financialYear group by hoaId,headOfAccount,unitId,unitName order by unitId,unitName,hoaId")
	public List<AdminSanctionViewModel> getAbsRepUnitHOAWiseFinyear(Integer financialYear);
	

	
	

}
