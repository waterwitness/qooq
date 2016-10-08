import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ntg
  implements MessageQueue.IdleHandler
{
  public ntg(AIOGalleryScene paramAIOGalleryScene)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean queueIdle()
  {
    Object localObject = this.a.a.a();
    if ((localObject != null) && (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).a)))
    {
      AIOImageData localAIOImageData = (AIOImageData)((AIORichMediaInfo)localObject).a;
      if ((localAIOImageData != null) && (localAIOImageData.a(4)) && (localAIOImageData.a(4) == null)) {
        this.a.c(true);
      }
    }
    if ((localObject != null) && (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).a)))
    {
      localObject = (AIOFilePicData)((AIORichMediaInfo)localObject).a;
      if ((localObject != null) && (((AIOFilePicData)localObject).a(20)) && (((AIOFilePicData)localObject).a(20) == null)) {
        this.a.c(true);
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ntg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */