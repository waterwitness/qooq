import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.qphone.base.util.BaseApplication;

class tbs
  implements Runnable
{
  tbs(tbq paramtbq, ActionGlobalData paramActionGlobalData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    
    if (this.jdField_a_of_type_Tbq.jdField_a_of_type_Int == 1)
    {
      ((View)this.jdField_a_of_type_Tbq.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.b).setBackgroundColor(0);
      this.jdField_a_of_type_Tbq.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) && ("gravity".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.j)) && (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(BaseApplicationImpl.getContext().getString(2131367835), false))) {
      this.jdField_a_of_type_Tbq.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.a.au();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */