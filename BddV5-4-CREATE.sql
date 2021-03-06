/*==============================================================*/
/* Nom de SGBD :  PostgreSQL 8                                  */
/* Date de création :  23/02/2016 21:17:19                      */
/*==============================================================*/

DROP TABLE IF EXISTS VOIE CASCADE;
DROP TABLE IF EXISTS FILIERE CASCADE;
DROP TABLE IF EXISTS NIVEAU CASCADE;
DROP TABLE IF EXISTS BLOC CASCADE;
DROP TABLE IF EXISTS MATIERE CASCADE;
DROP TABLE IF EXISTS COM_CAP CASCADE;
DROP TABLE IF EXISTS ASSOC_COM_CAP CASCADE;
DROP TABLE IF EXISTS CLASSROOM CASCADE;
DROP TABLE IF EXISTS PERSONNE CASCADE;
DROP TABLE IF EXISTS ELEVE CASCADE;
DROP TABLE IF EXISTS EMPLOYE CASCADE;
DROP TABLE IF EXISTS GROUPE CASCADE;
DROP TABLE IF EXISTS DROIT CASCADE;
DROP TABLE IF EXISTS BILAN CASCADE;
DROP TABLE IF EXISTS NOTE CASCADE;

DROP TABLE IF EXISTS ASSOC_FILIERE_BLOC CASCADE;
DROP TABLE IF EXISTS ASSOC_MATIERE_COM_CAP CASCADE;
DROP TABLE IF EXISTS ASSOC_EMPLOYE_GROUPE CASCADE;

DROP TABLE IF EXISTS ASSOC_ENSEIGNER CASCADE;
DROP TABLE IF EXISTS ASSOC_ETUDIER CASCADE;
DROP TABLE IF EXISTS ASSOC_EVALUER CASCADE;

DROP TABLE IF EXISTS PARAMETRE CASCADE;
DROP TABLE IF EXISTS STATISTIQUE CASCADE;
DROP TABLE IF EXISTS PROMO CASCADE;
DROP TABLE IF EXISTS TOKEN CASCADE;

/*==============================================================*/
/* Table : token                                                 */
/*==============================================================*/
CREATE TABLE TOKEN
(
  id SERIAL PRIMARY KEY  NOT NULL,
  utilisateur  VARCHAR(40) NOT NULL,
  token VARCHAR(40)
)

/*==============================================================*/
/* Table : PROMO                                                 */
/*==============================================================*/
CREATE TABLE PROMO (
  PROMO_ID      SERIAL               NOT NULL,
  PROMO_LIBELLE CHARACTER VARYING(9) NOT NULL,
  CONSTRAINT PK_PROMO PRIMARY KEY (PROMO_ID)
);


/*==============================================================*/
/* Table : VOIE                                                 */
/*==============================================================*/
CREATE TABLE VOIE (
  VOIE_ID      SERIAL                 NOT NULL,
  VOIE_LIBELLE CHARACTER VARYING(150) NOT NULL,
  CONSTRAINT PK_VOIE PRIMARY KEY (VOIE_ID)
);

/*==============================================================*/
/* Table : FILIERE                                              */
/*==============================================================*/
CREATE TABLE FILIERE (
  FILIERE_ID         SERIAL                 NOT NULL,
  FILIERE_FK_VOIE_ID INT                    NOT NULL,
  FILIERE_LIBELLE    CHARACTER VARYING(150) NOT NULL,
  CONSTRAINT PK_FILIERE PRIMARY KEY (FILIERE_ID)
);
ALTER TABLE FILIERE
ADD CONSTRAINT FK_FILIERE_CONTENIR_VOIE FOREIGN KEY (FILIERE_FK_VOIE_ID)
REFERENCES VOIE (VOIE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

/*==============================================================*/
/* Table : NIVEAU                                               */
/*==============================================================*/
CREATE TABLE NIVEAU (
  NIVEAU_ID      SERIAL                 NOT NULL,
  NIVEAU_LIBELLE CHARACTER VARYING(150) NOT NULL,
  CONSTRAINT PK_NIVEAU PRIMARY KEY (NIVEAU_ID)
);

/*==============================================================*/
/* Table : BLOC                                                 */
/*==============================================================*/
CREATE TABLE BLOC (
  BLOC_ID      SERIAL                 NOT NULL,
  BLOC_LIBELLE CHARACTER VARYING(150) NOT NULL,
  CONSTRAINT PK_BLOC PRIMARY KEY (BLOC_ID)
);

/*==============================================================*/
/* Table : MATIERE                                              */
/*==============================================================*/
CREATE TABLE MATIERE (
  MATIERE_ID         SERIAL                 NOT NULL,
  MATIERE_FK_BLOC_ID INT                    NOT NULL,
  MATIERE_LIBELLE    CHARACTER VARYING(150) NOT NULL,
  CONSTRAINT PK_MATIERE PRIMARY KEY (MATIERE_ID)
);
ALTER TABLE MATIERE
ADD CONSTRAINT FK_MATIERE_COMPORTER_BLOC FOREIGN KEY (MATIERE_FK_BLOC_ID)
REFERENCES BLOC (BLOC_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

/*==============================================================*/
/* Table : COM_CAP                                              */
/*==============================================================*/
CREATE TABLE COM_CAP (
  COM_CAP_ID      SERIAL                 NOT NULL,
  COM_CAP_LIBELLE CHARACTER VARYING(350) NOT NULL,
  CONSTRAINT PK_COM_CAP PRIMARY KEY (COM_CAP_ID)
);

/*==============================================================*/
/* Table : ASSOC_COM_CAP                                        */
/*==============================================================*/
CREATE TABLE ASSOC_COM_CAP (
  ASSOC_COM_CAP_ID        SERIAL NOT NULL,
  ASSOC_COM_CAP_FK_COM_ID INT    NOT NULL,
  ASSOC_COM_CAP_FK_CAP_ID INT    NOT NULL,
  CONSTRAINT PK_ASSOC_COM_CAP PRIMARY KEY (ASSOC_COM_CAP_FK_COM_ID, ASSOC_COM_CAP_FK_CAP_ID)
);

ALTER TABLE ASSOC_COM_CAP
ADD CONSTRAINT FK_ASSOC_CO_A_POUR_CO_COM_CAP FOREIGN KEY (ASSOC_COM_CAP_FK_CAP_ID)
REFERENCES COM_CAP (COM_CAP_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ASSOC_COM_CAP
ADD CONSTRAINT FK_ASSOC_CO_EST_UNE_C_COM_CAP FOREIGN KEY (ASSOC_COM_CAP_FK_COM_ID)
REFERENCES COM_CAP (COM_CAP_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

/*==============================================================*/
/* Table : GROUPE                                               */
/*==============================================================*/
CREATE TABLE GROUPE (
  GROUPE_ID          SERIAL                 NOT NULL,
  GROUPE_LIBELLE     CHARACTER VARYING(100) NOT NULL,
  GROUPE_NIVEAUACCES INT2                   NOT NULL,
  CONSTRAINT PK_GROUPE PRIMARY KEY (GROUPE_ID)
);

/*==============================================================*/
/* Table : DROIT                                                */
/*==============================================================*/
CREATE TABLE DROIT (
  DROIT_ID       SERIAL                 NOT NULL,
  --   DROIT_FK_GROUPE_ID INT                    NOT NULL,
  DROIT_UNITE    CHARACTER VARYING(250) NOT NULL,
  DROIT_LECTURE  INT2                   NOT NULL,
  DROIT_ECRITURE INT2                   NOT NULL,
  CONSTRAINT PK_DROIT PRIMARY KEY (DROIT_ID)
);

-- ALTER TABLE DROIT
-- ADD CONSTRAINT FK_DROIT_DONNER_GROUPE FOREIGN KEY (DROIT_FK_GROUPE_ID)
-- REFERENCES GROUPE (GROUPE_ID)
-- ON DELETE RESTRICT ON UPDATE RESTRICT;
CREATE INDEX droit_unite_index ON public.droit (droit_unite);

/*==============================================================*/
/* Table : PERSONNE                                             */
/*==============================================================*/
CREATE TABLE PERSONNE (
  PERSONNE_ID             SERIAL                 NOT NULL,
  PERSONNE_LOGIN          CHARACTER VARYING(150) NOT NULL,
  PERSONNE_PASSWORD       CHARACTER VARYING(150) NOT NULL DEFAULT 'P@ssword',
  PERSONNE_NOM            CHARACTER VARYING(150) NOT NULL,
  PERSONNE_PRENOM         CHARACTER VARYING(150) NOT NULL,
  PERSONNE_DATE_NAISSANCE DATE,
  PERSONNE_ADRESSE        CHARACTER VARYING(300),
  PERSONNE_CP             CHARACTER VARYING(5),
  PERSONNE_VILLE          CHARACTER VARYING(150),
  PERSONNE_FK_GROUPE_ID   INT                    NOT NULL,
  CONSTRAINT PK_PERSONNE PRIMARY KEY (PERSONNE_ID)
);


ALTER TABLE PERSONNE
ADD CONSTRAINT FK_PERSONNE_AFFILIER_GROUPE FOREIGN KEY (PERSONNE_FK_GROUPE_ID)
REFERENCES GROUPE (GROUPE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

/*==============================================================*/
/* Table : ELEVE                                                */
/*==============================================================*/
CREATE TABLE ELEVE (
  ELEVE_EMAIL_PARENT CHARACTER VARYING(150),
  CONSTRAINT PK_ELEVE PRIMARY KEY (PERSONNE_ID)
)
  INHERITS (PERSONNE);
/* Faut t'il refaire la contrainte vers groupe sur les heritage?*/

/*==============================================================*/
/* Table : EMPLOYE                                              */
/*==============================================================*/
CREATE TABLE EMPLOYE (
  CONSTRAINT PK_EMPLOYE PRIMARY KEY (PERSONNE_ID)
)
  INHERITS (PERSONNE);

/*==============================================================*/
/* Table : CLASSROOM                                               */
/*==============================================================*/
CREATE TABLE CLASSROOM (
  CLASSROOM_ID                     SERIAL                 NOT NULL,
  CLASSROOM_FK_FILIERE_ID          INT                    NOT NULL,
  CLASSROOM_FK_NIVEAU_ID           INT                    NOT NULL,
  CLASSROOM_FK_PERSONNE_MANAGER_ID INT                    NOT NULL,
  CLASSROOM_LIBELLE                CHARACTER VARYING(100) NOT NULL,
  CONSTRAINT PK_CLASSROOM PRIMARY KEY (CLASSROOM_ID)
);

ALTER TABLE CLASSROOM
ADD CONSTRAINT FK_CLASSROOM_AFFILIER_NIVEAU FOREIGN KEY (CLASSROOM_FK_NIVEAU_ID)
REFERENCES NIVEAU (NIVEAU_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE CLASSROOM
ADD CONSTRAINT FK_CLASSROOM_APPARTENI_FILIERE FOREIGN KEY (CLASSROOM_FK_FILIERE_ID)
REFERENCES FILIERE (FILIERE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE CLASSROOM
ADD CONSTRAINT FK_CLASSROOM_A_MANAGER FOREIGN KEY (CLASSROOM_FK_PERSONNE_MANAGER_ID)
REFERENCES EMPLOYE (PERSONNE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;


/*==============================================================*/
/* Table : BILAN                                                */
/*==============================================================*/
CREATE TABLE BILAN (
  BILAN_ID             SERIAL                 NOT NULL,
  BILAN_FK_PERSONNE_ID INT                    NOT NULL,
  BILAN_LIBELLE        CHARACTER VARYING(150) NOT NULL,
  BILAN_COMMENTAIRE    CHARACTER VARYING(255) NOT NULL,
  BILAN_DATE_DEBUT     DATE                   NOT NULL,
  BILAN_DATE_FIN       DATE                   NOT NULL,
  CONSTRAINT PK_BILAN PRIMARY KEY (BILAN_ID)
);

ALTER TABLE BILAN
ADD CONSTRAINT FK_BILAN_RECEVOIR_ELEVE FOREIGN KEY (BILAN_FK_PERSONNE_ID)
REFERENCES ELEVE (PERSONNE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

/*==============================================================*/
/* Table : NOTE                                                 */
/*==============================================================*/
CREATE TABLE NOTE (
  NOTE_ID      SERIAL                 NOT NULL,
  NOTE_ABVR    CHARACTER VARYING(3)   NOT NULL,
  NOTE_LIBELLE CHARACTER VARYING(100) NOT NULL,
  NOTE_VALEUR  INT                    NOT NULL,
  NOTE_COULEUR CHARACTER VARYING(7)   NOT NULL,
  NOTE_ACTIVE  BOOLEAN                NOT NULL,
  CONSTRAINT PK_NOTE PRIMARY KEY (NOTE_ID)
);


/*==============================================================*/
/* Table : FILIERE_BLOC                                         */
/*==============================================================*/
CREATE TABLE ASSOC_FILIERE_BLOC (
  ASSOC_FILIERE_BLOC_ID            SERIAL NOT NULL,
  ASSOC_FILIERE_BLOC_FK_FILIERE_ID INT    NOT NULL,
  ASSOC_FILIERE_BLOC_FK_BLOC_ID    INT    NOT NULL,
  CONSTRAINT PK_FILIERE_BLOC PRIMARY KEY (ASSOC_FILIERE_BLOC_FK_FILIERE_ID, ASSOC_FILIERE_BLOC_FK_BLOC_ID)
);

ALTER TABLE ASSOC_FILIERE_BLOC
ADD CONSTRAINT FK_FILIERE__LIER_BLOC FOREIGN KEY (ASSOC_FILIERE_BLOC_FK_BLOC_ID)
REFERENCES BLOC (BLOC_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ASSOC_FILIERE_BLOC
ADD CONSTRAINT FK_FILIERE__LIER2_FILIERE FOREIGN KEY (ASSOC_FILIERE_BLOC_FK_FILIERE_ID)
REFERENCES FILIERE (FILIERE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

/*==============================================================*/
/* Table : MATIERE_COM_CAP                                      */
/*==============================================================*/
CREATE TABLE ASSOC_MATIERE_COM_CAP (
  ASSOC_MATIERE_COM_CAP_ID               SERIAL NOT NULL,
  ASSOC_MATIERE_COM_CAP_FK_MATIERE_ID    INT    NOT NULL,
  ASSOC_MATIERE_COM_CAP_FK_COMPETENCE_ID INT    NOT NULL,
  CONSTRAINT PK_MATIERE_COM_CAP PRIMARY KEY (ASSOC_MATIERE_COM_CAP_FK_MATIERE_ID, ASSOC_MATIERE_COM_CAP_FK_COMPETENCE_ID)
);

ALTER TABLE ASSOC_MATIERE_COM_CAP
ADD CONSTRAINT FK_MATIERE__POSSEDER_COM_CAP FOREIGN KEY (ASSOC_MATIERE_COM_CAP_FK_COMPETENCE_ID)
REFERENCES COM_CAP (COM_CAP_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ASSOC_MATIERE_COM_CAP
ADD CONSTRAINT FK_MATIERE__POSSEDER2_MATIERE FOREIGN KEY (ASSOC_MATIERE_COM_CAP_FK_MATIERE_ID)
REFERENCES MATIERE (MATIERE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

/*==============================================================*/
/* Table : ASSOC_EMPLOYE_GROUPE                                 */
/*==============================================================*/
/* MAJ 13/03 */
/*  Une personne ne peut pas avoir plusieurs groupe */
/*create table ASSOC_EMPLOYE_GROUPE (
	ASSOC_EMPLOYE_GROUPE_ID SERIAL not null,
   ASSOC_EMPLOYE_GROUPE_FK_PERSONNE_ID          INT                 not null,
   ASSOC_EMPLOYE_GROUPE_FK_GROUPE_ID            INT                 not null,
   constraint PK_EMPLOYE_GROUPE primary key (ASSOC_EMPLOYE_GROUPE_FK_PERSONNE_ID, ASSOC_EMPLOYE_GROUPE_FK_GROUPE_ID)
);

alter table ASSOC_EMPLOYE_GROUPE
   add constraint FK_EMPLOYE__AVOIR_GROUPE foreign key (ASSOC_EMPLOYE_GROUPE_FK_GROUPE_ID)
      references GROUPE (GROUPE_ID)
      on delete restrict on update restrict;

alter table ASSOC_EMPLOYE_GROUPE
   add constraint FK_EMPLOYE__AVOIR2_EMPLOYE foreign key (ASSOC_EMPLOYE_GROUPE_FK_PERSONNE_ID)
      references EMPLOYE (PERSONNE_ID)
      on delete restrict on update restrict;
*/
/*==============================================================*/
/* Table : ASSOC_ENSEIGNER                                            */
/*==============================================================*/
CREATE TABLE ASSOC_ENSEIGNER (
  ASSOC_ENSEIGNER_ID                       SERIAL NOT NULL,
  ASSOC_ENSEIGNER_FK_PERSONNE_ID           INT    NOT NULL,
  ASSOC_ENSEIGNER_FK_CLASSROOM_ID          INT    NOT NULL,
  ASSOC_ENSEIGNER_FK_MATIERE_ID            INT    NOT NULL,
  ASSOC_ENSEIGNER_FK_PROMO_ENSEIGNEMENT_ID INT    NOT NULL,
  CONSTRAINT PK_ENSEIGNER PRIMARY KEY (ASSOC_ENSEIGNER_FK_PERSONNE_ID, ASSOC_ENSEIGNER_FK_CLASSROOM_ID, ASSOC_ENSEIGNER_FK_MATIERE_ID, ASSOC_ENSEIGNER_FK_PROMO_ENSEIGNEMENT_ID)
);

ALTER TABLE ASSOC_ENSEIGNER
ADD CONSTRAINT FK_ENSEIGNE_ENSEIGNE_MATIERE FOREIGN KEY (ASSOC_ENSEIGNER_FK_MATIERE_ID)
REFERENCES MATIERE (MATIERE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ASSOC_ENSEIGNER
ADD CONSTRAINT FK_ENSEIGNE_ENSEIGNE2_EMPLOYE FOREIGN KEY (ASSOC_ENSEIGNER_FK_PERSONNE_ID)
REFERENCES EMPLOYE (PERSONNE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ASSOC_ENSEIGNER
ADD CONSTRAINT FK_ENSEIGNE_ENSEIGNE3_CLASSROOM FOREIGN KEY (ASSOC_ENSEIGNER_FK_CLASSROOM_ID)
REFERENCES CLASSROOM (CLASSROOM_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ASSOC_ENSEIGNER
ADD CONSTRAINT FK_ENSEIGNE_ENSEIGNE4_CLASSROOM FOREIGN KEY (ASSOC_ENSEIGNER_FK_PROMO_ENSEIGNEMENT_ID)
REFERENCES PROMO (PROMO_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

/*==============================================================*/
/* Table : ASSOC_ETUDIER                                              */
/*==============================================================*/
CREATE TABLE ASSOC_ETUDIER (
  ASSOC_ETUDIER_ID                   SERIAL NOT NULL,
  ASSOC_ETUDIER_FK_PERSONNE_ID       INT    NOT NULL,
  ASSOC_ETUDIER_FK_CLASSROOM_ID      INT    NOT NULL,
  ASSOC_ETUDIER_FK_PROMO_ETUDIANT_ID INT    NOT NULL,
  CONSTRAINT PK_ETUDIER PRIMARY KEY (ASSOC_ETUDIER_FK_PERSONNE_ID, ASSOC_ETUDIER_FK_CLASSROOM_ID, ASSOC_ETUDIER_FK_PROMO_ETUDIANT_ID)
);

ALTER TABLE ASSOC_ETUDIER
ADD CONSTRAINT FK_ETUDIER_ETUDIER_CLASSROOM FOREIGN KEY (ASSOC_ETUDIER_FK_CLASSROOM_ID)
REFERENCES CLASSROOM (CLASSROOM_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ASSOC_ETUDIER
ADD CONSTRAINT FK_ETUDIER_ETUDIER2_ELEVE FOREIGN KEY (ASSOC_ETUDIER_FK_PERSONNE_ID)
REFERENCES ELEVE (PERSONNE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ASSOC_ETUDIER
ADD CONSTRAINT FK_ETUDIER_ETUDIER3_ELEVE FOREIGN KEY (ASSOC_ETUDIER_FK_PROMO_ETUDIANT_ID)
REFERENCES PROMO (PROMO_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

/*==============================================================*/
/* Table : ASSOC_EVALUER                                              */
/*==============================================================*/
CREATE TABLE ASSOC_EVALUER (
  ASSOC_EVALUER_ID                 SERIAL NOT NULL,
  ASSOC_EVALUER_FK_PERSONNE_EMP_ID INT    NOT NULL,
  ASSOC_EVALUER_FK_PERSONNE_ELE_ID INT    NOT NULL,
  ASSOC_EVALUER_FK_COM_CAP_ID      INT    NOT NULL,
  ASSOC_EVALUER_FK_NOTE_EMP_ID     INT    NULL,
  ASSOC_EVALUER_FK_NOTE_ELE_ID     INT    NOT NULL,
  ASSOC_EVALUER_DATE_EVALUATION    DATE   NOT NULL,
  CONSTRAINT PK_EVALUER PRIMARY KEY (ASSOC_EVALUER_ID)
);

ALTER TABLE ASSOC_EVALUER
ADD CONSTRAINT FK_EVALUER_EVALUER_COM_CAP FOREIGN KEY (ASSOC_EVALUER_FK_COM_CAP_ID)
REFERENCES COM_CAP (COM_CAP_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ASSOC_EVALUER
ADD CONSTRAINT FK_EVALUER_EVALUER2_ELEVE FOREIGN KEY (ASSOC_EVALUER_FK_PERSONNE_ELE_ID)
REFERENCES ELEVE (PERSONNE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ASSOC_EVALUER
ADD CONSTRAINT FK_EVALUER_EVALUER3_EMPLOYE FOREIGN KEY (ASSOC_EVALUER_FK_PERSONNE_EMP_ID)
REFERENCES EMPLOYE (PERSONNE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ASSOC_EVALUER
ADD CONSTRAINT FK_EVALUER_EVALUER4_NOTE FOREIGN KEY (ASSOC_EVALUER_FK_NOTE_EMP_ID)
REFERENCES NOTE (NOTE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ASSOC_EVALUER
ADD CONSTRAINT FK_EVALUER_EVALUER5_NOTE FOREIGN KEY (ASSOC_EVALUER_FK_NOTE_ELE_ID)
REFERENCES NOTE (NOTE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

/*==============================================================*/
/* Table : PARAMETRE                                            */
/*==============================================================*/
CREATE TABLE PARAMETRE (
  PARAMETRE_ID      SERIAL                 NOT NULL,
  PARAMETRE_LIBELLE CHARACTER VARYING(50)  NOT NULL,
  PARAMETRE_VALEUR  CHARACTER VARYING(255) NOT NULL,
  CONSTRAINT PK_PARAMETRE PRIMARY KEY (PARAMETRE_ID)
);

/*==============================================================*/
/* Table : STATISTIQUE                                          */
/*==============================================================*/
CREATE TABLE STATISTIQUE (
  STATISTIQUE_ID        SERIAL                 NOT NULL,
  STATISTIQUE_LIBELLE   CHARACTER VARYING(150) NOT NULL,
  STATISTIQUE_VALEUR    CHARACTER VARYING(150) NOT NULL,
  STATISTIQUE_DATE_STAT TIMESTAMP              NOT NULL,
  CONSTRAINT PK_STATISTIQUE PRIMARY KEY (STATISTIQUE_ID)
);