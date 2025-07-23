package com.leandroleiteh.resources;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.openapi.quarkus.swagger_codegen_backend_challenge_yaml.api.JwtApi;
import org.openapi.quarkus.swagger_codegen_backend_challenge_yaml.model.JwtInput;
import org.openapi.quarkus.swagger_codegen_backend_challenge_yaml.model.JwtResponse;

@RunOnVirtualThread
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@ApplicationScoped
public class JwtResource implements JwtApi {

    @Override
    public Response validateJwtToken(JwtInput jwtInput) {
        return Response.ok(new JwtResponse().valid(Boolean.TRUE)).build();
    }
}
