package com.tencent.mobileqq.apollo.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ApolloPopLayout
  extends FrameLayout
{
  public ApolloPopLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ApolloPopLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGuestsStateActivity", 2, "back down");
      }
      if ((!(super.getContext() instanceof ApolloGuestsStateActivity)) || (((ApolloGuestsStateActivity)super.getContext()).isFinishing())) {}
    }
    try
    {
      ((ApolloGuestsStateActivity)super.getContext()).d();
      ((Activity)super.getContext()).onBackPressed();
      return true;
    }
    catch (Exception paramKeyEvent)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloGuestsStateActivity", 2, "remove popWindow error:" + paramKeyEvent.toString());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\ApolloPopLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */