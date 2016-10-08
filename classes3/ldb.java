import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ldb
  extends SubAccountBindObserver
{
  public ldb(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (paramSubAccountBackProtocData == null)
      {
        localObject1 = null;
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramBoolean) && (paramSubAccountBackProtocData != null)) {
        break label113;
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder().append("Conversation.onGetBindSubAccount() return:");
        if (!paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (paramSubAccountBackProtocData = "data=null";; paramSubAccountBackProtocData = "isSucc=false")
    {
      QLog.d("SUB_ACCOUNT", 4, paramSubAccountBackProtocData);
      return;
      localObject1 = paramSubAccountBackProtocData.c;
      break;
    }
    label113:
    if (paramSubAccountBackProtocData.p == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      SubAccountControll.a(this.a.a, 0);
    }
    if (paramSubAccountBackProtocData.a())
    {
      SubAccountControll.a(this.a.a, paramSubAccountBackProtocData.a(), 2);
      this.a.a.d = true;
    }
    if (paramSubAccountBackProtocData.b())
    {
      localObject1 = paramSubAccountBackProtocData.b();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          SubAccountControll.c(this.a.a, (String)localObject2);
        }
      }
    }
    paramSubAccountBackProtocData.a();
    this.a.a(0L);
    Conversation.c(this.a);
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.p + " errMsg=" + paramSubAccountBackProtocData.a);
      }
    }
    if ((paramBoolean) && (paramSubAccountBackProtocData != null) && (paramSubAccountBackProtocData.c())) {
      SubAccountControll.a(this.a.a, paramSubAccountBackProtocData.c(), 1);
    }
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.p + " errMsg=" + paramSubAccountBackProtocData.a);
      }
    }
    if (paramSubAccountBackProtocData == null) {}
    while ((!paramBoolean) || (paramSubAccountBackProtocData.c == null) || (paramSubAccountBackProtocData.c.length() <= 4)) {
      return;
    }
    this.a.a.a().c(paramSubAccountBackProtocData.c, 7000);
    SubAccountControll.c(this.a.a, paramSubAccountBackProtocData.c);
    this.a.a(0L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ldb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */