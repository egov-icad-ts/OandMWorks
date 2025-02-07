package in.OAndM.repositories;

import java.util.List;

import in.OAndM.Entities.AgreementsEntity;
import in.OAndM.Entities.UploadGOsEntity;
import in.OAndM.core.BaseRepository;

public interface UploadGOsRepo extends  BaseRepository<UploadGOsEntity, Integer>{
	
	public List<UploadGOsEntity> findByuploadTypeAndDeleteFlagFalse(String type);

}

