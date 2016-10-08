import com.tencent.av.ui.EffectToolbar;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IItemDownloadMgr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public class gtk
  implements QAVPtvTemplateAdapter.IItemDownloadMgr
{
  public gtk(EffectToolbar paramEffectToolbar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    PtvTemplateManager.a(paramAppInterface).a(paramAppInterface, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gtk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */