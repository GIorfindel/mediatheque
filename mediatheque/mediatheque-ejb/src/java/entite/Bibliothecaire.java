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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author glorfindel
 */
@Entity
@Table(name = "BIBLIOTHECAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliothecaire.findAll", query = "SELECT b FROM Bibliothecaire b")
    , @NamedQuery(name = "Bibliothecaire.findByBibliothecaireId", query = "SELECT b FROM Bibliothecaire b WHERE b.bibliothecaireId = :bibliothecaireId")
    , @NamedQuery(name = "Bibliothecaire.findByLogin", query = "SELECT b FROM Bibliothecaire b WHERE b.login = :login")
    , @NamedQuery(name = "Bibliothecaire.findByMdp", query = "SELECT b FROM Bibliothecaire b WHERE b.mdp = :mdp")})
public class Bibliothecaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIBLIOTHECAIRE_ID")
    private Integer bibliothecaireId;
    @Size(max = 20)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 20)
    @Column(name = "MDP")
    private String mdp;
    @JoinColumn(name = "BIBLIOTHECAIRE_ID", referencedColumnName = "PERSONNE_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;

    public Bibliothecaire() {
    }

    public Bibliothecaire(Integer bibliothecaireId) {
        this.bibliothecaireId = bibliothecaireId;
    }

    public Integer getBibliothecaireId() {
        return bibliothecaireId;
    }

    public void setBibliothecaireId(Integer bibliothecaireId) {
        this.bibliothecaireId = bibliothecaireId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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
        hash += (bibliothecaireId != null ? bibliothecaireId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bibliothecaire)) {
            return false;
        }
        Bibliothecaire other = (Bibliothecaire) object;
        if ((this.bibliothecaireId == null && other.bibliothecaireId != null) || (this.bibliothecaireId != null && !this.bibliothecaireId.equals(other.bibliothecaireId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Bibliothecaire[ bibliothecaireId=" + bibliothecaireId + " ]";
    }
    
}
