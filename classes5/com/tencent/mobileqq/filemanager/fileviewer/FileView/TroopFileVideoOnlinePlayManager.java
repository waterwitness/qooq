package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.HexUtil;
import sgr;
import sgs;
import tencent.im.oidb.cmd0x6e7.oidb_0x6e7.ReqBody;

public class TroopFileVideoOnlinePlayManager
{
  public TroopFileVideoOnlinePlayManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return "http://" + paramString1 + "/ftn_handler/" + paramString2 + "/?fname=" + HexUtil.b(paramString3) + paramString5;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, sgs paramsgs)
  {
    if (paramLong < 0L) {
      return;
    }
    oidb_0x6e7.ReqBody localReqBody = new oidb_0x6e7.ReqBody();
    localReqBody.uint64_group_code.set(paramLong);
    localReqBody.str_app_src.set("android");
    localReqBody.str_version.set("6.5.5");
    ProtoUtils.a(paramQQAppInterface, new sgr(paramsgs), localReqBody.toByteArray(), "OidbSvc.oidb_0x6e7", 1767, 0, null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\TroopFileVideoOnlinePlayManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */