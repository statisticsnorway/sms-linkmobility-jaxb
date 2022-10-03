package no.ssb.linkmobility.jaxb;

import no.ssb.linkmobility.jaxb.request.MSG;
import no.ssb.linkmobility.jaxb.request.MSGLST;
import no.ssb.linkmobility.jaxb.request.ObjectFactory;
import no.ssb.linkmobility.jaxb.request.SESSION;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

/**
 * Created by lrb on 08.03.2016.
 */
@RunWith(JUnit4.class)
public class TestUnmarshalMarshal {
    @Before
    public void before(){
        Properties props = System.getProperties();
        props.setProperty("javax.xml.accessExternalDTD", "all");
    }
    @Test
    public void testUnmarshalXmlRequest() throws JAXBException {
        ObjectFactory of = new ObjectFactory();
        JAXBContext jc = JAXBContext.newInstance(of.createSESSION().getClass() );
        Unmarshaller u = jc.createUnmarshaller();
        SESSION session = (SESSION) u.unmarshal(new File("src/test/resources/request.xml"));
        Assert.assertEquals(session.getMSGLST().getMSG().size(),2);
        MSG msg = session.getMSGLST().getMSG().get(0);
        Assert.assertEquals(msg.getRCV(),"4793000000");
    }

    @Test
    public void testMarshal()throws JAXBException{
        ObjectFactory of = new ObjectFactory();
        SESSION session = of.createSESSION();
        session.setCLIENT("demo");
        session.setPW("password");
        MSGLST msglst = of.createMSGLST();
        MSG msg1 = of.createMSG();
        msg1.setTEXT("Test message1");
        msg1.setRCV("4793000000");
        MSG msg2 = of.createMSG();
        msg2.setTEXT("Test message2");
        msg2.setRCV("4793000000");
        msglst.getMSG().add(msg1);
        msglst.getMSG().add(msg2);
        session.setMSGLST(msglst);

        JAXBContext jc = JAXBContext.newInstance(of.createSESSION().getClass() );
        java.io.StringWriter sw = new StringWriter();
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
        marshaller.marshal(session, sw);
        System.out.println(sw.toString());
    }

    @Test
    public void TestUnmarshalXmlResponse() throws JAXBException {
        no.ssb.linkmobility.jaxb.response.ObjectFactory of = new no.ssb.linkmobility.jaxb.response.ObjectFactory();
        JAXBContext jc = JAXBContext.newInstance(of.createSESSION().getClass() );
        Unmarshaller u = jc.createUnmarshaller();
        no.ssb.linkmobility.jaxb.response.SESSION session = (no.ssb.linkmobility.jaxb.response.SESSION) u.unmarshal(new File("src/test/resources/response.xml"));
        Assert.assertEquals(session.getMSGLST().getMSG().size(),2);
        no.ssb.linkmobility.jaxb.response.MSG msg = session.getMSGLST().getMSG().get(0);
        Assert.assertEquals(msg.getID(),"Digikorr-4799594665");
        Assert.assertEquals(msg.getSTATUS(),"OK");
    }
//
//
// OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!
// OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!
// OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!OBSOBSOBSOBS!!!!v
// DENNE SENDER FAKTISK SMS!!
// DENNE SENDER FAKTISK SMS!!
// DENNE SENDER FAKTISK SMS!!
// DENNE SENDER FAKTISK SMS!!

    @Ignore
    public void reallySendSMS() throws JAXBException {
        ObjectFactory of = new ObjectFactory();
        SESSION session = of.createSESSION();
        session.setSD("Unik_id_for_denne_batchen_"+ new Random().nextInt());
        session.setCLIENT("stsdemo");
        session.setPW("KCk8jbHTn");
        MSGLST msglst = of.createMSGLST();
        MSG msg1 = of.createMSG();
        msg1.setTEXT("Hei Lars-Roger");
        msg1.setRCV("4799594665");
        msg1.setSND("SSB");
        msg1.setID("Digikorr-4799594665");
        MSG msg2 = of.createMSG();
        msg2.setTEXT("Hei Jim!");
        msg2.setRCV("4791392812");
        msg2.setID("Digikorr-4791392812");
        msg2.setSND("SSB");
        msglst.getMSG().add(msg1);
        msglst.getMSG().add(msg2);
        session.setMSGLST(msglst);

        JAXBContext jc = JAXBContext.newInstance(of.createSESSION().getClass() );
        java.io.StringWriter sw = new StringWriter();
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
        marshaller.marshal(session, sw);

        String xml = sw.toString();
        HttpURLConnection connection = null;
        try {

            URL url = new URL("https://xml.pswin.com");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/xml");

            connection.setRequestProperty("Content-Length", "" +
                    Integer.toString(xml.getBytes().length));

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(xml);
            wr.flush();
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            System.out.println(response.toString());
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            if(connection != null) {
                connection.disconnect();
            }
        }
    }
}
