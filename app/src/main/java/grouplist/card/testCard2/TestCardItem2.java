package grouplist.card.testCard2;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.hanwei.cardrecyclerview.R;

import grouplist.cardbase.BaseCardAdapter;
import grouplist.cardbase.BaseCardItemViewHolder;

/**
 * Created by hanwei on 16-6-16.
 */
public class TestCardItem2 extends BaseCardItemViewHolder {
    private View mItemView;
    private TextView textView;
    public TestCardItem2(View itemView) {
        super(itemView);
        mItemView = itemView;
        textView = (TextView) itemView.findViewById(R.id.textBody);
    }

    @Override
    public void bindItem(BaseCardAdapter adapter, Object cardItem, final int position) {
        mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("This is card 2, and position is : " + position);
            }
        });
    }
}
