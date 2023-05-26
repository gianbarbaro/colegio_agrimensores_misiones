
package com.agrimensuramisiones.entities;

import com.agrimensuramisiones.enums.NormativeAlcance;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Normatives")
public class Normative implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private byte[] archivo;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NormativeAlcance alcance;
    
    @Column(nullable = false)
    private Boolean visible;

    public Normative() {
    }

    public Normative(String id, String description, byte[] archivo, Date created_at, Date updated_at, NormativeAlcance alcance, Boolean visible) {
        this.id = id;
        this.description = description;
        this.archivo = archivo;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.alcance = alcance;
        this.visible = visible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
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

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public NormativeAlcance getAlcance() {
        return alcance;
    }

    public void setAlcance(NormativeAlcance alcance) {
        this.alcance = alcance;
    }

    @Override
    public String toString() {
        return "Normative{" + "id=" + id + ", description=" + description + ", archivo=" + archivo + ", created_at=" + created_at + ", updated_at=" + updated_at + ", alcance=" + alcance + ", visible=" + visible + '}';
    }
    
}
