import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;
import cooperation.dingdong.DingdongJsApiPlugin;

public class yap
  implements ActionSheet.OnDismissListener
{
  public yap(DingdongJsApiPlugin paramDingdongJsApiPlugin, ActionSheet paramActionSheet, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    this.jdField_a_of_type_CooperationDingdongDingdongJsApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */