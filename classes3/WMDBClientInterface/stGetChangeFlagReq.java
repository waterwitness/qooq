package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetChangeFlagReq
  extends JceStruct
{
  public int changeVersion = 0;
  
  public stGetChangeFlagReq() {}
  
  public stGetChangeFlagReq(int paramInt)
  {
    this.changeVersion = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.changeVersion = paramJceInputStream.read(this.changeVersion, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.changeVersion, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\WMDBClientInterface\stGetChangeFlagReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */