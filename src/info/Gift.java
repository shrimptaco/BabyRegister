package info;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Gift{
	private String donorName;
	private String giftName;
	private Date donationDate;
	
	SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public Gift(String donorName, String giftName, String donationDate){
		this.donorName = donorName;
		this.giftName = giftName;
		try{
			this.donationDate = myFormat.parse(donationDate);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	public Gift(String donorName, String giftName, Date donationDate){
		this.donorName = donorName;
		this.giftName = giftName;
		this.donationDate = donationDate;
	}
	
	public String getDonationDate(){
		return myFormat.format(donationDate);
	}
	public void setDonationDate(Date donationDate){
		this.donationDate = donationDate;
	}
	public String getDonorName(){
		return donorName;
	}
	public void setDonorName(String donorName){
		this.donorName = donorName;
	}
	public String getGiftName(){
		return giftName;
	}
	public void setGiftName(String giftName){
		this.giftName = giftName;
	}

	@Override
	public String toString() {
		return "Donor name: "+getDonorName()+" Gift:"+getGiftName()+" Date:"+getDonationDate();
	}
	
	
	
}