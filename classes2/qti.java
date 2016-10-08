import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

class qti
  implements Runnable
{
  qti(qtg paramqtg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = this.a.a.a.b;
    File localFile = new File(str);
    if ((localFile != null) && (localFile.exists()))
    {
      DynamicUtils.a(this.a.a.app, str, 38, this.a.a.n, 100);
      return;
    }
    SelectCoverActivity.a(this.a.a, 2, "上传失败，请重试", 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */