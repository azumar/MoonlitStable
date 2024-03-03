///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package moonlit.edupl.message.impl;
//
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.ejb.Asynchronous;
//import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.event.Observes;
//import javax.inject.Named;
//import moonlit.edupl.account.config.AbstractMessageConfig;
//import moonlit.edupl.account.data.UserAccount;
//import moonlit.edupl.message.interfaces.IMessageManager;
//import moonlit.edupl.validation.controller.AccountCreationEvent;
//
///**
// *
// * @author umar_
// */
//
//@Named
//@ApplicationScoped
//public class UKTextNotifier  implements IMessageManager{
//     private final String USER_AGENT = "Mozilla/5.0";
// @Asynchronous
//    @Override
//    public void sendNotification(UserAccount messageReceiver, AbstractMessageConfig message) {
//         try {
//            URL url = new URL("http://api-mapper.clicksend.com/http/v2/send.php");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//
//            Map<String, String> parameters = new HashMap<>();
//             parameters.put("method", "http");
//            parameters.put("username", "azumar");
//            parameters.put("key", "D62BDE40-A408-9690-AC2A-BAAA8F739214");
//            parameters.put("to", messageReceiver.getTelephone());
////            parameters.put("from", "EduPL");
//            parameters.put("message", message.getContent());
////            parameters.put("ref", "112233");
////             parameters.put("maxsplit", "5");
////            parameters.put("delay", "15");
//       
//            con.setDoOutput(true);
//            DataOutputStream out = new DataOutputStream(con.getOutputStream());
//            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
//            out.flush();
//            out.close();
//            int status = con.getResponseCode();
//            System.out.println("RESPONSE: "+ status);
//             System.out.println("BA MATSALA");
//        } catch (Exception ex) {
//           
//            System.out.println("AKWAI MATSALA");
//        }
//    }
//    
////@Asynchronous
//    @Override
//    public void sendNotification(@Observes AccountCreationEvent event) {
//        try {
//            URL url = new URL("http://api-mapper.clicksend.com/http/v2/send.php");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//
//            Map<String, String> parameters = new HashMap<>();
//             parameters.put("method", "http");
//            parameters.put("username", "azumar");
//            parameters.put("key", "D62BDE40-A408-9690-AC2A-BAAA8F739214");
//            parameters.put("to", event.getUserAccount().getTelephone());
////            parameters.put("from", "EduPL");
//            parameters.put("message", event.getAccountMessage().getContent());
////            parameters.put("ref", "112233");
////             parameters.put("maxsplit", "5");
////            parameters.put("delay", "15");
//       
//            con.setDoOutput(true);
//            DataOutputStream out = new DataOutputStream(con.getOutputStream());
//            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
//            out.flush();
//            out.close();
//            int status = con.getResponseCode();
//            System.out.println("RESPONSE: "+ status);
//             System.out.println("BA MATSALA");
//        } catch (Exception ex) {
//           
//            System.out.println("AKWAI MATSALA");
//        }
//    }
//
//  
//}
