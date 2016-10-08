import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormMutiItem;

class ogx
  implements Runnable
{
  ogx(ogw paramogw, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Ogw.a.b.setSecondLineText("");
      this.jdField_a_of_type_Ogw.a.b.setSecondLineVisible(false);
      return;
    }
    this.jdField_a_of_type_Ogw.a.b.setSecondLineText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Ogw.a.b.setSecondLineVisible(true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ogx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */