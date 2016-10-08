import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.IArConfigListener;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.widget.QQToast;

public class tru
  implements IArConfigListener
{
  public tru(ScanTorchActivity paramScanTorchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    QQToast.a(this.a, 0, "下载成功！", 0).a();
    this.a.d.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    ScanTorchActivity.b(this.a);
    ScanTorchActivity.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    this.a.e.setVisibility(0);
    this.a.b.setVisibility(8);
    this.a.f.setVisibility(8);
    QQToast.a(this.a, 0, "下载失败！请稍后重试", 0).a();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    int i = (int)(100L * paramLong1 / paramLong2);
    if (this.a.b.getVisibility() != 0) {
      this.a.b.setVisibility(0);
    }
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
    this.a.g.setText(this.a.getResources().getString(2131372602));
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    ScanTorchActivity.a(this.a, paramArConfigInfo);
    if ((ScanTorchActivity.a(this.a) != null) && (ScanTorchActivity.a(this.a) != null)) {
      ScanTorchActivity.a(this.a);
    }
  }
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    ScanTorchActivity.a(this.a, paramArEffectConfig);
    ARDeviceController.a().a(paramArEffectConfig);
    if ((ScanTorchActivity.a(this.a) != null) && (ScanTorchActivity.a(this.a) != null)) {
      ScanTorchActivity.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */