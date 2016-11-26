/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author glorfindel
 */
@Entity
@Table(name = "AUTEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auteur.findAll", query = "SELECT a FROM Auteur a")
    , @NamedQuery(name = "Auteur.findByAuteurId", query = "SELECT a FROM Auteur a WHERE a.auteurId = :auteurId")})
public class Auteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUTEUR_ID")
    private Integer auteurId;
    @ManyToMany(mappedBy = "auteurCollection")
    private Collection<Edition> editionCollection;
    @JoinColumn(name = "AUTEUR_ID", referencedColumnName = "PERSONNE_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;

    public Auteur() {
    }

    public Auteur(Integer auteurId) {
        this.auteurId = auteurId;
    }

    public Integer getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(Integer auteurId) {
        this.auteurId = auteurId;
    }

    @XmlTransient
    public Collection<Edition> getEditionCollection() {
        return editionCollection;
    }

    public void setEditionCollection(Collection<Edition> editionCollection) {
        this.editionCollection = editionCollection;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auteurId != null ? auteurId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auteur)) {
            return false;
        }
        Auteur other = (Auteur) object;
        if ((this.auteurId == null && other.auteurId != null) || (this.auteurId != null && !this.auteurId.equals(other.auteurId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Auteur[ auteurId=" + auteurId + " ]";
    }
    
}
