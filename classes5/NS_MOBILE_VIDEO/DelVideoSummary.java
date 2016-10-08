package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DelVideoSummary
  extends JceStruct
{
  public String msg;
  public int ret;
  public String vid;
  
  public DelVideoSummary()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.vid = "";
    this.msg = "";
  }
  
  public DelVideoSummary(String paramString1, int paramInt, String paramString2)
  {
    this.vid = "";
    this.msg = "";
    this.vid = paramString1;
    this.ret = paramInt;
    this.msg = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vid = paramJceInputStream.readString(0, false);
    this.ret = paramJceInputStream.read(this.ret, 1, false);
    this.msg = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vid != null) {
      paramJceOutputStream.write(this.vid, 0);
    }
    paramJceOutputStream.write(this.ret, 1);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\DelVideoSummary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */