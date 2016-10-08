import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qidian.QidianProfileCardActivity;

class wyx
  implements View.OnClickListener
{
  wyx(wyw paramwyw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ((ClipboardManager)this.a.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */