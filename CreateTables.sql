SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `HibernateSpringWebProject` DEFAULT CHARACTER SET latin1 ;
USE `HibernateSpringWebProject` ;

-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`Quote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`Quote` (
  `QuoteId` INT(11) NOT NULL AUTO_INCREMENT,
  `total_amount` DOUBLE NULL DEFAULT NULL,
  `company_add` VARCHAR(255) NULL DEFAULT NULL,
  `company_initials` VARCHAR(3) NOT NULL,
  `company_name` VARCHAR(255) NOT NULL,
  `company_phone` INT(11) NULL DEFAULT NULL,
  `company_quote_count` INT(11) NULL DEFAULT NULL,
  `person_in_charge` VARCHAR(255) NULL DEFAULT NULL,
  `quotation_date` DATETIME NULL DEFAULT NULL,
  `quotation_number` TEXT NOT NULL,
  `sales_person` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`QuoteId`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`Invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`Invoice` (
  `Invoiceid` INT(11) NOT NULL AUTO_INCREMENT,
  `Comapny_initials` VARCHAR(255) NULL DEFAULT NULL,
  `Invoice_number` VARCHAR(255) NULL DEFAULT NULL,
  `quote_fk` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Invoiceid`),
  INDEX `FK_me7qrwk69cvcankc1wxl7txi0` (`quote_fk` ASC),
  CONSTRAINT `FK_me7qrwk69cvcankc1wxl7txi0`
    FOREIGN KEY (`quote_fk`)
    REFERENCES `HibernateSpringWebProject`.`Quote` (`QuoteId`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`Employee` (
  `EmployeeId` INT(11) NOT NULL AUTO_INCREMENT,
  `badgeId` VARCHAR(255) NOT NULL,
  `fname` VARCHAR(255) NOT NULL,
  `lname` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`EmployeeId`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`EmployeeDetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`EmployeeDetails` (
  `detailsId` INT(11) NOT NULL AUTO_INCREMENT,
  `User_Email` VARCHAR(255) NULL DEFAULT NULL,
  `UserFk` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`detailsId`),
  INDEX `FK_uglctohhwo0caxndtt6in82g` (`EmployeeFk` ASC),
  CONSTRAINT `FK_uglctohhwo0caxndtt6in82g`
    FOREIGN KEY (`EmployeeFk`)
    REFERENCES `HibernateSpringWebProject`.`Employee` (`EmployeeId`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`authorities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`authorities` (
  `username` VARCHAR(60) NOT NULL,
  `authority` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_authorities_1_idx` (`username` ASC),
  CONSTRAINT `fk_authorities_1`
    FOREIGN KEY (`username`)
    REFERENCES `HibernateSpringWebProject`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`users` (
  `USER_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(80) NULL DEFAULT NULL,
  `enabled` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`user_roles` (
  `user_roles_id` INT NOT NULL,
  `USER_ID` INT(10) NOT NULL,
  `AUTHORITY` VARCHAR(45) NULL,
  PRIMARY KEY (`user_roles_id`),
  INDEX `fk_user_roles_1_idx` (`USER_ID` ASC),
  CONSTRAINT `fk_user_roles_1`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `HibernateSpringWebProject`.`users` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



-- ADDING VALUES :
-- 
-- 
-- 
INSERT INTO `HibernateSpringWebProject`.`user_roles`
(`user_roles_id`,
`USER_ID`,
`AUTHORITY`)
VALUES(0,0,'admin_role');

INSERT INTO `HibernateSpringWebProject`.`users`
(`username`,`password`,`enabled`)
VALUES('dinesh','letmein',1);

-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema springwebmvcprj
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springwebmvcprj` DEFAULT CHARACTER SET utf8 ;
USE `springwebmvcprj` ;

-- -----------------------------------------------------
-- Table `springwebmvcprj`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springwebmvcprj`.`users` (
  `USER_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(80) NULL DEFAULT NULL,
  `enabled` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE (username))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `springwebmvcprj`.`authorities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springwebmvcprj`.`authorities` (
  `authoritiesId` INT(11) NOT NULL AUTO_INCREMENT,
  `authority` VARCHAR(45) NULL DEFAULT NULL,
  `usernameFK` VARCHAR(60) NULL,
  PRIMARY KEY (`authoritiesId`),
  CONSTRAINT `usernameFkey`
    FOREIGN KEY (`usernameFK`)
    REFERENCES `springwebmvcprj`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `springwebmvcprj`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springwebmvcprj`.`employee` (
  `EmployeeId` INT(11) NOT NULL AUTO_INCREMENT,
  `badgeId` VARCHAR(255) NOT NULL,
  `fname` VARCHAR(255) NOT NULL,
  `lname` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`EmployeeId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `springwebmvcprj`.`employeedetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springwebmvcprj`.`employeedetails` (
  `detailsId` INT(11) NOT NULL AUTO_INCREMENT,
  `User_Email` VARCHAR(255) NULL DEFAULT NULL,
  `EmployeeFk` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`detailsId`),
  INDEX `FK_uglctohhwo0caxndtt6in82g` (`EmployeeFk` ASC),
  CONSTRAINT `FK_uglctohhwo0caxndtt6in82g`
    FOREIGN KEY (`EmployeeFk`)
    REFERENCES `springwebmvcprj`.`employee` (`EmployeeId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `springwebmvcprj`.`users`
(`username`,`password`,`enabled`)
VALUES('dinesh','letmein',1);

INSERT INTO `springwebmvcprj`.`authorities`
(`authority`,`usernameFK`)
VALUES('role_admin','dinesh');