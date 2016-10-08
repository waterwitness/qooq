package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CheckHotSpotNode
  extends AsyncStep
{
  public CheckHotSpotNode()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\CheckHotSpotNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */