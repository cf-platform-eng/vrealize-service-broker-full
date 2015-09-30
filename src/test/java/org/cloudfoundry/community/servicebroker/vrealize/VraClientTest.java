package org.cloudfoundry.community.servicebroker.vrealize;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.cloudfoundry.community.servicebroker.exception.ServiceBrokerException;
import org.cloudfoundry.community.servicebroker.model.Catalog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
public class VraClientTest {

	@Autowired
	private VraClient client;

	@Autowired
	TokenService tokenService;

	@Test
	public void testGetAllCatalog() throws ServiceBrokerException {
		String token = tokenService.getToken();
		// System.out.println(token);
		assertNotNull(token);
		Catalog c = client.getAllCatalogItems(token);
		assertNotNull(c);
		assertEquals(17, c.getServiceDefinitions().size());
	}

	@Test
	public void testGetEntitledCatalog() throws ServiceBrokerException {
		String token = tokenService.getToken();
		// System.out.println(token);
		assertNotNull(token);
		Catalog c = client.getAllCatalogItems(token);
		assertNotNull(c);
	}
}
