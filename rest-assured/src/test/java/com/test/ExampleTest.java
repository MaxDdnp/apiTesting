package com.test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ExampleTest {
	@Test
	public void testForLoopMeAPIAdsV3() {

		get("http://loopme.me/api/loopme/ads/v3?ak=b510d5bcda&ct=2&lng=ru&sv=4.2.0&av=14.1&mr=0&or=p&vt=ad3e363a-f943-4469-8abc-9dc67dcd61ea&carrier=25501")
				.then()
				.body("settings.format",
						equalTo("interstitial"))
				.body("settings.orientation",
						equalTo("landscape"))
				.body("settings.ad_refresh_time",
						equalTo("30"))
				.body("settings.ad_expiry_time",
						equalTo(3600));
	}

}
