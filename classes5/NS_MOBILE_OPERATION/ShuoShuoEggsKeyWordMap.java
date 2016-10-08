package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class ShuoShuoEggsKeyWordMap
  extends JceStruct
{
  static Map cache_mapKeyWordEggs;
  public Map mapKeyWordEggs;
  
  public ShuoShuoEggsKeyWordMap()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ShuoShuoEggsKeyWordMap(Map paramMap)
  {
    this.mapKeyWordEggs = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_mapKeyWordEggs == null)
    {
      cache_mapKeyWordEggs = new HashMap();
      ImageSummaryList localImageSummaryList = new ImageSummaryList();
      cache_mapKeyWordEggs.put("", localImageSummaryList);
    }
    this.mapKeyWordEggs = ((Map)paramJceInputStream.read(cache_mapKeyWordEggs, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapKeyWordEggs != null) {
      paramJceOutputStream.write(this.mapKeyWordEggs, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\ShuoShuoEggsKeyWordMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */