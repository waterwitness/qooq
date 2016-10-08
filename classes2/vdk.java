import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.ContactsTroopActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class vdk
  extends Handler
{
  public vdk(ContactsTroopActivity paramContactsTroopActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 100: 
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.H();
        return;
      case 101: 
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.H();
        QQToast.a(this.a, this.a.getString(2131368597), 0).b(this.a.getTitleBarHeight());
        return;
      }
    } while (!(paramMessage.obj instanceof String));
    this.a.b();
    TroopUtils.a(this.a, 1, (String)paramMessage.obj, 1, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */