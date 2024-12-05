package in.OAndM.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.OAndM.DTO.AdminSanctionsModel;
import in.OAndM.DTO.AgreementsModel;
import in.OAndM.DTO.BillsModel;
import in.OAndM.DTO.TechnicalSanctionsModel;
import in.OAndM.core.BaseResponse;
import in.OAndM.services.AdminSanctionService;
import in.OAndM.services.AgreementsService;
import in.OAndM.services.BillsService;
import in.OAndM.services.TechnicalSanctionService;
import in.OAndM.utils.DateUtil;

@RestController
@RequestMapping("/OandMWorks")
public class OAndMController {

	@Autowired
	AdminSanctionService adminSanctionService;

	@Autowired
	TechnicalSanctionService technicalSanctionService;
	
	@Autowired
	AgreementsService agreementsService;
	
	@Autowired
	BillsService billsService;

	@GetMapping("/adminSanctions")
	public ResponseEntity<BaseResponse<HttpStatus, List<AdminSanctionsModel>>> getAdminSanctions(Integer unit,
			Integer finyear) {
		BaseResponse<HttpStatus, List<AdminSanctionsModel>> response = adminSanctionService
				.getAdminSanctionByFinYearByUnit(unit, finyear);
		return new ResponseEntity<>(response, response.getStatus());
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/adminSanctionsByworkId")
	@ResponseBody
	public ResponseEntity<BaseResponse<HttpStatus, AdminSanctionsModel>> getAdminSanctionsByworkId(
			@RequestParam Integer workId) {
		BaseResponse<HttpStatus, AdminSanctionsModel> response = adminSanctionService.findbyWorkId(workId);

		return new ResponseEntity<>(response, response.getStatus());
	}

	@GetMapping("/adminSanctionsByworkIdAndTechnicalSanctionTechId")
	public ResponseEntity<BaseResponse<HttpStatus, AdminSanctionsModel>> getAdminSanctionsByTechId(Integer unit,
			Integer finYear, Integer tsId) {
		BaseResponse<HttpStatus, AdminSanctionsModel> response = adminSanctionService
				.findByunitIdAndFinancialYearAndIsLatestAndDeleteFlagAndTechnEntriesIsLatestAndTechnEntriesTsId(unit,
						finYear, true, false, true, tsId);
		return new ResponseEntity<>(response, response.getStatus());
	}

	@GetMapping("/O&MWorksTechnicalSanction")
	@ResponseBody
	public ResponseEntity<BaseResponse<HttpStatus, List<AdminSanctionsModel>>> getAdminSanctionsForDEE(
			@RequestParam Integer unitId, @RequestParam Integer divisionId, @RequestParam Integer subDivisionId,
			@RequestParam Integer finyear) {
		BaseResponse<HttpStatus, List<AdminSanctionsModel>> response = adminSanctionService
				.getAdminSanctionForDEE(unitId, divisionId, subDivisionId, finyear);

		return new ResponseEntity<>(response, response.getStatus());
	}

	 @CrossOrigin(origins = "http://localhost:3000")
	 @GetMapping("/technicalSanctionsByworkId")
	    public ResponseEntity<BaseResponse<HttpStatus,  List<TechnicalSanctionsModel>>> getTechSanctionsByworkId(Integer workId) {
	        BaseResponse<HttpStatus, List<TechnicalSanctionsModel>> response = technicalSanctionService.getTechnicalSanctionByWorkId(workId);
	        return new ResponseEntity<>(response, response.getStatus());
	    }
	 
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/AgreementsByworkId")
	public ResponseEntity<BaseResponse<HttpStatus,  List<AgreementsModel>>> getAgreementsByworkId(Integer workId) {
        BaseResponse<HttpStatus, List<AgreementsModel>> response = agreementsService.getAgreementsByworkId(workId);
        return new ResponseEntity<>(response, response.getStatus());
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/agmtAndBillDetailsByworkId")
	@ResponseBody
	public ResponseEntity<BaseResponse<HttpStatus, AgreementsModel>> getAgmtAndBillDetailsByworkId(
			@RequestParam Integer workId,@RequestParam Integer agreementId) {
		BaseResponse<HttpStatus, AgreementsModel> response = agreementsService.getAgmtAndBillDetailsByworkId(workId, agreementId);

		return new ResponseEntity<>(response, response.getStatus());
	}


		@PostMapping(value="/submitTechnicalSanctions",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

		public void submitTechnicalSanctions(@ModelAttribute TechnicalSanctionsModel techlist){
			
			  MultipartFile tsFile=null,tsEstimateFile=null; 
 List<TechnicalSanctionsModel> tsList1 = new ArrayList<TechnicalSanctionsModel>();
 
 List<TechnicalSanctionsModel> tsList = techlist.getTechList();
 
			  String tsValidFile,tsEstValidFile=null; 
			  if(techlist!=null) {
					for(int i=0;i<tsList.size();i++) {
//						tsList.get(i).setUpdatedByUserName(uname);

						tsFile = tsList.get(i).getTechSancUrl();
						tsEstimateFile = tsList.get(i).getTechEstimateUrl();
						if (null != tsFile && tsFile.getSize() > 0) {
							Timestamp timestamp = new Timestamp(System.currentTimeMillis());
							Long uploadTime = timestamp.getTime();
							String fileName = tsFile.getOriginalFilename().replaceAll("\\s+", "");;
							String FileType = tsFile.getContentType();
							String rootPath = System.getProperty("catalina.home");
							File dir = new File(rootPath + File.separator + "webapps" + File.separator + "PMSWebApp"
									+ File.separator + "O&MWorks"+ File.separator + "TechSanctionFiles" + File.separator);
							String[] temps = fileName.split(Pattern.quote("."));
							if (!dir.exists())
								dir.mkdirs();
							String saveFileName = temps[0]+"_"+uploadTime + "." +temps[temps.length - 1];
							try {
								tsFile.transferTo(new File(dir.getAbsolutePath() + File.separator + saveFileName));
							} catch (IllegalStateException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							tsList.get(i).setTsFileUrl("O&MWorks"+ File.separator + "TechSanctionFiles"+  File.separator + saveFileName);
							tsValidFile = temps[temps.length - 1];
							tsList.get(i).setSancFileType(tsValidFile);
						}
						
						if (null != tsEstimateFile && tsEstimateFile.getSize() > 0) {
							Timestamp timestamp = new Timestamp(System.currentTimeMillis());
							Long uploadTime = timestamp.getTime();
							String fileName = tsEstimateFile.getOriginalFilename().replaceAll("\\s+", "");;
							String FileType = tsEstimateFile.getContentType();
							String rootPath = System.getProperty("catalina.home");
							File dir = new File(rootPath + File.separator + "webapps" + File.separator + "PMSWebApp"
									+ File.separator + "O&MWorks"+ File.separator + "TechEstimateFiles" + File.separator);
							String[] temps = fileName.split(Pattern.quote("."));
							if (!dir.exists())
								dir.mkdirs();
							String saveFileName = temps[0]+"_"+uploadTime + "." +temps[temps.length - 1];
							try {
								tsEstimateFile.transferTo(new File(dir.getAbsolutePath() + File.separator + saveFileName));
							} catch (IllegalStateException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							tsList.get(i).setTsEstFileUrl("O&MWorks"+ File.separator + "TechSanctionFiles"+  File.separator + saveFileName);
							tsEstValidFile = temps[temps.length - 1];
							tsList.get(i).setEstFileType(tsEstValidFile);
						}
						java.sql.Date sqlDate=null;
						if(tsList.get(i).getTsDate()!=null) {
							try {
								sqlDate=DateUtil.getSQLDate1(tsList.get(i).getTsDate());
								if(sqlDate!=null) {
									tsList.get(i).setTsApprovedDate(sqlDate);
								}
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				technicalSanctionService.insertTechnicalSanctions(tsList);
				

	}
	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> testUpload(@RequestParam("file") MultipartFile file) {
		return ResponseEntity.ok("File uploaded: " + file.getOriginalFilename());
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value="/submitAgreements")

	public void submitAgreements(@RequestBody AgreementsModel agreements){
		 
			agreementsService.insertAgreements(agreements);
			

}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value="/submitBillDetails")

	public void submitBillDetails(@RequestBody BillsModel bills){
		 
		billsService.insertBills(bills);

}
}
