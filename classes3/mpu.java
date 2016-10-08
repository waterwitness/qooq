import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class mpu
  extends FriendListObserver
{
  public mpu(TroopAssistantActivity paramTroopAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    this.a.e();
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if ((this.a.app.a() != null) && (this.a.app.a().equals(paramString)))
    {
      ThreadManager.a(new mpw(this, paramString), 8, null, true);
      return;
    }
    this.a.e();
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("head", 2, "ContactsActivity.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    label134:
    do
    {
      return;
      int i;
      if (("batch_setting".equals(this.a.d)) && (this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() > 0) && (this.a.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController != null))
      {
        i = 0;
        for (;;)
        {
          if (i >= this.a.jdField_a_of_type_JavaUtilList.size()) {
            break label134;
          }
          paramMap = String.valueOf(this.a.jdField_a_of_type_JavaUtilList.get(i));
          if (((Boolean)this.a.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.get(paramMap)).booleanValue()) {
            break;
          }
          i += 1;
        }
        QQToast.a(this.a.app.a(), 2, "设置成功", 0).b(this.a.getTitleBarHeight());
        TroopAssistantActivity.a(this.a);
        return;
      }
      paramMap = paramMap.entrySet().iterator();
      if (paramMap.hasNext())
      {
        String str = (String)((Map.Entry)paramMap.next()).getKey();
        i = this.a.app.b(str);
        if ((i == 1) || (i == 4)) {
          TroopAssistantManager.a().c(str, this.a.app);
        }
        for (;;)
        {
          this.a.e();
          break;
          if (i == 3) {
            TroopAssistantManager.a().b(str, this.a.app);
          }
        }
      }
    } while (!this.a.isResume());
    if (paramBoolean)
    {
      QQToast.a(this.a.app.a(), 2, this.a.getString(2131368706), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.app.a(), 1, this.a.getString(2131368707), 0).b(this.a.getTitleBarHeight());
  }
  
  void b(String paramString)
  {
    if (!paramString.equals(this.a.app.getAccount())) {
      return;
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1).sendToTarget();
    this.a.runOnUiThread(new mpv(this));
  }
  
  protected void b(boolean paramBoolean, String paramString) {}
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (paramBoolean) {
      ThreadManager.a(new mpx(this), 5, null, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mpu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */