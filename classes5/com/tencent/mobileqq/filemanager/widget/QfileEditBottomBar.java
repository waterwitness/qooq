package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import skc;

public class QfileEditBottomBar
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  Button jdField_a_of_type_AndroidWidgetButton;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51;
  final String jdField_a_of_type_JavaLangString = "QfileEditBottomBar";
  Button b;
  Button c;
  Button d;
  Button e;
  
  public QfileEditBottomBar(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QfileEditBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QfileEditBottomBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903984, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300914));
    this.b = ((Button)findViewById(2131300915));
    this.c = ((Button)findViewById(2131300917));
    this.d = ((Button)findViewById(2131300916));
    this.e = ((Button)findViewById(2131300918));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void c()
  {
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = FMDataCache.b();
    Object localObject2 = FMDataCache.c();
    Object localObject1 = FMDataCache.e();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject4;
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (FileInfo)((Iterator)localObject3).next();
        FileManagerEntity localFileManagerEntity = FileManagerUtil.a((FileInfo)localObject4);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.b(10000);
        localForwardFileInfo.d(localFileManagerEntity.getCloudType());
        localForwardFileInfo.b(localFileManagerEntity.nSessionId);
        localForwardFileInfo.d(localFileManagerEntity.fileName);
        localForwardFileInfo.c(localFileManagerEntity.uniseq);
        localForwardFileInfo.c(localFileManagerEntity.WeiYunFileId);
        localForwardFileInfo.d(localFileManagerEntity.fileSize);
        localForwardFileInfo.a(localFileManagerEntity.getFilePath());
        localForwardFileInfo.b(localFileManagerEntity.Uuid);
        localArrayList2.add(Uri.parse(((FileInfo)localObject4).d()));
        localArrayList1.add(localForwardFileInfo);
      }
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
        localObject4 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject4).b(10001);
        ((ForwardFileInfo)localObject4).d(((FileManagerEntity)localObject3).getCloudType());
        ((ForwardFileInfo)localObject4).b(((FileManagerEntity)localObject3).nSessionId);
        ((ForwardFileInfo)localObject4).d(((FileManagerEntity)localObject3).fileName);
        ((ForwardFileInfo)localObject4).c(((FileManagerEntity)localObject3).uniseq);
        ((ForwardFileInfo)localObject4).c(((FileManagerEntity)localObject3).WeiYunFileId);
        ((ForwardFileInfo)localObject4).d(((FileManagerEntity)localObject3).fileSize);
        ((ForwardFileInfo)localObject4).a(((FileManagerEntity)localObject3).getFilePath());
        ((ForwardFileInfo)localObject4).b(((FileManagerEntity)localObject3).Uuid);
        if ((((FileManagerEntity)localObject3).getCloudType() == 3) && (((FileManagerEntity)localObject3).getFilePath() != null) && (((FileManagerEntity)localObject3).getFilePath().length() > 0)) {
          localArrayList2.add(Uri.parse(((FileManagerEntity)localObject3).getFilePath()));
        }
        for (;;)
        {
          localArrayList1.add(localObject4);
          break;
          localArrayList2.add(Uri.parse(""));
        }
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localIntent.putExtra("k_dataline", false);
      localObject3 = ((List)localObject1).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (WeiYunFileInfo)((Iterator)localObject3).next();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((WeiYunFileInfo)localObject4).jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(((WeiYunFileInfo)localObject4).jdField_a_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = FileManagerUtil.a((WeiYunFileInfo)localObject4);
          }
        }
        localObject2 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject2).b(10003);
        ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).getCloudType());
        ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).nSessionId);
        ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileName);
        ((ForwardFileInfo)localObject2).c(((FileManagerEntity)localObject1).uniseq);
        ((ForwardFileInfo)localObject2).c(((FileManagerEntity)localObject1).WeiYunFileId);
        ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileSize);
        ((ForwardFileInfo)localObject2).a(((FileManagerEntity)localObject1).getFilePath());
        ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).Uuid);
        localArrayList1.add(localObject2);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((WeiYunFileInfo)localObject4).jdField_a_of_type_JavaLangString);
        if (localObject1 != null) {
          break label921;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(((WeiYunFileInfo)localObject4).jdField_a_of_type_JavaLangString);
      }
    }
    label921:
    for (;;)
    {
      if ((localObject1 != null) && (((FileManagerEntity)localObject1).getFilePath() != null) && (((FileManagerEntity)localObject1).getFilePath().length() > 0))
      {
        localArrayList2.add(Uri.parse(((FileManagerEntity)localObject1).getFilePath()));
        break;
      }
      localArrayList2.add(Uri.parse(""));
      break;
      localBundle.putInt("forward_type", 0);
      localBundle.putParcelableArrayList("fileinfo_array", localArrayList1);
      localBundle.putBoolean("not_forward", true);
      localIntent.putExtra("sendMultiple", true);
      localBundle.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("foward_editbar", true);
      localIntent.putExtra("forward_type", 0);
      localObject1 = "转发文件";
      if (localArrayList1.size() == 1) {
        localObject1 = "已选择" + FileManagerUtil.d(((ForwardFileInfo)localArrayList1.get(0)).d()) + "。";
      }
      for (;;)
      {
        localIntent.putExtra("forward_text", (String)localObject1);
        localIntent.putExtra("k_favorites", false);
        ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localIntent, 103);
        return;
        if (localArrayList1.size() > 1) {
          localObject1 = "已选择" + FileManagerUtil.d(((ForwardFileInfo)localArrayList1.get(0)).d()) + "等" + localArrayList1.size() + "个文件。";
        }
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if (FMDataCache.a() > 0L) {}
    int i;
    int j;
    int k;
    int m;
    FileManagerEntity localFileManagerEntity;
    for (boolean bool = true;; bool = false)
    {
      ((Button)localObject).setEnabled(bool);
      localObject = FMDataCache.c().iterator();
      i = 0;
      j = 0;
      k = 0;
      m = 0;
      if (((Iterator)localObject).hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        if ((localFileManagerEntity.getCloudType() != 3) && (localFileManagerEntity.getCloudType() != 5)) {
          break label324;
        }
        if (k == 0) {
          break;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QfileEditBottomBar", 4, "changeSelectCount nLocal[" + m + "] WeiYun [" + FileManagerUtil.a(localFileManagerEntity) + "]");
        }
      }
      label132:
      if (FMDataCache.a() != m) {
        break label534;
      }
      i = 1;
      label144:
      if (FMDataCache.a() != k) {
        break label539;
      }
      k = 1;
      label157:
      if (FMDataCache.a() != j) {
        break label545;
      }
      j = 1;
      label170:
      localObject = this.b;
      if (i != 0) {
        break label551;
      }
      bool = true;
      label182:
      ((Button)localObject).setEnabled(bool);
      localObject = this.c;
      if (k != 0) {
        break label557;
      }
      bool = true;
      label201:
      ((Button)localObject).setEnabled(bool);
      localObject = this.d;
      if (j != 0) {
        break label563;
      }
      bool = true;
      label220:
      ((Button)localObject).setEnabled(bool);
      if (FMDataCache.a() <= 0L) {
        break label569;
      }
      this.e.setTextColor(getResources().getColor(2131428330));
      this.e.setEnabled(true);
      return;
    }
    int i2 = m + 1;
    int i1 = k;
    int n = j;
    label280:
    if ((localFileManagerEntity.getCloudType() == 3) && (localFileManagerEntity.getFilePath() != null) && (localFileManagerEntity.getFilePath().length() > 0)) {
      i += 1;
    }
    for (;;)
    {
      j = n;
      k = i1;
      m = i2;
      break;
      label324:
      if (localFileManagerEntity.getCloudType() == 2)
      {
        if (m != 0)
        {
          if (!QLog.isDevelopLevel()) {
            break label132;
          }
          QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + k + "], Local[" + FileManagerUtil.a(localFileManagerEntity) + "]");
          break label132;
        }
        i1 = k + 1;
        n = j;
        i2 = m;
        break label280;
      }
      n = j;
      i1 = k;
      i2 = m;
      if (localFileManagerEntity.getCloudType() != 6) {
        break label280;
      }
      n = j;
      i1 = k;
      i2 = m;
      if (FileUtil.b(localFileManagerEntity.getFilePath())) {
        break label280;
      }
      if ((m != 0) || (k != 0))
      {
        if (!QLog.isDevelopLevel()) {
          break label132;
        }
        QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + k + "], Local[" + FileManagerUtil.a(localFileManagerEntity) + "]");
        break label132;
      }
      n = j + 1;
      i1 = k;
      i2 = m;
      break label280;
      label534:
      i = 0;
      break label144;
      label539:
      k = 0;
      break label157;
      label545:
      j = 0;
      break label170;
      label551:
      bool = false;
      break label182;
      label557:
      bool = false;
      break label201;
      label563:
      bool = false;
      break label220;
      label569:
      this.e.setTextColor(-5855578);
      this.e.setEnabled(false);
      return;
    }
  }
  
  void a(View paramView)
  {
    new ArrayList();
    int i = 0;
    if (this.jdField_a_of_type_Int == 1) {
      i = 1;
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
    paramView.a(2131362929, 3);
    if (this.jdField_a_of_type_Int != 3)
    {
      if (i == 0) {
        break label84;
      }
      paramView.a(" 删除本地文件后将无法找回，是否继续？");
    }
    for (;;)
    {
      paramView.d(2131367262);
      paramView.a(new skc(this, paramView));
      paramView.show();
      return;
      label84:
      paramView.a("删除文件记录及云端记录");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
        } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 == null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.b();
        return;
        if (QLog.isColorLevel()) {
          QLog.i("QfileEditBottomBar", 2, "downLoadAllSelectFiles,weiyun[" + FMDataCache.e().size() + "], offline[" + FMDataCache.d().size() + "], recent[" + FMDataCache.c().size() + "], localfile[" + FMDataCache.b().size() + "]");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g();
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.c();
        }
        FMDataCache.b();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.e(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.d();
        }
        FMDataCache.b();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.e(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
      } while (paramView.size() <= 0);
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.get(0);
      if (paramView.size() > 1)
      {
        FMToastUtil.b(FileManagerUtil.d(localFileManagerEntity.fileName) + "等" + paramView.size() + "个文件" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362814));
        return;
      }
      FMToastUtil.b(FileManagerUtil.d(localFileManagerEntity.fileName) + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362814));
      return;
      c();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.e();
      }
      FMDataCache.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.e(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
      return;
      a(paramView);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.f();
  }
  
  public void setClickListener(IClickListener_Ver51 paramIClickListener_Ver51)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = paramIClickListener_Ver51;
  }
  
  public void setEditBtnVisible(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    int j = 0;
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (paramBoolean1)
    {
      i = 0;
      localButton.setVisibility(i);
      localButton = this.b;
      if (!paramBoolean2) {
        break label114;
      }
      i = 0;
      label36:
      localButton.setVisibility(i);
      localButton = this.c;
      if (!paramBoolean3) {
        break label121;
      }
      i = 0;
      label56:
      localButton.setVisibility(i);
      localButton = this.d;
      if (!paramBoolean4) {
        break label128;
      }
      i = 0;
      label77:
      localButton.setVisibility(i);
      localButton = this.e;
      if (!paramBoolean5) {
        break label135;
      }
    }
    label114:
    label121:
    label128:
    label135:
    for (int i = j;; i = 8)
    {
      localButton.setVisibility(i);
      return;
      i = 8;
      break;
      i = 8;
      break label36;
      i = 8;
      break label56;
      i = 8;
      break label77;
    }
  }
  
  public void setTabType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\widget\QfileEditBottomBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */