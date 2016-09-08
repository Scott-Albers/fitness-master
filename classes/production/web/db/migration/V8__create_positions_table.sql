CREATE TABLE `positions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lon` decimal(11,0) DEFAULT NULL,
  `lat` decimal(11,0) DEFAULT NULL,
  `alt` decimal(11,0) DEFAULT NULL,
  `current_time` datetime DEFAULT NULL,
  `run_id` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_runs_pos_idx` (`run_id`),
  CONSTRAINT `fk_runs_pos` FOREIGN KEY (`run_id`) REFERENCES `runs` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
