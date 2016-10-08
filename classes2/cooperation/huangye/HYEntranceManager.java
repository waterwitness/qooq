package cooperation.huangye;

import android.os.Message;
import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;
import ycn;

public class HYEntranceManager
{
  private static final int jdField_a_of_type_Int = 0;
  private static volatile HYEntranceManager jdField_a_of_type_CooperationHuangyeHYEntranceManager;
  private static final String jdField_a_of_type_JavaLangString = "HYEntranceManager";
  private static final int b = 1;
  private static final int c = 2;
  private HYConfigLoader.GetConfigListener jdField_a_of_type_CooperationHuangyeHYConfigLoader$GetConfigListener;
  private int d;
  
  private HYEntranceManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = 0;
    this.jdField_a_of_type_CooperationHuangyeHYConfigLoader$GetConfigListener = new ycn(this);
  }
  
  public static HYEntranceManager a()
  {
    if (jdField_a_of_type_CooperationHuangyeHYEntranceManager == null) {}
    try
    {
      if (jdField_a_of_type_CooperationHuangyeHYEntranceManager == null) {
        jdField_a_of_type_CooperationHuangyeHYEntranceManager = new HYEntranceManager();
      }
      return jdField_a_of_type_CooperationHuangyeHYEntranceManager;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int i = 1;
    boolean bool;
    if (this.d == 1)
    {
      bool = true;
      if (bool != paramBoolean) {
        if (!paramBoolean) {
          break label111;
        }
      }
    }
    for (;;)
    {
      label111:
      try
      {
        this.d = i;
        Object localObject = paramQQAppInterface.a(Conversation.class);
        if (localObject != null)
        {
          Message localMessage = Message.obtain();
          localMessage.what = 16;
          localMessage.arg1 = 0;
          ((MqqHandler)localObject).sendMessage(localMessage);
        }
        paramQQAppInterface = paramQQAppInterface.a(Call.class);
        if (paramQQAppInterface != null)
        {
          localObject = Message.obtain();
          ((Message)localObject).what = 16;
          ((Message)localObject).arg1 = 0;
          paramQQAppInterface.sendMessage((Message)localObject);
        }
        return;
      }
      finally {}
      bool = false;
      break;
      i = 2;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (this.d == 0)
    {
      HYConfigLoader.a().a(this.jdField_a_of_type_CooperationHuangyeHYConfigLoader$GetConfigListener);
      HYConfigLoader.a().a(paramQQAppInterface);
    }
    while (this.d == 1) {
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYEntranceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */