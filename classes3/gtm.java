import com.tencent.av.ui.EffectToolbar;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class gtm
  implements Runnable
{
  gtm(gtl paramgtl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = true;
    if (QLog.isDevelopLevel()) {
      if (this.a.jdField_a_of_type_ComTencentAvUiEffectToolbar.a == null) {
        break label57;
      }
    }
    for (;;)
    {
      QLog.d("EffectSettingUi", 4, String.format("双人挂件配置更新完成, mAdapter[%s]", new Object[] { Boolean.valueOf(bool) }));
      if (this.a.jdField_a_of_type_ComTencentAvUiEffectToolbar.a != null) {
        break;
      }
      return;
      label57:
      bool = false;
    }
    ArrayList localArrayList = this.a.jdField_a_of_type_ComTencentAvUiEffectToolbar.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.a.jdField_a_of_type_ComTencentAvUiEffectToolbar.a.a(localArrayList);
    this.a.jdField_a_of_type_ComTencentAvUiEffectToolbar.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localArrayList);
    this.a.jdField_a_of_type_ComTencentAvUiEffectToolbar.a.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gtm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */