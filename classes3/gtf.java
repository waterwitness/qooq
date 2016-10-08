import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IEffectCallback;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class gtf
  implements QAVPtvTemplateAdapter.IEffectCallback
{
  public gtf(EffectSettingUi paramEffectSettingUi)
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
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(1, paramPtvTemplateInfo.id);
    HashMap localHashMap = new HashMap();
    localHashMap.put("expID", VideoController.a().a().z);
    UserAction.onUserAction(EffectsRenderController.b, true, -1L, -1L, localHashMap, true);
    ((AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramPtvTemplateInfo.id);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gtf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */