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
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class DebugResource {

    @ConfigProperty(name = "mensagem_configmaps")
    String mensagemConfigMaps;

    @ConfigProperty(name = "mensagem_secrets")
    String mensagemSecrets;

    @GET
    public Response debug() {
        HashMap<String, String> hm = new HashMap<>();

        hm.put("mensagem_configmaps", mensagemConfigMaps);
        hm.put("mensagem_secrets", mensagemSecrets);

        return Response.ok(hm).build();
    }

}
