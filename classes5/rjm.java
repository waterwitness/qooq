import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.emoticon.SogouEmojiTaskController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rjm
  implements DialogInterface.OnDismissListener
{
  public rjm(SogouEmojiTaskController paramSogouEmojiTaskController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmojiTaskController.jdField_a_of_type_JavaLangString, 2, "func onDismiss begins, mCurTaskId:" + this.a.jdField_a_of_type_Int);
    }
    this.a.a(this.a.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmojiTaskController.jdField_a_of_type_JavaLangString, 2, "func onDismiss ends");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */