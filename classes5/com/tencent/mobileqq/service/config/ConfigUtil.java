package com.tencent.mobileqq.service.config;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceReqInfo;

public class ConfigUtil
{
  private ConfigUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = paramString2;
    localGetResourceReqInfo.uiCurVer = 0L;
    localGetResourceReqInfo.sResType = 4;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    localArrayList.add(localGetResourceReqInfo);
    a(paramQQAppInterface, paramString1, localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramString = new ToServiceMsg("mobileqq.service", paramString, "ConfigService.GetResourceReq");
      paramString.extraData.putSerializable("getResourceReqInfos", paramArrayList);
      paramQQAppInterface.a(paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\config\ConfigUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */