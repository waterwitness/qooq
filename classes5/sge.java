import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sge
  extends FMObserver
{
  sge(sgd paramsgd)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if ((paramThumbnailInfo.a instanceof FileManagerEntity))
    {
      paramThumbnailInfo = (FileManagerEntity)paramThumbnailInfo.a;
      if ((paramThumbnailInfo.Uuid != null) && (paramThumbnailInfo.Uuid.equals(OfflineVideoFileView.a(this.a.a).e()))) {
        this.a.a.h();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */