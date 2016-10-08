package com.tencent.biz.pubaccount.subscript;

import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class SubscriptRecommendAdapter$RecommendPublicAccountObserver
  extends PublicAccountObserver
{
  SubscriptRecommendAdapter.RecommendItem jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem;
  
  public SubscriptRecommendAdapter$RecommendPublicAccountObserver(SubscriptRecommendAdapter paramSubscriptRecommendAdapter, SubscriptRecommendAdapter.RecommendItem paramRecommendItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem = null;
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem = paramRecommendItem;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(SubscriptRecommendAdapter.a, 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString + " | mRecommendItem: " + this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem != null)
    {
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem;
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      paramString.a(i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\subscript\SubscriptRecommendAdapter$RecommendPublicAccountObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */