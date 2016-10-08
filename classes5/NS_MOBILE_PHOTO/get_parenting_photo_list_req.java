package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class get_parenting_photo_list_req
  extends JceStruct
  implements Cloneable
{
  static Map cache_busi_param;
  public String albumid;
  public String attach_info;
  public Map busi_param;
  public String password;
  public long uin;
  
  public get_parenting_photo_list_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.albumid = "";
    this.attach_info = "";
    this.password = "";
  }
  
  public get_parenting_photo_list_req(long paramLong, String paramString1, String paramString2, String paramString3, Map paramMap)
  {
    this.albumid = "";
    this.attach_info = "";
    this.password = "";
    this.uin = paramLong;
    this.albumid = paramString1;
    this.attach_info = paramString2;
    this.password = paramString3;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.attach_info = paramJceInputStream.readString(2, false);
    this.password = paramJceInputStream.readString(3, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.albumid, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
    if (this.password != null) {
      paramJceOutputStream.write(this.password, 3);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\get_parenting_photo_list_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */