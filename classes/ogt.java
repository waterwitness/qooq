import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ogt
  implements ConditionSearchManager.IConfigListener
{
  public ogt(AddContactsView paramAddContactsView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AddContactsView.a(), 2, "onGetConfig | isSuccess = " + paramBoolean + ", resultCode = " + paramInt);
    }
    if ((paramInt == 2) && (paramBoolean))
    {
      this.a.b = true;
      this.a.e();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ogt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */