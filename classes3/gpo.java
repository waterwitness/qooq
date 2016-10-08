import android.content.res.Resources;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcControllerImpl.DeviceCMDTLV;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.funchat.magicface.MagicfaceManagerForAV;
import com.tencent.av.funchat.magicface.MagicfaceViewControllerForAV;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ChildGuideUi;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.FaceToolbar;
import com.tencent.av.ui.HYControlUI;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;

public class gpo
  extends ControlUIObserver
{
  public gpo(AVActivity paramAVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
    if ((i == 1) || (i == 3)) {}
    while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().c()) || ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.a())) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h(0);
  }
  
  protected void a(int paramInt)
  {
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
    if ((i == 1) || (i == 3)) {}
    while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().c()) || ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.a())) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)) {
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi == null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) && (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof HYControlUI))) {
      this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi = new ChildGuideUi(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.a, this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI, (RelativeLayout)AVActivity.a(this.a, 2131298955));
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.c()))
    {
      this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.e();
      ReportController.b(null, "CliOper", "", "", "0X80061F6", "0X80061F6", 0, 0, "", "", "", "");
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(paramInt);
  }
  
  protected void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, " onChangeUI_receiveTransferMsg ");
    }
    if ((this.a.j == 9500) && ((paramObject instanceof VcControllerImpl.DeviceCMDTLV)))
    {
      paramObject = (VcControllerImpl.DeviceCMDTLV)paramObject;
      if (((VcControllerImpl.DeviceCMDTLV)paramObject).jdField_a_of_type_Int != 6) {
        break label349;
      }
      if ((((VcControllerImpl.DeviceCMDTLV)paramObject).b & 0x1) != 1) {
        break label295;
      }
      if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.s = true;
        ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(27, true, 2130839063);
      }
    }
    label294:
    label295:
    label349:
    do
    {
      do
      {
        do
        {
          break label294;
          for (;;)
          {
            if (((((VcControllerImpl.DeviceCMDTLV)paramObject).b & 0x4) == 4) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
            {
              this.a.jdField_a_of_type_ComTencentAvVideoController.t = true;
              ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).ah();
            }
            if (((((VcControllerImpl.DeviceCMDTLV)paramObject).b & 0x8) == 8) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
            {
              this.a.jdField_a_of_type_ComTencentAvVideoController.u = false;
              DoubleVideoCtrlUI localDoubleVideoCtrlUI = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
              this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gpr(this, localDoubleVideoCtrlUI), 500L);
            }
            if (((((VcControllerImpl.DeviceCMDTLV)paramObject).b & 0x2) == 2) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
            {
              paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
              this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean = false;
              this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gps(this, (DoubleVideoCtrlUI)paramObject), 500L);
            }
            return;
            if (((((VcControllerImpl.DeviceCMDTLV)paramObject).b & 0x1) == 0) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
            {
              this.a.jdField_a_of_type_ComTencentAvVideoController.s = false;
              ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(27, false, 2130839063);
            }
          }
        } while (((VcControllerImpl.DeviceCMDTLV)paramObject).jdField_a_of_type_Int != 5);
        if (((VcControllerImpl.DeviceCMDTLV)paramObject).b != 2) {
          break;
        }
      } while (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI));
      paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
      ((DoubleVideoCtrlUI)paramObject).a(2131363723, 2, 0, ((DoubleVideoCtrlUI)paramObject).a.getDimensionPixelSize(2131492908));
      return;
    } while ((((VcControllerImpl.DeviceCMDTLV)paramObject).b != 3) || (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)));
    paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    ((DoubleVideoCtrlUI)paramObject).a(2131363724, 1, 0, ((DoubleVideoCtrlUI)paramObject).a.getDimensionPixelSize(2131492908));
  }
  
  protected void a(String paramString)
  {
    int i = 1;
    if ((paramString != null) && (paramString.equals("SUPPORT_TRUE"))) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().M = true;
    }
    for (;;)
    {
      if (i != 0) {
        if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
          this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.e();
        }
      }
      while (!FaceToolbar.a(this.a.jdField_a_of_type_ComTencentAvVideoController))
      {
        return;
        if ((paramString == null) || (!paramString.equals("SUPPORT_FALSE"))) {
          break label114;
        }
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().M = false;
        break;
      }
      MagicfaceManagerForAV.a().a(paramString, new gpt(this, paramString));
      return;
      label114:
      i = 0;
    }
  }
  
  protected void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString1, paramInt1, paramString2, paramInt2);
    }
  }
  
  protected void a(ArrayList paramArrayList)
  {
    if ((this.a.jdField_g_of_type_Int == 2) || (this.a.jdField_g_of_type_Int == 0) || (this.a.jdField_g_of_type_Int == 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "onChangeUI_ShowVideo ignore ");
      }
      return;
    }
    Object localObject;
    int k;
    int j;
    VideoViewInfo localVideoViewInfo;
    String str2;
    int m;
    boolean bool2;
    boolean bool3;
    int i;
    label212:
    String str1;
    boolean bool1;
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      k = this.a.jdField_a_of_type_ComTencentAvVideoController.i();
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "onChangeUI_ShowVideo-->infos=" + (String)localObject);
      }
      Collections.sort(paramArrayList, new gpp(this));
      j = 0;
      if (j < paramArrayList.size())
      {
        localVideoViewInfo = (VideoViewInfo)paramArrayList.get(j);
        str2 = CharacterUtil.a(localVideoViewInfo.jdField_a_of_type_Long);
        m = localVideoViewInfo.jdField_a_of_type_Int;
        bool2 = localVideoViewInfo.jdField_a_of_type_Boolean;
        bool3 = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m);
        i = -1;
        if (this.a.j == 3000)
        {
          i = 1004;
          str1 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str2, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().e));
          if (!localVideoViewInfo.jdField_b_of_type_Boolean) {
            break label996;
          }
          if (str2.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
            break label684;
          }
          localObject = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (localVideoViewInfo.jdField_b_of_type_Long != 5L) {
            break label632;
          }
          bool1 = true;
          label293:
          ((VideoLayerUI)localObject).a(str2, m, true, bool2, bool1);
          if ((!bool2) || (localVideoViewInfo.d)) {
            break label996;
          }
          if (CharacterUtil.a(str1) <= 20) {
            break label990;
          }
          localObject = CharacterUtil.a(str1, 0, 20) + "...";
          label357:
          if (m != 2) {
            break label638;
          }
          localObject = String.format(this.a.getString(2131363459), new Object[] { localObject });
          TipsManager.a(106, (String)localObject);
          this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106, (String)localObject, true);
          label406:
          i = 0;
        }
      }
    }
    for (;;)
    {
      label409:
      if (i == 0)
      {
        if ((localVideoViewInfo.jdField_b_of_type_Boolean) || (localVideoViewInfo.jdField_a_of_type_Boolean)) {
          break label824;
        }
        if (k == 4) {
          break label790;
        }
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) {
          break label714;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
        label479:
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, this.a.b, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        if ((!bool3) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().z))
        {
          float f = 10.0F;
          if (bool2) {
            f = 14.0F;
          }
          f = UITools.a(this.a.getApplicationContext(), f);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, str1, f, -1);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m);
        }
        j += 1;
        break;
        if (this.a.j == 1)
        {
          i = 1000;
          break label212;
        }
        if (this.a.j != 0) {
          break label212;
        }
        i = 0;
        break label212;
        label632:
        bool1 = false;
        break label293;
        label638:
        localObject = String.format(this.a.getString(2131363458), new Object[] { localObject });
        TipsManager.a(103, (String)localObject);
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103, (String)localObject, true);
        break label406;
        label684:
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, bool2);
        i = 1;
        break label409;
        label714:
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)
        {
          ReportController.b(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
          break label479;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
        break label479;
        label790:
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, this.a.c, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        continue;
        label824:
        if (!localVideoViewInfo.jdField_a_of_type_Boolean) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, this.a.c, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        } else {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        }
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.p, false);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(this.a.p);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.a.p);
      return;
      label990:
      localObject = str1;
      break label357;
      label996:
      i = 0;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.jdField_g_of_type_Int == 2) {}
    do
    {
      do
      {
        return;
        if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
          this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
        }
      } while (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, paramBoolean);
    } while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().z));
    String str1 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    int i;
    if (this.a.j == 3000) {
      i = 1004;
    }
    for (;;)
    {
      String str2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str1, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().e));
      float f = 10.0F;
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str1, 1)) {
        f = 14.0F;
      }
      f = UITools.a(this.a.getApplicationContext(), f);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, 1, str2, f, -1);
      if (!paramBoolean) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, 1, this.a.jdField_a_of_type_AndroidGraphicsBitmap, true, true);
      return;
      if (this.a.j == 1) {
        i = 1000;
      } else {
        i = -1;
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      if ((!paramBoolean1) && (!paramBoolean2)) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.s(true);
      }
      if ((paramBoolean1) && (paramBoolean2)) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.s(false);
      }
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)
    {
      if ((!paramBoolean1) && (paramBoolean2)) {
        this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.d();
      }
      if ((paramBoolean1) && (!paramBoolean2)) {
        this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.c();
      }
    }
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
      this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.d();
    }
  }
  
  protected void b(int paramInt)
  {
    AVActivity.a(this.a, true, paramInt);
  }
  
  protected void b(ArrayList paramArrayList)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
    {
      Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "onChangeUI_CloseVideo-->infos=" + (String)localObject);
      }
      Collections.sort(paramArrayList, new gpq(this));
      int i = 0;
      if (i < paramArrayList.size())
      {
        localObject = (VideoViewInfo)paramArrayList.get(i);
        String str = CharacterUtil.a(((VideoViewInfo)localObject).jdField_a_of_type_Long);
        boolean bool2 = ((VideoViewInfo)localObject).jdField_a_of_type_Boolean;
        int j = ((VideoViewInfo)localObject).jdField_a_of_type_Int;
        VideoLayerUI localVideoLayerUI;
        if (!str.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))
        {
          if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str, j)) && (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null))
          {
            TipsManager.c(103);
            this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103);
          }
          localVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (((VideoViewInfo)localObject).jdField_b_of_type_Long != 5L) {
            break label218;
          }
        }
        label218:
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
      QLog.d("AVActivity", 2, "onChangeUI_DobuleAudio2MultiAudio isBackground_Stop:" + this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
      this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.d();
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    long l1;
    Object localObject1;
    do
    {
      do
      {
        return;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().k == 11)
        {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(null);
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, false, false, false);
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
        }
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
        this.a.jdField_g_of_type_Boolean = false;
        this.a.h = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
        if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
          this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.k();
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) {
          this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.f();
        }
        if (!VcSystemInfo.h())
        {
          this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(true);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, false);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = false;
        }
        this.a.a();
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f();
          if (this.a.jdField_g_of_type_Int != 2) {
            this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g();
          }
        }
        l1 = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().c != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("AVActivity", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
      return;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c).longValue();
      long l2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().e;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().b = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l2));
      localObject1 = new ArrayList();
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().b != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().b.length != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AVActivity", 2, "onChangeUI_DobuleAudio2MultiAudio-->uinList is null");
    return;
    int i = 0;
    if (i < this.a.jdField_a_of_type_ComTencentAvVideoController.a().b.length)
    {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().b[i] == l1) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().b[i] == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long)) {}
      for (;;)
      {
        i += 1;
        break;
        ((ArrayList)localObject1).add(Long.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().b[i]));
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      i = ((ArrayList)localObject1).size();
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.size() <= 0) {
        break label1106;
      }
      i += this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.size();
    }
    label1106:
    for (;;)
    {
      l1 = ((Long)((ArrayList)localObject1).get(0)).longValue();
      Object localObject2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, String.valueOf(l1), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().e));
      localObject1 = localObject2;
      if (((String)localObject2).length() > 9) {
        localObject1 = ((String)localObject2).substring(0, 8) + "...";
      }
      localObject2 = localObject1;
      if (i > 1) {
        localObject2 = (String)localObject1 + "等" + i + "人";
      }
      localObject1 = String.format(this.a.getString(2131363619), new Object[] { localObject2 });
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c((String)localObject1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().O = false;
        this.a.j = this.a.jdField_a_of_type_ComTencentAvVideoController.a().l;
        if (this.a.h != 4) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.h, false, false);
        return;
        if (QLog.isColorLevel()) {
          QLog.e("AVActivity", 2, "onChangeUI_DobuleAudio2MultiAudio-->inviteList is null");
        }
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.size() > 0)
        {
          String str = ((AVPhoneUserInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.get(0)).telInfo.mobile;
          localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(str);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = PstnUtils.a(str, 4);
          }
          i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.size();
          localObject2 = localObject1;
          if (i > 1) {
            localObject2 = (String)localObject1 + "等" + i + "人";
          }
          localObject1 = String.format(this.a.getString(2131363619), new Object[] { localObject2 });
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
            this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c((String)localObject1);
          }
        }
      }
    }
  }
  
  protected void c(int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 1)) {
      this.a.h = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
    }
    this.a.a(true, paramInt);
  }
  
  protected void d()
  {
    boolean bool = false;
    if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
      this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.c();
    }
    int j;
    int i;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
        break label158;
      }
      j = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b();
      i = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
    }
    for (;;)
    {
      VideoLayerUI localVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      if (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m) {
        bool = true;
      }
      localVideoLayerUI.a(j, i, bool);
      if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int) || (this.a.jdField_g_of_type_Boolean)) && (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.s)) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
      }
      return;
      label158:
      i = 0;
      j = 0;
    }
  }
  
  protected void e()
  {
    if ((!this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().ag) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(true);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if ((!this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d()) && (this.a.q > 0)) {
        MagicfaceViewControllerForAV.a().b(0);
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, false);
      if (!this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c()) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = false;
      }
    }
    if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(true);
    }
  }
  
  protected void f()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {}
  }
  
  protected void g()
  {
    if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.e();
    }
  }
  
  protected void h()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(false);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.q(false);
    }
  }
  
  protected void i()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(true);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.q(true);
    }
  }
  
  protected void j()
  {
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d_(true);
    }
  }
  
  protected void k()
  {
    AVActivity.a(this.a, true);
  }
  
  protected void l()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.r)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.r = false;
      this.a.e = true;
      this.a.finish();
    }
  }
  
  protected void m()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.ag();
    }
  }
  
  protected void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onChangeUI_SmallView_Position_change");
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int) || (this.a.jdField_g_of_type_Boolean))) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */