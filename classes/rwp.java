import android.content.IntentFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class rwp
  implements Runnable
{
  public rwp(FileManagerDataCenter paramFileManagerDataCenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.a() != null))
    {
      if (FileManagerDataCenter.a(this.a) == null) {
        FileManagerDataCenter.a(this.a, new rwq(this));
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.a.a.a().registerReceiver(FileManagerDataCenter.a(this.a), localIntentFilter);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rwp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */