package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class VideoBanner
  extends JceStruct
{
  static ArrayList cache_videos;
  public String nick = "";
  public long uUin;
  public ArrayList videos;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_videos = new ArrayList();
    OneVideoInfo localOneVideoInfo = new OneVideoInfo();
    cache_videos.add(localOneVideoInfo);
  }
  
  public VideoBanner() {}
  
  public VideoBanner(long paramLong, ArrayList paramArrayList, String paramString)
  {
    this.uUin = paramLong;
    this.videos = paramArrayList;
    this.nick = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uUin = paramJceInputStream.read(this.uUin, 0, false);
    this.videos = ((ArrayList)paramJceInputStream.read(cache_videos, 1, false));
    this.nick = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uUin, 0);
    if (this.videos != null) {
      paramJceOutputStream.write(this.videos, 1);
    }
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_AD_BANNER\VideoBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */