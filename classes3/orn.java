import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity.QueryPhotoTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class orn
  implements Runnable
{
  public orn(PhotoListActivity paramPhotoListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    new PhotoListActivity.QueryPhotoTask(this.a).execute(new Object[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\orn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */