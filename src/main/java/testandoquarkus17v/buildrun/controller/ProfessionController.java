package testandoquarkus17v.buildrun.controller;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import testandoquarkus17v.buildrun.service.ProfessionService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/profession")
@ApplicationScoped
public class ProfessionController {

    private final ProfessionService professionService;

    public ProfessionController(ProfessionService professionService){
        this.professionService = professionService;
    }

    @GET
    public Response findAll(){
        return Response.ok(professionService.findAll()).build();
    }

}
