package com.tencent.av.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gri;

public class ConfigInfoTips
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 6;
  private static final long jdField_a_of_type_Long = 2000L;
  public static final String a = "com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE";
  public static final String b = "com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD";
  public static final String c = "version";
  private static final String d = "com.tencent.av.ui.ConfigInfoTips";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private boolean jdField_a_of_type_Boolean;
  private long[] jdField_a_of_type_ArrayOfLong;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public ConfigInfoTips(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new gri(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ArrayOfLong = new long[6];
  }
  
  private void a(View paramView)
  {
    paramView = (Activity)this.jdField_a_of_type_AndroidContentContext;
    paramView.findViewById(2131299042).setVisibility(0);
    TextView localTextView1 = (TextView)paramView.findViewById(2131299043);
    TextView localTextView2 = (TextView)paramView.findViewById(2131299044);
    int n = ConfigInfo.instance().getSharpConfigVersionFromFile();
    String[] arrayOfString = ConfigInfo.instance().getSharpConfigPayloadFromFile().split("\n");
    paramView = new String();
    int i1 = arrayOfString.length;
    int k = 0;
    int i = 0;
    String str;
    int j;
    if (k < i1)
    {
      str = arrayOfString[k];
      j = str.length();
      if (j < 2) {
        break label282;
      }
    }
    label282:
    for (int m = str.charAt(j - 2);; m = 0)
    {
      j = i;
      if (m == 125) {
        j = i - 1;
      }
      i = 0;
      while (i < j)
      {
        paramView = paramView + "\t";
        i += 1;
      }
      paramView = paramView + str;
      paramView = paramView + "\n";
      i = j;
      if (m == 123) {
        i = j + 1;
      }
      k += 1;
      break;
      localTextView1.setText(String.valueOf(n) + "|" + TraeConfigUpdate.a().a("load"));
      localTextView2.setText(paramView);
      return;
    }
  }
  
  private void c() {}
  
  public void a()
  {
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    View localView = ((Activity)localObject).findViewById(2131299088);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
    localView = ((Activity)localObject).findViewById(2131299044);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
    localObject = ((Activity)localObject).findViewById(2131299042);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
    ((IntentFilter)localObject).addAction("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131299088: 
      do
      {
        return;
        System.arraycopy(this.jdField_a_of_type_ArrayOfLong, 1, this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_ArrayOfLong.length - 1);
        this.jdField_a_of_type_ArrayOfLong[(this.jdField_a_of_type_ArrayOfLong.length - 1)] = SystemClock.uptimeMillis();
      } while (this.jdField_a_of_type_ArrayOfLong[0] < SystemClock.uptimeMillis() - 2000L);
      a(paramView);
      return;
    }
    ((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131299042).setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\ConfigInfoTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */