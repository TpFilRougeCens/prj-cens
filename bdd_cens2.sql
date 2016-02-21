-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.2-beta
-- PostgreSQL version: 9.5
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: bdd_cens | type: DATABASE --
-- -- DROP DATABASE IF EXISTS bdd_cens;
-- CREATE DATABASE bdd_cens
-- 	ENCODING = 'UTF8'
-- 	LC_COLLATE = 'French_France.UTF8'
-- 	LC_CTYPE = 'French_France.UTF8'
-- 	TABLESPACE = pg_default
-- 	OWNER = postgres
-- ;
-- -- ddl-end --
-- 


DROP TABLE IF EXISTS public.bilan CASCADE;
DROP TABLE IF EXISTS public.classe CASCADE;
DROP TABLE IF EXISTS public.evaluation CASCADE;
DROP TABLE IF EXISTS public.filiere CASCADE;
DROP TABLE IF EXISTS public.droit CASCADE;
DROP TABLE IF EXISTS public.ligne_evaluation CASCADE;
DROP TABLE IF EXISTS public.matiere CASCADE;
DROP TABLE IF EXISTS public.niveau CASCADE;
DROP TABLE IF EXISTS public.personne CASCADE;
DROP TABLE IF EXISTS public.capacite_competence CASCADE;
DROP TABLE IF EXISTS public.ligne_message CASCADE;
DROP TABLE IF EXISTS public.ligne_matiere_capacite CASCADE;
DROP TABLE IF EXISTS public.bloc CASCADE;
DROP TABLE IF EXISTS public.type CASCADE;
DROP TABLE IF EXISTS public.note CASCADE;
DROP TABLE IF EXISTS public.voie CASCADE;
DROP TABLE IF EXISTS public.ligne_employe_classe CASCADE;
DROP TABLE IF EXISTS public.message CASCADE;




-- object: public.droit | type: TABLE --
CREATE TABLE public.droit(
	iddroit SERIAL PRIMARY KEY,
	libelle character varying(32)
);
-- ddl-end --
ALTER TABLE public.droit OWNER TO postgres;
-- ddl-end --

CREATE TABLE public.voie(
	idvoie SERIAL PRIMARY KEY,
	abvr character varying(8),
	libelle character varying(128)
);
-- ddl-end --
ALTER TABLE public.voie OWNER TO postgres;
-- ddl-end --
-- object: public.droit | type: TABLE --
CREATE TABLE public.note(
	idnote SERIAL PRIMARY KEY,
	abvr character varying(8),
	libelle character varying(32)
);
-- ddl-end --
ALTER TABLE public.note OWNER TO postgres;
-- ddl-end --

-- object: public.message | type: TABLE --
CREATE TABLE public.message(
	idmessage SERIAL PRIMARY KEY,
	libelle character varying(32),
	contenu character varying(255),
	date timestamp
);
-- ddl-end --
ALTER TABLE public.message OWNER TO postgres;
-- ddl-end --

-- object: public.niveau | type: TABLE --
CREATE TABLE public.niveau(
	idniveau SERIAL PRIMARY KEY,
	abvr character varying(8),
	libelle character varying(32)
);
-- ddl-end --
ALTER TABLE public.niveau OWNER TO postgres;
-- ddl-end --

-- object: public.bloc | type: TABLE --
CREATE TABLE public.bloc(
	idbloc SERIAL PRIMARY KEY,
	libelle character varying(128)

);
-- ddl-end --
ALTER TABLE public.bloc OWNER TO postgres;
-- ddl-end --


-- object: public.capacite_competence | type: TABLE --
CREATE TABLE public.capacite_competence(
	idcapacite_competence SERIAL PRIMARY KEY,
	fk_capacite_competence integer REFERENCES capacite_competence(idcapacite_competence),
	libelle character varying(128)

);
-- ddl-end --
ALTER TABLE public.capacite_competence OWNER TO postgres;
-- ddl-end --
-- object: public.matiere | type: TABLE --
CREATE TABLE public.matiere(
	idmatiere SERIAL PRIMARY KEY,
	fk_bloc integer NOT NULL REFERENCES bloc(idbloc),
	libelle character varying(128)
);
-- ddl-end --
ALTER TABLE public.matiere OWNER TO postgres;
-- ddl-end --
-- object: public.matiere | type: TABLE --
CREATE TABLE public.type(
	idtype SERIAL PRIMARY KEY,
	libelle character varying(128)
);
-- ddl-end --
ALTER TABLE public.type OWNER TO postgres;
-- ddl-end --
-- object: public.personne | type: TABLE --
CREATE TABLE public.personne(
	idpersonne SERIAL PRIMARY KEY,
	fk_droit integer NOT NULL REFERENCES droit(iddroit),
	fk_type integer REFERENCES type(idtype),
	fk_personne integer REFERENCES personne(idpersonne),
	nom character varying(128),
	prenom character varying(128),
	mail character varying(128),
	mdp character varying(8),
	date_naissance date

);
-- ddl-end --
ALTER TABLE public.personne OWNER TO postgres;
-- ddl-end --

-- object: public.ligne_evaluation | type: TABLE --
CREATE TABLE public.ligne_evaluation(
	idligne_evaluation SERIAL PRIMARY KEY,
	fk_personne integer NOT NULL REFERENCES personne(idpersonne),
	fk_note_evaluation integer REFERENCES note(idnote),
	fk_note_autoevaluation integer REFERENCES note(idnote),
	commentaire character varying(255),
	date timestamp
);
-- ddl-end --
ALTER TABLE public.ligne_evaluation OWNER TO postgres;
-- ddl-end --

-- object: public.filiere | type: TABLE --
CREATE TABLE public.filiere(
	idfiliere SERIAL PRIMARY KEY,
	fk_voie integer NOT NULL REFERENCES voie(idvoie),
	fk_capacite_competence integer NOT NULL REFERENCES capacite_competence(idcapacite_competence),
	libelle character varying(128)
);
-- ddl-end --
ALTER TABLE public.filiere OWNER TO postgres;
-- ddl-end --





-- object: public.bilan | type: TABLE --
CREATE TABLE public.bilan(
	idbilan SERIAL PRIMARY KEY,
	fk_ligne_evaluation integer NOT NULL REFERENCES ligne_evaluation(idligne_evaluation),
	libelle character varying(64),
	commentaire character varying(255),
	trimestre1 character varying(255),
	trimestre2 character varying(255),
	trimestre3 character varying(255)
);
-- ddl-end --
ALTER TABLE public.bilan OWNER TO postgres;
-- ddl-end --

-- object: public.classe | type: TABLE --
CREATE TABLE public.classe(
	idclasse SERIAL PRIMARY KEY,
	fk_filiere integer NOT NULL REFERENCES filiere(idfiliere),
	fk_niveau integer NOT NULL REFERENCES niveau(idniveau),
	fk_personne integer REFERENCES personne(idpersonne),
	libelle character varying(32)
);
-- ddl-end --
ALTER TABLE public.classe OWNER TO postgres;
-- ddl-end --

-- object: public.evaluation | type: TABLE --
CREATE TABLE public.evaluation(
	idevaluation SERIAL PRIMARY KEY,
	fk_capacite_competence integer NOT NULL REFERENCES capacite_competence(idcapacite_competence), --ici
	fk_ligne_evaluation integer NOT NULL REFERENCES ligne_evaluation(idligne_evaluation),
	fk_personne integer NOT NULL REFERENCES personne(idpersonne),
	date_evaluation timestamp
);
-- ddl-end --
ALTER TABLE public.evaluation OWNER TO postgres;
-- ddl-end --


-- object: public.ligne_message | type: TABLE --
CREATE TABLE public.ligne_message(
	fk_message integer NOT NULL REFERENCES message(idmessage),
	fk_personne_emetteur integer NOT NULL REFERENCES personne(idpersonne),
	fk_personne_destinataire integer NOT NULL REFERENCES personne(idpersonne)
);
-- ddl-end --
ALTER TABLE public.ligne_message OWNER TO postgres;
-- ddl-end --

-- object: public.ligne_matiere_capacite | type: TABLE --
CREATE TABLE public.ligne_matiere_capacite(
	fk_capacite_competence integer NOT NULL REFERENCES capacite_competence(idcapacite_competence),
	fk_matiere integer NOT NULL REFERENCES matiere(idmatiere),
	type integer
);
-- ddl-end --
ALTER TABLE public.ligne_matiere_capacite OWNER TO postgres;
-- ddl-end --

-- object: public.ligne_employe_classe | type: TABLE --
CREATE TABLE public.ligne_employe_classe(
	fk_personne integer NOT NULL REFERENCES personne(idpersonne),
	fk_classe integer NOT NULL REFERENCES classe(idclasse),
	annee date
);
-- ddl-end --
ALTER TABLE public.ligne_employe_classe OWNER TO postgres;
-- ddl-end --


