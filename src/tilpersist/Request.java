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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "request")
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r"),
    @NamedQuery(name = "Request.findByReqIndex", 
        query = "SELECT r FROM Request r WHERE r.reqIndex = :reqIndex"),
    @NamedQuery(name = "Request.findByFpni", 
        query = "SELECT r FROM Request r WHERE r.fpni = :fpni"),
    @NamedQuery(name = "Request.findByCartnum", 
        query = "SELECT r FROM Request r WHERE r.cartnum = :cartnum"),
    @NamedQuery(name = "Request.findByDatesub", 
        query = "SELECT r FROM Request r WHERE r.datesub = :datesub"),
    @NamedQuery(name = "Request.findByDateappr", 
        query = "SELECT r FROM Request r WHERE r.dateappr = :dateappr"),
    @NamedQuery(name = "Request.findByDatepull", 
        query = "SELECT r FROM Request r WHERE r.datepull = :datepull"),
    @NamedQuery(name = "Request.findByNumrequested", 
        query = "SELECT r FROM Request r WHERE r.numrequested = :numrequested"),
    @NamedQuery(name = "Request.findJoinUnpulled", 
        query="SELECT r FROM Request as r "
        + "JOIN r.invRecord AS n "
        + "JOIN r.invRecord.owner AS p "
        + "WHERE r.datepull IS NULL AND r.dateappr IS NOT NULL "
        + "AND r.fpni=n.pniIndex "
        + "AND r.invRecord.mrn = p.mrn"),
    @NamedQuery(name = "Request.findJoinUnapproved", 
        query="SELECT r FROM Request as r "
        + "JOIN r.invRecord AS n "
        + "JOIN r.invRecord.owner AS p "
        + "WHERE r.dateappr IS NULL "
        + "AND r.fpni = n.pniIndex "
        + "AND r.invRecord.mrn = p.mrn"),
    @NamedQuery(name = "Request.deleteCart", 
        query = "DELETE FROM Request r WHERE r.cartnum = :cartnum"),
    @NamedQuery(name = "Request.deleteRequest", 
        query = "DELETE FROM Request r WHERE r.reqIndex = :reqIndex"),
    @NamedQuery(name = "Request.markCartDateApproved", 
        query = "UPDATE Request r SET r.dateappr = current_date() "
        + "WHERE r.cartnum = :cartnum"),
    @NamedQuery(name = "Request.markCartDatePulled", 
        query = "UPDATE Request r SET r.datepull = current_date() "
        + "WHERE r.cartnum = :cartnum"),
    @NamedQuery(name = "Request.alterNumPulled", 
        query = "UPDATE Request r SET r.numrequested = :numrequested "
        + "WHERE r.reqIndex = :reqIndex"),
    @NamedQuery(name = "Request.updateCartInfo", 
        query ="UPDATE Request r "
        + "SET r.rname = :rname, r.email = :email, r.rmdest = :rmdest, "
        + "r.rnote = :rnote "
        + "WHERE r.cartnum = :cartnum"),
    @NamedQuery(name = "Request.getCompleted",
        query = "SELECT r FROM Request AS r "
        + "JOIN r.invRecord AS n "
        + "JOIN r.invRecord.owner AS p "
        + "WHERE r.datepull IS NOT NULL"),
    @NamedQuery(name = "Request.getCompletedAfterDtPull",
        query = "SELECT r FROM Request As r "
        + "JOIN r.invRecord AS n "
        + "JOIN r.invRecord.owner AS p "
        + "WHERE r.datepull > :dtpull"
        )
      
    })

    public class Request implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "req_index")
    private Long reqIndex;
    @Basic(optional = false)
    @Column(name = "fpni")
    private Long fpni;
    @Basic(optional = false)
    @Column(name = "cartnum")
    private Long cartnum;
    @Column(name = "datesub")
    @Temporal(TemporalType.DATE)
    private Date datesub;
    @Column(name = "dateappr")
    @Temporal(TemporalType.DATE)
    private Date dateappr;
    @Column(name = "datepull")
    @Temporal(TemporalType.DATE)
    private Date datepull;
    @Column(name = "numrequested")
    private Integer numrequested;
    @Lob
    @Column(name = "sbuser")
    private String sbuser;
    @Lob
    @Column(name = "email")
    private String email;
    @Lob
    @Column(name = "rmdest")
    private String rmdest;
    @Lob
    @Column(name = "rname")
    private String rname;
    @Lob
    @Column(name = "rnote")
    private String rnote;

    @ManyToOne
    @JoinColumn(name="fpni",referencedColumnName="pni_index",
        insertable=false, updatable=false)
    private Norminv invRecord;

    public Request() {
    }

    public Request(Long reqIndex) {
        this.reqIndex = reqIndex;
    }

    public Request(Long reqIndex, Long fpni, Long cartnum) {
        this.reqIndex = reqIndex;
        this.fpni = fpni;
        this.cartnum = cartnum;
    }

    @Override
    public Object clone(){
        //Make a new request object & copy all the field values.
        
        Request ret = new Request(this.reqIndex, this.fpni, this.cartnum);
        //Dates need to be cloned
        ret.dateappr = (Date) this.dateappr.clone();
        ret.datepull = (Date) this.datepull.clone();
        ret.datesub = (Date) this.datesub.clone();
        //For the inventory record, copy the reference only
        ret.invRecord = this.invRecord;
        //Strings are immuteable and safe to simply copy by assignment.
        ret.email = this.email;
        ret.numrequested = this.numrequested; 
        ret.rmdest = this.rmdest;
        ret.rname = this.rname;
        ret.rnote = this.rnote;
        ret.sbuser = this.sbuser;
                
        return ret;
    }
    
    public Long getReqIndex() {
        return reqIndex;
    }

    public void setReqIndex(Long reqIndex) {
        this.reqIndex = reqIndex;
    }

    public Long getFpni() {
        return fpni;
    }

    public void setFpni(Long fpni) {
        this.fpni = fpni;
    }

    public Long getCartnum() {
        return cartnum;
    }

    public void setCartnum(Long cartnum) {
        this.cartnum = cartnum;
    }

    public Date getDatesub() {
        return datesub;
    }

    public void setDatesub(Date datesub) {
        this.datesub = datesub;
    }

    public Date getDateappr() {
        return dateappr;
    }

    public void setDateappr(Date dateappr) {
        this.dateappr = dateappr;
    }

    public Date getDatepull() {
        return datepull;
    }

    public void setDatepull(Date datepull) {
        this.datepull = datepull;
    }

    public Integer getNumrequested() {
        return numrequested;
    }

    public void setNumrequested(Integer numrequested) {
        this.numrequested = numrequested;
    }

    public String getSbuser() {
        return sbuser;
    }

    public void setSbuser(String sbuser) {
        this.sbuser = sbuser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRmdest() {
        return rmdest;
    }

    public void setRmdest(String rmdest) {
        this.rmdest = rmdest;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRnote() {
        return rnote;
    }

    public void setRnote(String rnote) {
        this.rnote = rnote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reqIndex != null ? reqIndex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        
        /* //Original implementation is simple reqIndex check
        if ((this.reqIndex == null && other.reqIndex != null) || 
                (this.reqIndex != null && !this.reqIndex.equals(other.reqIndex))) {
            return false;
        }
        */
        
        //Check non-string fields. These might be null, but shouldn't hurt
        // the comparison.  If any don't match, Requests are not equal
        if( this.reqIndex == other.reqIndex &&
            this.cartnum == other.cartnum &&
            this.dateappr == other.dateappr &&
            this.datepull == other.datepull &&
            this.datesub == other.datesub &&
            this.fpni == other.fpni &&
            this.invRecord == other.invRecord &&
            this.numrequested == other.numrequested &&
            this.reqIndex == other.reqIndex
                 ){
            //Carry on.
        }else{
            //A field is not equal.  Whole thing is not equal
            return false;
        }
        
        /*String value checks.  str1 == null ? str2 == null : str1.equals(str2)
         * if str1 is null, expression is false
         * if str1 is null and str2 is not null, expression is false
         * if str1 is null and str2 is null and values are not equal, expr false
         * if str1 is null and str2 is null, epression is true.
         * if str1 and str2 are not null and values are equal, expression true.
        */
        if( (this.sbuser == null ? other.sbuser == null : this.sbuser.equals(other.sbuser)) &&
            (this.rmdest == null ? other.rmdest == null : this.rmdest.equals(other.rmdest)) &&
            (this.rnote == null ? other.rnote == null : this.rnote.equals(other.rnote)) &&
            (this.email == null ? other.email == null : this.email.equals(other.email))
                ){
            //Everything is equal.  Carry on
        }else{
            //Strings are not equal
            return false;
        }
        
        //All the checks have passed, call the requests equal.
        return true;
    }

    @Override
    public String toString() {
        return "tilpersist.Request[reqIndex=" + reqIndex + "]";
    }

    /**
     * @return the invRecord
     */
    public Norminv getInvRecord() {
        return invRecord;
    }

    /**
     * @param invRecord the invRecord to set
     */
    public void setInvRecord(Norminv invRecord) {
        this.invRecord = invRecord;
    }

}
