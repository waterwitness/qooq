package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class s_shoot_info
  extends JceStruct
{
  static Map cache_extendinfo;
  static s_gps cache_shoot_gps;
  public Map extendinfo;
  public s_gps shoot_gps;
  public String shoot_location = "";
  public long shoot_time;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_shoot_gps = new s_gps();
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public s_shoot_info() {}
  
  public s_shoot_info(s_gps params_gps, String paramString, long paramLong, Map paramMap)
  {
    this.shoot_gps = params_gps;
    this.shoot_location = paramString;
    this.shoot_time = paramLong;
    this.extendinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shoot_gps = ((s_gps)paramJceInputStream.read(cache_shoot_gps, 0, false));
    this.shoot_location = paramJceInputStream.readString(1, false);
    this.shoot_time = paramJceInputStream.read(this.shoot_time, 2, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.shoot_gps != null) {
      paramJceOutputStream.write(this.shoot_gps, 0);
    }
    if (this.shoot_location != null) {
      paramJceOutputStream.write(this.shoot_location, 1);
    }
    paramJceOutputStream.write(this.shoot_time, 2);
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_shoot_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */