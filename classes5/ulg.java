import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.widget.QQToast;

public class ulg
  implements Runnable
{
  ulg(FTSMessageSearchEngine paramFTSMessageSearchEngine)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), "Error:fts search exists repeated results", 0).a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ulg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */