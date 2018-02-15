/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import javax.persistence.PostPersist;

/**
 *
 * @author 553817
 */
public class BrewEntityListener {
    
    @PostPersist
    public void afterBrew(Brew brew)
    {
        Recipe recipe = new Recipe();
        
    }
    
}
