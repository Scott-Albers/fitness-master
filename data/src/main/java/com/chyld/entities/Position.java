package com.chyld.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "positions")
@Data
public class Position implements Serializable {
    private int id;
    private int version;
    private float latitude;
    private float longitude;
    private float altitude;
    private Date current;
    private Run run;
    private Date created;
    private Date modified;

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Version
    public int getVersion() {return version;}
    public void setVersion(int version) {this.version = version;}

    @ManyToOne
    @JoinColumn(name="run_id")
    @JsonIgnore
    public Run getRun() {return run;}
    public void setRun(Run run) {this.run = run;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}

    @Column(name = "lat")
    public float getLatitude() { return latitude;  }
    public void setLatitude(float latitude) { this.latitude = latitude;  }

    @Column(name = "lon")
    public float getLongitude() { return longitude;  }
    public void setLongitude(float longitude) { this.longitude = longitude;  }

    @Column(name = "alt")
    public float getAltitude() { return altitude;  }
    public void setAltitude(float altitude) { this.altitude = altitude;  }

    @Column(name = "current_time")
    public Date getCurrent() { return current;  }
    public void setCurrent(Date current) { this.current = current;  }
}