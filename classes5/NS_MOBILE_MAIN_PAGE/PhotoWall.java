package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class PhotoWall
  extends JceStruct
{
  static Map cache_photoUrls;
  public long ctime;
  public String photoId;
  public Map photoUrls;
  
  public PhotoWall()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.photoId = "";
  }
  
  public PhotoWall(String paramString, long paramLong, Map paramMap)
  {
    this.photoId = "";
    this.photoId = paramString;
    this.ctime = paramLong;
    this.photoUrls = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photoId = paramJceInputStream.readString(0, true);
    this.ctime = paramJceInputStream.read(this.ctime, 1, false);
    if (cache_photoUrls == null)
    {
      cache_photoUrls = new HashMap();
      cache_photoUrls.put(Integer.valueOf(0), "");
    }
    this.photoUrls = ((Map)paramJceInputStream.read(cache_photoUrls, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.photoId, 0);
    paramJceOutputStream.write(this.ctime, 1);
    if (this.photoUrls != null) {
      paramJceOutputStream.write(this.photoUrls, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\PhotoWall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */