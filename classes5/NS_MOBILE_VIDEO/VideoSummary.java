package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class VideoSummary
  extends JceStruct
{
  static Map cache_cover;
  public Map cover;
  public int num;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_cover = new HashMap();
    cache_cover.put(Integer.valueOf(0), "");
  }
  
  public VideoSummary() {}
  
  public VideoSummary(int paramInt, Map paramMap)
  {
    this.num = paramInt;
    this.cover = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.cover = ((Map)paramJceInputStream.read(cache_cover, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    if (this.cover != null) {
      paramJceOutputStream.write(this.cover, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\VideoSummary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */