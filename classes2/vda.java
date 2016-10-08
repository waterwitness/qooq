import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.activity.AudioRecordActivity;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarImagePreviewAdapter;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class vda
  extends Handler
{
  public vda(AbsPublishActivity paramAbsPublishActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (this.a.isFinishing()) {}
    do
    {
      do
      {
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
                default: 
                  return;
                }
              } while (this.a.a(1));
              this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName());
              return;
              this.a.b(false);
              if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
                this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
              }
              this.a.rightViewText.setEnabled(true);
              this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
              this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
              QQToast.a(this.a, 2131364807, 1).b(this.a.getTitleBarHeight());
            } while (!(paramMessage.obj instanceof String));
            paramMessage = (String)paramMessage.obj;
            this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramMessage);
            return;
            if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
            }
            this.a.b(false);
            this.a.j();
            return;
          } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
          this.a.j();
          return;
          this.a.b(false);
          if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          }
          this.a.rightViewText.setEnabled(true);
          this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
          this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
          QQToast.a(this.a, 2131364807, 1).b(this.a.getTitleBarHeight());
          return;
        } while (this.a.a(2));
        paramMessage = new Intent();
        paramMessage.putExtra("audio_max_length", this.a.m);
        if (this.a.v != null)
        {
          paramMessage.putExtra("from", "publish");
          paramMessage.putExtra("bid", this.a.v);
          paramMessage.putExtra("fromflag", this.a.c);
          TroopBarUtils.a(this.a.t, this.a.u, "Clk_record", this.a.v, this.a.c, "", "");
        }
        paramMessage.setClass(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AudioRecordActivity.class);
        this.a.startActivityForResult(paramMessage, 1003);
        return;
      } while (!this.a.a(4));
      return;
    } while (!this.a.a(8));
    return;
    if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList);
      paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() < 9) {
        bool = true;
      }
      paramMessage.a(bool, true);
      this.a.a(4);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setCurType(4);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
      return;
    }
    this.a.jdField_a_of_type_JavaUtilArrayList.clear();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(false, true);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
    this.a.a(0);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setCurType(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */