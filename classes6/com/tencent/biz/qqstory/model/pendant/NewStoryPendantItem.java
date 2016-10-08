package com.tencent.biz.qqstory.model.pendant;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class NewStoryPendantItem
{
  public static final NewStoryPendantItem a;
  public static final NewStoryPendantItem b;
  private float jdField_a_of_type_Float;
  public final int a;
  public final String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  private String g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem = new NewStoryPendantItem("_NONE_", "NONE", null, null, null, 0, "forbidden");
    jdField_b_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem = new NewStoryPendantItem("_EMPTY_", "EMPTY", null, null, null, 0, "empty");
  }
  
  private NewStoryPendantItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.jdField_a_of_type_Int = paramInt;
    this.f = paramString6;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return this.g;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (NewStoryPendantItem.OnDownloadStateListener localOnDownloadStateListener = (NewStoryPendantItem.OnDownloadStateListener)this.jdField_a_of_type_JavaLangRefWeakReference.get(); localOnDownloadStateListener != null; localOnDownloadStateListener = null)
    {
      localOnDownloadStateListener.a(this);
      return;
    }
    SLog.a("NewStoryPendantItem", "notifyDownloadStateChanged : " + this.jdField_a_of_type_JavaLangRefWeakReference);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(NewStoryPendantItem.OnDownloadStateListener paramOnDownloadStateListener)
  {
    if (paramOnDownloadStateListener == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnDownloadStateListener);
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool3;
            } while (paramObject == null);
            bool1 = bool3;
          } while (getClass() != paramObject.getClass());
          paramObject = (NewStoryPendantItem)paramObject;
          bool1 = bool3;
        } while (this.jdField_a_of_type_Boolean != ((NewStoryPendantItem)paramObject).jdField_a_of_type_Boolean);
        bool1 = bool3;
      } while (Float.compare(((NewStoryPendantItem)paramObject).jdField_a_of_type_Float, this.jdField_a_of_type_Float) != 0);
      if (this.jdField_a_of_type_JavaLangString == null) {
        break;
      }
      bool1 = bool3;
    } while (!this.jdField_a_of_type_JavaLangString.equals(((NewStoryPendantItem)paramObject).jdField_a_of_type_JavaLangString));
    if (this.g != null)
    {
      bool1 = bool2;
      if (this.g.equals(((NewStoryPendantItem)paramObject).g)) {}
    }
    label118:
    for (boolean bool1 = false;; bool1 = bool2)
    {
      return bool1;
      if (((NewStoryPendantItem)paramObject).jdField_a_of_type_JavaLangString == null) {
        break;
      }
      return false;
      if (((NewStoryPendantItem)paramObject).g != null) {
        break label118;
      }
    }
  }
  
  public int hashCode()
  {
    int m = 0;
    int i;
    int j;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      i = this.jdField_a_of_type_JavaLangString.hashCode();
      if (!this.jdField_a_of_type_Boolean) {
        break label83;
      }
      j = 1;
      label27:
      if (this.jdField_a_of_type_Float == 0.0F) {
        break label88;
      }
    }
    label83:
    label88:
    for (int k = Float.floatToIntBits(this.jdField_a_of_type_Float);; k = 0)
    {
      if (this.g != null) {
        m = this.g.hashCode();
      }
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label27;
    }
  }
  
  public String toString()
  {
    return "NewStoryPendantItem{id='" + this.jdField_a_of_type_JavaLangString + '\'' + ", name='" + this.jdField_b_of_type_JavaLangString + '\'' + ", iconUrl='" + this.c + '\'' + ", zipUrl='" + this.d + '\'' + ", zipMd5='" + this.e + '\'' + ", version=" + this.jdField_a_of_type_Int + ", downloading=" + this.jdField_a_of_type_Boolean + ", downloadProgress=" + this.jdField_a_of_type_Float + ", downloadedFolderPath='" + this.g + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\NewStoryPendantItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */