import android.text.TextUtils;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearpeople.ranking.ShowLoveEditorActivity;
import com.tencent.qphone.base.util.QLog;

public class tqs
  implements ConditionSearchManager.IConfigListener
{
  public tqs(ShowLoveEditorActivity paramShowLoveEditorActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "onGetConfig:" + paramInt + "   " + paramBoolean);
    }
    if ((paramBoolean) && (TextUtils.isEmpty(this.a.f)) && (this.a.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.a.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      String str = this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.a.jdField_a_of_type_ArrayOfJavaLangString);
      if ((!this.a.f.equals(str)) && (!this.a.b)) {
        this.a.runOnUiThread(new tqt(this));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */