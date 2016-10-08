package com.tencent.mobileqq.nearby.redtouch;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x6cd.RedpointInfo;
import tencent.im.oidb.cmd0x6cd.ReqBody;
import tencent.im.oidb.cmd0x6cd.RspBody;
import tencent.im.oidb.cmd0x6ce.ReadRedpointReq;
import tencent.im.oidb.cmd0x6ce.ReqBody;
import tencent.im.oidb.cmd0x6ce.RspBody;
import tencent.im.oidb.cmd0x6f5.ReqBody;
import tencent.im.oidb.cmd0x6f5.RspBody;

public class RedtouchHandler
  extends BusinessHandler
{
  public static final String a = RedtouchHandler.class.getSimpleName();
  public static final String b = "OidbSvc.cmd0x6f5";
  public static final String c = "OidbSvc.cmd0x6cd";
  public static final String d = "OidbSvc.cmd0x6ce";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RedtouchHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "handleGetRedPointConfigs");
    }
    paramToServiceMsg = new cmd0x6f5.RspBody();
    int i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "handleGetRedPointConfigs, errCode=" + i);
    }
    if ((i == 0) && (paramToServiceMsg.str_config_version.has()))
    {
      paramFromServiceMsg = paramToServiceMsg.str_config_version.get();
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "handleGetRedPointConfigs, server configVersion=" + paramFromServiceMsg);
      }
      if (!TextUtils.isEmpty(paramFromServiceMsg))
      {
        paramObject = (LocalRedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
        if (paramObject != null)
        {
          ((LocalRedTouchManager)paramObject).a(paramFromServiceMsg);
          ((LocalRedTouchManager)paramObject).a(paramToServiceMsg);
          ((LocalRedTouchManager)paramObject).a();
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "handlePullRedTouch");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    boolean bool4;
    cmd0x6cd.RspBody localRspBody;
    int i;
    do
    {
      return;
      bool4 = paramToServiceMsg.extraData.getBoolean("is_new_channel", false);
      localRspBody = new cmd0x6cd.RspBody();
      i = a(paramFromServiceMsg, paramObject, localRspBody);
      paramObject = (LocalRedTouchManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(159);
    } while (paramObject == null);
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "handlePullRedTouch success.");
      }
      if (localRspBody.rpt_msg_redpoint.has()) {}
      for (paramToServiceMsg = localRspBody.rpt_msg_redpoint.get();; paramToServiceMsg = null)
      {
        if (paramToServiceMsg == null) {
          break label323;
        }
        paramFromServiceMsg = new ArrayList(paramToServiceMsg.size());
        i = 0;
        while (i < paramToServiceMsg.size())
        {
          paramFromServiceMsg.add(RedTouchItem.getRedTouchItem((cmd0x6cd.RedpointInfo)paramToServiceMsg.get(i)));
          i += 1;
        }
      }
    }
    label323:
    for (paramToServiceMsg = paramFromServiceMsg;; paramToServiceMsg = null)
    {
      paramFromServiceMsg = (FromServiceMsg)localObject1;
      if (localRspBody.rpt_unfinished_redpoint.has()) {
        paramFromServiceMsg = localRspBody.rpt_unfinished_redpoint.get();
      }
      boolean bool1 = bool2;
      if (paramFromServiceMsg != null)
      {
        bool1 = bool2;
        if (paramFromServiceMsg.size() > 0)
        {
          bool1 = true;
          a(paramFromServiceMsg, bool4);
        }
      }
      while (bool4)
      {
        ((LocalRedTouchManager)paramObject).a(paramToServiceMsg, bool1);
        return;
        bool1 = bool3;
        paramToServiceMsg = (ToServiceMsg)localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i(a, 2, "handlePullRedTouch failed:" + i);
          bool1 = bool3;
          paramToServiceMsg = (ToServiceMsg)localObject2;
        }
      }
      ((LocalRedTouchManager)paramObject).b(paramToServiceMsg, bool1);
      return;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "handleReportTouchClick");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramToServiceMsg.extraData.getInt("redPointId", 0);
        if (a(paramFromServiceMsg, paramObject, new cmd0x6ce.RspBody()) != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i(a, 2, "handleReportTouchClick success. taskId:" + i);
      return;
    } while (!QLog.isColorLevel());
    QLog.i(a, 2, "handleReportTouchClick faild. taskId:" + i);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "getRedPointConfigs(), client version : 6.5.5");
    }
    cmd0x6f5.ReqBody localReqBody = new cmd0x6f5.ReqBody();
    localReqBody.uint32_qq_platform.set(1);
    localReqBody.str_qq_version.set("6.5.5");
    b(a("OidbSvc.cmd0x6f5", 1781, 0, localReqBody.toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.cmd0x6cd".equals(str)) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.cmd0x6ce".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.cmd0x6f5".equals(str));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "reportRedTouchClick, redPointId=" + ((cmd0x6ce.ReadRedpointReq)paramList.get(0)).uint32_appid.get());
    }
    Object localObject = new cmd0x6ce.ReqBody();
    ((cmd0x6ce.ReqBody)localObject).rpt_msg_read_req.set(paramList);
    localObject = a("OidbSvc.cmd0x6ce", 1742, 0, ((cmd0x6ce.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("redPointId", ((cmd0x6ce.ReadRedpointReq)paramList.get(0)).uint32_appid.get());
    super.b((ToServiceMsg)localObject);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = a;
      localStringBuilder = new StringBuilder().append("pullRedTouch, list size=");
      if (paramList != null) {
        break label106;
      }
    }
    label106:
    for (Object localObject = "";; localObject = Integer.valueOf(paramList.size()))
    {
      QLog.i(str, 2, localObject + ", isNewChannel=" + paramBoolean);
      localObject = new cmd0x6cd.ReqBody();
      ((cmd0x6cd.ReqBody)localObject).rpt_msg_pull_req.set(paramList);
      paramList = a("OidbSvc.cmd0x6cd", 1741, 0, ((cmd0x6cd.ReqBody)localObject).toByteArray());
      paramList.extraData.putBoolean("is_new_channel", paramBoolean);
      super.b(paramList);
      return;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.cmd0x6f5");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.cmd0x6cd");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.cmd0x6ce");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\redtouch\RedtouchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */