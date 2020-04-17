package com.company;

import java.util.regex.*;

public class Main {

    public static void main(String[] args) {

	// Работа со строками и регулярными выражениями

        // Строковые литералы

        String str = "bmstu";

        // С помощью конструктора

        String str1 = new String("hello");

        // Стровки в java - immutable - неизменяемые

        //Можно задать строку массивом символов

        char[] array_str = {'b','m','s','t','u'};

        String str2 = new String(array_str);

        //StringBuffer
        //StringBuilder

        String a1 = new String("Moscow");
        String a2 = new String("Moscow");
        System.out.println(a1.equals(a2));

        String m1 = "Moscow";
        String m2 = "Moscow";
        System.out.println(m1==m2);

        String abc = "adfgadfgadfg";
        int legnth = abc.length();
        char searchChar = 'f';
        for(int i=0;i<legnth;i++) {
            if(abc.charAt(i) == searchChar) {
                // первое вхождение
                break;
            }
        }

        // concat
        // + +=

        String str3 = "bmstu".concat(".ru").concat("/url2020").concat("/1234test");

        // +

        String s1 = "bmstu";
        String s2 = ".ru";

        String s3 = s1 + s2;

        String s4 = new StringBuilder().append(s1).append(s2).toString();

        // Метод concat лучше использовать только если нужно сделать слияение один раз

        String word = "school";
        String word2 = word.replace('l','d');

        StringBuilder builder = new StringBuilder("build");
        builder.replace(0,1,"d");

        String formatString = "double var (%f), string val (%s), integer val (%d)";
        System.out.println(String.format(formatString,2.3,"ttt",10));

        String v1 = "hello";
        String v2 = "Ivan";

        System.out.println(String.join(",",v1,v2));

        int a = 10;
        String a_val = Integer.toString(a);

        String b_val = "1000";
        int b = Integer.valueOf(b_val);


       // StringBuffer - потокобезопасный
        // StringBuilder - лучше использовать в приложениях без потоков

        String domain = ".ru";
        StringBuffer buffer = new StringBuffer("bmstu");

        buffer.append(domain);
        buffer.delete(buffer.length()-domain.length(),buffer.length()); // "bmstu"
        buffer.insert(buffer.length(),domain); // "bmstu.ru"


        System.out.println("-------------------------------------------------------------------------");

        // Pattern - шаблон по которому осуществляется поиск
        // Matcher - совпадение


         // ^ Начало строки
        // $ Конец строки
        // . любой символ
        // * 0 или более раз

        Pattern p = Pattern.compile("^bmstu.*");
        Matcher m = p.matcher("gbmstudfghdfgh");
        System.out.println(m.matches());


        Pattern p1 = Pattern.compile(".+\\.(com|ru|org)");
        Matcher m3 = p1.matcher(".org");
        System.out.println(m3.matches());

        Pattern p2 = Pattern.compile("^[^a-c]*");
        Matcher m4 = p2.matcher("ahjk");
        System.out.println(m4.matches());

        // Pattern p3 = Pattern.compile("\\#([a-fA-F]|[0-9]){6}");
        Pattern p3 = Pattern.compile("\\#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})");
        Matcher m5 = p3.matcher("#ff00");
        System.out.println(m5.matches());

        // 7-925-333-4400

        String text = "Егор Алла Александр";

        // жадный
        Pattern pattern = Pattern.compile("А.+а");
        Matcher matcher =pattern.matcher(text);
        while(matcher.find()) {
            System.out.println(text.substring(matcher.start(),matcher.end()));
        }

        // ленивый
        Pattern pattern2 = Pattern.compile("А.+?а");
        Matcher matcher2 =pattern2.matcher(text);
        while(matcher2.find()) {
            System.out.println(text.substring(matcher2.start(),matcher2.end()));
        }





	}
}
