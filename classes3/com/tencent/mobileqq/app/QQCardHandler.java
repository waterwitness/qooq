package com.tencent.mobileqq.app;

import LBS.LBSInfo;
import QCARD.CollectCouponReq;
import QCARD.CollectCouponRsp;
import QCARD.CouponMobileItem;
import QCARD.GetCollectItemMobileRsp;
import QCARD.GetListReq;
import QCARD.GetListRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qqcard.QQCardConstant;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.manager.TicketManager;

public class QQCardHandler
  extends BusinessHandler
  implements QQCardConstant
{
  private static final String r = QQCardHandler.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected QQCardHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return QQCardObserver.class;
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, Map paramMap, LBSInfo paramLBSInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(r, 2, "getCouponsList, sequence=" + paramLong + ",req_type=" + paramInt1 + ",condition=" + paramInt2 + ",map_folderid_index=" + paramMap + ",lbsInfo=" + paramLBSInfo);
    }
    Object localObject = (TicketManager)this.b.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(this.b.getAccount());; localObject = "")
    {
      GetListReq localGetListReq = new GetListReq();
      localGetListReq.sequence = paramLong;
      localGetListReq.req_type = paramInt1;
      localGetListReq.uin = this.b.getLongAccountUin();
      localGetListReq.condition = paramInt2;
      localGetListReq.map_folderid_index = paramMap;
      localGetListReq.lbs_info = paramLBSInfo;
      localGetListReq.skey = ((String)localObject);
      paramMap = new ToServiceMsg("mobileqq.service", this.b.a(), "QQCardAccessSvc.getList");
      paramMap.extraData.putSerializable("req", localGetListReq);
      super.a(paramMap);
      return;
    }
  }
  
  public void a(CouponMobileItem paramCouponMobileItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d(r, 2, "collectCoupon, cardId=" + paramCouponMobileItem.card_id);
    }
    CollectCouponReq localCollectCouponReq = new CollectCouponReq();
    localCollectCouponReq.appid = paramCouponMobileItem.appid;
    localCollectCouponReq.card_id = paramCouponMobileItem.card_id;
    localCollectCouponReq.field = paramCouponMobileItem.field;
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.a(), "QQCardAccessSvc.CollectCoupon");
    localToServiceMsg.extraData.putSerializable("req", localCollectCouponReq);
    localToServiceMsg.extraData.putString("recommend_card_id", paramCouponMobileItem.card_id);
    super.a(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    boolean bool1 = paramFromServiceMsg.isSuccess();
    if (QLog.isColorLevel()) {
      QLog.d(r, 2, "onReceive, cmd=" + str + ",isSucc=" + bool1);
    }
    if ("QQCardAccessSvc.getList".equals(str))
    {
      if (!bool1) {
        break label262;
      }
      if (((GetListRsp)paramObject).ret_code == 0) {
        bool1 = true;
      }
    }
    label181:
    label256:
    label262:
    for (;;)
    {
      a(((GetListReq)paramToServiceMsg.extraData.get("req")).req_type, bool1, paramObject);
      do
      {
        return;
        bool1 = false;
        break;
        if ("QQCardAccessSvc.CollectCoupon".equals(str))
        {
          paramToServiceMsg = paramToServiceMsg.extraData;
          bool2 = bool1;
          if (bool1)
          {
            paramFromServiceMsg = (CollectCouponRsp)paramObject;
            if (paramFromServiceMsg.ret_code != 0) {
              break label181;
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            bool2 = bool1;
            if (bool1)
            {
              paramToServiceMsg.putSerializable("recommend_card_rsp", paramFromServiceMsg);
              bool2 = bool1;
            }
            a(6, bool2, paramToServiceMsg);
            return;
          }
        }
      } while (!"QQCardAccessSvc.GetCollectItemMobile".equals(str));
      paramToServiceMsg = paramToServiceMsg.extraData;
      boolean bool2 = bool1;
      if (bool1)
      {
        paramFromServiceMsg = (GetCollectItemMobileRsp)paramObject;
        if (paramFromServiceMsg.ret_code != 0) {
          break label256;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1)
        {
          paramToServiceMsg.putSerializable("recommend_card_rsp", paramFromServiceMsg);
          bool2 = bool1;
        }
        a(7, bool2, paramToServiceMsg);
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\QQCardHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */