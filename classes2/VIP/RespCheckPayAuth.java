package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespCheckPayAuth
  extends JceStruct
{
  public String attentionTips;
  public int defaultSelected;
  public String errMsg;
  public long mpuin;
  public String openId;
  public int ret;
  
  public RespCheckPayAuth()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.errMsg = "";
    this.openId = "";
    this.attentionTips = "";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.errMsg = paramJceInputStream.readString(1, false);
    this.openId = paramJceInputStream.readString(2, false);
    this.defaultSelected = paramJceInputStream.read(this.defaultSelected, 3, true);
    this.mpuin = paramJceInputStream.read(this.mpuin, 4, true);
    this.attentionTips = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errMsg != null) {
      paramJceOutputStream.write(this.errMsg, 1);
    }
    if (this.openId != null) {
      paramJceOutputStream.write(this.openId, 2);
    }
    paramJceOutputStream.write(this.defaultSelected, 3);
    paramJceOutputStream.write(this.mpuin, 4);
    if (this.attentionTips != null) {
      paramJceOutputStream.write(this.attentionTips, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\VIP\RespCheckPayAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */