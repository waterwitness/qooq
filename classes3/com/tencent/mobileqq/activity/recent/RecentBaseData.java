package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class RecentBaseData
{
  public static final int A = 16384;
  public static final int B = 65536;
  public static final int C = 131072;
  public static final int D = 1048576;
  public static final int E = 2097152;
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 4;
  public static final int k = 5;
  public static final int l = 15;
  public static final int m = 240;
  public static final int n = 3840;
  public static final int o = 61440;
  public static final int p = 983040;
  public static final int q = 3145728;
  public static final int r = 0;
  public static final int s = 1;
  public static final int t = 16;
  public static final int u = 32;
  public static final int v = 48;
  public static final int w = 256;
  public static final int x = 4096;
  public static final int y = 8192;
  public static final int z = 12288;
  public int F;
  public int G;
  public int H;
  public int I;
  public int J;
  public int K;
  public int L;
  public int M;
  public int N;
  public int O;
  protected MsgSummary a;
  public CharSequence a;
  public boolean a;
  public volatile long b;
  public CharSequence b;
  public String b;
  public boolean b;
  public CharSequence c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public RecentBaseData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.G = 1;
    this.K = 0;
    this.K |= 0x1;
  }
  
  public abstract int a();
  
  public abstract long a();
  
  public final MsgSummary a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary = new MsgSummary();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary.a();
    }
  }
  
  public abstract String a();
  
  public void a()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(1024);
      String str2 = "null";
      String str1 = "null";
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        str1 = "lenth=" + this.jdField_b_of_type_JavaLangString.length();
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {
        str2 = "lenth=" + this.jdField_b_of_type_JavaLangCharSequence.length();
      }
      localStringBuilder.append("[").append("type:").append(a()).append(", uin:").append(a()).append(", unreadNum:").append(this.H).append(", titleName:").append(str1).append(", mMenuFlag:").append(this.K).append(", status:").append(this.F).append(", authenIcon:").append(this.I).append(", showTime:").append(this.c).append(", lastmsg:").append(str2).append(", extrainfo:").append(this.jdField_a_of_type_JavaLangCharSequence).append(", lastmsgtime:").append(a()).append(", lastdrafttime:").append(b()).append("]");
      QLog.i("Q.recent", 4, localStringBuilder.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.F = 0;
    int i3 = a();
    long l1;
    int i4;
    Object localObject;
    if ((i3 == 3000) || (i3 == 1)) {
      try
      {
        l1 = Long.parseLong(a());
        i4 = UITools.a(i3);
        if (paramQQAppInterface.a().a(i4, l1) > 0L) {
          if (paramQQAppInterface.a().a(i4, l1))
          {
            this.F = 2;
            if ((i3 == 0) && (paramQQAppInterface.a().d(a()))) {
              this.F = 5;
            }
            if (this.F == 0)
            {
              paramQQAppInterface = paramQQAppInterface.a();
              if ((paramQQAppInterface == null) || (!paramQQAppInterface.d(a(), i3))) {
                break label352;
              }
              this.F = 4;
            }
            return;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          l1 = 0L;
          continue;
          this.F = 3;
          continue;
          if (!paramQQAppInterface.a().a(i4, a())) {
            break;
          }
          this.F = 3;
        }
        localObject = paramQQAppInterface.a().a(l1, 2);
        if (localObject == null) {}
      }
    }
    for (int i1 = ((AVNotifyCenter.VideoRoomInfo)localObject).a + 0;; i1 = 0)
    {
      localObject = paramQQAppInterface.a().a(l1, 10);
      int i2 = i1;
      if (localObject != null) {
        i2 = i1 + ((AVNotifyCenter.VideoRoomInfo)localObject).a;
      }
      if (i2 <= 0) {
        break;
      }
      if (paramQQAppInterface.a().a(i4, l1))
      {
        this.F = 2;
        break;
      }
      this.F = 3;
      break;
      if ((!paramQQAppInterface.d()) || ((paramQQAppInterface.a().g() != 1) && (paramQQAppInterface.a().g() != 2))) {
        break;
      }
      i1 = paramQQAppInterface.a().h();
      localObject = paramQQAppInterface.a().f();
      String str = paramQQAppInterface.a().g();
      if ((i3 != i1) || ((!a().equals(localObject)) && (!a().equals(str)))) {
        break;
      }
      this.F = 1;
      break;
      label352:
      this.F = 0;
      return;
    }
  }
  
  public abstract void a(QQAppInterface paramQQAppInterface, Context paramContext);
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = a();
    }
    if (paramMsgSummary != null)
    {
      this.jdField_b_of_type_JavaLangCharSequence = paramMsgSummary.a(paramContext);
      if (((this.jdField_b_of_type_JavaLangCharSequence instanceof SpannableStringBuilder)) && (DeviceInfoUtil.b())) {
        this.jdField_b_of_type_JavaLangCharSequence = ((SpannableStringBuilder)this.jdField_b_of_type_JavaLangCharSequence).append(" ");
      }
      paramQQAppInterface = this.jdField_b_of_type_JavaLangCharSequence;
      if ((paramQQAppInterface == null) || (paramQQAppInterface.length() <= 168)) {}
    }
    try
    {
      this.jdField_b_of_type_JavaLangCharSequence = paramQQAppInterface.subSequence(0, 168);
      if ((this.jdField_b_of_type_Long > 0L) && (this.jdField_b_of_type_Long != 9223372036854775806L)) {
        this.c = TimeManager.a().a(a(), this.jdField_b_of_type_Long);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          paramQQAppInterface.printStackTrace();
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramMsgSummary.a = false;
          paramMsgSummary.d = null;
        } while (this.jdField_b_of_type_Long > b());
        paramQQAppInterface = paramQQAppInterface.a();
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a(a(), a());
    } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.jdField_b_of_type_Long = paramQQAppInterface.getTime();
    paramMsgSummary.a = true;
    paramMsgSummary.d = new QQText(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (paramMessage != null) {}
    for (String str = paramMessage.nickName;; str = null)
    {
      MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, paramInt, paramMsgSummary, str, false, false);
      return;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public final int b()
  {
    return this.H;
  }
  
  public abstract long b();
  
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final void b()
  {
    this.H = 0;
  }
  
  public long c()
  {
    return 5L;
  }
  
  public final void c()
  {
    this.H = 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (boolean bool = true; (!bool) && ((paramObject instanceof RecentBaseData)); bool = false)
    {
      paramObject = (RecentBaseData)paramObject;
      if ((((RecentBaseData)paramObject).a() != a()) || (!Utils.a(((RecentBaseData)paramObject).a(), a()))) {
        break;
      }
      return true;
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentBaseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */