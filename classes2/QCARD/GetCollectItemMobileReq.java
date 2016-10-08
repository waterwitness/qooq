package QCARD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetCollectItemMobileReq
  extends JceStruct
{
  public String appid;
  public String card_id;
  public int field;
  public long sequence;
  public long uin;
  
  public GetCollectItemMobileReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.appid = "";
    this.card_id = "";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.field = paramJceInputStream.read(this.field, 0, true);
    this.appid = paramJceInputStream.readString(1, true);
    this.card_id = paramJceInputStream.readString(2, true);
    this.sequence = paramJceInputStream.read(this.sequence, 3, true);
    this.uin = paramJceInputStream.read(this.uin, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.field, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.card_id, 2);
    paramJceOutputStream.write(this.sequence, 3);
    paramJceOutputStream.write(this.uin, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QCARD\GetCollectItemMobileReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */