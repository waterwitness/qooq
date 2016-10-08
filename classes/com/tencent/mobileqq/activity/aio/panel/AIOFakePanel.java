package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AIOFakePanel
  extends LinearLayout
{
  public AIOFakePanel(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    setBackgroundResource(2130843209);
  }
  
  public void setPanelType() {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\panel\AIOFakePanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */