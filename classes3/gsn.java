import android.widget.ImageButton;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gsn
  extends GAudioUIObserver
{
  public gsn(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onGaOperationResult-->Result=" + paramInt1 + " ,uin=" + paramLong1 + " ,info=" + paramLong2);
    }
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("DoubleVideoMeetingCtrlUI", 2, "onGaOperationResult-->Error:result = " + paramInt1 + " ,uin = " + paramLong1 + " ,info = " + paramLong2);
      }
    case 93: 
    case 94: 
    case 95: 
    case 97: 
    case 98: 
    case 96: 
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("DoubleVideoMeetingCtrlUI", 2, "Request View Suc.info = " + paramLong2 + " ,uin = " + paramLong1);
          }
          if (paramLong2 != 1L) {
            break;
          }
        } while (this.a.jdField_a_of_type_ComTencentAvVideoController.a().an);
        this.a.g("OnGaOprationResult->REQUEST_VIDEO_SUC");
        this.a.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList);
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().g = true;
        return;
      } while (!QLog.isColorLevel());
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "Request view failed.info = " + paramLong2);
      return;
    case 90: 
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoMeetingCtrlUI", 2, "go on stage suc,camera num = " + this.a.w);
      }
      if (paramLong2 == 3L) {
        if (this.a.w > 1)
        {
          this.a.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
          label360:
          if ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().f) || (this.a.c))
          {
            this.a.c = false;
            this.a.v();
            paramInt1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(this.a.jdField_b_of_type_Long, 1);
            if (paramInt1 == -1) {
              break label562;
            }
          }
        }
      }
      break;
    }
    label562:
    for (boolean bool = ((VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).a;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(bool) });
      DoubleVideoMeetingCtrlUI.c(this.a);
      return;
      this.a.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
      break label360;
      if ((paramLong2 == 2L) || (paramLong2 != 4L)) {
        break;
      }
      return;
      this.a.f(true);
      this.a.y();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
      return;
    }
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onCreateRoomSuc-->relationId = " + paramLong);
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onDestroyInviteUI-->GroupId = " + paramLong);
    }
    if (paramLong == this.a.jdField_a_of_type_Long)
    {
      super.c(paramLong);
      this.a.g(true);
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onMemberVideoIn-->RelationId=" + paramLong1 + " ,friendUin=" + paramLong2);
    }
    this.a.a(paramLong1, paramLong2, 1);
  }
  
  protected void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onMemberVideoOut-->RelationId=" + paramLong1 + " ,friendUin=" + paramLong2);
    }
    this.a.a(paramLong1, paramLong2, 2);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onMemberLeave-->RelationId = " + paramLong1 + " ,friendUin = " + paramLong2);
    }
    this.a.a(paramLong1, paramLong2, 6);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onMemberJoin-->RelationId = " + paramLong1 + " ,friendUin = " + paramLong2 + " ,isRefresh = " + paramBoolean1 + " ,isQQUser = " + paramBoolean2);
    }
    this.a.a(paramLong1, paramLong2, 5);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "EnterRoomSuc-->GroupId = " + paramLong);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().A = true;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(3, 0, true, true, this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
    }
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onGaMemberShareSrcInOrOut-->RelationId=" + paramLong1 + " ,friendUin=" + paramLong2 + " ,bIn=" + paramBoolean1 + " ,isPPt=" + paramBoolean2);
    }
    if (paramBoolean1) {
      this.a.a(paramLong1, paramLong2, 3);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_Boolean = paramBoolean2;
      return;
      this.a.a(paramLong1, paramLong2, 4);
    }
  }
  
  protected void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onDestory UI-->relationId = " + paramLong);
    }
    if (this.a.jdField_a_of_type_Long == paramLong) {
      this.a.g(true);
    }
  }
  
  protected void c(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onFirstFrameDataComeIn-->uin = " + paramLong + " ,videosrctype = " + paramInt);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, paramInt);
    if ((paramInt != -1) && (((VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt)).a))
    {
      TipsManager.c(106);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
      TipsManager.c(103);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103);
    }
    DoubleVideoMeetingCtrlUI.d(this.a);
    this.a.h("OnFirstFrameDataComeIn");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gsn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */