import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.takevideo.QQStoryPreTakeVideo;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iwv
  implements DialogInterface.OnClickListener
{
  public iwv(QQStoryPreTakeVideo paramQQStoryPreTakeVideo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FontSettingManager.a();
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */