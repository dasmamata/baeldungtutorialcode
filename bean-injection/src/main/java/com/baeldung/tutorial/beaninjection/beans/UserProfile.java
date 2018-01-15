package com.baeldung.tutorial.beaninjection.beans;

public class UserProfile {

	private UserCredentials credentials;
	private DemoGraphic demoGraphic;

	public UserProfile(UserCredentials creds) {
		setCredentials(creds);
	}

	public UserCredentials getCredentials() {
		return credentials;
	}

	public void setCredentials(UserCredentials credentials) {
		this.credentials = credentials;
	}

	public DemoGraphic getDemoGraphic() {
		return demoGraphic;
	}

	public void setDemoGraphic(DemoGraphic demoGraphic) {
		this.demoGraphic = demoGraphic;
	}

}
