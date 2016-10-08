package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class cell_extend
  extends JceStruct
{
  static Map cache_mapEx;
  public Map mapEx;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_mapEx = new HashMap();
    cache_mapEx.put("", "");
  }
  
  public cell_extend() {}
  
  public cell_extend(Map paramMap)
  {
    this.mapEx = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapEx = ((Map)paramJceInputStream.read(cache_mapEx, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapEx != null) {
      paramJceOutputStream.write(this.mapEx, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_extend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */