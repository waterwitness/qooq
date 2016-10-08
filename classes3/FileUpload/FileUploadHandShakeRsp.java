package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class FileUploadHandShakeRsp
  extends JceStruct
{
  private static ArrayList<IpInfo> e = new ArrayList();
  public ArrayList<IpInfo> a = null;
  public int b = 0;
  public long c = 0L;
  public long d = 0L;
  
  static
  {
    IpInfo localIpInfo = new IpInfo();
    e.add(localIpInfo);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((ArrayList)paramJceInputStream.read(e, 0, false));
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.read(this.c, 2, false);
    this.d = paramJceInputStream.read(this.d, 3, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.a != null) {
      paramJceOutputStream.write(this.a, 0);
    }
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\FileUploadHandShakeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */