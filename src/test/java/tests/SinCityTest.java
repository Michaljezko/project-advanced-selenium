package tests;

import Base.TestBase;
import enumerators.SinType;
import models.Sin;
import org.junit.Test;
import pages.SinCityPage;

import java.util.ArrayList;
import java.util.List;

public class SinCityTest extends TestBase {

    @Test
    public void testNewSin(){

        Sin spiderSin = new Sin("zabil som pavuka", "michal", "zabil som ho lopatou");
        SinCityPage sinCityPage = new SinCityPage();
        List<SinType> spiderSinTags = new ArrayList<SinType>();
        spiderSinTags.add(SinType.MURDER);
        spiderSinTags.add(SinType.ROBBERY);
        spiderSin.setTags(spiderSinTags);

        sinCityPage.openPage();
        sinCityPage.fillSinInformation(spiderSin);
        sinCityPage.markTag(spiderSin.getTags());
        sinCityPage.confessSin();
//        sinCityPage.openSinDetail(spiderSin);
//        sinCityPage.checkSinStatus(spiderSin);
    }
}
