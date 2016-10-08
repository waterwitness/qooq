import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad.FilterVideoSoCallback;
import com.tencent.mobileqq.shortvideo.util.PtvSoDownLoadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public final class usq
  implements PtvFilterSoLoad.FilterVideoSoCallback
{
  private PtvFilterSoLoad.FilterVideoSoCallback a;
  
  private usq(PtvFilterSoLoad.FilterVideoSoCallback paramFilterVideoSoCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramFilterVideoSoCallback;
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvSoDownLoadManager", 2, "WrapFilterVideoDownload:" + paramInt + " " + paramBoolean);
    }
    if (!paramBoolean)
    {
      QQToast.a(BaseApplicationImpl.getContext(), "视频贴纸插件下载失败", 0).a();
      this.a.a(-1);
    }
    do
    {
      return;
      if ((paramInt == 1) && (paramBoolean)) {
        PtvSoDownLoadManager.b(true);
      }
      if ((paramInt == 2) && (paramBoolean)) {
        PtvSoDownLoadManager.c(true);
      }
    } while ((!PtvSoDownLoadManager.b()) || (!PtvSoDownLoadManager.c()));
    this.a.a(101);
    PtvSoDownLoadManager.b(false);
    PtvSoDownLoadManager.c(false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (usq)paramObject;
        if (this.a != null) {
          break;
        }
      } while (((usq)paramObject).a == null);
      return false;
    } while (this.a.equals(((usq)paramObject).a));
    return false;
  }
  
  public int hashCode()
  {
    if (this.a == null) {}
    for (int i = 0;; i = this.a.hashCode()) {
      return i + 31;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */