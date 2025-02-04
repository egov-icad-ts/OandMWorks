package in.OAndM.DTO;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadGOsModel {

	private Integer  goId;
	 private String  goNumber;
	 private String  goDesc;
	 private String  goUrl;
	 private MultipartFile goFileUrl;
	 private boolean  deleteFlag;
	 private String  goDate;
	 private Date goDt;
	 private String  uploadType;
	 private Double  goAmount;
	 private Integer  financialYear;
	 private String goFileType;
}
