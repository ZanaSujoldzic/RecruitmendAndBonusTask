/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zana
 */
@Entity
@Table(name = "stake")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stake.findAll", query = "SELECT s FROM Stake s")
    , @NamedQuery(name = "Stake.findById", query = "SELECT s FROM Stake s WHERE s.id = :id")
    , @NamedQuery(name = "Stake.findByAmount", query = "SELECT s FROM Stake s WHERE s.amount = :amount")
    , @NamedQuery(name = "Stake.findByTime", query = "SELECT s FROM Stake s WHERE s.time = :time")})
public class Stake implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "time")
    private String time;
    @JoinColumn(name = "deviceId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Device deviceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stakeId")
    private List<Ticket> ticketList;

    public Stake() {
    }

    public Stake(Integer id) {
        this.id = id;
    }

    public Stake(Integer id, double amount, String time) {
        this.id = id;
        this.amount = amount;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stake)) {
            return false;
        }
        Stake other = (Stake) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Stake[ id=" + id + " ]";
    }
    
}
