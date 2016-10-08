import com.tencent.av.funchat.magicface.MagicfaceManagerForAV;
import com.tencent.av.ui.FaceToolbar;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IItemDownloadMgr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public class gto
  implements QAVPtvTemplateAdapter.IItemDownloadMgr
{
  public gto(FaceToolbar paramFaceToolbar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    MagicfaceManagerForAV.a().a(paramPtvTemplateInfo.id, new gtp(this, paramIPtvTemplateDownloadListener, paramPtvTemplateInfo));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */