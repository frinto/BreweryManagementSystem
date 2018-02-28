DROP TRIGGER IF EXISTS `brewery`.`production_BEFORE_INSERT`;

DELIMITER $$
USE `brewery`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `brewery`.`production_BEFORE_INSERT` BEFORE INSERT ON `production` FOR EACH ROW
BEGIN
  
  DECLARE prodQty DOUBLE DEFAULT 0;
  DECLARE matQty DOUBLE DEFAULT 0;
  DECLARE prodName VARCHAR(25) DEFAULT "";
  DECLARE matName VARCHAR(25) DEFAULT "";
  DECLARE done INT DEFAULT FALSE;
  DECLARE cur1 CURSOR FOR SELECT *
  FROM productionmaterialusage;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
  SET prodQty = New.quantity;
  
  OPEN cur1;
  

  read_loop: LOOP
    FETCH cur1 INTO matQty,prodName,matName;
    IF done THEN
      LEAVE read_loop;
      END IF;
    
    if(NEW.productionType = prodName) THEN
        UPDATE productionmaterial
            SET qty = qty-matQty*prodQty
                WHERE name = matName;
                END if;
                
                
           
    
  END LOOP;

  CLOSE cur1;

END$$
DELIMITER ;

