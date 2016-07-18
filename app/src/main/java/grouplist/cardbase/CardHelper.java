package grouplist.cardbase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by hanwei on 16-6-20.
 */
public class CardHelper {
    private Map<Integer, BaseCard> mMap;
    public CardHelper() {
        initMap();
    }

    /**
     * 对单张卡片进行排序处理（注：卡片一定在初始化调用此方法前有数据）
     * @param cardHolder
     * @return
     */
    public List<BaseCard> getCardCollecitons(BaseCard cardHolder) {
        if (mMap == null) {
            initMap();
        }
        mMap.put(cardHolder.getCardsLocation(), cardHolder);
        List<BaseCard> cards = new ArrayList<>();
        Set<Integer> keySet = mMap.keySet();
        Iterator<Integer> iter = keySet.iterator();
        while (iter.hasNext()) {
            Integer key = iter.next();
            BaseCard card = mMap.get(key);
            cards.add(card);
        }
        if (cards != null && cards.size() > 0)
            return cards;

        return null;
    }

    public List<BaseCard> getCardCollecitons(List<BaseCard> cardHolders) {
        if (mMap == null) {
            initMap();
        }
        List<BaseCard> cards = new ArrayList<>();
        for (BaseCard cardHolder : cardHolders) {
            mMap.put(cardHolder.getCardsLocation(), cardHolder);
            Set<Integer> keySet = mMap.keySet();
            Iterator<Integer> iter = keySet.iterator();
            while (iter.hasNext()) {
                Integer key = iter.next();
                BaseCard card = mMap.get(key);
                cards.add(card);
            }
        }
        if (cards != null && cards.size() > 0)
            return cards;

        return null;
    }

    private void initMap() {
        mMap = new TreeMap<Integer, BaseCard>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer lhs, Integer rhs) {
                        return lhs.compareTo(rhs);
                    }
                });
    }
}
