package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RegisterHttpShortConnectionResp
  extends JceStruct
{
  static ArrayList cache_vBusiPacks;
  static byte[] cache_vCookies;
  static byte[] cache_vSig;
  public byte bReloadSvrlist;
  public long uInterval;
  public ArrayList vBusiPacks;
  public byte[] vCookies;
  public byte[] vSig;
  
  public RegisterHttpShortConnectionResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RegisterHttpShortConnectionResp(byte[] paramArrayOfByte1, ArrayList paramArrayList, long paramLong, byte[] paramArrayOfByte2, byte paramByte)
  {
    this.vCookies = paramArrayOfByte1;
    this.vBusiPacks = paramArrayList;
    this.uInterval = paramLong;
    this.vSig = paramArrayOfByte2;
    this.bReloadSvrlist = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vCookies == null)
    {
      cache_vCookies = (byte[])new byte[1];
      ((byte[])cache_vCookies)[0] = 0;
    }
    this.vCookies = ((byte[])paramJceInputStream.read(cache_vCookies, 0, true));
    if (cache_vBusiPacks == null)
    {
      cache_vBusiPacks = new ArrayList();
      RegisterHttpShortConnectionBusiPack localRegisterHttpShortConnectionBusiPack = new RegisterHttpShortConnectionBusiPack();
      cache_vBusiPacks.add(localRegisterHttpShortConnectionBusiPack);
    }
    this.vBusiPacks = ((ArrayList)paramJceInputStream.read(cache_vBusiPacks, 1, true));
    this.uInterval = paramJceInputStream.read(this.uInterval, 2, false);
    if (cache_vSig == null)
    {
      cache_vSig = (byte[])new byte[1];
      ((byte[])cache_vSig)[0] = 0;
    }
    this.vSig = ((byte[])paramJceInputStream.read(cache_vSig, 3, false));
    this.bReloadSvrlist = paramJceInputStream.read(this.bReloadSvrlist, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vCookies, 0);
    paramJceOutputStream.write(this.vBusiPacks, 1);
    paramJceOutputStream.write(this.uInterval, 2);
    if (this.vSig != null) {
      paramJceOutputStream.write(this.vSig, 3);
    }
    paramJceOutputStream.write(this.bReloadSvrlist, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\RegisterProxySvcPack\RegisterHttpShortConnectionResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */