import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rsk
  extends FMObserver
{
  public rsk(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
      } while (!(paramThumbnailInfo.a instanceof FileManagerEntity));
      localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.a;
    } while ((paramThumbnailInfo.b == null) || (paramThumbnailInfo.b.length() <= 0));
    localFileManagerEntity.strThumbPath = paramThumbnailInfo.b;
    QfileBaseLocalFileTabView.b(this.a).a().c(localFileManagerEntity);
    this.a.j();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseLocalFileTabView.a(this.a, new rsl(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QfileBaseLocalFileTabView.b(this.a, new rsm(this, paramLong2));
  }
  
  protected void b()
  {
    super.b();
    QfileBaseLocalFileTabView.c(this.a, new rsn(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rsk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */