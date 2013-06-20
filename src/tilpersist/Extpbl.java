/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tilpersist;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author grossco
 */
@Entity
@Table(name = "extpbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extpbl.findAll", query = "SELECT e FROM Extpbl e"),
    @NamedQuery(name = "Extpbl.findByFpni", query = "SELECT e FROM Extpbl e WHERE e.fpni = :fpni"),
    @NamedQuery(name = "Extpbl.findByName", query = "SELECT e FROM Extpbl e WHERE e.name = :name"),
    @NamedQuery(name = "Extpbl.findByMrn", query = "SELECT e FROM Extpbl e WHERE e.mrn = :mrn"),
    @NamedQuery(name = "Extpbl.findByDrawDate", query = "SELECT e FROM Extpbl e WHERE e.drawDate = :drawDate"),
    @NamedQuery(name = "Extpbl.findBySampleId", query = "SELECT e FROM Extpbl e WHERE e.sampleId = :sampleId"),
    @NamedQuery(name = "Extpbl.findBySpecType", query = "SELECT e FROM Extpbl e WHERE e.specType = :specType"),
    @NamedQuery(name = "Extpbl.findByReposId", query = "SELECT e FROM Extpbl e WHERE e.reposId = :reposId"),
    @NamedQuery(name = "Extpbl.findByDrawTime", query = "SELECT e FROM Extpbl e WHERE e.drawTime = :drawTime"),
    @NamedQuery(name = "Extpbl.findByReceiptDate", query = "SELECT e FROM Extpbl e WHERE e.receiptDate = :receiptDate"),
    @NamedQuery(name = "Extpbl.findByReceiptTime", query = "SELECT e FROM Extpbl e WHERE e.receiptTime = :receiptTime"),
    @NamedQuery(name = "Extpbl.findByTotCellsE6", query = "SELECT e FROM Extpbl e WHERE e.totCellsE6 = :totCellsE6"),
    @NamedQuery(name = "Extpbl.findByTotVls", query = "SELECT e FROM Extpbl e WHERE e.totVls = :totVls"),
    @NamedQuery(name = "Extpbl.findByCellConcE6", query = "SELECT e FROM Extpbl e WHERE e.cellConcE6 = :cellConcE6"),
    @NamedQuery(name = "Extpbl.findByBldVolMl", query = "SELECT e FROM Extpbl e WHERE e.bldVolMl = :bldVolMl"),
    @NamedQuery(name = "Extpbl.findByBldTubesRecd", query = "SELECT e FROM Extpbl e WHERE e.bldTubesRecd = :bldTubesRecd"),
    @NamedQuery(name = "Extpbl.findByTotVlsAvail", query = "SELECT e FROM Extpbl e WHERE e.totVlsAvail = :totVlsAvail"),
    @NamedQuery(name = "Extpbl.findUnresolved", query = "SELECT e FROM Extpbl e WHERE e.fpni IS NULL")
})
public class Extpbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "fpni")
    private BigInteger fpni;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "mrn")
    private String mrn;
    @Column(name = "draw_date")
    @Temporal(TemporalType.DATE)
    private Date drawDate;
    @Id
    @Basic(optional = false)
    @Column(name = "sample_id")
    private String sampleId;
    @Column(name = "spec_type")
    private String specType;
    @Basic(optional = false)
    @Column(name = "repos_id")
    private String reposId;
    @Column(name = "draw_time")
    private String drawTime;
    @Column(name = "receipt_date")
    @Temporal(TemporalType.DATE)
    private Date receiptDate;
    @Column(name = "receipt_time")
    private String receiptTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tot_cells_e6")
    private BigDecimal totCellsE6;
    @Column(name = "tot_vls")
    private Integer totVls;
    @Column(name = "cell_conc_e6")
    private BigDecimal cellConcE6;
    @Column(name = "bld_vol_ml")
    private Integer bldVolMl;
    @Column(name = "bld_tubes_recd")
    private Integer bldTubesRecd;
    @Column(name = "tot_vls_avail")
    private Integer totVlsAvail;
    @Lob
    @Column(name = "comments")
    private String comments;
    
    @OneToOne
    @JoinColumn(name="fpni",referencedColumnName="pni_index",
        insertable=false, updatable=false)
    private Norminv invRecord;

    public Extpbl() {
    }

    public Extpbl(String sampleId) {
        this.sampleId = sampleId;
    }

    public Extpbl(String sampleId, String mrn, String reposId) {
        this.sampleId = sampleId;
        this.mrn = mrn;
        this.reposId = reposId;
    }

    public BigInteger getFpni() {
        return fpni;
    }

    public void setFpni(BigInteger fpni) {
        this.fpni = fpni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMrn() {
        return mrn;
    }

    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    public Date getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(Date drawDate) {
        this.drawDate = drawDate;
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getSpecType() {
        return specType;
    }

    public void setSpecType(String specType) {
        this.specType = specType;
    }

    public String getReposId() {
        return reposId;
    }

    public void setReposId(String reposId) {
        this.reposId = reposId;
    }

    public String getDrawTime() {
        return drawTime;
    }

    public void setDrawTime(String drawTime) {
        this.drawTime = drawTime;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(String receiptTime) {
        this.receiptTime = receiptTime;
    }

    public BigDecimal getTotCellsE6() {
        return totCellsE6;
    }

    public void setTotCellsE6(BigDecimal totCellsE6) {
        this.totCellsE6 = totCellsE6;
    }

    public Integer getTotVls() {
        return totVls;
    }

    public void setTotVls(Integer totVls) {
        this.totVls = totVls;
    }

    public BigDecimal getCellConcE6() {
        return cellConcE6;
    }

    public void setCellConcE6(BigDecimal cellConcE6) {
        this.cellConcE6 = cellConcE6;
    }

    public Integer getBldVolMl() {
        return bldVolMl;
    }

    public void setBldVolMl(Integer bldVolMl) {
        this.bldVolMl = bldVolMl;
    }

    public Integer getBldTubesRecd() {
        return bldTubesRecd;
    }

    public void setBldTubesRecd(Integer bldTubesRecd) {
        this.bldTubesRecd = bldTubesRecd;
    }

    public Integer getTotVlsAvail() {
        return totVlsAvail;
    }

    public void setTotVlsAvail(Integer totVlsAvail) {
        this.totVlsAvail = totVlsAvail;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public Norminv getInvRecord(){
        return this.invRecord;
    }
    
    public void setInvRecord(Norminv n){
        this.invRecord = n;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sampleId != null ? sampleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extpbl)) {
            return false;
        }
        Extpbl other = (Extpbl) object;
        if ((this.sampleId == null && other.sampleId != null) || (this.sampleId != null && !this.sampleId.equals(other.sampleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tilpersist.Extpbl[ sampleId=" + sampleId + " ]";
    }
    
}
