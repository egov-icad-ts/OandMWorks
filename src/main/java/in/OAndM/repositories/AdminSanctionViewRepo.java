package in.OAndM.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.OAndM.DTO.AdminSanctionsModel;
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
	
	@Query( "select  new in.OAndM.DTO.AdminSanctionsModel (headOfAccount, count(distinct(workId)) as workId, "
			+ "count(distinct(govtSanction)) as govtSanction,COALESCE(sum(govtSancAmount),0) as govtSancAmount,"
			+ "count(distinct(omCommiteeSanction)) as omCommiteeSanction, COALESCE(sum(committeeSancAmount),0) as committeeSancAmount, "
			+ "count(distinct(go45SanctionCe)) as go45SanctionCe, COALESCE(sum(go45SancAmountCe),0) as go45SancAmountCe,  "
			+ "count(distinct(go45SanctionSe)) as go45SanctionSe, COALESCE(sum(go45SancAmountSe),0) as go45SancAmountSe,"
			+ "count(distinct(go45SanctionEe)) as go45SanctionEe, COALESCE(sum(go45SancAmountEe),0) as go45SancAmountEe,"
			+ "count(distinct(go45SanctionDee)) as go45SanctionDee, COALESCE(sum(go45SancAmountDee),0) as go45SancAmountDee, "
			+ " COALESCE(sum(adminSanctionAmt),0) as adminSanctionAmt )"
			+ " from AdminSanctionViewEntity where financialYear = :financialYear group by headOfAccount ")
	public List<AdminSanctionsModel> getAbsRepHOAWiseByFinancialyear(@Param("financialYear") Integer financialYear);
	
	

}
