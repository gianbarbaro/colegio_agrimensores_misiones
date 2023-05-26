
package com.agrimensuramisiones.entities;

import com.agrimensuramisiones.enums.Cargo;
import com.agrimensuramisiones.enums.Cities;
import com.agrimensuramisiones.enums.Gender;
import com.agrimensuramisiones.enums.Rol;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Users")
public class User implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = true)
    private String first_name;
    
    @Column(nullable = true)
    private String last_name;
    
    @Column(nullable = true)
    private String addres;
    
    @Column(nullable = true, unique = true)
    private Integer dni;
    
    @Column(nullable = true, unique = true)
    private Integer cuit;
    
    @Column(nullable = true, unique = true)
    private String email;
    
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date birth_date;
    
    @Column(nullable = true, unique = true)
    private Integer phone;
    
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
    
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Cities city;
    
    @Column(nullable = true)
    private String password;
    
    @Column(nullable = true)
    private String matricula;
    
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date subscribe_at;
    
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date unsubscribe_at;
    
    @Column(nullable = true)
    private Cargo cargo;
    
    @OneToOne
    @JoinColumn(name = "authority_photo")
    private Photo photo;
    
    @Column(nullable = true)
    private Boolean active;
    
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Rol rol;

    public User() {
    }

    public User(String id, String first_name, String last_name, String addres, Integer dni, Integer cuit, String email, Gender gender, Date birth_date, Integer phone, Date created_at, Date updated_at, Cities city, String password, String matricula, Date subscribe_at, Date unsubscribe_at, Cargo cargo, Photo photo, Boolean active, Rol rol) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.addres = addres;
        this.dni = dni;
        this.cuit = cuit;
        this.email = email;
        this.gender = gender;
        this.birth_date = birth_date;
        this.phone = phone;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.city = city;
        this.password = password;
        this.matricula = matricula;
        this.subscribe_at = subscribe_at;
        this.unsubscribe_at = unsubscribe_at;
        this.cargo = cargo;
        this.photo = photo;
        this.active = active;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getCuit() {
        return cuit;
    }

    public void setCuit(Integer cuit) {
        this.cuit = cuit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getSubscribe_at() {
        return subscribe_at;
    }

    public void setSubscribe_at(Date subscribe_at) {
        this.subscribe_at = subscribe_at;
    }

    public Date getUnsubscribe_at() {
        return unsubscribe_at;
    }

    public void setUnsubscribe_at(Date unsubscribe_at) {
        this.unsubscribe_at = unsubscribe_at;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", addres=" + addres + ", dni=" + dni + ", cuit=" + cuit + ", email=" + email + ", gender=" + gender + ", birth_date=" + birth_date + ", phone=" + phone + ", created_at=" + created_at + ", updated_at=" + updated_at + ", city=" + city + ", password=" + password + ", matricula=" + matricula + ", subscribe_at=" + subscribe_at + ", unsubscribe_at=" + unsubscribe_at + ", cargo=" + cargo + ", photo=" + photo + ", active=" + active + ", rol=" + rol + '}';
    }
    
}
