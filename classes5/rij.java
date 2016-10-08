import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.bubble.BubbleDiyText;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class rij
  implements BusinessObserver
{
  rij(rhz paramrhz, Bundle paramBundle1, MessengerService paramMessengerService, Bundle paramBundle2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null)) {}
    try
    {
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        if (!((List)paramObject).isEmpty()) {
          this.jdField_a_of_type_AndroidOsBundle.putString("diyText", ((BubbleDiyText)((List)paramObject).get(0)).mText);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.b);
        return;
        this.jdField_a_of_type_AndroidOsBundle.putString("diyText", "");
      }
      return;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.emoji.web.MessengerService", 2, ((Exception)paramObject).getMessage());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */