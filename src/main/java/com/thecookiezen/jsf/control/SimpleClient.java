package com.thecookiezen.jsf.control;

import com.thecookiezen.jsf.entity.SearchResult;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/v1")
public interface SimpleClient {

    @GET
    @Path("/search")
    public SearchResult findDockerImages(@QueryParam("q") String query);
}
