package cooperation.troop_homework.outer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import yud;

public class TroopHWRecordArrangeActivity
  extends TroopHWRecordBaseActivity
{
  private Handler a;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  
  public TroopHWRecordArrangeActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = 20;
    this.jdField_a_of_type_AndroidOsHandler = new yud(this);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)LayoutInflater.from(this).inflate(2130903645, null));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.app, this, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if (getIntent() != null) {
      this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("webid");
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\troop_homework\outer\TroopHWRecordArrangeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */