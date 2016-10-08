package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class operat_data
  extends JceStruct
{
  static Map cache_mapExt;
  public int cmd;
  public String desc;
  public Map mapExt;
  
  public operat_data()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.desc = "";
  }
  
  public operat_data(int paramInt, String paramString, Map paramMap)
  {
    this.desc = "";
    this.cmd = paramInt;
    this.desc = paramString;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmd = paramJceInputStream.read(this.cmd, 0, false);
    this.desc = paramJceInputStream.readString(1, false);
    if (cache_mapExt == null)
    {
      cache_mapExt = new HashMap();
      cache_mapExt.put("", "");
    }
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmd, 0);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 1);
    }
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\operat_data.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */