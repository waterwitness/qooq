package MyCarrier;

import LBS.LBSInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqCarrier
  extends JceStruct
{
  static LBSInfo cache_lbsInfo;
  public int bindFrom;
  public String bindMobile;
  public LBSInfo lbsInfo;
  public String optBuf;
  
  public ReqCarrier()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.bindMobile = "";
    this.optBuf = "";
  }
  
  public ReqCarrier(String paramString1, int paramInt, LBSInfo paramLBSInfo, String paramString2)
  {
    this.bindMobile = "";
    this.optBuf = "";
    this.bindMobile = paramString1;
    this.bindFrom = paramInt;
    this.lbsInfo = paramLBSInfo;
    this.optBuf = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bindMobile = paramJceInputStream.readString(0, true);
    this.bindFrom = paramJceInputStream.read(this.bindFrom, 1, true);
    if (cache_lbsInfo == null) {
      cache_lbsInfo = new LBSInfo();
    }
    this.lbsInfo = ((LBSInfo)paramJceInputStream.read(cache_lbsInfo, 2, true));
    this.optBuf = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bindMobile, 0);
    paramJceOutputStream.write(this.bindFrom, 1);
    paramJceOutputStream.write(this.lbsInfo, 2);
    paramJceOutputStream.write(this.optBuf, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\MyCarrier\ReqCarrier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */