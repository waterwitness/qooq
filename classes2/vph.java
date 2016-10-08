import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopCommentBrowser;
import com.tencent.mobileqq.widget.QQToast;

public class vph
  implements TextView.OnEditorActionListener
{
  public vph(TroopCommentBrowser paramTroopCommentBrowser)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && ((paramInt == 4) || (paramInt == 6) || (paramInt == 1) || (paramInt == 0)))
    {
      paramInt = this.a.getResources().getDimensionPixelSize(2131492908);
      paramTextView = this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
      if (!TextUtils.isEmpty(paramTextView))
      {
        if (paramTextView.length() > 100)
        {
          QQToast.a(this.a.getActivity(), 2131365203, 0).b(paramInt);
          return true;
        }
        this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, 1, paramTextView, this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient$Callback);
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
        ((InputMethodManager)this.a.jdField_a_of_type_AndroidWidgetEditText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
        ReportController.b(this.a.app, "dc00899", "Grp_talk", "", "detail", "reply_suc", 0, 0, this.a.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */