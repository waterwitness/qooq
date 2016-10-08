package NearbyGroup;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RspGetNearbyGroupArea
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_vGroupArea;
  public ArrayList vGroupArea;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!RspGetNearbyGroupArea.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RspGetNearbyGroupArea() {}
  
  public RspGetNearbyGroupArea(ArrayList paramArrayList)
  {
    this.vGroupArea = paramArrayList;
  }
  
  public String className()
  {
    return "NearbyGroup.RspGetNearbyGroupArea";
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.vGroupArea, "vGroupArea");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.vGroupArea, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (RspGetNearbyGroupArea)paramObject;
    return JceUtil.equals(this.vGroupArea, ((RspGetNearbyGroupArea)paramObject).vGroupArea);
  }
  
  public String fullClassName()
  {
    return "NearbyGroup.RspGetNearbyGroupArea";
  }
  
  public ArrayList getVGroupArea()
  {
    return this.vGroupArea;
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
    if (cache_vGroupArea == null)
    {
      cache_vGroupArea = new ArrayList();
      GroupArea localGroupArea = new GroupArea();
      cache_vGroupArea.add(localGroupArea);
    }
    this.vGroupArea = ((ArrayList)paramJceInputStream.read(cache_vGroupArea, 0, false));
  }
  
  public void setVGroupArea(ArrayList paramArrayList)
  {
    this.vGroupArea = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vGroupArea != null) {
      paramJceOutputStream.write(this.vGroupArea, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyGroup\RspGetNearbyGroupArea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */