package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UserCntlData
  extends JceStruct
{
  public long lLastPos;
  public int nVersion;
  
  public UserCntlData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UserCntlData(int paramInt, long paramLong)
  {
    this.nVersion = paramInt;
    this.lLastPos = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nVersion = paramJceInputStream.read(this.nVersion, 0, false);
    this.lLastPos = paramJceInputStream.read(this.lLastPos, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nVersion, 0);
    paramJceOutputStream.write(this.lLastPos, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\UserCntlData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */