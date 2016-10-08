package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class newest_feeds_req
  extends JceStruct
{
  static ArrayList cache_vec_uinlist;
  public int cmd;
  public long last_feed_time;
  public long login_uin;
  public String str_attach;
  public ArrayList vec_uinlist;
  
  public newest_feeds_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.str_attach = "";
  }
  
  public newest_feeds_req(int paramInt, long paramLong1, ArrayList paramArrayList, long paramLong2, String paramString)
  {
    this.str_attach = "";
    this.cmd = paramInt;
    this.login_uin = paramLong1;
    this.vec_uinlist = paramArrayList;
    this.last_feed_time = paramLong2;
    this.str_attach = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmd = paramJceInputStream.read(this.cmd, 0, false);
    this.login_uin = paramJceInputStream.read(this.login_uin, 1, false);
    if (cache_vec_uinlist == null)
    {
      cache_vec_uinlist = new ArrayList();
      cache_vec_uinlist.add(Long.valueOf(0L));
    }
    this.vec_uinlist = ((ArrayList)paramJceInputStream.read(cache_vec_uinlist, 2, false));
    this.last_feed_time = paramJceInputStream.read(this.last_feed_time, 3, false);
    this.str_attach = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmd, 0);
    paramJceOutputStream.write(this.login_uin, 1);
    if (this.vec_uinlist != null) {
      paramJceOutputStream.write(this.vec_uinlist, 2);
    }
    paramJceOutputStream.write(this.last_feed_time, 3);
    if (this.str_attach != null) {
      paramJceOutputStream.write(this.str_attach, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_NEWEST_FEEDS\newest_feeds_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */