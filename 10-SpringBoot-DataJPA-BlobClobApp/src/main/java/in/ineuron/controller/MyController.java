package in.ineuron.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.model.MarriageSeeker;
import in.ineuron.service.IMarriageSeekerMgmt;

@Component
public class MyController {
	
	@Autowired
	private IMarriageSeekerMgmt seekerMgmt;
	
	
	
	public void registermarriageSeeker() {
	MarriageSeeker mSeeker = new MarriageSeeker();
		
		mSeeker.setAddress("Piparda");
		mSeeker.setDob(LocalDateTime.of(1998, 05, 2, 4, 8));
		mSeeker.setIndian(true);
		mSeeker.setName("Rakesh Pawar");
		
		
		    File file = new File("D:\\Doc\\photoM.jpg");
	        byte[] fileContent = new byte[(int) file.length()];

	        try (FileInputStream inputStream = new FileInputStream(file)) {
	            inputStream.read(fileContent);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	     
	        File resumefile = new File("D:\\Doc\\MANGESH_DHANDE_Resume.pdf");
	        byte[] resume = new byte[(int) resumefile.length()];

	        try (FileInputStream inputStream = new FileInputStream(resumefile)) {
	            inputStream.read(resume);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }    
	        
	        
	     File file2 = new File("D:\\Doc\\res.txt");
	     char[] bioData = new char[(int) file2.length()];
	     try (Reader reader = new FileReader(file2)) {
			reader.read(bioData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
	    mSeeker.setBiodata(bioData);
	    mSeeker.setPhoto(fileContent);
	    mSeeker.setResume(resume);
	    
	    String registerSeeker = seekerMgmt.registerSeeker(mSeeker);
	    System.out.println(registerSeeker);
	}
	
	
	
	public void fetchById() throws FileNotFoundException {
		
		
		
		Optional<MarriageSeeker> optional = seekerMgmt.searchSeekerById(1L);
		
		if (optional.isPresent()) {
			
			MarriageSeeker seeker = optional.get();
			
			System.out.println(seeker.getId()+"  "+seeker.getName());
			
			
			try (OutputStream oStream = new FileOutputStream("D:\\retrieval_image.jpg")) {
				try {
					oStream.write(seeker.getPhoto());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				throw e;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Writer writer = null;
			try {
				writer = new FileWriter("D:\\retrive_biodata.txt");
				writer.write(seeker.getBiodata());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			try (OutputStream oStream = new FileOutputStream("D:\\retrieval_resume.pdf")) {
				try {
					oStream.write(seeker.getResume());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				throw e;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Data is not available with id ");
		}
		
		
	}

}
