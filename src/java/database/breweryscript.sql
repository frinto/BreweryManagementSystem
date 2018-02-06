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
DROP TABLE IF EXISTS `Role` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Role` (
  `roleId` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`roleId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Employee` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Employee` (
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
DROP TABLE IF EXISTS `SV` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `SV` (
  `svId` INT NOT NULL,
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
DROP TABLE IF EXISTS `ProductionMaterial` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `ProductionMaterial` (
  `name` VARCHAR(40) NOT NULL,
  `qty` INT NULL,
  PRIMARY KEY (`Name`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Production`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Production` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Production` (
  `prodId` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `date` DATETIME NOT NULL,
  `employeeId` INT NOT NULL,
  `svNum` INT NOT NULL,
  `productionType` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`prodId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `ProductionMaterialUsage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ProductionMaterialUsage` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `ProductionMaterialUsage` (
  `materialQty` DOUBLE NULL,
  `name` VARCHAR(20) NOT NULL,
  `usage` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Usage`, `Name`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Account` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Account` (
  `accountId` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`accountId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FinishedProduct`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FinishedProduct` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `FinishedProduct` (
  `productName` VARCHAR(40) NOT NULL,
  `qty` INT NULL,
  PRIMARY KEY (`productName`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Product` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Product` (
  `name` VARCHAR(45) NULL,
  `finishedProductId` INT NOT NULL,
  PRIMARY KEY (`finishedProductId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Delivery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Delivery` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Delivery` (
  `deliveryId` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `accountId` INT NOT NULL,
  `empId` INT NOT NULL,
  `finishedProductId` INT NOT NULL,
  PRIMARY KEY (`deliveryId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FV`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FV` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `FV` (
  `fvId` INT NOT NULL,
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
DROP TABLE IF EXISTS `Recipe` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Recipe` (
  `recipeName` VARCHAR(25) NOT NULL,
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
  `firstHopAmt` VARCHAR(20) NULL,
  `secondHop` VARCHAR(20) NULL,
  `secondHopAmt` VARCHAR(20) NULL,
  `thirdHop` VARCHAR(20) NULL,
  `thirdHopAmt` VARCHAR(20) NULL,
  `baseMalt` VARCHAR(20) NULL,
  `baseMaltAmt` VARCHAR(20) NULL,
  `secondMalt` VARCHAR(20) NULL,
  `secondMaltAmt` VARCHAR(20) NULL,
  `thirdMalt` VARCHAR(20) NULL,
  `thirdMaltAmt` VARCHAR(20) NULL,
  `fourthMalt` VARCHAR(20) NULL,
  `fourthMaltAmt` VARCHAR(20) NULL,
  PRIMARY KEY (`recipeName`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Brew`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Brew` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Brew` (
  `brewId` INT NOT NULL,
  `mashInTime` INT NULL,
  `restTime` INT NULL,
  `inTime` VARCHAR(45) NULL,
  `underletTime` INT NULL,
  `lauterRestTime` INT NULL,
  `vorlaufTime` INT NULL,
  `firstWortGravity` FLOAT NULL,
  `runOffTime` INT NULL,
  `lastRunningsGravity` FLOAT NULL,
  `kettleFullVol` INT NULL,
  `kettleFullGravity` FLOAT NULL,
  `kettleStrikeOutVol` FLOAT NULL,
  `kettleStrikeOutGravity` FLOAT NULL,
  `empId` INT NOT NULL,
  `fvId` INT NOT NULL,
  `recipeId` INT NOT NULL,
  PRIMARY KEY (`brewId`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Supplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Supplier` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Supplier` (
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
DROP TABLE IF EXISTS `PurchaseOrder` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `PurchaseOrder` (
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
DROP TABLE IF EXISTS `BrewMaterials` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `BrewMaterials` (
  `name` VARCHAR(25) NOT NULL,
  `qty` INT NULL,
  `units` VARCHAR(5) NULL,
  `type`  VARCHAR(10) NULL,
  PRIMARY KEY (`Name`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `RecipeMaterials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RecipeMaterials` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `RecipeMaterials` (
  `qty` INT NULL,
  `recipeId` INT NOT NULL,
  `brewMaterialsName` VARCHAR(15) NOT NULL)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Transfer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Transfer` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Transfer` (
  `transferId` INT NOT NULL,
  `date` DATE NULL,
  `volume` DECIMAL NULL,
  `fromFv` INT NOT NULL,
  `toSv` INT NOT NULL,
  PRIMARY KEY (`transferId`))
ENGINE = InnoDB;

SHOW WARNINGS;
USE `brewery` ;

-- -----------------------------------------------------
-- Table `ProductionSchedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ProductionSchedule` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `ProductionSchedule` (
  `date` DATE NOT NULL,
  `brew1` VARCHAR(45) NULL,
  `brew2` VARCHAR(45) NULL,
  `brew3` VARCHAR(45) NULL,
  `transfer` VARCHAR(45) NULL,
  `productionDetail` VARCHAR(45) NULL,
  PRIMARY KEY (`date`))
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


