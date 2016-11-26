/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ADHERENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adherent.findAll", query = "SELECT a FROM Adherent a")
    , @NamedQuery(name = "Adherent.findByAdherentId", query = "SELECT a FROM Adherent a WHERE a.adherentId = :adherentId")})
public class Adherent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADHERENT_ID")
    private Integer adherentId;
    @JoinColumn(name = "ADHERENT_ID", referencedColumnName = "PERSONNE_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adherent")
    private Collection<Emprunte> emprunteCollection;

    public Adherent() {
    }

    public Adherent(Integer adherentId) {
        this.adherentId = adherentId;
    }

    public Integer getAdherentId() {
        return adherentId;
    }

    public void setAdherentId(Integer adherentId) {
        this.adherentId = adherentId;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @XmlTransient
    public Collection<Emprunte> getEmprunteCollection() {
        return emprunteCollection;
    }

    public void setEmprunteCollection(Collection<Emprunte> emprunteCollection) {
        this.emprunteCollection = emprunteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adherentId != null ? adherentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adherent)) {
            return false;
        }
        Adherent other = (Adherent) object;
        if ((this.adherentId == null && other.adherentId != null) || (this.adherentId != null && !this.adherentId.equals(other.adherentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Adherent[ adherentId=" + adherentId + " ]";
    }
    
}
