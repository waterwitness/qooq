package com.dataline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import ch;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class PrinterSubOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public PrinterSubOptionActivity.PrinterItemAdapter a;
  public DataLineHandler a;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  public List a;
  public boolean a;
  
  public PrinterSubOptionActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new ch(this);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = ((DataLineHandler)this.app.a(8));
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList = null;
    getWindow().setBackgroundDrawableResource(2131427369);
    setContentView(2130903266);
    setTitle(2131362308);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter = new PrinterSubOptionActivity.PrinterItemAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297933));
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131296449, "n/a");
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    setLeftViewName(2131367975);
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131296449, "n/a");
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_JavaLangString = getString(2131362321);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList);
    }
    PrinterStatusHandler localPrinterStatusHandler = (PrinterStatusHandler)this.app.a(74);
    this.jdField_a_of_type_Boolean = localPrinterStatusHandler.a();
    localPrinterStatusHandler.a();
  }
  
  protected boolean onBackEvent()
  {
    setResult(-1, new Intent());
    finish();
    return true;
  }
  
  public void onClick(View paramView) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\activities\PrinterSubOptionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */