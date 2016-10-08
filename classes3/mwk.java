import android.content.Intent;
import com.tencent.mobileqq.activity.TroopPrivateSettingActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;

public class mwk
  extends TroopObserver
{
  public mwk(TroopPrivateSettingActivity paramTroopPrivateSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, byte paramByte)
  {
    if ((paramInt == 2) || (paramInt == 9))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131369498, 1500);
      this.a.finish();
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if ((paramInt == 2) || (paramInt == 9))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
      }
      if (paramByte == 0)
      {
        paramString = new Intent();
        paramString.putExtra("isNeedFinish", true);
        this.a.setResult(-1, paramString);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(5, 2131369497, 1500);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131369498, 1500);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.a.b == null) || (!this.a.b.equals(paramString))) {}
    while (paramBoolean) {
      return;
    }
    QQToast.a(this.a, this.a.getString(2131364854), 0).b(this.a.getTitleBarHeight());
    TroopPrivateSettingActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mwk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */