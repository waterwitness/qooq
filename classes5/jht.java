import android.view.View;
import com.tencent.biz.webviewplugin.PubAccountMailJsPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class jht
  implements ActionSheet.OnButtonClickListener
{
  public jht(PubAccountMailJsPlugin paramPubAccountMailJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d(PubAccountMailJsPlugin.jdField_a_of_type_JavaLangString, 2, String.format("Unknow button %d", new Object[] { Integer.valueOf(paramInt) }));
      }
      return;
    case 0: 
      PubAccountMailJsPlugin.a(this.a);
      return;
    case 1: 
      PubAccountMailJsPlugin.b(this.a);
      return;
    case 2: 
      PubAccountMailJsPlugin.c(this.a);
      return;
    }
    PubAccountMailJsPlugin.d(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */