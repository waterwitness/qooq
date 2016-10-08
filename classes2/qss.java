import android.view.View;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class qss
  implements ActionSheet.OnButtonClickListener
{
  public qss(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.a.a.a(DynamicAvatarRecordActivity.a());
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */