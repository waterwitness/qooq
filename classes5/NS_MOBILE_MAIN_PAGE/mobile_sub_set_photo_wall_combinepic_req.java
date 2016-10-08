package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class mobile_sub_set_photo_wall_combinepic_req
  extends JceStruct
{
  static Map cache_extinfo;
  public Map extinfo;
  public int photoWallCombinePic;
  public long uin;
  
  public mobile_sub_set_photo_wall_combinepic_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_set_photo_wall_combinepic_req(long paramLong, int paramInt, Map paramMap)
  {
    this.uin = paramLong;
    this.photoWallCombinePic = paramInt;
    this.extinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.photoWallCombinePic = paramJceInputStream.read(this.photoWallCombinePic, 1, false);
    if (cache_extinfo == null)
    {
      cache_extinfo = new HashMap();
      cache_extinfo.put("", "");
    }
    this.extinfo = ((Map)paramJceInputStream.read(cache_extinfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.photoWallCombinePic, 1);
    if (this.extinfo != null) {
      paramJceOutputStream.write(this.extinfo, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_set_photo_wall_combinepic_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */