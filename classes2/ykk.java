import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.activity.ShareDumpMemoryActivity;

public final class ykk
  implements View.OnClickListener
{
  public ykk(Dialog paramDialog, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    paramView = new Intent(BaseApplicationImpl.a(), ShareDumpMemoryActivity.class);
    paramView.addFlags(335544320);
    paramView.putExtra("dumpFilePath", this.jdField_a_of_type_JavaLangString);
    BaseApplicationImpl.a().startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */