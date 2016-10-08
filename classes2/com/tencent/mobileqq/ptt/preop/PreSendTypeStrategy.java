package com.tencent.mobileqq.ptt.preop;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

public class PreSendTypeStrategy
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
  public int f;
  public int g;
  int h = 0;
  private int i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PreSendTypeStrategy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_c_of_type_Float = 0.75F;
    paramQQAppInterface = BaseApplicationImpl.a.getSharedPreferences("PttPreSendSp_" + paramQQAppInterface.a(), 0);
    try
    {
      paramQQAppInterface = paramQQAppInterface.getString("PttVoiceChangePreSender", "[]");
      JSONArray localJSONArray = new JSONArray(paramQQAppInterface);
      if (localJSONArray.length() == b + 2)
      {
        int j = 0;
        while (j < b)
        {
          this.a[j] = localJSONArray.getInt(j);
          j += 1;
        }
        this.f = localJSONArray.getInt(b);
        this.g = localJSONArray.getInt(b + 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d(PttPreSendManager.a, 2, "init : get send record " + paramQQAppInterface);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      this.a = new int[b];
      this.f = 0;
      this.g = 0;
      paramQQAppInterface.printStackTrace();
    }
  }
  
  private float a(int paramInt)
  {
    return this.a[paramInt] / this.f;
  }
  
  private String a()
  {
    JSONArray localJSONArray = new JSONArray();
    int[] arrayOfInt = this.a;
    int k = arrayOfInt.length;
    int j = 0;
    while (j < k)
    {
      localJSONArray.put(arrayOfInt[j]);
      j += 1;
    }
    localJSONArray.put(this.f);
    localJSONArray.put(this.g);
    return localJSONArray.toString();
  }
  
  private int b()
  {
    int j = 0;
    int n = 0;
    int m;
    for (int k = 0; j < b; k = m)
    {
      m = k;
      if (k < this.a[j])
      {
        m = this.a[j];
        n = j;
      }
      j += 1;
    }
    return n;
  }
  
  public int a()
  {
    if ((this.f < 5) || (this.jdField_d_of_type_Int < 0))
    {
      this.e = -1;
      return -1;
    }
    if (this.jdField_c_of_type_Int >= 2)
    {
      this.e = this.jdField_d_of_type_Int;
      this.h = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PttPreSendManager.a, 2, "guess type, result : " + this.e + " case : " + this.h + ", datas : " + a());
      }
      return this.e;
      int j = b();
      if (a(j) >= this.jdField_c_of_type_Float)
      {
        this.e = j;
        this.h = 2;
      }
      else if ((this.jdField_d_of_type_Int >= 0) && (this.g / this.f > 0.8D))
      {
        this.e = this.jdField_d_of_type_Int;
        this.h = 3;
      }
      else
      {
        this.e = -1;
        this.h = -1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    String str = a();
    paramQQAppInterface = BaseApplicationImpl.a.getSharedPreferences("PttPreSendSp_" + paramQQAppInterface.a(), 0).edit();
    paramQQAppInterface.putString("PttVoiceChangePreSender", str);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.d(PttInfoCollector.a, 2, "save send record " + str);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    float f1 = 0.55F;
    if ((this.e != -1) && (this.h == 2))
    {
      if (this.e != paramInt) {
        break label88;
      }
      this.jdField_c_of_type_Float -= this.jdField_c_of_type_Float * this.jdField_d_of_type_Float;
      if (this.jdField_c_of_type_Float >= 0.55F) {
        break label111;
      }
      label55:
      this.jdField_c_of_type_Float = f1;
      if (this.jdField_c_of_type_Float <= 0.9F) {
        break label119;
      }
    }
    label88:
    label111:
    label119:
    for (f1 = 0.9F;; f1 = this.jdField_c_of_type_Float)
    {
      this.jdField_c_of_type_Float = f1;
      if (paramInt >= 0) {
        break label127;
      }
      this.jdField_d_of_type_Int = paramInt;
      return;
      this.jdField_c_of_type_Float += (1.0F - this.jdField_c_of_type_Float) * this.jdField_d_of_type_Float;
      break;
      f1 = this.jdField_c_of_type_Float;
      break label55;
    }
    label127:
    if (paramInt == this.jdField_d_of_type_Int)
    {
      this.jdField_c_of_type_Int += 1;
      this.g += 1;
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = paramInt;
      int[] arrayOfInt = this.a;
      arrayOfInt[paramInt] += 1;
      this.f += 1;
      this.i += 1;
      if (this.i % 5 == 0) {
        a(paramQQAppInterface);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(PttInfoCollector.a, 2, "real send type " + paramInt);
      return;
      this.jdField_c_of_type_Int = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\preop\PreSendTypeStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */