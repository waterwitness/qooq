package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UploadVideoInfoRsp
  extends JceStruct
{
  private static byte[] a;
  public int iBusiNessType = 0;
  public String sVid = "";
  public byte[] vBusiNessData = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    a = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public UploadVideoInfoRsp() {}
  
  public UploadVideoInfoRsp(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    this.sVid = paramString;
    this.iBusiNessType = paramInt;
    this.vBusiNessData = paramArrayOfByte;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.sVid = paramJceInputStream.readString(0, false);
    this.iBusiNessType = paramJceInputStream.read(this.iBusiNessType, 1, false);
    this.vBusiNessData = ((byte[])paramJceInputStream.read(a, 2, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sVid != null) {
      paramJceOutputStream.write(this.sVid, 0);
    }
    paramJceOutputStream.write(this.iBusiNessType, 1);
    if (this.vBusiNessData != null) {
      paramJceOutputStream.write(this.vBusiNessData, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\UploadVideoInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */