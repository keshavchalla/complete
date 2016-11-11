package hello.util;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.Marshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import hello.util.CISXMLParser;

@Configuration
public class CISAppConfig {

	@Bean
	public CISXMLParser getHandler() {
		CISXMLParser handler = new CISXMLParser();
		handler.setMarshaller(getCastorMarshaller());
		handler.setUnmarshaller(getCastorMarshaller());
		return handler;
	}

	@Bean
	public Jaxb2Marshaller getCastorMarshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		String[] packagesToScan = { "hello.model", "hello.util" };
		jaxb2Marshaller.setPackagesToScan(packagesToScan);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jaxb.formatted.output", true);
		jaxb2Marshaller.setMarshallerProperties(map);
		return jaxb2Marshaller;
	}

}