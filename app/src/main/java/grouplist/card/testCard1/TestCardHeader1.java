package grouplist.card.testCard1;

import android.view.View;

import grouplist.cardbase.BaseCardAdapter;
import grouplist.cardbase.BaseCardItemViewHolder;

/**
 * Created by hanwei on 16-6-16.
 */
public class TestCardHeader1 extends BaseCardItemViewHolder{
    private View mItemView;
    public TestCardHeader1(View itemView) {
        super(itemView);
        mItemView = itemView;
    }

    @Override
    public void bindItem(BaseCardAdapter adapter, Object cardItem, int position) {
            
    }
}
