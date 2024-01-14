/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sales;

import java.rmi.Remote;
import java.util.List;

/**
 *
 * @author NAKS MTSHATSHENI
 */
public interface Sales extends Remote{
    public List<Province> getProvince() throws Exception;

    
}
