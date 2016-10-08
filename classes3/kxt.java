import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kxt
  implements DialogInterface.OnClickListener
{
  public kxt(ChatHistoryImageView paramChatHistoryImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    kxx localkxx = new kxx(this.a, this.a.jdField_a_of_type_JavaUtilArrayList, true, false);
    paramDialogInterface.jdField_a_of_type_Kxx = localkxx;
    ThreadManager.a(localkxx, 5, null, true);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */