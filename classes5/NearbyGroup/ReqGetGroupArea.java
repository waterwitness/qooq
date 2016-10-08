package NearbyGroup;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetGroupArea
  extends JceStruct
  implements Cloneable
{
  public long dwGroupStartIdx;
  public int iCount;
  public int iLat;
  public int iLon;
  public String strAreaName = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!ReqGetGroupArea.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReqGetGroupArea() {}
  
  public ReqGetGroupArea(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.strAreaName = paramString;
    this.iLat = paramInt1;
    this.iLon = paramInt2;
    this.dwGroupStartIdx = paramLong;
    this.iCount = paramInt3;
  }
  
  public String className()
  {
    return "NearbyGroup.ReqGetGroupArea";
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
    paramStringBuilder.display(this.strAreaName, "strAreaName");
    paramStringBuilder.display(this.iLat, "iLat");
    paramStringBuilder.display(this.iLon, "iLon");
    paramStringBuilder.display(this.dwGroupStartIdx, "dwGroupStartIdx");
    paramStringBuilder.display(this.iCount, "iCount");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.strAreaName, true);
    paramStringBuilder.displaySimple(this.iLat, true);
    paramStringBuilder.displaySimple(this.iLon, true);
    paramStringBuilder.displaySimple(this.dwGroupStartIdx, true);
    paramStringBuilder.displaySimple(this.iCount, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ReqGetGroupArea)paramObject;
    } while ((!JceUtil.equals(this.strAreaName, ((ReqGetGroupArea)paramObject).strAreaName)) || (!JceUtil.equals(this.iLat, ((ReqGetGroupArea)paramObject).iLat)) || (!JceUtil.equals(this.iLon, ((ReqGetGroupArea)paramObject).iLon)) || (!JceUtil.equals(this.dwGroupStartIdx, ((ReqGetGroupArea)paramObject).dwGroupStartIdx)) || (!JceUtil.equals(this.iCount, ((ReqGetGroupArea)paramObject).iCount)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NearbyGroup.ReqGetGroupArea";
  }
  
  public long getDwGroupStartIdx()
  {
    return this.dwGroupStartIdx;
  }
  
  public int getICount()
  {
    return this.iCount;
  }
  
  public int getILat()
  {
    return this.iLat;
  }
  
  public int getILon()
  {
    return this.iLon;
  }
  
  public String getStrAreaName()
  {
    return this.strAreaName;
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
    this.strAreaName = paramJceInputStream.readString(0, true);
    this.iLat = paramJceInputStream.read(this.iLat, 1, true);
    this.iLon = paramJceInputStream.read(this.iLon, 2, true);
    this.dwGroupStartIdx = paramJceInputStream.read(this.dwGroupStartIdx, 3, false);
    this.iCount = paramJceInputStream.read(this.iCount, 4, true);
  }
  
  public void setDwGroupStartIdx(long paramLong)
  {
    this.dwGroupStartIdx = paramLong;
  }
  
  public void setICount(int paramInt)
  {
    this.iCount = paramInt;
  }
  
  public void setILat(int paramInt)
  {
    this.iLat = paramInt;
  }
  
  public void setILon(int paramInt)
  {
    this.iLon = paramInt;
  }
  
  public void setStrAreaName(String paramString)
  {
    this.strAreaName = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strAreaName, 0);
    paramJceOutputStream.write(this.iLat, 1);
    paramJceOutputStream.write(this.iLon, 2);
    paramJceOutputStream.write(this.dwGroupStartIdx, 3);
    paramJceOutputStream.write(this.iCount, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyGroup\ReqGetGroupArea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */