package com.thecookiezen.jsf.boundary;

import com.thecookiezen.jsf.entity.Docker;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("test")
@Produces("application/json")
@Consumes("application/json")
public class TestResource {

    @GET
    @Path("/1")
    public Docker test() {
        Docker docker = new Docker();
        docker.setDescription("qweqweqwe");
        return docker;
    }
}
