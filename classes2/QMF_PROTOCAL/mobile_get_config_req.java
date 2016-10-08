package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_get_config_req
  extends JceStruct
{
  public int appid;
  public String cookies;
  public int scene;
  
  public mobile_get_config_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cookies = "";
  }
  
  public mobile_get_config_req(int paramInt1, int paramInt2, String paramString)
  {
    this.cookies = "";
    this.appid = paramInt1;
    this.scene = paramInt2;
    this.cookies = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.scene = paramJceInputStream.read(this.scene, 1, false);
    this.cookies = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.scene, 1);
    if (this.cookies != null) {
      paramJceOutputStream.write(this.cookies, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QMF_PROTOCAL\mobile_get_config_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */