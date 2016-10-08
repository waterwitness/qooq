package com.tencent.mobileqq.freshnews.data;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class FreshNewsDataFactory
{
  public FreshNewsDataFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static FNBaseItemData a(Context paramContext, AppInterface paramAppInterface, FreshNewsInfo paramFreshNewsInfo)
  {
    FreshNewsManager localFreshNewsManager = (FreshNewsManager)paramAppInterface.getManager(211);
    FNBaseItemData localFNBaseItemData = localFreshNewsManager.a(paramFreshNewsInfo.feedPK);
    if (localFNBaseItemData != null)
    {
      localFNBaseItemData.a(paramFreshNewsInfo);
      localFNBaseItemData.a(paramContext, paramAppInterface);
      return localFNBaseItemData;
    }
    localFNBaseItemData = a(paramFreshNewsInfo);
    localFNBaseItemData.a(paramContext, paramAppInterface);
    localFreshNewsManager.a(paramFreshNewsInfo.feedPK, localFNBaseItemData);
    return localFNBaseItemData;
  }
  
  public static FNBaseItemData a(FreshNewsInfo paramFreshNewsInfo)
  {
    if (paramFreshNewsInfo == null) {}
    do
    {
      return null;
      if (paramFreshNewsInfo.feedType == 6L) {
        return new FNTopicItemData(paramFreshNewsInfo);
      }
      if (paramFreshNewsInfo.feedType == 8L) {
        return new FNHotChatItemData(paramFreshNewsInfo);
      }
      if (paramFreshNewsInfo.feedType != 12L) {
        break;
      }
      if (paramFreshNewsInfo.adStyle == 1) {
        return new FNADHotTopicItemData(paramFreshNewsInfo);
      }
    } while (paramFreshNewsInfo.adStyle != 3);
    return new FNADNowItemData(paramFreshNewsInfo);
    return new FNDefaultItemData(paramFreshNewsInfo);
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, List paramList1, List paramList2)
  {
    label227:
    label267:
    for (;;)
    {
      FreshNewsManager localFreshNewsManager;
      FreshNewsInfo localFreshNewsInfo;
      FNBaseItemData localFNBaseItemData;
      try
      {
        paramList2.clear();
        if ((paramList1 == null) || (paramList1.size() <= 0)) {
          break label227;
        }
        localFreshNewsManager = (FreshNewsManager)paramAppInterface.getManager(211);
        Iterator localIterator = paramList1.iterator();
        if (!localIterator.hasNext()) {
          break label227;
        }
        localFreshNewsInfo = (FreshNewsInfo)localIterator.next();
        paramList1 = localFreshNewsInfo.feedPK;
        if (localFreshNewsInfo.feedType != 6L) {
          break label267;
        }
        paramList1 = localFreshNewsInfo.feedPK + localFreshNewsInfo.topicInfo.a;
        localFNBaseItemData = localFreshNewsManager.a(paramList1);
        if (localFNBaseItemData != null)
        {
          localFNBaseItemData.a(localFreshNewsInfo);
          localFNBaseItemData.a(paramContext, paramAppInterface);
          paramList1 = localFNBaseItemData;
          paramList2.add(paramList1);
          continue;
        }
        localFNBaseItemData = a(localFreshNewsInfo);
      }
      finally {}
      if (localFNBaseItemData == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby.freshNews", 2, "convertToFNBaseItemData itemData is null, newsInfo：" + localFreshNewsInfo);
        }
      }
      else
      {
        localFNBaseItemData.a(paramContext, paramAppInterface);
        localFreshNewsManager.a(paramList1, localFNBaseItemData);
        paramList1 = localFNBaseItemData;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby.freshNews", 2, "feedList size：" + paramList2.size());
        }
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\data\FreshNewsDataFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */