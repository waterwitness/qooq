package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class count_info
  extends JceStruct
{
  static single_count cache_stCount;
  static ArrayList cache_vecUinList;
  public single_count stCount;
  public String trace_info = "";
  public ArrayList vecUinList;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_stCount = new single_count();
    cache_vecUinList = new ArrayList();
    feed_host_info localfeed_host_info = new feed_host_info();
    cache_vecUinList.add(localfeed_host_info);
  }
  
  public count_info() {}
  
  public count_info(single_count paramsingle_count, ArrayList paramArrayList, String paramString)
  {
    this.stCount = paramsingle_count;
    this.vecUinList = paramArrayList;
    this.trace_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCount = ((single_count)paramJceInputStream.read(cache_stCount, 0, false));
    this.vecUinList = ((ArrayList)paramJceInputStream.read(cache_vecUinList, 1, false));
    this.trace_info = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stCount != null) {
      paramJceOutputStream.write(this.stCount, 0);
    }
    if (this.vecUinList != null) {
      paramJceOutputStream.write(this.vecUinList, 1);
    }
    if (this.trace_info != null) {
      paramJceOutputStream.write(this.trace_info, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\count_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */