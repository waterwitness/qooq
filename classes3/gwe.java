import android.content.res.Resources;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiMembersVideoUI;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.av.utils.EllipsisUtil;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gwe
  extends GAudioUIObserver
{
  public gwe(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2)
  {
    super.a(paramInt1, paramLong1, paramLong2, paramLong3, paramInt2);
    label281:
    label298:
    VideoViewInfo localVideoViewInfo;
    switch (paramInt1)
    {
    default: 
    case 96: 
    case 97: 
    case 98: 
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MultiVideoCtrlLayerUIBase", 2, "request video success,Info = " + paramLong2);
          }
          if (paramLong2 == 1L)
          {
            this.a.f("onGaOperationResult");
            this.a.W();
            this.a.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "onGaOperationResult --> EV_GA_SDK_REQUEST_VIDEO_SUC Failed. Info = " + paramLong2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MultiVideoCtrlLayerUIBase", 2, "request video failed");
        }
      } while (paramLong2 != 1L);
      this.a.b(this.a.jdField_c_of_type_Long, paramInt1, false, -1);
      return;
    case 90: 
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "go on stage success CameraNum=" + this.a.w);
      }
      if (paramLong2 == 3L) {
        if (this.a.w > 1)
        {
          this.a.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
          ArrayList localArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
          paramInt1 = 0;
          if (paramInt1 >= localArrayList.size()) {
            break label629;
          }
          localVideoViewInfo = (VideoViewInfo)localArrayList.get(paramInt1);
          if (paramLong1 != localVideoViewInfo.jdField_a_of_type_Long) {
            break label403;
          }
        }
      }
      break;
    }
    label403:
    label629:
    for (boolean bool = localVideoViewInfo.jdField_a_of_type_Boolean;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(105), Boolean.valueOf(bool) });
      this.a.ag();
      this.a.W();
      this.a.c(true);
      return;
      this.a.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
      break label281;
      paramInt1 += 1;
      break label298;
      this.a.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
      this.a.q(2131299023);
      this.a.z();
      if (paramLong2 == 2L)
      {
        this.a.g(53);
        return;
      }
      if (paramLong2 != 4L) {
        break;
      }
      this.a.g(54);
      if (this.a.d != 2) {
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004CFD", "0X8004CFD", 0, 0, "", "", "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "go on stage failed");
      }
      this.a.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
      this.a.q(2131299023);
      this.a.z();
      if (paramLong2 == 7L) {
        this.a.g(55);
      }
      while (this.a.d == 2)
      {
        ReportController.b(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
        return;
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(47, true);
      }
      this.a.z();
      return;
    }
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super.a(paramLong, paramInt1, paramInt2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramLong, paramInt1, paramInt2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a(paramLong, paramInt1, paramInt2, paramBoolean);
    if (paramLong == this.a.jdField_c_of_type_Long) {
      this.a.H();
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.a.b(paramLong2, 5, false, 72);
  }
  
  protected void a(long paramLong1, long paramLong2, int paramInt)
  {
    super.a(paramLong1, paramLong2, paramInt);
    if (paramLong2 == this.a.jdField_c_of_type_Long) {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoCtrlLayerUIBase", 2, "onMemberVideoOut-->Server Go off Stage ,must close local video");
        }
        this.a.T();
      }
    }
    for (;;)
    {
      this.a.b(paramLong2, 6, false, 73);
      return;
      VideoViewInfo localVideoViewInfo = new VideoViewInfo();
      localVideoViewInfo.jdField_a_of_type_Long = paramLong2;
      localVideoViewInfo.jdField_a_of_type_Int = paramInt;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localVideoViewInfo);
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localArrayList });
      if (paramInt == 2)
      {
        TipsManager.c(106);
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
      }
    }
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramBoolean);
    if (this.a.jdField_b_of_type_Long != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "onMemberJoin,wrong group uin.GroupUin = " + paramLong1 + " , RelationId = " + this.a.jdField_b_of_type_Long + " , isQQUser = " + paramBoolean);
      }
      return;
    }
    this.a.jdField_c_of_type_Boolean = paramBoolean;
    super.a(paramLong1, paramLong2, paramBoolean);
    this.a.b(paramLong2, 1, true, 71);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (this.a.jdField_b_of_type_Long != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "onMemberJoin , wrong group uin. GroupUin = " + paramLong1 + " , mRelationId = " + this.a.jdField_b_of_type_Long + " , isQQUser = " + paramBoolean2);
      }
      return;
    }
    this.a.jdField_c_of_type_Boolean = paramBoolean2;
    this.a.b(paramLong2, 0, paramBoolean1, 70);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2);
    if (paramBoolean1) {}
    for (int i = 42;; i = 43)
    {
      this.a.b(paramLong, 2, paramBoolean2, i);
      return;
    }
  }
  
  protected void a(ArrayList paramArrayList, int paramInt)
  {
    if (paramInt == 0)
    {
      TipsManager.c(104);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(104);
      if (this.a.f != null)
      {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.f);
        this.a.f = null;
      }
      return;
    }
    if ((paramInt == 1) && (((Long)paramArrayList.get(0)).longValue() == this.a.jdField_c_of_type_Long))
    {
      this.a.k.setText("自我静音");
      TipsManager.a(104, "你的环境有些嘈杂，为免影响他人，不发言时请静音。");
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(104, "你的环境有些嘈杂，为免影响他人，不发言时请静音。", false);
      return;
    }
    Object localObject;
    long l;
    if (this.a.f == null)
    {
      this.a.f = new gwk(this.a);
      localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      Runnable localRunnable = this.a.f;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.d < 2000L)
      {
        l = 2000L;
        ((Handler)localObject).postDelayed(localRunnable, l);
      }
    }
    else
    {
      paramArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramArrayList.get(0)), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().e), this.a.d);
      float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493966);
      localObject = new StringBuilder();
      EllipsisUtil.b((StringBuilder)localObject, paramArrayList, this.a.j.getPaint(), f);
      if (paramInt != 1) {
        break label362;
      }
      ((StringBuilder)localObject).append("的环境有些嘈杂。");
      this.a.k.setText("将TA静音");
    }
    for (;;)
    {
      paramArrayList = ((StringBuilder)localObject).toString();
      TipsManager.a(104, paramArrayList);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(104, paramArrayList, false);
      return;
      l = this.a.jdField_a_of_type_ComTencentAvVideoController.d;
      break;
      label362:
      ((StringBuilder)localObject).append("等").append(paramInt);
      ((StringBuilder)localObject).append("人的环境有些嘈杂。");
      this.a.k.setText("设置他们的麦克风静音");
    }
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    int i;
    int j;
    if (paramBoolean1)
    {
      i = 7;
      j = 78;
    }
    for (;;)
    {
      this.a.b(paramLong2, i, false, j);
      return;
      i = 8;
      j = 79;
      TipsManager.c(106);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
    }
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    super.b(paramLong, paramBoolean);
    this.a.H();
    if ((paramLong == 0L) || (paramLong == this.a.jdField_c_of_type_Long)) {
      return;
    }
    Object localObject2;
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().e), this.a.d);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {}
      }
      else
      {
        localObject1 = String.valueOf(paramLong);
      }
      float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493966);
      localObject2 = new StringBuilder();
      EllipsisUtil.b((StringBuilder)localObject2, (String)localObject1, this.a.j.getPaint(), f);
      if (!paramBoolean) {
        break label206;
      }
    }
    label206:
    for (Object localObject1 = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363647);; localObject1 = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363648))
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(69, ((StringBuilder)localObject2).toString(), 5000L, 0);
      this.a.k(paramBoolean);
      return;
    }
  }
  
  protected void c()
  {
    super.c();
    if ((this.a.g != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.a.g);
    }
  }
  
  protected void c(long paramLong)
  {
    super.c(paramLong);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().e == paramLong) {
      this.a.i(true);
    }
  }
  
  protected void c(long paramLong, int paramInt)
  {
    super.c(paramLong, paramInt);
    paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, paramInt);
    if ((paramInt != -1) && (((VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(paramInt)).jdField_a_of_type_Boolean))
    {
      TipsManager.c(106);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
      TipsManager.c(103);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103);
    }
    this.a.ag();
    this.a.g("onFirstFrameDataComeIn");
  }
  
  protected void c(long paramLong, boolean paramBoolean)
  {
    super.c(paramLong, paramBoolean);
    this.a.H();
    if (paramLong == this.a.jdField_c_of_type_Long) {
      return;
    }
    Object localObject2;
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().e), this.a.d);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {}
      }
      else
      {
        localObject1 = String.valueOf(paramLong);
      }
      float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493966);
      localObject2 = new StringBuilder();
      EllipsisUtil.b((StringBuilder)localObject2, (String)localObject1, this.a.j.getPaint(), f);
      if (!paramBoolean) {
        break label200;
      }
    }
    label200:
    for (Object localObject1 = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363645);; localObject1 = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363646))
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(69, ((StringBuilder)localObject2).toString(), 5000L, 0);
      this.a.k(paramBoolean);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */