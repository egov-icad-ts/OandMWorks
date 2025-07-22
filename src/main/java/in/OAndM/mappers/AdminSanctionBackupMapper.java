package in.OAndM.mappers;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import in.OAndM.DTO.AdminSanctionsModel;
import in.OAndM.Entities.AdminSanctionsBackupEntity;
import in.OAndM.Entities.AdminSanctionsEntity;
import in.OAndM.core.BaseMapperImpl;

	
@Component
public class AdminSanctionBackupMapper extends BaseMapperImpl<AdminSanctionsBackupEntity, AdminSanctionsModel> {

    @Override
    public AdminSanctionsModel mapEntityToModel(AdminSanctionsBackupEntity entity) {
        AdminSanctionsModel model = new AdminSanctionsModel();
        BeanUtils.copyProperties(entity, model);
        return model;
    }

    @Override
    public AdminSanctionsBackupEntity mapModelToEntity(AdminSanctionsModel model) {
        AdminSanctionsBackupEntity entity = new AdminSanctionsBackupEntity();
        BeanUtils.copyProperties(model, entity);
        return entity;
    }

    // 🔧 This is the method you need
    public AdminSanctionsBackupEntity mapFromMainEntity(AdminSanctionsEntity entity) {
        AdminSanctionsBackupEntity backupEntity = new AdminSanctionsBackupEntity();
        BeanUtils.copyProperties(entity, backupEntity);
        return backupEntity;
    }
}

