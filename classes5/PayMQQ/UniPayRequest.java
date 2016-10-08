package PayMQQ;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UniPayRequest
  extends JceStruct
  implements Cloneable
{
  public String sPlatform = "";
  public String sUin = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!UniPayRequest.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UniPayRequest() {}
  
  public UniPayRequest(String paramString1, String paramString2)
  {
    this.sUin = paramString1;
    this.sPlatform = paramString2;
  }
  
  public String className()
  {
    return "MQQ.UniPayRequest";
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
    paramStringBuilder.display(this.sUin, "sUin");
    paramStringBuilder.display(this.sPlatform, "sPlatform");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.sUin, true);
    paramStringBuilder.displaySimple(this.sPlatform, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (UniPayRequest)paramObject;
    } while ((!JceUtil.equals(this.sUin, ((UniPayRequest)paramObject).sUin)) || (!JceUtil.equals(this.sPlatform, ((UniPayRequest)paramObject).sPlatform)));
    return true;
  }
  
  public String fullClassName()
  {
    return "MQQ.UniPayRequest";
  }
  
  public String getSPlatform()
  {
    return this.sPlatform;
  }
  
  public String getSUin()
  {
    return this.sUin;
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
    this.sUin = paramJceInputStream.readString(0, true);
    this.sPlatform = paramJceInputStream.readString(1, true);
  }
  
  public void setSPlatform(String paramString)
  {
    this.sPlatform = paramString;
  }
  
  public void setSUin(String paramString)
  {
    this.sUin = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sUin, 0);
    paramJceOutputStream.write(this.sPlatform, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PayMQQ\UniPayRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */