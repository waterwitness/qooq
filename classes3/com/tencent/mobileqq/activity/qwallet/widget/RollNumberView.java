package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Random;

public class RollNumberView
  extends LinearLayout
  implements RollTextView.OnRollTextChangeListener
{
  private int count;
  private int index;
  private Context mContext;
  private int mFactor;
  private RollNumberView.OnRollListener mListener;
  private int mTextColor;
  private int mTextSize;
  private int mViewRolledCount;
  private int max;
  
  public RollNumberView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mContext = paramContext;
  }
  
  public RollNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    getAttrs(paramContext, paramAttributeSet);
  }
  
  public RollNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    getAttrs(paramContext, paramAttributeSet);
  }
  
  private void getAttrs(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aL);
    this.mTextSize = ((int)paramContext.getDimension(1, 12.0F));
    this.mTextColor = paramContext.getColor(0, 0);
    paramContext.recycle();
  }
  
  public int init(int paramInt)
  {
    if (paramInt < 0) {
      throw new Exception("no must be positive");
    }
    int i = paramInt % 10;
    RollTextView localRollTextView = new RollTextView(this.mContext, this.mTextSize, this.mTextColor);
    localRollTextView.setListener(this);
    int j = this.mFactor;
    this.mFactor = (j + 1);
    localRollTextView.setFactor(j);
    addView(localRollTextView, 0);
    j = 4 - new Random().nextInt(3);
    localRollTextView.setScope(i + j, i);
    paramInt /= 10;
    i = 0;
    while (paramInt > 0)
    {
      i += 1;
      localRollTextView = new RollTextView(this.mContext, this.mTextSize, this.mTextColor);
      localRollTextView.setListener(this);
      int k = this.mFactor;
      this.mFactor = (k + 1);
      localRollTextView.setFactor(k);
      k = paramInt % 10;
      localRollTextView.setScope(k + j + i, k);
      addView(localRollTextView, 0);
      paramInt /= 10;
    }
    return j;
  }
  
  public void init(double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      throw new Exception("no must be positive");
    }
    TextView localTextView = new TextView(this.mContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localTextView.setIncludeFontPadding(false);
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setGravity(80);
    localTextView.setTextSize(0, this.mTextSize);
    localTextView.setTextColor(this.mTextColor);
    int i = (int)paramDouble;
    int j = (int)Math.round((paramDouble - i) * 1000.0D) / 10;
    this.max = init(j);
    if (j < 10) {
      init(0);
    }
    localTextView.setText(".");
    addView(localTextView, 0);
    i = init(i);
    if (i > this.max) {}
    for (;;)
    {
      this.max = i;
      return;
      i = this.max;
    }
  }
  
  public void onRollTextChanged(Bitmap paramBitmap) {}
  
  public void onRollTextComplete()
  {
    if (this.mViewRolledCount == this.count - 2) {
      this.mListener.complete();
    }
    this.mViewRolledCount += 1;
  }
  
  public void reset(double paramDouble)
  {
    int i = 0;
    while (i < this.count)
    {
      View localView = getChildAt(i);
      if ((localView != null) && ((localView instanceof RollTextView))) {
        ((RollTextView)localView).stopRoll();
      }
      i += 1;
    }
    this.mFactor = 0;
    removeAllViews();
    try
    {
      this.mViewRolledCount = 0;
      init(paramDouble);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void roll()
  {
    this.count = getChildCount();
    int i = 0;
    while (i < this.count)
    {
      View localView = getChildAt(i);
      if ((localView != null) && ((localView instanceof RollTextView))) {
        ((RollTextView)localView).show();
      }
      i += 1;
    }
  }
  
  public void setFactor(int paramInt)
  {
    if (paramInt >= 0) {
      this.mFactor = paramInt;
    }
  }
  
  public void setLisener(RollNumberView.OnRollListener paramOnRollListener)
  {
    if (paramOnRollListener != null) {
      this.mListener = paramOnRollListener;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\widget\RollNumberView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */