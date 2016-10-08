package com.tencent.mobileqq.activity.qwallet.widget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

class RollTextView$RollViewHandler
  extends Handler
{
  WeakReference mRootView;
  
  RollTextView$RollViewHandler(RollTextView paramRollTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mRootView = new WeakReference(paramRollTextView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    RollTextView localRollTextView = (RollTextView)this.mRootView.get();
    if (localRollTextView == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return;
        localBundle = paramMessage.getData();
      } while (localBundle == null);
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      localRollTextView.setText(localBundle.getString("content"));
    } while (RollTextView.access$000(localRollTextView) == null);
    RollTextView.access$000(localRollTextView).onRollTextChanged(null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\widget\RollTextView$RollViewHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */