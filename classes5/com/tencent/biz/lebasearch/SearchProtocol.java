package com.tencent.biz.lebasearch;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ExtensionRequestInfo;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.PluginState;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RequestBody;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RootSearcherRequest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hjp;
import hjq;
import hjr;
import hjs;
import hjt;
import hju;
import hjv;
import hjw;
import hjx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchProtocol
{
  public static float a = -1.0F;
  public static final int a = 1;
  public static long a = 0L;
  static final String a = "SearchProtocol";
  public static float b = -1.0F;
  public static final int b = 2;
  public static final long b = 10800000L;
  public static final String b = "DynSearchSvc.Search";
  public static final int c = 3;
  public static final long c = 600000L;
  public static final String c = "result_type";
  public static final int d = 4;
  public static final long d = 600000L;
  public static final String d = "result_name";
  public static final int e = 0;
  public static final long e = 43200000L;
  public static final String e = "total_count";
  public static final int f = -1;
  public static final String f = "result_extension";
  public static final int g = -2;
  public static final String g = "result_id";
  public static final int h = -16734752;
  public static final String h = "jump_url";
  public static final int i = 1;
  public static final String i = "pic_url";
  public static final int j = 2;
  public static final String j = "name";
  public static final String k = "word";
  public static final String l = "keyword";
  public static final String m = "more_url";
  public static final String n = "more_name";
  public static final String o = "clickable";
  public static final String p = "active_search_home_hot_word";
  public static final String q = "active_search_home_hot_word_id";
  public static final String r = "active_search_home_hot_word_time";
  public static final String s = "active_search_hot_words";
  public static final String t = "active_search_hot_words_time";
  public static final String u = "search_lbs_timestamp";
  public static final String v = "search_lbs_delay";
  public static final String w = "search_lbs_latitude";
  public static final String x = "search_lbs_logitude";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected static SearchProtocol.WordItem a(SharedPreferences paramSharedPreferences)
  {
    SearchProtocol.WordItem localWordItem = new SearchProtocol.WordItem();
    localWordItem.word = paramSharedPreferences.getString("active_search_home_hot_word", "");
    localWordItem.id = paramSharedPreferences.getString("active_search_home_hot_word_id", "");
    return localWordItem;
  }
  
  public static List a(SharedPreferences paramSharedPreferences)
  {
    localArrayList = new ArrayList();
    paramSharedPreferences = paramSharedPreferences.getString("active_search_hot_words", "");
    if (!TextUtils.isEmpty(paramSharedPreferences)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramSharedPreferences);
        int i1 = 0;
        while (i1 < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
          SearchProtocol.WordItem localWordItem = new SearchProtocol.WordItem();
          localWordItem.id = localJSONObject.optString("id");
          localWordItem.word = localJSONObject.optString("word");
          localWordItem.jumpUrl = localJSONObject.optString("url");
          localWordItem.textColor = localJSONObject.optInt("color");
          localWordItem.type = localJSONObject.optInt("type");
          localArrayList.add(localWordItem);
          i1 += 1;
        }
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchProtocol", 2, "JSONException tips = " + paramSharedPreferences);
        }
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    paramContext = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
    int i1 = paramContext.getInt("search_lbs_delay", 0);
    if (i1 > 0) {
      paramLong = i1 * 60 * 60 * 1000;
    }
    if (System.currentTimeMillis() - paramContext.getLong("search_lbs_timestamp", 0L) > paramLong)
    {
      SosoInterface.a(new hjp(0, true, false, 60000L, false, false, paramString, paramContext));
      return;
    }
    a = paramContext.getFloat("search_lbs_latitude", -1.0F);
    b = paramContext.getFloat("search_lbs_logitude", -1.0F);
  }
  
  public static void a(SharedPreferences paramSharedPreferences, List paramList)
  {
    JSONArray localJSONArray;
    if (paramList.size() != 0)
    {
      localJSONArray = new JSONArray();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      SearchProtocol.WordItem localWordItem;
      JSONObject localJSONObject;
      if (paramList.hasNext())
      {
        localWordItem = (SearchProtocol.WordItem)paramList.next();
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("word", localWordItem.word);
        localJSONObject.put("id", localWordItem.id);
        localJSONObject.put("url", localWordItem.jumpUrl);
        localJSONObject.put("color", localWordItem.textColor);
        localJSONObject.put("type", localWordItem.type);
        localJSONArray.put(localJSONObject);
        continue;
        paramSharedPreferences.edit().putString("active_search_hot_words", localJSONArray.toString()).commit();
        paramSharedPreferences.edit().putLong("active_search_hot_words_time", System.currentTimeMillis()).commit();
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, SearchProtocol.SearchObserver paramSearchObserver)
  {
    if ((paramAppInterface == null) || (paramSearchObserver == null)) {
      return;
    }
    paramContext = new hjs(Looper.getMainLooper(), paramSearchObserver);
    if (HttpUtil.a() == 0)
    {
      paramAppInterface = paramContext.obtainMessage();
      paramAppInterface.arg1 = -1;
      paramContext.sendMessage(paramAppInterface);
      return;
    }
    paramSearchObserver = paramAppInterface.a().getSharedPreferences(paramAppInterface.getAccount(), 0);
    if (Long.valueOf(System.currentTimeMillis()).longValue() - Long.valueOf(0L).longValue() < 600000L)
    {
      paramAppInterface = a(paramSearchObserver);
      paramSearchObserver = paramContext.obtainMessage();
      paramSearchObserver.arg1 = 0;
      paramSearchObserver.obj = paramAppInterface;
      paramContext.sendMessage(paramSearchObserver);
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppInterface.a(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", "DynSearchSvc.Search");
    mobileqq_dynamic_search.RequestBody localRequestBody = new mobileqq_dynamic_search.RequestBody();
    localRequestBody.cmd.set(1);
    mobileqq_dynamic_search.RootSearcherRequest localRootSearcherRequest = new mobileqq_dynamic_search.RootSearcherRequest();
    localRootSearcherRequest.business.set(128);
    localRootSearcherRequest.busi_mask.set(-1L);
    localRequestBody.search_request.set(localRootSearcherRequest);
    localNewIntent.putExtra("data", localRequestBody.toByteArray());
    localNewIntent.setObserver(new hjt(paramSearchObserver, paramContext));
    paramAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, SearchProtocol.SearchObserver paramSearchObserver, String paramString)
  {
    if ((paramAppInterface == null) || (paramSearchObserver == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramContext = new hjw(Looper.getMainLooper(), paramSearchObserver);
    if (HttpUtil.a() == 0)
    {
      paramAppInterface = paramContext.obtainMessage();
      paramAppInterface.arg1 = -1;
      paramContext.sendMessage(paramAppInterface);
      return;
    }
    paramSearchObserver = new NewIntent(paramAppInterface.a(), ProtoServlet.class);
    paramSearchObserver.putExtra("cmd", "DynSearchSvc.Search");
    mobileqq_dynamic_search.RequestBody localRequestBody = new mobileqq_dynamic_search.RequestBody();
    localRequestBody.cmd.set(2);
    localRequestBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new mobileqq_dynamic_search.RootSearcherRequest();
    paramString.business.set(128);
    localRequestBody.search_request.set(paramString);
    paramSearchObserver.putExtra("data", localRequestBody.toByteArray());
    paramSearchObserver.setObserver(new hjx(paramContext));
    paramAppInterface.startServlet(paramSearchObserver);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, SearchProtocol.SearchObserver paramSearchObserver, String paramString, List paramList)
  {
    if ((paramAppInterface == null) || (paramSearchObserver == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramContext = new hjq(Looper.getMainLooper(), paramSearchObserver);
    if (HttpUtil.a() == 0)
    {
      paramAppInterface = paramContext.obtainMessage();
      paramAppInterface.arg1 = -2;
      paramContext.sendMessage(paramAppInterface);
      return;
    }
    paramSearchObserver = new NewIntent(paramAppInterface.a(), ProtoServlet.class);
    paramSearchObserver.putExtra("cmd", "DynSearchSvc.Search");
    mobileqq_dynamic_search.RequestBody localRequestBody = new mobileqq_dynamic_search.RequestBody();
    localRequestBody.cmd.set(4);
    localRequestBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString));
    localRequestBody.version.set(ByteStringMicro.copyFromUtf8("6.5.5"));
    mobileqq_dynamic_search.RootSearcherRequest localRootSearcherRequest = new mobileqq_dynamic_search.RootSearcherRequest();
    localRootSearcherRequest.business.set(128);
    localRootSearcherRequest.busi_mask.set(-1L);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)paramList.next();
      mobileqq_dynamic_search.PluginState localPluginState = new mobileqq_dynamic_search.PluginState();
      localPluginState.plugin_id.set((int)localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId);
      if (localLebaViewItem.jdField_a_of_type_Byte == 0) {
        localPluginState.plugin_switch.set(1);
      }
      for (;;)
      {
        localArrayList.add(localPluginState);
        break;
        if (localLebaViewItem.jdField_a_of_type_Byte == 1) {
          localPluginState.plugin_switch.set(0);
        }
      }
    }
    localRootSearcherRequest.plugin_state.set(localArrayList);
    localRequestBody.search_request.set(localRootSearcherRequest);
    if (a != -1.0F)
    {
      paramList = new mobileqq_dynamic_search.ExtensionRequestInfo();
      paramList.latitude.set(a);
      paramList.longitude.set(b);
      localRequestBody.extension_request_info.set(paramList);
    }
    paramSearchObserver.putExtra("data", localRequestBody.toByteArray());
    paramSearchObserver.setObserver(new hjr(paramString, paramContext));
    paramAppInterface.startServlet(paramSearchObserver);
  }
  
  private static int b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("#")) || (paramString.length() > 9) || (paramString.length() < 6)) {
      return 0;
    }
    try
    {
      int i1 = StringUtil.a(paramString, 1, paramString.length());
      return i1;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static void b(AppInterface paramAppInterface, Context paramContext, SearchProtocol.SearchObserver paramSearchObserver)
  {
    if ((paramAppInterface == null) || (paramSearchObserver == null)) {
      return;
    }
    paramContext = new hju(Looper.getMainLooper(), paramSearchObserver);
    if (HttpUtil.a() == 0)
    {
      paramAppInterface = paramContext.obtainMessage();
      paramAppInterface.arg1 = -1;
      paramContext.sendMessage(paramAppInterface);
      return;
    }
    paramSearchObserver = paramAppInterface.a().getSharedPreferences(paramAppInterface.getAccount(), 0);
    if (Long.valueOf(System.currentTimeMillis()).longValue() - Long.valueOf(0L).longValue() < 600000L)
    {
      paramAppInterface = a(paramSearchObserver);
      paramSearchObserver = paramContext.obtainMessage();
      paramSearchObserver.arg1 = 0;
      paramSearchObserver.obj = paramAppInterface;
      paramContext.sendMessage(paramSearchObserver);
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppInterface.a(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", "PubAccountArticleCenter.GetSearchHotwords");
    mobileqq_dynamic_search.RequestBody localRequestBody = new mobileqq_dynamic_search.RequestBody();
    localRequestBody.cmd.set(1);
    mobileqq_dynamic_search.RootSearcherRequest localRootSearcherRequest = new mobileqq_dynamic_search.RootSearcherRequest();
    localRootSearcherRequest.business.set(128);
    localRequestBody.search_request.set(localRootSearcherRequest);
    localRequestBody.version.set(ByteStringMicro.copyFromUtf8("6.5.5"));
    localNewIntent.putExtra("data", localRequestBody.toByteArray());
    localNewIntent.setObserver(new hjv(paramSearchObserver, paramContext));
    paramAppInterface.startServlet(localNewIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\lebasearch\SearchProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */