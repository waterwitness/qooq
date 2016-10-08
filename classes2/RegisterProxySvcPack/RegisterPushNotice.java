package RegisterProxySvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RegisterPushNotice
  extends JceStruct
  implements Cloneable
{
  public long uEndSeq;
  public long uFlag;
  public long ulTimeOutFlag;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!RegisterPushNotice.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RegisterPushNotice() {}
  
  public RegisterPushNotice(long paramLong1, long paramLong2, long paramLong3)
  {
    this.uFlag = paramLong1;
    this.uEndSeq = paramLong2;
    this.ulTimeOutFlag = paramLong3;
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.uFlag, "uFlag");
    paramStringBuilder.display(this.uEndSeq, "uEndSeq");
    paramStringBuilder.display(this.ulTimeOutFlag, "ulTimeOutFlag");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.uFlag, true);
    paramStringBuilder.displaySimple(this.uEndSeq, true);
    paramStringBuilder.displaySimple(this.ulTimeOutFlag, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (RegisterPushNotice)paramObject;
    } while ((!JceUtil.equals(this.uFlag, ((RegisterPushNotice)paramObject).uFlag)) || (!JceUtil.equals(this.uEndSeq, ((RegisterPushNotice)paramObject).uEndSeq)) || (!JceUtil.equals(this.ulTimeOutFlag, ((RegisterPushNotice)paramObject).ulTimeOutFlag)));
    return true;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uFlag = paramJceInputStream.read(this.uFlag, 0, false);
    this.uEndSeq = paramJceInputStream.read(this.uEndSeq, 1, false);
    this.ulTimeOutFlag = paramJceInputStream.read(this.ulTimeOutFlag, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uFlag, 0);
    paramJceOutputStream.write(this.uEndSeq, 1);
    paramJceOutputStream.write(this.ulTimeOutFlag, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\RegisterProxySvcPack\RegisterPushNotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */