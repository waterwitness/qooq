package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UploadUpsInfoRsp
  extends JceStruct
{
  private static byte[] a;
  private static Map<Long, String> b;
  public int iHight = 0;
  public int iPhotoType = 0;
  public int iType = 0;
  public int iWidth = 0;
  public String sUrl = "";
  public Map<Long, String> sUrls = null;
  public byte[] vBusiNessData = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    a = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    b = new HashMap();
    b.put(Long.valueOf(0L), "");
  }
  
  public UploadUpsInfoRsp() {}
  
  public UploadUpsInfoRsp(int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2, int paramInt3, int paramInt4, Map<Long, String> paramMap)
  {
    this.iType = paramInt1;
    this.vBusiNessData = paramArrayOfByte;
    this.sUrl = paramString;
    this.iWidth = paramInt2;
    this.iHight = paramInt3;
    this.iPhotoType = paramInt4;
    this.sUrls = paramMap;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.iType = paramJceInputStream.read(this.iType, 0, true);
    this.vBusiNessData = ((byte[])paramJceInputStream.read(a, 1, false));
    this.sUrl = paramJceInputStream.readString(2, false);
    this.iWidth = paramJceInputStream.read(this.iWidth, 3, false);
    this.iHight = paramJceInputStream.read(this.iHight, 4, false);
    this.iPhotoType = paramJceInputStream.read(this.iPhotoType, 5, false);
    this.sUrls = ((Map)paramJceInputStream.read(b, 6, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iType, 0);
    if (this.vBusiNessData != null) {
      paramJceOutputStream.write(this.vBusiNessData, 1);
    }
    if (this.sUrl != null) {
      paramJceOutputStream.write(this.sUrl, 2);
    }
    paramJceOutputStream.write(this.iWidth, 3);
    paramJceOutputStream.write(this.iHight, 4);
    paramJceOutputStream.write(this.iPhotoType, 5);
    if (this.sUrls != null) {
      paramJceOutputStream.write(this.sUrls, 6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\UploadUpsInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */