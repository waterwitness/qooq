package cooperation.qzone.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import yor;

public class RecvMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new yor();
  public static final String SSOSEQ_KEY = "_ssoSeqKey";
  private static final String tag = "RecvMsg";
  public Bundle extraData = new Bundle();
  public int reqSeq;
  public int resultCode;
  public String serviceCmd;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RecvMsg() {}
  
  public RecvMsg(int paramInt, String paramString)
  {
    this.resultCode = 1001;
    this.reqSeq = paramInt;
    this.serviceCmd = paramString;
  }
  
  public RecvMsg(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public RecvMsg(String paramString)
  {
    this(-1, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getBusinessFailMsg()
  {
    if (this.extraData.containsKey("error")) {
      return this.extraData.getString("error");
    }
    return null;
  }
  
  public int getMsgResultCode()
  {
    return this.resultCode;
  }
  
  public int getRequestId()
  {
    return this.reqSeq;
  }
  
  public int getRequestSsoSeq()
  {
    return this.extraData.getInt("_ssoSeqKey", -1);
  }
  
  public int getResultCode()
  {
    return this.resultCode;
  }
  
  public String getServiceCmd()
  {
    return this.serviceCmd;
  }
  
  public byte[] getWupBuffer()
  {
    if (this.extraData.containsKey("wup")) {
      return (byte[])this.extraData.get("wup");
    }
    return null;
  }
  
  public boolean isSuccess()
  {
    return this.resultCode == 1000;
  }
  
  public void putWupBuffer(byte[] paramArrayOfByte)
  {
    this.extraData.putByteArray("wup", paramArrayOfByte);
  }
  
  /* Error */
  public void readFromParcel(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 109	android/os/Parcel:readInt	()I
    //   5: putfield 50	cooperation/qzone/remote/RecvMsg:reqSeq	I
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 109	android/os/Parcel:readInt	()I
    //   13: putfield 48	cooperation/qzone/remote/RecvMsg:resultCode	I
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 112	android/os/Parcel:readString	()Ljava/lang/String;
    //   21: putfield 52	cooperation/qzone/remote/RecvMsg:serviceCmd	Ljava/lang/String;
    //   24: aload_0
    //   25: getfield 45	cooperation/qzone/remote/RecvMsg:extraData	Landroid/os/Bundle;
    //   28: invokevirtual 115	android/os/Bundle:clear	()V
    //   31: aload_1
    //   32: aload_0
    //   33: invokevirtual 119	java/lang/Object:getClass	()Ljava/lang/Class;
    //   36: invokevirtual 125	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   39: invokevirtual 129	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   42: astore_1
    //   43: aload_1
    //   44: invokestatic 135	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   47: invokestatic 140	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Context;)Ljava/lang/ClassLoader;
    //   50: invokevirtual 144	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   53: aload_0
    //   54: getfield 45	cooperation/qzone/remote/RecvMsg:extraData	Landroid/os/Bundle;
    //   57: aload_1
    //   58: invokevirtual 148	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   61: return
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   67: goto -14 -> 53
    //   70: astore_1
    //   71: ldc 17
    //   73: iconst_1
    //   74: ldc -103
    //   76: aload_1
    //   77: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	RecvMsg
    //   0	82	1	paramParcel	Parcel
    //   62	2	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   43	53	62	java/lang/Exception
    //   0	43	70	java/lang/RuntimeException
    //   43	53	70	java/lang/RuntimeException
    //   53	61	70	java/lang/RuntimeException
    //   63	67	70	java/lang/RuntimeException
  }
  
  public void setBusinessFail()
  {
    this.resultCode = 1001;
  }
  
  public void setBusinessFail(int paramInt, String paramString)
  {
    this.resultCode = paramInt;
    this.extraData.putString("error", paramString);
  }
  
  public void setBusinessFail(String paramString)
  {
    this.resultCode = 1001;
    this.extraData.putString("error", paramString);
  }
  
  public void setMsgFail()
  {
    this.resultCode = 1001;
  }
  
  public void setMsgResult(int paramInt)
  {
    this.resultCode = paramInt;
  }
  
  public void setMsgSuccess()
  {
    this.resultCode = 1000;
  }
  
  public void setRequestId(int paramInt)
  {
    this.reqSeq = paramInt;
  }
  
  public void setRequestSsoSeq(int paramInt)
  {
    this.extraData.putInt("_ssoSeqKey", paramInt);
  }
  
  public void setServiceCmd(String paramString)
  {
    this.serviceCmd = paramString;
  }
  
  public String toString()
  {
    return "RecvMsg ssoseq:" + getRequestSsoSeq() + " resultCode:" + this.resultCode + " serviceCmd:" + this.serviceCmd + " appSeq:" + this.reqSeq;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.reqSeq);
      paramParcel.writeInt(this.resultCode);
      paramParcel.writeString(this.serviceCmd);
      paramParcel.writeBundle(this.extraData);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.w("RecvMsg", 1, "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\remote\RecvMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */