package grouplist.cardbase;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hanwei on 16-6-15.
 */
public class BaseCardAdapter extends RecyclerView.Adapter<BaseCardItemViewHolder>{
    private List<BaseCard> mCards;
    private Object mCardItem;
    @Override
    public BaseCardItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        for (BaseCard card : mCards) {
            if (card.isTypeHere(viewType)) {
                return card.getViewHolderByType(parent, viewType);
            }
        }
        return null;
    }

    public void refreshCards(List<BaseCard> cards) {
        if (cards != null && cards.size() > 0) {
            mCards = cards;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        int itemCount = 0;
        for (BaseCard card : mCards) {
            itemCount += card.getCardSize() + 1;
        }
        return itemCount;
    }

    @Override
    public void onBindViewHolder(BaseCardItemViewHolder holder, int position) {
        holder.bindItem(this, mCardItem, position);
    }

    @Override
    public int getItemViewType(int position) {
        if(mCards != null || mCards.size() > 0) {
            int[] cardPositionOffset = getCardPositionOffset(position);
            BaseCard card = mCards.get(cardPositionOffset[0]);
            if (cardPositionOffset[1] != 0) {
                mCardItem = card.getCardData().get(cardPositionOffset[1] - 1);
            }
            return card.getCurrentItemType(cardPositionOffset[1]);
        } else {
            return 0;
        }
    }

    /**
     * 获取当前item所在卡片位置
     * @param position
     * @return item所在卡片位置
     */
    private int[] getCardPositionOffset(int position) {
        int[] cardPositionOffset = new int[2];
        // 记录该卡片是第几张卡片
        int cardPosition = 0;
        // 记录item在卡片中的偏移值
        int cardOffSet = 0;
        int itemCount = 0;
        for (BaseCard card : mCards) {
            itemCount += card.getCardSize() + 1;
            if (position < itemCount) {
                if (cardPosition == 0) {
                    cardOffSet = position;
                }
                break;
            }
            cardOffSet = position - itemCount;
            if (cardOffSet < 0) {
                cardOffSet = 0;
            }
            cardPosition++;
        }
        cardPositionOffset[0] = cardPosition;
        cardPositionOffset[1] = cardOffSet;
        return cardPositionOffset;
    }
}
