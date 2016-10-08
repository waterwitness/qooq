package com.tencent.mobileqq.dating;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import rgi;
import rgj;

public class SayHelloMsgListActivity
  extends BaseMsgBoxActivity
{
  NearbyRelevantObserver a;
  
  public SayHelloMsgListActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver = new rgi(this);
  }
  
  protected List a(List paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    long l2;
    if (localIterator.hasNext())
    {
      paramList = (MessageRecord)localIterator.next();
      String str = paramList.senderuin;
      l2 = System.currentTimeMillis();
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
        paramList = (RecentBaseData)this.jdField_a_of_type_JavaUtilMap.get(str);
      }
      for (;;)
      {
        paramList.a(this.app, BaseApplication.getContext());
        localArrayList1.add(paramList);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("Q.msg_box", 4, "item update time cost = " + (System.currentTimeMillis() - l2));
        break;
        paramList = new RecentSayHelloListItem(paramList);
        this.jdField_a_of_type_JavaUtilMap.put(str, paramList);
        try
        {
          localArrayList2.add(Long.valueOf(paramList.a()));
        }
        catch (Exception localException) {}
      }
    }
    if (!localArrayList2.isEmpty()) {
      ThreadManager.a().post(new rgj(this, localArrayList2));
    }
    if (QLog.isDevelopLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 4, "makeRecetBaseData |start cost time:" + (l2 - l1));
    }
    return localArrayList1;
  }
  
  protected void b(List paramList)
  {
    Object localObject3 = null;
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    ConversationFacade localConversationFacade = this.app.a();
    Object localObject1 = null;
    Object localObject2 = null;
    MessageRecord localMessageRecord;
    Object localObject4;
    int k;
    int j;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        if (TextUtils.isEmpty(localMessageRecord.senderuin))
        {
          localIterator.remove();
        }
        else
        {
          localObject4 = localObject1;
          if (localMessageRecord.istroop == 1001)
          {
            localObject4 = localObject1;
            if (!localMessageRecord.senderuin.equals(AppConstants.aO))
            {
              localObject4 = localObject1;
              if (!localMessageRecord.senderuin.equals(AppConstants.aP))
              {
                if (localConversationFacade == null) {
                  break label443;
                }
                k = localConversationFacade.e(localMessageRecord.senderuin, 1001);
                if (k != 0) {
                  break label434;
                }
                j = localConversationFacade.d(localMessageRecord.senderuin, 1001);
                if (j > 0) {
                  break label428;
                }
                i = localConversationFacade.a(localMessageRecord);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (k > 0)
      {
        localObject4 = localObject3;
        if (localObject3 == null) {
          localObject4 = new ArrayList();
        }
        ((List)localObject4).add(localMessageRecord);
        localIterator.remove();
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
      }
      for (;;)
      {
        localObject4 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
        if (j <= 0)
        {
          localObject4 = localObject1;
          if (i <= 0) {}
        }
        else
        {
          if (j > 0)
          {
            localObject4 = localObject2;
            if (localObject2 == null) {
              localObject4 = new ArrayList();
            }
            ((List)localObject4).add(localMessageRecord);
            localIterator.remove();
            localObject2 = localObject1;
            localObject1 = localObject3;
            localObject3 = localObject4;
            continue;
          }
          localObject4 = localObject1;
          if (i > 0)
          {
            localObject4 = localObject1;
            if (localObject1 == null) {
              localObject4 = new ArrayList();
            }
            ((List)localObject4).add(localMessageRecord);
            localIterator.remove();
          }
        }
        localObject1 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject4;
      }
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        paramList.addAll(0, (Collection)localObject1);
      }
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        paramList.addAll(0, (Collection)localObject2);
      }
      if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
        break;
      }
      paramList.addAll(0, (Collection)localObject3);
      return;
      label428:
      i = 0;
      continue;
      label434:
      i = 0;
      j = 0;
      continue;
      label443:
      k = 0;
      i = 0;
      j = 0;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setTitle(2131372098);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver, true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\SayHelloMsgListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */