package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.MqqWeakReferenceHandler;

public class NearbyTroopsBaseView
  extends FrameLayout
{
  protected int a;
  protected View a;
  public NearbyTroopsBaseView.INearbyTroopContext a;
  protected boolean a;
  public boolean b;
  
  public NearbyTroopsBaseView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
  }
  
  protected void a() {}
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
    setBackgroundDrawable(null);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().overridePendingTransition(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  protected void a(Intent paramIntent) {}
  
  protected final void a(Intent paramIntent, int paramInt)
  {
    b(paramIntent, paramInt);
  }
  
  protected void a(Intent paramIntent, NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext = paramINearbyTroopContext;
  }
  
  protected final void a(String paramString)
  {
    if (!b()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(paramString);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void b()
  {
    this.b = true;
  }
  
  protected final void b(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  public void b(Intent paramIntent)
  {
    b(paramIntent, 0);
  }
  
  protected final void b(Intent paramIntent, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().startActivityForResult(paramIntent, paramInt);
  }
  
  protected final boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void c() {}
  
  protected void d() {}
  
  protected void e()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void f()
  {
    this.b = false;
  }
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void h() {}
  
  protected void i()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\NearbyTroopsBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */