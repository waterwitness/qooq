package com.tencent.mobileqq.theme.diy;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ScrollLayout$1
  extends Handler
{
  ScrollLayout$1(ScrollLayout paramScrollLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    int j = Integer.parseInt(paramMessage.obj.toString());
    this.this$0.getChildAt(i);
    this.this$0.changeAlpha(this.this$0.getChildAt(i), false, j);
    if (i > 0) {
      this.this$0.changeAlpha(this.this$0.getChildAt(i - 1), true, j);
    }
    if (i < this.this$0.getChildCount() - 1) {
      this.this$0.changeAlpha(this.this$0.getChildAt(i + 1), true, j);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ScrollLayout$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */