package com.lossurdo.resources;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.HashMap;

@RequestScoped
@Path("/debug")
@Produces(MediaType.APPLICATION_JSON)
public class DebugResource {

    @ConfigProperty(name = "quarkus.application.version")
    String quarkusVersion;

    @GET
    public Response debug() {
        HashMap<String, String> hm = new HashMap<>();

        hm.put("quarkus_version", quarkusVersion);

        return Response.ok(hm).build();
    }

}
