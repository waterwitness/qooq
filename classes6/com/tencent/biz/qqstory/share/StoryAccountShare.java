package com.tencent.biz.qqstory.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import iqg;
import java.util.ArrayList;

public class StoryAccountShare
{
  public static final String a = "StoryAccountShare";
  static String h = "mqqapi://qstory/opencontent?";
  static String i = "http://story.now.qq.com/mobile/transfer.html?";
  static String j = "src_type=internal&version=1&unionid=%s&usertype=%d&userid=%d";
  public int a;
  boolean a;
  String b;
  public String c;
  String d;
  String e;
  String f;
  String g;
  String k;
  String l;
  String m;
  String n;
  String o;
  String p;
  String q = " ";
  String r = null;
  String s = null;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StoryAccountShare(UserInfo paramUserInfo)
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = paramUserInfo.headUrl;
    this.jdField_a_of_type_Int = paramUserInfo.type;
    this.c = paramUserInfo.unionId;
    this.f = ("分享" + paramUserInfo.nick + "的日迹[来自日迹，请使用新版手机QQ查看]");
    this.g = ("[日迹]分享" + paramUserInfo.nick + "的日迹");
    this.d = (paramUserInfo.nick + "的日迹");
    this.e = paramUserInfo.desc;
    this.l = String.format(j, new Object[] { paramUserInfo.unionId, Integer.valueOf(paramUserInfo.type), Long.valueOf(paramUserInfo.uid) });
    this.m = (i + this.l);
    if (paramUserInfo.type == 0)
    {
      this.q = "plugin";
      this.r = "mqqapi://qstory/opendiscovery?src_type=internal&version=1&key_from=4";
      this.s = this.r;
    }
    while (paramUserInfo.type != 1) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.q = "plugin";
    this.r = "mqqapi://qstory/open?src_type=internal&version=1";
    this.s = this.r;
  }
  
  private static Bitmap a(Bitmap paramBitmap)
  {
    Object localObject3 = null;
    localObject2 = null;
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        int i1 = paramBitmap.getWidth();
        int i2 = paramBitmap.getHeight();
        if (i1 * i2 > 8000)
        {
          double d1 = Math.sqrt(8000.0D / (i1 * i2));
          localObject1 = Bitmap.createScaledBitmap(paramBitmap, (int)(i1 * d1), (int)(i2 * d1), true);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        localObject1 = localObject2;
        localObject2 = localOutOfMemoryError2;
        System.gc();
        ((OutOfMemoryError)localObject2).printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("StoryAccountShare", 2, "scaleBitmapForWeChat ERROR OutOfMemoryError");
        }
        continue;
      }
      catch (Exception localException1)
      {
        localObject1 = localOutOfMemoryError2;
        if (QLog.isColorLevel()) {
          QLog.d("StoryAccountShare", 2, "scaleBitmapForWeChat ERROR e=" + localException1.getMessage());
        }
        continue;
      }
      try
      {
        paramBitmap.recycle();
        paramBitmap = (Bitmap)localObject1;
        localObject2 = null;
        localObject1 = paramBitmap;
        paramBitmap = (Bitmap)localObject2;
        if (localObject1 != null) {
          break label180;
        }
      }
      catch (Exception localException2)
      {
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        continue;
        paramBitmap = (Bitmap)localObject1;
        continue;
      }
      return paramBitmap;
      localObject2 = paramBitmap;
    }
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    Bitmap localBitmap = null;
    Object localObject;
    if (paramDrawable == null) {
      localObject = localBitmap;
    }
    for (;;)
    {
      return (Bitmap)localObject;
      int i1 = paramDrawable.getIntrinsicWidth();
      int i2 = paramDrawable.getIntrinsicWidth();
      localObject = localBitmap;
      if (i1 > 0)
      {
        localObject = localBitmap;
        if (i2 > 0) {
          try
          {
            localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
            localObject = localBitmap;
            if (localBitmap != null)
            {
              localObject = new Canvas(localBitmap);
              ((Canvas)localObject).drawColor(-1);
              paramDrawable.setBounds(0, 0, i1, i2);
              paramDrawable.draw((Canvas)localObject);
              return localBitmap;
            }
          }
          catch (OutOfMemoryError paramDrawable) {}
        }
      }
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    paramContext.getResources();
    String str1 = h + this.l + "&storysharefrom=qq&sharefromtype=" + 11;
    this.p = str1;
    this.o = str1;
    String str3;
    if (TextUtils.isEmpty(this.b))
    {
      str1 = null;
      str3 = this.d;
      if (!TextUtils.isEmpty(this.e)) {
        break label157;
      }
    }
    label157:
    for (String str2 = this.k;; str2 = this.e)
    {
      ShareMsgHelper.a(paramContext, 29, 81, "web_share", "", str1, str3, str2, this.g, this.k, "plugin", this.n, this.o, this.p, this.q, null, this.r, this.s, null, "日迹", null, this.f, this.jdField_a_of_type_Boolean);
      return;
      str1 = this.b;
      break;
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    int i2 = 1;
    if ((paramInt != 2) && (paramInt != 3)) {
      return;
    }
    paramContext = new StringBuilder().append(this.m).append("&storysharefrom=wechat&sharefromtype=");
    int i1;
    Object localObject;
    if (paramInt == 2)
    {
      i1 = 13;
      this.k = i1;
      if (TextUtils.isEmpty(this.b)) {
        break label265;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = 140;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = 140;
      if (this.jdField_a_of_type_Int != 1) {
        break label246;
      }
      paramContext = ThumbnailUrlHelper.a(this.b);
      label101:
      paramContext = URLDrawable.getDrawable(paramContext, (URLDrawable.URLDrawableOptions)localObject);
      if ((paramContext.getStatus() != 1) || (paramContext.getCurrDrawable() == null)) {
        break label265;
      }
    }
    label246:
    label265:
    for (paramContext = a(paramContext.getCurrDrawable());; paramContext = null)
    {
      localObject = paramContext;
      if (paramContext == null) {
        localObject = TroopShareUtility.a(ImageUtil.a(this.jdField_a_of_type_Int));
      }
      localObject = a((Bitmap)localObject);
      String str1 = String.valueOf(System.currentTimeMillis());
      paramContext = new iqg(this, str1, paramInt);
      WXShareHelper.a().a(paramContext);
      WXShareHelper localWXShareHelper = WXShareHelper.a();
      String str2 = this.d;
      if (TextUtils.isEmpty(this.e)) {}
      for (paramContext = this.k;; paramContext = this.e)
      {
        String str3 = this.k;
        i1 = i2;
        if (paramInt == 2) {
          i1 = 0;
        }
        localWXShareHelper.a(str1, str2, (Bitmap)localObject, paramContext, str3, i1);
        return;
        i1 = 14;
        break;
        paramContext = ThumbnailUrlHelper.b(this.b);
        break label101;
      }
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    Bundle localBundle = new Bundle();
    this.k = (this.m + "&storysharefrom=qzone&sharefromtype=" + 12);
    if (TextUtils.isEmpty(this.d))
    {
      localObject = this.k;
      localBundle.putString("title", (String)localObject);
      if (!TextUtils.isEmpty(this.e)) {
        break label173;
      }
    }
    label173:
    for (Object localObject = this.k;; localObject = this.e)
    {
      localBundle.putString("desc", (String)localObject);
      localBundle.putString("detail_url", this.k);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(this.b);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 0);
      if (QZoneShareManager.a(paramQQAppInterface, paramContext, localBundle, null)) {
        break label181;
      }
      QRUtils.a(1, 2131369679);
      return;
      localObject = this.d;
      break;
    }
    label181:
    StoryReportor.a("share_uin", "qzone_suc", 0, this.jdField_a_of_type_Int, new String[] { this.c });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\share\StoryAccountShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */