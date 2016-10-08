package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class operation_delfavour_req
  extends JceStruct
{
  public long appid;
  public long subid;
  public long uin;
  public String vecFavID;
  
  public operation_delfavour_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.vecFavID = "";
  }
  
  public operation_delfavour_req(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    this.vecFavID = "";
    this.uin = paramLong1;
    this.vecFavID = paramString;
    this.appid = paramLong2;
    this.subid = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.vecFavID = paramJceInputStream.readString(1, false);
    this.appid = paramJceInputStream.read(this.appid, 2, false);
    this.subid = paramJceInputStream.read(this.subid, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.vecFavID != null) {
      paramJceOutputStream.write(this.vecFavID, 1);
    }
    paramJceOutputStream.write(this.appid, 2);
    paramJceOutputStream.write(this.subid, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\operation_delfavour_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */