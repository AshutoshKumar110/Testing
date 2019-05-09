/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.ta_portal.manager;

import com.tcs.ignite.ta_portal.model.UserDetails;
import com.tcs.ta_portal.abstractManager.AbstractManager;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ignite054
 */
@Repository("Manager")
public class Manager extends AbstractManager<UserDetails> {
    public UserDetails getTraineeByBatch(String batch)
    {
      return fetchTraineeByBatch("fetchTraineeByBatch",batch);
    }
    
}
