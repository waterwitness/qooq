package qqwifi;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class WiFiAccountReq
  extends JceStruct
{
  public byte barsetting;
  public long crc;
  public long seqno;
  public long uin;
  
  public WiFiAccountReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public WiFiAccountReq(long paramLong1, long paramLong2, long paramLong3, byte paramByte)
  {
    this.uin = paramLong1;
    this.seqno = paramLong2;
    this.crc = paramLong3;
    this.barsetting = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.seqno = paramJceInputStream.read(this.seqno, 1, true);
    this.crc = paramJceInputStream.read(this.crc, 2, true);
    this.barsetting = paramJceInputStream.read(this.barsetting, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.seqno, 1);
    paramJceOutputStream.write(this.crc, 2);
    paramJceOutputStream.write(this.barsetting, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qqwifi\WiFiAccountReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */