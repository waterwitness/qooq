package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;

public class ReqDpcInfoNewItem
  implements CheckUpdateItemInterface
{
  private static final String jdField_a_of_type_JavaLangString = "ReqDpcInfoNewItem";
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public ReqDpcInfoNewItem(AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramAppInterface;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    QLog.i("ReqDpcInfoNewItem", 1, "getCheckUpdateItemData");
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 117;
    localReqItem.cOperType = 1;
    byte[] arrayOfByte1 = DeviceProfileManager.a(this.a).toByteArray();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    PkgTools.a(arrayOfByte2, 0, arrayOfByte1.length + 4);
    PkgTools.a(arrayOfByte2, 4, arrayOfByte1, arrayOfByte1.length);
    localReqItem.vecParam = arrayOfByte2;
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    int i = 1;
    QLog.i("ReqDpcInfoNewItem", 1, "handleCheckUpdateItemData" + paramRespItem.cResult);
    byte[] arrayOfByte;
    if (paramRespItem.eServiceID == 117)
    {
      if (paramRespItem.cResult != 2) {
        break label188;
      }
      arrayOfByte = WupUtil.b(paramRespItem.vecUpdate);
      if (arrayOfByte != null) {
        paramRespItem = new ConfigurationService.RespGetConfig();
      }
    }
    else
    {
      try
      {
        paramRespItem.mergeFrom(arrayOfByte);
        if ((paramRespItem != null) && (paramRespItem.result.get() == 0)) {
          if ((paramRespItem.config_list != null) && (paramRespItem.config_list.size() > 0))
          {
            DeviceProfileManager.a().a(paramRespItem, this.a.a());
            if (i == 0) {
              DeviceProfileManager.a().a(4);
            }
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramRespItem)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReqDpcInfoNewItem", 2, "error: " + paramRespItem.getMessage());
          }
          paramRespItem.printStackTrace();
          paramRespItem = null;
        }
        QLog.i("ReqDpcInfoNewItem", 1, "respGetConfig has no contentlist");
      }
    }
    for (;;)
    {
      i = 0;
      break;
      label188:
      QLog.i("ReqDpcInfoNewItem", 1, "error happend item.cResult = " + paramRespItem.cResult);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\ReqDpcInfoNewItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */