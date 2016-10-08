import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class vis
  extends Handler
{
  public vis(TroopBarReplyActivity paramTroopBarReplyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramMessage.what)
            {
            case 1002: 
            case 1007: 
            default: 
              return;
            case 1001: 
              this.a.a(false);
              if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
                this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
              }
              QQToast.a(this.a, 2131364808, 1).b(this.a.getTitleBarHeight());
            }
          } while (!(paramMessage.obj instanceof String));
          paramMessage = (String)paramMessage.obj;
          try
          {
            this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramMessage);
            return;
          }
          catch (UnsupportedOperationException paramMessage) {}
        } while (!QLog.isColorLevel());
        QLog.d("TroopBar", 2, paramMessage.toString());
        return;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        this.a.a(false);
        this.a.a();
        return;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
      this.a.a();
      return;
      this.a.a(false);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      QQToast.a(this.a, 2131364807, 1).b(this.a.getTitleBarHeight());
      return;
      if ((paramMessage.obj instanceof String))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a((String)paramMessage.obj);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(this.a.jdField_a_of_type_JavaUtilArrayList);
    } while (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
    return;
    this.a.jdField_a_of_type_JavaUtilArrayList.clear();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
    TroopBarReplyActivity.a(this.a, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */