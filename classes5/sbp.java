import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class sbp
  extends MessageObserver
{
  public sbp(BaseActionBarDataLineFile paramBaseActionBarDataLineFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (BaseActionBarDataLineFile.a(this.a)) {
        FMToastUtil.a(2131362248);
      }
      BaseActionBarDataLineFile.a(this.a, false);
      QLog.d(BaseActionBarDataLineFile.a() + "[MPFile]", 2, "PC offline!");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */