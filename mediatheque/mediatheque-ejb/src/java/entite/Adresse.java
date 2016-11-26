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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author glorfindel
 */
@Entity
@Table(name = "ADRESSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a")
    , @NamedQuery(name = "Adresse.findByAdresseId", query = "SELECT a FROM Adresse a WHERE a.adresseId = :adresseId")
    , @NamedQuery(name = "Adresse.findByPays", query = "SELECT a FROM Adresse a WHERE a.pays = :pays")
    , @NamedQuery(name = "Adresse.findByVille", query = "SELECT a FROM Adresse a WHERE a.ville = :ville")
    , @NamedQuery(name = "Adresse.findByRue", query = "SELECT a FROM Adresse a WHERE a.rue = :rue")
    , @NamedQuery(name = "Adresse.findByNumero", query = "SELECT a FROM Adresse a WHERE a.numero = :numero")})
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ADRESSE_ID")
    private Integer adresseId;
    @Size(max = 20)
    @Column(name = "PAYS")
    private String pays;
    @Size(max = 20)
    @Column(name = "VILLE")
    private String ville;
    @Size(max = 20)
    @Column(name = "RUE")
    private String rue;
    @Column(name = "NUMERO")
    private Integer numero;
    @OneToMany(mappedBy = "adresseId")
    private Collection<Editeur> editeurCollection;
    @OneToMany(mappedBy = "adresseId")
    private Collection<Personne> personneCollection;

    public Adresse() {
    }

    public Adresse(Integer adresseId) {
        this.adresseId = adresseId;
    }

    public Integer getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(Integer adresseId) {
        this.adresseId = adresseId;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @XmlTransient
    public Collection<Editeur> getEditeurCollection() {
        return editeurCollection;
    }

    public void setEditeurCollection(Collection<Editeur> editeurCollection) {
        this.editeurCollection = editeurCollection;
    }

    @XmlTransient
    public Collection<Personne> getPersonneCollection() {
        return personneCollection;
    }

    public void setPersonneCollection(Collection<Personne> personneCollection) {
        this.personneCollection = personneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adresseId != null ? adresseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.adresseId == null && other.adresseId != null) || (this.adresseId != null && !this.adresseId.equals(other.adresseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Adresse[ adresseId=" + adresseId + " ]";
    }
    
}
