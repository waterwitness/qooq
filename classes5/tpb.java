import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;

class tpb
  implements DialogInterface.OnClickListener
{
  tpb(tos paramtos, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    try
    {
      paramDialogInterface = this.jdField_a_of_type_Tos.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int);
      PicInfo localPicInfo1 = (PicInfo)this.jdField_a_of_type_Tos.a.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag();
      PicInfo localPicInfo2 = (PicInfo)paramDialogInterface.getTag();
      NearbyProfileEditPanel.a(this.jdField_a_of_type_Tos.a, (CustomImgView)paramDialogInterface, localPicInfo1, null);
      NearbyProfileEditPanel.a(this.jdField_a_of_type_Tos.a, this.jdField_a_of_type_Tos.a.jdField_a_of_type_ComTencentWidgetCustomImgView, localPicInfo2, null);
      if (QLog.isDevelopLevel()) {
        QLog.d("checkDialog", 4, "smallPicInfo:" + localPicInfo2 + ",bigPicInfo:" + localPicInfo1);
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */