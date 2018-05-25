DELIMITER $$

DROP PROCEDURE IF EXISTS fa_management_reset $$
CREATE PROCEDURE fa_management_reset(date_effet DATETIME)
BEGIN
   IF date_effet IS NULL THEN
      SET date_effet = now();
   END IF;

   SET FOREIGN_KEY_CHECKS=0;
      TRUNCATE TABLE member;
      TRUNCATE TABLE rank;
      TRUNCATE TABLE status;
      TRUNCATE TABLE user;
   SET FOREIGN_KEY_CHECKS=1;
    
    INSERT INTO rank(id, libelle) VALUES
    (1, "Leader"),
    (2, "Officer"),
    (3, "Recruiter");
    
    INSERT INTO status(id, libelle) VALUES
    (1, "Member"),
    (2, "Decliner"),
    (3, "Leaver"),
    (4, "Absent");
    
    INSERT INTO member(id, id_status, name, free_company, plateform, comment, lodestone_number, join_date) VALUES
    (1, 1, "bob lek", "FA", "PS4", "test comment", "17826939", now()),
    (2, 4, "absent member", "FA", "PC", "comment", "19066194", now());
    
    INSERT INTO user(id, id_rank, email, name, password) VALUES
    (1, 1, "nomsmail@gmail.com", "Noms", "password1"),
    (2, 2, "scircamail@gmail.com", "Scirca", "password2");

END$$

CALL fa_management_reset(now());