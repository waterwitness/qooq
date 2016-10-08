package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateConfig.SignatureTemplateType;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.ImageItem;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import qgd;
import qge;
import qgf;
import qgg;

public class SignatureManager
  implements Handler.Callback, Manager
{
  public static final int a = 1;
  public static SignatureTemplateInfo.DynamicItem a;
  public static final String a = "SignatureManager";
  public static boolean a = false;
  public static SignatureTemplateConfig.SignatureTemplateType[] a;
  public static final int b = 0;
  private static SignatureTemplateInfo b;
  public static final String b = "sigResUpt";
  public static final int c = 14;
  public static final String c = "sigTplCfgVer";
  public static final int d = 19;
  public static final String d = "sigTplUptFlag";
  public static final String e = "sigTplUptTime";
  public static final String f = "sigTplCfgVerTemp";
  public static final String g = AppConstants.ca + "SigtplJson.txt";
  private static final int h = 1;
  public static final String h = "http://i.gtimg.cn/qqshow/admindata/comdata/sigtpl_%d/android.zip";
  private static final int i = 2;
  public static final String i = AppConstants.ca;
  private static final int j = 1;
  public static final String j = i + "/temp";
  private static final int k = 2;
  public static final String k = "resType";
  private static final int l = 3;
  public static final String l = "dynamicType";
  private static final int m = 4;
  public static final String m = "tplId";
  public static final String n = "fileName";
  public static final String o = "tlpres";
  public static final String p = "cover.png";
  public static final String q = "aio_2.png";
  public static final String r = "aio_3.png";
  public static final String s = "aio_4.png";
  public static final String t = "view.png";
  public static final String u = "icon.png";
  public static final String v = "action_off.png";
  public static final String w = "action_on.png";
  public static final String x = "dynamic_aio";
  public static String y;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new qge(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  public QQAppInterface a;
  public SignatureTemplateInfo a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new qgf(this);
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public int e;
  public int f = -1;
  public int g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SignatureManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)paramQQAppInterface.getManager(46)).a(1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    ThreadManager.a(new qgd(this), 8, null, true);
  }
  
  public static int a(String paramString, ListAdapter paramListAdapter)
  {
    int i1 = 0;
    while (i1 < paramListAdapter.getCount())
    {
      Object localObject = paramListAdapter.getItem(i1);
      if (((localObject instanceof RichStatus)) && (((RichStatus)localObject).feedsId.equals(paramString))) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private Bitmap a(File paramFile)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return null;
      Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inDensity = 320;
      if (localResources.getDisplayMetrics().densityDpi > localOptions.inDensity) {}
      for (localOptions.inTargetDensity = 320;; localOptions.inTargetDensity = localResources.getDisplayMetrics().densityDpi) {
        try
        {
          paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
          return paramFile;
        }
        catch (OutOfMemoryError paramFile) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("SignatureManager", 2, "OOM");
    return null;
  }
  
  public static Layout a(Resources paramResources, TextView paramTextView, StatusManager paramStatusManager, RichStatus paramRichStatus, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt)
  {
    if (paramRichStatus == null) {
      return null;
    }
    int i1 = Color.parseColor("black");
    SpannableString localSpannableString = paramRichStatus.toSpannableString(null, i1, i1);
    TextPaint localTextPaint = paramTextView.getPaint();
    if (paramBoolean)
    {
      paramInt -= DisplayUtil.a(paramQQAppInterface.getApplication().getApplicationContext(), 40.0F);
      i1 = DisplayUtil.a(paramQQAppInterface.getApplication().getApplicationContext(), 5.0F);
      if ((paramRichStatus == null) || (paramResources == null) || (TextUtils.isEmpty(paramRichStatus.actionText))) {
        break label293;
      }
      paramQQAppInterface = new SpannableStringBuilder(localSpannableString);
      paramQQAppInterface.insert(0, "[S] ");
      if (paramStatusManager == null) {
        break label269;
      }
      paramStatusManager = paramStatusManager.a(paramRichStatus.actionId, 200);
      label126:
      paramResources = new StatableBitmapDrawable(paramResources, paramStatusManager, false, false);
      int i2 = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
      paramResources.setBounds(0, 0, i2, i2);
      if ((Build.VERSION.SDK_INT < 4) || (Build.VERSION.SDK_INT >= 20)) {
        break label280;
      }
    }
    label269:
    label280:
    for (paramResources = new OffsetableImageSpan(paramResources, 1);; paramResources = new OffsetableImageSpan(paramResources, 0))
    {
      paramResources.a(-0.1F);
      paramQQAppInterface.setSpan(paramResources, 0, "[S]".length(), 17);
      return new DynamicLayout(paramQQAppInterface, localTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, i1, true);
      paramInt -= DisplayUtil.a(paramQQAppInterface.getApplication().getApplicationContext(), 60.0F);
      i1 = DisplayUtil.a(paramQQAppInterface.getApplication().getApplicationContext(), 2.0F);
      break;
      paramStatusManager = BitmapManager.a(paramResources, 2130842868);
      break label126;
    }
    label293:
    return new StaticLayout(localSpannableString, localTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, i1, true);
  }
  
  private static String a(int paramInt, String paramString)
  {
    if (jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType == null) {}
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("http://i.gtimg.cn/qqshow/admindata/comdata/");
    localStringBuilder.append("vipSignature_item");
    localStringBuilder.append("_");
    localStringBuilder.append(Integer.toString(paramInt));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(Resources paramResources, TextView paramTextView, StatusManager paramStatusManager, RichStatus paramRichStatus, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramRichStatus == null)
    {
      paramTextView.setText(new SpannableString(""));
      return;
    }
    int i2 = Color.parseColor("black");
    int i1;
    if ((paramQQAppInterface != null) && (!paramBoolean))
    {
      i1 = Color.parseColor(((SignatureManager)paramQQAppInterface.getManager(57)).a(Integer.toString(paramRichStatus.tplId)).jdField_e_of_type_JavaLangString);
      paramQQAppInterface = paramRichStatus.toSpannableString(null, i1, i2);
      if ((paramRichStatus == null) || (paramResources == null) || (TextUtils.isEmpty(paramRichStatus.actionText))) {
        break label264;
      }
      paramQQAppInterface = new SpannableStringBuilder(paramQQAppInterface);
      paramQQAppInterface.insert(0, "[S] ");
      if (paramStatusManager == null) {
        break label240;
      }
      paramStatusManager = paramStatusManager.a(paramRichStatus.actionId, 200);
      label131:
      paramResources = new StatableBitmapDrawable(paramResources, paramStatusManager, false, false);
      i2 = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
      paramResources.setBounds(0, 0, i2, i2);
      if ((Build.VERSION.SDK_INT < 4) || (Build.VERSION.SDK_INT == 20)) {
        break label251;
      }
      paramResources = new OffsetableImageSpan(paramResources, 1);
      label193:
      paramResources.a(-0.1F);
      paramQQAppInterface.setSpan(paramResources, 0, "[S]".length(), 17);
      paramTextView.setText(paramQQAppInterface);
    }
    for (;;)
    {
      paramTextView.setTextColor(i1);
      return;
      i1 = Color.parseColor("#ffa8a8a8");
      break;
      label240:
      paramStatusManager = BitmapManager.a(paramResources, 2130842868);
      break label131;
      label251:
      paramResources = new OffsetableImageSpan(paramResources, 0);
      break label193;
      label264:
      paramTextView.setText(paramQQAppInterface);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, RichStatus paramRichStatus)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      bool = false;
    }
    while (paramQQAppInterface.a().equals(paramString)) {
      return bool;
    }
    ThreadManager.a(new qgg(paramRichStatus, paramQQAppInterface, paramString), 8, null, false);
    return true;
  }
  
  public static boolean a(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    if (paramSignatureTemplateInfo.jdField_e_of_type_Int == 1) {}
    do
    {
      for (;;)
      {
        return false;
        if ((!TextUtils.isEmpty(paramSignatureTemplateInfo.r)) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.q)))
        {
          Object localObject = new Date(NetConnInfoCenter.getServerTimeMillis());
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          localObject = localSimpleDateFormat.format((Date)localObject);
          try
          {
            localObject = localSimpleDateFormat.parse((String)localObject);
            Date localDate = localSimpleDateFormat.parse(paramSignatureTemplateInfo.r);
            paramSignatureTemplateInfo = localSimpleDateFormat.parse(paramSignatureTemplateInfo.q);
            if (((Date)localObject).compareTo(localDate) <= 0)
            {
              int i1 = ((Date)localObject).compareTo(paramSignatureTemplateInfo);
              if (i1 >= 0) {
                return true;
              }
            }
          }
          catch (ParseException paramSignatureTemplateInfo) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("SignatureManager", 2, paramSignatureTemplateInfo.toString());
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (SharpPUtil.isSharpPFile(new File(paramString))) {
        return true;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1)) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SignatureManager", 2, paramString + " is not a picture");
    return false;
  }
  
  private boolean b(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    boolean bool = false;
    if ((!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[1].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[2].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[3].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[4].jdField_a_of_type_JavaLangString))) {
      bool = true;
    }
    return bool;
  }
  
  public Drawable a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject4 = null;
    int i4 = 0;
    int i3 = 0;
    jdField_a_of_type_Boolean = false;
    Object localObject3 = Integer.toString(paramInt1);
    SignatureTemplateInfo localSignatureTemplateInfo = a((String)localObject3);
    if ((localSignatureTemplateInfo != null) && (localSignatureTemplateInfo.jdField_a_of_type_JavaLangString.equals("0"))) {}
    for (int i2 = 1;; i2 = 0)
    {
      y = null;
      jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = null;
      boolean bool2;
      if (localSignatureTemplateInfo != null)
      {
        bool2 = b(localSignatureTemplateInfo);
        bool1 = bool2;
        if (bool2)
        {
          localSignatureTemplateInfo.getClass();
          jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = new SignatureTemplateInfo.DynamicItem(localSignatureTemplateInfo);
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        int i1 = i3;
        Object localObject1;
        switch (paramInt2)
        {
        default: 
          i1 = i3;
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
          localObject1 = null;
        }
        for (;;)
        {
          label199:
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
          {
            localObject3 = null;
            label209:
            return (Drawable)localObject3;
            if (i2 != 0)
            {
              i2 = 2130841861;
              label222:
              i1 = i2;
              if (localSignatureTemplateInfo == null) {
                break label1471;
              }
              if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
                break label366;
              }
            }
            label366:
            for (localObject2 = localSignatureTemplateInfo.k;; localObject2 = localSignatureTemplateInfo.s)
            {
              i1 = i2;
              localObject1 = localObject2;
              if (!bool1) {
                break label1468;
              }
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                y = "dynamic_aio";
                jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0];
              }
              i1 = i2;
              localObject1 = localObject2;
              if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                break label1468;
              }
              i1 = i2;
              localObject1 = localObject2;
              if (b((String)localObject3)) {
                break label1468;
              }
              a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
              i1 = i2;
              localObject1 = localObject2;
              break;
              i2 = 2130841860;
              break label222;
            }
            i2 = 2130841873;
            i1 = i2;
            if (localSignatureTemplateInfo == null) {
              break;
            }
            localObject1 = localSignatureTemplateInfo.d;
            i1 = i2;
            continue;
            if (localSignatureTemplateInfo == null) {
              break label1491;
            }
            localObject1 = localSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.c;
            if (!bool1) {
              break label1483;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              y = "dynamic_aio";
              jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0];
            }
            if ((TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) || (b((String)localObject3))) {
              break label1483;
            }
            a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
            i1 = 2130841860;
            continue;
            if (i2 != 0)
            {
              i2 = 2130841861;
              label511:
              if ((localSignatureTemplateInfo == null) || (localSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem == null)) {
                break label1477;
              }
            }
          }
          label661:
          label805:
          label825:
          label969:
          label989:
          label1133:
          label1468:
          label1471:
          label1477:
          for (Object localObject2 = localSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.jdField_a_of_type_JavaLangString;; localObject2 = null)
          {
            i1 = i2;
            localObject1 = localObject2;
            if (bool1)
            {
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                y = "dynamic_aio";
                jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[4];
              }
              i1 = i2;
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString))
              {
                i1 = i2;
                localObject1 = localObject2;
                if (!b((String)localObject3))
                {
                  a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
                  i1 = i2;
                  localObject1 = localObject2;
                  break label199;
                  i2 = 2130841860;
                  break label511;
                  if (i2 != 0)
                  {
                    i2 = 2130841861;
                    i1 = i2;
                    if (localSignatureTemplateInfo == null) {
                      break label1471;
                    }
                    if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
                      break label805;
                    }
                  }
                  for (localObject2 = localSignatureTemplateInfo.g;; localObject2 = localSignatureTemplateInfo.s)
                  {
                    i1 = i2;
                    localObject1 = localObject2;
                    if (!bool1) {
                      break label1468;
                    }
                    if (!TextUtils.isEmpty((CharSequence)localObject2))
                    {
                      y = "dynamic_aio";
                      jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[1];
                    }
                    i1 = i2;
                    localObject1 = localObject2;
                    if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                      break label1468;
                    }
                    i1 = i2;
                    localObject1 = localObject2;
                    if (b((String)localObject3)) {
                      break label1468;
                    }
                    a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
                    i1 = i2;
                    localObject1 = localObject2;
                    break;
                    i2 = 2130841860;
                    break label661;
                  }
                  if (i2 != 0)
                  {
                    i2 = 2130841861;
                    i1 = i2;
                    if (localSignatureTemplateInfo == null) {
                      break label1471;
                    }
                    if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
                      break label969;
                    }
                  }
                  for (localObject2 = localSignatureTemplateInfo.h;; localObject2 = localSignatureTemplateInfo.s)
                  {
                    i1 = i2;
                    localObject1 = localObject2;
                    if (!bool1) {
                      break label1468;
                    }
                    if (!TextUtils.isEmpty((CharSequence)localObject2))
                    {
                      y = "dynamic_aio";
                      jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[2];
                    }
                    i1 = i2;
                    localObject1 = localObject2;
                    if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                      break label1468;
                    }
                    i1 = i2;
                    localObject1 = localObject2;
                    if (b((String)localObject3)) {
                      break label1468;
                    }
                    a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
                    i1 = i2;
                    localObject1 = localObject2;
                    break;
                    i2 = 2130841860;
                    break label825;
                  }
                  if (i2 != 0)
                  {
                    i2 = 2130841861;
                    i1 = i2;
                    if (localSignatureTemplateInfo == null) {
                      break label1471;
                    }
                    if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
                      break label1133;
                    }
                  }
                  for (localObject2 = localSignatureTemplateInfo.i;; localObject2 = localSignatureTemplateInfo.s)
                  {
                    i1 = i2;
                    localObject1 = localObject2;
                    if (!bool1) {
                      break label1468;
                    }
                    if (!TextUtils.isEmpty((CharSequence)localObject2))
                    {
                      y = "dynamic_aio";
                      jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[3];
                    }
                    i1 = i2;
                    localObject1 = localObject2;
                    if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                      break label1468;
                    }
                    i1 = i2;
                    localObject1 = localObject2;
                    if (b((String)localObject3)) {
                      break label1468;
                    }
                    a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
                    i1 = i2;
                    localObject1 = localObject2;
                    break;
                    i2 = 2130841860;
                    break label989;
                  }
                  if (localSignatureTemplateInfo != null)
                  {
                    localObject1 = localSignatureTemplateInfo.j;
                    i1 = 2130841861;
                    break label199;
                    i2 = 2130841876;
                    i1 = i2;
                    if (localSignatureTemplateInfo == null) {
                      break;
                    }
                    localObject1 = localSignatureTemplateInfo.l;
                    i1 = i2;
                    break label199;
                    i2 = 2130841877;
                    i1 = i2;
                    if (localSignatureTemplateInfo == null) {
                      break;
                    }
                    localObject1 = localSignatureTemplateInfo.m;
                    i1 = i2;
                    break label199;
                    i1 = i3;
                    if (localSignatureTemplateInfo == null) {
                      break;
                    }
                    localObject1 = localSignatureTemplateInfo.h;
                    i1 = i4;
                    break label199;
                    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getResources().getDrawable(i1);
                    if (paramInt2 == 9) {
                      localObject2 = new ColorDrawable(Color.parseColor("#dedede"));
                    }
                    localObject3 = localObject2;
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {
                      break label209;
                    }
                    try
                    {
                      localObject1 = new URL("sig_cover", (String)localObject1, Integer.toString(paramInt1));
                      localObject3 = localObject2;
                      if (localObject1 == null) {
                        break label209;
                      }
                      localObject3 = URLDrawable.URLDrawableOptions.obtain();
                      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramInt3;
                      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramInt4;
                      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
                      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
                      ((URLDrawable.URLDrawableOptions)localObject3).mUseSharpPImage = QQSharpPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
                      localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
                      ((URLDrawable)localObject1).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                      if (((URLDrawable)localObject1).getStatus() == 2) {
                        ((URLDrawable)localObject1).restartDownload();
                      }
                      localObject3 = localObject1;
                      if (((URLDrawable)localObject1).getStatus() != 1) {
                        break label209;
                      }
                      jdField_a_of_type_Boolean = true;
                      return (Drawable)localObject1;
                    }
                    catch (MalformedURLException localMalformedURLException)
                    {
                      for (;;)
                      {
                        localObject1 = localObject4;
                        if (QLog.isColorLevel())
                        {
                          QLog.d("SignatureManager", 2, localMalformedURLException.getMessage());
                          localObject1 = localObject4;
                        }
                      }
                    }
                  }
                  i1 = 2130841861;
                  localObject1 = null;
                  break label199;
                }
              }
            }
            break label199;
            localObject1 = null;
            break label199;
          }
          label1483:
          i1 = 2130841860;
          continue;
          label1491:
          i1 = 2130841860;
          localObject1 = null;
        }
      }
    }
  }
  
  public RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {}
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (localObject != null)
      {
        localObject = ((ExtensionInfo)localObject).getRichStatus();
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((RichStatus)localObject).feedsId, localObject);
        }
      }
      return (RichStatus)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    finally {}
  }
  
  public SignatureTemplateConfig.SignatureTemplateType a(int paramInt)
  {
    if ((jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType != null) && (jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length > paramInt)) {
      return jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[paramInt];
    }
    return null;
  }
  
  public SignatureTemplateInfo a(String paramString)
  {
    if (jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType != null)
    {
      int i1 = 0;
      while (i1 < jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length)
      {
        int i2 = 0;
        while (i2 < jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[i1].a.size())
        {
          SignatureTemplateInfo localSignatureTemplateInfo = (SignatureTemplateInfo)jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[i1].a.get(i2);
          if (localSignatureTemplateInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
            return localSignatureTemplateInfo;
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
    if (paramString.equals("0")) {
      return new SignatureTemplateInfo("0");
    }
    if (b == null)
    {
      b = a("0");
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
        if (QLog.isColorLevel()) {
          QLog.w("SignatureManager", 2, "check json config id=" + paramString);
        }
      }
    }
    return b;
  }
  
  public File a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = a(Integer.parseInt(paramString1), paramString2);
    paramString2 = new File(SignatureTemplateConfig.a(paramString1, paramString2));
    paramString1 = new DownloadTask(str, paramString2);
    paramString1.i = paramBoolean;
    paramString1.n = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (DownloaderFactory.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0))
    {
      if ((paramString2.exists()) && (!a(paramString2.getAbsolutePath()))) {
        paramString2.delete();
      }
    }
    else {
      paramString1 = new File(AppConstants.bj);
    }
    do
    {
      return paramString1;
      paramString1 = paramString2;
    } while (!SharpPUtil.isSharpPFile(paramString2));
    return QQSharpPUtil.a(paramString2);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      if (paramString != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface == null) {}
    do
    {
      return;
      localObject = a(Integer.parseInt(paramString1), paramString2);
    } while (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((String)localObject) != null);
    Object localObject = new DownloadTask((String)localObject, new File(SignatureTemplateConfig.a(paramString1, paramString2)));
    Bundle localBundle = new Bundle();
    localBundle.putInt("resType", 2);
    localBundle.putInt("dynamicType", paramInt);
    localBundle.putString("tplId", paramString1);
    localBundle.putString("fileName", paramString2);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
  }
  
  public void a(List paramList)
  {
    if (paramList != null) {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          RichStatus localRichStatus = (RichStatus)paramList.next();
          if (!TextUtils.isEmpty(localRichStatus.feedsId)) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localRichStatus.feedsId, localRichStatus);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    label123:
    label233:
    label354:
    do
    {
      do
      {
        return;
        if (paramBoolean1)
        {
          if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext())) {
            break label123;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SignatureManager", 2, "checkSigTplConfig no network");
          }
        }
        for (;;)
        {
          localObject1 = new File(g);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("sigResUpt", 0);
          paramBoolean1 = ((SharedPreferences)localObject2).getBoolean("sigTplUptFlag", false);
          if ((((File)localObject1).exists()) && (!paramBoolean1)) {
            break label354;
          }
          if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext())) {
            break label233;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SignatureManager", 2, "checkSigTplConfig download no network");
          return;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("sigResUpt", 0);
          long l1 = ((SharedPreferences)localObject1).getLong("sigTplUptTime", 0L);
          long l2 = NetConnInfoCenter.getServerTimeMillis();
          if ((l2 - l1 >= 3600000L) || (paramBoolean2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SignatureManager", 2, "checkSigTplConfig checkUpdate");
            }
            ClubContentUpdateHandler.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            ((SharedPreferences)localObject1).edit().putLong("sigTplUptTime", l2).commit();
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("SignatureManager", 2, "checkSigTplConfig checkUpdate shorter than 1 hour");
          }
        }
        if (paramBoolean1) {
          ((SharedPreferences)localObject2).edit().putBoolean("sigTplUptFlag", false).commit();
        }
        localObject1 = EmosmUtils.a("VIP_sig_cfg", IndividuationUrlHelper.a("signatureTemplate"));
      } while ((this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((String)localObject1) != null));
      Object localObject1 = new DownloadTask((String)localObject1, new File(g));
      ((DownloadTask)localObject1).n = false;
      ((DownloadTask)localObject1).l = true;
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("resType", 1);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject2);
      return;
    } while (jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType != null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public SignatureTemplateInfo b(String paramString)
  {
    if (jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType != null)
    {
      int i1 = 0;
      while (i1 < jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length)
      {
        int i2 = 0;
        while (i2 < jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[i1].a.size())
        {
          SignatureTemplateInfo localSignatureTemplateInfo = (SignatureTemplateInfo)jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[i1].a.get(i2);
          if (localSignatureTemplateInfo.jdField_a_of_type_JavaLangString.equals(paramString))
          {
            this.jdField_e_of_type_Int = i1;
            this.f = i2;
            return localSignatureTemplateInfo;
          }
          i2 += 1;
        }
        i1 += 1;
      }
      if (paramString.equals("0"))
      {
        this.jdField_e_of_type_Int = 0;
        this.f = 0;
        return new SignatureTemplateInfo("0");
      }
      return b("0");
    }
    return null;
  }
  
  public boolean b(String paramString)
  {
    paramString = SignatureTemplateConfig.a(paramString, "dynamic_aio");
    File localFile = new File(paramString);
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {}
    while (FileUtils.a(paramString).size() <= 0) {
      return false;
    }
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    case 3: 
    default: 
    case 1: 
      do
      {
        do
        {
          return true;
          paramMessage = SignatureTemplateConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        } while ((paramMessage == null) || (paramMessage.length <= 0));
        paramMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(2, paramMessage);
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramMessage);
      } while (!QLog.isColorLevel());
      QLog.d("SignatureManager", 2, "parse sign tpl done...");
      return true;
    }
    a(true, true);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType = null;
    b = null;
    a(null);
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SignatureManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */