package com.tencent.mobileqq.app.automator.step;

import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GetWebViewAuthorize
  extends AsyncStep
{
  public GetWebViewAuthorize()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    AuthorizeConfig.a();
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetWebViewAuthorize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */