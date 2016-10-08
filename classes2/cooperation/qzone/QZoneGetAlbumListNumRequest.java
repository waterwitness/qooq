package cooperation.qzone;

import NS_MOBILE_PHOTO.get_albumlist_num_req;
import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QZoneGetAlbumListNumRequest
  extends QzoneExternalRequest
{
  public static final String a = "getAlbumListNum";
  public static final String b = "getAlbumListNum";
  private static final String c = "QzoneNewService.getAlbumListNum";
  private static final String d = "getAlbumListNum";
  public JceStruct a;
  
  public QZoneGetAlbumListNumRequest(long paramLong, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.setRefer(paramString);
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    paramString = new get_albumlist_num_req();
    paramString.uin = paramLong;
    this.a = paramString;
  }
  
  public static get_albumlist_num_rsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    get_albumlist_num_rsp localget_albumlist_num_rsp;
    do
    {
      return paramArrayOfByte;
      localget_albumlist_num_rsp = (get_albumlist_num_rsp)decode(paramArrayOfByte, "getAlbumListNum");
      paramArrayOfByte = localget_albumlist_num_rsp;
    } while (localget_albumlist_num_rsp != null);
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getAlbumListNum";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "getAlbumListNum";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneGetAlbumListNumRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */