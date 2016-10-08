package ResPackage;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqResOrder
  extends JceStruct
  implements Cloneable
{
  static byte[] cache_PkgInfo;
  static int cache_ResID;
  public String Path = "";
  public byte[] PkgInfo;
  public int ResID;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!ReqResOrder.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReqResOrder() {}
  
  public ReqResOrder(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.ResID = paramInt;
    this.Path = paramString;
    this.PkgInfo = paramArrayOfByte;
  }
  
  public String className()
  {
    return "ResPackage.ReqResOrder";
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
    paramStringBuilder.display(this.ResID, "ResID");
    paramStringBuilder.display(this.Path, "Path");
    paramStringBuilder.display(this.PkgInfo, "PkgInfo");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.ResID, true);
    paramStringBuilder.displaySimple(this.Path, true);
    paramStringBuilder.displaySimple(this.PkgInfo, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ReqResOrder)paramObject;
    } while ((!JceUtil.equals(this.ResID, ((ReqResOrder)paramObject).ResID)) || (!JceUtil.equals(this.Path, ((ReqResOrder)paramObject).Path)) || (!JceUtil.equals(this.PkgInfo, ((ReqResOrder)paramObject).PkgInfo)));
    return true;
  }
  
  public String fullClassName()
  {
    return "ResPackage.ReqResOrder";
  }
  
  public String getPath()
  {
    return this.Path;
  }
  
  public byte[] getPkgInfo()
  {
    return this.PkgInfo;
  }
  
  public int getResID()
  {
    return this.ResID;
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
    this.ResID = paramJceInputStream.read(this.ResID, 0, true);
    this.Path = paramJceInputStream.readString(1, true);
    if (cache_PkgInfo == null)
    {
      cache_PkgInfo = (byte[])new byte[1];
      ((byte[])cache_PkgInfo)[0] = 0;
    }
    this.PkgInfo = ((byte[])paramJceInputStream.read(cache_PkgInfo, 2, false));
  }
  
  public void setPath(String paramString)
  {
    this.Path = paramString;
  }
  
  public void setPkgInfo(byte[] paramArrayOfByte)
  {
    this.PkgInfo = paramArrayOfByte;
  }
  
  public void setResID(int paramInt)
  {
    this.ResID = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ResID, 0);
    paramJceOutputStream.write(this.Path, 1);
    if (this.PkgInfo != null) {
      paramJceOutputStream.write(this.PkgInfo, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ResPackage\ReqResOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */