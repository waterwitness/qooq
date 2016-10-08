package com.tencent.mobileqq.ptt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class PttVoiceChangePreSender
{
  public static final float a = 0.55F;
  public static final int a = 5;
  public static final float b = 0.9F;
  public static final int b = ListenChangeVoicePanel.a.length;
  public int[] a = new int[b];
  public float c;
  int c;
  float jdField_d_of_type_Float = 0.05F;
  int jdField_d_of_type_Int = -1;
  int e = -1;
  int f = -1;
  public int g;
  public int h;
  int i = 0;
  int j = 0;
  private int k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PttVoiceChangePreSender()
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_c_of_type_Float = 0.75F;
    Object localObject = BaseApplicationImpl.a().a().getPreferences();
    try
    {
      localObject = ((SharedPreferences)localObject).getString("PttVoiceChangePreSender", "[]");
      JSONArray localJSONArray = new JSONArray((String)localObject);
      if (localJSONArray.length() == b + 2)
      {
        int m = 0;
        while (m < b)
        {
          this.a[m] = localJSONArray.getInt(m);
          m += 1;
        }
        this.g = localJSONArray.getInt(b);
        this.h = localJSONArray.getInt(b + 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d(PttInfoCollector.a, 2, "get send record " + (String)localObject);
      }
      return;
    }
    catch (Exception localException)
    {
      this.a = new int[b];
      this.g = 0;
      this.h = 0;
      localException.printStackTrace();
    }
  }
  
  private float a(int paramInt)
  {
    return this.a[paramInt] / this.g;
  }
  
  private void a()
  {
    Object localObject1 = new JSONArray();
    Object localObject2 = this.a;
    int n = localObject2.length;
    int m = 0;
    while (m < n)
    {
      ((JSONArray)localObject1).put(localObject2[m]);
      m += 1;
    }
    ((JSONArray)localObject1).put(this.g);
    ((JSONArray)localObject1).put(this.h);
    localObject2 = BaseApplicationImpl.a().a().getPreferences().edit();
    localObject1 = ((JSONArray)localObject1).toString();
    ((SharedPreferences.Editor)localObject2).putString("PttVoiceChangePreSender", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).commit();
    if (QLog.isColorLevel()) {
      QLog.d(PttInfoCollector.a, 2, "save send record " + (String)localObject1);
    }
  }
  
  private int c()
  {
    int m = 0;
    int i2 = 0;
    int i1;
    for (int n = 0; m < b; n = i1)
    {
      i1 = n;
      if (n < this.a[m])
      {
        i1 = this.a[m];
        i2 = m;
      }
      m += 1;
    }
    return i2;
  }
  
  public int a()
  {
    if (this.g < 5)
    {
      this.e = -1;
      return -1;
    }
    if ((this.jdField_c_of_type_Int >= 2) && (this.jdField_d_of_type_Int >= 0))
    {
      this.e = this.jdField_d_of_type_Int;
      this.i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PttInfoCollector.a, 2, "pre-send type " + this.e);
      }
      return this.e;
      int m = c();
      if (a(m) >= this.jdField_c_of_type_Float)
      {
        this.e = m;
        this.i = 2;
      }
      else if ((this.jdField_d_of_type_Int >= 0) && (this.h / this.g > 0.8D))
      {
        this.e = this.jdField_d_of_type_Int;
        this.i = 3;
      }
      else
      {
        this.e = -1;
        this.i = -1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a();
    if (this.e != -1)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800608D", "0X800608D", this.i + 10, 0, this.e + "", paramInt + "", "", "6.5.5");
      if (this.i == 2)
      {
        if (this.e != paramInt) {
          break label235;
        }
        this.jdField_c_of_type_Float -= this.jdField_c_of_type_Float * this.jdField_d_of_type_Float;
        if (this.jdField_c_of_type_Float >= 0.55F) {
          break label258;
        }
        f1 = 0.55F;
        label127:
        this.jdField_c_of_type_Float = f1;
        if (this.jdField_c_of_type_Float <= 0.9F) {
          break label266;
        }
      }
    }
    label235:
    label258:
    label266:
    for (float f1 = 0.9F;; f1 = this.jdField_c_of_type_Float)
    {
      this.jdField_c_of_type_Float = f1;
      b();
      if (this.f != -1) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800608D", "0X800608D", this.j + 20, 0, this.f + "", paramInt + "", "", "6.5.5");
      }
      if (paramInt >= 0) {
        break label274;
      }
      return;
      this.jdField_c_of_type_Float += (1.0F - this.jdField_c_of_type_Float) * this.jdField_d_of_type_Float;
      break;
      f1 = this.jdField_c_of_type_Float;
      break label127;
    }
    label274:
    if (paramInt == this.jdField_d_of_type_Int)
    {
      this.jdField_c_of_type_Int += 1;
      this.h += 1;
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = paramInt;
      paramQQAppInterface = this.a;
      paramQQAppInterface[paramInt] += 1;
      this.g += 1;
      this.k += 1;
      if (this.k % 5 == 0) {
        a();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(PttInfoCollector.a, 2, "real send type " + paramInt);
      return;
      this.jdField_c_of_type_Int = 1;
    }
  }
  
  public int b()
  {
    if ((this.jdField_d_of_type_Int == -1) || (this.g < 5))
    {
      this.f = -1;
      return -1;
    }
    if (this.jdField_c_of_type_Int >= 2)
    {
      this.f = this.jdField_d_of_type_Int;
      this.j = 1;
    }
    for (;;)
    {
      return this.f;
      int m = c();
      if (this.jdField_d_of_type_Int == m)
      {
        this.f = this.jdField_d_of_type_Int;
        this.j = 2;
      }
      else if (this.h / this.g > 0.85D)
      {
        this.f = this.jdField_d_of_type_Int;
        this.j = 3;
      }
      else
      {
        this.f = -1;
        this.j = -1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\PttVoiceChangePreSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */