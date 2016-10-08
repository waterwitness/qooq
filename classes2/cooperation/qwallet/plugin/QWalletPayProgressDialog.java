package cooperation.qwallet.plugin;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QWalletPayProgressDialog
  extends ProgressDialog
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString = "请稍候...";
  
  public QWalletPayProgressDialog(Context paramContext)
  {
    this(paramContext, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QWalletPayProgressDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      super.setContentView(2130903139);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        getWindow().addFlags(67108864);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297326));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      super.setCancelable(false);
      return;
    }
    catch (Exception paramBundle) {}catch (OutOfMemoryError paramBundle) {}
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      try
      {
        super.cancel();
        return false;
      }
      catch (Exception paramKeyEvent)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            paramKeyEvent.printStackTrace();
          }
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    super.setMessage(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (this.jdField_a_of_type_JavaLangString = "";; this.jdField_a_of_type_JavaLangString = paramCharSequence.toString())
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\QWalletPayProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */