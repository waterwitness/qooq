package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.msfmqpsdkbridge.MSFSigCheckWrapper;

public class SignatureScan
  extends AsyncStep
{
  public SignatureScan()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    new MSFSigCheckWrapper(this.a.b).a(false);
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\SignatureScan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */