package com.tencent.mobileqq.filemanager.util;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilePicURLDrawlableHelper
{
  public static final float a = 0.5625F;
  public static int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "FilePicURLDrawlableHelper<FileAssistant>";
  private static List jdField_a_of_type_JavaUtilList = new ArrayList();
  public static final float b = 1.7777778F;
  public static int b;
  public static int c;
  public static int d;
  public static final int e;
  public static final int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = AIOUtils.a(232.0F, BaseApplicationImpl.getContext().getResources());
    b = AIOUtils.a(130.0F, BaseApplicationImpl.getContext().getResources());
    if (BaseChatItemLayout.i > 0)
    {
      jdField_a_of_type_Int = BaseChatItemLayout.i;
      b = (int)(BaseChatItemLayout.i * 0.5625F);
    }
    c = jdField_a_of_type_Int;
    d = b;
    float f1 = BaseApplicationImpl.a.getResources().getDisplayMetrics().density;
    if (f1 != 0.0F)
    {
      c = (int)(jdField_a_of_type_Int / f1);
      d = (int)(b / f1);
    }
    e = b;
    f = jdField_a_of_type_Int;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      paramInt2 = 0;
      return paramInt2;
    }
    int j = 1;
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      i >>= 1;
      paramInt2 >>= 1;
      if ((i < paramInt3) || (paramInt2 < paramInt3))
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= 1) {
          break;
        }
        return 1;
      }
      paramInt1 *= 2;
    }
  }
  
  public static int a(URL paramURL)
  {
    try
    {
      int i = Integer.parseInt(paramURL.getFile().split("\\|")[1]);
      return i;
    }
    catch (Exception paramURL) {}
    return 0;
  }
  
  public static long a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      if (jdField_a_of_type_JavaUtilList.contains(paramString)) {
        return -1L;
      }
      jdField_a_of_type_JavaUtilList.add(paramString);
      return 1L;
    }
  }
  
  private static FilePicURLDrawlableHelper.Type a(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 1;
    int k = jdField_a_of_type_Int;
    int m = b;
    if (paramInt1 > k) {
      if (a(paramInt1, paramInt2))
      {
        paramInt2 = 1;
        paramInt1 = j;
      }
    }
    for (;;)
    {
      FilePicURLDrawlableHelper.Type localType = new FilePicURLDrawlableHelper.Type();
      localType.jdField_a_of_type_Int = paramInt2;
      localType.b = paramInt1;
      return localType;
      paramInt1 = 2;
      paramInt2 = 2;
      continue;
      if ((paramInt1 <= k) && (paramInt1 > m))
      {
        if (paramInt2 > k)
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt2 = 1;
            paramInt1 = 3;
            continue;
          }
          paramInt1 = 4;
          paramInt2 = 2;
          continue;
        }
        if ((paramInt2 <= k) && (paramInt2 > m))
        {
          paramInt1 = 5;
          paramInt2 = 3;
        }
      }
      else if ((paramInt1 <= m) && (paramInt1 > 0))
      {
        if (paramInt2 > k)
        {
          paramInt1 = 6;
          paramInt2 = 4;
          continue;
        }
        if ((paramInt2 <= k) && (paramInt2 > m))
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt1 = 7;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 8;
          paramInt2 = 3;
          continue;
        }
        if ((paramInt2 <= m) && (paramInt2 > 0))
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt1 = 9;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 10;
          paramInt2 = 3;
          continue;
        }
      }
      paramInt1 = 0;
      paramInt2 = i;
    }
  }
  
  public static FilePicURLDrawlableHelper.imgInfo a(int paramInt1, int paramInt2, FilePicURLDrawlableHelper.Type paramType, boolean paramBoolean)
  {
    int i1 = jdField_a_of_type_Int;
    int i2 = b;
    int j;
    int i;
    int k;
    int m;
    int i3;
    int n;
    switch (paramType.b)
    {
    case 2: 
    case 4: 
    case 5: 
    default: 
      j = paramInt2;
      i = paramInt1;
      k = paramInt2;
      m = paramInt1;
      if (i > j)
      {
        i3 = i;
        n = j;
        switch (paramType.jdField_a_of_type_Int)
        {
        default: 
          paramType = new FilePicURLDrawlableHelper.imgInfo();
          paramType.jdField_a_of_type_Int = paramInt1;
          paramType.b = paramInt2;
          return paramType;
        }
      }
      break;
    case 1: 
    case 3: 
    case 6: 
      label79:
      if (paramInt1 > paramInt2)
      {
        i = paramInt2;
        label140:
        k = (int)(i * 1.7777778F);
        if (paramInt1 <= paramInt2) {
          break label199;
        }
        j = i;
        label158:
        i = k;
        if (k > paramInt1) {
          i = paramInt1;
        }
        if (j <= paramInt2) {
          break label474;
        }
      }
      break;
    }
    for (;;)
    {
      j = paramInt2;
      k = paramInt2;
      m = i;
      paramInt1 = i;
      break;
      i = paramInt1;
      break label140;
      label199:
      j = k;
      k = i;
      break label158;
      i3 = j;
      n = i;
      break label79;
      float f1 = i2 / (n * 1.0F);
      n = (int)(i3 * f1);
      if (m > paramInt1) {}
      for (;;)
      {
        if (k > paramInt2) {}
        for (;;)
        {
          k = Math.round(paramInt1 * f1);
          m = Math.round(paramInt2 * f1);
          if (i > j)
          {
            paramInt2 = i2;
            i = i1;
            label287:
            paramInt1 = i;
            if (i > k) {
              paramInt1 = k;
            }
            if (paramInt2 <= m) {
              break label459;
            }
            paramInt2 = m;
          }
          label405:
          label441:
          label459:
          for (;;)
          {
            break;
            paramInt2 = i1;
            i = i2;
            break label287;
            f1 = i1 / (i3 * 1.0F);
            n = (int)(n * f1);
            if ((i <= j) || (m > paramInt1)) {}
            for (;;)
            {
              if (k > paramInt2) {}
              for (;;)
              {
                paramInt1 = Math.round(paramInt1 * f1);
                paramInt2 = Math.round(paramInt2 * f1);
                break;
                break;
                k = (int)(n * 1.7777778F);
                if (i > j)
                {
                  i = n;
                  j = k;
                  if (k > paramInt1) {
                    j = paramInt1;
                  }
                  if (i <= paramInt2) {
                    break label441;
                  }
                }
                for (;;)
                {
                  paramInt1 = j;
                  break;
                  i = k;
                  k = n;
                  break label405;
                  paramInt2 = i;
                }
                paramInt2 = k;
              }
              paramInt1 = m;
            }
          }
          paramInt2 = k;
        }
        paramInt1 = m;
      }
      label474:
      paramInt2 = j;
    }
  }
  
  public static FilePicURLDrawlableHelper.imgInfo a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i;
    if (paramInt1 > paramInt2) {
      i = paramInt2;
    }
    for (int j = paramInt1;; j = paramInt2)
    {
      FilePicURLDrawlableHelper.Type localType = a(i, j);
      i = a(paramInt1, paramInt2, jdField_a_of_type_Int);
      return a(paramInt1 * i, i * paramInt2, localType, false);
      i = paramInt1;
    }
  }
  
  public static FilePicURLDrawlableHelper.imgInfo a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    FilePicURLDrawlableHelper.imgInfo localimgInfo = new FilePicURLDrawlableHelper.imgInfo();
    int j;
    int i;
    float f1;
    int k;
    if (FileUtils.b(paramFileManagerEntity.strMiddleThumPath))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramFileManagerEntity.strMiddleThumPath, localOptions);
      localimgInfo.jdField_a_of_type_Int = localOptions.outWidth;
      localimgInfo.b = localOptions.outHeight;
      paramFileManagerEntity = localimgInfo;
      j = paramFileManagerEntity.jdField_a_of_type_Int;
      i = paramFileManagerEntity.b;
      f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      if ((j >= d) && (i >= d)) {
        break label283;
      }
      if (j >= i) {
        break label232;
      }
      f1 = b / j;
      k = b;
      int m = (int)(f1 * i + 0.5F);
      i = m;
      j = k;
      if (m > jdField_a_of_type_Int)
      {
        i = jdField_a_of_type_Int;
        j = k;
      }
    }
    for (;;)
    {
      paramFileManagerEntity.jdField_a_of_type_Int = j;
      paramFileManagerEntity.b = i;
      return paramFileManagerEntity;
      if ((paramFileManagerEntity.imgWidth > 0) && (paramFileManagerEntity.imgHeight > 0)) {
        j = paramFileManagerEntity.imgWidth;
      }
      for (i = paramFileManagerEntity.imgHeight;; i = f)
      {
        paramFileManagerEntity = a(j, i, false);
        break;
        j = e;
      }
      label232:
      j = (int)(b / i * j + 0.5F);
      i = j;
      if (j > jdField_a_of_type_Int) {
        i = jdField_a_of_type_Int;
      }
      k = b;
      j = i;
      i = k;
      continue;
      label283:
      if ((j >= c) || (i >= c)) {
        break label324;
      }
      j = (int)(j * f1 + 0.5F);
      i = (int)(f1 * i + 0.5F);
    }
    label324:
    if (j > i)
    {
      f1 = jdField_a_of_type_Int / j;
      label340:
      if (j <= i) {
        break label399;
      }
    }
    label399:
    for (float f2 = b / i;; f2 = b / j)
    {
      f1 = Math.max(f1, f2);
      j = (int)(j * f1 + 0.5F);
      i = (int)(f1 * i + 0.5F);
      break;
      f1 = jdField_a_of_type_Int / i;
      break label340;
    }
  }
  
  public static String a(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-dsc-";
      continue;
      str = "minni-dsc-";
      continue;
      str = "small-dsc-";
      continue;
      str = "middle-dsc-";
      continue;
      str = "large-dsc-";
      continue;
      str = "qlarge-dsc-";
      continue;
      str = "xlarge-dsc-";
      continue;
      str = "qxlarge-dsc-";
      continue;
      str = "screen-dsc-";
    }
  }
  
  public static String a(String paramString)
  {
    if (!FileUtil.b(paramString)) {}
    label144:
    for (;;)
    {
      return null;
      String str1 = HexUtil.a(FileManagerUtil.c(paramString));
      a();
      str1 = FMSettings.a().d() + a(5, str1);
      String str2 = str1 + "_original_" + ".tmp";
      if (FileUtils.b(paramString)) {}
      for (;;)
      {
        if (paramString == null) {
          break label144;
        }
        try
        {
          if (!FileUtils.b(str2)) {
            Utils.a(paramString, str2, true, "", 1);
          }
          if ((!FileUtils.b(str2)) || (FileUtils.a(new File(str2), new File(str1)) != true)) {
            break;
          }
          return str1;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
          }
        }
        paramString = null;
      }
    }
  }
  
  private static URL a(int paramInt1, int paramInt2, FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = a(paramInt1, paramInt2, false);
    int j = ((FilePicURLDrawlableHelper.imgInfo)localObject).jdField_a_of_type_Int;
    int i = ((FilePicURLDrawlableHelper.imgInfo)localObject).b;
    float f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    if ((j < b) || (i < b)) {
      if (j < i)
      {
        f1 = b / j;
        j = b;
        i = (int)(f1 * i + 0.5F);
        paramInt1 = i;
        paramInt2 = j;
        if (i > jdField_a_of_type_Int)
        {
          paramInt1 = jdField_a_of_type_Int;
          paramInt2 = j;
        }
        if (!FileUtils.b(paramFileManagerEntity.strMiddleThumPath)) {
          break label302;
        }
        localObject = AsyncImageView.a(paramFileManagerEntity.strMiddleThumPath, paramInt2, paramInt1, new File(paramFileManagerEntity.strMiddleThumPath), false, false, true);
        paramFileManagerEntity = (FileManagerEntity)localObject;
        if (localObject != null) {
          break label340;
        }
      }
    }
    label230:
    label289:
    label302:
    do
    {
      return null;
      paramInt2 = (int)(b / i * j + 0.5F);
      paramInt1 = paramInt2;
      if (paramInt2 > jdField_a_of_type_Int) {
        paramInt1 = jdField_a_of_type_Int;
      }
      i = b;
      paramInt2 = paramInt1;
      paramInt1 = i;
      break;
      if (j < jdField_a_of_type_Int)
      {
        paramInt2 = j;
        paramInt1 = i;
        if (i < jdField_a_of_type_Int) {
          break;
        }
      }
      if (j > i)
      {
        f1 = jdField_a_of_type_Int / j;
        if (j <= i) {
          break label289;
        }
      }
      for (float f2 = b / i;; f2 = b / j)
      {
        f1 = Math.max(f1, f2);
        paramInt2 = (int)(j * f1 + 0.5F);
        paramInt1 = (int)(f1 * i + 0.5F);
        break;
        f1 = jdField_a_of_type_Int / i;
        break label230;
      }
      if (!FileUtils.b(paramFileManagerEntity.strLargeThumPath)) {
        break label342;
      }
      paramFileManagerEntity = AsyncImageView.a(paramFileManagerEntity.strLargeThumPath, paramInt2, paramInt1, new File(paramFileManagerEntity.strLargeThumPath), false, false, true);
    } while (paramFileManagerEntity == null);
    for (;;)
    {
      label340:
      return paramFileManagerEntity;
      label342:
      if (FileUtils.b(paramFileManagerEntity.getFilePath()))
      {
        localObject = AsyncImageView.a(paramFileManagerEntity.getFilePath(), paramInt2, paramInt1, new File(paramFileManagerEntity.getFilePath()), false, false, true);
        paramFileManagerEntity = (FileManagerEntity)localObject;
        if (localObject == null) {
          return null;
        }
      }
      else
      {
        paramFileManagerEntity = null;
      }
    }
  }
  
  public static URL a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    int j = 0;
    int i = j;
    if (paramFileManagerEntity.getCloudType() == 3)
    {
      i = j;
      if (!FileUtils.b(paramFileManagerEntity.strMiddleThumPath)) {
        i = 1;
      }
    }
    if (i != 0) {
      paramFileManagerEntity.strMiddleThumPath = a(paramFileManagerEntity.getFilePath());
    }
    return b(paramFileManagerEntity);
  }
  
  public static void a()
  {
    File localFile = new File(FMSettings.a().d());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    label27:
    String str1;
    String str2;
    do
    {
      return;
      if (!FileUtils.b(paramFileManagerEntity.strLargeThumPath)) {
        break label186;
      }
      if (paramFileManagerEntity.Uuid == null) {
        break;
      }
      localObject1 = paramFileManagerEntity.Uuid;
      localObject1 = ((String)localObject1).replace("/", "");
      a();
      str1 = FMSettings.a().d() + a(5, (String)localObject1);
      str2 = str1 + "_750_" + ".tmp";
    } while (a(str2) == -1L);
    if (FileUtils.b(paramFileManagerEntity.strLargeThumPath)) {}
    label186:
    Object localObject2;
    for (Object localObject1 = paramFileManagerEntity.strLargeThumPath;; localObject2 = null)
    {
      if (localObject1 == null)
      {
        a(str2);
        return;
        localObject1 = paramFileManagerEntity.fileName;
        break label27;
      }
      try
      {
        Utils.a((String)localObject1, str2, true, "", 1);
        if ((FileUtils.b(str2)) && (FileUtils.a(new File(str2), new File(str1)) == true)) {
          paramFileManagerEntity.strMiddleThumPath = str1;
        }
        a(str2);
        localObject1 = (QQAppInterface)BaseApplicationImpl.a().a();
        if ((localObject1 == null) || (!FileUtils.b(paramFileManagerEntity.strMiddleThumPath))) {
          break;
        }
        ((QQAppInterface)localObject1).a().a(true, 3, null);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a(str2);
          localException.printStackTrace();
        }
      }
    }
  }
  
  private static void a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      jdField_a_of_type_JavaUtilList.remove(paramString);
      return;
    }
  }
  
  public static boolean a()
  {
    boolean bool = SettingCloneUtil.readValue(BaseApplicationImpl.getContext(), null, BaseApplicationImpl.getContext().getString(2131367826), "qqsetting_auto_receive_pic_key", true);
    return (NetworkUtil.b(BaseApplicationImpl.getContext()) == 1) || (bool);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt2 > (int)(paramInt1 * 1.7777778F);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.status == 16) {}
    while ((paramFileManagerEntity.cloudType == 1) && (FileManagerUtil.a(paramFileManagerEntity))) {
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("[一-龥]").matcher(paramString).find();
  }
  
  public static int b(URL paramURL)
  {
    try
    {
      int i = Integer.parseInt(paramURL.getFile().split("\\|")[2]);
      return i;
    }
    catch (Exception paramURL) {}
    return 0;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    paramString = paramString.replaceAll("【", "[").replaceAll("】", "]").replaceAll("！", "!").replaceAll("：", ":");
    return Pattern.compile("[『』-]").matcher(paramString).replaceAll("").trim();
  }
  
  public static URL b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    do
    {
      return null;
      if (!FileUtils.b(paramFileManagerEntity.strMiddleThumPath)) {
        break;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramFileManagerEntity.strMiddleThumPath, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      paramFileManagerEntity = AsyncImageView.a(paramFileManagerEntity.strMiddleThumPath, i, j, new File(paramFileManagerEntity.strMiddleThumPath), false, false, true);
    } while (paramFileManagerEntity == null);
    for (;;)
    {
      return paramFileManagerEntity;
      paramFileManagerEntity = null;
    }
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    label27:
    String str1;
    String str2;
    do
    {
      return;
      if (!FileUtils.b(paramFileManagerEntity.strMiddleThumPath)) {
        break label186;
      }
      if (paramFileManagerEntity.Uuid == null) {
        break;
      }
      localObject1 = paramFileManagerEntity.Uuid;
      localObject1 = ((String)localObject1).replace("/", "");
      a();
      str1 = FMSettings.a().d() + a(5, (String)localObject1);
      str2 = str1 + "_384_" + ".tmp";
    } while (a(str2) == -1L);
    if (FileUtils.b(paramFileManagerEntity.strMiddleThumPath)) {}
    label186:
    Object localObject2;
    for (Object localObject1 = paramFileManagerEntity.strMiddleThumPath;; localObject2 = null)
    {
      if (localObject1 == null)
      {
        a(str2);
        return;
        localObject1 = paramFileManagerEntity.fileName;
        break label27;
      }
      try
      {
        Utils.a((String)localObject1, str2, true, "", 1);
        if ((FileUtils.b(str2)) && (FileUtils.a(new File(str2), new File(str1)) == true)) {
          paramFileManagerEntity.strMiddleThumPath = str1;
        }
        a(str2);
        localObject1 = (QQAppInterface)BaseApplicationImpl.a().a();
        if ((localObject1 == null) || (!FileUtils.b(paramFileManagerEntity.strMiddleThumPath))) {
          break;
        }
        ((QQAppInterface)localObject1).a().a(true, 3, null);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a(str2);
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.imgHeight <= 0) || (paramFileManagerEntity.imgWidth <= 0)) {
      return true;
    }
    int i;
    if (paramFileManagerEntity.imgWidth > paramFileManagerEntity.imgHeight) {
      i = paramFileManagerEntity.imgWidth;
    }
    for (int j = paramFileManagerEntity.imgHeight; a(j, i); j = paramFileManagerEntity.imgWidth)
    {
      return true;
      i = paramFileManagerEntity.imgHeight;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\FilePicURLDrawlableHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */