package it.edenred.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import it.edenred.bean.Affiliato;
import it.edenred.bean.Menu;
import it.edenred.bean.Paese;
import it.edenred.mybatis.DBConnection;
import it.edenred.mybatis.EdenredMapper;

import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
 
public class EdenredClient {
	
	public static SqlSession accesMyBatis() throws IOException {
        String resource = "it/edenred/mybatis/config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
 
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);
        
        SqlSession session = factory.openSession();	
        return session;
	}
	
	public Affiliato[] getAffiliati(String localita) throws IOException {
    	SqlSession session = null;
    	Affiliato[] affiliati = null; 
    	try {
            session = accesMyBatis();     
        	System.out.println("LOCALITA: " + localita);               
        	EdenredMapper mapper = session.getMapper(EdenredMapper.class);
        	
            Map<String, Object> vMap = new HashMap<String, Object>();

            vMap.put("localita", localita);   
            
            mapper.getAffiliati(vMap);
            affiliati = ((List<Affiliato>) vMap.get("affiliati")).toArray(new Affiliato[0]);
        	
//            for (Affiliato affiliato:affiliati) {
//            	System.out.println("Cod affiliato: " +affiliato.getCodAffiliato() + ", indirizzo: " +affiliato.getIndirizzoLocale() 
//            		+ ", nome: " +affiliato.getNomeLocale() + ", telefono: " +affiliato.getTelefono());
//            }
        } finally {
            session.close();
        }
		return affiliati;		
	}
	
	public Paese[] getPaesi() throws Exception {
    	SqlSession session = null;
    	Paese[] paesi = null;
    	try {
            session = accesMyBatis();     
        	EdenredMapper mapper = session.getMapper(EdenredMapper.class);
            paesi = mapper.getPaesi();
            
        } finally {
            session.close();
        }
		return paesi;		
	} 
	
//	public void insertAffiliato(String codAffiliato, String nomeLocale, String localita, String indirizzoLocale) throws IOException {
//    	SqlSession session = null;
//    	try {
//            session = accesMyBatis();     
//        	System.out.println("LOCALITA: " + localita);               
//        	EdenredMapper mapper = session.getMapper(EdenredMapper.class);
//            mapper.insertAffiliato(codAffiliato, nomeLocale, localita, indirizzoLocale);
//        } finally {
//            session.close();
//        }	
//	}	
//	
//	
//	
    public static void main(String[] args) throws Exception {
    	
    	EdenredClient edenredClient = new EdenredClient();
    	Affiliato[] affiliati = edenredClient.getAffiliati("TORINO");
    	for (Affiliato affiliato:affiliati) {
    		System.out.println(affiliato.getNomeLocale());
    	}    	
    	
    	
 //   	edenredClient.insertAffiliato("2", "BAR ALEX 2", "MONTE CARLO", "MONEY STREET 2");

//    	Paese[] paesi = edenredClient.getPaesi();
//		for(int i=0; i<paesi.length; i++) {
//			System.out.println(paesi[i].getPaese());
//		}
    	/*String SQL = "Update ACCESS$ SET D_OBJ# = ? WHERE ORDER# = ?";
 	   pstmt = conn.prepareStatement(SQL);
 	   pstmt.setString(1, "111"); 
 	   pstmt.setString(2, "1"); 
 	   int rows = pstmt.executeUpdate();
 	   System.out.println("Rows impacted : " + rows );*/        
        
     /*     Connection conn = DBConnection.connect();
          BufferedReader br = new BufferedReader(new FileReader("DIM_ANAGRAFICA_AFFILIATI_Copy2.txt"));
        try {
            String line = "";
            int j = 0;
            while (line != null) {
            	System.out.println("linia" + j);
                line = br.readLine();
                String[] fields = line.split(",",69);
                if (fields[10].equals("BOLZANO")) {
	         	    String insertTableSQL = "INSERT INTO R_DIM_ANAGRAFICA_AFFILIATI"
	         				+ "(COD_AFFILIATO, RAGIONE_SOCIALE, CODICE_FISCALE, PARTITA_IVA, TOPONIMO_SOCIETA, INDIRIZZO_SOCIETA, CIVICO_SOCIETA, INDIRIZZO_SOCIETA_COMPLETO, CAP_SOCIETA, LOCALITA_AGGIUNTIVA_SOCIETA, LOCALITA_SOCIETA, PROVINCIA_SOCIETA, REFERENTE, TELEFONO, CELLULARE, DATA_CREAZIONE_ANAGRAFICA, DATA_APERTURA, NOME_LOCALE, TOPONIMO_LOCALE, INDIRIZZO_LOCALE, CIVICO_LOCALE, INDIRIZZO_LOCALE_COMPLETO, CAP_LOCALE, LOCALITA_AGGIUNTIVA_LOCALE, FRAZIONE_LOCALE, LOCALITA_DEL_LOCALE, PROVINCIA_LOCALE, REGIONE_LOCALE, INTERLOCUTORE, TELEFONO_LOCALE, NUMERO_POSTI_LOCALE, GIORNI_CHIUSURA_LOCALE, COD_LICENZA_COMMERC, DESCRIZIONE_LICENZA, TIPO_CESSIONE, TIPOLOGIA_LICENZA, COD_TIPO_LICENZA_COMMERC, TIPO_LICENZA_COMMERC, CELIACI, GRUPPO_FATTURAZIONE, GRUPPO_SOCIETARIO, DESCRIZIONE_GRUPPO_SOCIETARIO, DATA_RICONTRATTUALIZ, DATA_CESSAZIONE, COD_TIPO_CHIUSURA, DESCR_TIPO_CHIUSURA, NOTA_DEBITO_CLIENTE, EROGAZIONE_SERVIZIO, XDEFX, YDEFX, YDEFX_GRADI, XDEFX_GRADI, QUALITY_GEO, TOPO, TIPO_GARA, COD_CONDIZIONE_PAGAMENTO, DESCR_TIPO_PAGAMENTO, SCONTO_PAGAM_ACCEL, TERMINALE_POS, DATA_ULTIMA_TRANSAZIONE, EMAIL_CIRC, EMAIL_DOC_AMMI, EMAIL_PREFATTURE, EMAIL_AVVISI_BONIFICO, FAX_CIRC, FAX_DOC_AMMI, FAX_PREFATTURE, FAX_AVVISI_BONIFICO) VALUES"
	         				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	         		PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
	         		for (int i=1; i<=68; i++) {          	   
	                       	preparedStatement.setString(i, fields[i-1]);
	                	System.out.println(i + ": " + fields[i-1]);
	                }
	        		preparedStatement.executeUpdate(); 
                } 
        		j++;
             }
        } finally {
            br.close();
        }   */
    }


}
