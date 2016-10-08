import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nuh
  implements Runnable
{
  public nuh(AIOImageListScene paramAIOImageListScene)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!((AIOPhotoListAdapter)this.a.a).a(false)) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nuh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */