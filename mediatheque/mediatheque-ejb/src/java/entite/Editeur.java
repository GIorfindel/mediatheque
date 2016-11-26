/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author glorfindel
 */
@Entity
@Table(name = "EDITEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editeur.findAll", query = "SELECT e FROM Editeur e")
    , @NamedQuery(name = "Editeur.findByEditeurId", query = "SELECT e FROM Editeur e WHERE e.editeurId = :editeurId")
    , @NamedQuery(name = "Editeur.findByNom", query = "SELECT e FROM Editeur e WHERE e.nom = :nom")})
public class Editeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EDITEUR_ID")
    private Integer editeurId;
    @Size(max = 20)
    @Column(name = "NOM")
    private String nom;
    @JoinColumn(name = "ADRESSE_ID", referencedColumnName = "ADRESSE_ID")
    @ManyToOne
    private Adresse adresseId;

    public Editeur() {
    }

    public Editeur(Integer editeurId) {
        this.editeurId = editeurId;
    }

    public Integer getEditeurId() {
        return editeurId;
    }

    public void setEditeurId(Integer editeurId) {
        this.editeurId = editeurId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(Adresse adresseId) {
        this.adresseId = adresseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (editeurId != null ? editeurId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editeur)) {
            return false;
        }
        Editeur other = (Editeur) object;
        if ((this.editeurId == null && other.editeurId != null) || (this.editeurId != null && !this.editeurId.equals(other.editeurId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Editeur[ editeurId=" + editeurId + " ]";
    }
    
}
