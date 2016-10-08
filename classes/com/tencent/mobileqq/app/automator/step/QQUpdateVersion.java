package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.C2CMessageManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQUpdateVersion
  extends AsyncStep
{
  private final String c;
  private final String d;
  private final String e;
  
  public QQUpdateVersion()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = "qq_update_5.6";
    this.d = "qq_update_6.5.5";
    this.e = "QQUpdateVersion";
  }
  
  private void c()
  {
    int i = 0;
    String str;
    int j;
    Object localObject3;
    Object localObject1;
    if (i < MsgProxyUtils.c.length)
    {
      str = MsgProxyUtils.c[i];
      j = MsgProxyUtils.t[i];
      localObject3 = this.a.b.a().b(str, j);
      localObject1 = AppConstants.aO;
      if (MsgProxyUtils.a(j) != 1001) {
        break label79;
      }
      localObject1 = AppConstants.aO;
    }
    for (;;)
    {
      if ((localObject3 == null) || (((List)localObject3).isEmpty()))
      {
        return;
        label79:
        if (MsgProxyUtils.a(j) == 1010) {
          localObject1 = AppConstants.aP;
        }
      }
      else
      {
        Object localObject2 = null;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject3).iterator();
        label116:
        while (localIterator.hasNext())
        {
          localObject3 = (MessageRecord)localIterator.next();
          if ((!((String)localObject1).equals(((MessageRecord)localObject3).senderuin)) && (MsgProxyUtils.c((MessageRecord)localObject3)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQUpdateVersion", 2, "doMergeSayHelloBox oneWay=" + ((MessageRecord)localObject3).getBaseInfoString());
            }
            if (localObject2 != null) {
              break label442;
            }
            localObject2 = localObject3;
          }
        }
        label442:
        for (;;)
        {
          this.a.b.a().a().a(str, j, ((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).selfuin, false);
          ((MessageRecord)localObject3).frienduin = ((String)localObject1);
          ((MessageRecord)localObject3).setStatus(1000);
          localArrayList.add(localObject3);
          break label116;
          if (localArrayList.size() > 0) {
            this.a.b.a().b(localArrayList);
          }
          if (localObject2 != null)
          {
            this.a.b.a().a(str, j, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).selfuin);
            localObject3 = MessageRecordFactory.a(((MessageRecord)localObject2).msgtype);
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject3, (MessageRecord)localObject2);
            ((MessageRecord)localObject3).senderuin = ((String)localObject1);
            ((MessageRecord)localObject3).frienduin = str;
            ((MessageRecord)localObject3).istroop = j;
            localObject1 = new ArrayList();
            ((List)localObject1).add(localObject3);
            this.a.b.a().b((List)localObject1);
            this.a.b.a().b(str, j);
            this.a.b.a().a().a((MessageRecord)localObject3, true, 2);
            this.a.b.a().a().a((MessageRecord)localObject2, true, 2);
            this.a.b.a().a(localObject3);
          }
          i += 1;
          break;
        }
      }
    }
  }
  
  private void d()
  {
    Object localObject = this.a.b.a().b(AppConstants.aP, 1010);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        this.a.b.a().a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin);
      }
    }
    localObject = this.a.b.a().b(AppConstants.aH, 1010);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        this.a.b.a().a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin);
      }
    }
  }
  
  protected int a()
  {
    localSharedPreferences = this.a.b.a().getSharedPreferences(this.a.b.a(), 0);
    boolean bool1 = localSharedPreferences.getBoolean("qq_update_5.6", true);
    boolean bool2 = localSharedPreferences.getBoolean("qq_update_6.5.5", true);
    if (bool1) {
      if (QLog.isColorLevel()) {
        QLog.d("QQUpdateVersion", 2, "do qq update 5.6");
      }
    }
    try
    {
      String[] arrayOfString = "6.5.5".split("\\.");
      if ((arrayOfString != null) && (arrayOfString.length >= 2))
      {
        int i = Integer.parseInt(arrayOfString[0]);
        int j = Integer.parseInt(arrayOfString[1]);
        if ((i >= 5) && (j >= 6)) {
          c();
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        do
        {
          d();
          localSharedPreferences.edit().putBoolean("qq_update_6.5.5", false).commit();
          return 7;
          localException1 = localException1;
        } while (!QLog.isColorLevel());
        QLog.w("QQUpdateVersion", 2, localException1.getMessage(), localException1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QQUpdateVersion 6.5.5", 2, localException2.getMessage(), localException2);
          }
        }
      }
    }
    localSharedPreferences.edit().putBoolean("qq_update_5.6", false).commit();
    if (bool2) {
      if (QLog.isColorLevel()) {
        QLog.d("QQUpdateVersion", 2, "do qq update 6.5.5");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\QQUpdateVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */