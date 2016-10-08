package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class BaseInfo
  extends JceStruct
  implements Cloneable
{
  public String appId = "";
  public String nonce = "";
  public String phoneModel = "";
  public String phoneOS = "";
  public String qVersion = "";
  public String sig = "";
  public String sigType = "";
  public long timeStamp;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!BaseInfo.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "VIP.BaseInfo";
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
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (BaseInfo)paramObject;
    } while ((!JceUtil.equals(this.appId, ((BaseInfo)paramObject).appId)) || (!JceUtil.equals(this.nonce, ((BaseInfo)paramObject).nonce)) || (!JceUtil.equals(this.timeStamp, ((BaseInfo)paramObject).timeStamp)) || (!JceUtil.equals(this.sigType, ((BaseInfo)paramObject).sigType)) || (!JceUtil.equals(this.sig, ((BaseInfo)paramObject).sig)) || (!JceUtil.equals(this.qVersion, ((BaseInfo)paramObject).qVersion)) || (!JceUtil.equals(this.phoneOS, ((BaseInfo)paramObject).phoneOS)) || (!JceUtil.equals(this.phoneModel, ((BaseInfo)paramObject).phoneModel)));
    return true;
  }
  
  public String fullClassName()
  {
    return "VIP.BaseInfo";
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
    this.appId = paramJceInputStream.readString(0, true);
    this.nonce = paramJceInputStream.readString(1, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 2, true);
    this.sigType = paramJceInputStream.readString(3, true);
    this.sig = paramJceInputStream.readString(4, true);
    this.qVersion = paramJceInputStream.readString(5, true);
    this.phoneOS = paramJceInputStream.readString(6, true);
    this.phoneModel = paramJceInputStream.readString(7, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appId, 0);
    paramJceOutputStream.write(this.nonce, 1);
    paramJceOutputStream.write(this.timeStamp, 2);
    paramJceOutputStream.write(this.sigType, 3);
    paramJceOutputStream.write(this.sig, 4);
    paramJceOutputStream.write(this.qVersion, 5);
    paramJceOutputStream.write(this.phoneOS, 6);
    paramJceOutputStream.write(this.phoneModel, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\VIP\BaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */