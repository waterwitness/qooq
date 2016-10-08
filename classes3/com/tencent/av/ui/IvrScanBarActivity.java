package com.tencent.av.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.biz.widgets.ScannerView.ScannerListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import gup;
import mqq.app.BaseActivity;

public class IvrScanBarActivity
  extends BaseActivity
  implements ScannerView.ScannerListener
{
  public static final String a = "scanStr";
  public static final String b = "from_other";
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ScannerView jdField_a_of_type_ComTencentBizWidgetsScannerView;
  private boolean jdField_a_of_type_Boolean;
  
  public IvrScanBarActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.d();
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent(super.getIntent());
    localIntent.putExtra("scanStr", paramString);
    localIntent.putExtra("seq", this.jdField_a_of_type_Int);
    setResult(-1, localIntent);
    if (!this.jdField_a_of_type_Boolean) {
      ReportController.b(null, "CliOper", "", "", "0X800465C", "0X800465C", 0, 0, "", "", "", "");
    }
    super.finish();
  }
  
  public void b() {}
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("seq", -1);
    super.setContentView(2130903572);
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView = ((ScannerView)super.findViewById(2131299270));
    this.jdField_a_of_type_Boolean = super.getIntent().getBooleanExtra("from_other", false);
    if (this.jdField_a_of_type_Boolean) {}
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setScanListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131299278));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new gup(this));
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.c();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\IvrScanBarActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */