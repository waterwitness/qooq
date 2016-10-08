package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqCheckPayAuth
  extends JceStruct
{
  static BaseInfo cache_baseInfo;
  public String bargainorId;
  public BaseInfo baseInfo;
  public String p1;
  public String p2;
  public String p3;
  public int payFrom;
  public String pubAcc;
  public String sessionKey;
  public String tokenId;
  
  public ReqCheckPayAuth()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.tokenId = "";
    this.pubAcc = "";
    this.bargainorId = "";
    this.p1 = "";
    this.p2 = "";
    this.p3 = "";
    this.sessionKey = "";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_baseInfo == null) {
      cache_baseInfo = new BaseInfo();
    }
    this.baseInfo = ((BaseInfo)paramJceInputStream.read(cache_baseInfo, 0, true));
    this.tokenId = paramJceInputStream.readString(1, true);
    this.pubAcc = paramJceInputStream.readString(2, false);
    this.bargainorId = paramJceInputStream.readString(3, true);
    this.payFrom = paramJceInputStream.read(this.payFrom, 4, true);
    this.p1 = paramJceInputStream.readString(5, false);
    this.p2 = paramJceInputStream.readString(6, false);
    this.p3 = paramJceInputStream.readString(7, false);
    this.sessionKey = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.baseInfo, 0);
    paramJceOutputStream.write(this.tokenId, 1);
    if (this.pubAcc != null) {
      paramJceOutputStream.write(this.pubAcc, 2);
    }
    paramJceOutputStream.write(this.bargainorId, 3);
    paramJceOutputStream.write(this.payFrom, 4);
    if (this.p1 != null) {
      paramJceOutputStream.write(this.p1, 5);
    }
    if (this.p2 != null) {
      paramJceOutputStream.write(this.p2, 6);
    }
    if (this.p3 != null) {
      paramJceOutputStream.write(this.p3, 7);
    }
    if (this.sessionKey != null) {
      paramJceOutputStream.write(this.sessionKey, 8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\VIP\ReqCheckPayAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */