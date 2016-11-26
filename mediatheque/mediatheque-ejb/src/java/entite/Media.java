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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author glorfindel
 */
@Entity
@Table(name = "MEDIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m")
    , @NamedQuery(name = "Media.findByMediaId", query = "SELECT m FROM Media m WHERE m.mediaId = :mediaId")
    , @NamedQuery(name = "Media.findByNbexemplaires", query = "SELECT m FROM Media m WHERE m.nbexemplaires = :nbexemplaires")})
public class Media implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEDIA_ID")
    private Integer mediaId;
    @Column(name = "NBEXEMPLAIRES")
    private Integer nbexemplaires;
    @JoinTable(name = "ESTGENRE", joinColumns = {
        @JoinColumn(name = "MEDIA_ID", referencedColumnName = "MEDIA_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "GENRE_ID", referencedColumnName = "GENRE_ID")})
    @ManyToMany
    private Collection<Genre> genreCollection;
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "TYPE_ID")
    @ManyToOne
    private Type typeId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "media")
    private Genre genre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "media")
    private Collection<Emprunte> emprunteCollection;
    @OneToMany(mappedBy = "idMedia")
    private Collection<Edition> editionCollection;
    @OneToMany(mappedBy = "livreId")
    private Collection<Livre> livreCollection;

    public Media() {
    }

    public Media(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getNbexemplaires() {
        return nbexemplaires;
    }

    public void setNbexemplaires(Integer nbexemplaires) {
        this.nbexemplaires = nbexemplaires;
    }

    @XmlTransient
    public Collection<Genre> getGenreCollection() {
        return genreCollection;
    }

    public void setGenreCollection(Collection<Genre> genreCollection) {
        this.genreCollection = genreCollection;
    }

    public Type getTypeId() {
        return typeId;
    }

    public void setTypeId(Type typeId) {
        this.typeId = typeId;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @XmlTransient
    public Collection<Emprunte> getEmprunteCollection() {
        return emprunteCollection;
    }

    public void setEmprunteCollection(Collection<Emprunte> emprunteCollection) {
        this.emprunteCollection = emprunteCollection;
    }

    @XmlTransient
    public Collection<Edition> getEditionCollection() {
        return editionCollection;
    }

    public void setEditionCollection(Collection<Edition> editionCollection) {
        this.editionCollection = editionCollection;
    }

    @XmlTransient
    public Collection<Livre> getLivreCollection() {
        return livreCollection;
    }

    public void setLivreCollection(Collection<Livre> livreCollection) {
        this.livreCollection = livreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediaId != null ? mediaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.mediaId == null && other.mediaId != null) || (this.mediaId != null && !this.mediaId.equals(other.mediaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Media[ mediaId=" + mediaId + " ]";
    }
    
}
