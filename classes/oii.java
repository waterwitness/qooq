import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.activity.contact.addcontact.ViewFactory.GuideView.OnItemClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class oii
  implements ViewFactory.GuideView.OnItemClickListener
{
  public oii(SearchContactsFragment paramSearchContactsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "guide view | onItemClick type is:" + paramInt + " keyWords is:" + paramString);
    }
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_Int = paramInt;
    this.a.a(paramString, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */