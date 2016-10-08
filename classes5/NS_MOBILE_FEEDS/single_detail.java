package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class single_detail
  extends JceStruct
{
  static Map cache_singledetail;
  public Map singledetail;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_singledetail = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_singledetail.put(Integer.valueOf(0), arrayOfByte);
  }
  
  public single_detail() {}
  
  public single_detail(Map paramMap)
  {
    this.singledetail = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.singledetail = ((Map)paramJceInputStream.read(cache_singledetail, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.singledetail != null) {
      paramJceOutputStream.write(this.singledetail, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\single_detail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */