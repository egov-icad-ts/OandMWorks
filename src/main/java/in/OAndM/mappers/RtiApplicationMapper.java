package in.OAndM.mappers;

import in.OAndM.Entities.RTIApplication;
import in.OAndM.DTO.RtiApplicationDto;
import in.OAndM.core.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RtiApplicationMapper implements BaseMapper<RTIApplication, RtiApplicationDto> {

    @Override
    public RtiApplicationDto mapEntityToModel(RTIApplication entity) {
        if (entity == null) {
            return null;
        }
        
        RtiApplicationDto dto = new RtiApplicationDto();
        dto.setApplicationId(entity.getApplicationId());
        dto.setAppnDate(entity.getAppndate());
        dto.setApptName(entity.getApptName());
        dto.setApptAddress(entity.getApptAddress());
        dto.setPioRecDate(entity.getPioReceiptDate());
        dto.setApptCategory(entity.getApplicantCategory());
        dto.setDescInfoReq(entity.getDescriptionInfoRequest());
        dto.setThirdParty(entity.getThirdParty());
        dto.setAppnFee(entity.getApplicationFee());
        dto.setChargesCollected(entity.getChargesCollected());
        dto.setTotAmt(entity.getTotalAmount());
        dto.setIsTransferred(entity.getIsTransferred());
        dto.setTransDate(entity.getTransferDate());
        dto.setTransName(entity.getTransferName());
        dto.setDeemedPio(entity.getDeemedPIO());
        dto.setInfoPartFull(entity.getInfoPartFull());
        dto.setRejectDate(entity.getRejectionDate());
        dto.setRejectSectionId(entity.getRejectedSectionId());
        if (entity.getRejectionSectionStatus() == null || entity.getRejectionSectionStatus().getRejectSectionId() ==0) {
        	//System.out.println("section status is null");
        	dto.setRejectionSectionStatus(null);
        }
        if (entity.getRejectionSectionStatus() != null && entity.getRejectionSectionStatus().getRejectSectionId() >0 ) {
            dto.setRejectSectionId(entity.getRejectionSectionStatus().getRejectSectionId());
            dto.setRtiRejectionSection(entity.getRejectionSectionStatus().getRtiRejectionSection());
        }
        dto.setDeemedRefusal(entity.getDeemedRefusal());
        dto.setAppealMade(entity.getAppealMade());
        dto.setRemarks(entity.getRemarks());
        dto.setIsLatest(entity.getIsLatest());
        dto.setDeleteFlag(entity.getDeleteFlag());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreateDate(entity.getCreateDate());
        dto.setUnitId(entity.getUnitId());
        dto.setCircleId(entity.getCircleId());
        dto.setDivisionId(entity.getDivisionId());
        dto.setSubdivisionId(entity.getSubdivisionId());
        dto.setDesignationId(entity.getDesignationId());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setUpdateDate(entity.getUpdatedDate());
        dto.setDeletedBy(entity.getDeletedBy());
        dto.setDeletedDate(entity.getDeletedDate());
        dto.setInfoFurnDate(entity.getInfoFurnishedDate());
        dto.setInfoPartDate(entity.getInfoPartDate());
        dto.setInfoFullDate(entity.getInfoFullDate());
        dto.setCreatedPostId(entity.getCreatedPostId());
        dto.setAppnNum(entity.getAppnnum());
        dto.setTransMode(entity.getTransferMode());
        dto.setTransAmt(entity.getTransferAmount());
        dto.setRefusedDate(entity.getRefusedDate());
        
        return dto;
    }

    @Override
    public RTIApplication mapModelToEntity(RtiApplicationDto model) {
        if (model == null) {
            return null;
        }
        
        RTIApplication entity = new RTIApplication();
        entity.setApplicationId(model.getApplicationId());
        entity.setAppndate(model.getAppnDate());
        entity.setApptName(model.getApptName());
        entity.setApptAddress(model.getApptAddress());
        entity.setPioReceiptDate(model.getPioRecDate());
        entity.setApplicantCategory(model.getApptCategory());
        entity.setDescriptionInfoRequest(model.getDescInfoReq());
        entity.setThirdParty(model.getThirdParty());
        entity.setApplicationFee(model.getAppnFee());
        entity.setChargesCollected(model.getChargesCollected());
        entity.setTotalAmount(model.getTotAmt());
        entity.setIsTransferred(model.getIsTransferred());
        entity.setTransferDate(model.getTransDate());
        entity.setTransferName(model.getTransName());
        entity.setDeemedPIO(model.getDeemedPio());
        entity.setInfoPartFull(model.getInfoPartFull());
        entity.setRejectionDate(model.getRejectDate());
        entity.setRejectedSectionId(model.getRejectSectionId());
        if (model.getRejectSectionId() == null) {
            System.out.println("Reject Section ID is null, assigning default value 0.");
        }
        entity.setDeemedRefusal(model.getDeemedRefusal());
        entity.setAppealMade(model.getAppealMade());
        entity.setRemarks(model.getRemarks());
        entity.setIsLatest(model.getIsLatest());
        entity.setDeleteFlag(model.getDeleteFlag());
        entity.setCreatedBy(model.getCreatedBy());
        entity.setCreateDate(model.getCreateDate());
        entity.setUnitId(model.getUnitId());
        entity.setCircleId(model.getCircleId());
        entity.setDivisionId(model.getDivisionId());
        entity.setSubdivisionId(model.getSubdivisionId());
        entity.setDesignationId(model.getDesignationId());
        entity.setUpdatedBy(model.getUpdatedBy());
        entity.setUpdatedDate(model.getUpdateDate());
        entity.setDeletedBy(model.getDeletedBy());
        entity.setDeletedDate(model.getDeletedDate());
        entity.setInfoFurnishedDate(model.getInfoFurnDate());
        entity.setInfoPartDate(model.getInfoPartDate());
        entity.setInfoFullDate(model.getInfoFullDate());
        entity.setCreatedPostId(model.getCreatedPostId());
        entity.setAppnnum(model.getAppnNum());
        entity.setTransferMode(model.getTransMode());
        entity.setTransferAmount(model.getTransAmt());
        entity.setRefusedDate(model.getRefusedDate());
        
        return entity;
    }

    @Override
    public List<RtiApplicationDto> mapEntityToModel(List<RTIApplication> entities) {
        return entities.stream()
                .map(this::mapEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<RTIApplication> mapModelToEntity(List<RtiApplicationDto> models) {
        return models.stream()
                .map(this::mapModelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void mapModelToEntity(RTIApplication entity, RtiApplicationDto model) {
        if (entity == null || model == null) {
            return;
        }
        
        entity.setApplicationId(model.getApplicationId());
        entity.setAppndate(model.getAppnDate());
        entity.setApptName(model.getApptName());
        entity.setApptAddress(model.getApptAddress());
        entity.setPioReceiptDate(model.getPioRecDate());
        entity.setDescriptionInfoRequest(model.getDescInfoReq());
        entity.setThirdParty(model.getThirdParty());
        entity.setApplicationFee(model.getAppnFee());
        entity.setChargesCollected(model.getChargesCollected());
        entity.setTotalAmount(model.getTotAmt());
        entity.setIsTransferred(model.getIsTransferred());
        entity.setTransferDate(model.getTransDate());
        entity.setTransferName(model.getTransName());
        entity.setDeemedPIO(model.getDeemedPio());
        entity.setInfoPartFull(model.getInfoPartFull());
        entity.setRejectionDate(model.getRejectDate());
        entity.setRejectedSectionId(model.getRejectSectionId());
        entity.setDeemedRefusal(model.getDeemedRefusal());
        entity.setAppealMade(model.getAppealMade());
        entity.setRemarks(model.getRemarks());
        entity.setIsLatest(model.getIsLatest());
        entity.setDeleteFlag(model.getDeleteFlag());
        entity.setCreatedBy(model.getCreatedBy());
        entity.setCreateDate(model.getCreateDate());
        entity.setUnitId(model.getUnitId());
        entity.setCircleId(model.getCircleId());
        entity.setDivisionId(model.getDivisionId());
        entity.setSubdivisionId(model.getSubdivisionId());
        entity.setDesignationId(model.getDesignationId());
        entity.setUpdatedBy(model.getUpdatedBy());
        entity.setUpdatedDate(model.getUpdateDate());
        entity.setDeletedBy(model.getDeletedBy());
        entity.setDeletedDate(model.getDeletedDate());
        entity.setInfoFurnishedDate(model.getInfoFurnDate());
        entity.setInfoPartDate(model.getInfoPartDate());
        entity.setInfoFullDate(model.getInfoFullDate());
        entity.setCreatedPostId(model.getCreatedPostId());
        entity.setAppnnum(model.getAppnNum());
        entity.setTransferMode(model.getTransMode());
        entity.setTransferAmount(model.getTransAmt());
        entity.setRefusedDate(model.getRefusedDate());
    }

    @Override
    public void mapEntityToModel(RTIApplication entity, RtiApplicationDto model) {
        if (entity == null || model == null) {
            return;
        }
        
        model.setApplicationId(entity.getApplicationId());
        model.setAppnDate(entity.getAppndate());
        model.setApptName(entity.getApptName());
        model.setApptAddress(entity.getApptAddress());
        model.setPioRecDate(entity.getPioReceiptDate());
        model.setApptCategory(entity.getApplicantCategory());
        model.setDescInfoReq(entity.getDescriptionInfoRequest());
        model.setThirdParty(entity.getThirdParty());
        model.setAppnFee(entity.getApplicationFee());
        model.setChargesCollected(entity.getChargesCollected());
        model.setTotAmt(entity.getTotalAmount());
        model.setIsTransferred(entity.getIsTransferred());
        model.setTransDate(entity.getTransferDate());
        model.setTransName(entity.getTransferName());
        model.setDeemedPio(entity.getDeemedPIO());
        model.setInfoPartFull(entity.getInfoPartFull());
        model.setRejectDate(entity.getRejectionDate());
        model.setRejectSectionId(entity.getRejectedSectionId());
        if (entity.getRejectionSectionStatus() == null || entity.getRejectionSectionStatus().getRejectSectionId() ==0) {
        	System.out.println("section status is null");
        	model.setRejectionSectionStatus(null);
        }

        if (entity.getRejectionSectionStatus() != null && entity.getRejectionSectionStatus().getRejectSectionId() >0 ) {
            model.setRejectSectionId(entity.getRejectionSectionStatus().getRejectSectionId());
            model.setRtiRejectionSection(entity.getRejectionSectionStatus().getRtiRejectionSection());
        }
        model.setDeemedRefusal(entity.getDeemedRefusal());
        model.setAppealMade(entity.getAppealMade());
        model.setRemarks(entity.getRemarks());
        model.setIsLatest(entity.getIsLatest());
        model.setDeleteFlag(entity.getDeleteFlag());
        model.setCreatedBy(entity.getCreatedBy());
        model.setCreateDate(entity.getCreateDate());
        model.setUnitId(entity.getUnitId());
        model.setCircleId(entity.getCircleId());
        model.setDivisionId(entity.getDivisionId());
        model.setSubdivisionId(entity.getSubdivisionId());
        model.setDesignationId(entity.getDesignationId());
        model.setUpdatedBy(entity.getUpdatedBy());
        model.setUpdateDate(entity.getUpdatedDate());
        model.setDeletedBy(entity.getDeletedBy());
        model.setDeletedDate(entity.getDeletedDate());
        model.setInfoFurnDate(entity.getInfoFurnishedDate());
        model.setInfoPartDate(entity.getInfoPartDate());
        model.setInfoFullDate(entity.getInfoFullDate());
        model.setCreatedPostId(entity.getCreatedPostId());
        model.setAppnNum(entity.getAppnnum());
        model.setTransMode(entity.getTransferMode());
        model.setTransAmt(entity.getTransferAmount());
        model.setRefusedDate(entity.getRefusedDate());
    }
}



//package com.tgs.ir.mappers;
//
//import com.tgs.ir.entities.RTIApplication;
//import com.tgs.ir.dto.RtiApplicationDto;
//import com.tgs.ir.core.BaseMapper;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class RtiApplicationMapper implements BaseMapper<RTIApplication, RtiApplicationDto> {
//
//    @Override
//    public RtiApplicationDto mapEntityToModel(RTIApplication entity) {
//        // Implement mapping logic from entity to DTO
//    }
//
//    @Override
//    public RTIApplication mapModelToEntity(RtiApplicationDto model) {
//        // Implement mapping logic from DTO to entity
//    }
//
//    @Override
//    public List<RtiApplicationDto> mapEntityToModel(List<RTIApplication> entities) {
//        return entities.stream().map(this::mapEntityToModel).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<RTIApplication> mapModelToEntity(List<RtiApplicationDto> models) {
//        return models.stream().map(this::mapModelToEntity).collect(Collectors.toList());
//    }
//
//    @Override
//    public void mapModelToEntity(RTIApplication entity, RtiApplicationDto model) {
//        // Implement mapping logic for updating an existing entity from DTO
//    }
//
//    @Override
//    public void mapEntityToModel(RTIApplication entity, RtiApplicationDto model) {
//        // Implement mapping logic for updating an existing DTO from entity
//    }
//}
