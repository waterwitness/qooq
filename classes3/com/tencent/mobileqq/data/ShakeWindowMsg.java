package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ShakeWindowMsg
  implements Externalizable
{
  public static final int OFFLINE_SHAKE = 2;
  public static final int ONLINE_SHAKE = 1;
  private static int VERSION = 1;
  public int mReserve;
  public int mType;
  public int onlineFlag = 1;
  public boolean shake = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ShakeWindowMsg() {}
  
  public ShakeWindowMsg(ShakeWindowMsg paramShakeWindowMsg)
  {
    this.shake = paramShakeWindowMsg.shake;
    this.mType = paramShakeWindowMsg.mType;
    this.mReserve = paramShakeWindowMsg.mReserve;
    this.onlineFlag = paramShakeWindowMsg.onlineFlag;
  }
  
  public byte[] getBytes()
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.shakemsg", 2, localIOException.getMessage(), localIOException);
      }
    }
    return null;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    if (paramObjectInput.readInt() == 1)
    {
      this.shake = paramObjectInput.readBoolean();
      this.onlineFlag = paramObjectInput.readInt();
      this.mType = paramObjectInput.readInt();
      this.mReserve = paramObjectInput.readInt();
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(VERSION);
    paramObjectOutput.writeBoolean(this.shake);
    paramObjectOutput.writeInt(this.onlineFlag);
    paramObjectOutput.writeInt(this.mType);
    paramObjectOutput.writeInt(this.mReserve);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ShakeWindowMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */