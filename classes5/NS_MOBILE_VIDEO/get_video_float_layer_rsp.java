package NS_MOBILE_VIDEO;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class get_video_float_layer_rsp
  extends JceStruct
{
  static ArrayList cache_all_videolist_data;
  static Map cache_busi_param;
  static Map cache_extend_info;
  public ArrayList all_videolist_data;
  public String attach_info = "";
  public Map busi_param;
  public Map extend_info;
  public int hasmore;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_all_videolist_data = new ArrayList();
    single_feed localsingle_feed = new single_feed();
    cache_all_videolist_data.add(localsingle_feed);
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_extend_info = new HashMap();
    cache_extend_info.put("", "");
  }
  
  public get_video_float_layer_rsp() {}
  
  public get_video_float_layer_rsp(ArrayList paramArrayList, Map paramMap1, Map paramMap2, int paramInt, String paramString)
  {
    this.all_videolist_data = paramArrayList;
    this.busi_param = paramMap1;
    this.extend_info = paramMap2;
    this.hasmore = paramInt;
    this.attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.all_videolist_data = ((ArrayList)paramJceInputStream.read(cache_all_videolist_data, 0, false));
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 1, false));
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 2, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 3, false);
    this.attach_info = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.all_videolist_data != null) {
      paramJceOutputStream.write(this.all_videolist_data, 0);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 1);
    }
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 2);
    }
    paramJceOutputStream.write(this.hasmore, 3);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\get_video_float_layer_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */