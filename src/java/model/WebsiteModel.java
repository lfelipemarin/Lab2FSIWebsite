/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.WebsiteDAO;
import dto.WebsiteDTO;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class WebsiteModel {

    public ArrayList<WebsiteDTO> getWebs() throws Exception {
        ArrayList<WebsiteDTO> webs = null;
        try {
            WebsiteDAO dao = new WebsiteDAO();
            webs = dao.getAll();
        } catch (Exception e) {
            throw e;
        }
        return webs;
    }

    public void insertWeb(WebsiteDTO web) throws Exception {
        try {
            WebsiteDAO dao = new WebsiteDAO();
            dao.insertWeb(web);

        } catch (Exception e) {
            throw e;
        }
    }
}
