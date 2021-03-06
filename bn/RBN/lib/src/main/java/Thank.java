

import java.time.LocalDate;
import java.util.*;

import jakarta.validation.constraints.*;

public class Thank implements EntityInterface{
	
	@NotNull(message = "uid can't be empty")
	private UUID uid;
	
	private UUID tid;
	
	private UUID thank_to;
	
	@NotNull(message = "description can't be empty")
	private String description;
	
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) || null ", message = "invalid date")
	private LocalDate date_created;
	
	public Thank() {
		tid = UUID.randomUUID();
		
		if (this.getDescription() == null) {
			this.setDescription(" ");
		}
	}

	@Override
	public LocalDate getDateCreated() {
		// TODO Auto-generated method stub
		return date_created;
	}

	@Override
	public UUID getId() {
		// TODO Auto-generated method stub
		return tid;
	}
	
	public void setUID(UUID u) {
		this.uid = u;
	}
	
	public UUID getUID() {
		return uid;
	}
	
	public boolean isNil() {
		return false;
	}
	
	public UUID getThankTo() {
		return thank_to;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String s) {
		this.description = s;
	}
	
	public boolean containsInThank(String substring) {
		if (description.contains(substring)) {
			return true;
		}
		else {
			return false;
		}
	}

}
