package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class PicExtendInfo
  extends JceStruct
{
  private static ArrayList<QuanInfo> a = new ArrayList();
  private static Map<String, String> b;
  private static Map<String, String> c;
  public int iEffect = 0;
  public Map<String, String> mapExif = null;
  public Map<String, String> mapParams = null;
  public String sUserDefineSource = "";
  public ArrayList<QuanInfo> vQuanInfo = null;
  
  static
  {
    QuanInfo localQuanInfo = new QuanInfo();
    a.add(localQuanInfo);
    b = new HashMap();
    b.put("", "");
    c = new HashMap();
    c.put("", "");
  }
  
  public PicExtendInfo() {}
  
  public PicExtendInfo(int paramInt, ArrayList<QuanInfo> paramArrayList, Map<String, String> paramMap1, String paramString, Map<String, String> paramMap2)
  {
    this.iEffect = paramInt;
    this.vQuanInfo = paramArrayList;
    this.mapExif = paramMap1;
    this.sUserDefineSource = paramString;
    this.mapParams = paramMap2;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.iEffect = paramJceInputStream.read(this.iEffect, 0, false);
    this.vQuanInfo = ((ArrayList)paramJceInputStream.read(a, 1, false));
    this.mapExif = ((Map)paramJceInputStream.read(b, 2, false));
    this.sUserDefineSource = paramJceInputStream.readString(3, false);
    this.mapParams = ((Map)paramJceInputStream.read(c, 4, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iEffect, 0);
    if (this.vQuanInfo != null) {
      paramJceOutputStream.write(this.vQuanInfo, 1);
    }
    if (this.mapExif != null) {
      paramJceOutputStream.write(this.mapExif, 2);
    }
    if (this.sUserDefineSource != null) {
      paramJceOutputStream.write(this.sUserDefineSource, 3);
    }
    if (this.mapParams != null) {
      paramJceOutputStream.write(this.mapParams, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\PicExtendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */