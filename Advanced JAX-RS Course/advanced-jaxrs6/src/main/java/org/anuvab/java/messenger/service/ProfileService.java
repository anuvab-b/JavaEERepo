package org.anuvab.java.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.anuvab.java.messenger.database.DatabaseClass;
import org.anuvab.java.messenger.model.Profile;

public class ProfileService {

	private Map<String, org.anuvab.java.messenger.model.Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("koushik", new Profile(1L, "koushik", "Koushik", "Kothagal"));
	}
	
	public List<org.anuvab.java.messenger.model.Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public org.anuvab.java.messenger.model.Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public org.anuvab.java.messenger.model.Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
}
