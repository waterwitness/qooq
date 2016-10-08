package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class FlowPanel
{
  FlowActivity a;
  
  public FlowPanel(FlowActivity paramFlowActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramFlowActivity;
  }
  
  public Context a()
  {
    return this.a;
  }
  
  public abstract void a();
  
  public abstract void a(ViewGroup paramViewGroup);
  
  public abstract void b();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\FlowPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */