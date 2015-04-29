/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.google.gson.Gson;
import dto.WebsiteDTO;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.WebsiteModel;

/**
 * REST Web Service
 *
 * @author felipe
 */
@Path("/json/getWebs")
public class JSONService {
    
    @Context
    private UriInfo context;
    
    @GET
    @Path("/getFeeds")
    @Produces("application/json")
    public String feed() {
        String feeds = null;
        try {
            ArrayList<WebsiteDTO> webs = null;
            WebsiteModel model = new WebsiteModel();
            webs = model.getWebs();
            Gson gson = new Gson();
            System.out.println(gson.toJson(webs));
            feeds = gson.toJson(webs);
        } catch (Exception e) {
            System.out.println("Exception error");
        }
        return feeds;
    }
    
    @PUT
    @Path("/insertWeb")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createWebJSON(WebsiteDTO web) throws Exception {
        WebsiteModel model = new WebsiteModel();
        model.insertWeb(web);
        String result = "Web saved: " + web;
        return Response.status(201).entity(result).build();
    }
//    /**
//     * Creates a new instance of JSONService
//     */
//    public JSONService() {
//    }

//    /**
//     * Retrieves representation of an instance of webservice.JSONService
//     * @return an instance of java.lang.String
//     */
//    @GET
//    @Produces("application/json")
//    public String getJson() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//
//    /**
//     * PUT method for updating or creating an instance of JSONService
//     * @param content representation for the resource
//     * @return an HTTP response with content of the updated or created resource.
//     */
//    @PUT
//    @Consumes("application/json")
//    public void putJson(String content) {
//    }
}
