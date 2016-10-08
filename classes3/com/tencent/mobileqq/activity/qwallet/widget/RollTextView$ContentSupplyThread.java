package com.tencent.mobileqq.activity.qwallet.widget;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class RollTextView$ContentSupplyThread
  implements Runnable
{
  RollTextView$ContentSupplyThread(RollTextView paramRollTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(RollTextView.access$400(this.this$0) * 170);
      for (;;)
      {
        if ((RollTextView.access$500(this.this$0) == RollTextView.access$600(this.this$0)) || (!this.this$0.mAcitive)) {
          break label165;
        }
        try
        {
          int i = RollTextView.access$500(this.this$0);
          Message localMessage1 = RollTextView.access$700(this.this$0).obtainMessage();
          localMessage1.what = 1;
          localBundle = new Bundle();
          localBundle.putString("content", Integer.toString(i % 10));
          localMessage1.setData(localBundle);
          RollTextView.access$700(this.this$0).sendMessage(localMessage1);
          Thread.sleep(170L);
          if (RollTextView.access$500(this.this$0) <= RollTextView.access$600(this.this$0)) {
            break;
          }
          RollTextView.access$510(this.this$0);
        }
        catch (InterruptedException localInterruptedException1)
        {
          localInterruptedException1.printStackTrace();
        }
      }
    }
    catch (InterruptedException localInterruptedException2)
    {
      Bundle localBundle;
      for (;;)
      {
        localInterruptedException2.printStackTrace();
        continue;
        RollTextView.access$508(this.this$0);
      }
      label165:
      if (RollTextView.access$500(this.this$0) == RollTextView.access$600(this.this$0))
      {
        Message localMessage2 = RollTextView.access$700(this.this$0).obtainMessage();
        localMessage2.what = 1;
        localBundle = new Bundle();
        localBundle.putString("content", Integer.toString(RollTextView.access$500(this.this$0) % 10));
        localMessage2.setData(localBundle);
        RollTextView.access$700(this.this$0).sendMessage(localMessage2);
      }
      if (RollTextView.access$000(this.this$0) != null) {
        RollTextView.access$000(this.this$0).onRollTextComplete();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\widget\RollTextView$ContentSupplyThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */