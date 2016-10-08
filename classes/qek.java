import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class qek
  implements Runnable
{
  public qek(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(QQAppInterface.d(this.a).getApplicationContext(), 2131370682, 3000).a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */