package AndroidClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stVerifyBlackListRsp
  extends JceStruct
{
  public int iValue = 0;
  
  public stVerifyBlackListRsp() {}
  
  public stVerifyBlackListRsp(int paramInt)
  {
    this.iValue = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iValue = paramJceInputStream.read(this.iValue, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iValue, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\AndroidClientInterface\stVerifyBlackListRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */