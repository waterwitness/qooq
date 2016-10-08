package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DCacheUserInfo
  extends JceStruct
{
  static byte[] cache_strBlackList;
  public byte cPushNbTimes;
  public int iAtoRTimes;
  public int iRtoATimes;
  public int lTime;
  public byte[] strBlackList;
  
  public DCacheUserInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DCacheUserInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, byte paramByte)
  {
    this.strBlackList = paramArrayOfByte;
    this.lTime = paramInt1;
    this.iAtoRTimes = paramInt2;
    this.iRtoATimes = paramInt3;
    this.cPushNbTimes = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_strBlackList == null)
    {
      cache_strBlackList = (byte[])new byte[1];
      ((byte[])cache_strBlackList)[0] = 0;
    }
    this.strBlackList = ((byte[])paramJceInputStream.read(cache_strBlackList, 0, true));
    this.lTime = paramJceInputStream.read(this.lTime, 1, false);
    this.iAtoRTimes = paramJceInputStream.read(this.iAtoRTimes, 2, false);
    this.iRtoATimes = paramJceInputStream.read(this.iRtoATimes, 3, false);
    this.cPushNbTimes = paramJceInputStream.read(this.cPushNbTimes, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strBlackList, 0);
    paramJceOutputStream.write(this.lTime, 1);
    paramJceOutputStream.write(this.iAtoRTimes, 2);
    paramJceOutputStream.write(this.iRtoATimes, 3);
    paramJceOutputStream.write(this.cPushNbTimes, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AccostSvc\DCacheUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */