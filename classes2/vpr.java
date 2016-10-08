import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol.DeleteFileObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.widget.QQToast;

public class vpr
  extends TroopFileProtocol.DeleteFileObserver
{
  public vpr(TroopFileManager paramTroopFileManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramBundle == null) {
      return;
    }
    int i = BaseApplicationImpl.a().getResources().getDimensionPixelSize(2131492908);
    paramBundle = paramBundle.getString("fileId");
    if (paramBoolean)
    {
      this.a.a(paramBundle);
      return;
    }
    switch (paramInt)
    {
    default: 
      QQToast.a(BaseApplicationImpl.a(), "操作失败,请重试", 0).b(i);
      return;
    }
    QQToast.a(BaseApplicationImpl.a(), "删除失败,目标文件不存在", 0).b(i);
    this.a.a(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */