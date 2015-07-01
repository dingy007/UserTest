SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `HibernateSpringWebProject` DEFAULT CHARACTER SET latin1 ;
USE `HibernateSpringWebProject` ;

-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`Contacts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`Contacts` (
  `contactId` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `firstName` VARCHAR(255) NOT NULL,
  `lastName` VARCHAR(255) NULL DEFAULT NULL,
  `mobile` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`contactId`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


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
-- Table `HibernateSpringWebProject`.`NewContact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`NewContact` (
  `contactid` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `phonenum` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`contactid`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`Usr`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`Usr` (
  `userId` INT(11) NOT NULL AUTO_INCREMENT,
  `badgeId` VARCHAR(255) NOT NULL,
  `fname` VARCHAR(255) NOT NULL,
  `lname` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`UserDetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`UserDetails` (
  `detailsId` INT(11) NOT NULL AUTO_INCREMENT,
  `User_Email` VARCHAR(255) NULL DEFAULT NULL,
  `UserFk` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`detailsId`),
  INDEX `FK_uglctohhwo0caxndtt6in82g` (`UserFk` ASC),
  CONSTRAINT `FK_uglctohhwo0caxndtt6in82g`
    FOREIGN KEY (`UserFk`)
    REFERENCES `HibernateSpringWebProject`.`Usr` (`userId`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`users` (
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(80) NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`authorities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HibernateSpringWebProject`.`authorities` (
  `username` VARCHAR(60) NOT NULL,
  `authority` VARCHAR(45) NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`users`
-- -----------------------------------------------------
-- CREATE TABLE `HibernateSpringWebProject`.`users` (
--   `USER_ID` int(10) unsigned NOT NULL,
--   `USERNAME` varchar(40) NOT NULL,
-- `PASSWORD` varchar(40) NOT NULL,
--   `ACTIVE` tinyint(1) NOT NULL,
--   PRIMARY KEY  (`USER_ID`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1


-- -----------------------------------------------------
-- Table `HibernateSpringWebProject`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE `HibernateSpringWebProject`.`user_roles` (
  `USER_ROLE_ID` int(10) unsigned NOT NULL,
  `USER_ID` int(10) unsigned NOT NULL,
  `AUTHORITY` varchar(45) NOT NULL,
  PRIMARY KEY  (`USER_ROLE_ID`),
  KEY `FK_user_roles` (`USER_ID`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
