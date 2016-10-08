import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.fts.FTSSyncHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;

public class qnh
  implements Runnable
{
  public qnh(FTSDBManager paramFTSDBManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (SQLiteFTSUtils.h(FTSDBManager.a(this.a)))
          {
            FTSDBManager.a(this.a);
            return;
          }
        } while ((!SQLiteFTSUtils.i(FTSDBManager.a(this.a))) || (this.a.b));
        FTSDBManager.a(this.a);
        ThreadRegulator.a().b();
      } while (FTSDBManager.a(this.a));
      if ((FTSDBManager.b(this.a) > 10) || (FTSDBManager.c(this.a) == 1))
      {
        FTSDBManager.a(this.a);
        return;
      }
    } while (FTSDBManager.c(this.a) != -1);
    this.a.a.postDelayed(this, 5000L);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qnh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */