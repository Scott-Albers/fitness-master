CREATE TABLE `fitness`.`runs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` VARCHAR(45) NOT NULL,
  `start_time` DATETIME NULL,
  `stop_time` DATETIME NULL,
  `active` BIT(1) NULL DEFAULT 1,
  `device_id` INT NULL,
  `created` DATETIME NULL,
  `updated` DATETIME NULL,
  PRIMARY KEY (`id`, `version`),
  INDEX `fk_this_stuff_idx` (`device_id` ASC),
  CONSTRAINT `fk_this_stuff`
    FOREIGN KEY (`device_id`)
    REFERENCES `fitness`.`devices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
