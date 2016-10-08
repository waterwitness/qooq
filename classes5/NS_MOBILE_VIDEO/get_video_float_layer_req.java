package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class get_video_float_layer_req
  extends JceStruct
{
  static Map cache_busi_param;
  static Map cache_extend_info;
  public int appid;
  public String attach_info = "";
  public Map busi_param;
  public Map extend_info;
  public int scene;
  public String ugckey = "";
  public long uin;
  public String video_url = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_extend_info = new HashMap();
    cache_extend_info.put("", "");
  }
  
  public get_video_float_layer_req() {}
  
  public get_video_float_layer_req(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, Map paramMap1, Map paramMap2, String paramString3)
  {
    this.uin = paramLong;
    this.scene = paramInt1;
    this.appid = paramInt2;
    this.ugckey = paramString1;
    this.video_url = paramString2;
    this.busi_param = paramMap1;
    this.extend_info = paramMap2;
    this.attach_info = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.scene = paramJceInputStream.read(this.scene, 1, false);
    this.appid = paramJceInputStream.read(this.appid, 2, false);
    this.ugckey = paramJceInputStream.readString(3, false);
    this.video_url = paramJceInputStream.readString(4, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 5, false));
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 6, false));
    this.attach_info = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.scene, 1);
    paramJceOutputStream.write(this.appid, 2);
    if (this.ugckey != null) {
      paramJceOutputStream.write(this.ugckey, 3);
    }
    if (this.video_url != null) {
      paramJceOutputStream.write(this.video_url, 4);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 5);
    }
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 6);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 7);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\get_video_float_layer_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */