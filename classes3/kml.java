import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XEditTextEx.SizeChangedCallback;
import mqq.os.MqqHandler;

public class kml
  implements XEditTextEx.SizeChangedCallback
{
  public kml(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext == null) || (this.a.jdField_a_of_type_MqqOsMqqHandler == null)) {
      return;
    }
    paramInt2 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493067);
    paramInt1 = 0;
    if (paramInt5 > paramInt3) {
      paramInt1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493068) + paramInt5 - paramInt3;
    }
    paramInt2 = Math.max(paramInt2, paramInt1);
    paramInt1 = paramInt2;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
    {
      paramInt1 = paramInt2;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getVisibility() == 0) {
        paramInt1 = paramInt2 + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight();
      }
    }
    if (this.a.x)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(54, paramInt1, paramInt4), 10L);
      return;
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(54, paramInt1, paramInt4));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */