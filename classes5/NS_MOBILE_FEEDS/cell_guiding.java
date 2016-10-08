package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class cell_guiding
  extends JceStruct
{
  static Map cache_extendInfo;
  static int cache_guiding_type = 0;
  static s_picdata cache_picdata;
  public String action_url = "";
  public String button_title = "";
  public Map extendInfo;
  public int guiding_type;
  public s_picdata picdata;
  public String summary = "";
  public String title = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_picdata = new s_picdata();
    cache_extendInfo = new HashMap();
    cache_extendInfo.put("", "");
  }
  
  public cell_guiding() {}
  
  public cell_guiding(s_picdata params_picdata, String paramString1, String paramString2, String paramString3, String paramString4, Map paramMap, int paramInt)
  {
    this.picdata = params_picdata;
    this.title = paramString1;
    this.summary = paramString2;
    this.button_title = paramString3;
    this.action_url = paramString4;
    this.extendInfo = paramMap;
    this.guiding_type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picdata = ((s_picdata)paramJceInputStream.read(cache_picdata, 0, false));
    this.title = paramJceInputStream.readString(1, false);
    this.summary = paramJceInputStream.readString(2, false);
    this.button_title = paramJceInputStream.readString(3, false);
    this.action_url = paramJceInputStream.readString(4, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 5, false));
    this.guiding_type = paramJceInputStream.read(this.guiding_type, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picdata != null) {
      paramJceOutputStream.write(this.picdata, 0);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 1);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 2);
    }
    if (this.button_title != null) {
      paramJceOutputStream.write(this.button_title, 3);
    }
    if (this.action_url != null) {
      paramJceOutputStream.write(this.action_url, 4);
    }
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 5);
    }
    paramJceOutputStream.write(this.guiding_type, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_guiding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */