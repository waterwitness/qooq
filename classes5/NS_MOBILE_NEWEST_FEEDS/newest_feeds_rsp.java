package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class newest_feeds_rsp
  extends JceStruct
{
  static ArrayList cache_vec_feed_info;
  public int code;
  public long last_feed_time;
  public String str_attach;
  public ArrayList vec_feed_info;
  
  public newest_feeds_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.str_attach = "";
  }
  
  public newest_feeds_rsp(int paramInt, ArrayList paramArrayList, long paramLong, String paramString)
  {
    this.str_attach = "";
    this.code = paramInt;
    this.vec_feed_info = paramArrayList;
    this.last_feed_time = paramLong;
    this.str_attach = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
    if (cache_vec_feed_info == null)
    {
      cache_vec_feed_info = new ArrayList();
      feed_info localfeed_info = new feed_info();
      cache_vec_feed_info.add(localfeed_info);
    }
    this.vec_feed_info = ((ArrayList)paramJceInputStream.read(cache_vec_feed_info, 1, false));
    this.last_feed_time = paramJceInputStream.read(this.last_feed_time, 2, false);
    this.str_attach = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    if (this.vec_feed_info != null) {
      paramJceOutputStream.write(this.vec_feed_info, 1);
    }
    paramJceOutputStream.write(this.last_feed_time, 2);
    if (this.str_attach != null) {
      paramJceOutputStream.write(this.str_attach, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_NEWEST_FEEDS\newest_feeds_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */