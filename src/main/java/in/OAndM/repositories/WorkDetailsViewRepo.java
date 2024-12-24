package in.OAndM.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import in.OAndM.DTO.WorkDetailsViewModel;
import in.OAndM.Entities.WorkDetailsViewEntity;
import in.OAndM.core.BaseRepository;


public interface WorkDetailsViewRepo  extends  BaseRepository<WorkDetailsViewEntity, Integer>{

	@Query("select  new in.OAndM.DTO.WorkDetailsViewModel(w.approvedById as approvedId,w.approvedName as approvedName,"
			+ "count(distinct(w.workId)) as adminCount, COALESCE(sum(w.adminApprovedAmount),0) as adminAmt,"
			+ "count(distinct(w.techWorkId)) as techCount, COALESCE(sum(w.tsApprovedAmount),0) as techAmt,"
			+ "count(distinct(w.agrWorkId)) as agreementCount, COALESCE(sum(w.agreementAmount),0) as agreementAmt, "
			+ "count(distinct(w.actionToBeTakenCount)) as actionToBeTakenCount, COALESCE(sum(w.actionToBeTakenAmt),0) as actionToBeTakenAmt,"
			+ "count(distinct(w.billsPaid)) as billsPaidCount, COALESCE(sum(w.paidAmount),0) as billsPaidAmount, "
			+ "count(distinct(w.billsPending)) as billsPendingCount, COALESCE(sum(w.pendingAmount),0) as billsPendingAmount) "
			+ " from WorkDetailsViewEntity  w where   w.finyear = :finyear group by w.approvedById,w.approvedName")
	public List<WorkDetailsViewModel> getWorksByFinyear(Integer finyear,String condition);
	
	
	@Query("select  new in.OAndM.DTO.WorkDetailsViewModel(w.workTypeId as approvedId,w.workTypeName as approvedName,"
			+ "count(distinct(w.workId)) as adminCount, COALESCE(sum(w.adminApprovedAmount),0) as adminAmt,"
			+ "count(distinct(w.techWorkId)) as techCount, COALESCE(sum(w.tsApprovedAmount),0) as techAmt,"
			+ "count(distinct(w.agrWorkId)) as agreementCount, COALESCE(sum(w.agreementAmount),0) as agreementAmt, "
			+ "count(distinct(w.actionToBeTakenCount)) as actionToBeTakenCount, COALESCE(sum(w.actionToBeTakenAmt),0) as actionToBeTakenAmt,"
			+ "count(distinct(w.billsPaid)) as billsPaidCount, COALESCE(sum(w.paidAmount),0) as billsPaidAmount, "
			+ "count(distinct(w.billsPending)) as billsPendingCount, COALESCE(sum(w.pendingAmount),0) as billsPendingAmount) "
			+ " from WorkDetailsViewEntity  w where   w.finyear = :finyear group by w.workTypeId,w.workTypeName")
	public List<WorkDetailsViewModel> getWorksByWorkcategoryByFinyear(Integer finyear);



}
