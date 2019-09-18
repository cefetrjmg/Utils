package br.cefetrj.mg.bsi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Utils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static String dateToText(Date d) {
        return sdf.format(d);
    }

    public static Date textToDate(String d) throws ParseException {
        return sdf.parse(d);
    }

    public static String input(String msg) {
        return JOptionPane.showInputDialog(null, msg);
    }

    public static String input(String msg, String title) {
        return JOptionPane.showInputDialog(null, msg, title);
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
    

}
