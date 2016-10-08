import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class hqs
  implements Runnable
{
  public hqs(PublicAccountManager paramPublicAccountManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a.get();
    String str = this.a.D;
    boolean bool = this.a.jdField_b_of_type_Boolean;
    if ((this.a.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.a.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (localQQAppInterface != null)) {
      SosoInterface.a(new hqt(this, 1, true, true, 0L, true, false, "PublicAccountManager", str, bool));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */