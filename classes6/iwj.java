import android.content.Intent;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.CompoundProcessor;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.VideoCompoundController;

public class iwj
  implements Runnable
{
  public iwj(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = RichmediaClient.a().a().a(this.a.g);
    if (localObject != null) {
      ((CompoundProcessor)localObject).a(103);
    }
    for (;;)
    {
      localObject = this.a.getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      this.a.setResult(1001, (Intent)localObject);
      this.a.finish();
      return;
      this.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */