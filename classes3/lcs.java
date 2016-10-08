import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DiscMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class lcs
  extends MessageObserver
{
  public lcs(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      this.a.b(new lcv(this));
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    paramString1 = RecentDataListManager.a(paramString1, Integer.MIN_VALUE);
    this.a.a(2, 9, paramString1);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    paramString = RecentDataListManager.a(paramString, Integer.MIN_VALUE);
    this.a.a(2, 9, paramString);
  }
  
  protected void a(boolean paramBoolean, String paramString, MessageHandler.MsgSendCostParams paramMsgSendCostParams)
  {
    a(paramBoolean, paramString);
  }
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() isSuccess=" + paramBoolean + " subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + " subAccount=" + paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString + " data.errorType=" + paramSubAccountBackProtocData.p + " errorMsg=" + paramSubAccountBackProtocData.a + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    if ((!paramBoolean) || (paramSubAccountBackProtocData == null)) {
      return;
    }
    if (paramSubAccountBackProtocData.p == 0)
    {
      SubAccountControll.a(this.a.a, paramString, 1);
      paramSubAccountBackProtocData = (SubAccountControll)this.a.a.getManager(61);
      if (paramSubAccountBackProtocData != null) {
        paramSubAccountBackProtocData.a(paramString, 1, true);
      }
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      if (paramSubAccountBackProtocData.p == 1)
      {
        SubAccountControll.c(this.a.a, paramString);
        Conversation.c(this.a);
      }
    }
  }
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.troop.revoked_troop_msg", 2, "onMsgRevokeNotice, isSuccess:" + paramBoolean1);
    }
    if (!paramBoolean1) {
      return;
    }
    MessageRecord localMessageRecord;
    TroopInfoManager localTroopInfoManager;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localMessageRecord = (MessageRecord)paramList.get(0);
      localTroopInfoManager = (TroopInfoManager)this.a.a.getManager(36);
      switch (localMessageRecord.istroop)
      {
      }
    }
    for (;;)
    {
      super.a(paramBoolean1, paramList, paramBoolean2);
      return;
      if (localTroopInfoManager.b(localMessageRecord.frienduin) != -1)
      {
        ((TroopMessageManager)this.a.a.a().a(localMessageRecord.istroop)).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.shmsgseq);
        this.a.a(8, localMessageRecord.frienduin, localMessageRecord.istroop);
        continue;
        if (localTroopInfoManager.b(localMessageRecord.frienduin + "&" + 3000) != -1)
        {
          ((DiscMessageManager)this.a.a.a().a(localMessageRecord.istroop)).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.shmsgseq);
          this.a.a(8, localMessageRecord.frienduin, localMessageRecord.istroop);
        }
      }
    }
  }
  
  protected void b()
  {
    TroopAssistantManager.a().c(this.a.a);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.data.errorType=" + paramSubAccountBackProtocData.p + " errorMsg=" + paramSubAccountBackProtocData.a + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    if (paramSubAccountBackProtocData != null) {
      switch (paramSubAccountBackProtocData.p)
      {
      default: 
        if ((paramSubAccountBackProtocData.jdField_c_of_type_Boolean) && (!paramSubAccountBackProtocData.d) && (paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString != null) && (paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString.length() > 4))
        {
          SubAccountControll.a(this.a.a, paramString, 6);
          paramSubAccountBackProtocData.d = true;
        }
        break;
      }
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      SubAccountControll.c(this.a.a, paramString);
      continue;
      SubAccountControll.a(this.a.a, 0);
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onGetOfflineMsgFinished|isSuc = " + paramBoolean);
    }
    if (Conversation.a(this.a) > 0L) {
      StartupTracker.a("Conversation_PullToRefresh_msgCB", SystemClock.uptimeMillis() - Conversation.a(this.a));
    }
    if (this.a.b != 1000L) {
      this.a.b = 1000L;
    }
    this.a.b(new lct(this, paramBoolean));
    Object localObject = (PublicAccountHandler)this.a.a.a(11);
    if (localObject != null)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
      long l = localSharedPreferences.getLong("fresh_weather_time", 0L);
      l = System.currentTimeMillis() - l;
      if ((l > 86400000L) || (l < 0L))
      {
        ((PublicAccountHandler)localObject).a(-1, 0, 0, 0);
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putLong("fresh_weather_time", System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  protected void d()
  {
    this.a.a(0L);
  }
  
  protected void d(boolean paramBoolean)
  {
    this.a.b(new lcu(this, paramBoolean));
  }
  
  public void d(boolean paramBoolean, String paramString)
  {
    this.a.a(8, paramString, Integer.MIN_VALUE);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, onBoxMsgUnreadNumRefresh");
    }
    this.a.a(0L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */