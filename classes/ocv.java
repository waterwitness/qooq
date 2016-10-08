import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

class ocv
  implements Runnable
{
  ocv(ocq paramocq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog != null) {
      this.a.a.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.dismiss();
    }
    this.a.a.i(true);
    TroopChatPie.d(this.a.a).postDelayed(new ocw(this), 100L);
    if (!AnonymousChatHelper.a(this.a.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      TroopChatPie.e(this.a.a).postDelayed(new ocx(this), 200L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ocv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */