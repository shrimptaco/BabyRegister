package info;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class Baby{
	private Date birthday;
	private String name;
	private char gender;
	
	SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	//Constructors:
	public Baby(){}
	
	public Baby(String birthday, String name, char gender){
		try{
			this.birthday = myFormat.parse(birthday);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		this.name = name;
		this.gender = gender;
	}
	public Baby(Date birthday, String name, char gender){
		this.birthday = birthday;
		this.name = name;
		this.gender = gender;
	}

	public Date getBirthday(){
		return birthday;
	}
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public char getGender(){
		return gender;
	}
	public void setGender(char gender){
		this.gender = gender;
	}
	
	// If a given kid is older than the current one
	public boolean isOlder(Baby baby){
		return getBirthday().after(baby.getBirthday());
	}
	// The actual age of the kid in days
	public int howOld(){
		long difference = System.currentTimeMillis() - birthday.getTime();
	    return (int) TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
	}
}