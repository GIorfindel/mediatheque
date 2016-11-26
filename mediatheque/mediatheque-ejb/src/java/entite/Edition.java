/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author glorfindel
 */
@Entity
@Table(name = "EDITION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edition.findAll", query = "SELECT e FROM Edition e")
    , @NamedQuery(name = "Edition.findByEditionId", query = "SELECT e FROM Edition e WHERE e.editionId = :editionId")
    , @NamedQuery(name = "Edition.findByNom", query = "SELECT e FROM Edition e WHERE e.nom = :nom")
    , @NamedQuery(name = "Edition.findByPublication", query = "SELECT e FROM Edition e WHERE e.publication = :publication")})
public class Edition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EDITION_ID")
    private Integer editionId;
    @Size(max = 20)
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PUBLICATION")
    @Temporal(TemporalType.DATE)
    private Date publication;
    @JoinTable(name = "CREEPAR", joinColumns = {
        @JoinColumn(name = "EDITION_ID", referencedColumnName = "EDITION_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "AUTEUR_ID", referencedColumnName = "AUTEUR_ID")})
    @ManyToMany
    private Collection<Auteur> auteurCollection;
    @JoinColumn(name = "ID_MEDIA", referencedColumnName = "MEDIA_ID")
    @ManyToOne
    private Media idMedia;

    public Edition() {
    }

    public Edition(Integer editionId) {
        this.editionId = editionId;
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    @XmlTransient
    public Collection<Auteur> getAuteurCollection() {
        return auteurCollection;
    }

    public void setAuteurCollection(Collection<Auteur> auteurCollection) {
        this.auteurCollection = auteurCollection;
    }

    public Media getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(Media idMedia) {
        this.idMedia = idMedia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (editionId != null ? editionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edition)) {
            return false;
        }
        Edition other = (Edition) object;
        if ((this.editionId == null && other.editionId != null) || (this.editionId != null && !this.editionId.equals(other.editionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Edition[ editionId=" + editionId + " ]";
    }
    
}
