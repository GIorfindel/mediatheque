/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author glorfindel
 */
@Embeddable
public class EmpruntePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEEMPRUNT")
    @Temporal(TemporalType.DATE)
    private Date dateemprunt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATERETOUR")
    @Temporal(TemporalType.DATE)
    private Date dateretour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MEDIA")
    private int idMedia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ADHERENT")
    private int idAdherent;

    public EmpruntePK() {
    }

    public EmpruntePK(Date dateemprunt, Date dateretour, int idMedia, int idAdherent) {
        this.dateemprunt = dateemprunt;
        this.dateretour = dateretour;
        this.idMedia = idMedia;
        this.idAdherent = idAdherent;
    }

    public Date getDateemprunt() {
        return dateemprunt;
    }

    public void setDateemprunt(Date dateemprunt) {
        this.dateemprunt = dateemprunt;
    }

    public Date getDateretour() {
        return dateretour;
    }

    public void setDateretour(Date dateretour) {
        this.dateretour = dateretour;
    }

    public int getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(int idMedia) {
        this.idMedia = idMedia;
    }

    public int getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(int idAdherent) {
        this.idAdherent = idAdherent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dateemprunt != null ? dateemprunt.hashCode() : 0);
        hash += (dateretour != null ? dateretour.hashCode() : 0);
        hash += (int) idMedia;
        hash += (int) idAdherent;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpruntePK)) {
            return false;
        }
        EmpruntePK other = (EmpruntePK) object;
        if ((this.dateemprunt == null && other.dateemprunt != null) || (this.dateemprunt != null && !this.dateemprunt.equals(other.dateemprunt))) {
            return false;
        }
        if ((this.dateretour == null && other.dateretour != null) || (this.dateretour != null && !this.dateretour.equals(other.dateretour))) {
            return false;
        }
        if (this.idMedia != other.idMedia) {
            return false;
        }
        if (this.idAdherent != other.idAdherent) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.EmpruntePK[ dateemprunt=" + dateemprunt + ", dateretour=" + dateretour + ", idMedia=" + idMedia + ", idAdherent=" + idAdherent + " ]";
    }
    
}
