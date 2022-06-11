package it.unibs.fp.mylib.esameArnaldo;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Mappa {
    public static char[][] creaMappa(String filename){
        String tagCorrente="";
        char[][] mappa=new char [22][31];
        ArrayList<Character> riga=new ArrayList<Character> ();

        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        try{
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream (filename));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        try {
            int row=0,coll=0;
            while (xmlr.hasNext()){

                switch (xmlr.getEventType()) {
                    //--------------------------------
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Start Read Doc " + filename);
                        System.out.println("\nCaricamento in corso...");
                        break;
                    //--------------------------------
                    case XMLStreamConstants.START_ELEMENT:
                        if(xmlr.getLocalName().equals("row")) {
                            if(riga.size()==31) {
                                for(coll=0;coll<31;coll++) {
                                    mappa[row][coll]=riga.get(coll).charValue();
                                }
                                row++;
                            }

                            riga.clear();
                            ;
                        }
                        if(xmlr.getLocalName().equals("cell")) {
                            riga.add(' ');
                        }
                        tagCorrente=xmlr.getLocalName();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if(xmlr.getLocalName().equals("row")) {

                        }

                        if(xmlr.getLocalName().equals("mappa")) {
                            System.out.println("Dim di row alla fine: "+row );
                        }
                        break;
                    //--------------------------------
                    case XMLStreamConstants.CHARACTERS:
                        if (xmlr.getText().trim().length() > 0) {
                            String text=xmlr.getText();
                            switch(tagCorrente) {
                                case "cell":
                                    riga.set(riga.size()-1,text.charAt(0));
                                    break;
                            }
                        }
                        break;
                }


                xmlr.next();

            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        System.out.println("\nCaricamento completato!");
        return mappa;
    }
}
