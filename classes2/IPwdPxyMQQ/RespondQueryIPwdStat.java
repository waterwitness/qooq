package IPwdPxyMQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespondQueryIPwdStat
  extends JceStruct
{
  public long uIsSetPwd;
  
  public RespondQueryIPwdStat()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespondQueryIPwdStat(long paramLong)
  {
    this.uIsSetPwd = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uIsSetPwd = paramJceInputStream.read(this.uIsSetPwd, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uIsSetPwd, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IPwdPxyMQQ\RespondQueryIPwdStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */