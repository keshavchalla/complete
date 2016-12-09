package hello.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class CISXMLParser {

	private Jaxb2Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public void setMarshaller(Jaxb2Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public void marshal(String fileName, Object graph) throws IOException {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileName);
			try {
				marshaller.marshal(graph, new StreamResult(fos));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			fos.close();
		}
	}

	public Object unmarshal(String fileName) throws IOException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileName);
			return unmarshaller.unmarshal(new StreamSource(fis));
		} finally {
			fis.close();
		}
	}
}
