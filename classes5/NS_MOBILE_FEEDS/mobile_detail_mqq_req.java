package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class mobile_detail_mqq_req
  extends JceStruct
{
  static Map cache_mqqinfo;
  public Map mqqinfo;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_mqqinfo = new HashMap();
    cache_mqqinfo.put("", "");
  }
  
  public mobile_detail_mqq_req() {}
  
  public mobile_detail_mqq_req(Map paramMap)
  {
    this.mqqinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mqqinfo = ((Map)paramJceInputStream.read(cache_mqqinfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mqqinfo, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\mobile_detail_mqq_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */