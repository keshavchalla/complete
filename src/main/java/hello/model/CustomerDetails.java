package hello.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerDetails {

	private String accountNumber;
	private String tnType;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	@XmlElement
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTnType() {
		return tnType;
	}
	
	@XmlElement
	public void setTnType(String tnType) {
		this.tnType = tnType;
	}
}
