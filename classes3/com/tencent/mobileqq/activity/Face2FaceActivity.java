package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.AddFriendScannerActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qlink.QQProxyForQlink;
import lin;

public class Face2FaceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String a = Face2FaceActivity.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    ((ImageView)findViewById(2131298229)).setOnClickListener(this);
    ((ImageView)findViewById(2131298230)).setOnClickListener(this);
    ((ImageView)findViewById(2131298231)).setOnClickListener(this);
    TextView localTextView = (TextView)findViewById(2131297139);
    localTextView.setText(getString(2131370432));
    localTextView.setContentDescription(getString(2131362055));
    localTextView = (TextView)findViewById(2131297083);
    localTextView.setVisibility(0);
    localTextView.setText(2131367975);
    localTextView.setContentDescription("返回，按钮");
    localTextView.setOnClickListener(new lin(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903353);
    setContentBackgroundResource(2130837958);
    a();
    return true;
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("fromFace2FaceActivity", true);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298229: 
      localIntent.setClass(this, AddFriendScannerActivity.class);
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "0X80049F1", "0X80049F1", 0, 0, "", "", "", "");
      return;
    case 2131298230: 
      localIntent.setClass(this, CreateFaceToFaceDiscussionActivity.class);
      startActivity(localIntent);
      overridePendingTransition(2130968590, 2130968591);
      ReportController.b(this.app, "CliOper", "", "", "0X80049F0", "0X80049F0", 0, 0, "", "", "", "");
      return;
    }
    QQProxyForQlink.a(this, 8, null);
    ReportController.b(this.app, "CliOper", "", "", "0X80049F2", "0X80049F2", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\Face2FaceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */