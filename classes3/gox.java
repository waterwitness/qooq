import android.view.Display;
import android.view.ViewGroup;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.funchat.magicface.MagicfaceManagerForAV;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.av.ui.AbstractOrientationEventListener;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.FaceToolbar;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gox
  extends ControlUIObserver
{
  public gox(SmallScreenVideoController paramSmallScreenVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
    if ((i == 1) || (i == 3)) {}
    while (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().c()) {
      return;
    }
  }
  
  protected void a(int paramInt) {}
  
  protected void a(String paramString)
  {
    if ((paramString != null) && (paramString.equals("SUPPORT_TRUE"))) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().M = true;
    }
    do
    {
      return;
      if ((paramString != null) && (paramString.equals("SUPPORT_FLASE")))
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().M = false;
        return;
      }
    } while (!FaceToolbar.a(this.a.jdField_a_of_type_ComTencentAvVideoController));
    ViewGroup localViewGroup = (ViewGroup)this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b.findViewById(2131298944);
    MagicfaceManagerForAV.a().a(paramString, localViewGroup);
  }
  
  protected void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  protected void a(ArrayList paramArrayList)
  {
    Object localObject;
    int k;
    int j;
    String str1;
    int m;
    boolean bool2;
    int i;
    label133:
    String str2;
    boolean bool1;
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      k = this.a.jdField_a_of_type_ComTencentAvVideoController.i();
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onChangeUI_ShowVideo-->infos=" + (String)localObject);
      }
      j = 0;
      if (j < paramArrayList.size())
      {
        localObject = (VideoViewInfo)paramArrayList.get(j);
        str1 = String.valueOf(((VideoViewInfo)localObject).jdField_a_of_type_Long);
        m = ((VideoViewInfo)localObject).jdField_a_of_type_Int;
        bool2 = ((VideoViewInfo)localObject).jdField_a_of_type_Boolean;
        i = -1;
        if (this.a.i == 3000)
        {
          i = 1004;
          str2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str1, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().e));
          if ((!((VideoViewInfo)localObject).jdField_b_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentAvVideoController.p())) {
            break label761;
          }
          if (str1.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
            break label467;
          }
          VideoLayerUI localVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (((VideoViewInfo)localObject).jdField_b_of_type_Long != 5L) {
            break label461;
          }
          bool1 = true;
          label226:
          localVideoLayerUI.a(str1, m, true, bool2, bool1);
          i = 0;
        }
      }
    }
    for (;;)
    {
      label243:
      if (i == 0)
      {
        if ((((VideoViewInfo)localObject).jdField_b_of_type_Boolean) || (((VideoViewInfo)localObject).jdField_a_of_type_Boolean)) {
          break label556;
        }
        if (k == 4) {
          break label524;
        }
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) {
          break label497;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
        label309:
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, ((VideoViewInfo)localObject).jdField_b_of_type_Boolean, ((VideoViewInfo)localObject).jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().z)
        {
          float f = UITools.a(this.a.jdField_a_of_type_AndroidContentContext, 12.0F);
          if (!str1.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
            this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, m, str2, f, -1);
          }
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, m);
        }
        j += 1;
        break;
        if (this.a.i == 1)
        {
          i = 1000;
          break label133;
        }
        if (this.a.i != 0) {
          break label133;
        }
        i = 0;
        break label133;
        label461:
        bool1 = false;
        break label226;
        label467:
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, bool2);
        i = 1;
        break label243;
        label497:
        ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
        break label309;
        label524:
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, ((VideoViewInfo)localObject).jdField_b_of_type_Boolean, ((VideoViewInfo)localObject).jdField_a_of_type_Boolean);
        continue;
        label556:
        if (!((VideoViewInfo)localObject).jdField_a_of_type_Boolean) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, ((VideoViewInfo)localObject).jdField_b_of_type_Boolean, ((VideoViewInfo)localObject).jdField_a_of_type_Boolean);
        } else {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, ((VideoViewInfo)localObject).jdField_b_of_type_Boolean, ((VideoViewInfo)localObject).jdField_a_of_type_Boolean);
        }
      }
      paramArrayList = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      i = this.a.l;
      if (this.a.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener == null) {}
      for (bool1 = true;; bool1 = this.a.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener.jdField_b_of_type_Boolean)
      {
        paramArrayList.a(i, bool1);
        i = this.a.l;
        j = this.a.jdField_a_of_type_AndroidViewDisplay.getRotation();
        if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b((i + j * 90) % 360);
        }
        if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
          this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.a.l);
        }
        return;
      }
      label761:
      i = 0;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.g == 2) {}
    do
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (!this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f())) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
      }
    } while (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
    this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
  }
  
  protected void b() {}
  
  protected void b(int paramInt) {}
  
  protected void b(ArrayList paramArrayList)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
    {
      Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onChangeUI_CloseVideo-->infos=" + (String)localObject);
      }
      int i = 0;
      if (i < paramArrayList.size())
      {
        localObject = (VideoViewInfo)paramArrayList.get(i);
        String str = String.valueOf(((VideoViewInfo)localObject).jdField_a_of_type_Long);
        boolean bool2 = ((VideoViewInfo)localObject).jdField_a_of_type_Boolean;
        int j = ((VideoViewInfo)localObject).jdField_a_of_type_Int;
        VideoLayerUI localVideoLayerUI;
        if (!str.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))
        {
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str, j))
          {
            TipsManager.c(106);
            TipsManager.c(103);
          }
          localVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (((VideoViewInfo)localObject).jdField_b_of_type_Long != 5L) {
            break label188;
          }
        }
        label188:
        for (boolean bool1 = true;; bool1 = false)
        {
          localVideoLayerUI.a(str, j, false, bool2, bool1);
          i += 1;
          break;
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {}
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onChangeUI_DobuleAudio2MultiAudio isBackground_Stop:" + this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    label51:
    long l1;
    Object localObject;
    do
    {
      do
      {
        break label51;
        do
        {
          return;
        } while (this.a.jdField_a_of_type_ComTencentAvVideoController.a().k == 11);
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, false, false, false);
        }
        if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
        {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.c();
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
        }
        this.a.d = false;
        this.a.h = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
        if (!VcSystemInfo.h())
        {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, false);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = false;
        }
        this.a.a(true);
        if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
        {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
          if (this.a.g != 2) {
            this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.f();
          }
        }
        l1 = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().c != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SmallScreenVideoController", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
      return;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c).longValue();
      long l2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().e;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().b = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l2));
      localObject = new ArrayList();
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().b != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().b.length != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SmallScreenVideoController", 2, "onChangeUI_DobuleAudio2MultiAudio-->uinList is null");
    return;
    int i = 0;
    if (i < this.a.jdField_a_of_type_ComTencentAvVideoController.a().b.length)
    {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().b[i] == l1) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().b[i] == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long)) {}
      for (;;)
      {
        i += 1;
        break;
        ((ArrayList)localObject).add(Long.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().b[i]));
      }
    }
    if (((ArrayList)localObject).size() > 0)
    {
      i = ((ArrayList)localObject).size();
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().g.size() <= 0) {
        break label926;
      }
      i += this.a.jdField_a_of_type_ComTencentAvVideoController.a().g.size();
    }
    label926:
    for (;;)
    {
      l1 = ((Long)((ArrayList)localObject).get(0)).longValue();
      String str1 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, String.valueOf(l1), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().e));
      localObject = str1;
      if (str1.length() > 9) {
        localObject = str1.substring(0, 8) + "...";
      }
      if (i > 1) {
        new StringBuilder().append((String)localObject).append("等").append(i).append("人").toString();
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().O = false;
        this.a.i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().l;
        if (this.a.h != 4) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.h, false, false);
        return;
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenVideoController", 2, "onChangeUI_DobuleAudio2MultiAudio-->inviteList is null");
        }
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().g.size() > 0)
        {
          String str2 = ((AVPhoneUserInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().g.get(0)).telInfo.mobile;
          str1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(str2);
          localObject = str1;
          if (str1 == null) {
            localObject = PstnUtils.a(str2, 4);
          }
          i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().g.size();
          if (i > 1) {
            new StringBuilder().append((String)localObject).append("等").append(i).append("人").toString();
          }
        }
      }
    }
  }
  
  protected void d()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(0, 0, true);
    }
  }
  
  protected void e()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, false);
    }
  }
  
  protected void f() {}
  
  protected void g() {}
  
  protected void h()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(false);
    }
  }
  
  protected void i()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(true);
    }
  }
  
  protected void j() {}
  
  protected void k() {}
  
  protected void l()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.r)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.r = false;
      this.a.jdField_b_of_type_Boolean = true;
      this.a.c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */