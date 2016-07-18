package grouplist;

import android.os.Handler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import grouplist.card.testCard1.TestCard1;
import grouplist.card.testCard2.TestCard2;
import grouplist.cardbase.BaseCard;
import grouplist.cardbase.BaseCardAdapter;
import grouplist.cardbase.CardHelper;

/**
 * Created by hanwei on 16-6-16.
 */
public class TestBaseCardAdapter extends BaseCardAdapter {
    private Handler mHandler = new Handler();
    public TestBaseCardAdapter() {
        init();
    }

    public void init() {


        final List<String> list1 = new ArrayList<>();
        final List<String> list2 = new ArrayList<>();
        final List<BaseCard> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list1.add("Hello World : " + i);
            list2.add("Not Hello : " + i);
        }


        final CardHelper cardHelper = new CardHelper();
        refreshCards(cardHelper.getCardCollecitons(new TestCard2(4, list2)));

        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshCards(cardHelper.getCardCollecitons(new TestCard1(7, list1)));
                    }
                }, 4000);
            }
        }).start();

    }
}
