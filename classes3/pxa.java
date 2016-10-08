import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class pxa
  implements Runnable
{
  public pxa(DiscussionHandler paramDiscussionHandler, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.a().getApplicationContext(), 1, this.jdField_a_of_type_JavaLangString, 0).a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */