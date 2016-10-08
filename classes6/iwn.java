import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.NowProxy;

public class iwn
  implements DialogInterface.OnClickListener
{
  public iwn(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity, NowProxy paramNowProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StoryReportor.a("video_shoot", "down_now", 0, 0, new String[0]);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowProxy.a(null);
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */