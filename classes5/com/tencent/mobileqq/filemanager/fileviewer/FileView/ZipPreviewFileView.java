package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.widgets.TriangleView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import shk;
import shm;

public class ZipPreviewFileView
  extends FileViewBase
{
  private static final int c = 13;
  private static final int jdField_d_of_type_Int = 14;
  private static final int jdField_e_of_type_Int = 15;
  public int a;
  public long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TriangleView jdField_a_of_type_ComTencentBizWidgetsTriangleView;
  public QQAppInterface a;
  TroopFileDetailBrowserActivity jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerTroopFileDetailBrowserActivity;
  public XListView a;
  public String a;
  public List a;
  boolean jdField_a_of_type_Boolean;
  public int b;
  public View b;
  public TextView b;
  public String b;
  public View c;
  public TextView c;
  public String c;
  View jdField_d_of_type_AndroidViewView;
  public TextView d;
  public String d;
  private View jdField_e_of_type_AndroidViewView;
  public String e;
  String f;
  
  public ZipPreviewFileView(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof TroopFileDetailBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerTroopFileDetailBrowserActivity = ((TroopFileDetailBrowserActivity)this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerTroopFileDetailBrowserActivity.i;
    }
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    try
    {
      paramByteStringMicro = paramByteStringMicro.toByteArray();
      if (paramByteStringMicro == null) {
        return "";
      }
    }
    catch (Exception paramByteStringMicro)
    {
      paramByteStringMicro.printStackTrace();
      return "";
    }
    char[] arrayOfChar = "0123456789ABCDEF".toCharArray();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramByteStringMicro.length)
    {
      int j = paramByteStringMicro[i];
      localStringBuffer.append(arrayOfChar[(j >>> 4 & 0xF)]);
      localStringBuffer.append(arrayOfChar[(j & 0xF)]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static final String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if ((i > 0) && (i < paramString.length() - 1)) {
      return paramString.substring(i + 1).toUpperCase();
    }
    return "";
  }
  
  private void f()
  {
    FileManagerEntity localFileManagerEntity;
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      this.e = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130904027, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.e.findViewById(2131297897));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.e.findViewById(2131301033));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.e.findViewById(2131299777));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.e.findViewById(2131301034));
      this.jdField_d_of_type_AndroidViewView = this.e.findViewById(2131301031);
      this.jdField_a_of_type_AndroidViewView = this.e.findViewById(2131301030);
      this.jdField_c_of_type_AndroidViewView = this.e.findViewById(2131301039);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView = this.e.findViewById(2131301036);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301038));
      this.jdField_a_of_type_ComTencentBizWidgetsTriangleView = ((TriangleView)this.e.findViewById(2131301035));
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      this.jdField_a_of_type_Long = localFileManagerEntity.nSessionId;
      this.f = localFileManagerEntity.peerUin;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("共" + this.jdField_a_of_type_JavaUtilList.size() + "项  " + FileUtil.a(localFileManagerEntity.fileSize));
      if ((!NetworkUtil.h(this.jdField_b_of_type_AndroidAppActivity)) || (localFileManagerEntity.strTroopFilePath == null)) {
        break label424;
      }
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.busId, new shk(this, localFileManagerEntity));
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localFileManagerEntity.busId, localFileManagerEntity.strTroopFilePath, new shm(this, localFileManagerEntity));
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label572;
      }
      this.e.setBackgroundResource(2130837958);
      this.jdField_a_of_type_ComTencentBizWidgetsTriangleView.setColor(this.jdField_b_of_type_AndroidAppActivity.getResources().getColor(2131427379));
      return;
      this.jdField_a_of_type_Boolean = false;
      break;
      label424:
      if (!NetworkUtil.h(this.jdField_b_of_type_AndroidAppActivity)) {
        QQToast.a(this.jdField_b_of_type_AndroidAppActivity, 1, this.jdField_b_of_type_AndroidAppActivity.getString(2131367256), 1).b(((IphoneTitleBarActivity)this.jdField_b_of_type_AndroidAppActivity).getTitleBarHeight());
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, "" + localFileManagerEntity.TroopUin, "" + this.jdField_b_of_type_Int, a(localFileManagerEntity.fileName), "1");
    }
    label572:
    this.e.setBackgroundColor(Color.parseColor("#ffffffff"));
    this.jdField_a_of_type_ComTencentBizWidgetsTriangleView.setColor(Color.parseColor("#ffffffff"));
    this.jdField_d_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#fff7f7f8"));
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    f();
    return this.e;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public boolean b()
  {
    return false;
  }
  
  public void c() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\ZipPreviewFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */