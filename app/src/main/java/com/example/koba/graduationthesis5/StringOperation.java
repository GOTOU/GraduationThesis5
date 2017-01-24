package com.example.koba.graduationthesis5;

import android.util.Log;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.List;

/**
 * Created by koba on 2017/01/11.
 */
public class StringOperation {  //受け取ったhtmlやらjsをマッチングして削除するためのクラス

    ListStock listStock = new ListStock();

    public String removeAds(String str){ //scriptタグの中身のjavascriptの文字列中にあるURLを抽出、広告と思わしきURLの削除もしくはreplace
//        Log.d("Debug", "str : "+str);

        List<String> list = listStock.getList();
        String result = str;


        for (String item : list) {
            final Pattern urlPattern = Pattern.compile("(http://|https://){1}[\\w\\.\\-/:\\#\\?\\=\\&\\;\\%\\~\\+]+", Pattern.CASE_INSENSITIVE);
            Matcher matcher = urlPattern.matcher(result);
            result = matcher.replaceAll("");

        }


//        Log.d("Debug", "result: "+result);
        return result;
    }


    public boolean isMatchOrNot(String str){  //iframe,ins,aなどのタグを削除するためのメソッド

        String urls = "(";

        for (String url : listStock.getList()) {
            urls = urls + url + "|";
        }
        String url_pattern = urls.substring(0, urls.length()-1);  //url_patternにはlistの全ての項目が入っている
        url_pattern += ")";


        final Pattern urlPattern = Pattern.compile(url_pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = urlPattern.matcher(str);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }

    }

}