import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.remind.RemindHelper;
import com.tencent.mobileqq.remind.TimeHelper;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;

public final class ufm
  implements DialogInterface.OnDismissListener
{
  public ufm(IosTimepicker paramIosTimepicker, JsBridgeListener paramJsBridgeListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    long l1;
    if ((this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener != null))
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker.a() / 1000L;
      if (!Build.MODEL.equals("Coolpad 5890")) {
        break label126;
      }
      long l2 = new Date().getTime() / 1000L;
      if (l1 >= l2) {
        break label126;
      }
      l1 = l2;
    }
    label126:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(RemindHelper.a(), 2, "onDismiss Time :" + TimeHelper.a(l1 * 1000L));
      }
      this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker.setOnTimePickerSelectListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener.a(Long.valueOf(l1));
      RemindHelper.a = true;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ufm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */