import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.hiar.sdk.HSARToolkit;
import com.tencent.mobileqq.ar.ARFragment;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.model.ArResourceInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class qom
  extends Handler
{
  public qom(ARFragment paramARFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if ((ScanTorchActivity.a) || (ScanTorchActivity.b))
    {
      paramMessage = new StringBuilder();
      if (HSARToolkit.a().b())
      {
        paramMessage.append("RecogTime: " + HSARToolkit.a().d + "ms\n");
        paramMessage.append("TrackTime: " + HSARToolkit.a().e + "ms\n");
        paramMessage.append("RenderTime: " + HSARToolkit.a().f + "ms\n");
        paramMessage.append("TrackQuality: " + HSARToolkit.a().b + "\n");
        paramMessage.append("RenderQuality: " + HSARToolkit.a().jdField_a_of_type_Int + "\n");
        if (HSARToolkit.a().jdField_a_of_type_ComTencentMobileqqArARTarget == null) {
          break label336;
        }
        paramMessage.append("CurrentTarget: " + HSARToolkit.a().jdField_a_of_type_ComTencentMobileqqArARTarget.a.n + "\n");
      }
      for (;;)
      {
        ARFragment.a(this.a).setVisibility(0);
        ARFragment.a(this.a).setText(paramMessage.toString());
        return;
        paramMessage.append("[Lost]RecogTime: " + HSARToolkit.a().d + "ms\n");
        break;
        label336:
        paramMessage.append("CurrentTarget: null\n");
      }
    }
    ARFragment.a(this.a).setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */