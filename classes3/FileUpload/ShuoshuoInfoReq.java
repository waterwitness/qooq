package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ShuoshuoInfoReq
  extends JceStruct
{
  private static byte[] f;
  private static ArrayList<ShuoshuoPicInfo> g;
  public String a = "";
  public int b = 0;
  public long c = 0L;
  public byte[] d = null;
  public ArrayList<ShuoshuoPicInfo> e = null;
  
  static
  {
    Object localObject = (byte[])new byte[1];
    f = (byte[])localObject;
    ((byte[])localObject)[0] = 0;
    g = new ArrayList();
    localObject = new ShuoshuoPicInfo();
    g.add(localObject);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    this.d = ((byte[])paramJceInputStream.read(f, 3, true));
    this.e = ((ArrayList)paramJceInputStream.read(g, 4, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\ShuoshuoInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */