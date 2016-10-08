package qqwifi.MQQ;

import LBS.LBSInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ContentRequest
  extends JceStruct
{
  static LBSInfo cache_lbsInfo;
  public long id;
  public LBSInfo lbsInfo;
  public String version;
  
  public ContentRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.version = "";
  }
  
  public ContentRequest(long paramLong, LBSInfo paramLBSInfo, String paramString)
  {
    this.version = "";
    this.id = paramLong;
    this.lbsInfo = paramLBSInfo;
    this.version = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, true);
    if (cache_lbsInfo == null) {
      cache_lbsInfo = new LBSInfo();
    }
    this.lbsInfo = ((LBSInfo)paramJceInputStream.read(cache_lbsInfo, 1, false));
    this.version = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    if (this.lbsInfo != null) {
      paramJceOutputStream.write(this.lbsInfo, 1);
    }
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qqwifi\MQQ\ContentRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */