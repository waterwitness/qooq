import android.os.SystemClock;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.effects.FilterProcessRender;
import com.tencent.av.opengl.ui.GLRootView.OnEvent;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.cache.VideoImageCache2;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoTemplateParser;
import java.util.HashMap;
import java.util.Map;

public class gjo
  implements GLRootView.OnEvent
{
  public gjo(EffectsRenderController paramEffectsRenderController, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    if ((VideoController.a().a().K != -1) && (!VideoController.a().a().y.equals(this.jdField_a_of_type_JavaLangString))) {
      VideoMemoryManager.getInstance().getVideoImageCache().clear();
    }
    int i = VideoMaterialUtil.TRIGGER_TYPE.UNKNOW.value;
    Object localObject2;
    Object localObject1;
    if (!StringUtil.b(this.jdField_a_of_type_JavaLangString))
    {
      localObject2 = VideoTemplateParser.parseVideoMaterial(this.jdField_a_of_type_JavaLangString, "params", false, EffectsRenderController.jdField_a_of_type_ComTencentTtpicUtilDecryptListener);
      VideoMemoryManager.getInstance().getVideoImageCache().loadAllImages((VideoMaterial)localObject2);
      ((VideoMaterial)localObject2).setLoadImageFromCache(true);
      if (localObject2 == null)
      {
        localObject1 = null;
        if ((localObject1 == null) || (localObject2 == null)) {
          break label640;
        }
        i = ((VideoMaterial)localObject2).getTriggerType();
      }
    }
    for (;;)
    {
      localObject2 = EffectsRenderController.a(this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController, i);
      if (VideoController.a().a().K != -1)
      {
        if (!VideoController.a().a().y.equals(this.jdField_a_of_type_JavaLangString))
        {
          l2 = (System.currentTimeMillis() - VideoController.a().a().h) / 1000L;
          HashMap localHashMap = new HashMap();
          localHashMap.put("tempID", VideoController.a().a().z);
          localHashMap.put("duration", l2 + "");
          UserAction.onUserAction(EffectsRenderController.b, true, -1L, -1L, localHashMap, true);
          if (QLog.isColorLevel()) {
            QLog.d(EffectsRenderController.jdField_a_of_type_JavaLangString, 2, " " + this.jdField_a_of_type_JavaLangString + "   oldPath:  " + VideoController.a().a().y + "  gadTime: " + l2);
          }
          if (QLog.isColorLevel()) {
            QLog.d(EffectsRenderController.jdField_a_of_type_JavaLangString, 2, EffectsRenderController.b + "   ID:  " + VideoController.a().a().z + "  gadTime: " + l2);
          }
          VideoController.a().a().h = System.currentTimeMillis();
        }
        label375:
        long l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d(EffectsRenderController.jdField_a_of_type_JavaLangString, 2, "EffectsRenderController_onDrawFrame setVideoFilter patternPath =" + this.jdField_a_of_type_JavaLangString + " tempList  " + localObject1);
        }
        if (localObject1 != null) {
          break label606;
        }
        VideoController.a().a().K = -1;
        VideoController.a().a().y = "";
        GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(0, 1);
      }
      for (;;)
      {
        VideoController.a().a().z = this.b;
        if (!this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController.a();
          if (AndroidCamera.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(AndroidCamera.m, AndroidCamera.l);
          }
        }
        this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a((VideoFilterList)localObject1);
        if (!StringUtil.b((String)localObject2)) {
          this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a((String)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d(EffectsRenderController.jdField_a_of_type_JavaLangString, 2, "EffectsRenderController_onDrawFrame setVideoFilter time =" + (System.currentTimeMillis() - l1));
        }
        return;
        localObject1 = VideoFilterUtil.createFilters((VideoMaterial)localObject2);
        break;
        VideoController.a().a().h = System.currentTimeMillis();
        break label375;
        label606:
        VideoController.a().a().K = 0;
        VideoController.a().a().y = this.jdField_a_of_type_JavaLangString;
        GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(1, 1);
      }
      label640:
      continue;
      localObject1 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gjo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */