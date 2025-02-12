package in.OAndM.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDetailsDto {
	 private String username;
	    private String email;
	    private String role;
	    private Integer empId;
	  
	
	    
	    private Integer unit;
	    private String unitName;
	    private Integer circle;
	    private String circleName;
	    private Integer division;
	    private String divisionName;
	    private Integer subDivision;
	    private String subDivisionName;
	    
	    private Integer section;
	    private String  sectionName;
	    private Integer designation;
	    private String designationName;
	    
	    
	    private String postType;
	    private String workingPlace;
	    private String workType;
	    private Long post;
	    
	    private String postFromDate;
	
	    
	    
	   
	   
	   // depOrganisationId	null
	   // deputationId	0
	  //  post	3044887672
	  //  postFromDate	"2021-01-10"
	    


	  
	   
	   
	 
	    
}


