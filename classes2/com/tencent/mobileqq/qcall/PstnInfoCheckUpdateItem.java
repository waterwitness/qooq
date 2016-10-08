package com.tencent.mobileqq.qcall;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class PstnInfoCheckUpdateItem
  extends PstnHandler
  implements CheckUpdateItemInterface
{
  public static final String i = "PstnInfoCheckUpdateItem";
  private ToServiceMsg a;
  private int t;
  
  public PstnInfoCheckUpdateItem(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.t = paramInt;
  }
  
  public int a()
  {
    return 5;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnInfoCheckUpdateItem", 2, "=== PstnInfoCheckUpdateItem getCheckUpdateItemData serviceId: " + this.t);
    }
    Object localObject2 = null;
    if (this.t == 128) {
      super.a();
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (this.a != null)
      {
        BaseProtocolCoder localBaseProtocolCoder = this.b.a.a(this.a.getServiceCmd());
        localObject1 = localObject2;
        if (localBaseProtocolCoder != null)
        {
          UniPacket localUniPacket = new UniPacket(true);
          localUniPacket.setEncodeName("utf-8");
          localObject1 = localObject2;
          if (localBaseProtocolCoder.a(this.a, localUniPacket))
          {
            localObject1 = new ReqItem();
            ((ReqItem)localObject1).eServiceID = this.t;
            ((ReqItem)localObject1).vecParam = localUniPacket.encode();
          }
        }
      }
      return (ReqItem)localObject1;
      if (this.t == 129) {
        super.a(this.b.a());
      }
    }
  }
  
  public void a(RespItem paramRespItem)
  {
    Object localObject = "";
    if (paramRespItem.eServiceID == 128) {
      localObject = "OidbSvc.0x4f1_0";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PstnInfoCheckUpdateItem", 2, "=== PstnInfoCheckUpdateItem handleCheckUpdateItemData serviceCmd: " + (String)localObject + ",result: " + paramRespItem.cResult);
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramRespItem.cResult == 2))
      {
        localObject = new FromServiceMsg(this.b.getAccount(), (String)localObject);
        ((FromServiceMsg)localObject).setMsgSuccess();
        ((FromServiceMsg)localObject).putWupBuffer(paramRespItem.vecUpdate);
        this.b.a(this.a, (FromServiceMsg)localObject);
      }
      return;
      if (paramRespItem.eServiceID == 129) {
        localObject = "OidbSvc.0x5eb_47";
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.a = paramToServiceMsg;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\PstnInfoCheckUpdateItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */