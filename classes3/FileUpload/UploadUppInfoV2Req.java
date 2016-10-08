package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UploadUppInfoV2Req
  extends JceStruct
{
  private static stPhotoSepcInfo n = new stPhotoSepcInfo();
  private static Map<String, String> o = new HashMap();
  private static MultiPicInfo p = new MultiPicInfo();
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 0;
  public long g = 0L;
  public stPhotoSepcInfo h = null;
  public Map<String, String> i = null;
  public String j = "";
  public long k = 0L;
  public MultiPicInfo l = null;
  private int m = 0;
  
  static
  {
    o.put("", "");
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = paramJceInputStream.readString(1, true);
    this.c = paramJceInputStream.readString(2, true);
    this.d = paramJceInputStream.readString(3, true);
    this.e = paramJceInputStream.readString(4, true);
    this.f = paramJceInputStream.read(this.f, 5, true);
    this.g = paramJceInputStream.read(this.g, 6, true);
    this.h = ((stPhotoSepcInfo)paramJceInputStream.read(n, 7, true));
    this.i = ((Map)paramJceInputStream.read(o, 8, false));
    this.j = paramJceInputStream.readString(9, false);
    this.k = paramJceInputStream.read(this.k, 10, false);
    this.l = ((MultiPicInfo)paramJceInputStream.read(p, 11, false));
    this.m = paramJceInputStream.read(this.m, 12, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    paramJceOutputStream.write(this.f, 5);
    paramJceOutputStream.write(this.g, 6);
    paramJceOutputStream.write(this.h, 7);
    if (this.i != null) {
      paramJceOutputStream.write(this.i, 8);
    }
    if (this.j != null) {
      paramJceOutputStream.write(this.j, 9);
    }
    paramJceOutputStream.write(this.k, 10);
    if (this.l != null) {
      paramJceOutputStream.write(this.l, 11);
    }
    paramJceOutputStream.write(this.m, 12);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\UploadUppInfoV2Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */