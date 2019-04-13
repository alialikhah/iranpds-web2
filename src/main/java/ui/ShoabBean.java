package ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import entity.ShoabEntity;
import service.SendMailServiceLocal;
import service.ShoabServiceLocal;

@Named
@SessionScoped
public class ShoabBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3904540383536890419L;
	public ShoabBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private ShoabServiceLocal shoabServiceLocal;
	@Inject
	private SendMailServiceLocal sendMailServiceLocal;
	
	private String cityBirth;
	private String date;
	private String father;
	private String name;
	private String shomareGovahiName;
	private String ssn;
	private String addres;
	private String shogl;
	private String madrak;
	private String reshte;
	private String mobile;
	private String phone;
	private String darBakhsh;
	private String darShahr;
	private String darShahrestan;
	private String darOstan;
	private String nahve;
	private List<String> options=new ArrayList<>(); 
	private String description;
	private String khon;
	public ShoabServiceLocal getShoabServiceLocal() {
		return shoabServiceLocal;
	}



	public void setShoabServiceLocal(ShoabServiceLocal shoabServiceLocal) {
		this.shoabServiceLocal = shoabServiceLocal;
	}



	public String getCityBirth() {
		return cityBirth;
	}



	public void setCityBirth(String cityBirth) {
		this.cityBirth = cityBirth;
	}






	public String getFather() {
		return father;
	}



	public void setFather(String father) {
		this.father = father;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}





	public String getShomareGovahiName() {
		return shomareGovahiName;
	}



	public void setShomareGovahiName(String shomareGovahiName) {
		this.shomareGovahiName = shomareGovahiName;
	}



	public String getSsn() {
		return ssn;
	}



	public void setSsn(String ssn) {
		this.ssn = ssn;
	}



	public String getAddres() {
		return addres;
	}



	public void setAddres(String addres) {
		this.addres = addres;
	}



	public String getShogl() {
		return shogl;
	}



	public void setShogl(String shogl) {
		this.shogl = shogl;
	}





	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getDarBakhsh() {
		return darBakhsh;
	}



	public void setDarBakhsh(String darBakhsh) {
		this.darBakhsh = darBakhsh;
	}



	public String getDarShahr() {
		return darShahr;
	}



	public void setDarShahr(String darShahr) {
		this.darShahr = darShahr;
	}



	public String getDarShahrestan() {
		return darShahrestan;
	}



	public void setDarShahrestan(String darShahrestan) {
		this.darShahrestan = darShahrestan;
	}



	public String getDarOstan() {
		return darOstan;
	}



	public void setDarOstan(String darOstan) {
		this.darOstan = darOstan;
	}




	


	public String getMadrak() {
		return madrak;
	}



	public void setMadrak(String madrak) {
		this.madrak = madrak;
	}



	public String getReshte() {
		return reshte;
	}



	public void setReshte(String reshte) {
		this.reshte = reshte;
	}





	public String getNahve() {
		return nahve;
	}



	public void setNahve(String nahve) {
		this.nahve = nahve;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}
	

	public List<String> getOptions() {
		return options;
	}



	public void setOptions(List<String> options) {
		this.options = options;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	

	public String convertOptions() {
		String optionAll = "";
		for (String string : this.options) {
			optionAll += string + "-";
		}
		return optionAll;
	}
	
	



	public String getKhon() {
		return khon;
	}



	public void setKhon(String khon) {
		this.khon = khon;
	}

	public void insertToShoab() throws AddressException, MessagingException, IOException {
		FacesContext contex=FacesContext.getCurrentInstance();
		ShoabEntity shoabEntity=new ShoabEntity();
		shoabEntity.setAddres(addres);
		shoabEntity.setCityBirth(cityBirth);
		shoabEntity.setDarBakhsh(darBakhsh);
		shoabEntity.setDarOstan(darOstan);
		shoabEntity.setDarShahr(darShahr);
		shoabEntity.setDarShahrestan(darShahrestan);
		shoabEntity.setDate(date);
		shoabEntity.setFather(father);
		shoabEntity.setMobile(mobile);
		shoabEntity.setName(name);
		shoabEntity.setPhone(phone);
		shoabEntity.setShogl(shogl);
		shoabEntity.setShomareGovahiName(shomareGovahiName);
		shoabEntity.setSsn(ssn);
		shoabEntity.setMadrak(madrak);
		shoabEntity.setReshte(reshte);
		shoabEntity.setNahve(nahve);
		shoabEntity.setOptions(convertOptions());
		shoabEntity.setDescription(description);
		shoabEntity.setKhon(khon);
		shoabServiceLocal.inserToShoab(shoabEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		String msgk=new String();
		msgk+="<html>";
		msgk+="<title>";
		msgk+="<meta Content-Type:'text/html' charset='utf-8'/>";
		msgk+="</title>";
		msgk+="<body>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> نام : " +"<b style=\"font-size:18px;\">" + name + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> فرزند :"+"<b style=\"font-size:18px;\">" + father +"</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> تاریخ تولد :"+"<b style=\"font-size:18px;\">" + date +"</b>" + "</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> محل تولد :"+"<b style=\"font-size:18px;\">" + cityBirth + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> کد ملی :"+"<b style=\"font-size:18px;\">" + ssn + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> شماره گواهی نامه رانندگی :"+"<b style=\"font-size:18px;\">" + shomareGovahiName +"</b>" + "</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> مدرک تحصیلی :"+"<b style=\"font-size:18px;\">" + madrak +"</b>" + "</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> رشته تحصیلی :"+"<b style=\"font-size:18px;\">" + reshte + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> شغل :"+"<b style=\"font-size:18px;\">" + shogl + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> شماره موبایل :"+"<b style=\"font-size:18px;\">" + mobile + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> شماره تلفن :"+"<b style=\"font-size:18px;\">" + phone + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> استان :"+"<b style=\"font-size:18px;\">" + darOstan + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> شهرستان :"+"<b style=\"font-size:18px;\">" + darShahrestan + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> شهر :"+"<b style=\"font-size:18px;\">" + darShahr + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> بخش / روستا :"+"<b style=\"font-size:18px;\">" + darBakhsh + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> نشانی کامل :"+"<b style=\"font-size:18px;\">" + addres + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> آمادگی برای :"+"<b style=\"font-size:18px;\">" + convertOptions() + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> توضیحات موارد بالا :"+"<b style=\"font-size:18px;\">" + description + "</b>" +"</p>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> نحوه پرداخت :"+"<b style=\"font-size:18px;\">" + nahve + "</b>" +"</p>";
		msgk+="</body>";
		msgk+="</html>";
		sendMailServiceLocal.send(msgk);
		this.addres="";
		this.cityBirth="";
		this.darBakhsh="";
		this.darOstan="";
		this.darShahr="";
		this.darShahrestan="";
		this.date="";
		this.father="";
		this.mobile="";
		this.name="";
		this.phone="";
		this.shogl="";
		this.shomareGovahiName="";
		this.ssn="";
		this.madrak="";
		this.reshte="";
		this.nahve="";
		this.description="";
		this.khon="";
		

	}

}
