package com.tencent.mobileqq.app.automator;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TimerChecker
  extends LinearGroup
{
  private static final String d = "LAST_UPDATE_TIME_PRE_";
  
  public TimerChecker()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    Object localObject = StepFactory.jdField_a_of_type_ArrayOfInt;
    StringBuilder localStringBuilder = new StringBuilder("{");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if ((Math.abs(l - this.a.a.getLong("LAST_UPDATE_TIME_PRE_" + localObject[i], 0L)) >= localObject[i] * 60 * 60 * 1000) && (StepFactory.jdField_a_of_type_ArrayOfJavaLangString[i].length() > 2))
      {
        localStringBuilder.append(StepFactory.jdField_a_of_type_ArrayOfJavaLangString[i]).append(',');
        this.a.a.edit().putLong("LAST_UPDATE_TIME_PRE_" + localObject[i], l).commit();
      }
      i += 1;
    }
    localObject = localStringBuilder.toString();
    this.c = (((String)localObject).substring(0, ((String)localObject).length() - 1) + "}");
    super.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\TimerChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */