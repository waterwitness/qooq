package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GetDiscussionInfo
  extends AsyncStep
{
  public GetDiscussionInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    ((DiscussionHandler)this.a.b.a(6)).e();
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetDiscussionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */