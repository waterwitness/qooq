import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rvj
  extends FMObserver
{
  public rvj(QfileRecentPicFileTabView paramQfileRecentPicFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    super.a(paramThumbnailInfo);
    if ((paramThumbnailInfo.b != null) && (paramThumbnailInfo.b.length() > 0)) {
      this.a.j();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rvj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */