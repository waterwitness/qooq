import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class kyp
  extends TroopObserver
{
  public kyp(ChatSettingForHotChat paramChatSettingForHotChat)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatSettingForHotChat", 2, "onTroopManagerFailed  reqtype= " + paramInt + ",result=" + paramByte);
    }
    if (TextUtils.isEmpty(this.a.d)) {}
    while ((paramInt != 2) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) || (this.a.isFinishing())) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("退出热聊房间失败");
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838442);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new kys(this), 1500L);
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatSettingForHotChat", 2, "onTroopManagerSuccess  reqtype= " + paramInt + ",result=" + paramByte + ",troopUin=" + paramString);
    }
    if ((TextUtils.isEmpty(this.a.d)) || (!this.a.d.equals(paramString))) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt != 2);
        if (paramByte != 0) {
          break;
        }
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) || (this.a.isFinishing()));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("退出热聊房间成功");
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838452);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new kyq(this), 1500L);
      return;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) || (this.a.isFinishing()));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("退出热聊房间失败");
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838442);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new kyr(this), 1500L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kyp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */