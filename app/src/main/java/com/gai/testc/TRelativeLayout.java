package com.gai.testc;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with Android Studio.
 * User: gai
 * Date: 16/6/11
 * Time: 下午11:39
 */

public class TRelativeLayout extends RelativeLayout implements ItemAdapter.OnDataChangedListener {

    private ItemAdapter mTagAdapter;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    private LinkedHashMap<String, Integer> viewId;
    private MotionEvent mMotionEvent;

    public TRelativeLayout(Context context) {
        this(context, null);
    }

    public TRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        viewId = new LinkedHashMap<>();
    }


    public void setmTagAdapter(ItemAdapter mTagAdapter) {
        this.mTagAdapter = mTagAdapter;
        mTagAdapter.setOnDataChangedListener(this);
        changeAdapter();


    }

    private void changeAdapter() {
        removeAllViews();
        ItemAdapter adapter = mTagAdapter;
        for (int i = 0; i < adapter.getCount(); i++) {
            TextView view= (TextView) adapter.getView(this,i);
            int id=0;
            Item tagView = (Item) adapter.getItem(i);
            view.setText(tagView.getTag());
            if (!viewId.containsKey(tagView.getTag())) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    id=generateViewId();
                    viewId.put(tagView.getTag(), id);



                } else {
                    for (; ; ) {
                        final int result = sNextGeneratedId.get();
                        // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
                        int newValue = result + 1;
                        if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
                        if (sNextGeneratedId.compareAndSet(result, newValue)) {
                            viewId.put(tagView.getTag(), result);
                            id=result;
                        }
                    }
                }

            }
            view.setId(id);
            LayoutParams lp1 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            Log.i("id",viewId.toString());
            Log.i("LEFT_OF",(viewId.get(tagView.getLeftof())!=null?viewId.get(tagView.getLeftof()):0)+"");
            Log.i("RIGHT_OF",(viewId.get(tagView.getRightof())!=null?viewId.get(tagView.getRightof()):0)+"");
            lp1.addRule(RelativeLayout.LEFT_OF, viewId.get(tagView.getLeftof())!=null?viewId.get(tagView.getLeftof()):0);
            lp1.addRule(RelativeLayout.RIGHT_OF,viewId.get(tagView.getRightof())!=null?viewId.get(tagView.getRightof()):0);
            addView(view,lp1);

        }
    }

    @Override
    public void onChanged() {


    }
}
