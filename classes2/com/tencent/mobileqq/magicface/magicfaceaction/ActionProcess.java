package com.tencent.mobileqq.magicface.magicfaceaction;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionProcess
{
  public static final String a = "stop";
  public static final String b = "record";
  public static final String c = "end";
  public int a;
  public List a;
  public int b;
  public String d;
  public String e;
  public String f;
  
  public ActionProcess()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = -1;
    this.a = new ArrayList();
  }
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      RecordCondition localRecordCondition = (RecordCondition)localIterator.next();
      if ((localRecordCondition.a <= paramInt) && (localRecordCondition.b > paramInt)) {
        return localRecordCondition.c;
      }
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\magicfaceaction\ActionProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */