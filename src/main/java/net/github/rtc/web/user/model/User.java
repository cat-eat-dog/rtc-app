package net.github.rtc.web.user.model;

import org.util.rtc.annotation.*;

import java.util.Date;
import java.util.List;
//import java.util.List;
//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class User {
    
    Integer id;
    @required
    @maxlength(50)
    @minlength(5)
    private String fio;
    @required
    @number
    private String phone;
    @email
    private String email;
    @date
    @required
    private Date birthDate;

    @maxlength(30)
    @minlength(5)
    @required
    private String city;

    @maxlength(30)
    @minlength(5)
    @required
    private String university;
    @maxlength(30)
    @minlength(5)
    @required
    private String faculty;
    @maxlength(30)
    @minlength(5)
    @required
    private String speciality;

   // private String technologies;
    @number
    private Integer writtenEng;
    @number
    private Integer oralEng;
    private String note;
    private String password;

    
     private List<Role> authorities;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    
     public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }
     public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    
    public String getCity() {
        return city;
    }

    public void  setId(Integer id)
    {
        this.id=id;
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //maybe this getter maybe should be changed
    //I have no idea how to pass several technologies from a reg.form to a controller and user
   /* public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }
*/
    public Integer getWrittenEng() {
        return writtenEng;
    }

    public void setWrittenEng(Integer writtenEng) {
        this.writtenEng = writtenEng;
    }

    public Integer getOralEng() {
        return oralEng;
    }

    public void setOralEng(Integer oralEng) {
        this.oralEng = oralEng;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    


    public User(){

    }

    public User(String fio, String phone, String email, Date birthDate, String city, String university, String faculty, String speciality, Integer writtenEng, Integer oralEng, String note, String password) {
       
       
        this.fio = fio;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.city = city;
        this.university = university;
        this.faculty = faculty;
        this.speciality = speciality;
        this.writtenEng = writtenEng;
        this.oralEng = oralEng;
        this.note = note;
        this.password = password;
    }
    public User (Integer id, String fio, String phone, 
            String email, String city, String university, 
            String faculty, String password)
    {
        this.id=id;
         this.fio = fio;
        this.phone = phone;
        this.email = email;
        this.birthDate = new Date();
        this.city = city;
        this.university = university;
        this.faculty = faculty;
        this.speciality = "bb";
       
        this.writtenEng = 1;
        this.oralEng = 2;
        this.note = "df";
        this.password = password;
    }



}
