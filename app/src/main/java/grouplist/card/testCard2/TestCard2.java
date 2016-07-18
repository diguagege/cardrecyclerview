package grouplist.card.testCard2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hanwei.cardrecyclerview.R;

import java.util.List;

import grouplist.cardbase.BaseCard;
import grouplist.cardbase.BaseCardItemViewHolder;
import grouplist.cardbase.CardUtils;

/**
 * Created by hanwei on 16-6-16.
 */
public class TestCard2 extends BaseCard{
    private List<?> mCardData;
    private LayoutInflater mInflater;
    private int mLocation;

    public TestCard2() {}

    public TestCard2(int location) {
        mLocation = location;
    }

    public TestCard2(int location, List<String> cardData) {
        mLocation = location;
        mCardData = cardData;
    }


    public TestCard2(List<String> cardData) {
        mCardData = cardData;
    }

    @Override
    public BaseCardItemViewHolder getHeaderViewHolder(ViewGroup parent) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(parent.getContext());
        }
        View view = mInflater.inflate(R.layout.mz_group_header2, parent, false);
        return new TestCardHeader2(view);
    }

    @Override
    public BaseCardItemViewHolder getItemViewHolder(ViewGroup parent) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(parent.getContext());
        }
        View view = mInflater.inflate(R.layout.mz_group_body2, parent, false);
        return new TestCardItem2(view);
    }

    @Override
    public int getHeaderType() {
        return CardUtils.TYPE_TEST_CARD2_HEADER;
    }

    @Override
    public int getItemType() {
        return CardUtils.TYPE_TEST_CARD2_ITEM;
    }

    @Override
    public List<?> getCardData() {
        return mCardData;
    }

    @Override
    public void setCardData(List<?> data) {
        mCardData = data;
    }

    @Override
    public int getCardsLocation() {
        return mLocation;
    }

    @Override
    public void setCardsLocation() {
        mLocation = 8;
    }
}
