import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class msh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public msh(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    TextView localTextView = (TextView)this.a.e.findViewById(2131305190);
    int i = localTextView.getLineCount();
    if (i == 0) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "lines = " + i + ", maxLines = " + 3 + ", remark = " + localTextView.getText().toString());
        }
        if (i > 3) {
          break;
        }
        localTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        this.a.d.setVisibility(0);
      } while (!this.a.jdField_b_of_type_Boolean);
      this.a.jdField_b_of_type_Boolean = false;
    } while (this.a.C.length() <= 4);
    String str = this.a.C.substring(0, this.a.C.length() - 3) + "...";
    this.a.a(str, localTextView);
    return;
    this.a.d.setVisibility(4);
    str = this.a.C.substring(0, this.a.C.length() - 1);
    this.a.a(str, localTextView);
    this.a.jdField_b_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */