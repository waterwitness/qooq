package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SystemAndEmojiEmoticonInfo
  extends EmoticonInfo
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int h = 3;
  public static final int k = -1;
  public static final String k = "SystemAndEmojiEmoticonInfo";
  public static final int l;
  public static final String l = "常用";
  public static final int m;
  public static final String m = "全部";
  public static final String n = "emoji";
  private Drawable a;
  public boolean a;
  public int i;
  public int j;
  public String o;
  
  static
  {
    int i2 = 0;
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    int i3 = SystemEmoticonInfo.a.length / 20;
    if (SystemEmoticonInfo.a.length % 20 == 0)
    {
      i1 = 0;
      l = i1 + i3;
      i3 = EmojiEmoticonInfo.jdField_b_of_type_Int / 20;
      if (EmojiEmoticonInfo.jdField_b_of_type_Int % 20 != 0) {
        break label62;
      }
    }
    label62:
    for (int i1 = i2;; i1 = 1)
    {
      m = i3 + i1;
      return;
      i1 = 1;
      break;
    }
  }
  
  public SystemAndEmojiEmoticonInfo(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    this.c = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
    this.o = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplication.getContext().getResources().getDrawable(2130837556);
      return;
    }
    catch (Exception paramString)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "SystemAndEmojiEmoticonInfo getdrawable exception e: = " + paramString.getMessage());
    }
  }
  
  public static List a()
  {
    ArrayList localArrayList = new ArrayList(SystemEmoticonInfo.a.length + EmojiEmoticonInfo.jdField_b_of_type_Int);
    int i2 = EmojiEmoticonInfo.jdField_b_of_type_Int % 20;
    int i1 = EmojiEmoticonInfo.jdField_b_of_type_Int - 1;
    while (i1 >= EmojiEmoticonInfo.jdField_b_of_type_Int - i2)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i1, "", false));
      i1 -= 1;
    }
    i1 = 0;
    while (i1 < 20 - i2)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
      i1 += 1;
    }
    i1 = EmojiEmoticonInfo.jdField_b_of_type_Int - i2 - 1;
    while (i1 >= 0)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i1, "", false));
      i1 -= 1;
    }
    i2 = SystemEmoticonInfo.a.length;
    i1 = 0;
    while (i1 < i2)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, SystemEmoticonInfo.a[i1], "", false));
      i1 += 1;
    }
    return localArrayList;
  }
  
  public static List a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getEmoticonList app = null");
      return null;
    }
    ArrayList localArrayList = new ArrayList(SystemEmoticonInfo.a.length + EmojiEmoticonInfo.jdField_b_of_type_Int);
    int i1 = 0;
    while (i1 < 7)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, "常用", false));
      i1 += 1;
    }
    paramQQAppInterface = ((CommonUsedSystemEmojiManager)paramQQAppInterface.getManager(171)).a();
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemAndEmojiEmoticonInfo", 2, "getEmoticonList commonusedsize = " + paramQQAppInterface.size());
      }
      i1 = paramQQAppInterface.size();
      if (i1 <= 21) {
        break label541;
      }
      i1 = 21;
    }
    label541:
    for (;;)
    {
      int i2 = 0;
      while (i2 < i1)
      {
        EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramQQAppInterface.get(i2);
        int i3 = 1;
        if (localSmallYellowItem.type.get() == 2) {
          i3 = 2;
        }
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, i3, localSmallYellowItem.id.get(), "", true));
        i2 += 1;
      }
      if (i1 < 21)
      {
        i2 = i1 % 7;
        if (i2 != 0)
        {
          i1 = 0;
          while (i1 < 7 - i2)
          {
            localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
            i1 += 1;
            continue;
            QLog.e("SystemAndEmojiEmoticonInfo", 1, "CommonlyUsedSystemEmoji IS NULL");
          }
        }
      }
      i1 = 0;
      while (i1 < 7)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, "全部", false));
        i1 += 1;
      }
      i2 = SystemEmoticonInfo.a.length;
      i1 = 0;
      while (i1 < i2)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, SystemEmoticonInfo.a[i1], "", false));
        i1 += 1;
      }
      i2 = SystemEmoticonInfo.a.length % 7;
      if (i2 > 0)
      {
        i1 = 0;
        while (i1 < i2)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
          i1 += 1;
        }
      }
      i1 = 0;
      while (i1 < 7)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, "emoji", false));
        i1 += 1;
      }
      i1 = 0;
      while (i1 < EmojiEmoticonInfo.jdField_b_of_type_Int)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i1, "", false));
        i1 += 1;
      }
      i2 = EmojiEmoticonInfo.jdField_b_of_type_Int % 7;
      if (i2 > 0)
      {
        i1 = 0;
        while (i1 < i2)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
          i1 += 1;
        }
      }
      return localArrayList;
    }
  }
  
  public Drawable a(int paramInt)
  {
    int i1;
    if (1 == this.i)
    {
      if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_b_of_type_Int)) {
        throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
      }
      i1 = EmotcationConstants.jdField_b_of_type_ArrayOfInt[paramInt];
    }
    while (i1 == -1)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getSystemEmojiStaticImg index error 11; index = " + paramInt);
      return null;
      if ((2 == this.i) && (this.j != -1))
      {
        if (paramInt < 0) {
          throw new IllegalArgumentException("invaid emoji index: " + paramInt);
        }
        if ((paramInt >= 0) && (paramInt < EmotcationConstants.e)) {
          i1 = 2130839808 + paramInt;
        } else {
          QLog.e("SystemAndEmojiEmoticonInfo", 1, "getSystemEmojiStaticImg index error; index = " + paramInt);
        }
      }
      else
      {
        i1 = -1;
      }
    }
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "RESOURCE_IMG", i1 + "");
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      return URLDrawable.getDrawable(localURL, localURLDrawableOptions);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getSystemEmojiStaticImg url exception e = " + localMalformedURLException.getMessage());
    }
    return null;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return a(this.j);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if ((this.i == 2) && (this.j == -1)) {
      return;
    }
    int i1 = paramEditText.getSelectionStart();
    int i2 = paramEditText.getSelectionEnd();
    paramSessionInfo = paramEditText.getEditableText();
    if (this.i == 1)
    {
      paramContext = TextUtils.b(this.j);
      label51:
      paramSessionInfo.replace(i1, i2, paramContext);
      paramEditText.requestFocus();
      paramContext = new EmosmPb.SmallYellowItem();
      paramContext.id.set(this.j);
      if (this.i != 1) {
        break label289;
      }
    }
    label289:
    for (i1 = 1;; i1 = 2)
    {
      paramContext.type.set(i1);
      long l1 = System.currentTimeMillis();
      paramContext.ts.set(l1);
      if (QLog.isColorLevel()) {
        QLog.d("SystemAndEmojiEmoticonInfo", 2, "send saveemoji type = " + i1 + ";id = " + this.j + ";ts = " + l1);
      }
      if (paramQQAppInterface != null)
      {
        paramEditText = (CommonUsedSystemEmojiManager)paramQQAppInterface.getManager(171);
        if (paramEditText != null) {
          paramEditText.a(paramContext);
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800717F", 0, 0, this.i + "", this.j + "", "", "");
      return;
      paramContext = TextUtils.a(this.j);
      break label51;
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.i == 1) {
      localObject1 = TextUtils.a(this.j, true);
    }
    do
    {
      do
      {
        return (Drawable)localObject1;
        localObject1 = localObject2;
      } while (this.i != 2);
      localObject1 = localObject2;
    } while (this.j == -1);
    return super.b(paramContext, paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\SystemAndEmojiEmoticonInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */