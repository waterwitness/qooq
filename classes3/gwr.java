import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.ui.MultiVideoEnterPageMembersControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gwr
  extends GAudioUIObserver
{
  public gwr(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  protected void a(long paramLong, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    super.a(paramLong, paramArrayList, paramInt1, paramInt2);
    if (paramArrayList == null) {
      if (!this.a.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoEnterPage", 2, "onUserListALLUpdate-->simpleData is null");
        }
        this.a.b();
        MultiVideoEnterPageActivity.b(this.a);
      }
    }
    label232:
    do
    {
      return;
      if ((paramInt1 == 2) || (paramInt1 == 10) || (paramInt1 == 12)) {}
      for (this.a.e = paramArrayList.size();; this.a.e = paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiVideoEnterPage", 2, "onUserListALLUpdate-->simpledata size=" + this.a.e);
        }
        if (this.a.e != 0) {
          break label337;
        }
        if (!this.a.jdField_a_of_type_Boolean) {
          break label290;
        }
        if ((this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI == null) || (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length != 2)) {
          break;
        }
        if (paramInt1 != 2) {
          break label232;
        }
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].c.setVisibility(0);
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].c.setText("当前无人视频");
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        return;
      }
    } while (paramInt1 != 10);
    this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].c.setVisibility(0);
    this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].c.setText("当前无人通话");
    this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    return;
    label290:
    if (QLog.isColorLevel()) {
      QLog.i("MultiVideoEnterPage", 2, "onUserListALLUpdate-->simple data size == 0,finishActivity");
    }
    this.a.b();
    if (this.a.jdField_a_of_type_ComTencentArrangeOpMeetingInfo == null)
    {
      MultiVideoEnterPageActivity.c(this.a);
      return;
    }
    this.a.e();
    return;
    label337:
    this.a.b.setVisibility(8);
    if ((paramInt1 == 10) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length > 1))
    {
      this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].setVisibility(0);
      this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].a(paramArrayList);
      if (this.a.jdField_a_of_type_Boolean)
      {
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].c.setVisibility(8);
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.a.b.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramArrayList);
      paramArrayList = "通话成员（" + this.a.e + "人）";
      this.a.d.setText(paramArrayList);
      this.a.c();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      return;
      if ((this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length > 0))
      {
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].setVisibility(0);
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].a(paramArrayList);
        if (this.a.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].c.setVisibility(8);
          this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (paramLong != this.a.jdField_a_of_type_Long);
      if (paramBoolean)
      {
        if (this.a.jdField_a_of_type_ComTencentArrangeOpMeetingInfo == null)
        {
          MultiVideoEnterPageActivity.a(this.a);
          return;
        }
        this.a.e = 0;
        this.a.e();
        return;
      }
    } while ((this.a.jdField_a_of_type_Boolean) || (!MultiVideoEnterPageActivity.a(this.a)));
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.c, this.a.jdField_a_of_type_Long, paramInt);
  }
  
  protected void d()
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      super.d();
      ArrayList localArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.c();
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(localArrayList);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */