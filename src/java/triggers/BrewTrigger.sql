CREATE DEFINER=`root`@`localhost` TRIGGER `brewery`.`brew_BEFORE_INSERT` BEFORE INSERT ON `brew` FOR EACH ROW
BEGIN

  DECLARE matQty DOUBLE DEFAULT 0;
  DECLARE typeName VARCHAR(25) DEFAULT "";
  DECLARE brewName VARCHAR(25) DEFAULT "";
  DECLARE done INT DEFAULT FALSE;
  DECLARE cur1 CURSOR FOR SELECT *
  FROM recipematerials;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
  
  
 
 

  OPEN cur1;
  

  read_loop: LOOP
    FETCH cur1 INTO matQty,typeName,brewName;
    IF done THEN
      LEAVE read_loop;
      END IF;
    
    if(NEW.recipeName = typeName) THEN
        UPDATE brewmaterials
            SET qty = qty-matQty
                WHERE name = brewName;
                END if;
                
                
           
    
  END LOOP;

  CLOSE cur1;

END