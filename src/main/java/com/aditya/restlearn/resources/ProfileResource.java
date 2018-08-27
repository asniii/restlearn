package com.aditya.restlearn.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aditya.restlearn.model.Profile;
import com.aditya.restlearn.service.ProfileService;


@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService = new ProfileService();

	//localhost:8080/restlearn/webapi/profiles
	@GET
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}

	//localhost:8080/restlearn/webapi/profiles
	// Call this with header "Accept" set to "text/xml".
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Profile> getXmlProfiles(){
		System.out.println("This is the xml method.");
		return profileService.getAllProfiles();
	}


	//localhost:8080/restlearn/webapi/profiles
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}


	//localhost:8080/restlearn/webapi/profiles/{profileName}
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return profileService.getProfile(profileName);
	}


	//localhost:8080/restlearn/webapi/profiles/{profileName}
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}


	//localhost:8080/restlearn/webapi/profiles/{profileName}
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName")String profileName) {
		profileService.removeProfile(profileName);
	}
	
}
