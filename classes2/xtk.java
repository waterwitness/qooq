import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.HongBaoPendantHolder;
import com.tencent.widget.HongBaoListView;

public class xtk
  implements Handler.Callback
{
  public xtk(HongBaoListView paramHongBaoListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      this.a.setIsShowingPreguide(true);
      this.a.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(this.a.j / 3, 300L);
      this.a.d(-this.a.j);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 600L);
      this.a.invalidate();
      return false;
      this.a.a(300L);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 300L);
      return false;
      this.a.setIsShowingPreguide(true);
      i = this.a.j / 2;
      if (paramMessage.arg1 != 0) {
        i = paramMessage.arg1;
      }
      this.a.d(-i);
      this.a.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(this.a.j / 3, 300L);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 600L);
      return false;
      this.a.a(300L);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 300L);
      return false;
      this.a.setIsShowingPreguide(false);
      return false;
      if (!this.a.m()) {
        this.a.setStackFromBottom(true);
      }
      this.a.setStackFromBottom(false);
    } while (this.a.d);
    int i = (int)this.a.getResources().getDimension(2131493760);
    this.a.d(-i);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xtk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */