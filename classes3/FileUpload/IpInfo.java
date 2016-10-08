package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IpInfo
  extends JceStruct
{
  public int ip = 0;
  public short port = 0;
  
  public IpInfo() {}
  
  public IpInfo(int paramInt, short paramShort)
  {
    this.ip = paramInt;
    this.port = paramShort;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.ip = paramJceInputStream.read(this.ip, 0, false);
    this.port = paramJceInputStream.read(this.port, 1, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ip, 0);
    paramJceOutputStream.write(this.port, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\IpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */