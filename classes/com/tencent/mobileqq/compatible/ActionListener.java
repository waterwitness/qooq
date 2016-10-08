package com.tencent.mobileqq.compatible;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

@Deprecated
public abstract class ActionListener
  extends IBaseActionListener.Stub
{
  public ActionListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public void onActionResult(FromServiceMsg paramFromServiceMsg) {}
  
  public void onRecvFromMsg(FromServiceMsg paramFromServiceMsg)
  {
    a((ToServiceMsg)paramFromServiceMsg.attributes.get(FromServiceMsg.class.getSimpleName()), paramFromServiceMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\compatible\ActionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */