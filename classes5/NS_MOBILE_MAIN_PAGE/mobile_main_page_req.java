package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class mobile_main_page_req
  extends JceStruct
{
  static Map cache_mapTimeStamp;
  public String attach_info;
  public byte force;
  public Map mapTimeStamp;
  public long uin;
  public long visituin;
  
  public mobile_main_page_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.attach_info = "";
  }
  
  public mobile_main_page_req(long paramLong1, long paramLong2, byte paramByte, String paramString, Map paramMap)
  {
    this.attach_info = "";
    this.uin = paramLong1;
    this.visituin = paramLong2;
    this.force = paramByte;
    this.attach_info = paramString;
    this.mapTimeStamp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.visituin = paramJceInputStream.read(this.visituin, 1, false);
    this.force = paramJceInputStream.read(this.force, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    if (cache_mapTimeStamp == null)
    {
      cache_mapTimeStamp = new HashMap();
      cache_mapTimeStamp.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    this.mapTimeStamp = ((Map)paramJceInputStream.read(cache_mapTimeStamp, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.visituin, 1);
    paramJceOutputStream.write(this.force, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    if (this.mapTimeStamp != null) {
      paramJceOutputStream.write(this.mapTimeStamp, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_main_page_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */