package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RspGetAreaList
  extends JceStruct
{
  static ArrayList cache_vGroupArea;
  public ArrayList vGroupArea;
  
  public RspGetAreaList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RspGetAreaList(ArrayList paramArrayList)
  {
    this.vGroupArea = paramArrayList;
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
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vGroupArea != null) {
      paramJceOutputStream.write(this.vGroupArea, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyGroup\RspGetAreaList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */