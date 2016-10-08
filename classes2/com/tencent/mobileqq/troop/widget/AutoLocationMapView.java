package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.tencentmap.mapsdk.map.MapView;
import vse;
import vsf;

public class AutoLocationMapView
  extends MapView
{
  static final int a = 1;
  public Handler a;
  public AutoLocationMapView.AutoLocationCallback a;
  
  public AutoLocationMapView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new vse(this);
  }
  
  public AutoLocationMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new vse(this);
  }
  
  public void a(String paramString, AutoLocationMapView.AutoLocationCallback paramAutoLocationCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView$AutoLocationCallback = paramAutoLocationCallback;
    SosoInterface.a(new vsf(this, 0, true, true, 300000L, false, false, "AutoLocationMapView"));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\AutoLocationMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */