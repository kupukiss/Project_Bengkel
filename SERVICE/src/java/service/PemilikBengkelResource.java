/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.LocationHelper;
import helper.PemilikBengkelHelper;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.PemilikBengkel;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("PemilikBengkel")
public class PemilikBengkelResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PemilikBengkelResource
     */
    public PemilikBengkelResource() {
    }

    /**
     * Retrieves representation of an instance of service.PemilikBengkelResource
     * @return an instance of java.lang.String
     */
      @GET
    @Produces(MediaType.APPLICATION_JSON)
     public Response getJson() {
        //TODO return proper representation object
                return Response.status(Response.Status.OK)
       .entity(PemilikBengkelHelper.toJson())
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
     * PUT method for updating or creating an instance of PemilikBengkelResource
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
     @POST
  @Path("addPB")
  @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
  public Response addNewPB(String data){
      Gson gson=new Gson();
      PemilikBengkel PB=gson.fromJson(data,PemilikBengkel.class);
      PemilikBengkelHelper helper=new PemilikBengkelHelper();
      helper.addNewPB(
              PB.getNama(), 
              PB.getEmail(), 
              PB.getPassword(),
              PB.getNamaBengkel(),
              PB.getAlamat(),
              PB.getJamBuka(),
              PB.getJamTutup(),
              PB.getJenisKendaraan(),
              PB.getLatitude(),
              PB.getLongitud()
      );
      return Response.status(200).entity(PB).build();
}
  
@Path("login")
   @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("email") String email, @QueryParam("password") String password) {
        return new Gson().toJson(new PemilikBengkel().login(email, password));
    }
}
