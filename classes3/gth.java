import android.content.Context;
import android.widget.Button;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.BeautyToolbar;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.EffectToolbar;
import com.tencent.av.ui.FaceToolbar;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IEffectCallback;
import com.tencent.av.ui.RaffitiToolbar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioHelper;
import java.lang.ref.WeakReference;

public class gth
{
  public int a;
  public Button a;
  public BaseToolbar a;
  public gtj a;
  public String a;
  public int b;
  public String b;
  
  public gth(EffectSettingUi paramEffectSettingUi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private BaseToolbar a(int paramInt)
  {
    Object localObject;
    QAVPtvTemplateAdapter.IEffectCallback localIEffectCallback;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("create Toolbar fail, Illegal value " + paramInt);
    case 2131299134: 
      localObject = new BeautyToolbar();
      localIEffectCallback = this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.d;
    }
    for (;;)
    {
      ((BaseToolbar)localObject).a(this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Context)this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.jdField_a_of_type_AndroidWidgetRelativeLayout, localIEffectCallback);
      return (BaseToolbar)localObject;
      localObject = new RaffitiToolbar();
      localIEffectCallback = this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.c;
      continue;
      localObject = new FaceToolbar();
      localIEffectCallback = this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.b;
      continue;
      localObject = new EffectToolbar();
      localIEffectCallback = this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(paramBoolean);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiBaseToolbar != null) {
      this.jdField_a_of_type_ComTencentAvUiBaseToolbar.a();
    }
    a(false);
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentAvUiBaseToolbar != null)
    {
      this.jdField_a_of_type_ComTencentAvUiBaseToolbar.a(paramVideoAppInterface);
      this.jdField_a_of_type_ComTencentAvUiBaseToolbar = null;
    }
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if (this.jdField_a_of_type_ComTencentAvUiBaseToolbar == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiBaseToolbar.a(paramArrayOfObject);
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Gtj.a())
    {
      ((AVActivity)this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.jdField_a_of_type_JavaLangRefWeakReference.get()).a(76, this.jdField_a_of_type_Gtj.a(), 3000, 1);
      gti.a(this.jdField_b_of_type_JavaLangString);
      return false;
    }
    gti.a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentAvUiBaseToolbar == null) {
      this.jdField_a_of_type_ComTencentAvUiBaseToolbar = a(this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvUiBaseToolbar.b();
    a(true);
    return true;
  }
  
  public void b()
  {
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a(), this.jdField_a_of_type_AndroidWidgetButton, this.jdField_a_of_type_Gtj.a(), this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */