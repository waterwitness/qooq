package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class s_msgb_festival
  extends JceStruct
{
  static Map cache_extendinfo;
  public String content = "";
  public Map extendinfo;
  public boolean is_festival = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public s_msgb_festival() {}
  
  public s_msgb_festival(String paramString, boolean paramBoolean, Map paramMap)
  {
    this.content = paramString;
    this.is_festival = paramBoolean;
    this.extendinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.content = paramJceInputStream.readString(0, false);
    this.is_festival = paramJceInputStream.read(this.is_festival, 1, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 0);
    }
    paramJceOutputStream.write(this.is_festival, 1);
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\s_msgb_festival.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */