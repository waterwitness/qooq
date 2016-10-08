package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class share_outsite_req
  extends JceStruct
{
  public String albumid;
  public int appid;
  public String batchid;
  public String cellid;
  public String lloc;
  public int ugc_type;
  
  public share_outsite_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cellid = "";
    this.albumid = "";
    this.lloc = "";
    this.batchid = "";
  }
  
  public share_outsite_req(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    this.cellid = "";
    this.albumid = "";
    this.lloc = "";
    this.batchid = "";
    this.appid = paramInt1;
    this.cellid = paramString1;
    this.ugc_type = paramInt2;
    this.albumid = paramString2;
    this.lloc = paramString3;
    this.batchid = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.cellid = paramJceInputStream.readString(1, false);
    this.ugc_type = paramJceInputStream.read(this.ugc_type, 2, false);
    this.albumid = paramJceInputStream.readString(3, false);
    this.lloc = paramJceInputStream.readString(4, false);
    this.batchid = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    if (this.cellid != null) {
      paramJceOutputStream.write(this.cellid, 1);
    }
    paramJceOutputStream.write(this.ugc_type, 2);
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 3);
    }
    if (this.lloc != null) {
      paramJceOutputStream.write(this.lloc, 4);
    }
    if (this.batchid != null) {
      paramJceOutputStream.write(this.batchid, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\share_outsite_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */