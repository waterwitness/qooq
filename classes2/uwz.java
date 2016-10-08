import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;

public class uwz
  implements Runnable
{
  public uwz(StructMsgItemVideo paramStructMsgItemVideo, Context paramContext, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = CGILoader.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.n, StructMsgItemVideo.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo));
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.obtainMessage().obj = this.jdField_a_of_type_AndroidViewView;
    if (!TextUtils.isEmpty(str))
    {
      StructMsgItemVideo.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo, this.jdField_a_of_type_AndroidContentContext, str);
      return;
    }
    StructMsgItemVideo.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo, this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uwz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */