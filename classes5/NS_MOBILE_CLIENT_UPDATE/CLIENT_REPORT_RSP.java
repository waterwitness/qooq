package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class CLIENT_REPORT_RSP
  extends JceStruct
{
  static Map cache_msg;
  public int code;
  public Map msg;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_msg = new HashMap();
    cache_msg.put("", "");
  }
  
  public CLIENT_REPORT_RSP() {}
  
  public CLIENT_REPORT_RSP(int paramInt, Map paramMap)
  {
    this.code = paramInt;
    this.msg = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
    this.msg = ((Map)paramJceInputStream.read(cache_msg, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_CLIENT_UPDATE\CLIENT_REPORT_RSP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */