package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RegisterHttpShortConnectionBusiPack
  extends JceStruct
{
  static byte[] cache_vBusi;
  public String strSvcCmd;
  public long uSeq;
  public byte[] vBusi;
  
  public RegisterHttpShortConnectionBusiPack()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strSvcCmd = "";
  }
  
  public RegisterHttpShortConnectionBusiPack(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.strSvcCmd = "";
    this.strSvcCmd = paramString;
    this.uSeq = paramLong;
    this.vBusi = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strSvcCmd = paramJceInputStream.readString(0, true);
    this.uSeq = paramJceInputStream.read(this.uSeq, 1, true);
    if (cache_vBusi == null)
    {
      cache_vBusi = (byte[])new byte[1];
      ((byte[])cache_vBusi)[0] = 0;
    }
    this.vBusi = ((byte[])paramJceInputStream.read(cache_vBusi, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strSvcCmd, 0);
    paramJceOutputStream.write(this.uSeq, 1);
    paramJceOutputStream.write(this.vBusi, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\RegisterProxySvcPack\RegisterHttpShortConnectionBusiPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */