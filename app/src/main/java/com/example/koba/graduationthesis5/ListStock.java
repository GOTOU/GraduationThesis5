package com.example.koba.graduationthesis5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by koba on 2017/01/22.
 */

public class ListStock {

/*    String[] items = {
            "premium.2ch.net",
            "microad.jp",
            "nend.net",
            "amoad.com",
            "adimg.net",
            "adingo.jp",
            "i-mobile.co.jp",
            "doubleclick.net",
            "spstaticimg.ameba.jp",
            "akamai.net",
            "ad-v.jp",
            "image.click.livedoor.com",
            "behaviad.net",
            "medibaad.com",
            "unthem.com",
            "i2i.jp",
            "iadsdk.apple.com",
            "iadc.qwapi.com",
            "ichi-ni-san.net",
            "app-adforce.jp",
            "kochava.com",
            "socdm.com",
            "adlantis.jp",
            "a8.net",
            "im.ov.yahoo.co.jp",
            "yads.yahoo.co.jp",
            "ads.yahoo.com",
            "maist.jp",
            "kau.li",
            "advg.jp",
            "zimg.jp",
            "zucks.net",
            "app-adfce.jp",
            "ad-stir.com",
            "mtburn.com",
            "astrsk.net",
            "ghnosy.com",
            "maist.jp",
            "iogous.com",
            "trax-ad.jp",
            "4clvr.jp",
            "formulas.jp",
            "iand2ch.net",
            "-ad.jp",
            "prism.pandora.tv",
            "adms-ad.com",
            "ad.gunosy.com",
            "adjust.com",
            "adtdp.com",
            "caprofitx.com",
            "conv.gunosy.com",
            "logs.gunosy.com",
            "platform.gunosy.com",
            "stimg.iand2ch.net",
            "stimgc.iand2ch.net",
            "blogsys.jp",
            "assys01.fc2.com",
            "media.fc2.com/counter",
            "i2ad.jp",
            "img.bb-chat.tv",
            "mediams.mb",
            "rubiconproject.com",
            "google-analytics.com",
            "yads.c.yimg.jp",
            "gsspcln.jp
    };

    ArrayList<String> list = new ArrayList<>(Arrays.asList(items));
*/
    private List<String> list = new ArrayList<>(Arrays.asList(
            "premium.2ch.net",
            "microad.jp",
            "nend.net",
            "amoad.com",
            "adimg.net",
            "adingo.jp",
            "i-mobile.co.jp",
            "doubleclick.net",
            "spstaticimg.ameba.jp",
            "akamai.net",
            "ad-v.jp",
            "image.click.livedoor.com",
            "behaviad.net",
            "medibaad.com",
            "unthem.com",
            "i2i.jp",
            "iadsdk.apple.com",
            "iadc.qwapi.com",
            "ichi-ni-san.net",
            "app-adforce.jp",
            "kochava.com",
            "socdm.com",
            "adlantis.jp",
            "a8.net",
            "im.ov.yahoo.co.jp",
            "yads.yahoo.co.jp",
            "ads.yahoo.com",
            "maist.jp",
            "kau.li",
            "advg.jp",
            "zimg.jp",
            "zucks.net",
            "app-adfce.jp",
            "ad-stir.com",
            "mtburn.com",
            "astrsk.net",
            "ghnosy.com",
            "maist.jp",
            "iogous.com",
            "trax-ad.jp",
            "4clvr.jp",
            "formulas.jp",
            "iand2ch.net",
            "-ad.jp",
            "prism.pandora.tv",
            "adms-ad.com",
            "ad.gunosy.com",
            "adjust.com",
            "adtdp.com",
            "caprofitx.com",
            "conv.gunosy.com",
            "logs.gunosy.com",
            "platform.gunosy.com",
            "stimg.iand2ch.net",
            "stimgc.iand2ch.net",
            "blogsys.jp",
            "assys01.fc2.com",
            "media.fc2.com/counter",
            "i2ad.jp",
            "img.bb-chat.tv",
            "mediams.mb",
            "rubiconproject.com",
            "google-analytics.com",
            "yads.c.yimg.jp",
            "gsspcln.jp" //せちがら速報のやつ　なぜか消えない

    ));

    public List<String> getList(){  //リストを呼び出すメソッド
        return list;
    }

    public void addList(String str){
        list.add(str);
    }

    public List<String> getRenewalList(){
        List<String> renewalList = list;
        return renewalList;
    }
}
