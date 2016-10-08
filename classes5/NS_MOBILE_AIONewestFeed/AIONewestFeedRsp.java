package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class AIONewestFeedRsp
  extends JceStruct
{
  static ArrayList cache_uFeedInfos;
  public ArrayList uFeedInfos;
  public long uOpuin;
  public long uTime;
  
  public AIONewestFeedRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AIONewestFeedRsp(long paramLong1, long paramLong2, ArrayList paramArrayList)
  {
    this.uOpuin = paramLong1;
    this.uTime = paramLong2;
    this.uFeedInfos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uOpuin = paramJceInputStream.read(this.uOpuin, 0, false);
    this.uTime = paramJceInputStream.read(this.uTime, 1, false);
    if (cache_uFeedInfos == null)
    {
      cache_uFeedInfos = new ArrayList();
      NewestFeedInfo localNewestFeedInfo = new NewestFeedInfo();
      cache_uFeedInfos.add(localNewestFeedInfo);
    }
    this.uFeedInfos = ((ArrayList)paramJceInputStream.read(cache_uFeedInfos, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uOpuin, 0);
    paramJceOutputStream.write(this.uTime, 1);
    if (this.uFeedInfos != null) {
      paramJceOutputStream.write(this.uFeedInfos, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_AIONewestFeed\AIONewestFeedRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */