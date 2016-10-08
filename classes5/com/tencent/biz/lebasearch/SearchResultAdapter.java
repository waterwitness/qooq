package com.tencent.biz.lebasearch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import hjy;
import hjz;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchResultAdapter
  extends BaseAdapter
{
  public static final String a = "SearchResultAdapter";
  public static final String b = "leba_search";
  public static final String c = "leba_search_plugin_load";
  public static final String d = "leba_search_load_fail";
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public SearchResultAdapter.OnResultItemClickedListener a;
  ViewPluginManager jdField_a_of_type_ComTencentBizViewpluginViewPluginManager;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  List jdField_a_of_type_JavaUtilList;
  JSONArray jdField_a_of_type_OrgJsonJSONArray;
  WeakReference b;
  
  public SearchResultAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ViewPluginManager paramViewPluginManager, JSONArray paramJSONArray, SearchResultAdapter.OnResultItemClickedListener paramOnResultItemClickedListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new hjy(this);
    a(paramJSONArray);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.b = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = paramViewPluginManager;
    this.jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter$OnResultItemClickedListener = paramOnResultItemClickedListener;
  }
  
  public static SpannableString a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramString2 == null) {
      return new SpannableString(paramString1);
    }
    int i = paramString1.indexOf(paramString2);
    if (i != -1)
    {
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), i, paramString2.length() + i, 34);
      return paramString1;
    }
    return new SpannableString(paramString1);
  }
  
  private void a(hjz paramhjz)
  {
    if ((paramhjz == null) || (paramhjz.jdField_a_of_type_JavaLangObject == null)) {
      break label11;
    }
    label11:
    while (paramhjz.e != 2) {
      return;
    }
    JSONObject localJSONObject = (JSONObject)paramhjz.jdField_a_of_type_JavaLangObject;
    int i1 = localJSONObject.optInt("result_type");
    String str1 = localJSONObject.optString("keyword", "");
    String str2 = localJSONObject.optString("result_id", "-1");
    int k = -1;
    int i = -1;
    int n = 0;
    label64:
    Object localObject;
    int m;
    int j;
    if (n < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (hjz)this.jdField_a_of_type_JavaUtilList.get(n);
      m = i;
      j = k;
      if (localObject != null)
      {
        m = i;
        j = k;
        if (((hjz)localObject).e == 1)
        {
          j = k + 1;
          m = -1;
        }
      }
      i = m;
      if (localObject != null)
      {
        i = m;
        if (((hjz)localObject).e == 2) {
          i = m + 1;
        }
      }
      if (!paramhjz.equals(localObject)) {}
    }
    for (k = 1;; k = m)
    {
      if (paramhjz.jdField_b_of_type_JavaLangObject == null)
      {
        if (k == 0) {
          i = -1;
        }
        localObject = new HashMap(8);
        ((HashMap)localObject).put("key_docid", String.valueOf(str2));
        ((HashMap)localObject).put("key_posid", String.valueOf(i));
        ((HashMap)localObject).put("key_clicktype", String.valueOf(i1));
        ((HashMap)localObject).put("key_keyword", String.valueOf(str1));
        paramhjz.jdField_b_of_type_JavaLangObject = localObject;
      }
      if ((this.b == null) || (this.b.get() == null)) {
        break;
      }
      ReportController.b((QQAppInterface)this.b.get(), "CliOper", "", ((QQAppInterface)this.b.get()).a(), "0X80053CF", "0X80053CF", 0, 0, j + "", i1 + "", str1, System.currentTimeMillis() + "");
      if (i1 != 2049) {
        break;
      }
      long l1 = localJSONObject.optLong("result_id", 0L);
      long l2 = localJSONObject.optLong("puin", 0L);
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", l2 + "", "0X80067B1", "0X80067B1", 0, 0, j + "", "", str1, l1 + "");
      return;
      n += 1;
      k = j;
      break label64;
      m = 0;
      j = k;
    }
  }
  
  public void a(JSONArray paramJSONArray)
  {
    this.jdField_a_of_type_OrgJsonJSONArray = paramJSONArray;
    this.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    if (i < this.jdField_a_of_type_OrgJsonJSONArray.length())
    {
      paramJSONArray = this.jdField_a_of_type_OrgJsonJSONArray.optJSONObject(i);
      Object localObject2 = new hjz(this);
      ((hjz)localObject2).e = 1;
      if (paramJSONArray.has("result_name"))
      {
        ((hjz)localObject2).jdField_a_of_type_JavaLangObject = paramJSONArray.optString("result_name");
        ((hjz)localObject2).jdField_a_of_type_JavaLangString = paramJSONArray.optString("result_name");
      }
      Object localObject1;
      if (paramJSONArray.has("result_extension"))
      {
        localObject1 = paramJSONArray.optJSONArray("result_extension");
        if (((JSONArray)localObject1).length() != 0) {}
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilList.add(localObject2);
        int j = 0;
        while (j < ((JSONArray)localObject1).length())
        {
          localObject2 = new hjz(this);
          ((hjz)localObject2).e = 2;
          ((hjz)localObject2).jdField_a_of_type_JavaLangObject = ((JSONArray)localObject1).optJSONObject(j);
          ((hjz)localObject2).jdField_a_of_type_JavaLangString = paramJSONArray.optString("result_name");
          ((hjz)localObject2).f = paramJSONArray.optInt("result_type");
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (j != ((JSONArray)localObject1).length() - 1)
          {
            localObject2 = new hjz(this);
            ((hjz)localObject2).e = 4;
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
          j += 1;
        }
        if (paramJSONArray.has("more_url"))
        {
          localObject1 = paramJSONArray.optString("more_url");
          localObject2 = paramJSONArray.optString("more_name");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) || ((paramJSONArray.optInt("result_type") == 2049) && (!TextUtils.isEmpty((CharSequence)localObject2))))
          {
            localObject1 = new hjz(this);
            ((hjz)localObject1).e = 4;
            this.jdField_a_of_type_JavaUtilList.add(localObject1);
            localObject1 = new hjz(this);
            ((hjz)localObject1).e = 3;
            ((hjz)localObject1).jdField_a_of_type_JavaLangObject = paramJSONArray.optString("more_url");
            ((hjz)localObject1).jdField_a_of_type_JavaLangString = paramJSONArray.optString("result_name");
            ((hjz)localObject1).jdField_b_of_type_JavaLangString = paramJSONArray.optString("more_name");
            ((hjz)localObject1).f = paramJSONArray.optInt("result_type");
            this.jdField_a_of_type_JavaUtilList.add(localObject1);
          }
        }
      }
    }
    paramJSONArray = new hjz(this);
    paramJSONArray.e = 4;
    this.jdField_a_of_type_JavaUtilList.add(paramJSONArray);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null) {
      return null;
    }
    Object localObject3 = (BaseActivity)localObject2;
    hjz localhjz = (hjz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localhjz.e == 1)
    {
      paramView = new TextView((Context)localObject2);
      paramView.setBackgroundColor(((Context)localObject2).getResources().getColor(2131428045));
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)DisplayUtils.a((Context)localObject2, 30.0F)));
      paramView.setTextColor(((Context)localObject2).getResources().getColor(2131427497));
      paramView.setTextSize(14.0F);
      paramView.setPadding((int)DisplayUtils.a((Context)localObject2, 15.0F), 0, 0, (int)DisplayUtils.a((Context)localObject2, 6.0F));
      paramView.setText((String)localhjz.jdField_a_of_type_JavaLangObject);
      paramView.setGravity(80);
      paramView.setFocusable(true);
      return paramView;
    }
    if (localhjz.e == 2)
    {
      Object localObject1 = (JSONObject)localhjz.jdField_a_of_type_JavaLangObject;
      paramViewGroup = this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a(((JSONObject)localObject1).optInt("result_type"));
      if (paramViewGroup != null) {
        if (ViewPluginManager.a(paramViewGroup, ((JSONObject)localObject1).toString())) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        paramViewGroup.setTag(localhjz);
        paramView = paramViewGroup;
        if (paramInt == 0)
        {
          paramView = LayoutInflater.from((Context)localObject2).inflate(2130903632, null);
          paramViewGroup = (ImageView)paramView.findViewById(2131299511);
          localObject2 = (TextView)paramView.findViewById(2131299512);
          localObject3 = a(((JSONObject)localObject1).optString("name"), ((JSONObject)localObject1).optString("keyword"));
          if (localObject3 != null) {
            ((TextView)localObject2).setText((CharSequence)localObject3);
          }
        }
        try
        {
          new URL(((JSONObject)localObject1).optString("pic_url"));
          localObject1 = URLDrawable.getDrawable(((JSONObject)localObject1).optString("pic_url"));
          ((URLDrawable)localObject1).addHeader("User-Agent", "Dalvik/1.6.0 (Linux; U; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + ")");
          paramViewGroup.setImageDrawable((Drawable)localObject1);
          paramView.setTag(localhjz);
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          return paramView;
          ReportController.b(((BaseActivity)localObject3).app, "P_CliOper", "BizTechReport", "", "leba_search", "leba_search_load_fail", 0, 0, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a(), "2", null, null);
          paramInt = 0;
          continue;
          ReportController.b(((BaseActivity)localObject3).app, "P_CliOper", "BizTechReport", "", "leba_search", "leba_search_load_fail", 0, 0, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a(), "1", null, null);
          paramInt = 0;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            paramViewGroup.setBackgroundColor(Color.parseColor("#e7e7e7"));
            if (QLog.isColorLevel()) {
              QLog.d("SearchResultAdapter", 2, localMalformedURLException.getMessage());
            }
          }
        }
      }
    }
    if (localhjz.e == 3)
    {
      paramView = LayoutInflater.from((Context)localObject2).inflate(2130903630, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)DisplayUtils.a((Context)localObject2, 44.0F)));
      paramView.setTag(localhjz);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
    }
    if (localhjz.e == 4)
    {
      paramView = new TextView((Context)localObject2);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      paramView.setBackgroundColor(Color.parseColor("#dedfe0"));
      return paramView;
    }
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\lebasearch\SearchResultAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */