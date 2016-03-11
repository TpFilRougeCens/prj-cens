/*==============================================================*/
/* Nom de SGBD :  PostgreSQL 8                                  */
/* Date de création :  23/02/2016 21:17:19                      */
/*==============================================================*/

drop table IF EXISTS VOIE CASCADE;
drop table IF EXISTS FILIERE CASCADE;
drop table IF EXISTS NIVEAU CASCADE;
drop table IF EXISTS BLOC CASCADE;
drop table IF EXISTS MATIERE CASCADE;
drop table IF EXISTS COM_CAP CASCADE;
drop table IF EXISTS ASSOC_COM_CAP CASCADE;
drop table IF EXISTS CLASSROOM CASCADE;
drop table IF EXISTS PERSONNE CASCADE;
drop table IF EXISTS ELEVE CASCADE;
drop table IF EXISTS EMPLOYE CASCADE;
drop table IF EXISTS GROUPE CASCADE;
drop table IF EXISTS DROIT CASCADE;
drop table IF EXISTS BILAN CASCADE;
drop table IF EXISTS NOTE CASCADE;

drop table IF EXISTS ASSOC_FILIERE_BLOC CASCADE;
drop table IF EXISTS ASSOC_MATIERE_COM_CAP CASCADE;
drop table IF EXISTS ASSOC_EMPLOYE_GROUPE CASCADE;

drop table IF EXISTS ASSOC_ENSEIGNER CASCADE;
drop table IF EXISTS ASSOC_ETUDIER CASCADE;
drop table IF EXISTS ASSOC_EVALUER CASCADE;

drop table IF EXISTS PARAMETRE CASCADE;
drop table IF EXISTS STATISTIQUE CASCADE;
drop table IF EXISTS PROMO CASCADE;

/*==============================================================*/
/* Table : PROMO                                                 */
/*==============================================================*/
create table PROMO (
   PROMO_ID              SERIAL               not null,
   PROMO_LIBELLE         CHARACTER VARYING(9)         not null,
   constraint PK_PROMO primary key (PROMO_ID)
);


/*==============================================================*/
/* Table : VOIE                                                 */
/*==============================================================*/
create table VOIE (
   VOIE_ID              SERIAL               not null,
   VOIE_LIBELLE         CHARACTER VARYING(150)         not null,
   constraint PK_VOIE primary key (VOIE_ID)
);

/*==============================================================*/
/* Table : FILIERE                                              */
/*==============================================================*/
create table FILIERE (
   FILIERE_ID           SERIAL               not null,
   FILIERE_FK_VOIE_ID           INT                 not null,
   FILIERE_LIBELLE      CHARACTER VARYING(150)         not null,
   constraint PK_FILIERE primary key (FILIERE_ID)
);
alter table FILIERE
   add constraint FK_FILIERE_CONTENIR_VOIE foreign key (FILIERE_FK_VOIE_ID)
      references VOIE (VOIE_ID)
      on delete restrict on update restrict;

/*==============================================================*/
/* Table : NIVEAU                                               */
/*==============================================================*/
create table NIVEAU (
   NIVEAU_ID            SERIAL               not null,
   NIVEAU_LIBELLE       CHARACTER VARYING(150)         not null,
   constraint PK_NIVEAU primary key (NIVEAU_ID)
);

/*==============================================================*/
/* Table : BLOC                                                 */
/*==============================================================*/
create table BLOC (
   BLOC_ID              SERIAL               not null,
   BLOC_LIBELLE         CHARACTER VARYING(150)         not null,
   constraint PK_BLOC primary key (BLOC_ID)
);

/*==============================================================*/
/* Table : MATIERE                                              */
/*==============================================================*/
create table MATIERE (
   MATIERE_ID           SERIAL               not null,
   MATIERE_FK_BLOC_ID           INT                 not null,
   MATIERE_LIBELLE      CHARACTER VARYING(150)         not null,
   constraint PK_MATIERE primary key (MATIERE_ID)
);
alter table MATIERE
   add constraint FK_MATIERE_COMPORTER_BLOC foreign key (MATIERE_FK_BLOC_ID)
      references BLOC (BLOC_ID)
      on delete restrict on update restrict;

/*==============================================================*/
/* Table : COM_CAP                                              */
/*==============================================================*/
create table COM_CAP (
   COM_CAP_ID           SERIAL               not null,
   COM_CAP_LIBELLE      CHARACTER VARYING(350)         not null,
   constraint PK_COM_CAP primary key (COM_CAP_ID)
);

/*==============================================================*/
/* Table : ASSOC_COM_CAP                                        */
/*==============================================================*/
create table ASSOC_COM_CAP (
	ASSOC_COM_CAP_ID	SERIAL not null,
   ASSOC_COM_CAP_FK_COM_ID               INT                 not null,
   ASSOC_COM_CAP_FK_CAP_ID               INT                 not null,
   constraint PK_ASSOC_COM_CAP primary key (ASSOC_COM_CAP_FK_COM_ID,ASSOC_COM_CAP_FK_CAP_ID)
);

alter table ASSOC_COM_CAP
   add constraint FK_ASSOC_CO_A_POUR_CO_COM_CAP foreign key (ASSOC_COM_CAP_FK_CAP_ID)
      references COM_CAP (COM_CAP_ID)
      on delete restrict on update restrict;

alter table ASSOC_COM_CAP
   add constraint FK_ASSOC_CO_EST_UNE_C_COM_CAP foreign key (ASSOC_COM_CAP_FK_COM_ID)
      references COM_CAP (COM_CAP_ID)
      on delete restrict on update restrict;

/*==============================================================*/
/* Table : PERSONNE                                             */
/*==============================================================*/
create table PERSONNE (
   PERSONNE_ID          SERIAL               not null,
   PERSONNE_NOM                  CHARACTER VARYING(150)         not null,
   PERSONNE_PRENOM               CHARACTER VARYING(150)         not null,
   PERSONNE_DATE_NAISSANCE       DATE                 ,
   PERSONNE_ADRESSE              CHARACTER VARYING(300)         ,
   PERSONNE_CP                   CHARACTER VARYING(5)          ,
   PERSONNE_VILLE                CHARACTER VARYING(150)         ,
   constraint PK_PERSONNE primary key (PERSONNE_ID)
);

/*==============================================================*/
/* Table : ELEVE                                                */
/*==============================================================*/
create table ELEVE (
   ELEVE_EMAIL_PARENT         CHARACTER VARYING(150)         ,
   constraint PK_ELEVE primary key (PERSONNE_ID)
)inherits(PERSONNE);

/*==============================================================*/
/* Table : EMPLOYE                                              */
/*==============================================================*/
create table EMPLOYE (
   constraint PK_EMPLOYE primary key (PERSONNE_ID)
)inherits(PERSONNE);

/*==============================================================*/
/* Table : GROUPE                                               */
/*==============================================================*/
create table GROUPE (
   GROUPE_ID            SERIAL               not null,
   GROUPE_LIBELLE       CHARACTER VARYING(100)         not null,
   constraint PK_GROUPE primary key (GROUPE_ID)
);

/*==============================================================*/
/* Table : DROIT                                                */
/*==============================================================*/
create table DROIT (
   DROIT_ID             SERIAL               not null,
   DROIT_FK_GROUPE_ID         INT                 not null,
   DROIT_UNITE               CHARACTER VARYING(250)         not null,
   DROIT_DROIT                CHARACTER VARYING(3)           not null,
   constraint PK_DROIT primary key (DROIT_ID)
);

alter table DROIT
   add constraint FK_DROIT_DONNER_GROUPE foreign key (DROIT_FK_GROUPE_ID)
      references GROUPE (GROUPE_ID)
      on delete restrict on update restrict;


/*==============================================================*/
/* Table : CLASSROOM                                               */
/*==============================================================*/
create table CLASSROOM (
   CLASSROOM_ID            SERIAL               not null,
   CLASSROOM_FK_FILIERE_ID        INT                 not null,
   CLASSROOM_FK_NIVEAU_ID         INT                 not null,
   CLASSROOM_FK_PERSONNE_MANAGER_ID        INT                 not null,
   CLASSROOM_LIBELLE       CHARACTER VARYING(100)         not null,
   constraint PK_CLASSROOM primary key (CLASSROOM_ID)
);

alter table CLASSROOM
   add constraint FK_CLASSROOM_AFFILIER_NIVEAU foreign key (CLASSROOM_FK_NIVEAU_ID)
      references NIVEAU (NIVEAU_ID)
      on delete restrict on update restrict;

alter table CLASSROOM
   add constraint FK_CLASSROOM_APPARTENI_FILIERE foreign key (CLASSROOM_FK_FILIERE_ID)
      references FILIERE (FILIERE_ID)
      on delete restrict on update restrict;

alter table CLASSROOM
   add constraint FK_CLASSROOM_A_MANAGER foreign key (CLASSROOM_FK_PERSONNE_MANAGER_ID)
      references EMPLOYE (PERSONNE_ID)
      on delete restrict on update restrict;


/*==============================================================*/
/* Table : BILAN                                                */
/*==============================================================*/
create table BILAN (
   BILAN_ID             SERIAL               not null,
   BILAN_FK_PERSONNE_ID       INT                 not null,
   BILAN_LIBELLE        CHARACTER VARYING(150)         not null,
   BILAN_COMMENTAIRE        CHARACTER VARYING(255)         not null,
   BILAN_DATE_DEBUT           DATE                 not null,
   BILAN_DATE_FIN             DATE                 not null,
   constraint PK_BILAN primary key (BILAN_ID)
);

alter table BILAN
   add constraint FK_BILAN_RECEVOIR_ELEVE foreign key (BILAN_FK_PERSONNE_ID)
      references ELEVE (PERSONNE_ID)
      on delete restrict on update restrict;

/*==============================================================*/
/* Table : NOTE                                                 */
/*==============================================================*/
create table NOTE (
   NOTE_ID              SERIAL               not null,
   NOTE_ABVR         		CHARACTER VARYING(3)         not null,
   NOTE_LIBELLE         CHARACTER VARYING(100)         not null,
   NOTE_VALEUR 		 INT                 not null,
   NOTE_COULEUR              CHARACTER VARYING(7)           not null,
   constraint PK_NOTE primary key (NOTE_ID)
);


/*==============================================================*/
/* Table : FILIERE_BLOC                                         */
/*==============================================================*/
create table ASSOC_FILIERE_BLOC (
	ASSOC_FILIERE_BLOC_ID SERIAL not null,
   ASSOC_FILIERE_BLOC_FK_FILIERE_ID           INT                 not null,
   ASSOC_FILIERE_BLOC_FK_BLOC_ID              INT                 not null,
   constraint PK_FILIERE_BLOC primary key (ASSOC_FILIERE_BLOC_FK_FILIERE_ID, ASSOC_FILIERE_BLOC_FK_BLOC_ID)
);

alter table ASSOC_FILIERE_BLOC
   add constraint FK_FILIERE__LIER_BLOC foreign key (ASSOC_FILIERE_BLOC_FK_BLOC_ID)
      references BLOC (BLOC_ID)
      on delete restrict on update restrict;

alter table ASSOC_FILIERE_BLOC
   add constraint FK_FILIERE__LIER2_FILIERE foreign key (ASSOC_FILIERE_BLOC_FK_FILIERE_ID)
      references FILIERE (FILIERE_ID)
      on delete restrict on update restrict;

/*==============================================================*/
/* Table : MATIERE_COM_CAP                                      */
/*==============================================================*/
create table ASSOC_MATIERE_COM_CAP (
	ASSOC_MATIERE_COM_CAP_ID SERIAL not null,
   ASSOC_MATIERE_COM_CAP_FK_MATIERE_ID           INT                 not null,
   ASSOC_MATIERE_COM_CAP_FK_COMPETENCE_ID          INT                 not null,
   constraint PK_MATIERE_COM_CAP primary key (ASSOC_MATIERE_COM_CAP_FK_MATIERE_ID, ASSOC_MATIERE_COM_CAP_FK_COMPETENCE_ID)
);

alter table ASSOC_MATIERE_COM_CAP
   add constraint FK_MATIERE__POSSEDER_COM_CAP foreign key (ASSOC_MATIERE_COM_CAP_FK_COMPETENCE_ID)
      references COM_CAP (COM_CAP_ID)
      on delete restrict on update restrict;

alter table ASSOC_MATIERE_COM_CAP
   add constraint FK_MATIERE__POSSEDER2_MATIERE foreign key (ASSOC_MATIERE_COM_CAP_FK_MATIERE_ID)
      references MATIERE (MATIERE_ID)
      on delete restrict on update restrict;

/*==============================================================*/
/* Table : ASSOC_EMPLOYE_GROUPE                                       */
/*==============================================================*/
create table ASSOC_EMPLOYE_GROUPE (
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

/*==============================================================*/
/* Table : ASSOC_ENSEIGNER                                            */
/*==============================================================*/
create table ASSOC_ENSEIGNER (
	ASSOC_ENSEIGNER_ID SERIAL not null,
   ASSOC_ENSEIGNER_FK_PERSONNE_ID          INT                 not null,
   ASSOC_ENSEIGNER_FK_CLASSROOM_ID            INT                 not null,
   ASSOC_ENSEIGNER_FK_MATIERE_ID           INT                 not null,
   ASSOC_ENSEIGNER_FK_PROMO_ENSEIGNEMENT_ID   INT              not null,
   constraint PK_ENSEIGNER primary key (ASSOC_ENSEIGNER_FK_PERSONNE_ID, ASSOC_ENSEIGNER_FK_CLASSROOM_ID, ASSOC_ENSEIGNER_FK_MATIERE_ID,ASSOC_ENSEIGNER_FK_PROMO_ENSEIGNEMENT_ID)
);

alter table ASSOC_ENSEIGNER
   add constraint FK_ENSEIGNE_ENSEIGNE_MATIERE foreign key (ASSOC_ENSEIGNER_FK_MATIERE_ID)
      references MATIERE (MATIERE_ID)
      on delete restrict on update restrict;

alter table ASSOC_ENSEIGNER
   add constraint FK_ENSEIGNE_ENSEIGNE2_EMPLOYE foreign key (ASSOC_ENSEIGNER_FK_PERSONNE_ID)
      references EMPLOYE (PERSONNE_ID)
      on delete restrict on update restrict;

alter table ASSOC_ENSEIGNER
   add constraint FK_ENSEIGNE_ENSEIGNE3_CLASSROOM foreign key (ASSOC_ENSEIGNER_FK_CLASSROOM_ID)
      references CLASSROOM (CLASSROOM_ID)
      on delete restrict on update restrict;

alter table ASSOC_ENSEIGNER
   add constraint FK_ENSEIGNE_ENSEIGNE4_CLASSROOM foreign key (ASSOC_ENSEIGNER_FK_PROMO_ENSEIGNEMENT_ID)
      references PROMO (PROMO_ID)
      on delete restrict on update restrict;

/*==============================================================*/
/* Table : ASSOC_ETUDIER                                              */
/*==============================================================*/
create table ASSOC_ETUDIER (
	ASSOC_ETUDIER_ID SERIAL not null,
   ASSOC_ETUDIER_FK_PERSONNE_ID          INT                 not null,
   ASSOC_ETUDIER_FK_CLASSROOM_ID            INT                 not null,
   ASSOC_ETUDIER_FK_PROMO_ETUDIANT_ID          INT               not null,
   constraint PK_ETUDIER primary key (ASSOC_ETUDIER_FK_PERSONNE_ID, ASSOC_ETUDIER_FK_CLASSROOM_ID, ASSOC_ETUDIER_FK_PROMO_ETUDIANT_ID)
);

alter table ASSOC_ETUDIER
   add constraint FK_ETUDIER_ETUDIER_CLASSROOM foreign key (ASSOC_ETUDIER_FK_CLASSROOM_ID)
      references CLASSROOM (CLASSROOM_ID)
      on delete restrict on update restrict;

alter table ASSOC_ETUDIER
   add constraint FK_ETUDIER_ETUDIER2_ELEVE foreign key (ASSOC_ETUDIER_FK_PERSONNE_ID)
      references ELEVE (PERSONNE_ID)
      on delete restrict on update restrict;

	  alter table ASSOC_ETUDIER
   add constraint FK_ETUDIER_ETUDIER3_ELEVE foreign key (ASSOC_ETUDIER_FK_PROMO_ETUDIANT_ID)
      references PROMO (PROMO_ID)
      on delete restrict on update restrict;

/*==============================================================*/
/* Table : ASSOC_EVALUER                                              */
/*==============================================================*/
create table ASSOC_EVALUER (
   ASSOC_EVALUER_ID SERIAL not null,
   ASSOC_EVALUER_FK_PERSONNE_EMP_ID      INT                 not null,
   ASSOC_EVALUER_FK_PERSONNE_ELE_ID      INT                 not null,
   ASSOC_EVALUER_FK_COM_CAP_ID           INT                 not null,
   ASSOC_EVALUER_FK_NOTE_EMP_ID       INT                 null,
   ASSOC_EVALUER_FK_NOTE_ELE_ID          INT                 not null,
   ASSOC_EVALUER_DATE_EVALUATION      DATE                 not null,
   constraint PK_EVALUER primary key (ASSOC_EVALUER_ID)
);

alter table ASSOC_EVALUER
   add constraint FK_EVALUER_EVALUER_COM_CAP foreign key (ASSOC_EVALUER_FK_COM_CAP_ID)
      references COM_CAP (COM_CAP_ID)
      on delete restrict on update restrict;

alter table ASSOC_EVALUER
   add constraint FK_EVALUER_EVALUER2_ELEVE foreign key (ASSOC_EVALUER_FK_PERSONNE_ELE_ID)
      references ELEVE (PERSONNE_ID)
      on delete restrict on update restrict;

alter table ASSOC_EVALUER
   add constraint FK_EVALUER_EVALUER3_EMPLOYE foreign key (ASSOC_EVALUER_FK_PERSONNE_EMP_ID)
      references EMPLOYE (PERSONNE_ID)
      on delete restrict on update restrict;

alter table ASSOC_EVALUER
   add constraint FK_EVALUER_EVALUER4_NOTE foreign key (ASSOC_EVALUER_FK_NOTE_EMP_ID)
      references NOTE (NOTE_ID)
      on delete restrict on update restrict;

alter table ASSOC_EVALUER
   add constraint FK_EVALUER_EVALUER5_NOTE foreign key (ASSOC_EVALUER_FK_NOTE_ELE_ID)
      references NOTE (NOTE_ID)
      on delete restrict on update restrict;

/*==============================================================*/
/* Table : PARAMETRE                                            */
/*==============================================================*/
create table PARAMETRE (
   PARAMETRE_ID            SERIAL               not null,
   PARAMETRE_LIBELLE       CHARACTER VARYING(50)         not null,
   PARAMETRE_VALEUR        CHARACTER VARYING(255)         not null,
   constraint PK_PARAMETRE primary key (PARAMETRE_ID)
);

/*==============================================================*/
/* Table : STATISTIQUE                                          */
/*==============================================================*/
create table STATISTIQUE (
   STATISTIQUE_STAT_ID              SERIAL               not null,
   STATISTIQUE_LIBELLE         CHARACTER VARYING(150)         not null,
   STATISTIQUE_VALEUR          CHARACTER VARYING(150)         not null,
   STATISTIQUE_DATE_STAT            TIMESTAMP                 not null,
   constraint PK_STATISTIQUE primary key (STATISTIQUE_STAT_ID)
);