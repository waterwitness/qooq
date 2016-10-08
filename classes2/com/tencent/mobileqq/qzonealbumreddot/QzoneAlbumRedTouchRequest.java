package com.tencent.mobileqq.qzonealbumreddot;

import NS_MOBILE_PHOTO.operation_red_touch_req;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QzoneExternalRequest;

public class QzoneAlbumRedTouchRequest
  extends QzoneExternalRequest
{
  public JceStruct a;
  
  public QzoneAlbumRedTouchRequest(long paramLong, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.a = new operation_red_touch_req(paramInt);
  }
  
  public QzoneAlbumRedTouchRequest(long paramLong, operation_red_touch_req paramoperation_red_touch_req)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.a = paramoperation_red_touch_req;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.asy_photo.OperationRedTouch";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "OperationRedTouch";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qzonealbumreddot\QzoneAlbumRedTouchRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */