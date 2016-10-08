package com.tencent.mobileqq.service.qcard;

import LBS.Cell;
import LBS.GPS;
import LBS.LBSInfo;
import LBS.Wifi;
import QCARD.CollectCouponReq;
import QCARD.CollectCouponRsp;
import QCARD.GetCollectItemMobileReq;
import QCARD.GetCollectItemMobileRsp;
import QCARD.GetListReq;
import QCARD.GetListRsp;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.activity.qqcard.QQCardConstant;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class QQCardService
  extends BaseProtocolCoder
{
  private static final String a = QQCardService.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static LBSInfo a()
  {
    LBSInfo localLBSInfo = new LBSInfo();
    Object localObject1 = SosoInterface.a();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null))
    {
      SosoInterface.a(60000L, QQCardService.class.getSimpleName());
      localObject1 = SosoInterface.a();
    }
    for (;;)
    {
      if (localObject1 == null) {
        return localLBSInfo;
      }
      Object localObject2;
      if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null)
      {
        localObject2 = new GPS();
        ((GPS)localObject2).eType = 1;
        ((GPS)localObject2).iLat = ((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a * 1000000.0D));
        ((GPS)localObject2).iLon = ((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b * 1000000.0D));
        localLBSInfo.stGps = ((GPS)localObject2);
      }
      if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localLBSInfo.vCells = new ArrayList();
        localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (SosoInterface.SosoCell)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            localObject3 = new Cell((short)((SosoInterface.SosoCell)localObject3).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject3).b, ((SosoInterface.SosoCell)localObject3).c, ((SosoInterface.SosoCell)localObject3).d, (short)((SosoInterface.SosoCell)localObject3).e);
            localLBSInfo.vCells.add(localObject3);
          }
        }
      }
      if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
      {
        localLBSInfo.vWifis = new ArrayList();
        localObject1 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = new Wifi(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Long, (short)((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Int);
            localLBSInfo.vWifis.add(localObject2);
          }
        }
      }
      return localLBSInfo;
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.getServiceCmd();
    try
    {
      if ("QQCardAccessSvc.getList".equals(paramToServiceMsg)) {
        return a(paramFromServiceMsg.getWupBuffer(), "rsp", new GetListRsp());
      }
      if ("QQCardAccessSvc.CollectCoupon".equals(paramToServiceMsg)) {
        return a(paramFromServiceMsg.getWupBuffer(), "rsp", new CollectCouponRsp());
      }
      if ("QQCardAccessSvc.GetCollectItemMobile".equals(paramToServiceMsg))
      {
        paramToServiceMsg = a(paramFromServiceMsg.getWupBuffer(), "rsp", new GetCollectItemMobileRsp());
        return paramToServiceMsg;
      }
    }
    catch (Throwable paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e(a, 2, "", paramToServiceMsg);
      }
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("QQCardAccessSvc.getList".equals(str))
    {
      paramUniPacket.setServantName("QCARD.CouponAccessCoroServer.CouponAccessCoroObj");
      paramUniPacket.setFuncName("getList");
      paramUniPacket.put("req", (GetListReq)paramToServiceMsg.extraData.getSerializable("req"));
      return true;
    }
    if ("QQCardAccessSvc.CollectCoupon".equals(str))
    {
      paramUniPacket.setServantName("QCARD.CouponAccessCoroServer.CouponAccessCoroObj");
      paramUniPacket.setFuncName("CollectCoupon");
      paramUniPacket.put("req", (CollectCouponReq)paramToServiceMsg.extraData.getSerializable("req"));
      return true;
    }
    if ("QQCardAccessSvc.GetCollectItemMobile".equals(str))
    {
      paramUniPacket.setServantName("QCARD.CouponAccessCoroServer.CouponAccessCoroObj");
      paramUniPacket.setFuncName("GetCollectItemMobile");
      paramUniPacket.put("req", (GetCollectItemMobileReq)paramToServiceMsg.extraData.getSerializable("req"));
      return true;
    }
    return false;
  }
  
  public String[] a()
  {
    return QQCardConstant.a;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\qcard\QQCardService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */