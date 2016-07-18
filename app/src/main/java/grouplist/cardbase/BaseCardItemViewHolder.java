package grouplist.cardbase;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hanwei on 16-6-16.
 */
public abstract class BaseCardItemViewHolder extends RecyclerView.ViewHolder{
    public BaseCardItemViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindItem(BaseCardAdapter adapter, Object cardItem, int position);
}
