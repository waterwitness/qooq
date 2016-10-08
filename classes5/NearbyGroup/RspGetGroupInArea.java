package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RspGetGroupInArea
  extends JceStruct
{
  static GroupArea cache_stGroupArea;
  public GroupArea stGroupArea;
  
  public RspGetGroupInArea()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RspGetGroupInArea(GroupArea paramGroupArea)
  {
    this.stGroupArea = paramGroupArea;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGroupArea == null) {
      cache_stGroupArea = new GroupArea();
    }
    this.stGroupArea = ((GroupArea)paramJceInputStream.read(cache_stGroupArea, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stGroupArea != null) {
      paramJceOutputStream.write(this.stGroupArea, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyGroup\RspGetGroupInArea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */