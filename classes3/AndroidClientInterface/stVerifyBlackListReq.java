package AndroidClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stVerifyBlackListReq
  extends JceStruct
{
  public String strModelName = "";
  
  public stVerifyBlackListReq() {}
  
  public stVerifyBlackListReq(String paramString)
  {
    this.strModelName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strModelName = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strModelName, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\AndroidClientInterface\stVerifyBlackListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */