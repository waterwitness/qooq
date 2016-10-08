package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import gtk;
import gtl;
import gtn;
import java.util.ArrayList;
import java.util.Iterator;

public class EffectToolbar
  extends BaseToolbar
{
  BroadcastReceiver a;
  public QAVPtvTemplateAdapter a;
  public HorizontalListView a;
  
  public EffectToolbar()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_Int = 2130903618;
  }
  
  private boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    IntentFilter localIntentFilter;
    BaseApplication localBaseApplication;
    do
    {
      return true;
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.video.q2v.debug");
      localBaseApplication = paramVideoAppInterface.a();
      paramVideoAppInterface = new gtn(this, paramVideoAppInterface);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = paramVideoAppInterface;
    } while (localBaseApplication.registerReceiver(paramVideoAppInterface, localIntentFilter) != null);
    return false;
  }
  
  private void c(VideoAppInterface paramVideoAppInterface)
  {
    PtvTemplateManager.a(paramVideoAppInterface).a(new gtl(this, paramVideoAppInterface));
  }
  
  private void d(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      paramVideoAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  public int a(VideoAppInterface paramVideoAppInterface, ArrayList paramArrayList)
  {
    int k = 0;
    paramVideoAppInterface = paramVideoAppInterface.a().a().z;
    int i;
    if (!StringUtil.b(paramVideoAppInterface))
    {
      paramArrayList = paramArrayList.iterator();
      i = 0;
      if (paramArrayList.hasNext()) {
        if (!((PtvTemplateManager.PtvTemplateInfo)paramArrayList.next()).id.equals(paramVideoAppInterface)) {}
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(i);
      int j = k;
      if (i > 0)
      {
        j = k;
        if (i > 5.5F)
        {
          j = this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.c;
          j = this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.b * (i - 1) + j;
        }
      }
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a_(j);
      return i;
      i += 1;
      break;
      i = 1;
    }
  }
  
  public ArrayList a(VideoAppInterface paramVideoAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
    localPtvTemplateInfo.id = "-1";
    localArrayList.add(localPtvTemplateInfo);
    localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
    localPtvTemplateInfo.id = "0";
    localPtvTemplateInfo.iconurl = String.valueOf(2130839226);
    localArrayList.add(localPtvTemplateInfo);
    paramVideoAppInterface = PtvTemplateManager.a(paramVideoAppInterface).a();
    if ((paramVideoAppInterface != null) && (!paramVideoAppInterface.isEmpty()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EffectSettingUi", 4, String.format("双人挂件, size[%s]", new Object[] { Integer.valueOf(paramVideoAppInterface.size()) }));
      }
      localArrayList.addAll(paramVideoAppInterface);
    }
    return localArrayList;
  }
  
  protected void a(Context paramContext, QAVPtvTemplateAdapter.IEffectCallback paramIEffectCallback)
  {
    PtvTemplateManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (!PtvTemplateManager.a()) {
      PtvTemplateManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299470));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    ArrayList localArrayList = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter = new QAVPtvTemplateAdapter(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramContext, localArrayList, this.jdField_a_of_type_ComTencentWidgetHorizontalListView);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.b(true);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(paramIEffectCallback);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(new gtk(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter);
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localArrayList);
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  protected void b(VideoAppInterface paramVideoAppInterface)
  {
    d(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = null;
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\EffectToolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */