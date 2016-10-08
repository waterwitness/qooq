import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.QbSdk;
import cooperation.comic.VipProxyPreLoadComicProcess;

public class yaj
  implements Runnable
{
  public yaj(VipProxyPreLoadComicProcess paramVipProxyPreLoadComicProcess, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QbSdk.preInit(this.jdField_a_of_type_AndroidContentContext, new yak(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */