package com.tencent.bitapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.PixelUtil;
import com.tencent.bitapp.bundle.BundleFacade;
import com.tencent.bitapp.cache.BitAppFileCache;
import com.tencent.bitapp.pre.ContextUtils;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.bitapp.view.BitAppBaseView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.PAReportUtil.AdverInfo;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import hdk;
import hdl;
import hdn;
import hdo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BitAppMsgItemBuilder
  extends AbstractChatItemBuilder
{
  public static final int a = 25;
  public static final int b = 10;
  private static final String b = "BitAppMsgItemBuilder";
  public static final int c = 10;
  public static final int d = 23;
  public static final int e = 240;
  Resources jdField_a_of_type_AndroidContentResResources;
  BitAppBaseViewCache jdField_a_of_type_ComTencentBitappBitAppBaseViewCache;
  PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private Map jdField_a_of_type_JavaUtilMap;
  
  public BitAppMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBitappBitAppBaseViewCache = null;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentBitappBitAppBaseViewCache = new BitAppBaseViewCache();
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    if (QLog.isColorLevel()) {
      Log.e("bitapp_performance", "BitAppMsgItemBuilder onclick");
    }
    b();
    BitAppExitBroadcastReceiver.a(ContextUtils.INSTANCE.getApplicationContext());
  }
  
  public static int a(Resources paramResources, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      return AIOUtils.a(paramInt1, paramResources);
    }
    return AIOUtils.a(paramInt2, paramResources);
  }
  
  public static int a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= 0) {
      return paramResources.getDisplayMetrics().widthPixels - paramInt2 - paramInt3;
    }
    return AIOUtils.a(paramInt1, paramResources);
  }
  
  public static View a(Context paramContext, View paramView)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = new View(paramContext);
    }
    if (QLog.isColorLevel())
    {
      localView.setBackgroundColor(-65281);
      return localView;
    }
    localView.setVisibility(8);
    return localView;
  }
  
  private void a(Activity paramActivity, View paramView, MessageForBitApp paramMessageForBitApp)
  {
    String str = paramMessageForBitApp.frienduin;
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = paramMessageForBitApp.bitAppMsg.adverKey;
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      int i = 0;
      if (i < ((JSONArray)localObject1).length())
      {
        JSONObject localJSONObject = (JSONObject)((JSONArray)localObject1).get(i);
        Object localObject2 = new PopupMenuDialog.MenuItem();
        ((PopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_Int = i;
        ((PopupMenuDialog.MenuItem)localObject2).b = 0;
        if (localJSONObject.has("show_name")) {}
        for (((PopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");; ((PopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString = "")
        {
          localArrayList1.add(localObject2);
          localObject2 = new PAReportUtil.AdverInfo();
          ((PAReportUtil.AdverInfo)localObject2).jdField_a_of_type_JavaLangString = str;
          ((PAReportUtil.AdverInfo)localObject2).c = localJSONObject.optString("index");
          ((PAReportUtil.AdverInfo)localObject2).d = localJSONObject.optString("index_name");
          ((PAReportUtil.AdverInfo)localObject2).b = localJSONObject.optString("index_type");
          ((PAReportUtil.AdverInfo)localObject2).e = String.valueOf(HttpUtil.a());
          localArrayList2.add(localObject2);
          i += 1;
          break;
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(paramActivity, localArrayList1, new hdl(this, paramActivity, paramMessageForBitApp, str, localArrayList2), new hdn(this), AIOUtils.a(100.0F, paramActivity.getResources()));
      i = paramView.getWidth() * 7 / 2;
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, 0 - i, 0);
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    int i = -1;
    try
    {
      paramInt1 = Integer.parseInt(String.valueOf(this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1))));
      return paramInt1 == paramInt2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramInt1 = i;
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(143);
    if (RNPreDownloadFacade.a()) {
      BundleFacade.loadBaseBundle();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("BitAppMsgItemBuilder", 2, "bitapp not ready");
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("bitapp_performance", 2, "BitAppMsgItemBuilder getItemView");
    }
    if ((!MessageForBitApp.class.isInstance(paramMessageRecord)) || (((MessageForBitApp)paramMessageRecord).bitAppMsg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BitAppMsgItemBuilder", 2, "not MessageForBitApp or bitAppMsg is null");
      }
      paramMessageRecord = a(this.jdField_a_of_type_AndroidContentContext, paramView);
      return paramMessageRecord;
    }
    MessageForBitApp localMessageForBitApp = (MessageForBitApp)paramMessageRecord;
    paramLinearLayout.setAddStatesFromChildren(false);
    Object localObject = null;
    if ((paramView == null) || (!(paramView instanceof BitAppViewGroup)))
    {
      View localView = LayoutInflater.from(paramLinearLayout.getContext()).inflate(2130904902, paramLinearLayout, false);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localObject = localLayoutParams;
      paramView = localView;
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = a(this.jdField_a_of_type_AndroidContentResResources, localMessageForBitApp.bitAppMsg.mPaddingLeft, 10);
        ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = a(this.jdField_a_of_type_AndroidContentResResources, localMessageForBitApp.bitAppMsg.mPaddingRight, 10);
        ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin = a(this.jdField_a_of_type_AndroidContentResResources, localMessageForBitApp.bitAppMsg.mPaddingTop, 23);
        ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin = a(this.jdField_a_of_type_AndroidContentResResources, localMessageForBitApp.bitAppMsg.mPaddingBottom, 25);
        paramView = localView;
        localObject = localLayoutParams;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (localObject == null) {
          break label380;
        }
        QLog.d("BitAppMsgItemBuilder", 4, "getItemView[" + paramViewHolder.jdField_a_of_type_Int + ", H1=" + ((ViewGroup.LayoutParams)localObject).height + "|" + paramLinearLayout.getHeight() + paramMessageRecord + "]");
      }
      for (;;)
      {
        ((BitAppViewGroup)paramView).a(this, localMessageForBitApp, a(localMessageForBitApp.bitAppMsg.getModuleId(), paramViewHolder.jdField_a_of_type_Int), paramOnLongClickAndTouchListener, new hdk(this, localMessageForBitApp));
        paramMessageRecord = paramView;
        if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) {
          break;
        }
        paramMessageRecord = paramView;
        if (!this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
        return paramView;
        label380:
        QLog.d("BitAppMsgItemBuilder", 4, "getItemView[" + paramViewHolder.jdField_a_of_type_Int + ", H2=" + paramView.getHeight() + "|" + paramLinearLayout.getHeight() + paramMessageRecord + "]");
      }
    }
  }
  
  public BitAppBaseView a(Context paramContext, MessageForBitApp paramMessageForBitApp, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, BitAppBaseViewCache.BitAppGetViewListener paramBitAppGetViewListener)
  {
    BitAppMsg localBitAppMsg = paramMessageForBitApp.bitAppMsg;
    int i = a(this.jdField_a_of_type_AndroidContentResResources, localBitAppMsg.mPaddingLeft, 10);
    int j = a(this.jdField_a_of_type_AndroidContentResResources, localBitAppMsg.mPaddingRight, 10);
    int k = localBitAppMsg.mWidth;
    j = a(this.jdField_a_of_type_AndroidContentResResources, k, i, j);
    i = 0;
    try
    {
      if (DisplayMetricsHolder.getDisplayMetrics() == null) {
        DisplayMetricsHolder.setDisplayMetrics(paramContext.getResources().getDisplayMetrics());
      }
      float f = PixelUtil.toDIPFromPixel(j);
      i = (int)f;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return this.jdField_a_of_type_ComTencentBitappBitAppBaseViewCache.a(paramContext, paramMessageForBitApp, i, paramOnLongClickAndTouchListener, paramBitAppGetViewListener);
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new hdo(this);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BitAppMsgItemBuilder", 2, "BitAppMsgItemBuilder destroy");
    }
    this.jdField_a_of_type_ComTencentBitappBitAppBaseViewCache.a();
    BitAppFileCache.c();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    BitAppMenuHelper.a(paramInt, this.jdField_a_of_type_AndroidContentContext, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBitappBitAppBaseViewCache.a(paramString);
  }
  
  public void a(HashMap paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppMsgItemBuilder", 2, "setLastPos .... " + paramHashMap.toString());
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.putAll(paramHashMap);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return BitAppMenuHelper.a(this.jdField_a_of_type_AndroidContentContext, paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppMsgItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */