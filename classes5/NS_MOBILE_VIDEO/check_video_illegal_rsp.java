package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class check_video_illegal_rsp
  extends JceStruct
{
  static Map cache_video_urls;
  public String illegal_msg = "";
  public String msg = "";
  public int ret;
  public Map video_urls;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_video_urls = new HashMap();
    UrlRsp localUrlRsp = new UrlRsp();
    cache_video_urls.put("", localUrlRsp);
  }
  
  public check_video_illegal_rsp() {}
  
  public check_video_illegal_rsp(int paramInt, String paramString1, Map paramMap, String paramString2)
  {
    this.ret = paramInt;
    this.msg = paramString1;
    this.video_urls = paramMap;
    this.illegal_msg = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.video_urls = ((Map)paramJceInputStream.read(cache_video_urls, 2, false));
    this.illegal_msg = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.video_urls != null) {
      paramJceOutputStream.write(this.video_urls, 2);
    }
    if (this.illegal_msg != null) {
      paramJceOutputStream.write(this.illegal_msg, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\check_video_illegal_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */