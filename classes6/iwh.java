import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iwh
  extends OrientationEventListener
{
  public iwh(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1)
    {
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "OrientationEventListener unknown");
      this.a.t = 90;
    }
    do
    {
      return;
      if ((paramInt > 315) || (paramInt < 45))
      {
        this.a.t = 90;
        return;
      }
      if ((paramInt > 45) && (paramInt < 135))
      {
        this.a.t = 180;
        return;
      }
      if ((paramInt > 135) && (paramInt < 225))
      {
        this.a.t = 270;
        return;
      }
    } while ((paramInt <= 225) || (paramInt >= 315));
    this.a.t = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */