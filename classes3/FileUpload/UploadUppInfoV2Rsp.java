package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UploadUppInfoV2Rsp
  extends JceStruct
{
  private static Map<Long, stPhotoSepcInfo> d = new HashMap();
  public String a = "";
  public String b = "";
  public Map<Long, stPhotoSepcInfo> c = null;
  
  static
  {
    stPhotoSepcInfo localstPhotoSepcInfo = new stPhotoSepcInfo();
    d.put(Long.valueOf(0L), localstPhotoSepcInfo);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = paramJceInputStream.readString(1, true);
    this.c = ((Map)paramJceInputStream.read(d, 2, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\UploadUppInfoV2Rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */