/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.Connection;


/**
 *
 * @author victor alves abreu
 */
public interface Database {
    public Connection connect();
    public void disconnect(Connection conn);
}
