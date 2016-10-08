import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.LOG;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class paf
  implements Runnable
{
  public paf(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidWidgetTextView.setText("按住录");
    if (this.jdField_a_of_type_Int == -3) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, "超时，请关闭重试", 0).a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == -2)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, "不支持机型，请关闭重试", 0).a();
        return;
      }
      if (this.jdField_a_of_type_Int < 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, "下载失败，请关闭重试", 0).a();
        return;
      }
    } while (this.jdField_a_of_type_Int < 100);
    if (this.jdField_a_of_type_Int == 200) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, "已经存在", 0).a();
    }
    for (;;)
    {
      boolean bool = PtvFilterSoLoad.b(BaseApplicationImpl.getContext());
      LOG.a("PTV.NewFlowCameraActivity", "BaseApplicationImpl.getContext() ^^^^^^^^^^^:" + BaseApplicationImpl.getContext() + "soExist:" + bool);
      if ((!NewFlowCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity)) && (bool))
      {
        NewFlowCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, PtvFilterSoLoad.a(BaseApplicationImpl.getContext()));
        if (NewFlowCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity)) {
          LOG.a("PTV.NewFlowCameraActivity", "mHasFilterSoLib ----->setupCameraUI(false) ^^^^^^^^^^^:");
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a.isEmpty()))) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
      ArrayList localArrayList = PtvTemplateManager.a(NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity)).a(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter = new PtvTemplateAdapter(NewFlowCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity), this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter);
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, "下载成功", 0).a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\paf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */