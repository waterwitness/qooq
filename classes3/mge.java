import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;

class mge
  implements Runnable
{
  mge(mgd parammgd, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!Utils.a(this.jdField_a_of_type_JavaLangString, QQSettingMe.a(this.jdField_a_of_type_Mgd.a)))
    {
      QQSettingMe.a(this.jdField_a_of_type_Mgd.a, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Mgd.a.a.setText(QQSettingMe.a(this.jdField_a_of_type_Mgd.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */