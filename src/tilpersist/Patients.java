/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tilpersist;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name = "patients")
@NamedQueries({
    @NamedQuery(name = "Patients.findAll", query = "SELECT p FROM Patients p"),
    @NamedQuery(name = "Patients.findByPpaIndex", query = "SELECT p FROM Patients p WHERE p.ppaIndex = :ppaIndex"),
    @NamedQuery(name = "Patients.findByLname", query = "SELECT p FROM Patients p WHERE p.lname = :lname"),
    @NamedQuery(name = "Patients.findByFname", query = "SELECT p FROM Patients p WHERE p.fname = :fname"),
    @NamedQuery(name = "Patients.findByMid", query = "SELECT p FROM Patients p WHERE p.mid = :mid"),
    @NamedQuery(name = "Patients.findByMrn", query = "SELECT p FROM Patients p WHERE p.mrn = :mrn"),
    @NamedQuery(name = "Patients.findByDiagnosis", query = "SELECT p FROM Patients p WHERE p.diagnosis = :diagnosis"),
    @NamedQuery(name = "Patients.findByCapcolor", query = "SELECT p FROM Patients p WHERE p.capcolor = :capcolor"),
    @NamedQuery(name = "Patients.findByProtocol", query = "SELECT p FROM Patients p WHERE p.protocol = :protocol"),
    @NamedQuery(name = "Patients.findByDod", query = "SELECT p FROM Patients p WHERE p.dod = :dod"),
    @NamedQuery(name = "Patients.recentFifty", query = "SELECT DISTINCT p FROM Patients AS p JOIN p.norminv AS n ORDER BY n.datefrzn DESC" ),
    @NamedQuery(name = "Patients.recentFiftyAfterDate", query = "SELECT DISTINCT p FROM Patients AS p JOIN p.norminv AS n WHERE n.datefrzn > :dt ORDER BY n.datefrzn DESC" )
})
public class Patients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ppa_index")
    private Long ppaIndex;
    @Column(name = "lname")
    private String lname;
    @Column(name = "fname")
    private String fname;
    @Column(name = "mid")
    private String mid;
    @Column(name = "mrn")
    private String mrn;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "capcolor")
    private String capcolor;
    @Column(name = "protocol")
    private String protocol;
    @Column(name = "dod")
    @Temporal(TemporalType.DATE)
    private Date dod;
    @Lob
    @Column(name = "comments")
    private String comments;

    @OneToMany(mappedBy="owner", targetEntity=Norminv.class)
    private List<Norminv> norminv;

    public Patients() {
    }

    public Patients(Long ppaIndex) {
        this.ppaIndex = ppaIndex;
    }

    public Long getPpaIndex() {
        return ppaIndex;
    }

    public void setPpaIndex(Long ppaIndex) {
        this.ppaIndex = ppaIndex;
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

    public String getMrn() {
        return mrn;
    }

    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getCapcolor() {
        return capcolor;
    }

    public void setCapcolor(String capcolor) {
        this.capcolor = capcolor;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Date getDod() {
        return dod;
    }

    public void setDod(Date dod) {
        this.dod = dod;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ppaIndex != null ? ppaIndex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patients)) {
            return false;
        }
        Patients other = (Patients) object;
        if ((this.ppaIndex == null && other.ppaIndex != null) || (this.ppaIndex != null && !this.ppaIndex.equals(other.ppaIndex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tilpersist.Patients[ppaIndex=" + ppaIndex + "]";
    }

}
