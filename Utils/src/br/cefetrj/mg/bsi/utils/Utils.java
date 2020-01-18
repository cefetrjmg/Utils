package br.cefetrj.mg.bsi.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *@author Cristian Madeira de Souza Pereira
 */
public class Utils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     
     * @param d Date that will be converted
     * @return String
     */
    public static String dateToText(Date d) {
        return sdf.format(d);
    }

    public static Date textToDate(String d) throws ParseException {
        return sdf.parse(d);
    }

    public static String input(String msg) {
        return JOptionPane.showInputDialog(null, msg);
    }

    public static String input(String msg, String initialSelectionValue) {
        return JOptionPane.showInputDialog(null, msg, initialSelectionValue);
    }

    public static void print(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public static void print(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void print(String msg, String title, boolean status) {
        JOptionPane.showMessageDialog(null, msg, title, (status ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE));
    }

    public static int confirm(String msg, String title) {
        return JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.YES_NO_OPTION);
    }
    public static String printf(String msg, Object ...args){
        return String.format(msg,args);
    }
    
    /**
     * @param params is variable of map(String,String) type 
     * @return is a return of byte array
     */
    public static byte[] mapToBytes(Map<String, String> params) {
        try {
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, String> param : params.entrySet()) {

                if (postData.length() != 0) {
                    postData.append('&');
                }

                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
            return postDataBytes;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
