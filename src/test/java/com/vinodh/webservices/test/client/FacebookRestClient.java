package com.vinodh.webservices.test.client;

import java.util.List;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.OAuth2Operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FacebookRestClient {

	// private static final String endPoint =
	// "https://graph.facebook.com/{appId}?fields=name,namespace,contact_email,website_url";
	// private static final String endPoint =
	// "https://graph.facebook.com/100001938558533?fields=name,first_name,gender,namespace,contact_email,relationship_status,website_url,age_range,admin_notes,birthday,employee_number,token_for_business,public_key";
	private static final String endPoint = "https://graph.facebook.com/100001938558533?fields=first_name,gender,email,relationship_status";
	public static final String FACEBOOK_HOST = "https://graph.facebook.com/";

	public static final String ACCESS_TOKEN = FACEBOOK_HOST + "v2.5/oauth/access_token";

	public static final String QPM_PASSWORD_GRANT = "?grant_type=password&username=Vinodh&password=abcd1234";

	public static final String QPM_ACCESS_TOKEN = "?access_token=";

	public static void main(String... s) {

		log.info("connecting to Facebook");

		String appToken = fetchApplicationAccessToken("871275273038741", "cd27dc2d87e5bf22786503a2374ad89c");
		log.info("/////////" + appToken);
		AppDetails appDetails = fetchApplicationData("871275273038741", appToken);

		log.info("........." + appDetails.toString());
	}

	private static AppDetails fetchApplicationData(String appId, String appToken) {
		Facebook facebook = new FacebookTemplate(appToken);
		return facebook.restOperations().getForObject(endPoint, AppDetails.class, appId);
	}

	private static String fetchApplicationAccessToken(String appId, String appSecret) {
		OAuth2Operations oauth = new FacebookConnectionFactory(appId, appSecret).getOAuthOperations();
		return oauth.authenticateClient().getAccessToken();
	}

	@Setter
	@Getter
	@ToString
	private static final class AppDetails {
		private long id;
		private String about;
		@JsonProperty("admin_notes")
		private String adminNotes;
		@JsonProperty("age_range")
		private String ageRange;
		private String name;
		private String namespace;
		@JsonProperty("contact_email")
		private String contactEmail;
		@JsonProperty("website_url")
		private String websiteUrl;
		private String birthday;
		private String context;
		private String cover;
		private String currency;
		private List<?> devices;
		private List<?> education;
		private String email;
		@JsonProperty("employee_number")
		private String employeeNumber;
		@JsonProperty("favorite_athletes")
		private List<?> favoriteAthletes;
		@JsonProperty("favorite_teams")
		private List<?> favoriteTeams;
		@JsonProperty("first_name")
		private String firstName;
		private String gender;
		@JsonProperty("public_key")
		private String publicKey;
		@JsonProperty("token_for_business")
		private String businessToken;
		@JsonProperty("third_party_id")
		private String thirdPartId;
		@JsonProperty("relationship_status")
		private String relationshipStatus;
	}
}
