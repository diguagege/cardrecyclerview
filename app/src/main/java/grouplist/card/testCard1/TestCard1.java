package grouplist.card.testCard1;

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
public class TestCard1 extends BaseCard{
    private List<?> mCardData;
    private LayoutInflater mInflater;
    private int mLocation;
    public TestCard1() {

    }

    public TestCard1(int location) {
        mLocation = location;
    }

    public TestCard1(List<String> cardData) {
        mCardData = cardData;
    }

    public TestCard1(int location, List<String> cardData) {
        mLocation = location;
        mCardData = cardData;
    }

    @Override
    public BaseCardItemViewHolder getHeaderViewHolder(ViewGroup parent) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(parent.getContext());
        }
        View view = mInflater.inflate(R.layout.mz_group_header, parent, false);
        return new TestCardHeader1(view);
    }

    @Override
    public BaseCardItemViewHolder getItemViewHolder(ViewGroup parent) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(parent.getContext());
        }
        View view = mInflater.inflate(R.layout.mz_group_body, parent, false);
        return new TestCardItem1(view);
    }


    @Override
    public int getHeaderType() {
        return CardUtils.TYPE_TEST_CARD1_HEADER;
    }

    @Override
    public int getItemType() {
        return CardUtils.TYPE_TEST_CARD1_ITEM;
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
        mLocation = 2;
    }
}
