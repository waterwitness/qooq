package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class publish_active_album_req
  extends JceStruct
{
  static ArrayList cache_added_photo;
  static Map cache_map_params;
  static shuoshuo_privacy cache_ss_info;
  public ArrayList added_photo;
  public Map map_params;
  public shuoshuo_privacy ss_info;
  public long uin;
  
  public publish_active_album_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public publish_active_album_req(long paramLong, Map paramMap, ArrayList paramArrayList, shuoshuo_privacy paramshuoshuo_privacy)
  {
    this.uin = paramLong;
    this.map_params = paramMap;
    this.added_photo = paramArrayList;
    this.ss_info = paramshuoshuo_privacy;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    if (cache_map_params == null)
    {
      cache_map_params = new HashMap();
      cache_map_params.put("", "");
    }
    this.map_params = ((Map)paramJceInputStream.read(cache_map_params, 1, false));
    if (cache_added_photo == null)
    {
      cache_added_photo = new ArrayList();
      active_photo localactive_photo = new active_photo();
      cache_added_photo.add(localactive_photo);
    }
    this.added_photo = ((ArrayList)paramJceInputStream.read(cache_added_photo, 2, false));
    if (cache_ss_info == null) {
      cache_ss_info = new shuoshuo_privacy();
    }
    this.ss_info = ((shuoshuo_privacy)paramJceInputStream.read(cache_ss_info, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.map_params != null) {
      paramJceOutputStream.write(this.map_params, 1);
    }
    if (this.added_photo != null) {
      paramJceOutputStream.write(this.added_photo, 2);
    }
    if (this.ss_info != null) {
      paramJceOutputStream.write(this.ss_info, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\publish_active_album_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */