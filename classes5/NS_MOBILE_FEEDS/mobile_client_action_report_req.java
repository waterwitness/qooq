package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class mobile_client_action_report_req
  extends JceStruct
{
  static Map cache_extendinfo;
  static int cache_report_feed_type = 0;
  static int cache_user_action;
  public long action_subtype;
  public Map extendinfo;
  public int report_feed_type;
  public int user_action;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_user_action = 0;
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public mobile_client_action_report_req() {}
  
  public mobile_client_action_report_req(int paramInt1, long paramLong, Map paramMap, int paramInt2)
  {
    this.user_action = paramInt1;
    this.action_subtype = paramLong;
    this.extendinfo = paramMap;
    this.report_feed_type = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.user_action = paramJceInputStream.read(this.user_action, 0, true);
    this.action_subtype = paramJceInputStream.read(this.action_subtype, 1, true);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 2, false));
    this.report_feed_type = paramJceInputStream.read(this.report_feed_type, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.user_action, 0);
    paramJceOutputStream.write(this.action_subtype, 1);
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 2);
    }
    paramJceOutputStream.write(this.report_feed_type, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\mobile_client_action_report_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */