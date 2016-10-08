import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hpj
  implements Runnable
{
  public hpj(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = PublicAccountJavascriptInterface.a();
    try
    {
      PublicAccountJavascriptInterface.a(l);
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */