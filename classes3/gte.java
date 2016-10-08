import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IEffectCallback;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class gte
  implements QAVPtvTemplateAdapter.IEffectCallback
{
  public gte(EffectSettingUi paramEffectSettingUi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.j();
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    this.a.j();
    if ((paramPtvTemplateInfo == null) || (!paramPtvTemplateInfo.usable)) {
      paramPtvTemplateInfo = "";
    }
    String str;
    for (Object localObject = "";; localObject = str)
    {
      if (((AVActivity)this.a.a.get()).a.a != null) {
        ((AVActivity)this.a.a.get()).a.a.a(paramPtvTemplateInfo, (String)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.i("EffectSettingUi", 2, "setVideoFilter " + paramPtvTemplateInfo);
      }
      return;
      localObject = PtvTemplateManager.g + paramPtvTemplateInfo.name;
      str = paramPtvTemplateInfo.id;
      paramPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localObject;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */