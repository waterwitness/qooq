import android.text.TextPaint;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

public class nqy
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public nqy(TroopFileItemBuilder paramTroopFileItemBuilder, nrc paramnrc, RelativeLayout.LayoutParams paramLayoutParams, int paramInt, TextPaint paramTextPaint, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_Nrc.a.getLineCount();
    if (i != 0)
    {
      this.jdField_a_of_type_Nrc.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      if (i != 1) {
        break label74;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = ((int)(this.jdField_a_of_type_Int - this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString)));
      this.jdField_a_of_type_Nrc.a.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    }
    label74:
    while (i != 2) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = -2;
    this.jdField_a_of_type_Nrc.a.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */