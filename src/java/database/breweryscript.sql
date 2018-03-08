-- MySQL Script generated by MySQL Workbench
-- Wed Jan 17 12:17:21 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALId_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema brewery
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `brewery` ;

-- -----------------------------------------------------
-- Schema brewery
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `brewery` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `brewery` ;

-- -----------------------------------------------------
-- Table `Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `role` (
  `roleId` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`roleId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `employee` (
  `empId` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(30) NOT NULL UNIQUE,
  `roleId` INT NOT NULL,
  `isActive` TINYINT NOT NULL,
  `resetPasswordUUID` VARCHAR(50),
    
  PRIMARY KEY (`empId`))
ENGINE = InnoDB;

SHOW WARNINGS;



-- -----------------------------------------------------
-- Table `SV`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sv` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `sv` (
  `svId` INT NOT NULL AUTO_INCREMENT,
  `capacity` INT NOT NULL,
  `volume` DOUBLE NULL,
    `brew1` INT NULL,
    `brew2` INT NULL,
    `brew3` INT NULL,
    `brand` VARCHAR(15) NULL,
  `status` CHAR NULL,
  PRIMARY KEY (`svId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `ProductionMaterial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `productionmaterial` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `productionmaterial` (
  `name` VARCHAR(40) NOT NULL,
  `qty` INT NULL,
  PRIMARY KEY (`Name`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Production`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `production` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `production` (
  `prodId` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `date` DATETIME NOT NULL,
  `employeeId` INT NOT NULL,
  `svNum` INT NOT NULL,
  `productionType` VARCHAR(20) NOT NULL,
  `expectedSvVolume` DOUBLE NOT NULL,  
  `finishedSvVolume` DOUBLE NOT NULL,
  `gainLoss` DOUBLE(9,9) NOT NULL,
  PRIMARY KEY (`prodId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `ProductionMaterialUsage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `productionmaterialusage` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `productionmaterialusage` (
  `materialQty` DOUBLE NULL,
  `name` VARCHAR(40) NOT NULL,
  `usage` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`Usage`, `Name`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `account` (
  `companyName` VARCHAR(45) NOT NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`companyName`, `address`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FinishedProduct`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finishedproduct` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `finishedproduct` (
  `productName` VARCHAR(40) NOT NULL,
  `qty` INT NULL,
  `volumePerUnit` DOUBLE NOT NULL,
  PRIMARY KEY (`productName`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `product` (
  `productName` VARCHAR(45) NOT NULL,
  `qty` INT NOT NULL,
  `deliveryId` INT NOT NULL,
  PRIMARY KEY (`deliveryId`, `productName`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Delivery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `delivery` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `delivery` (
  `deliveryId` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `companyName` VARCHAR(45) NOT NULL,
  `empId` INT NOT NULL,
  PRIMARY KEY (`deliveryId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FV`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fv` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `fv` (
  `fvId` INT NOT NULL AUTO_INCREMENT,
  `capacity` INT NOT NULL,
  `volume` DOUBLE NULL,
    `brew1` INT NULL,
    `brew2` INT NULL,
    `brew3` INT NULL,
    `brand` VARCHAR(15) NULL,
  `status` CHAR NULL,
  PRIMARY KEY (`fvId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Recipe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipe` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `recipe` (
  `recipeName` VARCHAR(25) NOT NULL,
  `dateModified` DATE NULL,
  `mashInTemp` FLOAT NULL,
  `mashInTime` FLOAT NULL,
  `mashWaterVolume` INT NULL,
  `restTime` DECIMAL NULL,
  `raiseToTemp` INT NULL,
  `inTime` DECIMAL NULL,
  `totalMashTime` DECIMAL NULL,
  `underletLitres` INT NULL,
  `rest` DECIMAL NULL,
  `vorlaufTime` DECIMAL NULL,
  `firstWortGrav` FLOAT NULL,
  `runOffTime` DECIMAL NULL,
  `spargVol` DECIMAL NULL,
  `spargTemp` FLOAT NULL,
  `lastRunningsGrav` FLOAT NULL,
  `kettleFullVol` DECIMAL NULL,
  `kettleFullGrav` FLOAT NULL,
  `boilTime` DECIMAL NULL,
  `strikeOutVol` DECIMAL NULL,
  `strikeOutGrav` FLOAT NULL,
  `whirlPoolTime` DECIMAL NULL,
  `coolInTemp` FLOAT NULL,
  `oxygenRate` FLOAT NULL,
  `gypsumAmt` FLOAT NULL,
  `calciumChlorideAmt` FLOAT NULL,
  `sodiumChlorideAmt` FLOAT NULL,
  `phosphAcidAmt` FLOAT NULL,
  `firstHop` VARCHAR(20) NULL,
  `firstHopAmt` FLOAT NULL,
  `secondHop` VARCHAR(20) NULL,
  `secondHopAmt` FLOAT NULL,
  `thirdHop` VARCHAR(20) NULL,
  `thirdHopAmt` FLOAT NULL,
  `baseMalt` VARCHAR(20) NULL,
  `baseMaltAmt` FLOAT NULL,
  `secondMalt` VARCHAR(20) NULL,
  `secondMaltAmt` FLOAT NULL,
  `thirdMalt` VARCHAR(20) NULL,
  `thirdMaltAmt` FLOAT NULL,
  `fourthMalt` VARCHAR(20) NULL,
  `fourthMaltAmt` FLOAT NULL,
  PRIMARY KEY (`recipeName`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Brew`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `brew` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `brew` (
  `brewId` INT NOT NULL AUTO_INCREMENT,
  `date` DATE,  
  `mashInTime` FLOAT NULL,
  `restTime` FLOAT NULL,
  `inTime` FLOAT NULL,
  `totalMashTime` FLOAT NULL,  
  `underletTime` FLOAT NULL,
  `lauterRestTime` FLOAT NULL,
  `vorlaufTime` FLOAT NULL,
  `firstWortGravity` FLOAT NULL,
  `runOffTime` FLOAT NULL,
  `lastRunningsGravity` FLOAT NULL,
  `kettleFullVol` FLOAT NULL,
  `kettleFullGravity` FLOAT NULL,
  `kettleStrikeOutVol` FLOAT NULL,
  `kettleStrikeOutGravity` FLOAT NULL,
  `allInVolume` FLOAT NULL,  
  `empId` INT NOT NULL,
  `fvId` INT NOT NULL,
  `recipeName` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`brewId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Supplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supplier` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `supplier` (
  `supplierId` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`supplierId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `PurchaseOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `purchaseorder` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `purchaseorder` (
  `purchaseOrderId` INT NOT NULL,
  `materialId` INT NULL,
  `qty` INT NULL,
  `empId` INT NOT NULL,
  `supplierId` INT NOT NULL,
  `dateArrived` DATE NULL,
  PRIMARY KEY (`purchaseOrderId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `BrewMaterials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `brewmaterials` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `brewmaterials` (
  `name` VARCHAR(25) NOT NULL,
  `qty` double NULL,
  `units` VARCHAR(5) NULL,
  `type`  VARCHAR(10) NULL,
  PRIMARY KEY (`Name`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `RecipeMaterials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipematerials` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `recipematerials` (
  `qty` double NULL,
  `recipeName` VARCHAR(25) NOT NULL,
  `brewMaterialsName` VARCHAR(15) NOT NULL)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Transfer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `transfer` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `transfer` (
  `transferId` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `volume` DOUBLE NULL,
  `fromFv` INT NOT NULL,
  `toSv` INT NOT NULL,
  `brand` VARCHAR(15) NULL,
  `correction` DOUBLE NULL,
  PRIMARY KEY (`transferId`))
ENGINE = InnoDB;

SHOW WARNINGS;
USE `brewery` ;

-- -----------------------------------------------------
-- Table `ProductionSchedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `productionschedule` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `productionschedule` (
  `date` DATE NOT NULL,
  `brew` VARCHAR(255) NULL,
  PRIMARY KEY (`date`))
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


