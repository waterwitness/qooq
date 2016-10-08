package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_get_photo_wall_req
  extends JceStruct
{
  public String attachInfo;
  public long uin;
  
  public mobile_sub_get_photo_wall_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.attachInfo = "";
  }
  
  public mobile_sub_get_photo_wall_req(long paramLong, String paramString)
  {
    this.attachInfo = "";
    this.uin = paramLong;
    this.attachInfo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.attachInfo = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.attachInfo != null) {
      paramJceOutputStream.write(this.attachInfo, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_get_photo_wall_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */