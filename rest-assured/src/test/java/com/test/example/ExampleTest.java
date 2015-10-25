package com.test.example;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ExampleTest {
	StringBuilder strB = new StringBuilder();

	private String s1 = "<html><head><meta charset=";
	private String s2 = "";
	private String expectedScr= "<html><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0\"><title>LoopMe</title></head><body><script>lmCampaigns = {\"eventLinkTemplate\":\"https://loopme.me/api/v2/events?et=__EVENT_TYPE__&rid=336de456-5cb1-4bc4-be8a-cc43056e6d29&meta=NDM4MjA6NDMwOTphZDNlMzYzYS1mOTQzLTQ0NjktOGFiYy05ZGM2N2RjZDYxZWE&id=336de456-5cb1-4bc4-be8a-cc43056e6d29&name=__CUSTOM_EVENT_NAME__\",\"apiCreativesLink\":\"https://loopme.me/ad/jsonp?callback=__CALLBACK__&id=336de456-5cb1-4bc4-be8a-cc43056e6d29&meta=NDM4MjA6NDMwOTphZDNlMzYzYS1mOTQzLTQ0NjktOGFiYy05ZGM2N2RjZDYxZWE&di=SBznzFTm_2aPbqoC7gaiJAL9UrSTa39pazka7h2KFS4eXwiqh1wk9gA1Eysvq0V4\"," +
			"\"requestId\":\"336de456-5cb1-4bc4-be8a-cc43056e6d29\",\"ads\":[\"336de456-5cb1-4bc4-be8a-cc43056e6d29\"],\"package_ids\":[\"com.test\"]};</script><script src=\"https://loopme.me/lm.bridge.js?cb=1445610079000\"></script><script>if (!L || !L.bridge) {window.location = \"loopme://webview/fail\";}</script><div id=\"LOOPME_widget\"><script id=\"LOOPME_script\" src=\"https://loopme.me/lm.main.js?_=1445610079\" data-app-key=\"b510d5bcda\" data-delay=\"2000\"></script></div></body></html>";
	@Test
	public void driveRestAPI() {
		strB.append("<html><head><meta charset=").append("utf-8")
				.append("><meta name=").append("viewport").append("content=").append("initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0").append("><title>LoopMe</title></head><body><script>lmCampaigns = {").append("eventLinkTemplate").append(":").append("https://loopme.me/api/v2/events?et=__EVENT_TYPE__&rid=336de456-5cb1-4bc4-be8a-cc43056e6d29&meta=NDM4MjA6NDMwOTphZDNlMzYzYS1mOTQzLTQ0NjktOGFiYy05ZGM2N2RjZDYxZWE&id=336de456-5cb1-4bc4-be8a-cc43056e6d29&name=__CUSTOM_EVENT_NAME__").append(",").append("apiCreativesLink").append(":").append("https://loopme.me/ad/jsonp?callback=__CALLBACK__&id=336de456-5cb1-4bc4-be8a-cc43056e6d29&meta=NDM4MjA6NDMwOTphZDNlMzYzYS1mOTQzLTQ0NjktOGFiYy05ZGM2N2RjZDYxZWE&di=SBznzFTm_2aPbqoC7gaiJAL9UrSTa39pazka7h2KFS4eXwiqh1wk9gA1Eysvq0V4").append(",").append("requestId").append(":").append("336de456-5cb1-4bc4-be8a-cc43056e6d29")
				.append(",").append("ads").append(":[").append("336de456-5cb1-4bc4-be8a-cc43056e6d29").append("],").append("package_ids").append(":[").append("com.test").append("]};</script><script src=").append("");

		get("http://loopme.me/api/loopme/ads/v3?ak=b510d5bcda&ct=2&lng=ru&sv=4.2.0&av=14.1&mr=0&or=p&vt=ad3e363a-f943-4469-8abc-9dc67dcd61ea&carrier=25501")
				.then()
				.body("settings.format",
						equalTo("interstitial"))
				.body("settings.orientation",
						equalTo("landscape"))
				.body("settings.ad_refresh_time",
						equalTo("30"))
				.body("settings.ad_expiry_time",
						equalTo(3600))
				.body("script",
						equalTo(expectedScr));
	}

}
