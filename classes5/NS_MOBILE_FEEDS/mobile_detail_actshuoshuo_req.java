package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_detail_actshuoshuo_req
  extends JceStruct
{
  public String act_id;
  public String busi_param;
  
  public mobile_detail_actshuoshuo_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.act_id = "";
    this.busi_param = "";
  }
  
  public mobile_detail_actshuoshuo_req(String paramString1, String paramString2)
  {
    this.act_id = "";
    this.busi_param = "";
    this.act_id = paramString1;
    this.busi_param = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.act_id = paramJceInputStream.readString(0, false);
    this.busi_param = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.act_id != null) {
      paramJceOutputStream.write(this.act_id, 0);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\mobile_detail_actshuoshuo_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */