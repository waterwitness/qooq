package com.tencent.common.app;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import jkm;
import jko;

public class ThreadTracker
{
  private static final int jdField_a_of_type_Int = 20000;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  public static Vector a;
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilVector = new Vector(400);
  }
  
  public static Iterable a(Iterable paramIterable, boolean paramBoolean)
  {
    return new jkm(paramIterable, paramBoolean);
  }
  
  public static void a(String paramString)
  {
    try
    {
      Log.d("ThreadTracker", "start Thread tracking");
      jdField_a_of_type_Long = SystemClock.uptimeMillis();
      jdField_a_of_type_Boolean = true;
      jdField_a_of_type_JavaLangString = paramString;
      paramString = Thread.currentThread().getThreadGroup();
      Object localObject1 = paramString.getClass().getDeclaredField("threadRefs");
      ((Field)localObject1).setAccessible(true);
      Object localObject2 = new ThreadTracker.1((List)((Field)localObject1).get(paramString));
      ((Field)localObject1).set(paramString, localObject2);
      localObject1 = a((Iterable)localObject2, true);
      localObject2 = paramString.getClass().getDeclaredField("threads");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(paramString, localObject1);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static jko b(long paramLong, List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      jko localjko = (jko)paramList.next();
      if (jko.a(localjko) == paramLong) {
        return localjko;
      }
    }
    return null;
  }
  
  public static void b(String paramString)
  {
    PrintStream localPrintStream;
    ArrayList localArrayList;
    Object localObject2;
    int j;
    try
    {
      localObject1 = new File(paramString);
      Log.d("ThreadTracker", "outputing " + paramString);
      localPrintStream = new PrintStream(new BufferedOutputStream(new FileOutputStream((File)localObject1, false)));
      localArrayList = new ArrayList(jdField_a_of_type_JavaUtilVector);
      localObject1 = Thread.currentThread().getThreadGroup();
      for (paramString = (String)localObject1; paramString != null; paramString = (String)localObject2)
      {
        localObject2 = paramString.getParent();
        localObject1 = paramString;
      }
      localObject2 = new Thread[((ThreadGroup)localObject1).activeCount() * 2];
      i = ((ThreadGroup)localObject1).enumerate((Thread[])localObject2);
      paramString = new Thread[i];
      System.arraycopy(localObject2, 0, paramString, 0, i);
      j = paramString.length;
      i = 0;
      if (i < j)
      {
        localObject1 = paramString[i];
        localObject2 = b(((Thread)localObject1).getId(), localArrayList);
        if (localObject2 != null) {
          jko.a((jko)localObject2, ((Thread)localObject1).getName());
        } else {
          localArrayList.add(new jko(((Thread)localObject1).getId(), ((Thread)localObject1).getName(), 0L, null));
        }
      }
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    localPrintStream.println("Threads:");
    Object localObject1 = localArrayList.iterator();
    int i = 0;
    label219:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (jko)((Iterator)localObject1).next();
      if (!jko.a((jko)localObject2).startsWith("SharedPreferencesImpl"))
      {
        localPrintStream.println(i + "," + ((jko)localObject2).toString());
        i += 1;
        break label561;
      }
    }
    else
    {
      localPrintStream.println("Stacks:");
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (jko)((Iterator)localObject1).next();
        if ((jko.a((jko)localObject2) != null) && (!jko.a((jko)localObject2).startsWith("SharedPreferencesImpl")))
        {
          localPrintStream.println("id:" + jko.a((jko)localObject2));
          localPrintStream.println("name:" + jko.a((jko)localObject2));
          jko.a((jko)localObject2).printStackTrace(localPrintStream);
          localPrintStream.println();
        }
      }
      localPrintStream.println("Running Threads.");
      localPrintStream.println();
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject1 = b(paramString[i].getId(), localArrayList);
        if (localObject1 != null)
        {
          localPrintStream.println("id:" + jko.a((jko)localObject1));
          localPrintStream.println("name:" + jko.a((jko)localObject1));
          if (jko.a((jko)localObject1) != null) {
            jko.a((jko)localObject1).printStackTrace(localPrintStream);
          }
          for (;;)
          {
            localPrintStream.println();
            break;
            localPrintStream.println("No Stack..");
          }
        }
      }
      else
      {
        localPrintStream.flush();
        localPrintStream.close();
        Log.d("ThreadTracker", "outputing done.");
        return;
        break label561;
        i += 1;
        break;
        label561:
        break label219;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\app\ThreadTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */