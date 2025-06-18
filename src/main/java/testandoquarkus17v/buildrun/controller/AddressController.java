package testandoquarkus17v.buildrun.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import testandoquarkus17v.buildrun.service.AddressService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/address")
@ApplicationScoped
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    
    @GET
    public Response findAll(){
        return Response.ok(addressService.findAll()).build();
    }

    //TODO Implementar consulta de endereço pelo nome do usuário
    
}
