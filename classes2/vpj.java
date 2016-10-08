import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopCommentBrowser;

class vpj
  implements TroopMemberApiClient.Callback
{
  vpj(vpi paramvpi, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle.getInt("errorCode") == 0)
    {
      paramBundle = this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130840203);
      paramBundle.setBounds(0, 0, this.jdField_a_of_type_Vpi.a.a, this.jdField_a_of_type_Vpi.a.a);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setCompoundDrawables(paramBundle, null, null, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */