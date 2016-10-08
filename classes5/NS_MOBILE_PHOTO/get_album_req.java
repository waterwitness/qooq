package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class get_album_req
  extends JceStruct
{
  static Map cache_busi_param;
  public String albumid = "";
  public Map busi_param;
  public boolean is_get_url_key;
  public long owner_uin;
  public int type;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public get_album_req() {}
  
  public get_album_req(String paramString, int paramInt, Map paramMap, long paramLong, boolean paramBoolean)
  {
    this.albumid = paramString;
    this.type = paramInt;
    this.busi_param = paramMap;
    this.owner_uin = paramLong;
    this.is_get_url_key = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 2, false));
    this.owner_uin = paramJceInputStream.read(this.owner_uin, 3, false);
    this.is_get_url_key = paramJceInputStream.read(this.is_get_url_key, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.type, 1);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 2);
    }
    paramJceOutputStream.write(this.owner_uin, 3);
    paramJceOutputStream.write(this.is_get_url_key, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\get_album_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */