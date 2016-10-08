package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class change_vkey_req
  extends JceStruct
{
  static ArrayList cache_video_urls;
  public ArrayList video_urls;
  
  public change_vkey_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public change_vkey_req(ArrayList paramArrayList)
  {
    this.video_urls = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_video_urls == null)
    {
      cache_video_urls = new ArrayList();
      cache_video_urls.add("");
    }
    this.video_urls = ((ArrayList)paramJceInputStream.read(cache_video_urls, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.video_urls != null) {
      paramJceOutputStream.write(this.video_urls, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\change_vkey_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */