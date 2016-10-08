import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.AppViewBaseActivity;
import com.tencent.open.appcommon.js.BaseJsCallBack;

public class wtf
  implements Runnable
{
  public wtf(BaseJsCallBack paramBaseJsCallBack, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString.equals("1")) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.activity instanceof AppViewBaseActivity)) {
        ((AppViewBaseActivity)this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.activity).b(bool);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wtf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */