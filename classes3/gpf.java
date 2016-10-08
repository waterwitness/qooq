import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gpf
  implements View.OnClickListener
{
  public gpf(AVActivity paramAVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().w) {}
    for (;;)
    {
      return;
      int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().f;
      if ((i == 1) || (i == 2))
      {
        if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().g()) {
          this.a.a(this.a.c, this.a.j, this.a.k);
        }
      }
      else {
        while (AVActivity.a(this.a) != null)
        {
          AVActivity.a(this.a).a();
          return;
          if ((i == 3) || (i == 4))
          {
            paramView = this.a.jdField_a_of_type_ComTencentAvVideoController.a().s;
            String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.j, paramView, null);
            if (QLog.isColorLevel()) {
              QLog.d("AVActivity", 2, "enterChatWin-->uin: " + paramView + ", uintype: " + this.a.j + ", name: " + str);
            }
            this.a.a(paramView, this.a.j, str);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */