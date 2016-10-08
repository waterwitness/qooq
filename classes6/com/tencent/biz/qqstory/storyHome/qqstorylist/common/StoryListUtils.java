package com.tencent.biz.qqstory.storyHome.qqstorylist.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.WatchVideoHandler;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.RecentStoryFinishEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.ShieldFriendStoryEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.image.RegionDrawable;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class StoryListUtils
{
  public static final int a = 1000;
  public static final String a = "Q.qqstory.home.StoryListUtils";
  public static final int[] a = { 120, 200, 320, 512, 640, 750, 1000 };
  public static String b = Integer.toString(a[0]);
  public static final String c = "/qqstory_pic/";
  public static final String d = "http://p.qpic.cn";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static float a(long paramLong)
  {
    return (float)(NetConnInfoCenter.getServerTimeMillis() - paramLong) / 3600000.0F;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 1: 
    case 2: 
    case 4: 
      return 1;
    case 3: 
    case 6: 
      return 2;
    }
    return 3;
  }
  
  public static Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    if (paramDrawable == null) {
      return null;
    }
    int i;
    Object localObject;
    if (paramInt1 > 0)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {}
    }
    else
    {
      if (!(paramDrawable instanceof RegionDrawable)) {
        break label113;
      }
      localObject = (RegionDrawable)paramDrawable;
      i = ((RegionDrawable)localObject).getIntrinsicWidth();
      paramInt1 = ((RegionDrawable)localObject).getIntrinsicHeight();
    }
    try
    {
      localObject = Bitmap.createBitmap(i, paramInt1, Bitmap.Config.ARGB_8888);
      if (localObject != null)
      {
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        paramDrawable.setBounds(0, 0, i, paramInt1);
        paramDrawable.draw(localCanvas);
      }
      SLog.a("Q.qqstory.home.StoryListUtils", "drawabletoBitmap:width=%d,height=%d,cost time=%d", Integer.valueOf(i), Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l));
      return (Bitmap)localObject;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      label113:
      SLog.e("Q.qqstory.home.StoryListUtils", "drawabletoBitmap out off memory width=" + i + ",height=" + paramInt1);
    }
    return null;
    return null;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    float f2 = 1.0F;
    float f1 = 0.0F;
    SLog.b("Q.qqstory.home.StoryListUtils", paramString + ",convertToBitmap,width=" + paramInt1 + ",height=" + paramInt2);
    long l = System.currentTimeMillis();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      f1 = 1.0F;
    }
    for (;;)
    {
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = ((int)Math.max(f2, f1));
      try
      {
        localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        paramString = (String)localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          SLog.d("Q.qqstory.home.StoryListUtils", "oom %s", new Object[] { paramString });
          paramString = null;
        }
        SLog.a("Q.qqstory.home.StoryListUtils", "convertToBitmap,width=%d,height=%d,costTime=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis() - l));
        return paramString;
      }
      if (paramString == null)
      {
        SLog.a("Q.qqstory.home.StoryListUtils", "convertToBitmap,width=%d,height=%d,costTime=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis() - l));
        return null;
        if ((i <= paramInt1) && (j <= paramInt2)) {
          break label238;
        }
        f2 = i / paramInt1;
        f1 = j / paramInt2;
      }
      label238:
      f2 = 0.0F;
    }
  }
  
  public static QQUserUIItem a(AppInterface paramAppInterface, long paramLong, boolean paramBoolean)
  {
    QQUserUIItem localQQUserUIItem = new QQUserUIItem();
    localQQUserUIItem.uid = paramLong;
    localQQUserUIItem.specialCare = paramBoolean;
    paramAppInterface = ((FriendsManager)paramAppInterface.getManager(50)).c(String.valueOf(paramLong));
    if (paramAppInterface == null) {
      return null;
    }
    localQQUserUIItem.nickName = paramAppInterface.name;
    localQQUserUIItem.remark = paramAppInterface.remark;
    return localQQUserUIItem;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "刚刚";
    case 0: 
      return "年";
    case 1: 
      return "月";
    case 2: 
      return "天";
    case 3: 
      return "小时";
    case 4: 
      return "分钟";
    }
    return "秒";
  }
  
  public static String a(long paramLong)
  {
    Object localObject = Calendar.getInstance();
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = (l1 - paramLong) / 1000L;
    if (l2 < 60L) {
      return "刚刚";
    }
    if (l2 > 86400L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      ((Calendar)localObject).setTimeInMillis(paramLong);
      i = ((Calendar)localObject).get(2) + 1;
      j = ((Calendar)localObject).get(5);
      k = ((Calendar)localObject).get(11);
      m = ((Calendar)localObject).get(12);
      ((Calendar)localObject).get(13);
      if (m < 10) {
        localStringBuilder.append(String.format("%d月%d日 %d:0%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append(String.format("%d月%d日 %d:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
      }
    }
    ((Calendar)localObject).setTimeInMillis(paramLong);
    int i = ((Calendar)localObject).get(11);
    int j = ((Calendar)localObject).get(12);
    int k = ((Calendar)localObject).get(13);
    ((Calendar)localObject).setTimeInMillis(l1);
    int m = ((Calendar)localObject).get(11);
    int n = ((Calendar)localObject).get(12);
    int i1 = ((Calendar)localObject).get(13);
    localObject = new StringBuilder();
    if ((m < i) || ((m == i) && (n < j)) || ((m == i) && (j == n) && (i1 < k))) {
      ((StringBuilder)localObject).append("昨天 ");
    }
    if (j < 10) {
      ((StringBuilder)localObject).append(String.format("%d:0%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    for (;;)
    {
      return ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).append(String.format("%d:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!a(paramString));
    paramString = b(paramString);
    return paramString + b;
  }
  
  public static void a(long paramLong)
  {
    SLog.b("Q.qqstory.home.StoryListUtils", "reportRecentStoryHaveFinish uin=" + paramLong);
    RecentStoryFinishEvent localRecentStoryFinishEvent = new RecentStoryFinishEvent();
    localRecentStoryFinishEvent.a = paramLong;
    Dispatchers.get().dispatch(localRecentStoryFinishEvent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = ((QQStoryManager)paramQQAppInterface.getManager(180)).a(false);
    paramQQAppInterface = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramQQAppInterface.add(((QQStoryUserInfo)((Iterator)localObject).next()).uin);
    }
    a(paramQQAppInterface);
  }
  
  public static void a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    paramString = new File(paramString);
    paramString.deleteOnExit();
    try
    {
      paramString = new FileOutputStream(paramString);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, paramString);
      paramString.flush();
      paramString.close();
      return;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      paramString.printStackTrace();
      return;
    }
    finally {}
  }
  
  public static void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    SLog.b("Q.qqstory.home.StoryListUtils", "reportShieldFriendStory:" + paramArrayList.size());
    ShieldFriendStoryEvent localShieldFriendStoryEvent = new ShieldFriendStoryEvent();
    localShieldFriendStoryEvent.a = paramArrayList;
    Dispatchers.get().dispatch(localShieldFriendStoryEvent);
  }
  
  public static boolean a()
  {
    return ((FriendsManager)QQStoryContext.a().a().getManager(50)).e();
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString.length() >= "http://p.qpic.cn".length() + "/qqstory_pic/".length()) && (paramString.startsWith("/qqstory_pic/", "http://p.qpic.cn".length()))) {
      return true;
    }
    return paramString.contains("/qqstory_pic/");
  }
  
  public static String[] a(Context paramContext, long paramLong)
  {
    paramContext = new String[2];
    long l = NetConnInfoCenter.getServerTimeMillis() - paramLong;
    if (l < 60000L)
    {
      paramContext[0] = "1";
      paramContext[1] = "分钟消失";
      return paramContext;
    }
    if (l < 86400000L)
    {
      paramContext[0] = String.valueOf((int)(24L - l / 3600000L));
      paramContext[1] = "小时消失";
      return paramContext;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(2) + 1;
    int j = localCalendar.get(5);
    int k = localCalendar.get(11);
    int m = localCalendar.get(12);
    localCalendar.get(13);
    if (m < 10) {
      localStringBuilder.append(String.format("%d月%d日 %d:0%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
    }
    for (;;)
    {
      paramContext[0] = localStringBuilder.toString();
      paramContext[1] = "";
      return paramContext;
      localStringBuilder.append(String.format("%d月%d日 %d:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
    }
  }
  
  public static String b(String paramString)
  {
    if (paramString.endsWith("/")) {
      return paramString;
    }
    int k = paramString.lastIndexOf("/");
    String str;
    int j;
    if ((k >= 0) && (k < paramString.length() - 1))
    {
      str = paramString.substring(k + 1, paramString.length());
      j = str.length() - 1;
      i = 0;
      if (j >= 0) {
        if (Character.isDigit(str.charAt(j))) {
          break label111;
        }
      }
    }
    for (int i = 0;; i = 0)
    {
      str = paramString;
      if (i != 0) {
        str = paramString.substring(0, k);
      }
      return str + "/";
      label111:
      j -= 1;
      i = 1;
      break;
    }
  }
  
  public static void b(long paramLong)
  {
    SLog.b("Q.qqstory.home.StoryListUtils", "reportLiveVideoHaveRead uid=" + paramLong);
    new WatchVideoHandler().a("0", paramLong, true);
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str;
    if (paramString.startsWith("file://")) {
      str = paramString.replaceFirst("file://", "");
    }
    for (;;)
    {
      return new File(str).exists();
      str = paramString;
      if (paramString.startsWith("file:")) {
        str = paramString.replaceFirst("file:", "");
      }
    }
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 0)
      {
        int i = paramString.lastIndexOf('.');
        str = paramString;
        if (i > -1)
        {
          str = paramString;
          if (i < paramString.length()) {
            str = paramString.substring(0, i);
          }
        }
      }
    }
    return str;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\common\StoryListUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */