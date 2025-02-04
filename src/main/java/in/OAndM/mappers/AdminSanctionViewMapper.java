package in.OAndM.mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import in.OAndM.core.BaseMapperImpl;
import in.OAndM.DTO.AdminSanctionsModel;
import in.OAndM.Entities.AdminSanctionViewEntity;

@Component
public class AdminSanctionViewMapper extends BaseMapperImpl<AdminSanctionViewEntity, AdminSanctionsModel>{
	

		@Override
		public AdminSanctionsModel mapEntityToModel(AdminSanctionViewEntity entity) {
			// TODO Auto-generated method stub
			
			AdminSanctionsModel model = new AdminSanctionsModel();
			BeanUtils.copyProperties(entity, model);
			return model;
		}

		@Override
		public AdminSanctionViewEntity mapModelToEntity(AdminSanctionsModel model) {
			// TODO Auto-generated method stub
			AdminSanctionViewEntity entity = new AdminSanctionViewEntity();
			BeanUtils.copyProperties(model, entity);
			return entity;
		}

	}


