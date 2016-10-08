import android.content.Context;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.ILog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class hgv
  implements Runnable
{
  public hgv(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (HtmlOffline.a.a()) {
      HtmlOffline.a.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,Begin transThread:");
    }
    new hhc(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack).a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */