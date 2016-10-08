package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class CLIENT_REPORT_REQ
  extends JceStruct
{
  static Map cache_extra_info;
  static ArrayList cache_info;
  public Map extra_info;
  public ArrayList info;
  public long type;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_info = new ArrayList();
    HashMap localHashMap = new HashMap();
    localHashMap.put("", "");
    cache_info.add(localHashMap);
    cache_extra_info = new HashMap();
    cache_extra_info.put("", "");
  }
  
  public CLIENT_REPORT_REQ() {}
  
  public CLIENT_REPORT_REQ(long paramLong, ArrayList paramArrayList, Map paramMap)
  {
    this.type = paramLong;
    this.info = paramArrayList;
    this.extra_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.info = ((ArrayList)paramJceInputStream.read(cache_info, 1, false));
    this.extra_info = ((Map)paramJceInputStream.read(cache_extra_info, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.info != null) {
      paramJceOutputStream.write(this.info, 1);
    }
    if (this.extra_info != null) {
      paramJceOutputStream.write(this.extra_info, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_CLIENT_UPDATE\CLIENT_REPORT_REQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */