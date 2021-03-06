-- PROMO
INSERT INTO "public"."promo" ("promo_libelle") VALUES ('2001-2004');
INSERT INTO "public"."promo" ("promo_libelle") VALUES ('2004-2007');
INSERT INTO "public"."promo" ("promo_libelle") VALUES ('2007-2010');
INSERT INTO "public"."promo" ("promo_libelle") VALUES ('2010-2013');
INSERT INTO "public"."promo" ("promo_libelle") VALUES ('2013-2016');
INSERT INTO "public"."promo" ("promo_libelle") VALUES ('2016-2019');

-- VOIES
INSERT INTO "public"."voie" ("voie_libelle") VALUES ('Générale');
INSERT INTO "public"."voie" ("voie_libelle") VALUES ('Technologie');
INSERT INTO "public"."voie" ("voie_libelle") VALUES ('Professionnelle');

-- FILIERES
INSERT INTO "public".filiere (filiere_fk_voie_id, filiere_libelle) VALUES ('1', 'Scientifique');
INSERT INTO "public".filiere (filiere_fk_voie_id, filiere_libelle) VALUES ('1', 'Littéraire');
INSERT INTO "public".filiere (filiere_fk_voie_id, filiere_libelle) VALUES ('2', 'STI génie des matériaux');
INSERT INTO "public".filiere (filiere_fk_voie_id, filiere_libelle)
VALUES ('2', 'STI électronique et Sciences Humaines');
INSERT INTO "public".filiere (filiere_fk_voie_id, filiere_libelle) VALUES ('3', 'Bois et ameublement');
INSERT INTO "public".filiere (filiere_fk_voie_id, filiere_libelle) VALUES ('3', 'Arts de la table');

-- NIVEAUX
INSERT INTO "public"."niveau" ("niveau_libelle") VALUES ('2sd');
INSERT INTO "public"."niveau" ("niveau_libelle") VALUES ('1er');
INSERT INTO "public"."niveau" ("niveau_libelle") VALUES ('Term');

-- BLOCS
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 11');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 12');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 13');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 14');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 21');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 22');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 23');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 24');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 31');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 32');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 33');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 34');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 41');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 42');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 43');
INSERT INTO "public"."bloc" ("bloc_libelle") VALUES ('Bloc 44');

-- MATIERES
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (1, '11Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (1, '11Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (1, '11Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (1, '11Sciences et Vie de la Terre');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (2, '12Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (2, '12Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (2, '12Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (2, '12Sciences et Vie de la Terre');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (3, '13Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (3, '13Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (3, '13Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (3, '13Sciences et Vie de la Terre');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (4, '14Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (4, '14Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (4, '14Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (4, '14Sciences et Vie de la Terre');

INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (5, '21Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (5, '21Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (5, '21Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (5, '21Sciences et Vie de la Terre');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (6, '22Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (6, '22Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (6, '22Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (6, '22Sciences et Vie de la Terre');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (7, '23Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (7, '23Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (7, '23Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (7, '23Sciences et Vie de la Terre');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (8, '24Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (8, '24Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (8, '24Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (8, '24Sciences et Vie de la Terre');

INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (9, '31Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (9, '31Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (9, '31Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (9, '31Sciences et Vie de la Terre');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (10, '32Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (10, '32Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (10, '32Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (10, '32Sciences et Vie de la Terre');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (11, '33Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (11, '33Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (11, '33Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (11, '33Sciences et Vie de la Terre');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (12, '34Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (12, '34Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (12, '34Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (12, '34Sciences et Vie de la Terre');

INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (13, '41Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (13, '41Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (13, '41Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (13, '41Sciences et Vie de la Terre');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (14, '42Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (14, '42Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (14, '42Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (14, '42Sciences et Vie de la Terre');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (15, '43Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (15, '43Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (15, '43Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (15, '43Sciences et Vie de la Terre');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (16, '44Mathématiques');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (16, '44Sciences');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (16, '44Français');
INSERT INTO "public"."matiere" ("matiere_fk_bloc_id", "matiere_libelle") VALUES (16, '44Sciences et Vie de la Terre');

-- COMPETENCES
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP110Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP110Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP110Repérer la situation étudiée dans le temps et dans l''espace');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP120Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP120Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP120Repérer la situation étudiée dans le temps et dans l''espace');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP130Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP130Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP130Repérer la situation étudiée dans le temps et dans l''espace');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP140Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP140Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP140Repérer la situation étudiée dans le temps et dans l''espace');

INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP210Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP210Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP210Repérer la situation étudiée dans le temps et dans l''espace');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP220Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP220Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP220Repérer la situation étudiée dans le temps et dans l''espace');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP230Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP230Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP230Repérer la situation étudiée dans le temps et dans l''espace');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP240Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP240Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP240Repérer la situation étudiée dans le temps et dans l''espace');

INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP310Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP310Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP310Repérer la situation étudiée dans le temps et dans l''espace');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP320Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP320Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP320Repérer la situation étudiée dans le temps et dans l''espace');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP330Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP330Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP330Repérer la situation étudiée dans le temps et dans l''espace');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP340Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP340Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP340Repérer la situation étudiée dans le temps et dans l''espace');

INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP410Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP410Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP410Repérer la situation étudiée dans le temps et dans l''espace');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP420Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP420Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP420Repérer la situation étudiée dans le temps et dans l''espace');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP430Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP430Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP430Repérer la situation étudiée dans le temps et dans l''espace');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP440Exploiter des documents pour analyser une situation Historique ou Géographique');
INSERT INTO "public"."com_cap" ("com_cap_libelle") VALUES ('COMP440Maîtriser des outils et des méthodes.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('COMP440Repérer la situation étudiée dans le temps et dans l''espace');

-- CAPACITES
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPDistinguer la date du document, et des faits rapportés.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPCompléter une carte simple, un croquis, un schéma fléché, relatifs à la situation étudiée.');
INSERT INTO "public"."com_cap" ("com_cap_libelle")
VALUES ('CAPRéaliser une carte, un croquis, un schéma fléché relatifs à la situation');

-- TABLE ASSOC COMPETENCE ET CAPACITE
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (1, 49);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (1, 50);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (1, 51);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (1, 52);

INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (2, 50);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (3, 51);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (4, 52);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (5, 53);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (6, 54);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (7, 55);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (8, 56);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (9, 57);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (10, 58);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (11, 59);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (12, 60);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (13, 61);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (14, 62);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (15, 63);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (16, 64);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (17, 65);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (18, 66);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (19, 67);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (20, 68);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (21, 69);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (22, 70);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (23, 71);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (24, 72);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (25, 73);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (26, 74);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (27, 75);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (28, 76);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (29, 77);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (30, 78);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (31, 79);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (32, 80);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (33, 81);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (34, 82);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (35, 83);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (36, 84);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (37, 85);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (38, 86);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (39, 87);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (40, 88);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (41, 89);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (42, 90);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (43, 91);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (44, 92);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (45, 93);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (46, 94);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (47, 95);
INSERT INTO "public"."assoc_com_cap" ("assoc_com_cap_fk_com_id", "assoc_com_cap_fk_cap_id") VALUES (48, 96);

-- Pas fini???

--GROUPE
INSERT INTO "public"."groupe" ("groupe_libelle", "groupe_niveauacces") VALUES ('Enseignant', 3);
INSERT INTO "public"."groupe" ("groupe_libelle", "groupe_niveauacces") VALUES ('Admin', 6);
INSERT INTO "public"."groupe" ("groupe_libelle", "groupe_niveauacces") VALUES ('Manager', 4);
INSERT INTO "public"."groupe" ("groupe_libelle", "groupe_niveauacces") VALUES ('Coordinateur', 5);
INSERT INTO "public"."groupe" ("groupe_libelle", "groupe_niveauacces") VALUES ('Eleve', 2);

-- DROITS
INSERT INTO "public"."droit" (droit_unite, droit_lecture, droit_ecriture) VALUES ('/Index', 1, 2);
INSERT INTO "public"."droit" (droit_unite, droit_lecture, droit_ecriture) VALUES ('/Eleve', 2, 3);
INSERT INTO "public"."droit" (droit_unite, droit_lecture, droit_ecriture) VALUES ('/EnseignantPage', 3, 4);
INSERT INTO "public"."droit" (droit_unite, droit_lecture, droit_ecriture) VALUES ('/CoordinateurPage', 4, 5);
INSERT INTO "public"."droit" (droit_unite, droit_lecture, droit_ecriture) VALUES ('/quelquechose4', 2, 5);

-- PERSONNE
-- AUCUN INSERT

-- EMPLOYES ID de 1 à 6
INSERT INTO "public"."employe" ("personne_login", "personne_nom", "personne_prenom", "personne_date_naissance", "personne_adresse", "personne_cp", "personne_ville", personne_fk_groupe_id)
VALUES ('Ens1', 'nom1', 'prenom1', NULL, '1 rue dupont', NULL, 'NANTES1', 1);
INSERT INTO "public"."employe" ("personne_login", "personne_nom", "personne_prenom", "personne_date_naissance", "personne_adresse", "personne_cp", "personne_ville", personne_fk_groupe_id)
VALUES ('Ens2', 'nom2', 'prenom1', NULL, '2 rue dupont', '20000', 'NANTES2', 1);
INSERT INTO "public"."employe" ("personne_password", "personne_login", "personne_nom", "personne_prenom", "personne_date_naissance", "personne_adresse", "personne_cp", "personne_ville", personne_fk_groupe_id)
VALUES ('toor', 'Directeur', 'nom3', 'prenom1', '30/01/2014', NULL, '30000', 'NANTES3', 2);
INSERT INTO "public"."employe" ("personne_password", "personne_login", "personne_nom", "personne_prenom", "personne_date_naissance", "personne_adresse", "personne_cp", "personne_ville", personne_fk_groupe_id)
VALUES ('toor', 'Manager1', 'nom4', 'prenom1', '31/01/2000', '4 rue dupont', NULL, 'NANTES4', 3);
INSERT INTO "public"."employe" ("personne_password", "personne_login", "personne_nom", "personne_prenom", "personne_date_naissance", "personne_adresse", "personne_cp", "personne_ville", personne_fk_groupe_id)
VALUES ('toor', 'Manager2', 'nom5', 'prenom1', '10/12/1970', '5 rue dupont', NULL, NULL, 3);
INSERT INTO "public"."employe" ("personne_password", "personne_login", "personne_nom", "personne_prenom", "personne_date_naissance", "personne_adresse", "personne_cp", "personne_ville", personne_fk_groupe_id)
VALUES ('toor', 'Pedagogie', 'nom6', 'prenom1', '10/12/1970', '5 rue dupont', NULL, NULL, 4);

-- ELEVES ID de 7 à 12
INSERT INTO "public"."eleve" ("personne_login", "personne_nom", "personne_prenom", "personne_date_naissance", "personne_adresse", "personne_cp", "personne_ville", personne_fk_groupe_id)
VALUES ('Eleve1', 'nom1', 'prenom1', NULL, '1 rue dupont', NULL, 'NANTES1', 5);
INSERT INTO "public"."eleve" ("personne_login", "personne_nom", "personne_prenom", "personne_date_naissance", "personne_adresse", "personne_cp", "personne_ville", personne_fk_groupe_id)
VALUES ('Eleve2', 'nom2', 'prenom1', NULL, '2 rue dupont', '20000', 'NANTES2', 5);
INSERT INTO "public"."eleve" ("personne_password", "personne_login", "personne_nom", "personne_prenom", "personne_date_naissance", "personne_adresse", "personne_cp", "personne_ville", personne_fk_groupe_id)
VALUES ('toor', 'Eleve3', 'nom3', 'prenom1', '30/01/2014', NULL, '30000', 'NANTES3', 5);
INSERT INTO "public"."eleve" ("personne_password", "personne_login", "personne_nom", "personne_prenom", "personne_date_naissance", "personne_adresse", "personne_cp", "personne_ville", personne_fk_groupe_id)
VALUES ('toor', 'Eleve4', 'nom4', 'prenom1', '31/01/2000', '4 rue dupont', NULL, 'NANTES4', 5);
INSERT INTO "public"."eleve" ("personne_password", "personne_login", "personne_nom", "personne_prenom", "personne_date_naissance", "personne_adresse", "personne_cp", "personne_ville", personne_fk_groupe_id)
VALUES ('toor', 'Eleve5', 'nom5', 'prenom1', '10/12/1970', '5 rue dupont', NULL, NULL, 5);
INSERT INTO "public"."eleve" ("personne_password", "personne_login", "personne_nom", "personne_prenom", "personne_date_naissance", "personne_adresse", "personne_cp", "personne_ville", personne_fk_groupe_id)
VALUES ('toor', 'Eleve6', 'nom6', 'prenom1', '10/12/1970', '5 rue dupont', NULL, NULL, 5);

-- CLASSES
INSERT INTO "public"."classroom" ("classroom_fk_filiere_id", "classroom_fk_niveau_id", "classroom_fk_personne_manager_id", "classroom_libelle")
VALUES (1, 1, 1, 'A');
INSERT INTO "public"."classroom" ("classroom_fk_filiere_id", "classroom_fk_niveau_id", "classroom_fk_personne_manager_id", "classroom_libelle")
VALUES (1, 2, 1, 'A');
INSERT INTO "public"."classroom" ("classroom_fk_filiere_id", "classroom_fk_niveau_id", "classroom_fk_personne_manager_id", "classroom_libelle")
VALUES (1, 3, 2, 'A');
INSERT INTO "public"."classroom" ("classroom_fk_filiere_id", "classroom_fk_niveau_id", "classroom_fk_personne_manager_id", "classroom_libelle")
VALUES (2, 1, 3, 'B');
INSERT INTO "public"."classroom" ("classroom_fk_filiere_id", "classroom_fk_niveau_id", "classroom_fk_personne_manager_id", "classroom_libelle")
VALUES (2, 2, 4, 'B');
INSERT INTO "public"."classroom" ("classroom_fk_filiere_id", "classroom_fk_niveau_id", "classroom_fk_personne_manager_id", "classroom_libelle")
VALUES (2, 3, 4, 'B');
INSERT INTO "public"."classroom" ("classroom_fk_filiere_id", "classroom_fk_niveau_id", "classroom_fk_personne_manager_id", "classroom_libelle")
VALUES (3, 1, 1, 'C');
INSERT INTO "public"."classroom" ("classroom_fk_filiere_id", "classroom_fk_niveau_id", "classroom_fk_personne_manager_id", "classroom_libelle")
VALUES (3, 2, 1, 'C');
INSERT INTO "public"."classroom" ("classroom_fk_filiere_id", "classroom_fk_niveau_id", "classroom_fk_personne_manager_id", "classroom_libelle")
VALUES (3, 3, 2, 'C');

-- BILANS
INSERT INTO "public"."bilan" ("bilan_fk_personne_id", "bilan_libelle", "bilan_commentaire", "bilan_date_debut", "bilan_date_fin")
VALUES
  (7, '1er semestre blabla', 'Un bloc de commentaire \n de longeur 255 charvs Bla Bla bla', '01/01/2016', '01/03/2016');
INSERT INTO "public"."bilan" ("bilan_fk_personne_id", "bilan_libelle", "bilan_commentaire", "bilan_date_debut", "bilan_date_fin")
VALUES
  (7, '2em semestre blabla', 'Un bloc de commentaire \n de longeur 255 charvs Bla Bla bla', '01/03/2016', '01/05/2016');
INSERT INTO "public"."bilan" ("bilan_fk_personne_id", "bilan_libelle", "bilan_commentaire", "bilan_date_debut", "bilan_date_fin")
VALUES
  (7, '3em semestre blabla', 'Un bloc de commentaire \n de longeur 255 charvs Bla Bla bla', '01/05/2017', '01/07/2017');
INSERT INTO "public"."bilan" ("bilan_fk_personne_id", "bilan_libelle", "bilan_commentaire", "bilan_date_debut", "bilan_date_fin")
VALUES
  (8, '1er semestre blabla', 'Un bloc de commentaire \n de longeur 255 charvs Bla Bla bla', '01/01/2016', '01/03/2016');
INSERT INTO "public"."bilan" ("bilan_fk_personne_id", "bilan_libelle", "bilan_commentaire", "bilan_date_debut", "bilan_date_fin")
VALUES
  (8, '2em semestre blabla', 'Un bloc de commentaire \n de longeur 255 charvs Bla Bla bla', '01/03/2016', '01/05/2016');
INSERT INTO "public"."bilan" ("bilan_fk_personne_id", "bilan_libelle", "bilan_commentaire", "bilan_date_debut", "bilan_date_fin")
VALUES
  (8, '3em semestre blabla', 'Un bloc de commentaire \n de longeur 255 charvs Bla Bla bla', '01/05/2017', '01/07/2017');
INSERT INTO "public"."bilan" ("bilan_fk_personne_id", "bilan_libelle", "bilan_commentaire", "bilan_date_debut", "bilan_date_fin")
VALUES
  (9, '1er semestre blabla', 'Un bloc de commentaire \n de longeur 255 charvs Bla Bla bla', '01/01/2016', '01/03/2016');
INSERT INTO "public"."bilan" ("bilan_fk_personne_id", "bilan_libelle", "bilan_commentaire", "bilan_date_debut", "bilan_date_fin")
VALUES (10, '1er semestre blabla', 'Un bloc de commentaire \n de longeur 255 charvs Bla Bla bla', '01/01/2016',
        '01/03/2016');
INSERT INTO "public"."bilan" ("bilan_fk_personne_id", "bilan_libelle", "bilan_commentaire", "bilan_date_debut", "bilan_date_fin")
VALUES (10, '2em semestre blabla', 'Un bloc de commentaire \n de longeur 255 charvs Bla Bla bla', '01/05/2017',
        '01/07/2017');

-- NOTES
INSERT INTO "public"."note" ("note_abvr", "note_libelle", "note_valeur", "note_couleur", "note_active")
VALUES ('A', 'Compétence acquise', 20, '#00af4c', TRUE);
INSERT INTO "public"."note" ("note_abvr", "note_libelle", "note_valeur", "note_couleur", "note_active")
VALUES ('A', 'Compétence presque acquise', 15, '#007baf', TRUE);
INSERT INTO "public"."note" ("note_abvr", "note_libelle", "note_valeur", "note_couleur", "note_active")
VALUES ('A', 'Compétence encore fragile, en voie d''acquisition', 10, '#ffd600', TRUE);
INSERT INTO "public"."note" ("note_abvr", "note_libelle", "note_valeur", "note_couleur", "note_active")
VALUES ('A', 'Compétence en cours d''acquisition, débutant', 5, '#ff9600', TRUE);
INSERT INTO "public"."note" ("note_abvr", "note_libelle", "note_valeur", "note_couleur", "note_active")
VALUES ('A', 'Compétence non acquise', 0, '#ff0000', TRUE);
INSERT INTO "public"."note" ("note_abvr", "note_libelle", "note_valeur", "note_couleur", "note_active")
VALUES ('DEC', 'Compétence désactivée', 0, '#ff0000', FALSE);

-- ASSOC FILIERES BLOCS
INSERT INTO "public"."assoc_filiere_bloc" ("assoc_filiere_bloc_fk_filiere_id", "assoc_filiere_bloc_fk_bloc_id")
VALUES (1, 1);
INSERT INTO "public"."assoc_filiere_bloc" ("assoc_filiere_bloc_fk_filiere_id", "assoc_filiere_bloc_fk_bloc_id")
VALUES (1, 2);
INSERT INTO "public"."assoc_filiere_bloc" ("assoc_filiere_bloc_fk_filiere_id", "assoc_filiere_bloc_fk_bloc_id")
VALUES (1, 3);
INSERT INTO "public"."assoc_filiere_bloc" ("assoc_filiere_bloc_fk_filiere_id", "assoc_filiere_bloc_fk_bloc_id")
VALUES (1, 4);

INSERT INTO "public"."assoc_filiere_bloc" ("assoc_filiere_bloc_fk_filiere_id", "assoc_filiere_bloc_fk_bloc_id")
VALUES (2, 5);
INSERT INTO "public"."assoc_filiere_bloc" ("assoc_filiere_bloc_fk_filiere_id", "assoc_filiere_bloc_fk_bloc_id")
VALUES (2, 6);
INSERT INTO "public"."assoc_filiere_bloc" ("assoc_filiere_bloc_fk_filiere_id", "assoc_filiere_bloc_fk_bloc_id")
VALUES (2, 7);
INSERT INTO "public"."assoc_filiere_bloc" ("assoc_filiere_bloc_fk_filiere_id", "assoc_filiere_bloc_fk_bloc_id")
VALUES (2, 8);

INSERT INTO "public"."assoc_filiere_bloc" ("assoc_filiere_bloc_fk_filiere_id", "assoc_filiere_bloc_fk_bloc_id")
VALUES (3, 9);
INSERT INTO "public"."assoc_filiere_bloc" ("assoc_filiere_bloc_fk_filiere_id", "assoc_filiere_bloc_fk_bloc_id")
VALUES (3, 10);
INSERT INTO "public"."assoc_filiere_bloc" ("assoc_filiere_bloc_fk_filiere_id", "assoc_filiere_bloc_fk_bloc_id")
VALUES (3, 11);
INSERT INTO "public"."assoc_filiere_bloc" ("assoc_filiere_bloc_fk_filiere_id", "assoc_filiere_bloc_fk_bloc_id")
VALUES (3, 12);

-- ASSOC MATIERE COMPETENCE/CAPCITES mat60 comp38
-- TRANSVERSALE
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (1, 1);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (2, 1);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (3, 2);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (4, 2);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (5, 3);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (6, 3);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (7, 4);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (8, 4);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (9, 5);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (10, 5);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (11, 6);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (12, 6);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (13, 7);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (14, 7);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (15, 8);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (16, 8);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (17, 9);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (18, 9);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (19, 10);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (20, 10);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (21, 11);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (22, 12);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (23, 12);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (24, 13);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (25, 13);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (26, 14);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (27, 14);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (28, 15);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (29, 15);

INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (30, 16);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (31, 17);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (32, 18);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (33, 19);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (34, 20);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (35, 21);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (36, 22);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (37, 23);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (38, 24);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (39, 25);

INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (1, 26);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (2, 15);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (3, 15);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (4, 14);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (5, 14);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (6, 13);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (7, 13);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (8, 12);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (9, 12);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (10, 11);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (11, 10);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (12, 10);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (13, 9);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (14, 9);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (17, 7);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (18, 7);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (19, 6);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (20, 6);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (21, 5);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (22, 5);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (23, 4);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (24, 4);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (25, 3);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (26, 3);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (27, 2);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (28, 2);
INSERT INTO "public"."assoc_matiere_com_cap" ("assoc_matiere_com_cap_fk_matiere_id", "assoc_matiere_com_cap_fk_competence_id")
VALUES (29, 1);

-- ASSOC ENSEIGNER ENS1à6 CLASS9 promo6
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (1, 1, 1, 1);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (1, 1, 1, 2);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (2, 1, 1, 3);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (2, 2, 1, 3);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (2, 2, 1, 1);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (3, 1, 2, 1);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (3, 3, 1, 2);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (4, 3, 1, 3);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (4, 4, 1, 3);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (4, 4, 1, 4);

INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (1, 1, 3, 1);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (1, 1, 3, 2);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (2, 1, 3, 3);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (2, 2, 3, 3);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (2, 2, 3, 1);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (3, 1, 3, 1);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (3, 3, 3, 2);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (4, 3, 3, 3);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (4, 4, 3, 3);
INSERT INTO "public"."assoc_enseigner" ("assoc_enseigner_fk_personne_id", "assoc_enseigner_fk_classroom_id", "assoc_enseigner_fk_matiere_id", "assoc_enseigner_fk_promo_enseignement_id")
VALUES (4, 4, 3, 4);

-- ASSOC ETUDIER
INSERT INTO "public"."assoc_etudier" ("assoc_etudier_fk_personne_id", "assoc_etudier_fk_classroom_id", "assoc_etudier_fk_promo_etudiant_id")
VALUES (7, 1, 1);
INSERT INTO "public"."assoc_etudier" ("assoc_etudier_fk_personne_id", "assoc_etudier_fk_classroom_id", "assoc_etudier_fk_promo_etudiant_id")
VALUES (8, 1, 1);
INSERT INTO "public"."assoc_etudier" ("assoc_etudier_fk_personne_id", "assoc_etudier_fk_classroom_id", "assoc_etudier_fk_promo_etudiant_id")
VALUES (9, 1, 1);
INSERT INTO "public"."assoc_etudier" ("assoc_etudier_fk_personne_id", "assoc_etudier_fk_classroom_id", "assoc_etudier_fk_promo_etudiant_id")
VALUES (8, 2, 1);
INSERT INTO "public"."assoc_etudier" ("assoc_etudier_fk_personne_id", "assoc_etudier_fk_classroom_id", "assoc_etudier_fk_promo_etudiant_id")
VALUES (9, 2, 2);
INSERT INTO "public"."assoc_etudier" ("assoc_etudier_fk_personne_id", "assoc_etudier_fk_classroom_id", "assoc_etudier_fk_promo_etudiant_id")
VALUES (10, 3, 1);
INSERT INTO "public"."assoc_etudier" ("assoc_etudier_fk_personne_id", "assoc_etudier_fk_classroom_id", "assoc_etudier_fk_promo_etudiant_id")
VALUES (11, 3, 1);
INSERT INTO "public"."assoc_etudier" ("assoc_etudier_fk_personne_id", "assoc_etudier_fk_classroom_id", "assoc_etudier_fk_promo_etudiant_id")
VALUES (12, 3, 1);

-- ASSOC EVALUER
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (1, 7, 1, 1, 2, '01/01/2016');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (1, 7, 2, 2, 1, '01/01/2016');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (1, 8, 3, 2, 1, '01/01/2016');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (1, 8, 4, 4, 5, '01/01/2016');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (2, 7, 5, 4, 5, '01/01/2016');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (2, 7, 6, 4, 5, '01/01/2016');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (3, 7, 7, 5, 1, '01/01/2015');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (3, 7, 8, 5, 1, '01/01/2015');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (3, 7, 9, 5, 1, '01/01/2015');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (3, 7, 10, 5, 1, '01/01/2015');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (3, 7, 11, 5, 1, '01/01/2015');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (3, 7, 12, 5, 1, '01/01/2015');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (3, 7, 13, 5, 1, '01/01/2015');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (3, 7, 14, 5, 1, '01/01/2015');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (3, 7, 15, 5, 1, '01/01/2015');
INSERT INTO "public"."assoc_evaluer" ("assoc_evaluer_fk_personne_emp_id", "assoc_evaluer_fk_personne_ele_id", "assoc_evaluer_fk_com_cap_id", "assoc_evaluer_fk_note_emp_id", "assoc_evaluer_fk_note_ele_id", "assoc_evaluer_date_evaluation")
VALUES (3, 7, 16, 5, 1, '01/01/2015');

-- PARAMETER
INSERT INTO "public"."parametre" ("parametre_libelle", "parametre_valeur") VALUES ('TITRE', 'LPC Cens');
INSERT INTO "public"."parametre" ("parametre_libelle", "parametre_valeur") VALUES ('HASHKEY', 'FxPMENDUZnCIQkIT');
INSERT INTO "public"."parametre" ("parametre_libelle", "parametre_valeur") VALUES ('LOGO', '/img/logo/full120x120.png');