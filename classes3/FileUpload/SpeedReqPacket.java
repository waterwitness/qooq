package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SpeedReqPacket
  extends JceStruct
{
  private static byte[] c;
  private String a = "";
  private byte[] b = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    c = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = ((byte[])paramJceInputStream.read(c, 1, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\SpeedReqPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */