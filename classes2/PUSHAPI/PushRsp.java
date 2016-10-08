package PUSHAPI;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PushRsp
  extends JceStruct
{
  static byte[] cache_UID;
  public String Mark = "";
  public byte[] UID;
  public long flag;
  public byte is_bgd;
  public long ptime;
  public String sUID = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_UID = (byte[])new byte[1];
    ((byte[])cache_UID)[0] = 0;
  }
  
  public PushRsp() {}
  
  public PushRsp(byte[] paramArrayOfByte, long paramLong1, String paramString1, byte paramByte, String paramString2, long paramLong2)
  {
    this.UID = paramArrayOfByte;
    this.ptime = paramLong1;
    this.Mark = paramString1;
    this.is_bgd = paramByte;
    this.sUID = paramString2;
    this.flag = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.UID = ((byte[])paramJceInputStream.read(cache_UID, 0, false));
    this.ptime = paramJceInputStream.read(this.ptime, 1, false);
    this.Mark = paramJceInputStream.readString(3, false);
    this.is_bgd = paramJceInputStream.read(this.is_bgd, 4, false);
    this.sUID = paramJceInputStream.readString(5, false);
    this.flag = paramJceInputStream.read(this.flag, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.UID != null) {
      paramJceOutputStream.write(this.UID, 0);
    }
    paramJceOutputStream.write(this.ptime, 1);
    if (this.Mark != null) {
      paramJceOutputStream.write(this.Mark, 3);
    }
    paramJceOutputStream.write(this.is_bgd, 4);
    if (this.sUID != null) {
      paramJceOutputStream.write(this.sUID, 5);
    }
    paramJceOutputStream.write(this.flag, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\PUSHAPI\PushRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */