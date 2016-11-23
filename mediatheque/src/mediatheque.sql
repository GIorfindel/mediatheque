CREATE schema Mediatheque;

CREATE table Mediatheque.Adresse(
  adresse_id integer generated always as identity primary key,
  pays varchar(20),
  ville varchar(20),
  rue varchar(20),
  numero integer
);

CREATE table Mediatheque.Personne(
  personne_Id integer generated always as identity primary key,
  nom varchar(20),
  prenom varchar(20),
  telephone varchar(10),
  adresse_id integer references Adresse(adresse_id)
);

create table Mediatheque.bibliothecaire(
  bibliothecaire_id integer primary key references Personne(personne_Id),
  login varchar(20),
  mdp varchar(20)
);

CREATE table Mediatheque.Auteur(
  auteur_id integer primary key
);
alter table Mediatheque.Auteur add foreign key (auteur_id) references Mediatheque.Personne;

create table Mediatheque.Editeur(
  editeur_id integer generated always as identity primary key,
  nom varchar(20),
  adresse_id integer references Adresse(adresse_id)
);

create table Mediatheque.Type(
  type_id integer generated always as identity primary key,
  nom varchar(10)
);

create table Mediatheque.Media(
  media_id integer generated always as identity primary key,
  type_id integer references Type(type_id),
  nbExemplaires integer
);

create table Mediatheque.Edition(
  edition_id integer generated always as identity primary key,
  nom varchar(20),
  publication date,
  id_media integer references Media(media_id)
);

create table Mediatheque.CreePar(
  edition_id integer references Edition(edition_id),
  auteur_id integer references Auteur(auteur_id),
  primary key (edition_id, auteur_id)
);

create table Mediatheque.Livre(
  livre_id integer references Media(media_id),
  ISBN varchar(13) primary key
);

create table Mediatheque.Genre(
  genre_id integer primary key references Media(media_id),
  nom varchar(20)
);

create table Mediatheque.EstGenre(
  media_id integer references Media(media_id),
  genre_id integer references Genre(genre_id),
  primary key (media_id, genre_id)
);

/*create table Mediatheque.Mediatheque(
    mediatheque_id integer generated always as identity primary key,
    nom varchar(20),
    adresse_id integer references Adresse(adresse_id)
);*/

create table Mediatheque.Adherent(
  adherent_id integer primary key references Personne(personne_Id)
);

create table Mediatheque.Emprunte(
  dateEmprunt date,
  dateRetour date,
  id_media integer references Media(media_id),
  id_adherent integer references Adherent(adherent_id),
  primary key (dateRetour, dateEmprunt, id_media, id_adherent)
);
