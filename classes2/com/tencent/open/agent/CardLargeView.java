package com.tencent.open.agent;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CardLargeView
  extends CardView
{
  protected static final float a = 680.0F;
  protected static final float b = 520.0F;
  
  public CardLargeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected float a()
  {
    return 1.3076923F;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\agent\CardLargeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */