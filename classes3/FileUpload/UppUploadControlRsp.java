package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UppUploadControlRsp
  extends JceStruct
{
  private static Map<Long, stPhotoSepcInfo> h = new HashMap();
  private int a = 0;
  private int b = 0;
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private Map<Long, stPhotoSepcInfo> g = null;
  
  static
  {
    stPhotoSepcInfo localstPhotoSepcInfo = new stPhotoSepcInfo();
    h.put(Long.valueOf(0L), localstPhotoSepcInfo);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.readString(2, false);
    this.d = paramJceInputStream.readString(3, true);
    this.e = paramJceInputStream.readString(4, true);
    this.f = paramJceInputStream.readString(5, true);
    this.g = ((Map)paramJceInputStream.read(h, 6, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    paramJceOutputStream.write(this.f, 5);
    paramJceOutputStream.write(this.g, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\UppUploadControlRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */