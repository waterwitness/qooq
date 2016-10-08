import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iwm
  implements DialogInterface.OnClickListener
{
  public iwm(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StoryReportor.a("video_shoot", "cancel_now", 0, 0, new String[0]);
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */