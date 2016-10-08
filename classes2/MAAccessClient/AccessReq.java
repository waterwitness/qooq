package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class AccessReq
  extends JceStruct
{
  static byte[] cache_body;
  public byte[] body;
  public int gray;
  public String imei = "";
  public String manufacture = "";
  public String mode = "";
  public String rom = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_body = (byte[])new byte[1];
    ((byte[])cache_body)[0] = 0;
  }
  
  public AccessReq() {}
  
  public AccessReq(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, byte[] paramArrayOfByte)
  {
    this.imei = paramString1;
    this.mode = paramString2;
    this.manufacture = paramString3;
    this.rom = paramString4;
    this.gray = paramInt;
    this.body = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, false);
    this.mode = paramJceInputStream.readString(1, false);
    this.manufacture = paramJceInputStream.readString(2, false);
    this.rom = paramJceInputStream.readString(3, false);
    this.gray = paramJceInputStream.read(this.gray, 4, false);
    this.body = ((byte[])paramJceInputStream.read(cache_body, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 0);
    }
    if (this.mode != null) {
      paramJceOutputStream.write(this.mode, 1);
    }
    if (this.manufacture != null) {
      paramJceOutputStream.write(this.manufacture, 2);
    }
    if (this.rom != null) {
      paramJceOutputStream.write(this.rom, 3);
    }
    paramJceOutputStream.write(this.gray, 4);
    if (this.body != null) {
      paramJceOutputStream.write(this.body, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MAAccessClient\AccessReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */