package com.webApp.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlUtils {

    @SuppressWarnings("unchecked")
    public static synchronized  <T> T unmarshalBeen(Class<T> classesToBeBound,final String path){
        try {
            JAXBContext jc = JAXBContext.newInstance(classesToBeBound);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new NullPointerException();
        }
    }

    public static synchronized void marshalBeen(Object been, Class<?> classesToBeBound,final String path){
        try {
            JAXBContext jc = JAXBContext.newInstance(classesToBeBound);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(been, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
