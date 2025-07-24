package com.leandroleiteh.resources;

import com.leandroleiteh.services.JwtValidationService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.openapi.quarkus.swagger_codegen_backend_challenge_yaml.api.JwtApi;
import org.openapi.quarkus.swagger_codegen_backend_challenge_yaml.model.JwtInput;
import org.openapi.quarkus.swagger_codegen_backend_challenge_yaml.model.JwtResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static jakarta.ws.rs.core.Response.Status.OK;

@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@ApplicationScoped
public class JwtResource implements JwtApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtResource.class);

    private final JwtValidationService jwtValidationService;

    public JwtResource(JwtValidationService jwtValidationService) {
        this.jwtValidationService = jwtValidationService;
    }

    @Override
    public Response validateJwtToken(final JwtInput jwtInput) {
        if (jwtInput == null) {
            LOGGER.error("Token cannot be null");
            throw new BadRequestException("Token cannot be null");
        }
        LOGGER.info("INIT VALIDATION TOKEN JWT = {} ", jwtInput.getJwt());

        var valid = jwtValidationService.validateJwt(jwtInput);
        var result = valid ? "verdadeiro" : "falso";

        LOGGER.info("END VALIDATION TOKEN JWT result = {} ", result);
        return Response
                .status(valid ? OK : BAD_REQUEST)
                .entity(new JwtResponse().valid(result))
                .build();
    }
}
