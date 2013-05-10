/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tilpersist;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author grossco
 */
@Entity
@Table(name = "ingress", catalog = "til_lab", schema = "")
@NamedQueries({
@NamedQuery(name = "Ingress.findAll", query = "SELECT i FROM Ingress i"), 
@NamedQuery(name = "Ingress.findByIngIndex", query = "SELECT i FROM Ingress i WHERE i.ingIndex = :ingIndex"), 
@NamedQuery(name = "Ingress.findByMrn", query = "SELECT i FROM Ingress i WHERE i.mrn = :mrn"), 
@NamedQuery(name = "Ingress.findByLname", query = "SELECT i FROM Ingress i WHERE i.lname = :lname"), 
@NamedQuery(name = "Ingress.findByFname", query = "SELECT i FROM Ingress i WHERE i.fname = :fname"), 
@NamedQuery(name = "Ingress.findByMid", query = "SELECT i FROM Ingress i WHERE i.mid = :mid"), 
@NamedQuery(name = "Ingress.findByCapcolor", query = "SELECT i FROM Ingress i WHERE i.capcolor = :capcolor"), 
@NamedQuery(name = "Ingress.findByDatefrzn", query = "SELECT i FROM Ingress i WHERE i.datefrzn = :datefrzn"), 
@NamedQuery(name = "Ingress.findByVialnum", query = "SELECT i FROM Ingress i WHERE i.vialnum = :vialnum"), 
@NamedQuery(name = "Ingress.findByAmount", query = "SELECT i FROM Ingress i WHERE i.amount = :amount"), 
@NamedQuery(name = "Ingress.findByUnits", query = "SELECT i FROM Ingress i WHERE i.units = :units"), 
@NamedQuery(name = "Ingress.findByLocation", query = "SELECT i FROM Ingress i WHERE i.location = :location"), 
@NamedQuery(name = "Ingress.findByOriginalvial", query = "SELECT i FROM Ingress i WHERE i.originalvial = :originalvial"), 
@NamedQuery(name = "Ingress.findByDateVerified", query = "SELECT i FROM Ingress i WHERE i.dateVerified = :dateVerified"),
@NamedQuery(name = "Ingress.notVerified", query = "SELECT i FROM Ingress as i WHERE i.dateVerified IS NULL")
})

public class Ingress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ing_index")
    private Long ingIndex;
    @Column(name = "mrn")
    private String mrn;
    @Column(name = "lname")
    private String lname;
    @Column(name = "fname")
    private String fname;
    @Column(name = "mid")
    private String mid;
    @Column(name = "capcolor")
    private String capcolor;
    @Column(name = "datefrzn")
    @Temporal(TemporalType.DATE)
    private Date datefrzn;
    @Lob
    @Column(name = "cellid")
    private String cellid;
    @Column(name = "vialnum")
    private Integer vialnum;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "units")
    private String units;
    @Column(name = "location")
    private String location;
    @Lob
    @Column(name = "comments")
    private String comments;
    @Column(name = "originalvial")
    private Integer originalvial;
    @Column(name = "dateVerified")
    @Temporal(TemporalType.DATE)
    private Date dateVerified;

    public Ingress() {
    }

    public Ingress(Long ingIndex) {
        this.ingIndex = ingIndex;
    }

    public Long getIngIndex() {
        return ingIndex;
    }

    public void setIngIndex(Long ingIndex) {
        this.ingIndex = ingIndex;
    }

    public String getMrn() {
        return mrn;
    }

    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getCapcolor() {
        return capcolor;
    }

    public void setCapcolor(String capcolor) {
        this.capcolor = capcolor;
    }

    public Date getDatefrzn() {
        return datefrzn;
    }

    public void setDatefrzn(Date datefrzn) {
        this.datefrzn = datefrzn;
    }

    public String getCellid() {
        return cellid;
    }

    public void setCellid(String cellid) {
        this.cellid = cellid;
    }

    public Integer getVialnum() {
        return vialnum;
    }

    public void setVialnum(Integer vialnum) {
        this.vialnum = vialnum;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getOriginalvial() {
        return originalvial;
    }

    public void setOriginalvial(Integer originalvial) {
        this.originalvial = originalvial;
    }

    public Date getDateVerified() {
        return dateVerified;
    }

    public void setDateVerified(Date dateVerified) {
        this.dateVerified = dateVerified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingIndex != null ? ingIndex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingress)) {
            return false;
        }
        Ingress other = (Ingress) object;
        if ((this.ingIndex == null && other.ingIndex != null) || (this.ingIndex != null && !this.ingIndex.equals(other.ingIndex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "incomingvialsapp.Ingress[ingIndex=" + ingIndex + "]";
    }

}
