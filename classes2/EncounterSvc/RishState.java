package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RishState
  extends JceStruct
{
  static byte[] cache_vState;
  public long uModifyTime;
  public byte[] vState;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_vState = (byte[])new byte[1];
    ((byte[])cache_vState)[0] = 0;
  }
  
  public RishState() {}
  
  public RishState(byte[] paramArrayOfByte, long paramLong)
  {
    this.vState = paramArrayOfByte;
    this.uModifyTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vState = ((byte[])paramJceInputStream.read(cache_vState, 0, true));
    this.uModifyTime = paramJceInputStream.read(this.uModifyTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vState, 0);
    paramJceOutputStream.write(this.uModifyTime, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\RishState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */