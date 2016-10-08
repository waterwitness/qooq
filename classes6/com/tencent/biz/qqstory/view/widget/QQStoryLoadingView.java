package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQStoryLoadingView
  extends TextView
{
  protected AnimationDrawable a;
  
  public QQStoryLoadingView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public QQStoryLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  protected void a()
  {
    this.a = new AnimationDrawable();
    int i = 0;
    while (i < 29)
    {
      this.a.addFrame(getResources().getDrawable(2130841420 + i), 50);
      i += 1;
    }
    this.a.setOneShot(false);
    setCompoundDrawablesWithIntrinsicBounds(null, this.a, null, null);
    setGravity(17);
    if (getVisibility() == 0) {
      this.a.start();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (getVisibility() != paramInt) {
      super.setVisibility(paramInt);
    }
    if (paramInt == 0)
    {
      this.a.start();
      return;
    }
    this.a.stop();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\widget\QQStoryLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */