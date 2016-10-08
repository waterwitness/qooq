import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.view.EmoWindow.NickClickSpanIntf;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pek
  extends ClickableSpan
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private EmoWindow.NickClickSpanIntf jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewEmoWindow$NickClickSpanIntf;
  private String jdField_a_of_type_JavaLangString;
  
  public pek(Context paramContext, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -16776961;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(EmoWindow.NickClickSpanIntf paramNickClickSpanIntf)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewEmoWindow$NickClickSpanIntf = paramNickClickSpanIntf;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewEmoWindow$NickClickSpanIntf != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewEmoWindow$NickClickSpanIntf.a(this.jdField_a_of_type_JavaLangString, 0);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */