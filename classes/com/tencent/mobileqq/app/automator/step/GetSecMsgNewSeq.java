package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class GetSecMsgNewSeq
  extends AsyncStep
{
  public GetSecMsgNewSeq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "GetSecMsgNewSeq start in QQInitHandler...");
    }
    SecMsgManager localSecMsgManager = (SecMsgManager)this.a.b.getManager(56);
    if (localSecMsgManager != null) {
      localSecMsgManager.a();
    }
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetSecMsgNewSeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */