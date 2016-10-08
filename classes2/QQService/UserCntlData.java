package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UserCntlData
  extends JceStruct
{
  static byte[] cache_strCookie;
  public long lNextMid;
  public byte[] strCookie;
  
  public UserCntlData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UserCntlData(long paramLong, byte[] paramArrayOfByte)
  {
    this.lNextMid = paramLong;
    this.strCookie = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lNextMid = paramJceInputStream.read(this.lNextMid, 0, true);
    if (cache_strCookie == null)
    {
      cache_strCookie = (byte[])new byte[1];
      ((byte[])cache_strCookie)[0] = 0;
    }
    this.strCookie = ((byte[])paramJceInputStream.read(cache_strCookie, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lNextMid, 0);
    if (this.strCookie != null) {
      paramJceOutputStream.write(this.strCookie, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\UserCntlData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */