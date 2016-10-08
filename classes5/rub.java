import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rub
  extends FMObserver
{
  public rub(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.J(this.a).a().a(paramLong1, paramString, paramInt, paramLong2);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseRecentFileTabView.a, 2, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + FileManagerUtil.e(paramString) + "], peerType[" + paramInt + "]");
      }
      return;
    }
    this.a.b(localFileManagerEntity);
    QfileBaseRecentFileTabView.K(this.a).a().c(localFileManagerEntity);
    QfileBaseRecentFileTabView.c(this.a, new rue(this));
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
    QfileBaseRecentFileTabView.F(this.a).a().c(localFileManagerEntity);
    this.a.j();
  }
  
  protected void a(Boolean paramBoolean, List paramList)
  {
    QfileBaseRecentFileTabView.a(this.a, paramBoolean, paramList);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    QfileBaseRecentFileTabView.d(this.a, new ruf(this));
    FileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseRecentFileTabView.a(this.a, new ruc(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.G(this.a).a().a(paramLong1, paramString1, paramInt1, paramLong2);
    if (localFileManagerEntity == null)
    {
      QLog.e(QfileBaseRecentFileTabView.a, 1, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + FileManagerUtil.e(paramString1) + "], peerType[" + paramInt1 + "]");
      return;
    }
    if (!paramBoolean)
    {
      localFileManagerEntity.bDelInFM = false;
      FileManagerUtil.a(paramLong2, paramInt2, paramString2);
    }
    if ((this.a.b == null) || (this.a.b.trim().length() == 0) || (localFileManagerEntity.getCloudType() != 2)) {
      this.a.b(localFileManagerEntity);
    }
    QfileBaseRecentFileTabView.H(this.a).a().c(localFileManagerEntity);
    QfileBaseRecentFileTabView.b(this.a, new rud(this, paramLong2));
  }
  
  protected void b()
  {
    super.b();
    QfileBaseRecentFileTabView.e(this.a, new rug(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */