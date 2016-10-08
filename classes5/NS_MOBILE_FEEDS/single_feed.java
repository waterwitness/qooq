package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class single_feed
  extends JceStruct
{
  static ArrayList cache_recomfeeds;
  static Map cache_singlefeed;
  public String feed_attach_info = "";
  public String feed_info = "";
  public String feedskey = "";
  public ArrayList recomfeeds;
  public Map singlefeed;
  public long status;
  public int time;
  public long uContainerSubType;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_singlefeed = new HashMap();
    Object localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_singlefeed.put(Integer.valueOf(0), localObject);
    cache_recomfeeds = new ArrayList();
    localObject = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    ((Map)localObject).put(Integer.valueOf(0), arrayOfByte);
    cache_recomfeeds.add(localObject);
  }
  
  public single_feed() {}
  
  public single_feed(Map paramMap, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt, ArrayList paramArrayList, long paramLong2)
  {
    this.singlefeed = paramMap;
    this.status = paramLong1;
    this.feed_info = paramString1;
    this.feed_attach_info = paramString2;
    this.feedskey = paramString3;
    this.time = paramInt;
    this.recomfeeds = paramArrayList;
    this.uContainerSubType = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.singlefeed = ((Map)paramJceInputStream.read(cache_singlefeed, 0, false));
    this.status = paramJceInputStream.read(this.status, 1, false);
    this.feed_info = paramJceInputStream.readString(2, false);
    this.feed_attach_info = paramJceInputStream.readString(3, false);
    this.feedskey = paramJceInputStream.readString(4, false);
    this.time = paramJceInputStream.read(this.time, 5, false);
    this.recomfeeds = ((ArrayList)paramJceInputStream.read(cache_recomfeeds, 6, false));
    this.uContainerSubType = paramJceInputStream.read(this.uContainerSubType, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.singlefeed != null) {
      paramJceOutputStream.write(this.singlefeed, 0);
    }
    paramJceOutputStream.write(this.status, 1);
    if (this.feed_info != null) {
      paramJceOutputStream.write(this.feed_info, 2);
    }
    if (this.feed_attach_info != null) {
      paramJceOutputStream.write(this.feed_attach_info, 3);
    }
    if (this.feedskey != null) {
      paramJceOutputStream.write(this.feedskey, 4);
    }
    paramJceOutputStream.write(this.time, 5);
    if (this.recomfeeds != null) {
      paramJceOutputStream.write(this.recomfeeds, 6);
    }
    paramJceOutputStream.write(this.uContainerSubType, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\single_feed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */