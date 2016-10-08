package cooperation.qzone;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_del_photo_wall_req;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class QZoneDelPhotoWallRequest
  extends QzoneExternalRequest
{
  public static final String a = "delPhotoWall";
  private static final String b = "QzoneNewService.delPhotoWall";
  public JceStruct a;
  
  public QZoneDelPhotoWallRequest(long paramLong1, long paramLong2, String paramString, Long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong2);
    mobile_sub_del_photo_wall_req localmobile_sub_del_photo_wall_req = new mobile_sub_del_photo_wall_req();
    PhotoWall localPhotoWall = new PhotoWall();
    localPhotoWall.photoId = paramString;
    localPhotoWall.ctime = paramLong.longValue();
    localmobile_sub_del_photo_wall_req.vecUrls = new ArrayList();
    localmobile_sub_del_photo_wall_req.vecUrls.add(localPhotoWall);
    this.a = localmobile_sub_del_photo_wall_req;
  }
  
  public static JceStruct a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return decode(paramArrayOfByte, "delPhotoWall");
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.delPhotoWall";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "delPhotoWall";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneDelPhotoWallRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */