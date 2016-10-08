package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vhp;
import vhs;
import vht;
import vhu;

public class TroopBarPublishBarSelectActivity
  extends IphoneTitleBarActivity
  implements HttpWebCgiAsyncTask.Callback, AdapterView.OnItemClickListener
{
  protected static final int a = 1001;
  public static final String a = "key_selected_item";
  public static final String b = "key_media_data";
  public static final String c = "key_drop_media_data";
  public long a;
  protected Drawable a;
  public Handler a;
  protected View a;
  protected TextView a;
  public TroopBarPublishBarSelectActivity.MyBarListAdapter a;
  public TroopBarMyBar a;
  protected PullRefreshHeader a;
  public XListView a;
  protected ArrayList a;
  protected boolean a;
  public int b;
  protected View b;
  protected int c;
  
  public TroopBarPublishBarSelectActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = -1;
    this.jdField_a_of_type_AndroidOsHandler = new vhs(this);
  }
  
  protected static final String a(int paramInt)
  {
    if (paramInt == 1) {
      return "语音";
    }
    if (paramInt == 4) {
      return "音乐";
    }
    if (paramInt == 2) {
      return "录音";
    }
    return "富媒体";
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903499, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    Contacts.OverScrollViewTag localOverScrollViewTag = new Contacts.OverScrollViewTag();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localOverScrollViewTag);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130838317));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new vhp(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      Contacts.OverScrollViewTag localOverScrollViewTag = (Contacts.OverScrollViewTag)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localOverScrollViewTag != null)
      {
        localOverScrollViewTag.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 800L);
        if (paramInt == 0) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
      }
    }
  }
  
  public final void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(true);
    TroopBarUtils.a(paramBaseActivity, new Bundle(), "http://buluo.qq.com/cgi-bin/bar/mybarlist", 5, new Bundle(), paramCallback);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt < 1) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    do
    {
      do
      {
        return;
        paramAdapterView = (TroopBarMyBar)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
        if (paramAdapterView.l == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopBar", 2, "用户点击了不可选的部落!!!");
      return;
    } while ((this.b > 0) && (a(paramAdapterView)));
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = paramAdapterView;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter.notifyDataSetChanged();
    paramAdapterView = new Intent();
    paramAdapterView.putExtra("key_selected_item", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar);
    setResult(-1, paramAdapterView);
    finish();
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramJSONObject != null) {
      try
      {
        paramBundle = paramJSONObject.getJSONArray("mybars");
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        for (;;)
        {
          this.c = paramBundle.length();
          paramInt = 0;
          while (paramInt < this.c)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(new TroopBarMyBar(paramBundle.getJSONObject(paramInt)));
            paramInt += 1;
          }
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        a(false);
      }
      catch (JSONException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramBundle.toString());
        }
        if (paramJSONObject.optInt("isend", -1) != 1)
        {
          paramInt = paramJSONObject.optInt("retcode", -1);
          if (paramInt == 0) {
            break label220;
          }
          QQToast.a(this, 1, getString(2131364762, new Object[] { Integer.valueOf(paramInt) }), 0).b(getTitleBarHeight());
        }
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131364772, new Object[] { Integer.valueOf(this.c) }));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter.notifyDataSetChanged();
      continue;
      label220:
      QQToast.a(this, 1, getString(2131364762, new Object[] { Integer.valueOf(paramJSONObject.optInt("errno", -1)) }), 0).b(getTitleBarHeight());
      continue;
      QQToast.a(this, 1, 2131364761, 0).b(getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      if ((this.centerView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838321);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    while ((this.centerView == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
      return;
    }
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.centerView.setCompoundDrawables(null, null, null, null);
  }
  
  protected boolean a(TroopBarMyBar paramTroopBarMyBar)
  {
    boolean bool = false;
    String str;
    if ((paramTroopBarMyBar.m & this.b) != this.b)
    {
      str = a(this.b);
      str = getString(2131364965, new Object[] { str, str });
    }
    for (;;)
    {
      if (str != null)
      {
        DialogUtil.a(this, 230, null, str, 2131367262, 2131366640, new vht(this, paramTroopBarMyBar), new vhu(this)).show();
        bool = true;
      }
      return bool;
      if ((paramTroopBarMyBar.n & this.b) == this.b)
      {
        str = a(this.b);
        str = getString(2131364964, new Object[] { str, str });
      }
      else
      {
        str = null;
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getResources();
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8355712);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130837958);
    int i = paramBundle.getDimensionPixelSize(2131493259);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    i = paramBundle.getDimensionPixelSize(2131493258);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837958);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    a();
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter = new TroopBarPublishBarSelectActivity.MyBarListAdapter(this, this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter);
    this.jdField_a_of_type_Boolean = false;
    Intent localIntent = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = ((TroopBarMyBar)localIntent.getParcelableExtra("key_selected_item"));
    this.b = localIntent.getIntExtra("key_media_data", -1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle.getString(2131364772, new Object[] { Integer.valueOf(this.c) }));
    a(this.app, this, this);
    setTitle(2131364791);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
    for (paramBundle = "0";; paramBundle = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x)
    {
      TroopBarUtils.a("pub_page", "exp_tribe", paramBundle, "0", "", "");
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopBarPublishBarSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */