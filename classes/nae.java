import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.widget.ClearableEditText;
import mqq.observer.ServerNotifyObserver;

public class nae
  extends ServerNotifyObserver
{
  public nae(VerifyCodeActivity paramVerifyCodeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceiveVerifyCode(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    this.a.b = false;
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
      Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131367308), 0).show();
    }
    this.a.jdField_a_of_type_MqqObserverServerNotifyObserver.setKey(paramString1);
    this.a.jdField_a_of_type_MqqObserverServerNotifyObserver.setSeq(paramInt);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString().length() > 4)) {
      VerifyCodeActivity.a(this.a, true);
    }
    if (paramArrayOfByte != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapManager.a(paramArrayOfByte, 0, paramArrayOfByte.length));
      this.a.a(false);
      return;
    }
    Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131367309), 1).show();
  }
  
  public void onVerifyClose()
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */