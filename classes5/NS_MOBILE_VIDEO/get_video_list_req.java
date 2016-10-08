package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class get_video_list_req
  extends JceStruct
{
  public String attach_info_new;
  public String attach_info_old;
  public long uin;
  
  public get_video_list_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.attach_info_new = "";
    this.attach_info_old = "";
  }
  
  public get_video_list_req(long paramLong, String paramString1, String paramString2)
  {
    this.attach_info_new = "";
    this.attach_info_old = "";
    this.uin = paramLong;
    this.attach_info_new = paramString1;
    this.attach_info_old = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.attach_info_new = paramJceInputStream.readString(1, false);
    this.attach_info_old = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.attach_info_new != null) {
      paramJceOutputStream.write(this.attach_info_new, 1);
    }
    if (this.attach_info_old != null) {
      paramJceOutputStream.write(this.attach_info_old, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\get_video_list_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */