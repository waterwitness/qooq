import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectToolbar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gtl
  implements Runnable
{
  public gtl(EffectToolbar paramEffectToolbar, VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool;
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_ComTencentAvUiEffectToolbar.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
      {
        bool = true;
        QLog.d("EffectSettingUi", 4, String.format("双人挂件加载回调, mListView[%s]", new Object[] { Boolean.valueOf(bool) }));
      }
    }
    else {
      if (this.jdField_a_of_type_ComTencentAvUiEffectToolbar.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) {
        break label56;
      }
    }
    label56:
    do
    {
      return;
      bool = false;
      break;
      gtm localgtm = new gtm(this);
      bool = this.jdField_a_of_type_ComTencentAvUiEffectToolbar.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(localgtm);
    } while (!QLog.isDevelopLevel());
    QLog.d("EffectSettingUi", 4, String.format("双人挂件 Handler.post ret[%s]", new Object[] { Boolean.valueOf(bool) }));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gtl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */