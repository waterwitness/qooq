package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class mobile_sub_del_photo_wall_req
  extends JceStruct
{
  static ArrayList cache_vecUrls;
  public ArrayList vecUrls;
  
  public mobile_sub_del_photo_wall_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_del_photo_wall_req(ArrayList paramArrayList)
  {
    this.vecUrls = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecUrls == null)
    {
      cache_vecUrls = new ArrayList();
      PhotoWall localPhotoWall = new PhotoWall();
      cache_vecUrls.add(localPhotoWall);
    }
    this.vecUrls = ((ArrayList)paramJceInputStream.read(cache_vecUrls, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecUrls, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_del_photo_wall_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */