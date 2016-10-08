package com.tencent.mobileqq.activity.qwallet.widget;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class RollTextView$1
  implements ViewSwitcher.ViewFactory
{
  RollTextView$1(RollTextView paramRollTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View makeView()
  {
    TextView localTextView = new TextView(RollTextView.access$100(this.this$0));
    localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    localTextView.setTextSize(0, RollTextView.access$200(this.this$0));
    localTextView.setIncludeFontPadding(false);
    localTextView.setTextColor(RollTextView.access$300(this.this$0));
    localTextView.setText("0");
    return localTextView;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\widget\RollTextView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */