package com.tencent.mobileqq.graytip;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class UniteGrayTipCallBack
{
  public UniteGrayTipCallBack()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniteGrayTipUtil.a, 2, "onPreAddedMsg");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\graytip\UniteGrayTipCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */