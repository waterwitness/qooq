package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Collection;

public class GetRichSig
  extends FriendListHandler
  implements CheckUpdateItemInterface
{
  private ToServiceMsg a;
  
  public GetRichSig(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    Object localObject2 = new ArrayList(2);
    ((ArrayList)localObject2).add(this.b.getAccount());
    Object localObject1 = (SubAccountManager)this.b.getManager(60);
    if (localObject1 != null) {}
    for (localObject1 = ((SubAccountManager)localObject1).a();; localObject1 = null)
    {
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
        ((ArrayList)localObject2).addAll((Collection)localObject1);
      }
      localObject1 = new String[((ArrayList)localObject2).size()];
      ((ArrayList)localObject2).toArray((Object[])localObject1);
      b((String[])localObject1);
      if (this.a != null)
      {
        localObject2 = this.b.a.a(this.a.getServiceCmd());
        if (localObject2 != null)
        {
          localObject1 = new UniPacket(true);
          ((UniPacket)localObject1).setEncodeName("utf-8");
          if (((BaseProtocolCoder)localObject2).a(this.a, (UniPacket)localObject1))
          {
            localObject2 = new ReqItem();
            ((ReqItem)localObject2).eServiceID = 119;
            ((ReqItem)localObject2).vecParam = ((UniPacket)localObject1).encode();
            return (ReqItem)localObject2;
          }
        }
      }
      return null;
    }
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 119) && (paramRespItem.cResult == 2))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.b.getAccount(), "ProfileService.GetRichSig");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.putWupBuffer(paramRespItem.vecUpdate);
      this.b.a(this.a, localFromServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.a = paramToServiceMsg;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\GetRichSig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */