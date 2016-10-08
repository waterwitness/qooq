import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet.OnDismissListener;
import cooperation.qzone.RDMEtraMsgCollector;

public class pan
  implements ActionSheet.OnDismissListener
{
  public pan(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity]").append(getClass().getSimpleName()).append(" QQCustomDialog click :").append("取消");
    RDMEtraMsgCollector.a().c(localStringBuilder.toString());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */