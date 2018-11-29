/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.PemilikKendaraanHelper;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.PemilikKendaraan;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("pemilikKendaraan")
public class PemilikKendaraanResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PemilikKendaraanResource
     */
    public PemilikKendaraanResource() {
    }

    /**
     * Retrieves representation of an instance of
     * service.PemilikKendaraanResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        return Response.status(Response.Status.OK)
                .entity(PemilikKendaraanHelper.toJson())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Control-Max-Age", "2")
                .header("Access-Preflight-Maxage", "2")
                .build();
    }

    /**
     * PUT method for updating or creating an instance of
     * PemilikKendaraanResource
     *
     * @param content representation for the resource
     */
//   
    @POST
    @Path("addPK")
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response addNewPK(String data) {
        Gson gson = new Gson();
        PemilikKendaraan PK = gson.fromJson(data, PemilikKendaraan.class);
        PemilikKendaraanHelper helper = new PemilikKendaraanHelper();
        helper.addNewPK(
                PK.getNama(),
                PK.getEmail(),
                PK.getPassword()
              
             );
      return Response.status(200).entity(PK).build();
    }

    @Path("login")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("email") String email, @QueryParam("password") String password) {
        return new Gson().toJson(new PemilikKendaraanHelper().login(email, password));
    }
}
