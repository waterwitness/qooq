import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class ngi
  implements Runnable
{
  public ngi(PressToChangeVoicePanel paramPressToChangeVoicePanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PressToChangeVoicePanel.a(this.a, true);
    boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool);
    }
    if (bool)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h())
      {
        this.a.setClickable(false);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(2);
      }
      return;
    }
    PressToChangeVoicePanel.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, "0X8006386");
    if (PressToChangeVoicePanel.jdField_b_of_type_JavaLangString == null)
    {
      QQToast.a(BaseApplication.getContext(), 2131372153, 0).a();
      return;
    }
    com.tencent.mobileqq.transfile.PttInfoCollector.a = SystemClock.uptimeMillis();
    int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getTitleBarHeight();
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (!FileUtils.a())
    {
      QQToast.a(BaseApplication.getContext(), 2131367684, 0).b(i);
      label175:
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c) {
        break label565;
      }
    }
    label565:
    for (i = 1;; i = 2)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005472", "0X8005472", i, 0, "", "", "", "6.5.5");
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(this.a);
      return;
      if (!QQRecorder.d())
      {
        QQToast.a(BaseApplication.getContext(), 2131367685, 0).b(i);
        break label175;
      }
      if (!QQRecorder.a(((QQRecorder.RecorderParam)localObject).c))
      {
        QQToast.a(BaseApplication.getContext(), 2131367688, 0).b(i);
        break label175;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
      {
        QQToast.a(BaseApplication.getContext(), 2131368056, 0).a();
        break label175;
      }
      if (AudioHelper.b(1))
      {
        ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
        break label175;
      }
      this.a.f();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.a, false, (QQRecorder.RecorderParam)localObject);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(3);
      this.a.h();
      localObject = new Rect();
      Rect localRect = new Rect();
      this.a.jdField_b_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect);
      this.a.getWindowVisibleDisplayFrame((Rect)localObject);
      localRect = new Rect();
      this.a.c.getGlobalVisibleRect(localRect);
      int j = localRect.bottom;
      i = j;
      if (Build.MODEL.startsWith("Coolpad"))
      {
        i = j;
        if (VersionUtils.h()) {
          i = j - ((Rect)localObject).top;
        }
      }
      this.a.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), ((Rect)localObject).right, ((Rect)localObject).bottom, i, this.a, 0, 0, 0);
      this.a.jdField_a_of_type_AndroidViewView = AudioPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.a.jdField_b_of_type_AndroidViewViewGroup, this.a.c);
      break label175;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ngi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */