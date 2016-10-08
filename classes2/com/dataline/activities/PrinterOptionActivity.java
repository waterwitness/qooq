package com.dataline.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cg;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.MyCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo;

public class PrinterOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a = "sIsCloudPrinter";
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DataLineHandler jdField_a_of_type_ComTencentMobileqqAppDataLineHandler;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private MyCheckBox jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public PrinterOptionActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new cg(this);
  }
  
  static void a(FormSimpleItem paramFormSimpleItem, float paramFloat, Context paramContext)
  {
    paramFormSimpleItem.setBgType(0);
    paramFormSimpleItem.a().setTextColor(-16777216);
    paramFormSimpleItem.b().setTextColor(-16777216);
    if (paramFloat != 0.0F)
    {
      paramFormSimpleItem.a().setTextSize(paramFloat);
      paramFormSimpleItem.b().setTextSize(paramFloat);
    }
    paramFormSimpleItem.setBackgroundDrawable(paramContext.getResources().getDrawable(2130838047));
  }
  
  private void a(boolean paramBoolean)
  {
    startActivityForResult(new Intent(this, PrinterSubOptionActivity.class), 103);
  }
  
  private boolean a()
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.app.a(10);
    PrinterStatusHandler localPrinterStatusHandler = (PrinterStatusHandler)this.app.a(74);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return true;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362319);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
    }
    for (;;)
    {
      return false;
      if (localRegisterProxySvcPackHandler.a() == 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362316);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
      }
      else if (!localPrinterStatusHandler.a())
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362318);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
      }
      else if (!a(false))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362315);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
      }
      else
      {
        if (b()) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362317);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h = "";
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h);
      return false;
    }
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a != null) && (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.size() > 0)) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!((String)((Iterator)localObject).next()).equals(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h = null;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h == null) && (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.size() > 0))
      {
        localObject = (String)this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.get(0);
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h = ((String)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h = getString(2131362315);
      }
      for (paramBoolean = false;; paramBoolean = true)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h);
        return paramBoolean;
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h = null;
        break;
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    int j = 1;
    Iterator localIterator1;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label408;
      }
      localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator1.hasNext()) {
        if (((FileInfo)localIterator1.next()).b() == 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      label165:
      int k;
      label274:
      int m;
      if (i != 0)
      {
        this.c.setVisibility(8);
        return bool;
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.b != null))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a() == null) {
            break label396;
          }
          localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          j = 1;
          i = 1;
          bool = false;
          if (!localIterator1.hasNext()) {
            break label381;
          }
          String str = ((FileInfo)localIterator1.next()).e().toLowerCase();
          Iterator localIterator2 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.b.iterator();
          for (;;)
          {
            if (localIterator2.hasNext())
            {
              C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo localSupportFileInfo = (C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo)localIterator2.next();
              if (str.endsWith("." + localSupportFileInfo.str_file_suffix.get())) {
                if (localSupportFileInfo.uint32_copies.get() == 1)
                {
                  k = 1;
                  if (localSupportFileInfo.uint32_duplex.get() != 1) {
                    break label324;
                  }
                  m = 1;
                  label289:
                  m &= j;
                  j = i & k;
                  bool = true;
                  i = m;
                  label310:
                  if (bool) {
                    break label330;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        break;
        k = 0;
        break label274;
        label324:
        m = 0;
        break label289;
        label330:
        k = j;
        j = i;
        i = k;
        break label165;
        i = 0;
        j = 0;
        break;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return bool;
        k = i;
        i = j;
        j = k;
        break label310;
        label381:
        k = i;
        i = j;
        j = k;
        continue;
        label396:
        i = 1;
        j = 1;
        bool = false;
      }
      label408:
      i = 1;
    }
  }
  
  void a()
  {
    boolean bool = true;
    Object localObject = getString(2131362302) + this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (this.jdField_a_of_type_Int > 1) {}
    for (;;)
    {
      ((View)localObject).setEnabled(bool);
      return;
      bool = false;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 103) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h = paramIntent.getStringExtra("sPrinterName");
      a();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = ((DataLineHandler)this.app.a(8));
    this.jdField_a_of_type_JavaUtilArrayList = super.getIntent().getParcelableArrayListExtra("sFilesSelected");
    this.jdField_a_of_type_Boolean = super.getIntent().getBooleanExtra("sIsCloudPrinter", false);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("sIsCloudPrinter", false);
    super.getWindow().setBackgroundDrawableResource(2131427369);
    setContentView(2130903265);
    setTitle(2131362307);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131297924));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296449, "n/a");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131297925));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, 19.0F, this);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297898));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297124));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297926));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297927);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131297928);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.c = ((TextView)super.findViewById(2131297932));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131297929));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox = ((MyCheckBox)super.findViewById(2131297931));
    a(true);
    b();
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    LiteActivity.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
    a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem) {
      a(true);
    }
    do
    {
      do
      {
        return;
        if (paramView != this.jdField_a_of_type_AndroidWidgetButton) {
          break;
        }
      } while (!a());
      paramView = new Intent();
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("printCopies", this.jdField_a_of_type_Int);
          if (!this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.isChecked()) {
            continue;
          }
          localJSONObject.put("duplexMode", 2);
          localJSONObject.put("printerName", this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h);
          paramView.putExtra("sPrintParam", localJSONObject.toString());
          paramView.putParcelableArrayListExtra("sFilesSelected", this.jdField_a_of_type_JavaUtilArrayList);
          paramView.putExtra(AlbumConstants.i, super.getIntent().getIntExtra(AlbumConstants.i, 0));
        }
        catch (JSONException localJSONException)
        {
          JSONObject localJSONObject;
          continue;
        }
        setResult(-1, paramView);
        finish();
        ReportController.b(this.app, "CliOper", "", "", "0X800405A", "0X800405A", 0, 0, "", "", "", "");
        return;
        localJSONObject.put("duplexMode", 1);
      }
      if (paramView == this.jdField_a_of_type_AndroidViewView)
      {
        this.jdField_a_of_type_Int -= 1;
        this.jdField_a_of_type_Int = Math.max(1, this.jdField_a_of_type_Int);
        a();
        return;
      }
    } while (paramView != this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_Int += 1;
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\activities\PrinterOptionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */