import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public class rkf
  implements AdapterView.OnItemClickListener
{
  public rkf(EmoticonMainPanel paramEmoticonMainPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramLong = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_EmoticonPanel_TabClick");
    if (this.a.jdField_a_of_type_JavaUtilList == null)
    {
      break label21;
      break label21;
    }
    label21:
    while (paramInt >= this.a.jdField_a_of_type_JavaUtilList.size()) {
      return;
    }
    EmoticonMainPanel.a(this.a).setSelection(paramInt);
    boolean bool;
    label96:
    Object localObject;
    String str1;
    String str2;
    if ((this.a.jdField_a_of_type_JavaUtilList.size() > EmoticonMainPanel.l) && (((EmotionPanelInfo)this.a.jdField_a_of_type_JavaUtilList.get(EmoticonMainPanel.l)).jdField_a_of_type_Int == 8))
    {
      bool = true;
      EmoticonMainPanel.b = bool;
      localObject = (EmotionPanelInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramAdapterView = "";
      str1 = "";
      str2 = "";
      if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int != 8) {
        break label316;
      }
      paramAdapterView = "0X8005798";
      paramView = (ImageView)paramView.findViewById(2131298191);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).commit();
      paramView = "已选定推荐面板";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramAdapterView)) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", paramAdapterView, 0, 0, str1, "", str2, "");
      }
      if (EmoticonMainPanel.k == paramInt) {
        break;
      }
      EmoticonMainPanel.k = paramInt;
      EmoticonMainPanel.a(this.a, paramInt, true);
      if (AppSetting.j) {
        QQAppInterface.f(paramView);
      }
      StartupTracker.a("AIO_EmoticonPanel_TabClick", null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonMainPanel", 2, "[Performance] TabsChanged duration:" + (System.currentTimeMillis() - paramLong));
      return;
      bool = false;
      break label96;
      label316:
      if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 9)
      {
        paramAdapterView = "0X8005797";
        paramView = "已选定魔法表情面板";
      }
      else
      {
        if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 4)
        {
          paramAdapterView = "0X8005799";
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break;
          }
          paramView = this.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
          localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
          bool = paramView.getBoolean("local_overflow" + (String)localObject, false);
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "isDelOverflow=" + bool);
          }
          if (!bool) {
            ThreadManager.a(new rkg(this, paramView, (String)localObject), 5, null, false);
          }
          for (;;)
          {
            paramView = "已选定收藏表情面板";
            break;
            EmoticonMainPanel.a(this.a, true);
          }
        }
        if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 7)
        {
          paramAdapterView = "0X800579A";
          paramView = "已选定经典表情面板";
        }
        else
        {
          if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 6)
          {
            localObject = ((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
            if (localObject != null)
            {
              str1 = ((EmoticonPackage)localObject).epId;
              if (((EmoticonPackage)localObject).status == 2) {}
              for (paramAdapterView = "0X800584E";; paramAdapterView = "0X80059B8")
              {
                str2 = Integer.toString(this.a.a(str1));
                paramView = "已选定" + ((EmoticonPackage)localObject).name + "面板";
                if (((EmoticonPackage)localObject).status == 2) {
                  break label627;
                }
                paramView = paramView + ",未下载";
                break;
              }
              label627:
              continue;
            }
          }
          paramView = "";
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */