package grouplist.card.testCard1;

import android.view.View;
import android.widget.TextView;

import com.example.hanwei.cardrecyclerview.R;

import grouplist.cardbase.BaseCardAdapter;
import grouplist.cardbase.BaseCardItemViewHolder;

/**
 * Created by hanwei on 16-6-16.
 */
public class TestCardItem1 extends BaseCardItemViewHolder {
    private View mItemView;
    private TextView textView;
    public TestCardItem1(View itemView) {
        super(itemView);
        mItemView = itemView;
        textView = (TextView) itemView.findViewById(R.id.textBody);
    }

    @Override
    public void bindItem(BaseCardAdapter adapter, final Object cardItem, final int position) {
        mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Card 1 position is : " + position + " and Data is : " + cardItem.toString());
            }
        });
    }
}
