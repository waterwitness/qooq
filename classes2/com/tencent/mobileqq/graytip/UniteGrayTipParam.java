package com.tencent.mobileqq.graytip;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class UniteGrayTipParam
{
  public static final int a = 10;
  public static final int[] a;
  public static final int b = 1;
  public static final int c = 131073;
  public static final int d = 1310721;
  public static final int e = 1310722;
  public static final int f = 1376257;
  public static final int g = 2097153;
  public long a;
  public String a;
  public ArrayList a;
  protected boolean a;
  public String b;
  protected boolean b;
  public int[] b;
  public String c;
  protected boolean c;
  public String d;
  public boolean d = true;
  public boolean e;
  public boolean f = true;
  public int h;
  public int i;
  public int j;
  public int k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 131073, 1310721, 1310722, 1376257, 2097153 };
  }
  
  public UniteGrayTipParam(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.h = paramInt1;
    this.j = paramInt2;
    this.i = paramInt3;
    this.jdField_a_of_type_Long = paramLong;
    a();
  }
  
  private void a()
  {
    if (this.j == 60516)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    if (this.j == 60515)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (this.j == 60514)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.j = 60496;
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 >= paramInt2) {
      return;
    }
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject1 = null;
    int i1 = 0;
    String str = null;
    int n;
    label31:
    Object localObject4;
    int m;
    Object localObject2;
    Object localObject3;
    label100:
    long l;
    if (paramBundle == null)
    {
      n = -1;
      localObject4 = localObject7;
      m = i1;
      localObject2 = localObject5;
      localObject3 = localObject6;
      switch (n)
      {
      default: 
        localObject3 = localObject6;
        localObject2 = localObject5;
        m = i1;
        localObject4 = localObject7;
      case 4: 
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        l = 0L;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break;
        }
      }
    }
    for (;;)
    {
      try
      {
        l = Long.parseLong((String)localObject4);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label294;
        }
        paramBundle = "#FF00a5e0";
        i1 = Color.parseColor(paramBundle);
        this.jdField_a_of_type_JavaUtilArrayList.add(new MessageForGrayTips.HightlightItem(paramInt1, paramInt2, l, m, n, (String)localObject2, (String)localObject3, str, null, i1));
        return;
      }
      catch (NumberFormatException paramBundle) {}
      n = paramBundle.getInt("key_action");
      localObject1 = paramBundle.getString("textColor");
      str = paramBundle.getString("image_resource");
      break label31;
      localObject4 = paramBundle.getString("troop_mem_uin");
      if (paramBundle.getBoolean("need_update_nick"))
      {
        m = 1;
        localObject2 = localObject5;
        localObject3 = localObject6;
        break label100;
      }
      m = 0;
      continue;
      localObject2 = paramBundle.getString("key_action_DATA");
      localObject3 = paramBundle.getString("key_a_action_DATA");
      localObject4 = localObject7;
      m = i1;
      break label100;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(UniteGrayTipUtil.jdField_a_of_type_JavaLangString, 2, "getHightlightMsgText ==>NumberFormatException");
      return;
      label294:
      paramBundle = (Bundle)localObject1;
    }
  }
  
  public boolean a()
  {
    boolean bool = MsgProxyUtils.i(this.j);
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int i1 = arrayOfInt.length;
    int m = 0;
    int n = 0;
    while (m < i1)
    {
      if (arrayOfInt[m] == this.i) {
        n = 1;
      }
      m += 1;
    }
    return (bool) && (n != 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\graytip\UniteGrayTipParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */