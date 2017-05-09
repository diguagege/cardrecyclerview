#首页卡片设计
## 1.首页卡片设计原因
>当前，许多app除了良好的用户体验之外，更重要的是需要丰富的内容，以及更强的用户黏性。作为工具app中的日活量居高的应用，就更应该具有更好的用户体验以及内容提供，而首页就首当其冲。
>根据以上的描述，我们需要拥有良好的运营能力来承载日常的运营。首页拥有快速迭代能力无疑是一个重要的环节，所以这就出现了首页卡片。

## 2. 首页卡片的设计思路
>为了使首页的运营能力更强，程序员的接入更加简易。所以首页卡片采用了XXXX设计模式。卡片框架实现了BaseCardAdapter, BaseCard, BaseCardItemViewHolder。使用者只需要在自己的Adapter继承BaseCardAdapter，实现自己业务相关信息就行。

### 2.1 首页卡片设计UML
UML图如下：
![](media/14942963421721/14943169387386.jpg)￼


### 2.2 首页卡片代码实现
####BaseCard类：
~~~
    ...
    
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
    ...
~~~
重点在于getViewHolderByType来区分不同卡片，从而获得不同的卡片显示效果。
####BaseCardAdapter
~~~
    ...
    public BaseCardItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        for (BaseCard card : mCards) {
            if (card.isTypeHere(viewType)) {
                return card.getViewHolderByType(parent, viewType);
            }
        }
        return null;
    }

    ...
    
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
        ...
        cardPositionOffset[0] = cardPosition;
        cardPositionOffset[1] = cardOffSet;
        return cardPositionOffset;
    }
~~~
从BaseCardAdapter中可以看出，子类只需要继承它并在子类中实现数据加载，并且new不同的Card出来（如2.1中的card1，card2），并调用addCard方法即可将方法添加至adapter中。
