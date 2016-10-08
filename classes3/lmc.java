import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class lmc
  implements Runnable
{
  lmc(llz paramllz, CardHandler paramCardHandler, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_Llz.a, 230, "上传失败", "部分照片上传失败，是否重试上传？", new lmd(this), new lme(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lmc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */