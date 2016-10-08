package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetCardSwitch
  extends JceStruct
  implements Cloneable
{
  static ReqHead cache_stHeader;
  public ReqHead stHeader;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!ReqGetCardSwitch.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReqGetCardSwitch() {}
  
  public ReqGetCardSwitch(ReqHead paramReqHead)
  {
    this.stHeader = paramReqHead;
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
    if (paramObject == null) {
      return false;
    }
    paramObject = (ReqGetCardSwitch)paramObject;
    return JceUtil.equals(this.stHeader, ((ReqGetCardSwitch)paramObject).stHeader);
  }
  
  public ReqHead getStHeader()
  {
    return this.stHeader;
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
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
  }
  
  public void setStHeader(ReqHead paramReqHead)
  {
    this.stHeader = paramReqHead;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\ReqGetCardSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */