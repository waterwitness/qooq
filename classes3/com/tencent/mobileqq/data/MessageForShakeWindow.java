package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class MessageForShakeWindow
  extends ChatMessage
{
  public ShakeWindowMsg mShakeWindowMsg;
  
  public MessageForShakeWindow()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MessageForShakeWindow(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5)
  {
    init(paramLong1, paramLong2, paramLong3, "[Shake Window]", paramLong4, 63516, paramInt, paramLong5);
  }
  
  protected void doParse()
  {
    try
    {
      this.mShakeWindowMsg = new ShakeWindowMsg();
      ObjectInputStream localObjectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
      this.mShakeWindowMsg.readExternal(localObjectInputStream);
      localObjectInputStream.close();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.shakemsg", 2, "convert byte array to ShakeWindowMsg failed", localException);
      }
      this.mShakeWindowMsg = null;
    }
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    if (this.mShakeWindowMsg != null) {}
    try
    {
      this.msgData = this.mShakeWindowMsg.getBytes();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.shakemsg", 2, "convert ShakeWindowMsg to byte array failed", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForShakeWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */