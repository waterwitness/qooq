package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.data.RecentItemActivateFriendsData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChangeMachine;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMsgBox;
import com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPcDataLine;
import com.tencent.mobileqq.activity.recent.data.RecentItemQCallData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRouterDataLine;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopBarAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification;
import com.tencent.mobileqq.activity.recent.data.RecentItemWifiHotSpot;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.data.SecMsgRecentItemData;
import com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import cooperation.dingdong.DingdongPluginRecentItem;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;

public class ConversationDataFactory
{
  public ConversationDataFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static RecentBaseData a(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramRecentUser != null)
    {
      localObject2 = localObject1;
      if (paramQQAppInterface != null)
      {
        if (paramContext != null) {
          break label29;
        }
        localObject2 = localObject1;
      }
    }
    label29:
    do
    {
      return (RecentBaseData)localObject2;
      if (!TextUtils.isEmpty(paramRecentUser.uin)) {
        break;
      }
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "buildRecentItemData, uin is null, " + paramRecentUser);
    return null;
    switch (paramRecentUser.type)
    {
    default: 
      localObject1 = localObject3;
      if (paramRecentUser.type == 9002)
      {
        if (!ActivateFriendsManager.a(paramQQAppInterface)) {
          break label785;
        }
        localObject1 = new RecentItemNewFriendMsgData(paramRecentUser);
      }
      break;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      ((RecentBaseData)localObject1).a(paramQQAppInterface, paramContext);
      localObject2 = localObject1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      return (RecentBaseData)localObject1;
      localObject1 = new RecentItemTroopAssistant(paramRecentUser);
      continue;
      localObject1 = new RecentItemPcDataLine(paramRecentUser);
      continue;
      localObject1 = new RecentItemPcDataLine(paramRecentUser);
      continue;
      localObject1 = new RecentItemRouterDataLine(paramRecentUser);
      continue;
      localObject1 = new RecentItemSubAccount(paramRecentUser);
      continue;
      localObject1 = new RecentItemMsgBox(paramRecentUser);
      continue;
      if (TextUtils.equals(paramRecentUser.uin, AppConstants.aZ))
      {
        localObject1 = localObject3;
        if (ReadInJoyHelper.a(paramQQAppInterface)) {}
      }
      else
      {
        localObject1 = new RecentItemChatMsgData(paramRecentUser);
        continue;
        if (paramRecentUser.msg != null)
        {
          localObject1 = localObject3;
          if (!(paramRecentUser.msg instanceof String)) {}
        }
        else
        {
          localObject1 = new RecentItemNewFriendMsgData(paramRecentUser);
          continue;
          localObject1 = new RecentItemTroopMsgData(paramRecentUser);
          continue;
          localObject1 = new RecentItemDiscussionMsgData(paramRecentUser);
          continue;
          localObject1 = new RecentItemTroopNotification(paramRecentUser);
          continue;
          localObject1 = new SecMsgRecentItemData(paramRecentUser);
          continue;
          localObject1 = new SendBlessRecentItemData(paramRecentUser);
          continue;
          localObject1 = localObject3;
          if (!ReadInJoyHelper.a(paramQQAppInterface))
          {
            localObject1 = new RecentItemTroopBarAssitant(paramRecentUser);
            continue;
            localObject1 = localObject3;
            if (ReadInJoyHelper.a(paramQQAppInterface))
            {
              localObject1 = localObject3;
              if (!ReadInJoyHelper.c())
              {
                localObject1 = new RecentItemKandianMergeData(paramRecentUser);
                continue;
                localObject1 = new RecentItemServiceAccountFolderData(paramRecentUser);
                continue;
                localObject1 = new RecentItemEcShopAssitant(paramRecentUser);
                continue;
                localObject1 = new RecentItemQCallData(paramRecentUser);
                continue;
                localObject1 = new DingdongPluginRecentItem(paramRecentUser);
                continue;
                localObject1 = new RecentItemWifiHotSpot(paramRecentUser);
                continue;
                localObject1 = new RecentItemChangeMachine(paramRecentUser);
                continue;
                label785:
                localObject1 = new RecentItemActivateFriendsData(paramRecentUser);
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(List paramList1, QQAppInterface paramQQAppInterface, Context paramContext, List paramList2, int paramInt)
  {
    if (paramList2 == null) {
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        paramList2.clear();
        if (paramList1 == null) {
          break label330;
        }
        i = paramList1.size();
        j = paramInt;
        if (paramQQAppInterface.a == null) {
          break label315;
        }
        j = paramInt;
        if (!paramQQAppInterface.a.b()) {
          break label315;
        }
        j = paramInt;
        if (i <= 90) {
          break label315;
        }
        paramInt = Math.min(90, paramInt);
        j = paramInt;
        if (!QLog.isColorLevel()) {
          break label315;
        }
        QLog.d("Q.recent", 2, "convertToRecentBaseDataList limit:" + paramInt + ",size:" + i);
        j = paramInt;
      }
      finally {}
      if ((paramInt >= j) || (paramInt >= i)) {
        break;
      }
      Object localObject2 = (RecentUser)paramList1.get(paramInt);
      if ((localObject2 != null) && (((RecentUser)localObject2).type != 9503) && ((j >= i) || (((RecentUser)localObject2).type != 7000)))
      {
        TraceUtils.a(((RecentUser)localObject2).uin);
        String str = RecentDataListManager.a(((RecentUser)localObject2).uin, ((RecentUser)localObject2).type);
        Object localObject1 = RecentDataListManager.a().a(str);
        if (localObject1 == null)
        {
          localObject2 = a((RecentUser)localObject2, paramQQAppInterface, paramContext);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            RecentDataListManager.a().a((RecentBaseData)localObject2, str);
            localObject1 = localObject2;
          }
          if (localObject1 != null) {
            paramList2.add(localObject1);
          }
          TraceUtils.a();
        }
        else
        {
          if ((localObject1 instanceof RecentUserBaseData)) {
            ((RecentUserBaseData)localObject1).a((RecentUser)localObject2);
          }
          ((RecentBaseData)localObject1).a(paramQQAppInterface, paramContext);
          continue;
          label315:
          paramInt = 0;
          continue;
        }
      }
      paramInt += 1;
      continue;
      label330:
      int i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\ConversationDataFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */