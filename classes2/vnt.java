import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class vnt
  extends AsyncTask
{
  public vnt(VideoPlayLogic paramVideoPlayLogic, TroopInfoManager paramTroopInfoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b();
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.b))
    {
      if (TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_AndroidContentContext) == 0)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing() == true)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364741), 1).a();
        return;
      }
      if (TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_AndroidContentContext) != 2)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing() == true)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_AndroidContentContext.getString(2131364178), this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_AndroidContentContext.getString(2131364325), 2131367262, 2131364326, new vnu(this), new vnv(this)).show();
        return;
      }
      VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing() == true)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare != null)
    {
      new StructMsgForGeneralShare.GeneralClickHandler(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare).a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.b);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.b);
  }
  
  protected void onCancelled()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing() == true)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */