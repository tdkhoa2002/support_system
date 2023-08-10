-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema support_system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema support_system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `support_system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `support_system` ;

-- -----------------------------------------------------
-- Table `support_system`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `support_system`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `support_system`.`faculty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `support_system`.`faculty` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` LONGTEXT NOT NULL,
  `website_url` TEXT NOT NULL,
  `video_url` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `support_system`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `support_system`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `avatar` VARCHAR(255) NOT NULL,
  `roleName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `support_system`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `support_system`.`article` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `content` LONGTEXT NOT NULL,
  `date` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  `faculty_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_article_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_article_category1_idx` (`category_id` ASC) VISIBLE,
  INDEX `fk_article_faculty1_idx` (`faculty_id` ASC) VISIBLE,
  CONSTRAINT `fk_article_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `support_system`.`category` (`id`),
  CONSTRAINT `fk_article_faculty1`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `support_system`.`faculty` (`id`),
  CONSTRAINT `fk_article_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `support_system`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `support_system`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `support_system`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` LONGTEXT NOT NULL,
  `date` DATETIME NOT NULL,
  `article_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_article1_idx` (`article_id` ASC) VISIBLE,
  INDEX `fk_comment_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_article1`
    FOREIGN KEY (`article_id`)
    REFERENCES `support_system`.`article` (`id`),
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `support_system`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `support_system`.`livestream`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `support_system`.`livestream` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` TEXT NOT NULL,
  `date` DATETIME NOT NULL,
  `time` DOUBLE NOT NULL,
  `thumbnail` VARCHAR(255) NOT NULL,
  `faculty_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_livestream_faculty1_idx` (`faculty_id` ASC) VISIBLE,
  CONSTRAINT `fk_livestream_faculty1`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `support_system`.`faculty` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `support_system`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `support_system`.`question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL,
  `date_submitted` VARCHAR(45) NOT NULL,
  `livestream_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_question_livestream1_idx` (`livestream_id` ASC) VISIBLE,
  INDEX `fk_question_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_question_livestream1`
    FOREIGN KEY (`livestream_id`)
    REFERENCES `support_system`.`livestream` (`id`),
  CONSTRAINT `fk_question_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `support_system`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `support_system`.`score`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `support_system`.`score` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `year` INT NOT NULL,
  `score` DOUBLE NULL DEFAULT NULL,
  `faculty_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_score_faculty1_idx` (`faculty_id` ASC) VISIBLE,
  INDEX `fk_score_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_score_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `support_system`.`category` (`id`),
  CONSTRAINT `fk_score_faculty1`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `support_system`.`faculty` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
