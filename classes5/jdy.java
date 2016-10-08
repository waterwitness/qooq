import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jdy
  implements TextUtils.EllipsizeCallback
{
  public jdy(MoveFileActivity paramMoveFileActivity, TextView paramTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity));
      return;
    }
    String str1 = MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).substring(0, paramInt1);
    String str2 = MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).substring(paramInt2, MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).length());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str1 + "..." + str2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jdy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */