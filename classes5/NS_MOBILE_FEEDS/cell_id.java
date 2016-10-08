package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_id
  extends JceStruct
{
  public String cellid;
  public String subid;
  
  public cell_id()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cellid = "";
    this.subid = "";
  }
  
  public cell_id(String paramString1, String paramString2)
  {
    this.cellid = "";
    this.subid = "";
    this.cellid = paramString1;
    this.subid = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cellid = paramJceInputStream.readString(0, false);
    this.subid = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cellid != null) {
      paramJceOutputStream.write(this.cellid, 0);
    }
    if (this.subid != null) {
      paramJceOutputStream.write(this.subid, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_id.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */