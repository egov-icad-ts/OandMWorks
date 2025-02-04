package in.OAndM.repositories;

import java.util.List;

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
}
