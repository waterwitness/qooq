package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.activity.recent.data.RecentPubAccountAssistantItem;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RecentItemEcShop
  extends RecentPubAccountAssistantItem
{
  public long a;
  public String a;
  
  public RecentItemEcShop(EcShopData paramEcShopData)
  {
    super(a(paramEcShopData));
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.G = 1;
    this.a = paramEcShopData.mImgInfo;
  }
  
  protected static PubAccountAssistantData a(EcShopData paramEcShopData)
  {
    PubAccountAssistantData localPubAccountAssistantData = new PubAccountAssistantData();
    localPubAccountAssistantData.mUin = paramEcShopData.mUin;
    localPubAccountAssistantData.mLastDraftTime = paramEcShopData.mLastDraftTime;
    localPubAccountAssistantData.mLastMsgTime = paramEcShopData.mLastMsgTime;
    localPubAccountAssistantData.mDistance = paramEcShopData.mDistance;
    return localPubAccountAssistantData;
  }
  
  public int a()
  {
    return 1008;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ecshopassit\RecentItemEcShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */