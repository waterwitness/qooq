package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class CircleFriendInfo
  extends JceStruct
{
  public String source;
  public String strRemark;
  public long uin;
  
  public CircleFriendInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strRemark = "";
    this.source = "";
  }
  
  public CircleFriendInfo(long paramLong, String paramString1, String paramString2)
  {
    this.strRemark = "";
    this.source = "";
    this.uin = paramLong;
    this.strRemark = paramString1;
    this.source = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.strRemark = paramJceInputStream.readString(1, true);
    this.source = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.strRemark, 1);
    if (this.source != null) {
      paramJceOutputStream.write(this.source, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\CircleFriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */