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
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.TemporalType;

/**
 *
 * @author grossco
 */
@Entity
@Table(name = "norminv")
@NamedQueries({
    @NamedQuery(name = "Norminv.findAll", query = "SELECT n FROM Norminv n"),
    @NamedQuery(name = "Norminv.findByPniIndex", query = "SELECT n FROM Norminv n WHERE n.pniIndex = :pniIndex"),
    @NamedQuery(name = "Norminv.findByMrn", query = "SELECT n FROM Norminv n WHERE n.mrn = :mrn"),
    @NamedQuery(name = "Norminv.findByCapcolor", query = "SELECT n FROM Norminv n WHERE n.capcolor = :capcolor"),
    @NamedQuery(name = "Norminv.findByDatefrzn", query = "SELECT n FROM Norminv n WHERE n.datefrzn = :datefrzn"),
    @NamedQuery(name = "Norminv.findByVialnum", query = "SELECT n FROM Norminv n WHERE n.vialnum = :vialnum"),
    @NamedQuery(name = "Norminv.findByAmount", query = "SELECT n FROM Norminv n WHERE n.amount = :amount"),
    @NamedQuery(name = "Norminv.findByUnits", query = "SELECT n FROM Norminv n WHERE n.units = :units"),
    @NamedQuery(name = "Norminv.findByLocation", query = "SELECT n FROM Norminv n WHERE n.location = :location"),
    @NamedQuery(name = "Norminv.findByOriginalvial", query = "SELECT n FROM Norminv n WHERE n.originalvial = :originalvial")
})
public class Norminv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pni_index")
    private Long pniIndex;
    @Column(name = "mrn")
    private String mrn;
    @Lob
    @Column(name = "protocol")
    private String protocol;
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

    @ManyToOne
    @JoinColumn(name = "mrn", referencedColumnName="mrn",
        insertable=false, updatable=false)
    private Patients owner;

    public Norminv() {
    }

    public Norminv(Long pniIndex) {
        this.pniIndex = pniIndex;
    }

    public Long getPniIndex() {
        return pniIndex;
    }

    public void setPniIndex(Long pniIndex) {
        this.pniIndex = pniIndex;
    }

    public String getMrn() {
        return mrn;
    }

    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pniIndex != null ? pniIndex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Norminv)) {
            return false;
        }
        Norminv other = (Norminv) object;
        if ((this.pniIndex == null && other.pniIndex != null) || (this.pniIndex != null && !this.pniIndex.equals(other.pniIndex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tilpersist.Norminv[pniIndex=" + pniIndex + "]";
    }

    /**
     * @return the owner
     */
    public Patients getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(Patients owner) {
        this.owner = owner;
    }

}
