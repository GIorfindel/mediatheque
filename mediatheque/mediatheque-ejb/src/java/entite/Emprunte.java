/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author glorfindel
 */
@Entity
@Table(name = "EMPRUNTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emprunte.findAll", query = "SELECT e FROM Emprunte e")
    , @NamedQuery(name = "Emprunte.findByDateemprunt", query = "SELECT e FROM Emprunte e WHERE e.empruntePK.dateemprunt = :dateemprunt")
    , @NamedQuery(name = "Emprunte.findByDateretour", query = "SELECT e FROM Emprunte e WHERE e.empruntePK.dateretour = :dateretour")
    , @NamedQuery(name = "Emprunte.findByIdMedia", query = "SELECT e FROM Emprunte e WHERE e.empruntePK.idMedia = :idMedia")
    , @NamedQuery(name = "Emprunte.findByIdAdherent", query = "SELECT e FROM Emprunte e WHERE e.empruntePK.idAdherent = :idAdherent")})
public class Emprunte implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpruntePK empruntePK;
    @JoinColumn(name = "ID_ADHERENT", referencedColumnName = "ADHERENT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Adherent adherent;
    @JoinColumn(name = "ID_MEDIA", referencedColumnName = "MEDIA_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Media media;

    public Emprunte() {
    }

    public Emprunte(EmpruntePK empruntePK) {
        this.empruntePK = empruntePK;
    }

    public Emprunte(Date dateemprunt, Date dateretour, int idMedia, int idAdherent) {
        this.empruntePK = new EmpruntePK(dateemprunt, dateretour, idMedia, idAdherent);
    }

    public EmpruntePK getEmpruntePK() {
        return empruntePK;
    }

    public void setEmpruntePK(EmpruntePK empruntePK) {
        this.empruntePK = empruntePK;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empruntePK != null ? empruntePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprunte)) {
            return false;
        }
        Emprunte other = (Emprunte) object;
        if ((this.empruntePK == null && other.empruntePK != null) || (this.empruntePK != null && !this.empruntePK.equals(other.empruntePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Emprunte[ empruntePK=" + empruntePK + " ]";
    }
    
}
