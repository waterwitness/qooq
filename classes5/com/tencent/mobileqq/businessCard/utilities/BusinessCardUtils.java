package com.tencent.mobileqq.businessCard.utilities;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import qxb;
import qxc;

public class BusinessCardUtils
{
  public static final int a = 1000;
  public static final String a = "is_upload_photo";
  public static final int b = 600;
  public static final String b = "card_ocr_info_report";
  public static final int c = 97;
  public static final String c = "ocr_user_edit_action_report";
  public static final String d = "/?01";
  public static final String e = "/?02";
  
  public BusinessCardUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.bj + paramQQAppInterface.a() + "/" + "business_card_photo/");
    localStringBuilder.append("IMG");
    localStringBuilder.append(localCalendar.get(1));
    int i = localCalendar.get(2) + 1;
    if (i < 10)
    {
      paramQQAppInterface = "0" + i;
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(5);
      if (i >= 10) {
        break label323;
      }
      paramQQAppInterface = "0" + i;
      label134:
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(11);
      if (i >= 10) {
        break label331;
      }
      paramQQAppInterface = "0" + i;
      label173:
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(12);
      if (i >= 10) {
        break label339;
      }
      paramQQAppInterface = "0" + i;
      label212:
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(13);
      if (i >= 10) {
        break label347;
      }
    }
    label323:
    label331:
    label339:
    label347:
    for (paramQQAppInterface = "0" + i;; paramQQAppInterface = Integer.valueOf(i))
    {
      localStringBuilder.append(paramQQAppInterface);
      if (new File(localStringBuilder.toString() + ".jpg").exists()) {
        break label355;
      }
      return localStringBuilder.toString() + ".jpg";
      paramQQAppInterface = Integer.valueOf(i);
      break;
      paramQQAppInterface = Integer.valueOf(i);
      break label134;
      paramQQAppInterface = Integer.valueOf(i);
      break label173;
      paramQQAppInterface = Integer.valueOf(i);
      break label212;
    }
    label355:
    paramQQAppInterface = new StringBuilder(localStringBuilder);
    int j = localStringBuilder.length();
    i = 1;
    for (;;)
    {
      if (i < Integer.MAX_VALUE)
      {
        paramQQAppInterface.append('(');
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(')');
        paramQQAppInterface.append(".jpg");
        if (new File(paramQQAppInterface.toString()).exists()) {}
      }
      else
      {
        return paramQQAppInterface.toString();
      }
      paramQQAppInterface.delete(j, paramQQAppInterface.length());
      i += 1;
    }
  }
  
  public static void a(Animator paramAnimator)
  {
    if (paramAnimator != null)
    {
      paramAnimator.removeAllListeners();
      paramAnimator.cancel();
    }
  }
  
  public static void a(Rect paramRect, float paramFloat)
  {
    if (paramFloat != 1.0F)
    {
      int i = paramRect.centerX();
      int j = paramRect.centerY();
      paramRect.offset(-i, -j);
      paramRect.left = ((int)(paramRect.left * paramFloat + 0.5F));
      paramRect.top = ((int)(paramRect.top * paramFloat + 0.5F));
      paramRect.right = ((int)(paramRect.right * paramFloat + 0.5F));
      paramRect.bottom = ((int)(paramRect.bottom * paramFloat + 0.5F));
      paramRect.offset(i, j);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("PhotoConst.TARGET_PATH", a(paramQQAppInterface));
    localIntent.putExtra("PhotoConst.32_Bit_Config", true);
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 1000);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 600);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 1000);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 600);
    localIntent.putExtra("is_upload_photo", true);
    paramActivity.startActivity(localIntent);
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(String paramString)
  {
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 1000;
      localURLDrawableOptions.mRequestHeight = 600;
      ThreadManager.a(new qxc(URLDrawable.getDrawable(paramString, localURLDrawableOptions)), 8, null, true);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode", String.valueOf(paramInt));
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString, "ocr_user_edit_action_report", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode", String.valueOf(paramInt1));
    localHashMap.put("successType", String.valueOf(paramInt2));
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString, "card_ocr_info_report", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static void a(String paramString, URLImageView paramURLImageView, int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramURLImageView == null)) {}
    do
    {
      return;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramInt1;
        localURLDrawableOptions.mRequestHeight = paramInt2;
        localURLDrawableOptions.mLoadingDrawable = paramURLImageView.getContext().getResources().getDrawable(2130840567);
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
        paramURLImageView.setURLDrawableDownListener(new qxb(paramURLImageView));
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("BusinessCard", 2, "error " + paramString.toString());
  }
  
  public static void a(String paramString1, URLImageView paramURLImageView, TextView paramTextView, String paramString2)
  {
    if ((paramURLImageView == null) || (paramTextView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard", 2, "picIv: " + paramURLImageView + " infoTv:" + paramTextView);
      }
      return;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramTextView.setVisibility(8);
      paramURLImageView.setVisibility(0);
      int i = (int)(paramURLImageView.getContext().getResources().getDimension(2131493584) * DeviceInfoUtil.a());
      int j = (int)(paramURLImageView.getContext().getResources().getDimension(2131493585) * DeviceInfoUtil.a());
      a(paramString1 + "/?02", paramURLImageView, i, j);
      return;
    }
    paramTextView.setText(paramString2);
    paramTextView.setVisibility(0);
    paramURLImageView.setVisibility(8);
  }
  
  public static boolean a(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\businessCard\utilities\BusinessCardUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */