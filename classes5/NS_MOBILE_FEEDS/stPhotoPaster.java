package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stPhotoPaster
  extends JceStruct
{
  public String paster_id;
  
  public stPhotoPaster()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.paster_id = "";
  }
  
  public stPhotoPaster(String paramString)
  {
    this.paster_id = "";
    this.paster_id = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.paster_id = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.paster_id != null) {
      paramJceOutputStream.write(this.paster_id, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\stPhotoPaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */