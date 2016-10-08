import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.ModifyTroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class lvt
  implements TextWatcher
{
  int jdField_a_of_type_Int;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  public boolean a;
  int b;
  public boolean b;
  int c;
  
  public lvt(ModifyTroopMemberCardActivity paramModifyTroopMemberCardActivity, int paramInt, EditText paramEditText)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    Object localObject3 = paramEditable;
    Object localObject2 = paramEditable;
    for (;;)
    {
      try
      {
        if (paramEditable.getBytes("utf-8").length > this.jdField_a_of_type_Int)
        {
          localObject5 = "";
          str1 = "";
          localObject3 = "";
          localEditable = paramEditable;
          localObject1 = localObject3;
          localObject4 = str1;
          localObject2 = paramEditable;
        }
      }
      catch (UnsupportedEncodingException paramEditable)
      {
        Object localObject5;
        String str1;
        Editable localEditable;
        Object localObject1;
        Object localObject4;
        String str2;
        String str3;
        paramEditable.printStackTrace();
        localObject3 = localObject2;
        continue;
        this.jdField_b_of_type_Boolean = true;
        ModifyTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity, true);
        continue;
        if (this.jdField_a_of_type_AndroidWidgetEditText != this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.jdField_b_of_type_AndroidWidgetEditText) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.jdField_b_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.getString(2131367935), (String)localObject3);
        return;
        if (this.jdField_a_of_type_AndroidWidgetEditText != this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.jdField_c_of_type_AndroidWidgetEditText) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.jdField_c_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.jdField_c_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.getString(2131367936), (String)localObject3);
        return;
        if (this.jdField_a_of_type_AndroidWidgetEditText != this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.jdField_d_of_type_AndroidWidgetEditText) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.jdField_d_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.jdField_d_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.getString(2131367937), (String)localObject3);
      }
      try
      {
        str2 = paramEditable.substring(0, this.jdField_b_of_type_Int);
        localEditable = paramEditable;
        localObject1 = localObject3;
        localObject4 = str1;
        localObject5 = str2;
        localObject2 = paramEditable;
        str3 = paramEditable.substring(this.jdField_b_of_type_Int + this.c, paramEditable.length());
        localEditable = paramEditable;
        localObject1 = localObject3;
        localObject4 = str3;
        localObject5 = str2;
        localObject2 = paramEditable;
        str1 = paramEditable.substring(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int + this.c);
        localObject3 = paramEditable;
        localEditable = paramEditable;
        localObject1 = str1;
        localObject4 = str3;
        localObject5 = str2;
        localObject2 = paramEditable;
        if (str2.getBytes().length + str3.getBytes().length <= this.jdField_a_of_type_Int)
        {
          localObject3 = str1;
          localEditable = paramEditable;
          localObject1 = localObject3;
          localObject4 = str3;
          localObject5 = str2;
          localObject2 = paramEditable;
          if (paramEditable.getBytes().length > this.jdField_a_of_type_Int)
          {
            localEditable = paramEditable;
            localObject1 = localObject3;
            localObject4 = str3;
            localObject5 = str2;
            localObject2 = paramEditable;
            if (((String)localObject3).length() > 0)
            {
              localEditable = paramEditable;
              localObject1 = localObject3;
              localObject4 = str3;
              localObject5 = str2;
              localObject2 = paramEditable;
              localObject3 = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
              localEditable = paramEditable;
              localObject1 = localObject3;
              localObject4 = str3;
              localObject5 = str2;
              localObject2 = paramEditable;
              paramEditable = str2 + (String)localObject3 + str3;
              continue;
            }
          }
          localEditable = paramEditable;
          localObject1 = localObject3;
          localObject4 = str3;
          localObject5 = str2;
          localObject2 = paramEditable;
          this.jdField_a_of_type_AndroidWidgetEditText.setText(paramEditable);
          localEditable = paramEditable;
          localObject1 = localObject3;
          localObject4 = str3;
          localObject5 = str2;
          localObject2 = paramEditable;
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str2.length() + ((String)localObject3).length());
          localObject3 = paramEditable;
        }
      }
      catch (Throwable paramEditable)
      {
        localObject3 = localEditable;
        localObject2 = localEditable;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = localEditable;
        QLog.d("ModifyTroopMemberCardActivity", 2, "afterTextChanged, headStr:" + (String)localObject5 + ", tailStr = " + (String)localObject4 + ", insert = " + (String)localObject1, paramEditable);
        localObject3 = localEditable;
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidWidgetEditText != this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.jdField_a_of_type_AndroidWidgetEditText) {
        break label523;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqActivityModifyTroopMemberCardActivity.getString(2131367934), (String)localObject3);
    }
    label523:
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt3;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */