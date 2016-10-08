import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import java.util.LinkedList;
import java.util.List;

public class txi
  implements Runnable
{
  public txi(QzonePhotoView paramQzonePhotoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (QZoneCover)this.a.a.a().createEntityManager().a(QZoneCover.class, QzonePhotoView.a(this.a));
    if (localObject != null)
    {
      new LinkedList();
      localObject = QzonePhotoView.a(this.a, ((QZoneCover)localObject).type, ((QZoneCover)localObject).parseCoverInfo(), ((QZoneCover)localObject).parsePhotoInfo());
      this.a.a((List)localObject);
      Message localMessage = Message.obtain();
      localMessage.what = 200;
      localMessage.obj = localObject;
      QzonePhotoView.a(this.a).sendMessage(localMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\txi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */