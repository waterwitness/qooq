package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class AIOImageListModel
  implements AbstractImageListModel
{
  public static final Object a;
  static final String jdField_a_of_type_JavaLangString = "AIOImageListModel";
  public static final Object b;
  int jdField_a_of_type_Int;
  AIORichMediaInfo jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  public AIORichMediaInfo b;
  private String jdField_b_of_type_JavaLangString;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  List jdField_c_of_type_JavaUtilList = new ArrayList();
  int d = 0;
  int e = -1;
  int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    List localList;
    int i;
    label14:
    Object localObject;
    if (paramBoolean)
    {
      localList = this.jdField_c_of_type_JavaUtilList;
      i = 0;
      if (i >= localList.size()) {
        break label657;
      }
      localObject = localList.get(i);
      if ((!paramBoolean) || (AIORichMediaInfo.class.isInstance(localObject))) {
        break label70;
      }
    }
    label70:
    label355:
    label483:
    do
    {
      do
      {
        do
        {
          do
          {
            i += 1;
            break label14;
            localList = this.jdField_a_of_type_JavaUtilList;
            break;
            localObject = ((AIORichMediaInfo)localObject).a;
            if (!AIOImageData.class.isInstance(localObject)) {
              break label355;
            }
            localObject = (AIOImageData)localObject;
          } while ((((AIOImageData)localObject).f != paramLong) || (((AIOImageData)localObject).k != paramInt1));
          if ("I:E".equals(paramString)) {
            switch (paramInt2)
            {
            }
          }
          do
          {
            return i;
            ((AIOImageData)localObject).jdField_b_of_type_Boolean = true;
            return i;
            ((AIOImageData)localObject).jdField_c_of_type_Boolean = true;
            return i;
            ((AIOImageData)localObject).jdField_a_of_type_Boolean = true;
            return i;
            switch (paramInt2)
            {
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            default: 
              return i;
            case 1: 
              ((AIOImageData)localObject).jdField_a_of_type_JavaLangString = paramString;
              return i;
            case 2: 
              ((AIOImageData)localObject).jdField_b_of_type_JavaLangString = paramString;
            }
          } while ((((AIOImageData)localObject).g) || (!new File(((AIOImageData)localObject).jdField_a_of_type_JavaLangString + "_hd").exists()));
          ((AIOImageData)localObject).jdField_a_of_type_JavaLangString += "_hd";
          return i;
          ((AIOImageData)localObject).jdField_c_of_type_JavaLangString = paramString;
          return i;
          ((AIOImageData)localObject).d = paramString;
          return i;
          if (!AIOShortVideoData.class.isInstance(localObject)) {
            break label483;
          }
          localObject = (AIOShortVideoData)localObject;
        } while (((AIOShortVideoData)localObject).f != paramLong);
        if ("I:E".equals(paramString))
        {
          switch (paramInt2)
          {
          default: 
            return i;
          case 0: 
            ((AIOShortVideoData)localObject).jdField_a_of_type_Boolean = true;
            return i;
          }
          ((AIOShortVideoData)localObject).jdField_b_of_type_Boolean = true;
          return i;
        }
        switch (paramInt2)
        {
        default: 
          return i;
        case 0: 
          ((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString = paramString;
          return i;
        }
        ((AIOShortVideoData)localObject).jdField_b_of_type_JavaLangString = paramString;
        return i;
      } while (!AIOFilePicData.class.isInstance(localObject));
      localObject = (AIOFilePicData)localObject;
    } while (((AIOFilePicData)localObject).f != paramLong);
    if ("I:E".equals(paramString))
    {
      switch (paramInt2)
      {
      case 17: 
      case 19: 
      default: 
        return i;
      case 16: 
        ((AIOFilePicData)localObject).jdField_c_of_type_Boolean = true;
        return i;
      case 18: 
        ((AIOFilePicData)localObject).jdField_a_of_type_Boolean = true;
        return i;
      }
      ((AIOFilePicData)localObject).jdField_b_of_type_Boolean = true;
      return i;
    }
    switch (paramInt2)
    {
    case 17: 
    case 19: 
    default: 
      return i;
    case 16: 
      ((AIOFilePicData)localObject).jdField_b_of_type_JavaLangString = paramString;
      return i;
    case 18: 
      ((AIOFilePicData)localObject).jdField_c_of_type_JavaLangString = paramString;
      return i;
    }
    ((AIOFilePicData)localObject).d = paramString;
    return i;
    label657:
    return -1;
  }
  
  public AIORichMediaInfo a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  }
  
  public AIORichMediaInfo a(int paramInt)
  {
    if ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt >= 0)) {
      return (AIORichMediaInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_c_of_type_JavaUtilList.get(paramInt);
  }
  
  String a(Calendar paramCalendar, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int i = paramCalendar.get(1);
    int j = localCalendar.get(1);
    int k = localCalendar.get(2);
    if ((i == j) && (paramCalendar.get(6) - localCalendar.get(6) < 7)) {
      return "7天内";
    }
    return String.format(Locale.CHINA, "%d年%d月", new Object[] { Integer.valueOf(j), Integer.valueOf(k + 1) });
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if ((this.jdField_c_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      a(false, this.jdField_a_of_type_JavaUtilList);
      this.f = this.jdField_c_of_type_JavaUtilList.indexOf(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = a(paramInt);
    this.f = this.jdField_c_of_type_JavaUtilList.indexOf(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
  }
  
  public void a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = paramAIORichMediaInfo;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.d = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
    this.jdField_a_of_type_JavaUtilList.add(paramAIORichMediaInfo);
    a(false, this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      Collections.reverse(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1 - this.jdField_a_of_type_Int);
    }
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    if (this.d == 0) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.jdField_c_of_type_JavaUtilList.clear();
        this.e = -1;
      }
      if (this.jdField_a_of_type_JavaUtilCalendar == null)
      {
        this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
        this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(MessageCache.a() * 1000L);
      }
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)paramList.get(i);
        String str = a(this.jdField_a_of_type_JavaUtilCalendar, localAIORichMediaInfo.a.g);
        if (!str.equals(this.jdField_b_of_type_JavaLangString))
        {
          this.jdField_b_of_type_JavaLangString = str;
          if (this.e != -1)
          {
            int k = this.e % this.d;
            if (k > 0)
            {
              j = 0;
              while (j < this.d - k)
              {
                this.jdField_c_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangObject);
                j += 1;
              }
            }
          }
          this.e = 0;
          this.jdField_c_of_type_JavaUtilList.add(str);
          int j = 0;
          while (j < this.d - 1)
          {
            this.jdField_c_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangObject);
            j += 1;
          }
        }
        this.jdField_c_of_type_JavaUtilList.add(localAIORichMediaInfo);
        this.e += 1;
        i -= 1;
      }
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    int i = this.jdField_b_of_type_JavaUtilList.size();
    if (i > 0)
    {
      this.jdField_b_of_type_Int += i;
      this.jdField_c_of_type_Int += i;
      a(false, this.jdField_b_of_type_JavaUtilList);
      if (!this.jdField_b_of_type_Boolean) {
        break label86;
      }
      Collections.reverse(this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_b_of_type_JavaUtilList);
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      bool = true;
      return bool;
      label86:
      this.jdField_a_of_type_Int = (i + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilList.addAll(0, this.jdField_b_of_type_JavaUtilList);
    }
  }
  
  public boolean a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfAIORichMediaData.length - 1;
    Object localObject;
    if (j >= 0)
    {
      localObject = paramArrayOfAIORichMediaData[j];
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo == null))
      {
        localObject = new AIORichMediaInfo((AIORichMediaData)localObject);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo)localObject);
      }
    }
    int i = 0;
    if (i < paramArrayOfAIORichMediaData.length)
    {
      localObject = paramArrayOfAIORichMediaData[i];
      if (this.jdField_a_of_type_Boolean)
      {
        localArrayList.add(new AIORichMediaInfo((AIORichMediaData)localObject));
        j = -1;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.f == ((AIORichMediaData)localObject).f) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.k == ((AIORichMediaData)localObject).k))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.d = true;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo == this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo) {
            j = i;
          }
          localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
        }
        else if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.f == ((AIORichMediaData)localObject).f) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.k == ((AIORichMediaData)localObject).k))
        {
          localArrayList.add(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
          j = i;
        }
        else
        {
          localArrayList.add(new AIORichMediaInfo((AIORichMediaData)localObject));
        }
      }
    }
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < paramArrayOfAIORichMediaData.length) {}
    }
    else
    {
      i = j;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilList.addAll(0, localArrayList);
      return false;
    }
    this.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      Collections.reverse(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1 - this.jdField_a_of_type_Int);
    }
    a(true, localArrayList);
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public AIORichMediaInfo b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramAIORichMediaInfo);
    a(true, this.jdField_a_of_type_JavaUtilList);
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int e()
  {
    return this.f;
  }
  
  public void e(int paramInt)
  {
    this.f = paramInt;
    Object localObject = a(paramInt);
    if (!AIORichMediaInfo.class.isInstance(localObject)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo)localObject);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.indexOf(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
  }
  
  public int f()
  {
    return this.jdField_c_of_type_JavaUtilList.size();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\AIOImageListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */