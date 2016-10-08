import android.app.Dialog;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class npu
  implements Runnable
{
  public npu(StructingMsgItemBuilder paramStructingMsgItemBuilder, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\npu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */