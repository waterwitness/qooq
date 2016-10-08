package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SvrConfigInfo
  extends JceStruct
{
  private static Map<String, String> a = new HashMap();
  public Map<String, String> mapConfigs = null;
  
  static
  {
    a.put("", "");
  }
  
  public SvrConfigInfo() {}
  
  public SvrConfigInfo(Map<String, String> paramMap)
  {
    this.mapConfigs = paramMap;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapConfigs = ((Map)paramJceInputStream.read(a, 0, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapConfigs != null) {
      paramJceOutputStream.write(this.mapConfigs, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\SvrConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */