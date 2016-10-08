package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class cell_view_more
  extends JceStruct
{
  static Map cache_busi_param;
  public int actiontype;
  public Map busi_param;
  public String guide_content = "";
  public String jump_url = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public cell_view_more() {}
  
  public cell_view_more(String paramString1, Map paramMap, int paramInt, String paramString2)
  {
    this.guide_content = paramString1;
    this.busi_param = paramMap;
    this.actiontype = paramInt;
    this.jump_url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.guide_content = paramJceInputStream.readString(0, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 1, false));
    this.actiontype = paramJceInputStream.read(this.actiontype, 2, false);
    this.jump_url = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.guide_content != null) {
      paramJceOutputStream.write(this.guide_content, 0);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 1);
    }
    paramJceOutputStream.write(this.actiontype, 2);
    if (this.jump_url != null) {
      paramJceOutputStream.write(this.jump_url, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_view_more.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */