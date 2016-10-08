package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stRishState
  extends JceStruct
{
  static byte[] cache_vState;
  public long uModifyTime;
  public byte[] vState;
  
  public stRishState()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public stRishState(byte[] paramArrayOfByte, long paramLong)
  {
    this.vState = paramArrayOfByte;
    this.uModifyTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vState == null)
    {
      cache_vState = (byte[])new byte[1];
      ((byte[])cache_vState)[0] = 0;
    }
    this.vState = ((byte[])paramJceInputStream.read(cache_vState, 0, true));
    this.uModifyTime = paramJceInputStream.read(this.uModifyTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vState, 0);
    paramJceOutputStream.write(this.uModifyTime, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\stRishState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */