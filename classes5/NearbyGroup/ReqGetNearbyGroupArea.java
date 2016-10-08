package NearbyGroup;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetNearbyGroupArea
  extends JceStruct
  implements Cloneable
{
  public int iLat;
  public int iLon;
  public int iRadius;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!ReqGetNearbyGroupArea.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReqGetNearbyGroupArea() {}
  
  public ReqGetNearbyGroupArea(int paramInt1, int paramInt2, int paramInt3)
  {
    this.iLat = paramInt1;
    this.iLon = paramInt2;
    this.iRadius = paramInt3;
  }
  
  public String className()
  {
    return "NearbyGroup.ReqGetNearbyGroupArea";
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
    paramStringBuilder.display(this.iLat, "iLat");
    paramStringBuilder.display(this.iLon, "iLon");
    paramStringBuilder.display(this.iRadius, "iRadius");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.iLat, true);
    paramStringBuilder.displaySimple(this.iLon, true);
    paramStringBuilder.displaySimple(this.iRadius, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ReqGetNearbyGroupArea)paramObject;
    } while ((!JceUtil.equals(this.iLat, ((ReqGetNearbyGroupArea)paramObject).iLat)) || (!JceUtil.equals(this.iLon, ((ReqGetNearbyGroupArea)paramObject).iLon)) || (!JceUtil.equals(this.iRadius, ((ReqGetNearbyGroupArea)paramObject).iRadius)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NearbyGroup.ReqGetNearbyGroupArea";
  }
  
  public int getILat()
  {
    return this.iLat;
  }
  
  public int getILon()
  {
    return this.iLon;
  }
  
  public int getIRadius()
  {
    return this.iRadius;
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
    this.iLat = paramJceInputStream.read(this.iLat, 0, true);
    this.iLon = paramJceInputStream.read(this.iLon, 1, true);
    this.iRadius = paramJceInputStream.read(this.iRadius, 2, true);
  }
  
  public void setILat(int paramInt)
  {
    this.iLat = paramInt;
  }
  
  public void setILon(int paramInt)
  {
    this.iLon = paramInt;
  }
  
  public void setIRadius(int paramInt)
  {
    this.iRadius = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLat, 0);
    paramJceOutputStream.write(this.iLon, 1);
    paramJceOutputStream.write(this.iRadius, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyGroup\ReqGetNearbyGroupArea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */