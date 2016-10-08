package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class cell_gift
  extends JceStruct
{
  static Map cache_gifturl;
  public String giftbackid = "";
  public String giftdesc = "";
  public String giftid = "";
  public String giftname = "";
  public String gifttype = "";
  public Map gifturl;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_gifturl = new HashMap();
    cache_gifturl.put(Integer.valueOf(0), "");
  }
  
  public cell_gift() {}
  
  public cell_gift(String paramString1, String paramString2, String paramString3, Map paramMap, String paramString4, String paramString5)
  {
    this.giftname = paramString1;
    this.gifttype = paramString2;
    this.giftid = paramString3;
    this.gifturl = paramMap;
    this.giftdesc = paramString4;
    this.giftbackid = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.giftname = paramJceInputStream.readString(0, false);
    this.gifttype = paramJceInputStream.readString(1, false);
    this.giftid = paramJceInputStream.readString(2, false);
    this.gifturl = ((Map)paramJceInputStream.read(cache_gifturl, 3, false));
    this.giftdesc = paramJceInputStream.readString(4, false);
    this.giftbackid = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.giftname != null) {
      paramJceOutputStream.write(this.giftname, 0);
    }
    if (this.gifttype != null) {
      paramJceOutputStream.write(this.gifttype, 1);
    }
    if (this.giftid != null) {
      paramJceOutputStream.write(this.giftid, 2);
    }
    if (this.gifturl != null) {
      paramJceOutputStream.write(this.gifturl, 3);
    }
    if (this.giftdesc != null) {
      paramJceOutputStream.write(this.giftdesc, 4);
    }
    if (this.giftbackid != null) {
      paramJceOutputStream.write(this.giftbackid, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_gift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */