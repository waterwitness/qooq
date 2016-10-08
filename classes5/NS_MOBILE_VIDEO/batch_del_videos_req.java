package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class batch_del_videos_req
  extends JceStruct
{
  static ArrayList cache_vids;
  public long uin;
  public ArrayList vids;
  
  public batch_del_videos_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public batch_del_videos_req(long paramLong, ArrayList paramArrayList)
  {
    this.uin = paramLong;
    this.vids = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    if (cache_vids == null)
    {
      cache_vids = new ArrayList();
      cache_vids.add("");
    }
    this.vids = ((ArrayList)paramJceInputStream.read(cache_vids, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.vids != null) {
      paramJceOutputStream.write(this.vids, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\batch_del_videos_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */