import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public final class ify
  implements Runnable
{
  public ify(Uri paramUri, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = this.jdField_a_of_type_AndroidNetUri.getQueryParameter("article_id");
    int i = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int == 0) {
      i = 100;
    }
    for (;;)
    {
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006DF8", "0X8006DF8", this.b, 0, str, this.jdField_a_of_type_JavaLangString, "" + i, "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */