import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public final class jgf
  implements Runnable
{
  public jgf(Exception paramException)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "leba_search", "leba_search_set_data", 0, 0, HtmlOffline.d("1002"), this.a.getClass().getSimpleName(), null, null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */