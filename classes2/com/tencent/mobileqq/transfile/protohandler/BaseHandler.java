package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.AppConstants.RichMediaErrorCode;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.IProtoRespBack;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class BaseHandler
  implements AppConstants.RichMediaErrorCode, ProtoReqManager.IProtoRespBack, RichProtoProc.RichProtoHandler
{
  public static final String d = "Q.richmedia.BaseHandler";
  int aI;
  
  public BaseHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.aI = 0;
  }
  
  public static int a()
  {
    return a(NetworkCenter.a().a());
  }
  
  public static int a(int paramInt)
  {
    int j = 6;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      String str = NetworkCenter.a().a();
      paramInt = i;
      if (str != null)
      {
        paramInt = i;
        if (str.contains("wap")) {
          paramInt = 5;
        }
      }
      return paramInt;
      i = 3;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, MessageObserver.StatictisInfo paramStatictisInfo, RichProto.RichProtoResp.RespCommon paramRespCommon)
  {
    paramRespCommon.c = paramInt1;
    paramRespCommon.d = paramInt2;
    paramRespCommon.h = paramString1;
    paramRespCommon.g = paramString2;
    if (paramInt1 == 0)
    {
      paramRespCommon.e = 1;
      paramRespCommon.f = (paramStatictisInfo.d - 1);
    }
    do
    {
      return;
      paramRespCommon.e = 0;
      paramRespCommon.f = paramStatictisInfo.d;
    } while (!QLog.isColorLevel());
    QLog.d("Q.richmedia.BaseHandler", 2, "result:" + paramInt1 + " errCode:" + paramInt2 + " reason:" + paramString1 + " errStr:" + paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, MessageObserver.StatictisInfo paramStatictisInfo, List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt1, paramInt2, paramString1, paramString2, paramStatictisInfo, (RichProto.RichProtoResp.RespCommon)paramList.next());
    }
  }
  
  void a(RichProto.RichProtoReq paramRichProtoReq, ProtoReqManager.ProtoReq paramProtoReq)
  {
    b(paramRichProtoReq);
    paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq = paramProtoReq;
    if (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) {
      paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramProtoReq);
    }
  }
  
  abstract void b(RichProto.RichProtoReq paramRichProtoReq);
  
  public void c(RichProto.RichProtoReq paramRichProtoReq) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\protohandler\BaseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */