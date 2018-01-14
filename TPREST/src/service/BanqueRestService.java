package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/banque")
public class BanqueRestService {
	private static Map<Integer, Compte> Comptes = new HashMap();
	
	@GET
	@Path("/conversion/{montant}")
	@Produces(MediaType.APPLICATION_JSON)
	public double convesrion(@PathParam(value="montant")int mt){
		return 11*mt;
	}
	
	@GET
	@Path("/comptes/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte getCompte(@PathParam(value="code") int code){
		return Comptes.get(code);				
	}
	
	@GET
	@Path("/comptes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> listComptes(){
		return new ArrayList<>(Comptes.values());
	}
	
	@POST
	@Path("/comptes")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte save(Compte cp){
		Comptes.put(cp.getCode(), cp);
		return cp;	
	}


	@PUT
	@Path("/comptes/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte update(Compte cp, @PathParam(value="code") int code){
		Comptes.put(code, cp);
		return cp;	
	}
	
	@DELETE
	@Path("/comptes/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@PathParam(value="code") int code){
		Comptes.remove(code);
		return true;	
	}
}
