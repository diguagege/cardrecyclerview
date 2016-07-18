package grouplist.cardbase;

import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hanwei on 16-6-15.
 */
public abstract class BaseCard {
    public abstract BaseCardItemViewHolder getHeaderViewHolder(ViewGroup parent);
    public abstract BaseCardItemViewHolder getItemViewHolder(ViewGroup parent);
    // 获取Header的Type
    public abstract int getHeaderType();
    // 获取Item的Type
    public abstract int getItemType();
    // 卡片数据
    public abstract List<?> getCardData();
    public abstract void setCardData(List<?> data);
    // 卡片位于所有卡片的下标位置
    public abstract int getCardsLocation();
    // 设置卡片的位置
    public abstract void setCardsLocation();

    public int getCardSize() {
        return getCardData() != null || getCardData().size() > 0 ? getCardData().size() : 0;
    }

    // 获取当前指向的item的type
    public int getCurrentItemType(int offset) {
        if (offset == 0) {
            return getHeaderType();
        } else {
            return getItemType();
        }
    }

    public boolean isTypeHere(int type) {
        if (type == getHeaderType() || type == getItemType()) {
            return  true;
        }
        return false;
    }

    public BaseCardItemViewHolder getViewHolderByType(ViewGroup parent, int type) {
        if (type == getHeaderType()) {
            return getHeaderViewHolder(parent);
        } else if (type == getItemType()) {
            return getItemViewHolder(parent);
        }
        return null;
    }
}
