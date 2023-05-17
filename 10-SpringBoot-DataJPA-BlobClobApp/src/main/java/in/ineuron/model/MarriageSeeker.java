package in.ineuron.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class MarriageSeeker implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	private String address;

	@NonNull
	@Lob
	private byte[] photo;

	@NonNull
	private LocalDateTime dob;
	
	@NonNull
	@Lob
	private char[] biodata;
	
	@NonNull
	private Boolean indian;
	
	@Lob
	@NonNull
	private byte[] resume;
	
}
