package com.adserver;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.adserver.domain.AdRepository;
import com.adserver.domain.AdRecord;
import com.adserver.controllers.AdController;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdserverprojectApplicationTests {

    private AdRepository adRepository;
    private AdController adControllerMock;
    private AdRecord adRecord;

    @Before
    public void setUp() {
        //adRepositoryMock = Mockito.mock(AdRepository.class);
        adRepository = new AdRepository();
        adControllerMock = Mockito.mock(AdController.class);

    }


    @Test
	public void repositoryTests() {

        // Test that an ad campaign is added and retrieved using patner_id.
        AdRecord ad = new AdRecord();
        ad.setPartnerId("Partner_99");
        ad.setAdDuration(20);
        ad.setAdContent("Some test content");
        adRepository.addAd(ad);
        ad = null;
        ad = adRepository.getAd("Partner_99");
        assertEquals("Some test content", ad.getAdContent());
        assertNotEquals(0, ad.getMillisAdded()); // proves current time is added

	}

    @Test
    public void fetchNonExistentAdTest() {

        // Test that an ad campaign is added and retrieved using patner_id.
        AdRecord ad = new AdRecord();
        ad = adRepository.getAd("Partner_01");
        assertNull(ad);
    }

	@Test
	public void durationTest() {

		String query1 = "{\"partner_id\": \"Partner_1\",\"duration\":10,\"ad_content\":\"Now you can be your very own business owner...see how\"}";
		String query2 = "{\"partner_id\": \"Partner_1\",\"duration\":10,\"ad_content\":\"Now you can own a new Mercedes, cheap!\"}";



	}

}
