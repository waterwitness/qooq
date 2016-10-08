package com.tencent.biz.common.offline;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hhf;
import java.io.UnsupportedEncodingException;
import mqq.os.MqqHandler;
import tencent.im.sso.offlinpkg.OfflinePkg.BidPkg;
import tencent.im.sso.offlinpkg.OfflinePkg.ReqBody;
import tencent.im.sso.offlinpkg.OfflinePkg.RspBody;

public class OfflineExpire$OfflineExpireCheckUpdate
  implements CheckUpdateItemInterface
{
  private QQAppInterface a;
  
  public OfflineExpire$OfflineExpireCheckUpdate(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
    if (paramQQAppInterface.getLongAccountUin() % 10L == 6L) {}
    for (bool = true;; bool = false)
    {
      HtmlOffline.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    if (OfflineExpire.jdField_a_of_type_Boolean) {
      return null;
    }
    OfflineExpire.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "getCheckUpdateItemData");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.cOperType = 1;
    localReqItem.eServiceID = 127;
    OfflinePkg.ReqBody localReqBody = new OfflinePkg.ReqBody();
    localReqBody.uint32_cmd.set(2);
    localReqBody.uint32_platform.set(OfflineExpire.jdField_a_of_type_Int);
    localReqBody.str_qver.set(ByteStringMicro.copyFrom("6.5.5".getBytes()));
    localReqBody.str_osrelease.set(ByteStringMicro.copyFrom(Build.VERSION.RELEASE.getBytes()));
    i = NetworkUtil.a(this.a.a());
    localReqBody.int32_network.set(i);
    localReqBody.str_from.set(ByteStringMicro.copyFrom("predown".getBytes()));
    Object localObject = HtmlOffline.a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      String[] arrayOfString = ((String)localObject).split(",");
      int n = arrayOfString.length;
      int k = 0;
      if (k < n)
      {
        String str = arrayOfString[k];
        if (!TextUtils.isEmpty(str)) {
          localObject = str.split("\\|");
        }
        for (;;)
        {
          try
          {
            i = Integer.valueOf(localObject[0]).intValue();
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            try
            {
              int m = Integer.valueOf(localObject[1]).intValue();
              j = i;
              i = m;
              if (j != 0) {
                break label330;
              }
              k += 1;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                OfflinePkg.BidPkg localBidPkg;
                j = i;
              }
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              int j = i;
              continue;
            }
            localNumberFormatException1 = localNumberFormatException1;
            j = 0;
            localNumberFormatException1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "NumberFormatException:" + str);
            }
            i = 0;
            continue;
          }
          catch (Exception localException1)
          {
            j = 0;
          }
          if (QLog.isColorLevel()) {
            QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "Exception:" + str);
          }
          i = 0;
          continue;
          label330:
          localBidPkg = new OfflinePkg.BidPkg();
          localBidPkg.uint32_bid.set(j);
          localBidPkg.uint32_pkg_id.add(Integer.valueOf(i));
          localReqBody.st_bid_pkg.add(localBidPkg);
        }
      }
    }
    localReqItem.vecParam = WupUtil.a(localReqBody.toByteArray());
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData");
    }
    if (paramRespItem.cResult == 2) {
      if (paramRespItem.eServiceID == 127)
      {
        paramRespItem = WupUtil.b(paramRespItem.vecUpdate);
        if (paramRespItem != null) {
          localRspBody = new OfflinePkg.RspBody();
        }
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        OfflinePkg.RspBody localRspBody;
        localRspBody.mergeFrom(paramRespItem);
        OfflineExpire.a(new String(localRspBody.str_expire_pkg.get().toByteArray(), "UTF-8"));
        OfflineExpire.a(new String(localRspBody.str_predown_pkg_ex.get().toByteArray(), "UTF-8"), this.a, this.a.a().getApplicationContext(), 1);
        ThreadManager.b().postDelayed(new hhf(this), 180000L);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramRespItem)
      {
        for (;;)
        {
          paramRespItem.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
          }
        }
      }
      catch (UnsupportedEncodingException paramRespItem)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
          }
        }
      }
      catch (Exception paramRespItem)
      {
        for (;;)
        {
          paramRespItem.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
          }
        }
      }
    }
    QLog.d(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "***handleCheckUpdateItemData fail respitem.cResult:" + paramRespItem.cResult);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\offline\OfflineExpire$OfflineExpireCheckUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */