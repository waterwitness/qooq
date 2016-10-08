package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListRequest;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.WupUtil;

public class PublicAccountHandler$PublicAccountCheckUpdateItem
  implements CheckUpdateItemInterface
{
  public PublicAccountHandler$PublicAccountCheckUpdateItem(PublicAccountHandler paramPublicAccountHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    ReqItem localReqItem = new ReqItem();
    localReqItem.cOperType = 0;
    localReqItem.eServiceID = 102;
    long l1 = PublicAccountHandler.a(this.a);
    long l2 = PublicAccountHandler.b(this.a);
    mobileqq_mp.GetUserFollowListRequest localGetUserFollowListRequest = new mobileqq_mp.GetUserFollowListRequest();
    localGetUserFollowListRequest.follow_seqno.set((int)l1);
    localGetUserFollowListRequest.public_account_seqno.set((int)l2);
    localGetUserFollowListRequest.begin.set(0);
    localGetUserFollowListRequest.limit.set(1);
    localGetUserFollowListRequest.version.set(1);
    localGetUserFollowListRequest.is_increment.set(true);
    localReqItem.vecParam = WupUtil.a(localGetUserFollowListRequest.toByteArray());
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 102) && (paramRespItem.cResult == 0)) {
      this.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\PublicAccountHandler$PublicAccountCheckUpdateItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */