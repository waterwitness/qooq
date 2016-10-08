import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity.QueryPhotoTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oro
  implements Runnable
{
  public oro(PhotoListActivity paramPhotoListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a == null)
    {
      this.a.a = new PhotoListActivity.QueryPhotoTask(this.a);
      this.a.a.execute(new Object[0]);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */