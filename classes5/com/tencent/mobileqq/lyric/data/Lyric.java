package com.tencent.mobileqq.lyric.data;

import android.graphics.Paint;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lyric
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "Lyric";
  public static final int b = 2;
  public static final int c = 3;
  private Sentence jdField_a_of_type_ComTencentMobileqqLyricDataSentence;
  public ArrayList a;
  public ArrayList b;
  public int d;
  @Deprecated
  public int e;
  private int f;
  private int g;
  
  public Lyric(int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = new ArrayList();
    this.d = paramInt1;
    this.e = paramInt2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    return b(paramInt);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (a()) {}
    do
    {
      return 0;
      paramInt1 = b(paramInt1);
      paramInt2 = e(paramInt2);
    } while ((paramInt1 < 0) || (paramInt2 < paramInt1));
    return paramInt2 - paramInt1 + 1;
  }
  
  public Sentence a(int paramInt)
  {
    if (a()) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt) {
      return null;
    }
    return (Sentence)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public String a(int paramInt)
  {
    if (a()) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt) {
      return null;
    }
    return ((Sentence)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
  }
  
  public String a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (paramLong < 0L)) {
      return null;
    }
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      Sentence localSentence = (Sentence)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((paramLong >= localSentence.jdField_a_of_type_Long) && (paramLong <= localSentence.jdField_a_of_type_Long + localSentence.b)) {
        return localSentence.jdField_a_of_type_JavaLangString;
      }
      i += 1;
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.f = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt)
  {
    a(paramPaint1, paramPaint2, paramInt, false, false);
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean)
  {
    a(paramPaint1, paramPaint2, paramInt, paramBoolean, false);
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b.clear();
    this.f = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Sentence localSentence = (Sentence)localIterator.next();
        localSentence.a(paramPaint1, paramPaint2, paramInt, paramBoolean1, paramBoolean2);
        this.f += localSentence.a();
        this.b.addAll(localSentence.jdField_a_of_type_JavaUtilArrayList);
      }
    }
  }
  
  public void a(Lyric paramLyric)
  {
    this.d = paramLyric.d;
    this.e = paramLyric.e;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = paramLyric.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Sentence localSentence = (Sentence)localIterator.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(localSentence.a());
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.f = paramLyric.b();
    Log.d("Lyric", "copy -> mType : " + this.d);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0);
  }
  
  public int[] a()
  {
    if (a()) {
      return null;
    }
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int[] arrayOfInt = new int[j * 2];
    int i = 0;
    if (i < j)
    {
      Sentence localSentence = (Sentence)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localSentence != null)
      {
        arrayOfInt[(i * 2)] = ((int)localSentence.jdField_a_of_type_Long);
        arrayOfInt[(i * 2 + 1)] = ((int)(localSentence.jdField_a_of_type_Long + localSentence.b));
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfInt[(i * 2)] = 0;
        arrayOfInt[(i * 2 + 1)] = 0;
      }
    }
    return arrayOfInt;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public int b(int paramInt)
  {
    if (paramInt < 0)
    {
      Log.w("Lyric", "findLineNoByStartTime -> illegal time");
      return -1;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      Log.w("Lyric", "findLineNoByStartTime -> lyric is empty");
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence != null) && (this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence.jdField_a_of_type_Long < paramInt) && (this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence.jdField_a_of_type_Long + this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence.b > paramInt)) {
      return this.g;
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int k = localArrayList.size();
    int j = 0;
    if (j < k)
    {
      Sentence localSentence = (Sentence)localArrayList.get(j);
      if (localSentence == null) {}
      while (localSentence.jdField_a_of_type_Long <= paramInt)
      {
        j += 1;
        break;
      }
    }
    for (paramInt = j - 1;; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j == k) {}
      for (paramInt = k - 1;; paramInt = i)
      {
        this.g = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence = ((Sentence)localArrayList.get(paramInt));
        return paramInt;
      }
    }
  }
  
  public int c()
  {
    if (a()) {
      return 0;
    }
    Sentence localSentence = (Sentence)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    return (int)(localSentence.jdField_a_of_type_Long + localSentence.b);
  }
  
  public int c(int paramInt)
  {
    int i;
    if ((paramInt < 0) || (a()))
    {
      Log.w("Lyric", "floorLineNoByEndTime -> illegal time");
      i = 0;
      return i;
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int k = localArrayList.size();
    int j = 0;
    if (j < k)
    {
      Sentence localSentence = (Sentence)localArrayList.get(j);
      if (localSentence == null) {}
      while (localSentence.jdField_a_of_type_Long + localSentence.b <= paramInt)
      {
        j += 1;
        break;
      }
    }
    for (paramInt = j - 1;; paramInt = 0)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j != k) {
        break;
      }
      return k - 1;
    }
  }
  
  public int d()
  {
    if (a()) {
      return 0;
    }
    return (int)((Sentence)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long;
  }
  
  public int d(int paramInt)
  {
    int j;
    if (paramInt < 0)
    {
      Log.w("Lyric", "findLineNoByEndTime -> illegal time");
      j = 0;
      return j;
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null)
    {
      Log.w("Lyric", "findLineNoByEndTime -> sentence data not found");
      return -1;
    }
    int k = localArrayList.size();
    int i = 0;
    if (i < k)
    {
      Sentence localSentence = (Sentence)localArrayList.get(i);
      if (localSentence == null) {}
      while (localSentence.jdField_a_of_type_Long + localSentence.b < paramInt)
      {
        i += 1;
        break;
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      j = paramInt;
      if (paramInt < 0) {
        j = 0;
      }
      if (i != k) {
        break;
      }
      return k - 1;
    }
  }
  
  public int e(int paramInt)
  {
    int i;
    if (paramInt < 0)
    {
      Log.w("Lyric", "findEndLineByStartTime -> illegal time");
      i = 0;
      return i;
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null)
    {
      Log.w("Lyric", "findEndLineByStartTime -> sentence data not found");
      return -1;
    }
    int k = localArrayList.size();
    int j = 0;
    if (j < k)
    {
      Sentence localSentence = (Sentence)localArrayList.get(j);
      if (localSentence == null) {}
      while (paramInt > localSentence.jdField_a_of_type_Long)
      {
        j += 1;
        break;
      }
    }
    for (paramInt = j - 1;; paramInt = 0)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j != k) {
        break;
      }
      return k - 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Sentence localSentence = (Sentence)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(localSentence.jdField_a_of_type_Long);
      localStringBuilder.append(":");
      localStringBuilder.append(localSentence.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(":");
      localStringBuilder.append(localSentence.b + localSentence.jdField_a_of_type_Long);
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\data\Lyric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */