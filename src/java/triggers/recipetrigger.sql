DROP TRIGGER IF EXISTS `brewery`.`brew_BEFORE_INSERT`;

DELIMITER $$
USE `brewery`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `brewery`.`brew_BEFORE_INSERT` BEFORE INSERT ON `recipe` FOR EACH ROW
BEGIN


  
if(NEW.gypsumAmt <> 0)
    THEN
        INSERT INTO recipematerials
            (qty,recipeName,brewMaterialsName)
                VALUES(NEW.gypsumAmt, NEW.recipeName, 'Gypsum');
END if;

if(NEW.calciumChlorideAmt <> 0)
    THEN
        INSERT INTO recipematerials
            (qty,recipeName,brewMaterialsName)
                VALUES(NEW.calciumChlorideAmt, NEW.recipeName, 'CalciumChloride');

END if;

if(NEW.sodiumChlorideAmt <> 0)
    THEN
        INSERT INTO recipematerials
            (qty,recipeName,brewMaterialsName)
                VALUES(NEW.sodiumChlorideAmt, NEW.recipeName, 'SodiumChloride');

END if;

if(NEW.phosphAcidAmt <> 0)
    THEN
        INSERT INTO recipematerials
            (qty,recipeName,brewMaterialsName)
                VALUES(NEW.phosphAcidAmt, NEW.recipeName, 'PhosphoricAcid');

END if;

if(NEW.firstHop IS NOT NULL)
    THEN
        INSERT INTO recipematerials
            (qty,recipeName,brewMaterialsName)
                VALUES(NEW.firstHopAmt, NEW.recipeName, NEW.firstHop);
end if;


if(NEW.secondHop IS NOT NULL)
    THEN
        INSERT INTO recipematerials
            (qty,recipeName,brewMaterialsName)
                VALUES(NEW.secondHopAmt, NEW.recipeName, NEW.secondHop);
end if;

INSERT INTO recipematerials
            (qty,recipeName,brewMaterialsName)
                VALUES(NEW.baseMaltAmt, NEW.recipeName, NEW.baseMalt);



if(NEW.thirdHop IS NOT NULL)
    THEN
        INSERT INTO recipematerials
            (qty,recipeName,brewMaterialsName)
                VALUES(NEW.thirdHopAmt, NEW.recipeName, NEW.thirdHop);

End if;

if(NEW.secondMalt IS NOT NULL)
    THEN
        INSERT INTO recipematerials
            (qty,recipeName,brewMaterialsName)
                VALUES(NEW.secondMaltAmt, NEW.recipeName, NEW.secondMalt);

End if;
        
if(NEW.thirdMalt IS NOT NULL)
    THEN
        INSERT INTO recipematerials
            (qty,recipeName,brewMaterialsName)
                VALUES(NEW.thirdMaltAmt, NEW.recipeName, NEW.thirdMalt);

End if;
  
if(NEW.fourthMalt IS NOT NULL)
    THEN
        INSERT INTO recipematerials
            (qty,recipeName,brewMaterialsName)
                VALUES(NEW.fourthMaltAmt, NEW.recipeName, NEW.fourthMalt);

End if;


END$$
DELIMITER ;
