package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortController;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.DropListener;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import lia;
import lib;
import lic;
import lid;
import lie;
import lif;
import lig;
import lih;
import lii;
import lij;
import lim;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class EmosmActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 1;
  static final String jdField_a_of_type_JavaLangString = "EmosmActivity";
  public static final int b = 2;
  public static final String b = "extra_launch_source";
  public static final int c = 1;
  public static final String c = "extra_launch_mode";
  public static final int d = 2;
  public static final int g = 0;
  public static final int h = 1;
  public Button a;
  public TextView a;
  EmoticonObserver jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver;
  public DragSortAdapter a;
  DragSortListView.DropListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener;
  DragSortListView.RemoveListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener;
  public DragSortListView a;
  EmoticonPackageChangedListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener;
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener;
  EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  public QQProgressDialog a;
  TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener;
  TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  public Runnable a;
  public WeakReference a;
  public ArrayList a;
  public boolean a;
  TextView b;
  public boolean b;
  public boolean c;
  public int e;
  public int f;
  
  public EmosmActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver = new lia(this);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener = new lim(this);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener = new lib(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new lic(this);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.b(true);
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getCount())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getItem(i);
        if (!localEmoticonPackage.epId.equals(paramInt + "")) {
          break label154;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(localEmoticonPackage);
        String str = localEmoticonPackage.epId;
        if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
          ThreadManager.a().post(new lid(this, str));
        }
        if (3 == localEmoticonPackage.jobType) {
          ReportController.b(this.app, "CliOper", "", "", "MbGuanli", "MbDianjiShanchu", 0, 0, "", "", "", "");
        }
      }
      return;
      label154:
      i += 1;
    }
  }
  
  private void c()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130838420);
    localQQToast.c(1500);
    localQQToast.a("鉴权错误，删除失败");
    localQQToast.b(0);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if ((this.f == 2) && (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getCount() == 0)) {
      ReportController.b(this.app, "CliOper", "", "", "0X80060AA", "0X80060AA", 0, 0, "", "", "", "");
    }
  }
  
  private void e()
  {
    String str = super.getIntent().getStringExtra("options");
    try
    {
      if (TextUtils.isEmpty(str))
      {
        this.leftView.setText(2131370445);
        return;
      }
      str = new JSONObject(str).optString("leftText", getString(2131370445));
      this.leftView.setText(str);
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmosmActivity", 2, localJSONException.getMessage());
      }
    }
  }
  
  public DragSortController a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new DragSortController(paramDragSortListView);
    paramDragSortListView.d(2131296306);
    paramDragSortListView.f(2131296307);
    paramDragSortListView.b(true);
    paramDragSortListView.a(true);
    paramDragSortListView.a(0);
    paramDragSortListView.b(0);
    paramDragSortListView.c(2);
    return paramDragSortListView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a();
    }
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      EmoticonPackage localEmoticonPackage;
      if (this.f == 1)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
          if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
      if (this.f == 2)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
          if ((3 == localEmoticonPackage.jobType) || (5 == localEmoticonPackage.jobType)) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    int j = 0;
    Object localObject2;
    int k;
    int i;
    if (this.c)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a();
      k = ((List)localObject2).size();
      i = 0;
      if (i >= k) {
        break label437;
      }
      if (((EmoticonPackage)((List)localObject2).get(i)).jobType != 3) {}
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1;
      Object localObject3;
      if (1 == this.f)
      {
        if (i == -1)
        {
          localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject1).hasNext()) {
            localArrayList.add(((EmoticonPackage)((Iterator)localObject1).next()).epId);
          }
          i += 1;
          break;
        }
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (EmoticonPackage)((Iterator)localObject2).next();
          if (((EmoticonPackage)localObject3).jobType == 3) {
            ((ArrayList)localObject1).add(((EmoticonPackage)localObject3).epId);
          }
        }
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList.add(((EmoticonPackage)((Iterator)localObject2).next()).epId);
          }
          localArrayList.addAll((Collection)localObject1);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b(localArrayList);
        localObject1 = (EmoticonHandler)this.app.a(12);
        if (localObject1 != null) {
          ((EmoticonHandler)localObject1).a(localArrayList, true);
        }
        return;
        k = this.jdField_a_of_type_JavaUtilArrayList.size();
        while (j < k)
        {
          localObject2 = (EmoticonPackage)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          if (j == i) {
            localArrayList.addAll((Collection)localObject1);
          }
          localArrayList.add(((EmoticonPackage)localObject2).epId);
          j += 1;
        }
        continue;
        if (2 == this.f)
        {
          k = ((List)localObject2).size();
          j = 0;
          while (j < k)
          {
            localObject1 = (EmoticonPackage)((List)localObject2).get(j);
            if (j == i)
            {
              localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject3).hasNext()) {
                localArrayList.add(((EmoticonPackage)((Iterator)localObject3).next()).epId);
              }
            }
            if (((EmoticonPackage)localObject1).jobType != 3) {
              localArrayList.add(((EmoticonPackage)localObject1).epId);
            }
            j += 1;
          }
        }
      }
      label437:
      i = -1;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130903351);
    super.setContentBackgroundResource(2130837958);
    super.setTitle(2131370269);
    e();
    this.jdField_a_of_type_AndroidWidgetTextView = this.rightViewText;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131370271);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new lie(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298217));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298219));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new lif(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)super.findViewById(2131298218));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131370445));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131370446));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)super.findViewById(16908298));
      paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDelImmediately(false);
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.app.getManager(13));
      paramBundle = super.getIntent();
      this.f = paramBundle.getIntExtra("extra_launch_mode", 1);
      this.jdField_a_of_type_JavaLangRunnable = new lig(this);
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter = new DragSortAdapter(this, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new lih(this));
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener = new lii(this);
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new lij(this);
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      this.e = paramBundle.getIntExtra("extra_launch_source", 2);
      if ((this.e == 2) || (this.e == 1))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131370271);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(false);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
      ReportController.b(this.app, "CliOper", "", "", "ep_mall", "View_mine", 0, 0, "", "", "", "");
      bool = true;
    }
    catch (OutOfMemoryError paramBundle)
    {
      do
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = null;
      } while (!QLog.isColorLevel());
      QLog.e("EmosmActivity", 2, paramBundle.getMessage());
    }
    return bool;
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onPause");
    }
    super.doOnPause();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
  }
  
  protected void doOnResume()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onResume");
    }
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    ((EmoticonHandler)this.app.a(12)).a(0, 0);
    super.doOnResume();
  }
  
  public void finish()
  {
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.b();
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (!NetworkUtil.e(this))
      {
        paramView = new QQToast(this);
        paramView.a(2130838420);
        paramView.c(1500);
        paramView.a("无网络连接，删除失败");
        paramView.b(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131370293));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a();
    } while (((List)localObject).size() <= 0);
    URLDrawable.clearMemoryCache();
    paramView = (EmoticonHandler)this.app.a(12);
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Integer.valueOf(Integer.parseInt(((EmoticonPackage)((Iterator)localObject).next()).epId)));
    }
    paramView.a(localArrayList);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "delete packages:" + localArrayList.toString());
    }
    ReportController.b(this.app, "CliOper", "", "", "EmosSetting", "EpDelete", 0, 0, "", "", "", "");
  }
  
  protected void onRestart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "emosm activity ..............onRestart");
    }
    super.onRestart();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\EmosmActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */